package com.miu.animalkingdomexplorer.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.miu.animalkingdomexplorer.data.model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class AddDialogFragment : DialogFragment(), CoroutineScope {
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

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        // To perform the Job, Displatchers.Main is used for CoroutineContext
        get() = job + Dispatchers.Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create an Instance for the Job()
        job = Job()
    }
    override fun onDestroy() {
        super.onDestroy()
        // Cancel the Job
        job.cancel()
    }

}