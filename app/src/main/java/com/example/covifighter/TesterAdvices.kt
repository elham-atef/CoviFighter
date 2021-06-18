package com.example.covifighter

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

             item.add(Container("Clean your hands often. Use soap and water, or an alcohol-based hand rub.",
                 R.drawable.wash_hand))
             item.add(Container("Maintain a safe distance from anyone who is coughing or sneezing.",
                 R.drawable.distances))
             item.add(Container("Wear a mask when physical distancing is not possible.",
                 R.drawable.wear_mask))
             item.add(Container("Don’t touch your eyes, nose or mouth.",
                 R.drawable.touch))
             item.add(Container("Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.",
                 R.drawable.cover_mouth))
             item.add(Container("Stay home if you feel unwell.",
                 R.drawable.stay_home))
             item.add(Container("If you have a fever, cough and difficulty breathing, seek medical attention.",
                 R.drawable.doctor))
        return item


    }
}