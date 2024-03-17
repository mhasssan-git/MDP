package com.miu.problem1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FoodPreferencesActivity : AppCompatActivity() {
    private lateinit var rgFavCuisine: RadioGroup
    private lateinit var rgEatFreq: RadioGroup
    private lateinit var rgSpicyFood: RadioGroup
    private lateinit var rgPrefVeg: RadioGroup
    private lateinit var rgPrefSea: RadioGroup
    private lateinit var btnSubmit: Button
    private lateinit var tvOutput:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_preferences)
        initView()
        populateRadioGroup()
        btnSubmit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                tvOutput.text= getRadioValue()
            }

        })
    }

    private fun initView() {
        rgFavCuisine = findViewById(R.id.rgFavCuisine)
        rgEatFreq = findViewById(R.id.rgEatFreq)
        rgSpicyFood = findViewById(R.id.rgSpicyFood)
        rgPrefVeg = findViewById(R.id.rgPrefVeg)
        rgPrefSea = findViewById(R.id.rgPrefSea)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvOutput=findViewById(R.id.tvOutput)
    }

    private fun populateRadioGroup() {
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

    private fun getRadioValue(): String {
        var selectedRBId=rgFavCuisine.checkedRadioButtonId
        var selectedRB:RadioButton
        var selectedValue:String=""
        var question:String=""
        var output:String=""
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.what_is_your_favorite_cuisine)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgEatFreq.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.how_often_do_you_eat_out)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgSpicyFood.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_prefer_spicy_food)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgPrefVeg.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_prefer_vegetarian_food)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgPrefSea.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_like_seafood)
            output+="$question : $selectedValue"
        }
        return output;
    }


}