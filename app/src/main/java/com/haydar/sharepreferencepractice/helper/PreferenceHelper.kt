package com.haydar.sharepreferencepractice.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val PREF_NAME = "myPref"
    private val sharedPreferences:SharedPreferences
    val editor:SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
    fun put(key:String,value:String){
        editor.putString(key,value)
        editor.apply()
    }

    fun getString(key:String):String?{
        return sharedPreferences.getString(key,null)
    }

    fun put(key:String,value:Boolean){
        editor.putBoolean(key,value)
        editor.apply()
    }

    fun getBoolean(key: String):Boolean{
        return sharedPreferences.getBoolean(key,false)
    }

    fun clear(){
        editor.clear().apply()
    }

}