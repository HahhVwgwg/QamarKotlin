package e.muslim.prayer.presentation.pray_time

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentPrayTimeBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrayTimeFragment :
    BaseBindingFragment<FragmentPrayTimeBinding, MainViewModel>(R.layout.fragment_pray_time) {
    override val vm: MainViewModel by viewModel()

    override fun initViews(savedInstanceState: Bundle?) {
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.run {
            qibla.setOnClickListener {
                it.click {

                }
            }
            settings.setOnClickListener {
                it.click {
                    findNavController().navigate(R.id.action_pray_time_to_settings)
                }
            }
            mosqueImage.setOnClickListener {
                it.click {
                    findNavController().navigate(R.id.action_pray_time_to_choose_mosque)
                }
            }
        }
    }
}