package e.muslim.prayer.presentation.khatym

import android.os.Bundle
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentKhatymBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class KhatymFragment :
    BaseBindingFragment<FragmentKhatymBinding, MainViewModel>(R.layout.fragment_khatym) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {

    }
}