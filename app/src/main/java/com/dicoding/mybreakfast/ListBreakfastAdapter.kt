package com.dicoding.mybreakfast

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBreakfastAdapter(private val listBreakfast: ArrayList<Breakfast>): RecyclerView.Adapter<ListBreakfastAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_breakfast, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val dataBreakfast = listBreakfast[position]
        Glide.with(holder.itemView.context)
            .load(dataBreakfast.pic)
            .apply(RequestOptions())
            .into(holder.picture)
        holder.name.text = dataBreakfast.name
        holder.description.text = dataBreakfast.description
        holder.itemView.setOnClickListener {
            val passItem = Intent(context, DetailActivity::class.java)
            passItem.putExtra(DetailActivity.EXTRA_NAME, dataBreakfast.name)
            passItem.putExtra(DetailActivity.EXTRA_DESC, dataBreakfast.description)
            passItem.putExtra(DetailActivity.EXTRA_BAHAN, dataBreakfast.bahan)
            passItem.putExtra(DetailActivity.EXTRA_STEP, dataBreakfast.step)
            passItem.putExtra(DetailActivity.EXTRA_PIC, dataBreakfast.pic)
            passItem.putExtra(DetailActivity.EXTRA_LINK, dataBreakfast.menulink)
            context.startActivity(passItem)
        }
    }

    override fun getItemCount(): Int {
        return listBreakfast.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.menu_name)
        var description: TextView = itemView.findViewById(R.id.menu_desc)
        var picture: ImageView = itemView.findViewById(R.id.menu_pic)
    }
}