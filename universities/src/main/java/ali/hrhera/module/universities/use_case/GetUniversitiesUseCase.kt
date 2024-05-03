package ali.hrhera.module.universities.use_case


import ali.hrhera.module.universities.data.UniversitiesRepo
import javax.inject.Inject

class GetUniversitiesUseCase
@Inject
constructor(private val universitiesRepo: UniversitiesRepo)  {

    val universitiesResponse = universitiesRepo.getUniversitiesResponse

    suspend fun getOnlineUniversities(country: String) = universitiesRepo.getUniversities(country)
    suspend fun getLocalUniversities(country: String) = universitiesRepo.getLocalUniversities(country)

}