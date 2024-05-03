package ali.hrhera.module.base.data.network

import androidx.annotation.Keep

@Keep
data class BaseErrorServerResponse(val statusCode: Int, val errorMessage: String? = null)
