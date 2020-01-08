package com.example.meenaclickmvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meenaclickmvp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load initial fragment
        loadFragment(HomeFragment())
    }

    private fun loadFragment(homeFragment: HomeFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, homeFragment)
        transaction.commit()
    }
}
