package com.example.covifighter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covifighter.adpter.AdvicesAdapter
import com.example.covifighter.models.Container
import kotlinx.android.synthetic.main.activity_tester_advices.*

class TesterAdvices : AppCompatActivity() {

    lateinit var adapter:AdvicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tester_advices)

        val data=createListAdapter()
        adapter= AdvicesAdapter(data)
        recycler_view.adapter=adapter


    }

    //fun to show each element in recyclerview
    private fun createListAdapter():List<Container> {

        val item =ArrayList<Container>()


  //getString(R.string.clean) -> is to get string from string file to be able to change it in any time easly
             item.add(Container(getString(R.string.clean_your_hands),
                 R.drawable.wash_hand))
             item.add(Container(getString(R.string.maintain_a_safe_distance),
                 R.drawable.distances))
             item.add(Container(getString(R.string.wear_a_mask),
                 R.drawable.wear_mask))
             item.add(Container(getString(R.string.do_not_touch_your_eyes),
                 R.drawable.touch))
             item.add(Container(getString(R.string.sneeze),
                 R.drawable.cover_mouth))
             item.add(Container(getString(R.string.Stay_home_if_you_feel_unwell),
                 R.drawable.stay_home))
             item.add(Container(getString(R.string.seek_medical_attention),
                 R.drawable.doctor))
        return item


    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Home::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}