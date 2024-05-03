package ali.hrhera.module.network.di

import android.app.Application
import dagger.Component

@Component(modules = [ContextModule::class])
interface AppComponent {

    fun inject(application: Application)

}