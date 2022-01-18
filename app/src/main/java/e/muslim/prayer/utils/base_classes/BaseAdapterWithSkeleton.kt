package e.muslim.prayer.utils.base_classes

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import e.muslim.prayer.utils.LOADED
import e.muslim.prayer.utils.NOT_LOADED
import e.muslim.prayer.utils.inflate

abstract class BaseAdapterWithSkeleton<T>(
    @LayoutRes val layoutID: Int,
    @LayoutRes val skeletonId: Int
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var type = NOT_LOADED

    var items = arrayListOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    open fun setData(data: List<T>) {
        type = LOADED
        items.clear()
        items.addAll(data as ArrayList<T>)
        notifyDataSetChanged()
    }

    open fun setDataWithoutNotify(data: List<T>) {
        type = LOADED
        //tell the recycler view that all the old items are one
        val initialSize = items.size
        if (items.isNotEmpty())
            items.clear()
        items = data as ArrayList<T>
        //tell the recycler view how many new items we added
        notifyItemRangeInserted(initialSize, items.size - 1)
    }

    override fun getItemViewType(position: Int): Int = type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (NOT_LOADED == type) {
            SkeletonVH(parent.inflate(skeletonId))
        } else {
            ViewHolder(parent.inflate(layoutID))
        }


    override fun getItemCount(): Int = if (type == NOT_LOADED) 5 else items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.apply {
                bindViewHolder(this, items[holder.bindingAdapterPosition])
            }
        }
    }

    abstract fun bindViewHolder(holder: ViewHolder, data: T)

}

class SkeletonVH(view: View) : RecyclerView.ViewHolder(view)