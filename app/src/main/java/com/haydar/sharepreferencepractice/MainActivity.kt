package com.haydar.sharepreferencepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haydar.sharepreferencepractice.databinding.ActivityMainBinding
import com.haydar.sharepreferencepractice.helper.Constant
import com.haydar.sharepreferencepractice.helper.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)
        binding.btnSave.setOnClickListener { onClick() }
        binding.btnShow.setOnClickListener { showText() }
    }

    private fun showText() {
        binding.tvName.text = preferenceHelper.getString(Constant.PREF_NAME)
    }

    private fun onClick() {
        if (binding.inputName.text.isNotEmpty()){
            preferenceHelper.put(Constant.PREF_NAME,binding.inputName.text.toString())
            preferenceHelper.put(Constant.PREF_IS_SEE,true)
        }
    }

    override fun onStart() {
        super.onStart()
        if (preferenceHelper.getBoolean(Constant.PREF_IS_SEE)){
            showText()
        }
    }


}