package com.example.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

//        createAlertDialog()
    }

    private fun createAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle("title")
            setMessage("message")
            setPositiveButton("yes") { dialog, which ->
                Toast.makeText(context, "positive clicked", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("no") { dialog, which ->
                Toast.makeText(context, "negative button clicked", Toast.LENGTH_SHORT).show()
            }
            setCancelable(true)
        }
        val dialog = builder.create()
        dialog.show()
    }

}