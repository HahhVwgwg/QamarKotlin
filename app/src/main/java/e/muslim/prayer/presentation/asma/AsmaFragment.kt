package e.muslim.prayer.presentation.asma

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentAsmaBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AsmaFragment :
    BaseBindingFragment<FragmentAsmaBinding, MainViewModel>(R.layout.fragment_asma) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.run {
            qaza.setOnClickListener {
                it.click {
                    findNavController().navigate(R.id.action_asma_to_qaza)
                }
            }
        }
    }
}