package ali.hrhera.module.base.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import java.net.SocketTimeoutException
import retrofit2.HttpException

const val NO_INTERNET = 10
const val BAD_INTERNET = 11

abstract class BaseRepository() {



    private val defaultDispatcher = Dispatchers.IO

    protected suspend fun <T : Any> buildApi(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Body(data = task()))
    }.flowOn(defaultDispatcher).onStart {
        emit(BaseResponse.Loading(loading = true))
    }.catch { throwable ->
        emit(BaseResponse.Error(throwable = throwable, errorBody = getErrorBody(throwable)))
    }

    protected suspend fun <T : Any> buildRoom(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Body(data = task()))
    }.flowOn(defaultDispatcher).onStart {
        emit(BaseResponse.Loading(loading = true))
    }.catch { throwable ->
        emit(BaseResponse.Error(throwable = throwable, errorBody = getErrorBody(throwable)))
    }

    private fun getErrorBody(throwable: Throwable): BaseErrorServerResponse = when (throwable) {
        is SocketTimeoutException -> BaseErrorServerResponse(BAD_INTERNET, )
        is HttpException -> {
            BaseErrorServerResponse(
                throwable.response()?.code() ?: 0, throwable.response()?.errorBody()?.string() ?: throwable.message
            )
        }

        else -> BaseErrorServerResponse(NO_INTERNET, throwable.message )
    }
}