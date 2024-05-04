package ali.hrhera.module.universities.di

import ali.hrhera.module.universities.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProviderModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):
            ApiService = retrofit.create(ApiService::class.java)
}