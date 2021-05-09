package com.matejjukic.ferit.birdscounter.models

class BirdsCounterModel() {
   var redBirdCounter = 0

 var greenBirdCounter = 0

 var blueBirdCounter = 0

 var yellowBirdCounter = 0

 val birds get() = (redBirdCounter + greenBirdCounter + blueBirdCounter + yellowBirdCounter)

    fun addRedBird() = redBirdCounter++
    fun addGreenBird() = greenBirdCounter++
    fun addBlueBird() = blueBirdCounter++
    fun addYellowBird() = yellowBirdCounter++

   fun reset(){

    redBirdCounter = 0
    greenBirdCounter = 0
    blueBirdCounter = 0
    yellowBirdCounter = 0


       }
}