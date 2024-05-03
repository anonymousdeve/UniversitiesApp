package ali.hrhera.module.base.di

import ali.hrhera.module.base.data.local.UniversityDAO
import ali.hrhera.module.base.data.local.UniversityDb
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RoomDAOProviderModule {


    @Provides
    @Singleton
    fun provideDAO(context: Context): UniversityDAO = UniversityDb.universityDAO(context)


}