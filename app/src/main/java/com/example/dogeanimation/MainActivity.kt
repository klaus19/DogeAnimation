package com.example.dogeanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dogeanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

     binding.btnAlphaAnimation.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v == binding.btnAlphaAnimation){

        }
    }

}