package com.demo.plantcareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.plantcareapp.fragments.AlertFragment
import com.demo.plantcareapp.fragments.HomeFragment
import com.demo.plantcareapp.fragments.ListFragment
import com.demo.plantcareapp.fragments.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val homeFragment = HomeFragment()
        val listFragment = ListFragment()
        val alertFragment = AlertFragment()
        val userFragment = UserFragment()

        makeCurrentFragment(homeFragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_list -> makeCurrentFragment(listFragment)
                R.id.navigation_alert -> makeCurrentFragment(alertFragment)
                R.id.navigation_user -> makeCurrentFragment(userFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}