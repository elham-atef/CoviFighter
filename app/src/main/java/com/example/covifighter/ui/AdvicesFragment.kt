package com.example.covifighter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covifighter.R


open class AdvicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advices, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            //it used to make context in fragment
            val context: Context? = activity

            //intent to go from fragment which is not activity -> to recycler activity (TesterAdvices)
            val intent = Intent(context, TesterAdvices::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)


    }



}