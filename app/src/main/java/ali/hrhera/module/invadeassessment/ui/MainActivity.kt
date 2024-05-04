package ali.hrhera.module.invadeassessment.ui

import ali.hrhera.module.base.domain.University
import ali.hrhera.module.base.ui.activity.BaseActivity
import ali.hrhera.module.base.util.KEY_UNIVERSITY
import ali.hrhera.module.invadeassessment.R
import ali.hrhera.module.invadeassessment.databinding.ActivityMainBinding
import ali.hrhera.module.universities.ui.UniversitiesListFragment
import ali.hrhera.module.universities.util.MoveToDetailsCallBack
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), MoveToDetailsCallBack {
    override fun intBinding() = ActivityMainBinding.inflate(layoutInflater)


    private lateinit var controller: NavController
    override fun afterViewSetUp() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        controller = navHostFragment.navController



        UniversitiesListFragment.moveToDetailsCallBack = this
    }

    override fun withItem(item: University) {
        Log.w("TAG WithItem", "withItem: ")
        controller.navigate(R.id.fragment_university_details, bundleOf(KEY_UNIVERSITY to item))

    }


}