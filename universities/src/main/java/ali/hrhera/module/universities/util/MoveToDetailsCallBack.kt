package ali.hrhera.module.universities.util

import ali.hrhera.module.base.domain.University

interface MoveToDetailsCallBack {
    fun withItem(item: University)
}