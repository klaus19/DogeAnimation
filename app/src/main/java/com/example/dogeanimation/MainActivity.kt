package com.example.dogeanimation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
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

        //Rotate in Y axis
        rotateY()

        //Rotate in X axis
        rotateX()

        //BounceInterpolator
        bounceInterpolator()

        //AccelerateInterpolator Animation
        accelerateInterpolator()


    }

    private fun accelerateInterpolator() {
        with(binding){
            btnAccelerateInterpolator.setOnClickListener {
                val accelerateInterpolator:ObjectAnimator = ObjectAnimator.ofFloat(btnAccelerateInterpolator,"Y",1050f)
                accelerateInterpolator.interpolator = AccelerateInterpolator()
                accelerateInterpolator.duration =1000
                accelerateInterpolator.start()
            }

        }
    }

    //Bounce Animation
    private fun bounceInterpolator() {
        with(binding){
            btnBounceInterpolator.setOnClickListener {
                val bounceInterpolator:ObjectAnimator = ObjectAnimator.ofFloat(btnBounceInterpolator,"Y",1000f)
                bounceInterpolator.interpolator = BounceInterpolator()
                bounceInterpolator.duration = 1000
                                     bounceInterpolator.start()
            }

        }
    }

    //Rotate in X Axis
    private fun rotateX() {
        with(binding){
            btnRotationX.setOnClickListener {
                ObjectAnimator.ofFloat(btnRotationX,"rotationX",150f)
                    .start()
            }
        }
    }

    //Rotate in Y axis
    private fun rotateY() {
        binding.btnRotationY.setOnClickListener {
            ObjectAnimator.ofFloat(binding.btnRotationY,"rotationY",150f)
                .start()

        }
    }

    //Fade in Animation
    private fun fadeAnim() {
        binding.btnAlphaAnimation.setOnClickListener {
            //This is for Fading Animation
            ObjectAnimator.ofFloat(binding.btnAlphaAnimation,"alpha",0.3f)
                .start()
        }
    }


}






