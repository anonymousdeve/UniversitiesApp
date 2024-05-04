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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ViewModel for handling business logic and data operations related to universities.
 */
@HiltViewModel
class UniversitiesViewModel
@Inject constructor(
    val getUniversitiesUseCase: GetUniversitiesUseCase
) : BaseViewModel() {


    private val _eventMutLiveData = MutableLiveData<UniversitiesEvents>()
    val events: LiveData<UniversitiesEvents> = _eventMutLiveData

    val adapter = UniversitiesAdapter().apply {
        onItemClickHandel = {
            _eventMutLiveData.postValue(UniversitiesEvents.MoveToDetails(it))
        }
    }

    init {
        // Initialize the ViewModel by fetching universities data
        fetchOnlineUniversities()
    }


    init {
        getUniversitiesUseCase.universitiesResponse.responseCollect({
            getLocalUniversities()

        }) {
            saveToLocal(it)
            launchTask {
                withContext(Dispatchers.Main) {
                    adapter.submitData(it)
                }
            }
        }

        fetchOnlineUniversities()
    }


    private var country: String = "United Arab Emirates"
    private var getDataJob: Job? = null

    private fun getLocalUniversities() {
        if (getDataJob == null)
            getDataJob = launchTask {
                getUniversitiesUseCase.getLocalUniversities(country)
            }
    }

    val loading = getUniversitiesUseCase.universitiesResponse.map { it is BaseResponse.Loading }.asLiveData()


    private fun fetchOnlineUniversities() {
        launchTask {
            getUniversitiesUseCase.getOnlineUniversities(country)
        }
    }


    @Inject
    lateinit var saveToLocalUseCase: SaveUniversitiesToLocalUseCase

    /**
     * Saves universities data to the local database.
     * @param universities The universities data to be saved.
     */

    fun saveToLocal(universities: Universities) {
        launchTask {
            saveToLocalUseCase.saveToLocal(universities)
        }
    }


}