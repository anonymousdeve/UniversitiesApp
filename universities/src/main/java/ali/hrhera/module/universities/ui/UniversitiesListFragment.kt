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

    // Instantiate UniversitiesAdapter
    private val adapter = UniversitiesAdapter().apply {
        // Set onItemClickHandler
        onItemClickHandel = {
            moveToDetailsCallBack?.withItem(it)
        }
    }

    // Inject UniversitiesViewModel
    private val viewModel: UniversitiesViewModel by viewModels()

    // Inflate binding layout
    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversitiesListBinding.inflate(inflater, container, false)

    override fun afterViewSetUp() {
        // Set adapter to RecyclerView
        binding.adapter = adapter

        // Fetch online universities data
        viewModel.fetchOnlineUniversities()

        // Observe LiveData for universities data
        setupUniversities()

        // Observe  loading state
        setupLoading()

        // Set refresh button click listener
        setupRefresh()
    }

    private fun setupUniversities() {
        viewModel.events.observe(viewLifecycleOwner) {
            when (it) {
                is UniversitiesEvents.ShowData -> {
                    with(it.items) {
                        // Submit data to adapter
                        adapter.submitData(this)
                        // Show/hide no data view based on data availability
                        binding.noData.isVisible = this.isEmpty()
                    }
                }

                UniversitiesEvents.NoAction -> TODO()
            }
        }
    }

    private fun setupLoading() {
        viewModel.loading.observe(viewLifecycleOwner) {
            // Show/hide loading indicator based on loading state
            binding.loading.isVisible = it
        }
    }

    private fun setupRefresh() {
        binding.refresh.setOnClickListener {
            // Refresh universities data
            viewModel.fetchOnlineUniversities()
        }
    }

    companion object {
        var moveToDetailsCallBack: MoveToDetailsCallBack? = null
    }
}
