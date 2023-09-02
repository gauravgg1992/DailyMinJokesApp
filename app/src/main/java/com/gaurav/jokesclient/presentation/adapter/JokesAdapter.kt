package com.gaurav.jokesclient.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.jokesclient.R
import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.databinding.JokeListItemBinding
import java.util.*

class JokesAdapter:RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<APIResponse>(){
        override fun areItemsTheSame(oldItem: APIResponse, newItem: APIResponse): Boolean {
            return oldItem.joke == newItem.joke
        }

        override fun areContentsTheSame(oldItem: APIResponse, newItem: APIResponse): Boolean {
           return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding = JokeListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return JokesViewHolder(binding)
    }



    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        val apiResponse = differ.currentList[position]
        holder.bind(apiResponse)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class JokesViewHolder(
        val binding: JokeListItemBinding
    ):
        RecyclerView.ViewHolder(binding.root){
           fun bind(apiResponse: APIResponse){
               Log.i("MYTAG","came here ${apiResponse.joke}")

               binding.ivImage.animation=AnimationUtils.loadAnimation(binding.root.context, R.anim.fade_transition_animation)
               binding.container.animation=AnimationUtils.loadAnimation(binding.root.context, R.anim.scale_transition_animation)

               binding.tvDescription.text = apiResponse.joke
               binding.tvTime.text= Date(apiResponse.createdAt).toString()

               }
           }
        }

        private var onItemClickListener :((APIResponse)->Unit)?=null

        fun setOnItemClickListener(listener : (APIResponse)->Unit){
            onItemClickListener = listener
        }












