package e.muslim.prayer.presentation.dua

import android.os.Bundle
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentDuaBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DuaFragment :
    BaseBindingFragment<FragmentDuaBinding, MainViewModel>(R.layout.fragment_dua) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {

    }
}