package com.example.dogeanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogeanimation.databinding.NextLayoutBinding

class NextActivity: AppCompatActivity() {

    lateinit var binding:NextLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NextLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}