package ali.hrhera.module.university_details.ui

import ali.hrhera.module.base.domain.University
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class UniversityDetailsViewModel(private val university: University) : BaseObservable() {
    val name = ObservableField(university.name)
    val state = ObservableField(university.stateProvince)
    val country = ObservableField(university.country)
    val countryCode = ObservableField(university.alphaTwoCode)
    val webPages = ObservableField<String>()
    val domains = ObservableField<String>()

    init {
        intWepPages()
        intDomains()

    }

    private fun intWepPages() {
        val wepPagesStrB = StringBuilder()
        university.webPages.forEach {
            wepPagesStrB.append("$it\n")
        }
        webPages.set(wepPagesStrB.toString())
    }

    private fun intDomains() {
        val domainsStrB = StringBuilder()
        university.domains.forEach {
            domainsStrB.append("$it\n")
        }
        domains.set(domainsStrB.toString())
    }


    var refreshClick = {}
    fun onRefreshClick() {
        refreshClick()
    }

}