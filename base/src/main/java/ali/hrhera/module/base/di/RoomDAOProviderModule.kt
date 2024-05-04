package ali.hrhera.module.base.di

import ali.hrhera.module.base.data.local.UniversityDAO
import ali.hrhera.module.base.data.local.UniversityDb
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDAOProviderModule {
    @Provides
    @Singleton
    fun provideDAO(@ApplicationContext context: Context): UniversityDAO = UniversityDb.universityDAO(context)


}