package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.data.network.BaseResponse
import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.base.ui.viewmodel.BaseViewModel
import ali.hrhera.module.universities.use_case.GetUniversitiesUseCase
import ali.hrhera.module.universities.use_case.SaveUniversitiesToLocalUseCase
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class UniversitiesViewModel
@Inject constructor(
    val getUniversitiesUseCase: GetUniversitiesUseCase
) : BaseViewModel() {


    val adapter = UniversitiesAdapter()

    init {
        getUniversitiesUseCase.universitiesResponse.responseCollect({

        }) {
            getLocalUniversities()
        }

        fetchOnlineUniversities()
    }





        var country: String = "United Arab Emirates"
        private fun getLocalUniversities() {
            launchTask {
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

        fun saveToLocal(universities: Universities) {
            launchTask {
                saveToLocalUseCase.saveToLocal(universities)
            }
        }


}