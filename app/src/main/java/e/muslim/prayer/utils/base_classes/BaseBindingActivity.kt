package e.muslim.prayer.utils.base_classes

import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import e.muslim.prayer.R
import e.muslim.prayer.utils.BACKGROUND_BLACK
import e.muslim.prayer.utils.BACKGROUND_GRAY
import e.muslim.prayer.utils.BACKGROUND_MAIN
import e.muslim.prayer.utils.getColorFromAttr

abstract class BaseBindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResID: Int) :
    BaseActivity() {

    private var _binding: B? = null
    open val binding get() = _binding!!

    override fun onCreateUI(savedInstanceState: Bundle?) {
        //  Override Resources ID Layout
        _binding = DataBindingUtil.setContentView(this, layoutResID)
        //  Initialize all widget in layout by ID
        initViews(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    open fun changeThemeStatus(index: Int) {
        when (index) {
            BACKGROUND_BLACK -> {
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                    false
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = getColorFromAttr(R.attr.bottomSheetContainer)
                window.navigationBarColor = getColorFromAttr(R.attr.bottomSheetContainer)
            }
            BACKGROUND_MAIN -> {
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                    true
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = getColorFromAttr(R.attr.backgroundColor)
                window.navigationBarColor = getColorFromAttr(R.attr.backgroundColor)
            }
            BACKGROUND_GRAY -> {
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                    true
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor =
                    getColorFromAttr(R.attr.bottomSheetContainer)
                window.navigationBarColor = getColorFromAttr(R.attr.bottomSheetContainer)
            }
        }
    }
}