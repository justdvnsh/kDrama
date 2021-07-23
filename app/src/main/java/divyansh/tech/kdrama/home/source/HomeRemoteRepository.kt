package divyansh.tech.kdrama.home.source

import divyansh.tech.kdrama.util.Parser.parseRecentDrama
import divyansh.tech.kdrama.util.ResultWrapper
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Inject

class HomeRemoteRepository @Inject constructor(
    retrofit: Retrofit
) {

    private val service = retrofit.create(FetchShows::class.java)

    suspend fun fetchRecentDrama(): ResultWrapper<*> {
        val response = service.fetchRecentDrama()
        return parseRecentDrama(response.string())
    }

    interface FetchShows {
        @GET("/")
        @Headers("Referer: https://kissasian.la/?__cf_chl_jschl_tk__=pmd_c90d626ca458bb18c4c42efdb1f75f707d505156-1627049845-0-gqNtZGzNAo2jcnBszRdi",
        "sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"", "sec-ch-ua-mobile: ?0",
        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36")
        suspend fun fetchRecentDrama(): ResponseBody
    }
}