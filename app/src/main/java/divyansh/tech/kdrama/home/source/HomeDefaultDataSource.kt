package divyansh.tech.kdrama.home.source

import divyansh.tech.kdrama.util.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface HomeDefaultDataSource {

    fun getShows(): Flow<ResultWrapper<*>>

    fun getMovies(): Flow<ResultWrapper<*>>
}