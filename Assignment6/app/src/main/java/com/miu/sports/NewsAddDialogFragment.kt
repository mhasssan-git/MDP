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

    private lateinit var _binding: DialogNewsAddLayoutBinding
    override fun onOkButtonSubmit() {
        _listner.saveData(
            News(
                _binding.etImageUrl.text.toString(),
                _binding.etTitle.text.toString(),
                _binding.etDescription.text.toString()
            )
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogNewsAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
        return super.onCreateDialog(savedInstanceState)

    }


}