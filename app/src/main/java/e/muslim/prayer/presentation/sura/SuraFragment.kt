package e.muslim.prayer.presentation.sura

import android.os.Bundle
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentTajweedBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuraFragment :
    BaseBindingFragment<FragmentTajweedBinding, MainViewModel>(R.layout.fragment_tajweed) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {

    }
}