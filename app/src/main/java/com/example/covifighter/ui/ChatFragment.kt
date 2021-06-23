package com.example.covifighter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covifighter.R


 class ChatFragment : Fragment() {

     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         return inflater.inflate(R.layout.fragment_chat,container,false)
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context: Context? = activity
        val intent = Intent(context,ChatActivity::class.java)
        startActivity(intent)
    }
}