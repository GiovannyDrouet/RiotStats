package com.giovannydrouet.riotstats.presentation.recylcerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.giovannydrouet.riotstats.R
import com.giovannydrouet.riotstats.domain.model.Champion
import com.squareup.picasso.Picasso

class ChampionListAdapter(
    private val itemAction: (id : String) -> Unit
) : RecyclerView.Adapter<ChampionListAdapter.ViewHolder>() {

    var dataList = emptyList<Champion>()

    internal fun setDataList(dataList: List<Champion>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var cardView: CardView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            cardView = itemView.findViewById(R.id.cardView)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.champion_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get the data model based on position
        val data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.name
        Picasso.get().load(data.image).into(holder.image)
        holder.cardView.setOnClickListener { itemAction(data.id) }
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}