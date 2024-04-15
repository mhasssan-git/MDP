package com.miu.sports

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.miu.sports.databinding.DialogSportsAddLayoutBinding

class SportAddDialogFragment : AddDialogFragment() {
    private lateinit var spSpinner: Spinner
    private lateinit var name: EditText
    private lateinit var instruction: EditText
    override fun onOkButtonSubmit() {
        _listner.saveData(
            Sport(
                spSpinner.selectedItem.toString(),
                name.text.toString(), instruction.text.toString()
            )
        )
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        SetLayout(R.layout.dialog_sports_add_layout)
        val builder = super.onCreateDialog(savedInstanceState)
        spSpinner = getDialogView().findViewById<Spinner>(R.id.spSportsType)
        name = getDialogView().findViewById<EditText>(R.id.name)
        instruction = getDialogView().findViewById<EditText>(R.id.instruction)
        return builder;
    }
}