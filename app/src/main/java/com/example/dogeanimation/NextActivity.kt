package com.example.dogeanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.animation.AnticipateInterpolator
import android.view.animation.CycleInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.dogeanimation.databinding.NextLayoutBinding

class NextActivity: AppCompatActivity() {

    lateinit var binding:NextLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NextLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRepeat.setOnClickListener {
            repeatMode()
        }

        binding.btnAnticipate.setOnClickListener {
            anticipateInteraction()
        }

        binding.btnOvershoot.setOnClickListener {
            overshootAnimation()
        }

        binding.btnCycle.setOnClickListener {
            cycleAnimation()
        }


    }

    private fun cycleAnimation() {
        val cycle:ObjectAnimator = ObjectAnimator.ofFloat(binding.btnCycle,"translationX",-200f)
        cycle.interpolator = CycleInterpolator(2f)
        cycle.duration=500
        cycle.start()
    }

    private fun overshootAnimation() {
        val overshoot:ObjectAnimator = ObjectAnimator.ofFloat(binding.btnOvershoot,"translationY",-120f)
                   overshoot.interpolator = OvershootInterpolator()
                   overshoot.duration=1000
                   overshoot.start()
    }

    private fun anticipateInteraction() {
        val anticipateInterpolator:ObjectAnimator  = ObjectAnimator.ofFloat(binding.btnAnticipate,"translationY",-200f)
                 anticipateInterpolator.interpolator = AnticipateInterpolator()
                 anticipateInterpolator.duration =1000
                 anticipateInterpolator.start()

    }

    private fun repeatMode() {

        //finding the height of the screen
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels.toFloat()

        //1 - Creating a ValueAnimator

        val animator = ValueAnimator.ofFloat(0f,-height)

        animator.addUpdateListener {
            val value = it.animatedValue as Float
            binding.btnRepeat.translationY = value
        }

        //2 Repeat repeatMode
        animator.repeatMode = ValueAnimator.REVERSE

        //3
        animator.repeatCount=3

        //4
        animator.duration = 1000L

        //5
        animator.start()

    }
}