package com.lcarlosfb.monedas.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lcarlosfb.monedas.R
import com.lcarlosfb.monedas.databinding.ActivitySplashBinding
import com.lcarlosfb.monedas.presentation.coin.CoinActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

	private lateinit var splashBinding: ActivitySplashBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		splashBinding = ActivitySplashBinding.inflate(layoutInflater)
		val view = splashBinding.root
		setContentView(view)

		val timer= Timer()
		timer.schedule(timerTask{
			val intent= Intent(this@SplashActivity,CoinActivity::class.java)
			startActivity(intent)
			finish()
		},2000 )

	}
}