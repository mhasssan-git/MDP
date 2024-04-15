package com.miu.sports

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText

class AtheleteAddDialogFragment : AddDialogFragment() {
    private lateinit var etName: EditText
    private lateinit var etSport: EditText
    private lateinit var etCountry: EditText
    private lateinit var etPersonalBest: EditText
    private lateinit var etAward: EditText
    private lateinit var etFact: EditText
    override fun onOkButtonSubmit() {
        _listner.saveData(
            Athlete(
                etName.text.toString(),
                etSport.text.toString(), etCountry.text.toString(),
                etPersonalBest.text.toString(),
                etAward.text.toString(), etFact.text.toString()
            )
        )
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        SetLayout(R.layout.dialog_athelete_add_layout)
        val builder = super.onCreateDialog(savedInstanceState)
        etName = getDialogView().findViewById<EditText>(R.id.etName)
        etSport = getDialogView().findViewById<EditText>(R.id.etSport)
        etCountry = getDialogView().findViewById<EditText>(R.id.etCountry)

        etPersonalBest = getDialogView().findViewById<EditText>(R.id.etPersonalBest)
        etAward = getDialogView().findViewById<EditText>(R.id.etAward)
        etFact = getDialogView().findViewById<EditText>(R.id.etFact)
        return builder;
    }
}