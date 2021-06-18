package com.example.covifighter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // covid_definition TextView is clicked
        covid_definition_text.setOnClickListener {
            // move to CoronaActivity
            val context: Context? = activity
            val intent = Intent(context, CoronaActivity::class.java)
            startActivity(intent)
        }
        // home quarantine rule TextView is clicked
        home_quarantine_rule_text.setOnClickListener {
            // move to QuarantineRulesActivity
            val context: Context? = activity
            val intent = Intent(context, QuarantineRulesActivity::class.java)
            startActivity(intent)
        }
        // check yourself TextView is clicked
        check_yourself_text.setOnClickListener {
            // move to CheckYourselfActivity
            val context: Context? = activity
            val intent = Intent(context, CheckYourselfActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }
        // about TextView is clicked
        about_text.setOnClickListener {
            // move to AboutActivity
            val context: Context? = activity
            val intent = Intent(context, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}