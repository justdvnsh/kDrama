package divyansh.tech.kdrama.home.source

import divyansh.tech.kdrama.util.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeDefaultRepository @Inject constructor(
    private val localRepo: HomeLocalRepository,
    private val remoteRepo: HomeRemoteRepository
): HomeDefaultDataSource {
    override fun getShows(): Flow<ResultWrapper<*>> {
        // TODO: ADD Caching
        return flow {
            emit(remoteRepo.fetchRecentDrama())
        }
    }

    override fun getMovies(): Flow<ResultWrapper<*>> {
        TODO("Not yet implemented")
    }
}