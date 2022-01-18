package e.muslim.prayer.utils.base_classes

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import e.muslim.prayer.utils.inflate

abstract class BaseAdapter<T>(@LayoutRes val layoutID: Int) : RecyclerView.Adapter<ViewHolder>() {

    var items = listOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    open fun setData(data: List<T>) {
        items = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(layoutID))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            bindViewHolder(this, items[holder.bindingAdapterPosition])
        }
    }

    abstract fun bindViewHolder(holder: ViewHolder, data: T)

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)