package e.muslim.prayer.presentation.quran

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.collection.SparseArrayCompat
import java.lang.ref.WeakReference
import android.view.ViewGroup
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.lang.ClassLoader

open class QuranViewPagerAdapter(fm: FragmentManager?, private val pages: FragmentPagerItems) :
    FragmentStatePagerAdapter(
        fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    private val holder: SparseArrayCompat<WeakReference<Fragment>> = SparseArrayCompat(pages.size)
    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return getPagerItem(position).instantiate(pages.context, position)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = super.instantiateItem(container, position)
        if (item is Fragment) {
            holder.put(position, WeakReference(item))
        }
        return item
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        holder.remove(position)
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getPagerItem(position).title
    }


    private fun getPagerItem(position: Int): FragmentPagerItem {
        return pages[position]
    }
}