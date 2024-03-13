package com.sebastian.project.ui.principal.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sebastian.project.data.EventsData
import com.sebastian.project.databinding.ItemsEventsBinding

class EventsAdapter(
    private var events:List<EventsData> = emptyList(),
    private val details:(EventsData) -> Unit
) : RecyclerView.Adapter<EventsAdapter.EventsHolder>() {

    fun update(newData:List<EventsData>){
        events = newData
        notifyDataSetChanged()
    }

    inner class EventsHolder(private val binding: ItemsEventsBinding):RecyclerView.ViewHolder(binding.root){
        fun render(eventsData: EventsData, details: (EventsData) -> Unit){
            binding.apply {

                Glide.with(itemView.context).load(eventsData.image).into(imgEvent)
                txtTitle.text = eventsData.title
                txtDescription.text = eventsData.description
                txtDate.text = eventsData.date

                itemView.setOnClickListener {
                    details(eventsData)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsHolder {
        return EventsHolder(ItemsEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventsHolder, position: Int) {
        holder.render(events[position], details)
    }

}