package com.matejjukic.ferit.birdscounter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.matejjukic.ferit.birdscounter.R
import com.matejjukic.ferit.birdscounter.databinding.ActivityMainBinding
import com.matejjukic.ferit.birdscounter.preferences.SharedPreferences


import com.matejjukic.ferit.birdscounter.viewmodel.BirdsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val birdsViewModel by viewModel<BirdsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.birdsViewModel = birdsViewModel
        binding.lifecycleOwner = this
        setup()
    }

  fun setup(){
        binding.apply {
            btnRedBird.setOnClickListener {  onClick(btnRedBird.id) }
            btnGreenBird.setOnClickListener {  onClick(btnGreenBird.id) }
            btnBlueBird.setOnClickListener {  onClick(btnBlueBird.id)}
            btnYellowBird.setOnClickListener {  onClick(btnYellowBird.id) }
            btnReset.setOnClickListener {  onClick(btnReset.id) }
        }

    }

    private fun onClick( id: Int){
        binding.apply {


            when (id){
                btnReset.id -> {
                   birdsViewModel?.reset()
                   
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.white))

                }
                btnRedBird.id -> {
                    birdsViewModel?.addRedBird()
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.red))

                }
                btnGreenBird.id -> {
                    birdsViewModel?.addGreenBird()
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.green))

                }
                btnBlueBird.id -> {
                    birdsViewModel?.addBlueBird()
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.blue))

                }
                btnYellowBird.id -> {
                    birdsViewModel?.addYellowBird()
                    tvBirdCounter.setBackgroundColor(resources.getColor(R.color.yellow))

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if(SharedPreferences.getCounter() != 0) {
            birdsViewModel.loadSharedPreferences()
        }
        binding.tvBirdCounter.setBackgroundColor(resources.getColor(SharedPreferences.getColor()))
    }



}