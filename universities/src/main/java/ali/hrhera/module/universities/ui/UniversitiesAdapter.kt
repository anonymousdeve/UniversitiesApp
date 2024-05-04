package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.University
import ali.hrhera.module.universities.databinding.ItemSingleUniversityBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import appssquare.projects.HealloCare.core.presentation.adapter.SingleViewHolderBaseRecyclerAdapter

class UniversitiesAdapter : SingleViewHolderBaseRecyclerAdapter<University, ItemSingleUniversityBinding>() {
    override fun createBinding(parent: ViewGroup, viewType: Int) =
        ItemSingleUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    var onItemClickHandel: (University) -> Unit = {}

    override fun bind(binding: ItemSingleUniversityBinding, position: Int) {
        binding.executePendingBindings()
        binding.model = AdapterViewModel(currentData[position]).apply {
            onItemClick = onItemClickHandel
        }

    }
}