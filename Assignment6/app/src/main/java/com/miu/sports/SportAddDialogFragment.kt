package com.miu.sports

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.miu.sports.databinding.DialogSportsAddLayoutBinding
import com.miu.sports.databinding.FragmentSportsBinding

class SportAddDialogFragment : DialogFragment() {

    private lateinit var _binding:DialogSportsAddLayoutBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_sports_add_layout, null)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click if needed
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click if needed
                dialog.dismiss()
            }

        return builder.create()
    }



}