package ali.hrhera.module.invadeassessment

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.work.Configuration
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
@HiltAndroidApp
class App : Application(), ViewModelStoreOwner, Configuration.Provider {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface HiltWorkerFactoryEntryPoint {
        fun workerFactory(): HiltWorkerFactory
    }

    override fun getWorkManagerConfiguration() = Configuration.Builder()
        .setWorkerFactory(EntryPoints.get(this, HiltWorkerFactoryEntryPoint::class.java).workerFactory())
        .setMinimumLoggingLevel(android.util.Log.DEBUG)
        .build()

    override val viewModelStore: ViewModelStore
        get() = appViewModelStore


    override fun onCreate() {
        super.onCreate()
        appContext = this

    }

    companion object {
        lateinit var appContext: Application

        private val appViewModelStore: ViewModelStore by lazy {
            ViewModelStore()
        }
    }


}