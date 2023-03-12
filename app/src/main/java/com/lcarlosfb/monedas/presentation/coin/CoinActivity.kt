package com.lcarlosfb.monedas.presentation.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.lcarlosfb.monedas.R
import com.lcarlosfb.monedas.databinding.ActivityCoinBinding
import kotlin.math.roundToInt

class CoinActivity : AppCompatActivity() {

	private lateinit var coinBinding: ActivityCoinBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		coinBinding = ActivityCoinBinding.inflate(layoutInflater)
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

		coinBinding.btnCalcular.setOnClickListener {

			val coinFrom : String = coinBinding.actvFrom.text.toString()
			val coinTo : String = coinBinding.actvTo.text.toString()
			val price : String = coinBinding.edtnFrom.text.toString()

			if (coinFrom.isEmpty() || coinTo.isEmpty() || price.isEmpty()) {
				Toast.makeText(applicationContext, "Hay campos vacios", Toast.LENGTH_SHORT).show()
			} else if(coinFrom == "Dólar (USD)" && coinTo == "Peso (COP)"){
				val resultado = ((price.toFloat() * 4848)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Dólar (USD)" && coinTo == "Euro"){
				val resultado = ((price.toFloat() * 0.94)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Dólar (USD)" && coinTo == "Dólar (USD)"){
				val resultado = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Euro" && coinTo == "Peso (COP)"){
				val resultado = ((price.toFloat() * 5171)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Euro" && coinTo == "Euro"){
				val resultado = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Euro" && coinTo == "Dólar (USD)"){
				val resultado = ((price.toFloat() * 1.07)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Peso (COP)" && coinTo == "Peso (COP)"){
				val resultado = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Peso (COP)" && coinTo == "Dólar (USD)"){
				val resultado = ((price.toFloat() * 0.00021)*10000).roundToInt().toDouble()/10000
				coinBinding.tvResult.setText(resultado.toString())
			}else if(coinFrom == "Peso (COP)" && coinTo == "Euro"){
				val resultado = ((price.toFloat() * 0.00019)*10000).roundToInt().toDouble()/10000
				coinBinding.tvResult.setText(resultado.toString())
			}
		}

		coinBinding.btnLimpiar.setOnClickListener {
			coinBinding.actvFrom.setText("")
			coinBinding.actvTo.setText("")
			coinBinding.edtnFrom.setText("")
			coinBinding.tvResult.setText("")
		}
	}
}
