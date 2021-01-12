package info.codive.sample.dialog.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePickerDialogFragment : DialogFragment() {

    private lateinit var listener: DatePickerDialog.OnDateSetListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), listener, year, month, day)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DatePickerDialog.OnDateSetListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement OnDateSetListener"))
        }
    }
}