package com.miu.sports

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import com.miu.sports.databinding.DialogAtheleteAddLayoutBinding
import com.miu.sports.databinding.DialogNewsAddLayoutBinding

class AtheleteAddDialogFragment : AddDialogFragment() {
    private lateinit var _binding: DialogAtheleteAddLayoutBinding
    override fun onOkButtonSubmit() {
        _listner.saveData(
            Athlete(
                _binding.etName.text.toString(),
                _binding.etSport.text.toString(), _binding.etCountry.text.toString(),
                _binding.etPersonalBest.text.toString(),
                _binding.etAward.text.toString(), _binding.etFact.text.toString()
            )
        )
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogAtheleteAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
        return super.onCreateDialog(savedInstanceState)
    }
}