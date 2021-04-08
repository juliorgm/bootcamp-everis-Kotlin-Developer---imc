package br.com.cuiadigital.model

import android.os.Parcelable
import br.com.cuiadigital.helpers.NumberHelper
import kotlinx.parcelize.Parcelize

@Parcelize
class IMC(val height: Double, val weight: Double) : Parcelable {
    fun getIMC():Double{
        var imc:Double = weight / (height * height)
        return NumberHelper.formaNumberTwoDecimal(imc)
    }
}