package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.ui.fragment.BaseFragment
import ali.hrhera.module.universities.databinding.FragmentUniversitiesListBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels

class UniversitiesListFragment : BaseFragment<FragmentUniversitiesListBinding>() {
    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversitiesListBinding.inflate(inflater, container, false)

    private val viewModel: UniversitiesViewModel by viewModels()
    override fun afterViewSetUp() {

        binding.viewModel = viewModel
    }
}