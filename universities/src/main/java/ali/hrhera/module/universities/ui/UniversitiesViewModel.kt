package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.data.network.BaseResponse
import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.base.ui.viewmodel.BaseViewModel
import ali.hrhera.module.universities.use_case.GetUniversitiesUseCase
import ali.hrhera.module.universities.use_case.SaveUniversitiesToLocalUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ViewModel for handling business logic and data operations related to universities.
 */
@HiltViewModel
class UniversitiesViewModel
@Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase,
    private val saveToLocalUseCase: SaveUniversitiesToLocalUseCase
) : BaseViewModel() {


    private val _eventMutLiveData = MutableLiveData<UniversitiesEvents>()
    val events: LiveData<UniversitiesEvents> = _eventMutLiveData


    init {
        handelOnlineResponse()
        handelLocalResponse()
    }


    private fun handelOnlineResponse() {
        getUniversitiesUseCase.universitiesResponse.responseCollect({
            getLocalUniversities()

        }) {
            saveToLocal(it)
            _eventMutLiveData.postValue(UniversitiesEvents.ShowData(it))
        }
    }

    private fun handelLocalResponse() {
        getUniversitiesUseCase.universitiesLocalResponse.responseCollect {
            _eventMutLiveData.postValue(UniversitiesEvents.ShowData(it))
        }
    }


    private var country: String = "United Arab Emirates"
    private var getDataJob: Job? = null

    private fun getLocalUniversities() {
        if (getDataJob == null)
            getDataJob = launchTask {
                getUniversitiesUseCase.getLocalUniversities(country)
            }
    }

    val onlineLoading =
        getUniversitiesUseCase.universitiesResponse.asSharedFlow().map { it is BaseResponse.Loading }.asLiveData()
    val localeLoading =
        getUniversitiesUseCase.universitiesLocalResponse.asSharedFlow().map { it is BaseResponse.Loading }.asLiveData()


     fun fetchOnlineUniversities() {
        launchTask {
            getUniversitiesUseCase.getOnlineUniversities(country)
        }
    }


    /**
     * Saves universities data to the local database.
     * @param universities The universities data to be saved.
     */

    private fun saveToLocal(universities: Universities) {
        launchTask {
            saveToLocalUseCase.saveToLocal(universities)
        }
    }


}