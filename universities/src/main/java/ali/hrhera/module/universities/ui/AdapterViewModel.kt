package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.University
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class AdapterViewModel(private val item: University) : BaseObservable() {

    val name = ObservableField(item.name)
    val stateProvince = ObservableField(item.stateProvince)
    var onItemClick:(University)->Unit={}

    fun onClick(){
        onItemClick(item)
    }

}