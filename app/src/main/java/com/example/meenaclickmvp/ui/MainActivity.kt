package com.example.meenaclickmvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.example.meenaclickmvp.R
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainContract.Communicator {
    lateinit var cartValue: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load initial fragment
        loadFragment(HomeFragment())

        //set toolbar
        setToolbar()
    }

    private fun setToolbar() {
        toolbar.setTitle("Cereals")
        toolbar.setNavigationIcon(R.drawable.back)
        setSupportActionBar(toolbar)

    }

    private fun loadFragment(homeFragment: HomeFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, homeFragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search_cart, menu)
        val menuItem = menu?.findItem(R.id.menu_item_search)
        search_view.setMenuItem(menuItem)
        getCartValue(menu)
        return  true
    }

    private fun getCartValue(menu: Menu?) {
        val cart = menu?.findItem(R.id.menu_item_cart)?.actionView
        cartValue = cart!!.findViewById(R.id.tv_notification_count)
        cartValue.text = "10"
    }

    override fun getCartValue(value: Int) {

    }

}
