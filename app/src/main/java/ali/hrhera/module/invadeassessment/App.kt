package ali.hrhera.module.invadeassessment

import ali.hrhera.module.network.di.AppComponent
import ali.hrhera.module.network.di.DaggerAppComponent
import android.app.Application

class App:Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }

}