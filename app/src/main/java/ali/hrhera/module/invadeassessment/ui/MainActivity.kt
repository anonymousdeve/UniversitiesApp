package ali.hrhera.module.invadeassessment.ui

import ali.hrhera.module.base.ui.activity.BaseActivity
import ali.hrhera.module.invadeassessment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun intBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun afterViewSetUp() {

    }


}