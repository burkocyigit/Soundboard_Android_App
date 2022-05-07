package com.example.soundboard

import android.media.SoundPool
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soundboard.databinding.RecyclerCellBinding

class RecyclerAdapter(private val soundList : ArrayList<Sound>, private val soundPool: SoundPool): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding : RecyclerCellBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cellTextView.text = soundList.get(position).name

        holder.binding.cellTextView.setOnClickListener {
            soundPool.play(soundList[position].sound, 1F, 1F, 0, 0, 1F)
        }
    }

    override fun getItemCount(): Int = soundList.size
}