package com.lcarlosfb.monedas.presentation.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lcarlosfb.monedas.R
import com.lcarlosfb.monedas.databinding.ActivityCoinBinding
import kotlin.math.roundToInt

class CoinActivity : AppCompatActivity() {

	private lateinit var coinBinding: ActivityCoinBinding
	private lateinit var coinViewModel: CoinViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		coinBinding = ActivityCoinBinding.inflate(layoutInflater)
		coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]
		val view = coinBinding.root
		setContentView(view)


		val from = resources.getStringArray(R.array.from)
		val adapter= ArrayAdapter(this,R.layout.list_from,from)
		with(coinBinding.actvFrom){
			setAdapter(adapter)
		}

		val to = resources.getStringArray(R.array.to)
		val adapter2= ArrayAdapter(this,R.layout.list_to,to)
		with(coinBinding.actvTo){
			setAdapter(adapter2)
		}

		val msgToast = Observer<String>{toastError->
			Toast.makeText(applicationContext,toastError,Toast.LENGTH_SHORT).show()
		}
		coinViewModel.toastEror.observe(this,msgToast)

		val outPut = Observer<Double> {resultado->
			coinBinding.tvResult.setText(resultado.toString())
		}
		coinViewModel.resultado.observe(this,outPut)


		coinBinding.btnCalcular.setOnClickListener {

			val coinFrom : String = coinBinding.actvFrom.text.toString()
			val coinTo : String = coinBinding.actvTo.text.toString()
			val price : String = coinBinding.edtnFrom.text.toString()

			coinViewModel.calcular(coinFrom,coinTo,price)
		}

		coinBinding.btnLimpiar.setOnClickListener {
			coinBinding.actvFrom.setText("")
			coinBinding.actvTo.setText("")
			coinBinding.edtnFrom.setText("")
			coinBinding.tvResult.setText("")
		}
	}
}
