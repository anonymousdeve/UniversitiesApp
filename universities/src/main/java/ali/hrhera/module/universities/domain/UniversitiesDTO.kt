package ali.hrhera.module.universities.domain


import ali.hrhera.module.base.domain.University
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class UniversitiesDTO(
    @SerializedName("alpha_two_code")
    @Expose
    val alphaTwoCode: String, // AE
    @SerializedName("country")
    @Expose
    val country: String, // United Arab Emirates
    @SerializedName("domains")
    @Expose
    val domains: List<String>,
    @SerializedName("name")
    @Expose
    val name: String, // Mohamed bin Zayed University of Artificial Intelligence (MBZUAI)
    @SerializedName("state-province")
    @Expose
    val stateProvince: String?, // Abu Dhabi
    @SerializedName("web_pages")
    @Expose
    val webPages: List<String>
) {
    fun toUniversity(): University {
        return University(
            name = name,
            alphaTwoCode = alphaTwoCode,
            country = country,
            domains = domains,
            stateProvince = stateProvince ?: "",
            webPages = webPages
        )
    }
}

typealias UniversitiesList = List<UniversitiesDTO>
