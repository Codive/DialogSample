package info.codive.sample.dialog.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment
import java.util.*


class TimePickerDialogFragment : DialogFragment() {

    private lateinit var listener: TimePickerDialog.OnTimeSetListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireActivity(),
            listener,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as TimePickerDialog.OnTimeSetListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement OnTimeSetListener"))
        }
    }
}