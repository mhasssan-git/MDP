package com.miu.sports

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class AddDialogFragment : DialogFragment() {
    protected lateinit var _listner: OnAddListener<Data>
    private var _layout:Int=0
    private lateinit var _view: View

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
    protected fun setDialogView(view: View){
        this._view=view
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(_view)
            .setPositiveButton("Add") { dialog, _ ->
                onOkButtonSubmit()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }


}