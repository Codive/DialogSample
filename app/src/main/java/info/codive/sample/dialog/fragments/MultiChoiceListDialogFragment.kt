package info.codive.sample.dialog.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import info.codive.sample.dialog.R


class MultiChoiceListDialogFragment : DialogFragment() {
    private lateinit var builder: AlertDialog.Builder

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Title")
        builder.setIcon(R.mipmap.ic_launcher)

        //Contents
        createMultiChoiceListContents()

        //Button
        createPositiveButton()
        createNegativeButton()
        createNeutralButton()

        return builder.create()
    }

    private fun createMultiChoiceListContents() {
        val items = arrayOf<String>("ITEM1", "ITEM2", "ITEM3", "ITEM4")
        val checkedItems = booleanArrayOf(false, false, true, true)
        builder.setMultiChoiceItems(items, checkedItems) { dialog, which, isChecked ->
            when (which) {
                0 -> Toast.makeText(activity, "ITEM1 $isChecked", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(activity, "ITEM2 $isChecked", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(activity, "ITEM3 $isChecked", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(activity, "ITEM4 $isChecked", Toast.LENGTH_SHORT).show()
                else -> {
                }
            }
        }
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