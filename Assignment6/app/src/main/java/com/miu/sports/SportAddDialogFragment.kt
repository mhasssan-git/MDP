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

class SportAddDialogFragment : DialogFragment() {

    private lateinit var _binding: DialogSportsAddLayoutBinding

    public interface OnAddSportsListener {
        fun saveSportsData(sport: Sport)
    }

    private lateinit var _listner: OnAddSportsListener
    public fun SetOnAddSportsListener(listener: OnAddSportsListener) {
        _listner = listener
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_sports_add_layout, null)
        val spSpinner=view.findViewById<Spinner>(R.id.spSportsType)
        val name=view.findViewById<EditText>(R.id.name)
        val instruction=view.findViewById<EditText>(R.id.instruction)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                _listner.saveSportsData(
                    Sport(
                        spSpinner.selectedItem.toString(),
                        name.text.toString(), instruction.text.toString()
                    )
                )
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click if needed
                dialog.dismiss()
            }

        return builder.create()
    }


}