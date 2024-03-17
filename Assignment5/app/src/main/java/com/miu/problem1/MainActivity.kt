package com.miu.problem1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private lateinit var rgPreference: RadioGroup
    private lateinit var btnSubmit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadSurveyRadiobutton()
        btnSubmit=findViewById(R.id.btnSubmit)
        val intent= Intent(this,FoodPreferencesActivity::class.java)
        btnSubmit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(intent)
            }

        })
    }
    private fun loadSurveyRadiobutton() {
        rgPreference = findViewById(R.id.rgPreference)
        val surveyPrefsArrayStr = resources.getStringArray(R.array.survey_prefs_array)
        for ((index, element) in surveyPrefsArrayStr.withIndex()) {
            val rb = this.rgPreference[index] as RadioButton
            rb.text = element
            println("Index: $index, Element: $element")
        }
    }
}