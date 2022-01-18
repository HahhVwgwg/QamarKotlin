package e.muslim.prayer.presentation.quran

import android.os.Bundle
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentSuraBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuraListFragment :
    BaseBindingFragment<FragmentSuraBinding, MainViewModel>(R.layout.fragment_sura) {
    override val vm: MainViewModel by viewModel()
    override fun initViews(savedInstanceState: Bundle?) {

    }

    companion object {
        fun newInstance(): SuraListFragment {
            val args = Bundle()
            val fragment = SuraListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}