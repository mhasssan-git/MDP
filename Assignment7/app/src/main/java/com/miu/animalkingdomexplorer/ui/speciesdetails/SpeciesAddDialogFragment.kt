package com.miu.animalkingdomexplorer.ui.speciesdetails

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.Settings.Global
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.miu.animalkingdomexplorer.R
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Species
import com.miu.animalkingdomexplorer.databinding.DialogAnimalAddLayoutBinding
import com.miu.animalkingdomexplorer.databinding.DialogSpeciesAddLayoutBinding
import com.miu.animalkingdomexplorer.ui.AddDialogFragment
import kotlinx.coroutines.launch
import java.util.Calendar

class SpeciesAddDialogFragment : AddDialogFragment() {

    private lateinit var _binding: DialogSpeciesAddLayoutBinding
    override fun onOkButtonSubmit(): Boolean {
        var species = Species(
            name = _binding.etName.text.toString(),
            description = _binding.etDescription.text.toString()
        )
        var isValid: Boolean = true
        if (species.name.isNullOrBlank()) {
            isValid = false
            _binding.etName.setBackgroundResource(R.drawable.red_border)
        }
        if (species.description.isNullOrBlank()) {
            isValid = false
            _binding.etDescription.setBackgroundResource(R.drawable.red_border)
        }

        if (isValid) {
            launch {
                _listner.saveData(
                    species
                )
            }
        }
        return isValid
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogSpeciesAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)


        _binding.etName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _binding.etName.setBackgroundResource(R.drawable.rounded_edittext_bg)
            }
            override fun afterTextChanged(s: Editable?) {

            }

        })
        _binding.etDescription.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _binding.etDescription.setBackgroundResource(R.drawable.rounded_edittext_bg)
            }
            override fun afterTextChanged(s: Editable?) {

            }

        })

        return super.onCreateDialog(savedInstanceState)

    }


}