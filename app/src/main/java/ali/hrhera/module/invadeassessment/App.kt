package ali.hrhera.module.invadeassessment

import ali.hrhera.module.base.di.AppComponent
import ali.hrhera.module.base.di.DaggerAppComponent
import android.app.Application

class App:Application() {
     private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }

}