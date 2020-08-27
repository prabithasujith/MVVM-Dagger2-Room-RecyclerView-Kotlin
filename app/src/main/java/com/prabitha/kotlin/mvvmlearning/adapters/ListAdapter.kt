package com.prabitha.kotlin.mvvmlearning.adapters

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prabitha.kotlin.mvvmlearning.R
import com.prabitha.kotlin.mvvmlearning.models.DataModel
import javax.inject.Inject

var inflater: LayoutInflater? = null
class ListAdapter(): RecyclerView.Adapter<ItemViewHolder>()


{

    var datamodels= listOf<DataModel>()

    init {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView =   LayoutInflater.from(parent.context). inflate(R.layout.list_item, parent, false)
       return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.wordItemView.text=datamodels[position].entryDetail
        holder.noOfItemsView.text=datamodels[position].noOfItems.toString()
    }


    fun setData(data: List<DataModel>)
    {
        this.datamodels=data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {

        if(null==datamodels)
            return 0
        else
     return datamodels.size
    }


}


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val wordItemView: TextView = itemView.findViewById(R.id.textView)
    val noOfItemsView: TextView = itemView.findViewById(R.id.textView2)

}