package info.codive.sample.dialog.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import info.codive.sample.dialog.R


class MessageDialogWithInterfaceFragment : DialogFragment() {

    private lateinit var listener: MessageDialogListener
    private lateinit var builder: AlertDialog.Builder

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Title")
        builder.setIcon(R.mipmap.ic_launcher)

        //Contents
        createMessageContents()

        //Button
        createPositiveButton()
        createNegativeButton()
        createNeutralButton()

        return builder.create()
    }

    private fun createMessageContents() {
        builder.setMessage("Message")
    }

    private fun createPositiveButton() {
        val text = "Positive"
        builder.setPositiveButton(text) { dialog, id ->
            listener.onMessageDialogPositiveClick(this, id, text)
        }
    }

    private fun createNegativeButton() {
        val text = "Negative"
        builder.setNegativeButton(text) { dialog, id ->
            listener.onMessageDialogNegativeClick(this, id, text)
        }
    }

    private fun createNeutralButton() {
        val text = "Neutral"
        builder.setNeutralButton(text) { dialog, id ->
            listener.onMessageDialogNeutralClick(this, id, text)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as MessageDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement MessageDialogListener"))
        }
    }

    //ダイアログ内のイベント処理を行うインターフェース
    internal interface MessageDialogListener {
        fun onMessageDialogPositiveClick(dialog: DialogFragment, id: Int, text: String)
        fun onMessageDialogNegativeClick(dialog: DialogFragment, id: Int, text: String)
        fun onMessageDialogNeutralClick(dialog: DialogFragment, id: Int, text: String)
    }
}