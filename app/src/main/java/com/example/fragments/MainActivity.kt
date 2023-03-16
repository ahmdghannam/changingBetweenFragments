package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val myFirstFragment = OneFragment()
    val mySecondFragment = TwoFragment()
    private var flag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSubView()
        initButton()
    }

    private fun initButton() {
        findViewById<Button>(R.id.btn_change).setOnClickListener {
        showOtherFragment()
        }
    }
    private fun showOtherFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        if (flag){
            transaction.replace(R.id.fragment_container, myFirstFragment)
        }else{
            transaction.replace(R.id.fragment_container, mySecondFragment)
        }
        transaction.commit()
        flag=!flag
    }

    private fun initSubView() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, myFirstFragment)
        transaction.commit()
    }
}