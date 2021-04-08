package br.com.cuiadigital.helpers

import android.content.res.Resources
import br.com.cuiadigital.R
import com.google.android.material.textfield.TextInputEditText

class ValidationForm {

    companion object{
        private const val MAX_HEIGHT = 2.5
        private const val MAX_WEIGHT = 600
        private const val ZERO = 600

        fun isEmpty(field: TextInputEditText):Boolean{
            if (field.getText().isNullOrEmpty()) return false
            return true
        }
        fun validateForm(fields: Array<TextInputEditText>):Boolean{
            fields.forEach {
                field-> if (field.getText().isNullOrEmpty()) {
                    field.requestFocus()
                    // Verificar a forma correta para usar strings.xml sem quebrar o app
                    field.setError("Preencha este campo")
                    return false
                }
            }

            return true
        }
        fun validateHeight(height:Double):Boolean{
            if (height > MAX_HEIGHT || height.equals(ZERO)) return false
            return true
        }
        fun validateWeight(weight:Double):Boolean{
            if (weight > MAX_WEIGHT || weight.equals(ZERO)) return false
            return true
        }

    }
}