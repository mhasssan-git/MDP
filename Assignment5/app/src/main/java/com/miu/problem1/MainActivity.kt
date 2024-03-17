package com.miu.problem1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private lateinit var rgPreference: RadioGroup
    private lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadSurveyRadiobutton()
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var selectedRBId = rgPreference.checkedRadioButtonId
                if (selectedRBId != -1) {
                    val selectedRB = findViewById<RadioButton>(selectedRBId)
                    val surveyPrefsArrayStr = resources.getStringArray(R.array.survey_prefs_array)
                    if (selectedRB.text.equals(surveyPrefsArrayStr[0])) {
                        val foodIntent =Intent(this@MainActivity, FoodPreferencesActivity::class.java)

                        startActivity(foodIntent)
                    } else {
                        val dietaryIntent =Intent(this@MainActivity, DietaryHabitActivity::class.java)
                        startActivity(dietaryIntent)
                    }
                } else {
                    Toast.makeText(
                        this@MainActivity, "Please select one option",
                        Toast.LENGTH_LONG
                    ).show()
                }

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