package e.muslim.prayer.utils.base_classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import e.muslim.prayer.R
import e.muslim.prayer.presentation.activity.MainActivity
import e.muslim.prayer.utils.BACKGROUND_BLACK
import e.muslim.prayer.utils.BACKGROUND_GRAY
import e.muslim.prayer.utils.BACKGROUND_MAIN

abstract class BaseBindingFragment<B : ViewDataBinding, T : BaseViewModel>(@LayoutRes private val layoutResID: Int) :
    BaseFragment() {

    protected abstract val vm: BaseViewModel

    var isShowMsg = false

    //  Your view data binding
    open val binding get() = _binding!!
    private var _binding: B? = null

    var lastClickTime = 0L

    //  Bind all widgets and start code
    protected abstract fun initViews(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResID, container, false)
        return binding.root
    }


    // Initialize all widget in layout by ID
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        vm.isLoading.observe(viewLifecycleOwner, {
            if (it) {
                showLoader()
            } else {
                hideLoader()
            }
        })
        vm.error.observe(viewLifecycleOwner, {
        })
        vm.errorString.observe(viewLifecycleOwner, {
        })
        vm.showNetworkError.observe(viewLifecycleOwner, {
        })
        vm.navigateTo.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        vm.navigateWithData.observe(viewLifecycleOwner) {
            findNavController().navigate(it.destination, it.bundle)
        }
        vm.navigateUp.observe(viewLifecycleOwner, {
            findNavController().navigateUp()
        })
        initViews(savedInstanceState)
    }

    fun View.click(onClick: () -> Unit) {
        if (System.currentTimeMillis() > lastClickTime + 750) {
            this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            lastClickTime = System.currentTimeMillis()
            onClick()
        }
    }

    fun onBackPressed() {
        when (activity) {
            is MainActivity -> {
                (activity as MainActivity).onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun toggleBottomNavVisibility(visible: Boolean) {
//        if (activity is MainActivity) {
//            (activity as MainActivity).toggleBottomNavVisibility(visible)
//        }
    }

    private fun setBackground() {
        toggleBottomNavVisibility(false)
        changeThemeStatus(BACKGROUND_BLACK)
    }

    fun setBackgroundMain() {
        toggleBottomNavVisibility(true)
        changeThemeStatus(BACKGROUND_MAIN)
    }

    private fun changeThemeStatus(index: Int) {
        activity?.window?.let { window ->
            when (index) {
                BACKGROUND_BLACK -> {
                    WindowInsetsControllerCompat(
                        window,
                        window.decorView
                    ).isAppearanceLightStatusBars =
                        false
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.black)
//                    window.navigationBarColor =
//                        ContextCompat.getColor(requireContext(), R.color.bg_main)
                }
                BACKGROUND_MAIN -> {
                    WindowInsetsControllerCompat(
                        window,
                        window.decorView
                    ).isAppearanceLightStatusBars =
                        true
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor =
                        ContextCompat.getColor(requireContext(), R.color.color000)
//                    window.navigationBarColor =
//                        ContextCompat.getColor(requireContext(), R.color.bg_main)
                }
                BACKGROUND_GRAY -> {
                    WindowInsetsControllerCompat(
                        window,
                        window.decorView
                    ).isAppearanceLightStatusBars =
                        true
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                    window.statusBarColor =
//                        ContextCompat.getColor(requireContext(), R.color.grey_bg_buy_card_recommend)
//                    window.navigationBarColor =
//                        ContextCompat.getColor(requireContext(), R.color.bg_main)
                }
            }
        }
    }
}