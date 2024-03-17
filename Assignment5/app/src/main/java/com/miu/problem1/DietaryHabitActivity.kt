package com.miu.problem1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.miu.problem1.databinding.ActivityDietaryHabitBinding

class DietaryHabitActivity : AppCompatActivity() {

    private lateinit var rgIsVeg: RadioGroup
    private lateinit var rfPrefOrganic: RadioGroup
    private lateinit var rgConsumeDairy: RadioGroup
    private lateinit var rgEatFastFood: RadioGroup
    private lateinit var rgAllergies: RadioGroup
    private lateinit var btnSubmit: Button
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietary_habit)
        initView()
        populateRadioGroup()
        btnSubmit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                tvOutput.text= getRadioValue()
            }
        })

    }
    private fun initView() {
        rgIsVeg = findViewById(R.id.rgIsVeg)
        rfPrefOrganic = findViewById(R.id.rfPrefOrganic)
        rgConsumeDairy = findViewById(R.id.rgConsumeDairy)
        rgEatFastFood = findViewById(R.id.rgEatFastFood)
        rgAllergies = findViewById(R.id.rgAllergies)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvOutput=findViewById(R.id.tvOutput)
    }

    private fun populateRadioGroup() {
        val survey_is_veg = resources.getStringArray(R.array.survey_is_veg)
        for (item in survey_is_veg) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgIsVeg.addView(radioButton)
        }

        val survey_prefs_organic = resources.getStringArray(R.array.survey_prefs_organic)
        for (item in survey_prefs_organic) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rfPrefOrganic.addView(radioButton)
        }

        val survey_prefs_dairy = resources.getStringArray(R.array.survey_prefs_dairy)
        for (item in survey_prefs_dairy) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgConsumeDairy.addView(radioButton)
        }

        val survey_prefs_fast_food = resources.getStringArray(R.array.survey_prefs_fast_food)
        for (item in survey_prefs_fast_food) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgEatFastFood.addView(radioButton)
        }

        val survey_have_allergies = resources.getStringArray(R.array.survey_have_allergies)
        for (item in survey_have_allergies) {
            val radioButton = RadioButton(this)
            radioButton.text = item
            rgAllergies.addView(radioButton)
        }
    }
    private fun getRadioValue(): String {
        var selectedRBId=rgIsVeg.checkedRadioButtonId
        var selectedRB: RadioButton
        var selectedValue:String=""
        var question:String=""
        var output:String=""
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.are_you_veg)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rfPrefOrganic.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_prefer_organic_food)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgConsumeDairy.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_consume_dairy)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgEatFastFood.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_eat_fast_food)
            output+="$question : $selectedValue \n"
        }
        selectedRBId=rgAllergies.checkedRadioButtonId
        if(selectedRBId!=-1)
        {
            selectedRB=findViewById<RadioButton>(selectedRBId)
            selectedValue= selectedRB.text.toString()
            question=resources.getString(R.string.do_you_have_allergies)
            output+="$question : $selectedValue"
        }
        return output;
    }

}