package ali.hrhera.module.base.ui.viewmodel

import ali.hrhera.module.base.data.network.BaseResponse
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {
    protected fun launchTask(task: suspend () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) { task() }

    protected fun <T : Any> Flow<BaseResponse<T>>.responseCollect(
        onError: (String) -> Unit = {},
        onSuccess: (T) -> Unit
    ) {
        launchTask {
            this@responseCollect.collectLatest { response ->
                when (response) {
                    is BaseResponse.Loading -> {
                    }

                    is BaseResponse.Body -> onSuccess(response.data)
                    is BaseResponse.Error -> {
                        try {
                            onError(response.errorBody.errorMessage ?: response.throwable.message ?: "")
                        } catch (e: Throwable) {
                            onError(e.message?:"")
                        }
                    }

                    is BaseResponse.None -> Unit

                }
            }
        }
    }

}