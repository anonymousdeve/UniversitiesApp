package ali.hrhera.module.base.domain

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "university")
data class University(
    @PrimaryKey
    val name: String,
    val stateProvince: String,
    val country: String,
    val alphaTwoCode: String,
    val webPages: List<String>,
    val domains: List<String>,
)


typealias Universities = List<University>