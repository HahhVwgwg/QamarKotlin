package e.muslim.prayer.utils.base_classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import e.muslim.prayer.R


abstract class BaseHomeBottomFragment(@LayoutRes private val layoutResID: Int): BottomSheetDialogFragment() {

    companion object{
        const val TAG = "BaseBottomSheetDialogFragment"
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    //  Initialize your views and start code
    protected abstract fun initViews(view: View?, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResID, container, false)
    }

    //  Initialize all widget in layout by ID
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = initViews(view, savedInstanceState)
}