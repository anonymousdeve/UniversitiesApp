package ali.hrhera.module.base.data.local

import ali.hrhera.module.base.domain.University
import ali.hrhera.module.base.util.TypeConverter
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [University::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)

abstract class UniversityDb : RoomDatabase() {
    abstract val universityDAO: UniversityDAO

    companion object {
        @Volatile
        private var dao: UniversityDAO? = null
        private fun buildDataBse(context: Context): UniversityDb = Room.databaseBuilder(
            context,
            UniversityDb::class.java,
            "UniversityDb"
        )
            .fallbackToDestructiveMigration()
            .build()

        fun universityDAO(context: Context): UniversityDAO {
            synchronized(this) {
                if (dao == null) {
                    dao = buildDataBse(context.applicationContext).universityDAO
                }
                return dao as UniversityDAO
            }
        }
    }
}