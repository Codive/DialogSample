package info.codive.sample.dialog.fragments

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import info.codive.sample.dialog.R


class MessageDialogFragment : DialogFragment() {

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
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun createNegativeButton() {
        val text = "Negative"
        builder.setNegativeButton(text) { dialog, id ->
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun createNeutralButton() {
        val text = "Neutral"
        builder.setNeutralButton(text) { dialog, id ->
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }
}