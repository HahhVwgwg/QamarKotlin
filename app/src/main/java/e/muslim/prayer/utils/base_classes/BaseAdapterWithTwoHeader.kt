package e.muslim.prayer.utils.base_classes

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import e.muslim.prayer.utils.HEADER
import e.muslim.prayer.utils.SIMPLE
import e.muslim.prayer.utils.inflate

abstract class BaseAdapterWithTwoHeader<T>(
    @LayoutRes val layoutID: Int,
    @LayoutRes val layoutHeaderID: Int
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var headerPosition = HashSet<Int>()

    var items = arrayListOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    open fun setData(data: List<T>, positions: HashSet<Int>) {
        items.clear()
        items.addAll(data as ArrayList<T>)
        headerPosition.clear()
        headerPosition.addAll(positions)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int =
        if (headerPosition.contains(position)) HEADER else SIMPLE


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            HEADER -> {
                HeaderViewHolder(parent.inflate(layoutHeaderID))
            }
            else -> {
                ViewHolder(parent.inflate(layoutID))
            }
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.apply {
                    bindViewHolder(this, items[holder.bindingAdapterPosition])
                }
            }
            is HeaderViewHolder -> {
                holder.apply {
                    bindViewHolderHeader(this, items[holder.bindingAdapterPosition])
                }
            }
        }
    }

    abstract fun bindViewHolder(holder: ViewHolder, data: T)
    abstract fun bindViewHolderHeader(holder: HeaderViewHolder, data: T)

}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
