package com.example.labs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.model.Person

class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name, current.idade, current.email)
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val personNameView: TextView = itemView.findViewById(R.id.textView)
        private val personEmailView: TextView = itemView.findViewById(R.id.textViewEmail)

        fun bind(name: String?, idade: String, email: String?) {
            personNameView.text = "$name-$idade"
            personEmailView.text = email
        }

        companion object {
            fun create(parent: ViewGroup): PersonViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return PersonViewHolder(view)
            }
        }
    }

    class PersonsComparator : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }
    }
}