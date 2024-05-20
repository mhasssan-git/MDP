package com.miu.animalkingdomexplorer.ui.animaldetails

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
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
import com.miu.animalkingdomexplorer.databinding.DialogAnimalAddLayoutBinding
import com.miu.animalkingdomexplorer.ui.AddDialogFragment
import kotlinx.coroutines.launch
import java.util.Calendar

class AnimalAddDialogFragment : AddDialogFragment() {

    private lateinit var _binding: DialogAnimalAddLayoutBinding
    override fun onOkButtonSubmit():Boolean {
        var animal=Animal(
            name = _binding.etName.text.toString(),
            habitat = _binding.etHabitate.text.toString(),
            diet = _binding.etDiet.text.toString()
        )
        var isValid:Boolean=true
        if(animal.name.isNullOrBlank())
        {
            isValid=false
            _binding.etName.setBackgroundResource(R.drawable.red_border)
        }
        if(animal.habitat.isNullOrBlank())
        {
            isValid=false
            _binding.etHabitate.setBackgroundResource(R.drawable.red_border)
        }
        if(animal.diet.isNullOrBlank())
        {
            isValid=false
            _binding.etDiet.setBackgroundResource(R.drawable.red_border)
        }
        if(isValid) {
            launch {
                _listner.saveData(
                    animal
                )
            }
        }
        return isValid
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogAnimalAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
         _binding.etName.addTextChangedListener(object:TextWatcher{
             override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

             }
             override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 _binding.etName.setBackgroundResource(R.drawable.rounded_edittext_bg)
             }
             override fun afterTextChanged(s: Editable?) {

             }

         })
        _binding.etDiet.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _binding.etDiet.setBackgroundResource(R.drawable.rounded_edittext_bg)
            }
            override fun afterTextChanged(s: Editable?) {

            }

        })
        _binding.etHabitate.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _binding.etHabitate.setBackgroundResource(R.drawable.rounded_edittext_bg)
            }
            override fun afterTextChanged(s: Editable?) {

            }

        })
        return super.onCreateDialog(savedInstanceState)

    }


}