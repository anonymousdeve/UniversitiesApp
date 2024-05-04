package ali.hrhera.module.universities.use_case

import ali.hrhera.module.base.domain.Universities
import ali.hrhera.module.universities.data.UniversitiesRepo
import javax.inject.Inject

class SaveUniversitiesToLocalUseCase
@Inject
constructor(private val universitiesRepo: UniversitiesRepo) {

    suspend fun saveToLocal(universities: Universities) = universitiesRepo.saveToLocal(universities)

}