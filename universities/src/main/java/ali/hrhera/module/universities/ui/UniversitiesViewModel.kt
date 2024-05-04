package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.base.ui.viewmodel.BaseViewModel
import ali.hrhera.module.universities.use_case.GetUniversitiesUseCase
import ali.hrhera.module.universities.use_case.SaveUniversitiesToLocalUseCase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
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
        }, loading = {
            _loading.postValue(it)
        }) {
            saveToLocal(it)
            _eventMutLiveData.postValue(UniversitiesEvents.ShowData(it))

        }


    }

    private fun handelLocalResponse() {
        getUniversitiesUseCase.universitiesLocalResponse.responseCollect(loading = {
            _loading.postValue(it)

        }) {
            _eventMutLiveData.postValue(UniversitiesEvents.ShowData(it))
        }

    }


    private var country: String = "United Arab Emirates"

    private fun getLocalUniversities() {
        launchTask {
            getUniversitiesUseCase.getLocalUniversities(country)
        }
    }

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading



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