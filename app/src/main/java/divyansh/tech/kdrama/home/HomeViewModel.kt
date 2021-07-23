package divyansh.tech.kdrama.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.kdrama.common.CommonViewModel
import divyansh.tech.kdrama.home.datamodels.HomeCustomResponseModel
import divyansh.tech.kdrama.home.source.HomeDefaultDataSource
import divyansh.tech.kdrama.util.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: HomeDefaultDataSource
): CommonViewModel() {

    private val _homeCustomResponseLiveData = MutableLiveData<HomeCustomResponseModel>()
    val homeCustomResponseLiveData get() = _homeCustomResponseLiveData

    init {
        fetchHomeScreen()
    }

    fun fetchHomeScreen() = viewModelScope.launch(Dispatchers.IO) {
        Log.i("RECENT", "CALLING")
        val response = repo.getShows()
        response.collect {
            when (it) {
                is ResultWrapper.Success ->
                    _homeCustomResponseLiveData.postValue(it.data as HomeCustomResponseModel)
                else -> {}
            }
        }
    }

    enum class HomeResponseType {
        DRAMA, KSHOWS, MOVIES
    }
}