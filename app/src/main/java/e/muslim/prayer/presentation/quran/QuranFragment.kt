package e.muslim.prayer.presentation.quran

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import e.muslim.prayer.R
import e.muslim.prayer.databinding.FragmentQuranBinding
import e.muslim.prayer.presentation.main.MainViewModel
import e.muslim.prayer.utils.base_classes.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuranFragment :
    BaseBindingFragment<FragmentQuranBinding, MainViewModel>(R.layout.fragment_quran) {
    override val vm: MainViewModel by viewModel()
    private var adapter: QuranViewPagerAdapter? = null

    override fun initViews(savedInstanceState: Bundle?) {
        binding.run {
            setupOnClickListener()

            adapter = QuranViewPagerAdapter(
                childFragmentManager,
                FragmentPagerItems.with(context)
                    .add(R.string.surah, SuraListFragment::class.java)
                    .add(R.string.para, SuraListFragment::class.java)
                    .add(R.string.booksmarks_main, SuraListFragment::class.java).create()
            )
            pager.adapter = adapter
            liquidSwipeTab.setViewPager(pager)
            pager.isSaveEnabled = false
        }
    }

    private fun setupOnClickListener() {
        binding.run {
            statistics.setOnClickListener {
                it.click {
                    findNavController().navigate(R.id.action_quran_to_statistics)
                }
            }
            search.setOnClickListener {
                it.click {
                    findNavController().navigate(R.id.action_quran_to_search)
                }
            }
            goTo.setOnClickListener {
                it.click {

                }
            }
        }
    }
}