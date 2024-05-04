package ali.hrhera.module.base.domain

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "university")
data class University(
    @PrimaryKey
    val name: String,
    val stateProvince: String,
    val country: String,
    val alphaTwoCode: String,
    val webPages: List<String>,
    val domains: List<String>,
) : Parcelable


typealias Universities = List<University>