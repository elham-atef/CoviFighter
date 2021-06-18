package com.example.covifighter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.check_yourself.*


var count: Int = 0

class CheckYourselfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check_yourself)
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
            // call function
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
    fun ifBack(){
        count = 0
        checkbox_1.setChecked(false)
        checkbox_2.setChecked(false)
        checkbox_3.setChecked(false)
        checkbox_4.setChecked(false)
        checkbox_5.setChecked(false)
        checkbox_6.setChecked(false)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Home::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()

    }
}