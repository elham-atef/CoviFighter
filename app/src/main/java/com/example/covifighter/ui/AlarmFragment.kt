package com.example.covifighter.ui
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covifighter.CreateEvent
import com.example.covifighter.R
import kotlinx.android.synthetic.main.fragment_alarm.*
class AlarmFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_create.setOnClickListener(View.OnClickListener {
            //it used to make context in fragment
            val context: Context? = activity
            val intent = Intent(context, CreateEvent::class.java)
            startActivity(intent) })
        btn_exist.setOnClickListener(View.OnClickListener {
            //it used to make context in fragment
            val context: Context? = activity
            val intent = Intent(context, YourAllarms::class.java)
            startActivity(intent) })
    }
}


