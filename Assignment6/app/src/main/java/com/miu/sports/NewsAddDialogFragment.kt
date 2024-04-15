package com.miu.sports

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.miu.sports.databinding.DialogNewsAddLayoutBinding
import com.miu.sports.databinding.DialogSportsAddLayoutBinding

class NewsAddDialogFragment : AddDialogFragment() {

    private lateinit var etImageUrl: EditText
    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    override fun onOkButtonSubmit() {
        _listner.saveData(
            News(
                etImageUrl.text.toString(),
                etTitle.text.toString(), etDescription.text.toString()
            )
        )
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        SetLayout(R.layout.dialog_news_add_layout)
        val builder = super.onCreateDialog(savedInstanceState)
        etImageUrl = getDialogView().findViewById<EditText>(R.id.etImageUrl)
        etTitle = getDialogView().findViewById<EditText>(R.id.etTitle)
        etDescription = getDialogView().findViewById<EditText>(R.id.etDescription)
        return builder;
    }


}