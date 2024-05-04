package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.University
import ali.hrhera.module.base.ui.fragment.BaseFragment
import ali.hrhera.module.base.util.KEY_UNIVERSITY
import ali.hrhera.module.base.util.parcelable
import ali.hrhera.module.universities.databinding.FragmentUniversitiesListBinding
import ali.hrhera.module.universities.util.MoveToDetailsCallBack
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversitiesListFragment : BaseFragment<FragmentUniversitiesListBinding>() {

    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversitiesListBinding.inflate(inflater, container, false)



    private val viewModel: UniversitiesViewModel by viewModels()
    override fun afterViewSetUp() {

        binding.viewModel = viewModel

        viewModel.events.observe(viewLifecycleOwner) {
            when (it) {

                is UniversitiesEvents.MoveToDetails -> {
                    moveToDetailsCallBack?.withItem(it.item)
                }
            }
        }
    }

    companion object {
        var moveToDetailsCallBack: MoveToDetailsCallBack? = null
    }

}