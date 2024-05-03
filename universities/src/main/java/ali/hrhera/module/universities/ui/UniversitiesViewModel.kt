package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.di.AppComponent
import ali.hrhera.module.base.di.DaggerAppComponent
import ali.hrhera.module.base.ui.viewmodel.BaseViewModel
import ali.hrhera.module.universities.use_case.GetUniversitiesUseCase
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class UniversitiesViewModel @Inject constructor(
    val getUniversitiesUseCase: GetUniversitiesUseCase
) : BaseViewModel() {


    init {
        (DaggerAppComponent.create() as AppComponent).inject(this)
    }


    val adapter = UniversitiesAdapter()
    val loading = MutableLiveData(true)

    init {
        getUniversitiesUseCase.universitiesResponse.responseCollect({

        }) {
//            getLocalUniversities()
        }

//        fetchOnlineUniversities()
    }
    /*




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
        }*/


}