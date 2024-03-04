package com.miu.wrd

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var etwrn:EditText
    lateinit var etLocation:EditText
    lateinit var etType:EditText
    lateinit var btnAdd:Button
    lateinit var tl:TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun btnAdd_click(view: View)
    {
        val _wrn=etwrn.text.toString();
        val _location=etLocation.text.toString();
        val _type=etType.text.toString();
        buildRow(tl,_wrn,_location,_type);
    }
    private fun initView()
    {
        etwrn=findViewById(R.id.etwrn)
        etLocation=findViewById(R.id.etLocation)
        etType=findViewById(R.id.etType)
        btnAdd=findViewById(R.id.btnAdd)
        tl=findViewById(R.id.tl)
    }
    fun buildRow(table:TableLayout,wrn:String,location:String,type:String)
    {
        val tvwrn= TextView(this)
        tvwrn.text=wrn
        setBorder(tvwrn)
        val tvlocation=TextView(this)
        tvlocation.text=location
        setBorder(tvlocation)
        val tvType=TextView(this)
        tvType.text=type;
        setBorder(tvType)
        val row= TableRow(this)
        setBorder(row)
        row.addView(tvwrn)
        row.addView(tvlocation)
        row.addView(tvType)
        table.addView(row)

    }
    fun setBorder(borderedView:View)
    {
       borderedView.setBackgroundResource(R.drawable.simpleborder)
    }
}