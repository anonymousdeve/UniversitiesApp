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
        // Check if arguments are not null
        arguments?.let { argument ->
            // Retrieve the University object from arguments
            (argument.parcelable(KEY_UNIVERSITY) as University?).let {
                it?.let { university ->
                    // Initialize UniversityDetailsViewModel with the retrieved University object
                    val viewModel = UniversityDetailsViewModel(university).apply {
                        // Set click listener for refresh button
                        refreshClick = {
                            // Navigate back when refresh button is clicked
                            findNavController().popBackStack()
                        }
                    }
                    // Bind the ViewModel to the layout
                    binding.viewModel = viewModel
                } ?: run {
                    // If University object is null, navigate back
                    findNavController().popBackStack()
                }
            }
        } ?: run {
            // If arguments are null, navigate back
            findNavController().popBackStack()
        }
    }


}