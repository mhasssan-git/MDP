package com.miu.animalkingdomexplorer.ui.speciesdetails

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.provider.Settings.Global
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Species
import com.miu.animalkingdomexplorer.databinding.DialogAnimalAddLayoutBinding
import com.miu.animalkingdomexplorer.databinding.DialogSpeciesAddLayoutBinding
import com.miu.animalkingdomexplorer.ui.AddDialogFragment
import kotlinx.coroutines.launch
import java.util.Calendar

class SpeciesAddDialogFragment : AddDialogFragment() {

    private lateinit var _binding: DialogSpeciesAddLayoutBinding
    override fun onOkButtonSubmit() {
        launch {
            _listner.saveData(
                Species(
                    name = _binding.etName.text.toString(),
                    description = _binding.etDescription.text.toString()
                )
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogSpeciesAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
        return super.onCreateDialog(savedInstanceState)

    }


}