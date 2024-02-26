package com.example.cgg

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etCguess:EditText
    private lateinit var etCName:EditText
    private lateinit var tvInfo:TextView
    var chemicals:MutableList<String> =mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        etCguess=findViewById(R.id.etCGuess)
        etCName=findViewById(R.id.etCName)
        tvInfo=findViewById(R.id.tvInfo)
    }
    @SuppressLint("SetTextI18n")
    fun clickBtnAddCName(view: View){
        val cName:String =etCName.text.toString()
        if(chemicals.contains(cName))
        {
            tvInfo.text="Chemical '$cName' is already available"
        }else
        {
            chemicals.add(cName);
            tvInfo.text="Chemical '$cName' added successfully"
        }
    }
    @SuppressLint("SetTextI18n")
    fun clickBtnGuess(view: View){
        tvInfo.text="Enter a chemical name or guess: "
        val randomCName:String=chemicals.random()
        val cGuess:String =etCguess.text.toString()
        if(randomCName.lowercase().equals(cGuess.lowercase()))
        {
            tvInfo.text="Congratulations! You guessed it right. It was $randomCName"
        }
        else{
            tvInfo.text="Sorry, wrong guess. The correnct answer was $randomCName"
        }
    }
}