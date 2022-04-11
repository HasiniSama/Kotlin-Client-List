package com.kln.android.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kln.android.myapplication.R
import com.kln.android.myapplication.model.ClientsViewModel

class ClientListAdapter(private val mList: List<ClientsViewModel>) : RecyclerView.Adapter<ClientListAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.name.text = ItemsViewModel.name
        holder.lat.text = "Lat: "+ ItemsViewModel.lat
        holder.long.text = "Lgt: "+ ItemsViewModel.long

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.nameTextView)
        val lat: TextView = itemView.findViewById(R.id.latTextView)
        val long: TextView = itemView.findViewById(R.id.lngTextView)
    }
}
