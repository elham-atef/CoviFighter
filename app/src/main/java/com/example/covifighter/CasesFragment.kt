package com.example.covifighter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_cases.*

class CasesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //when text1 is pressed go to url link
        text_1 .setOnClickListener(View.OnClickListener {
            openCasesWebsite(view)
        })

        //when text2 is pressed go to url link
        text_2.setOnClickListener(View.OnClickListener {
            openNewsWibsite(view)
        })

        //when text1 is pressed go to url link
        text_3.setOnClickListener(View.OnClickListener {
            openGcasesWibsite(view)
        })



    }

    //explicet intent -> go to url link
    //for egyption cases
    private fun openCasesWebsite(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.care.gov.eg/EgyptCare/index.aspx"))
        startActivity(browserIntent)
    }

    //explicet intent -> go to url link
    //for latest news
    private fun openNewsWibsite(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://dailymedicalinfo.com/tag/%D9%81%D9%8A%D8%B1%D9%88%D8%B3-%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7/"))
        startActivity(browserIntent)

    }

    //explicet intent -> go to url link
    //for global cases
    private fun openGcasesWibsite(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://dailymedicalinfo.com/coronavirus/"))
        startActivity(browserIntent)

    }


}