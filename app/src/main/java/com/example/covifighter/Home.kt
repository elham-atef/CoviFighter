package com.example.covifighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // check which item selected to open its fragment
        navigation.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.navigation_home) {
                pushFragment(HomeFragment())
            } else if (item.itemId == R.id.navigation_cases) {
                pushFragment(CasesFragment())
            } else if (item.itemId == R.id.navigation_tracker) {
                pushFragment(TrackerFragment())
            } else if (item.itemId == R.id.navigation_advices) {
                pushFragment(AdvicesFragment())
            }

            true; // item selected
        }
        navigation.selectedItemId = R.id.navigation_home
    }

    // fun that push fragment of item selected
    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}