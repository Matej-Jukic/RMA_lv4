package com.matejjukic.ferit.birdscounter.preferences

import android.content.Context
import com.matejjukic.ferit.birdscounter.BirdsCounter
import com.matejjukic.ferit.birdscounter.R


object SharedPreferences {
    private const val FILE = "BirdCounterFile"
    private const val KEY_COUNTER = "KEY_COUNTER"
    private const val RB_KEY_COUNTER = "RB_KEY_COUNTER"
    private const val GB_KEY_COUNTER = "GB_KEY_COUNTER"
    private const val BB_KEY_COUNTER = "BB_KEY_COUNTER"
    private const val YB_KEY_COUNTER = "YB_KEY_COUNTER"
    private const val KEY_COLOR = "Color"

    private val preferences = BirdsCounter.context.getSharedPreferences(
        FILE, Context.MODE_PRIVATE
    )

    private val editor = preferences.edit()


    fun saveCounter(counter: Int) = editor.putInt(KEY_COUNTER, counter).apply()
    fun saveRBCounter(counter: Int) = editor.putInt(RB_KEY_COUNTER, counter).apply()
    fun saveGBCounter(counter: Int) = editor.putInt(GB_KEY_COUNTER, counter).apply()
    fun saveBBCounter(counter: Int) = editor.putInt(BB_KEY_COUNTER, counter).apply()
    fun saveYBCounter(counter: Int) = editor.putInt(YB_KEY_COUNTER, counter).apply()

    fun getCounter(): Int = preferences.getInt(KEY_COUNTER, 0)
    fun getRBCounter(): Int = preferences.getInt(RB_KEY_COUNTER, 0)
    fun getGBCounter(): Int = preferences.getInt(GB_KEY_COUNTER, 0)
    fun getBBCounter(): Int = preferences.getInt(BB_KEY_COUNTER, 0)
    fun getYBCounter(): Int = preferences.getInt(YB_KEY_COUNTER, 0)

    fun saveColor(colorId: Int) = editor.putInt(KEY_COLOR, colorId).apply()

    fun getColor(): Int = preferences.getInt(KEY_COLOR, R.color.white)
}

