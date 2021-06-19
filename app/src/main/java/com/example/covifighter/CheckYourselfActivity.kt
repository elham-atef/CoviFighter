package com.example.covifighter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.check_yourself.*


var count: Int = 0

class CheckYourselfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check_yourself)

        //************************
        // continue button is Clicked
        continue_button.setOnClickListener {
            // compare count value with number2, if lower then go to YouAreFineActivity
            // if higher then go to YouAreSickActivity
            if (count < 2) {
                val intent = Intent(this, YouAreFineActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                val intent = Intent(this, YouAreSickActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            // call function to clear the count value, set checkBox to be unchecked
            ifBack()
        }
    }

    // A checkBox is clicked
    fun onCheckboxClicked(view: View) {
        // check if the checkBox is checked or not
        val checked: Boolean = (view as CheckBox).isChecked
        // if it is checked, then increment count value
        //if it isn't checked, decrement count value
        count = if (checked) {
            count + 1
        } else {
            count - 1
        }
    }
    // clear the count value, set checkBoxes to be not checked
    fun ifBack() {
        count = 0
        // create list of checkBoxes
        val checkBoxesList: List<CheckBox> =
            listOf(checkbox_1, checkbox_2, checkbox_3, checkbox_4, checkbox_5, checkbox_6)
        // create for loop to set all checkBoxes in the list to be unchecked
        // so if user returns back, the checkBoxes are reset
        for (i in checkBoxesList) {
            i.setChecked(false)
        }
    }
    // if Back Button is pressed, return to home
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Home::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}