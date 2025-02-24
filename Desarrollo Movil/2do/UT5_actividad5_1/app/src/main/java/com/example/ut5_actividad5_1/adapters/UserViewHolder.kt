package com.example.ut5_actividad5_1.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ut5_actividad5_1.databinding.ListitemUserBinding
import com.example.ut5_actividad5_1.model.User

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val idTextView: TextView
    private val nombreTextView: TextView
    private val emailTextView: TextView
    private val binding = ListitemUserBinding.bind(itemView)

    init {
        idTextView=binding.tvId
        nombreTextView = binding.tvNombre
        emailTextView = binding.tvEmail
    }

    fun bindUser(user: User){
        idTextView.text = user.id.toString()
        nombreTextView.text = user.name
        emailTextView.text = user.email
    }
}
