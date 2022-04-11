package com.example.dogeanimation

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        //Choreograping various Animation together
        choreoAnimate()

        //Getting Height of the screen and then creating an animation
        getAnimation_Height()

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@MainActivity,NextActivity::class.java))
        }

    }


    // Getting height and width of screen and random Animation with it
    private fun getAnimation_Height(){
         binding.btnRandomZig.setOnClickListener {
             //Found width and height of the screen
             val displayMetrics = DisplayMetrics()
             val view = binding.btnRandomZig
             windowManager.defaultDisplay.getMetrics(displayMetrics)
             val height = displayMetrics.heightPixels.toFloat()
            // val width = displayMetrics.widthPixels.toFloat()

             val position_animator = ValueAnimator.ofFloat(0f,-height)

             position_animator.addUpdateListener {
                 val value = it.animatedValue as Float
                 binding.btnRandomZig.translationY = value
             }

             //3
             val rotationAnimator = ObjectAnimator.ofFloat(view,"rotation",0f,180f)

             //4
             val animatorSet = AnimatorSet()

             //5
             animatorSet.play(position_animator).with(rotationAnimator)

             //6
             animatorSet.duration = 2000
             animatorSet.start()

         }
    }

    private fun choreoAnimate() {
      val argb = ArgbEvaluator()
        with(binding){
            btnChoreo.setOnClickListener {
                val animSet = AnimatorSet()
                animSet.playTogether(
                    ObjectAnimator.ofFloat(btnChoreo,"scaleX",1.0f,2.0f)
                        .setDuration(2000),
                    ObjectAnimator.ofFloat(btnChoreo,"scaleY",1.0f,2.0f)
                        .setDuration(2000),
                    ObjectAnimator.ofObject(btnChoreo,"backgroundColor",argb,ContextCompat.getColor(this@MainActivity,R.color.purple_200),
                        ContextCompat.getColor(this@MainActivity,R.color.teal_200))
                )
                animSet.start()

            }
        }
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






