package com.example.covifighter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


open class AdvicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advices, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val handler= Handler().postDelayed(Runnable {

            //it used to make context in fragment
            val context: Context? = activity

            //intent to go from fragment which is not activity -> to recycler activity (TesterAdvices)
            val intent = Intent(context, TesterAdvices::class.java)
            startActivity(intent)
        }, 0)




    }



}