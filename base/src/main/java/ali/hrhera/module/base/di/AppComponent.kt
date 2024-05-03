package ali.hrhera.module.base.di

import ali.hrhera.module.base.data.network.BaseRepository
import ali.hrhera.module.base.ui.viewmodel.BaseViewModel
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [ContextModule::class])
interface AppComponent {

    fun inject(application: Application)
    fun inject(viewModel: BaseViewModel)
    fun inject(repository: BaseRepository)
    fun inject(fragment: Fragment)

}