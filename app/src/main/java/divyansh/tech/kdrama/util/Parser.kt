package divyansh.tech.kdrama.util

import android.util.Log
import divyansh.tech.kdrama.home.datamodels.MetaDrama
import org.jsoup.Jsoup
import java.lang.Exception

object Parser {

    /*
    * Parse the home page to fetch the recent drama
    * @param response: String
    * @return ResultWrapper<*>
    * */
    fun parseRecentDrama(response: String): ResultWrapper<*>{
        return try {
            val list = mutableListOf<MetaDrama>()
            val jsoup = Jsoup.parse(response)
            val recentDramas = jsoup?.getElementById("drama")?.select("ul")?.first()?.select("li")
            recentDramas?.forEach {
                Log.i("RECENT", it.toString())
            }
            ResultWrapper.Success(list)
        } catch (e: Exception) {
            ResultWrapper.Error(message = e.localizedMessage, data = null)
        }
    }
}