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
import com.miu.sports.databinding.SportsItemLayoutBinding

class SportAddDialogFragment : AddDialogFragment() {
    private lateinit var _binding: DialogSportsAddLayoutBinding
    override fun onOkButtonSubmit() {
        _listner.saveData(
            Sport(
                _binding.spSportsType.selectedItem.toString(),
                _binding.name.text.toString(),
                _binding.instruction.text.toString()
            )
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogSportsAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
        return super.onCreateDialog(savedInstanceState)
    }
}