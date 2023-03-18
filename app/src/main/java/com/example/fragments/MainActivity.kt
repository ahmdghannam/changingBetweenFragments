package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myFirstFragment = OneFragment()
    private val mySecondFragment = TwoFragment()
    private val myThirdFragment = TwoFragment()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initSubView()
        addNavigationListener()
    }

    private fun addNavigationListener() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pageHome -> {
                    replaceFragment(myFirstFragment)
                    true// is handled as return value
                }
                R.id.pageFriends ->{
                    replaceFragment(mySecondFragment)
                    true
                }
                R.id.pageNotification ->{
                    replaceFragment(myThirdFragment)
                    true
                }
                else -> false
            }

        }
    }

    private fun initSubView() {
        addFragment(myFirstFragment)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


}