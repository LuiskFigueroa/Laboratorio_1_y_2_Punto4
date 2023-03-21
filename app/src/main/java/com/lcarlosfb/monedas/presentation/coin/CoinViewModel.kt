package com.lcarlosfb.monedas.presentation.coin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class CoinViewModel : ViewModel() {

	val toastEror : MutableLiveData<String> by lazy {
		MutableLiveData<String>()
	}
	val resultado : MutableLiveData<Double> by lazy {
		MutableLiveData<Double>()
	}


	fun calcular(coinFrom: String, coinTo: String, price: String) {

		if (coinFrom.isEmpty() || coinTo.isEmpty() || price.isEmpty()){
			toastEror.value = "Hay campos vacíos"
		}else if(coinFrom == "Dólar (USD)" && coinTo == "Peso (COP)"){
			resultado.value = ((price.toFloat() * 4848)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Dólar (USD)" && coinTo == "Euro") {
			resultado.value = ((price.toFloat() * 0.94) * 100).roundToInt().toDouble() / 100
		}else if(coinFrom == "Dólar (USD)" && coinTo == "Dólar (USD)"){
			resultado.value = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Euro" && coinTo == "Peso (COP)"){
			resultado.value = ((price.toFloat() * 5171)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Euro" && coinTo == "Euro"){
			resultado.value = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Euro" && coinTo == "Dólar (USD)"){
			resultado.value = ((price.toFloat() * 1.07)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Peso (COP)" && coinTo == "Peso (COP)"){
			resultado.value = ((price.toFloat() * 1)*100).roundToInt().toDouble()/100
		}else if(coinFrom == "Peso (COP)" && coinTo == "Dólar (USD)"){
			resultado.value = ((price.toFloat() * 0.00021)*10000).roundToInt().toDouble()/10000
		}else if(coinFrom == "Peso (COP)" && coinTo == "Euro"){
			resultado.value = ((price.toFloat() * 0.00019)*10000).roundToInt().toDouble()/10000
		}
	}
}
