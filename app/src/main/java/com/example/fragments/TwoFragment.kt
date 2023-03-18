package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {


    private lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val name = it.getString(Constants.KEY_NAME)
            view?.findViewById<TextView>(R.id.tv_f2)?.text = name
        }
    }

    companion object {
        val TAG = TwoFragment::class.java.simpleName
        fun newInstance(name: String): TwoFragment = TwoFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.KEY_NAME, name)
            }
        }
    }

}