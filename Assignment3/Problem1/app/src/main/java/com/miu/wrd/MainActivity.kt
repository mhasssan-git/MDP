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
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etwrn: EditText
    lateinit var etLocation: EditText
    lateinit var etType: EditText
    lateinit var btnAdd: Button
    lateinit var tl: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun btnAdd_click(view: View) {
        val _wrn = etwrn.text.toString();
        val _location = etLocation.text.toString();
        val _type = etType.text.toString();
        if (isValidate()) {
            buildRow(tl, _wrn, _location, _type);
            clearView()
        }
    }

    private fun clearView() {
        etwrn.setText("")
        etLocation.setText("")
        etType.setText("")
        etwrn.requestFocus()
    }

    private fun isValidate(): Boolean {
        var message = "";
        val txtwrn: String? = etwrn.text?.toString()?.trim();
        val txtLocation: String? = etLocation.text?.toString()?.trim();
        val txtType: String? = etType.text?.toString()?.trim();
        if (txtwrn.isNullOrEmpty()) {
            message = buildMessage(message, "Water Resource Name")
        }
        if (txtLocation.isNullOrEmpty()) {
            message = buildMessage(message, "Location")
        }
        if (txtType.isNullOrEmpty()) {
            message = buildMessage(message, "Type")
        }
        if (message.isNotEmpty()) {
            message = "Please provide $message"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            return false;
        }
        return true;
    }

    private fun buildMessage(str: String, viewStr: String?): String {
        if (str.isEmpty()) return str + viewStr;
        return "$str ,$viewStr";
    }

    private fun initView() {
        etwrn = findViewById(R.id.etwrn)
        etLocation = findViewById(R.id.etLocation)
        etType = findViewById(R.id.etType)
        btnAdd = findViewById(R.id.btnAdd)
        tl = findViewById(R.id.tl)
    }

    fun buildRow(table: TableLayout, wrn: String, location: String, type: String) {
        if (table.visibility == View.GONE)
            table.visibility = View.VISIBLE
        val tvwrn = TextView(this)
        tvwrn.text = wrn
        tvwrn.setPadding(5, 5, 5, 5)
        setBorder(tvwrn)
        val tvlocation = TextView(this)
        tvlocation.text = location
        tvlocation.setPadding(5, 5, 5, 5)
        setBorder(tvlocation)
        val tvType = TextView(this)
        tvType.text = type;
        setBorder(tvType)
        val row = TableRow(this)
        setBorder(row)
        tvType.setPadding(5, 5, 5, 5)
        row.addView(tvwrn)
        row.addView(tvlocation)
        row.addView(tvType)
        table.addView(row)

    }

    fun setBorder(borderedView: View) {
        borderedView.setBackgroundResource(R.drawable.simpleborder)
    }
}