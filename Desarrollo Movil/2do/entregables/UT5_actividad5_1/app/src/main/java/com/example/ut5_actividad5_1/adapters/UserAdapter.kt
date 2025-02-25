package com.example.ut5_actividad5_1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ut5_actividad5_1.R
import com.example.ut5_actividad5_1.model.User

class UserAdapter(val listUser: List<User>)
    : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //  Inflate la vista de cada fila
        val inteView = LayoutInflater.from(parent.context).inflate(
            R.layout.listitem_user,
            parent,
            false
        )
        return UserViewHolder(inteView)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.bindUser(user)
    }
}