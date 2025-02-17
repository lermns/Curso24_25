package com.example.demo_3.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_3.databinding.ListitemUserBinding
import com.example.demo_3.model.User

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
