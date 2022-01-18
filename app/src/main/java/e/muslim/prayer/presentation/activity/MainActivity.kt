package e.muslim.prayer.presentation.activity

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import e.muslim.prayer.R
import e.muslim.prayer.databinding.ActivityMainBinding
import e.muslim.prayer.utils.base_classes.BaseBindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseBindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val bottomVm: BottomNavigationViewModel by viewModel()
    private var calledNavigation = false

    override fun initViews(savedInstanceState: Bundle?) {


        binding.run {
            vm = bottomVm
            bottomVm.clickedMenu.observe(this@MainActivity, { menuType ->
                calledNavigation = true
                navView.selectedItemId = when (menuType) {
                    1 -> R.id.navigation_pray_times
                    2 -> R.id.navigation_quran
                    3 -> R.id.navigation_dua
                    4 -> R.id.navigation_tespihat
                    5 -> R.id.navigation_asma
                    else -> R.id.navigation_pray_times
                }
                calledNavigation = false
            })
            findNavController(R.id.nav_host_fragment_main).addOnDestinationChangedListener { _, destination, _ ->
                if (calledNavigation)
                    return@addOnDestinationChangedListener
                when (destination.id) {
                    R.id.navigation_asma -> bottomVm.onClick(5)
                    R.id.navigation_tespihat -> bottomVm.onClick(4)
                    R.id.navigation_dua -> bottomVm.onClick(3)
                    R.id.navigation_quran -> bottomVm.onClick(2)
                    R.id.navigation_pray_times -> bottomVm.onClick(1)
                    else -> bottomVm.onClick(6)
                }
            }
            navView.setupWithNavController(findNavController(R.id.nav_host_fragment_main))
        }
    }


    override fun onBackPressed() {
        when (NavHostFragment.findNavController(supportFragmentManager.fragments[0]).currentDestination?.id) {
            R.id.navigation_settings,
            R.id.navigation_search,
            R.id.navigation_qaza,
            R.id.navigation_khatym,
            R.id.navigation_choose_mosque,
            R.id.navigation_statistics,
            R.id.navigation_sura,
            R.id.navigation_para -> {
                bottomVm.onMainFragmentsOpened()
            }
            null -> {}
            else -> {

            }
        }
        super.onBackPressed()
    }

}