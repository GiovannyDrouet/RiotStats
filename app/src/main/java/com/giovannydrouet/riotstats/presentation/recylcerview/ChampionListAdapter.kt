package com.giovannydrouet.riotstats.presentation.recylcerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.domain.model.Champion

class ChampionListAdapter:
    RecyclerView.Adapter<ChampionListAdapter.ViewHolder>() {

    var dataList = emptyList<Champion>()

    internal fun setDataList(dataList: List<Champion>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.champion_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get the data model based on position
        val data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.name
        //holder.image.setImageResource(data.image)
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}