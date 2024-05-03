package ali.hrhera.module.universities.data

import ali.hrhera.module.universities.domain.UniversitiesList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getUniversityByCountry(@Query("country") country: String ): UniversitiesList
}