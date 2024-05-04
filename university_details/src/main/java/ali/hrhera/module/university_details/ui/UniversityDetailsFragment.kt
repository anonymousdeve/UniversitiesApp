package ali.hrhera.module.university_details.ui

import ali.hrhera.module.base.domain.University
import ali.hrhera.module.base.ui.fragment.BaseFragment
import ali.hrhera.module.base.util.KEY_UNIVERSITY
import ali.hrhera.module.base.util.parcelable
import ali.hrhera.module.university_details.databinding.FragmentUniversityDetailsBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class UniversityDetailsFragment : BaseFragment<FragmentUniversityDetailsBinding>() {
    override fun intBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUniversityDetailsBinding.inflate(inflater, container, false)

    override fun afterViewSetUp() {
        arguments?.let { argument ->
            (argument.parcelable(KEY_UNIVERSITY) as University?)?.let {
                val viewModel = UniversityDetailsViewModel(it)
                binding.viewModel = viewModel
            } ?: findNavController().popBackStack()

        } ?: findNavController().popBackStack()

    }


}