package com.example.qoutes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context):ViewModel() {
    private var qouteList :Array<Qoute> = emptyArray()
    private var index = 0

    init {
        qouteList = loadQoutesFromAssets()
    }

    private fun loadQoutesFromAssets(): Array<Qoute> {
        val inputStream = context.assets.open("qoutes.json")
        val size:Int =  inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Qoute>::class.java)


    }

    fun getQoute() =qouteList[index]

    fun nextQoute()  = qouteList[++index]
    fun previousQoute()  = qouteList[--index]
}