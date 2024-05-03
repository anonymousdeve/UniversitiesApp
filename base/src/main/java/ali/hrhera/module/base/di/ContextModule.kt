package ali.hrhera.module.base.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ContextModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext
}