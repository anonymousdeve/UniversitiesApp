package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.Universities

sealed class UniversitiesEvents {

    data object NoAction : UniversitiesEvents()
    data class ShowData(val items: Universities) : UniversitiesEvents()
}