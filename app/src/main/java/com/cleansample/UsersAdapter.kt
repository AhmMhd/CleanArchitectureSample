package com.cleansample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cleansample.databinding.LiUserBinding
import com.domain.model.User

class UsersAdapter(var list: List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LiUserBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.li_user,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = list[position]
        holder.binding.executePendingBindings()
    }

    class ViewHolder(var binding: LiUserBinding) : RecyclerView.ViewHolder(binding.root)
}