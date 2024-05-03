package ali.hrhera.module.universities.di

import ali.hrhera.module.universities.data.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkProviderModule {


    @Provides
    @Singleton
    fun provideCountryService(retrofit: Retrofit):
            ApiService = retrofit.create(ApiService::class.java)

}