package ali.hrhera.module.universities.data

import ali.hrhera.module.base.data.local.UniversityDAO
import ali.hrhera.module.base.data.network.BaseRepository
import ali.hrhera.module.base.data.network.BaseResponse
import ali.hrhera.module.base.domain.Universities
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

class UniversitiesRepo
@Inject constructor(
    private val apiService: ApiService,
    private val localDb: UniversityDAO
) : BaseRepository() {



    val getUniversitiesResponse = MutableStateFlow<BaseResponse<Universities>>(BaseResponse.None)

    suspend fun getUniversities(country: String) =
        getUniversitiesResponse.emitAll(flow = buildApi {
            apiService.getUniversityByCountry(country).map { it.toUniversity() }
        })


    suspend fun getLocalUniversities(country: String) =
        getUniversitiesResponse.emitAll(flow = buildRoom { localDb.getUniversityByCountry(country) })


    private val saveUniversitiesResponse = MutableStateFlow<BaseResponse<Unit>>(BaseResponse.None)

    suspend fun saveToLocal(universities: Universities) =
        saveUniversitiesResponse.emitAll(flow = buildRoom {
            localDb.addUniversity(universities)
        })

}