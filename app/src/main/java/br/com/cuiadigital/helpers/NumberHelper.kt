package br.com.cuiadigital.helpers

import java.math.BigDecimal
import java.math.RoundingMode

class NumberHelper {
    companion object{
        fun formaNumberTwoDecimal(number:Double):Double{
            return BigDecimal(number).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        }
    }
}