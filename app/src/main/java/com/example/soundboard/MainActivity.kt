package com.example.soundboard

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soundboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool : SoundPool
    private lateinit var binding : ActivityMainBinding
    private lateinit var soundList : ArrayList<Sound>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        soundList = ArrayList()

        soundInit()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(soundList.size)
            .setAudioAttributes(audioAttributes)
            .build()


        soundLoad()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = RecyclerAdapter(soundList, soundPool)
        }
    }

    private fun soundLoad() {
        soundList[0].sound = soundPool.load(this, R.raw.fart_sulu, 1)
        soundList[1].sound = soundPool.load(this, R.raw.fart_reverb, 1)
        soundList[2].sound = soundPool.load(this, R.raw.fart_quick_reverb, 1)
        soundList[3].sound = soundPool.load(this, R.raw.vine_boom, 1)
        soundList[4].sound = soundPool.load(this, R.raw.auugh, 1)
        soundList[5].sound = soundPool.load(this, R.raw.levo_tf, 1)
        soundList[6].sound = soundPool.load(this, R.raw.hayirli_nobetler, 1)
        soundList[7].sound = soundPool.load(this, R.raw.bohohoyt, 1)
    }

    private fun soundInit() {
        val soundDiarrhea = Sound("Diarrhea", R.raw.fart_sulu)
        val soundQuick = Sound("Quick", R.raw.fart_quick_reverb)
        val soundReverb = Sound("Reverb", R.raw.fart_reverb)
        val soundBoom = Sound("Vine Boom", R.raw.vine_boom)
        val soundAuugh = Sound("Auugh", R.raw.auugh)
        val soundLevo = Sound("Levo Tieff", R.raw.levo_tf)
        val soundPal = Sound("Hayırlı Nöbetler", R.raw.hayirli_nobetler)
        val soundBohohoyt = Sound("Böhöhöyt", R.raw.bohohoyt)

        soundList.add(soundDiarrhea)
        soundList.add(soundQuick)
        soundList.add(soundReverb)
        soundList.add(soundBoom)
        soundList.add(soundAuugh)
        soundList.add(soundLevo)
        soundList.add(soundPal)
        soundList.add(soundBohohoyt)
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}