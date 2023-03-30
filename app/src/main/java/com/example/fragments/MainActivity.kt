package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val fragments = listOf(OneFragment(), TwoFragment(), TwoFragment())
    val tabTitles = listOf("Home", "Friends", "Notifications")

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        val mediator = TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }

        mediator.attach()
    }

    private fun initViewPager() {
        val adapter =
            MyPagerAdapter(this@MainActivity, fragments) // AppCompatActivity is a FragmentActivity
        binding.viewPager.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete -> {
                toast("all the database deleted 😢")
                true
            }
            R.id.action_refresh -> {
                toast("ok its restored ✌️")
                true
            }
            else -> false
        }

    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

}