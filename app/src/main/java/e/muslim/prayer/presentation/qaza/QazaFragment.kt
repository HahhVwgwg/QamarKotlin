package e.muslim.prayer.presentation.qaza

import android.os.Bundle
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentQazaBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class QazaFragment :
    BaseBindingFragment<FragmentQazaBinding, MainViewModel>(R.layout.fragment_qaza) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.run {
            back.setOnClickListener {
                it.click {
                    onBackPressed()
                }
            }
            edit.setOnClickListener {
                it.click {

                }
            }
        }
    }
}