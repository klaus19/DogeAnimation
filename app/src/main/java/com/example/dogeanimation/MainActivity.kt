package com.example.dogeanimation

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogeanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // fade Animation
        fadeAnim()


    }

    private fun fadeAnim() {
        binding.btnAlphaAnimation.setOnClickListener {
            //This is for Fading Animation
            ObjectAnimator.ofFloat(binding.btnAlphaAnimation,"alpha",0.3f)
                .start()
        }
    }


}






