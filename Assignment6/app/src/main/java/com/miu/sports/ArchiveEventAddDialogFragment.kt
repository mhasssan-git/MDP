package com.miu.sports

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.miu.sports.databinding.DialogEventsAddLayoutBinding
import com.miu.sports.databinding.DialogEventsArchiveAddLayoutBinding
import com.miu.sports.databinding.DialogNewsAddLayoutBinding
import com.miu.sports.databinding.DialogSportsAddLayoutBinding
import java.text.DateFormatSymbols
import java.util.Calendar

@Suppress("NAME_SHADOWING")
class ArchiveEventAddDialogFragment : AddDialogFragment() {

    private lateinit var _binding: DialogEventsArchiveAddLayoutBinding
    override fun onOkButtonSubmit() {
        _listner.saveData(
            Event(
                _binding.etEventName.text.toString(),
                _binding.tvDate.text.toString(),
                _binding.etDescription.text.toString()
            )
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        _binding = DialogEventsArchiveAddLayoutBinding.inflate(inflater)
        setDialogView(_binding.root)
        _binding.tvDate.setOnClickListener { v ->
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                    val dfs=DateFormatSymbols()
                    val selectedMonth=dfs.months[selectedMonth]

                    val selectedDate = "$selectedMonth ${selectedDay}, $selectedYear"
                    _binding.tvDate.text = selectedDate
                },
                year,
                month,
                day
            )
            datePickerDialog.datePicker.minDate = getMinimumDate()
            datePickerDialog.show()
        }

        return super.onCreateDialog(savedInstanceState)

    }

    private fun getMinimumDate(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(1800, 0, 1) // Set the minimum date to January 1, 1800
        return calendar.timeInMillis
    }
}