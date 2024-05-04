package ali.hrhera.module.universities.ui

import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.base.domain.University

sealed class UniversitiesEvents {

    data class MoveToDetails(val item:University):UniversitiesEvents()
}