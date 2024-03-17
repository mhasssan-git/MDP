package com.miu.problem1

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class FoodPreferencesActivity : AppCompatActivity() {
    private lateinit var rgFavCuisine: RadioGroup
    private lateinit var rgEatFreq: RadioGroup
    private lateinit var rgSpicyFood: RadioGroup
    private lateinit var rgPrefVeg: RadioGroup
    private lateinit var rgPrefSea: RadioGroup
    private lateinit var btnSubmit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_preferences)
        initView()
        populateRadioGroup()
    }
    private fun initView()
    {
        rgFavCuisine=findViewById(R.id.rgFavCuisine)
        rgEatFreq=findViewById(R.id.rgEatFreq)
        rgSpicyFood=findViewById(R.id.rgSpicyFood)
        rgPrefVeg=findViewById(R.id.rgPrefVeg)
        rgPrefSea=findViewById(R.id.rgPrefSea)
        btnSubmit=findViewById(R.id.btnSubmit)
    }
    private fun populateRadioGroup(){
        val survey_fav_cuisine = resources.getStringArray(R.array.survey_fav_cuisine)
        for (item in survey_fav_cuisine) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgFavCuisine.addView(radioButton)
        }

        val survey_eat_frequency = resources.getStringArray(R.array.survey_eat_frequency)
        for (item in survey_eat_frequency) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgEatFreq.addView(radioButton)
        }

        val survey_prefs_spicy = resources.getStringArray(R.array.survey_prefs_spicy)
        for (item in survey_prefs_spicy) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgSpicyFood.addView(radioButton)
        }

        val survey_prefs_veg = resources.getStringArray(R.array.survey_prefs_veg)
        for (item in survey_prefs_veg) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgPrefVeg.addView(radioButton)
        }

        val survey_prefs_seafood = resources.getStringArray(R.array.survey_prefs_seafood)
        for (item in survey_prefs_seafood) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgPrefSea.addView(radioButton)
        }
    }


}