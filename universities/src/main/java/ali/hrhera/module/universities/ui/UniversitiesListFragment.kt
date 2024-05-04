package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.ui.fragment.BaseFragment
import ali.hrhera.module.universities.databinding.FragmentUniversitiesListBinding
import ali.hrhera.module.universities.util.MoveToDetailsCallBack
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversitiesListFragment : BaseFragment<FragmentUniversitiesListBinding>() {

    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversitiesListBinding.inflate(inflater, container, false)

    val adapter = UniversitiesAdapter().apply {
        onItemClickHandel = {
            moveToDetailsCallBack?.withItem(it)
        }
    }

    private val viewModel: UniversitiesViewModel by viewModels()
    override fun afterViewSetUp() {
        binding.adapter = adapter
        viewModel.fetchOnlineUniversities()


        viewModel.events.observe(viewLifecycleOwner) {
            when (it) {
                is UniversitiesEvents.ShowData -> adapter.submitData(it.items)
                UniversitiesEvents.NoAction -> TODO()
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.loading.isVisible = it
        }
    }

    companion object {
        var moveToDetailsCallBack: MoveToDetailsCallBack? = null
    }

}