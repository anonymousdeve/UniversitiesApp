package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.di.AppComponent
import ali.hrhera.module.base.di.DaggerAppComponent
import ali.hrhera.module.base.di.ViewModelFactory
import ali.hrhera.module.base.di.ViewModelModule
import ali.hrhera.module.base.ui.fragment.BaseFragment
import ali.hrhera.module.universities.databinding.FragmentUniversitiesListBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class UniversitiesListFragment : BaseFragment<FragmentUniversitiesListBinding>() {
    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversitiesListBinding.inflate(inflater, container, false)

    private val viewModel: UniversitiesViewModel by viewModels()
    override fun afterViewSetUp() {

        binding.viewModel = viewModel
    }
}