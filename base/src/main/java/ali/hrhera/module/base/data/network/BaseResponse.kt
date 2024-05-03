package ali.hrhera.module.base.data.network

import androidx.annotation.Keep

@Keep
sealed class BaseResponse<out T : Any> {
    @Keep
    data class Body<out T : Any>(val data: T) : BaseResponse<T>()


    @Keep
    data class Error(val throwable: Throwable, val errorBody: BaseErrorServerResponse) : BaseResponse<Nothing>()

    @Keep
    data class Loading(val loading: Boolean) : BaseResponse<Nothing>()

    @Keep
    object None : BaseResponse<Nothing>()
}