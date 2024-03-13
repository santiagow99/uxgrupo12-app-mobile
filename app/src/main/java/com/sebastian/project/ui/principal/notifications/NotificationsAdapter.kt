package com.sebastian.project.ui.principal.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebastian.project.data.EventsData
import com.sebastian.project.databinding.ItemsNotificationsBinding

class NotificationsAdapter(private var notifications: List<EventsData> = emptyList()) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationsHolder>() {

    fun update(newData: List<EventsData>) {
        notifications = newData
        notifications
    }

    inner class NotificationsHolder(private val binding: ItemsNotificationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(eventsData: EventsData) {
            binding.apply {

                txtTitle.text = eventsData.title
                txtDescription.text = eventsData.description

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsHolder {
        return NotificationsHolder(
            ItemsNotificationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = notifications.size

    override fun onBindViewHolder(holder: NotificationsHolder, position: Int) {
        holder.render(notifications[position])
    }

}