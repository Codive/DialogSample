package info.codive.sample.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import info.codive.sample.dialog.fragments.*

class MainActivity : AppCompatActivity(),
    MessageDialogWithInterfaceFragment.MessageDialogListener,
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DO NOT USE AlertDialog DIRECTLY, since this is not support android lifecycle.
        // 1.open dialog
        // 2.rotate the display
        findViewById<Button>(R.id.show_direct_dialog_button).setOnClickListener {
            val text = "DIRECT"
            AlertDialog.Builder(this)
                .setTitle("Title")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Message")
                .setPositiveButton(text) { dialog, id ->
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton(text) { dialog, id ->
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                    dialog.cancel() //Cancel
                }
                .setNeutralButton(text) { dialog, id ->
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        //AlertDialog
        findViewById<Button>(R.id.show_message_dialog_button).setOnClickListener {
            MessageDialogFragment().show(
                supportFragmentManager,
                MessageDialogFragment::class.simpleName
            )
        }
        findViewById<Button>(R.id.show_list_dialog_button).setOnClickListener {
            ListDialogFragment().show(supportFragmentManager, ListDialogFragment::class.simpleName)
        }
        findViewById<Button>(R.id.show_single_choice_list_dialog_button).setOnClickListener {
            SingleChoiceListDialogFragment().show(
                supportFragmentManager,
                SingleChoiceListDialogFragment::class.simpleName
            )
        }
        findViewById<Button>(R.id.show_multi_choice_list_dialog_button).setOnClickListener {
            MultiChoiceListDialogFragment().show(
                supportFragmentManager,
                MultiChoiceListDialogFragment::class.simpleName
            )
        }
        findViewById<Button>(R.id.show_custom_dialog_button).setOnClickListener {
            CustomDialogFragment().show(
                supportFragmentManager,
                CustomDialogFragment::class.simpleName
            )
        }

        //DatePickerDialog / TimePickerDialog
        findViewById<Button>(R.id.show_datepicker_dialog_button).setOnClickListener {
            DatePickerDialogFragment().show(
                supportFragmentManager,
                DatePickerDialogFragment::class.simpleName
            )
        }
        findViewById<Button>(R.id.show_timepicker_dialog_button).setOnClickListener {
            TimePickerDialogFragment().show(
                supportFragmentManager,
                TimePickerDialogFragment::class.simpleName
            )
        }

        //AlertDialog with Event Delegate Interface
        findViewById<Button>(R.id.show_message_with_interface_dialog_button).setOnClickListener {
            MessageDialogWithInterfaceFragment().show(
                supportFragmentManager,
                MessageDialogWithInterfaceFragment::class.simpleName
            )
        }
    }

    // DatePickerDialog.OnDateSetListener
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        Toast.makeText(this, "Date: $year/$month/$day", Toast.LENGTH_SHORT).show()
    }

    // TimePickerDialog.OnTimeSetListener
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        Toast.makeText(this, "Time: $hourOfDay:$minute", Toast.LENGTH_SHORT).show()
    }

    // MessageDialogWithInterfaceFragment.MessageDialogListener
    override fun onMessageDialogPositiveClick(dialog: DialogFragment, id: Int, text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    // MessageDialogWithInterfaceFragment.MessageDialogListener
    override fun onMessageDialogNegativeClick(dialog: DialogFragment, id: Int, text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    // MessageDialogWithInterfaceFragment.MessageDialogListener
    override fun onMessageDialogNeutralClick(dialog: DialogFragment, id: Int, text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}