package ali.hrhera.module.base.data.local

import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.base.domain.University
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UniversityDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUniversity(list: Universities)


    @Query("SELECT * FROM university WHERE name = :name")
    fun getSingleUniversity(name: Int): University

}