package com.matejjukic.ferit.birdscounter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.matejjukic.ferit.birdscounter.R
import com.matejjukic.ferit.birdscounter.models.BirdsCounterModel
import com.matejjukic.ferit.birdscounter.preferences.SharedPreferences

class BirdsViewModel (private val birdsCounter: BirdsCounterModel) : ViewModel() {



    private val _redBirds = MutableLiveData(birdsCounter.redBirdCounter)
    val redBirds: LiveData<Int> = _redBirds

    private val _greenBirds = MutableLiveData(birdsCounter.greenBirdCounter)
    val greenBirds: LiveData<Int> = _greenBirds

    private val _blueBirds = MutableLiveData(birdsCounter.blueBirdCounter)
    val blueBirds: LiveData<Int> = _blueBirds

    private val _yellowBirds = MutableLiveData(birdsCounter.yellowBirdCounter)
    val yellowBirds: LiveData<Int> = _yellowBirds

    private val _birds = MutableLiveData(birdsCounter.birds)
    val birds: LiveData<Int> = _birds


    fun addRedBird() {

            birdsCounter.addRedBird()
           _redBirds.postValue(birdsCounter.redBirdCounter)
            _birds.postValue(birdsCounter.birds)
            SharedPreferences.saveRBCounter(birdsCounter.redBirdCounter)
            SharedPreferences.saveCounter(birdsCounter.birds)
            SharedPreferences.saveColor(R.color.red)

    }
    fun addGreenBird() {


            birdsCounter.addGreenBird()
            _greenBirds.postValue(birdsCounter.greenBirdCounter)
            _birds.postValue(birdsCounter.birds)
        SharedPreferences.saveGBCounter(birdsCounter.greenBirdCounter)
        SharedPreferences.saveCounter(birdsCounter.birds)
        SharedPreferences.saveColor(R.color.green)


    }

    fun addBlueBird() {
        birdsCounter.addBlueBird()
        _blueBirds.postValue(birdsCounter.blueBirdCounter)
        _birds.postValue(birdsCounter.birds)
        SharedPreferences.saveBBCounter(birdsCounter.blueBirdCounter)
        SharedPreferences.saveCounter(birdsCounter.birds)
        SharedPreferences.saveColor(R.color.blue)
    }
    fun addYellowBird() {
        birdsCounter.addYellowBird()
        _yellowBirds.postValue(birdsCounter.yellowBirdCounter)
        _birds.postValue(birdsCounter.birds)
        SharedPreferences.saveYBCounter(birdsCounter.yellowBirdCounter)
        SharedPreferences.saveCounter(birdsCounter.birds)
        SharedPreferences.saveColor(R.color.yellow)
    }
    fun reset(){
        birdsCounter.reset()
        SharedPreferences.saveRBCounter(0)
        SharedPreferences.saveRBCounter(0)
        SharedPreferences.saveRBCounter(0)
        SharedPreferences.saveRBCounter(0)
        SharedPreferences.saveCounter(0)
        SharedPreferences.saveColor(R.color.white)
        postValues()
    }

    fun loadSharedPreferences(){
        birdsCounter.redBirdCounter = SharedPreferences.getRBCounter()
        birdsCounter.greenBirdCounter = SharedPreferences.getGBCounter()
        birdsCounter.blueBirdCounter = SharedPreferences.getBBCounter()
        birdsCounter.yellowBirdCounter = SharedPreferences.getYBCounter()
        postValues()

    }
    private fun postValues(){
        _redBirds.postValue(birdsCounter.redBirdCounter)
        _greenBirds.postValue(birdsCounter.greenBirdCounter)
        _blueBirds.postValue(birdsCounter.blueBirdCounter)
        _yellowBirds.postValue(birdsCounter.yellowBirdCounter)

    }
}
