package com.miu.sports

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment

abstract class AddDialogFragment : DialogFragment() {
    protected lateinit var _listner: OnAddListener<Data>
    private var _layout:Int=0
    protected lateinit var _view: View
    public fun SetOnAddListner(listener: OnAddListener<Data>) {
        _listner = listener
    }
    protected  abstract  fun onOkButtonSubmit()
    protected  fun SetLayout(layout:Int)
    {
        this._layout=layout
    }
    protected  fun getDialogView():View
    {
        return _view;
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        _view = inflater.inflate(_layout, null)
        builder.setView(_view)
            .setPositiveButton("OK") { dialog, _ ->
                onOkButtonSubmit()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }


}