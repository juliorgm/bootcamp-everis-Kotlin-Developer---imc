package br.com.cuiadigital.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import br.com.cuiadigital.R
import br.com.cuiadigital.databinding.ActivityMainBinding
import br.com.cuiadigital.helpers.ValidationForm
import br.com.cuiadigital.model.IMC
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickListeners()
    }

    private fun clickListeners() {
        binding.btnCalculate.setOnClickListener {
            if (validationsForm()){
                val height:Double = binding.edtHeight.text.toString().toDouble()
                val weight:Double = binding.edtWeight.text.toString().toDouble()

                if (!validateDataIMC(height, weight)) return@setOnClickListener

                val imc = IMC(height = height, weight = weight)

                goToResultActivity(imc)
            }
        }

        binding.btnCleanForm.setOnClickListener {
            binding.edtWeight.setText("")
            binding.edtHeight.setText("")
            binding.edtHeight.requestFocus()
        }
    }

    private fun validateDataIMC(height: Double, weight: Double):Boolean {
        if (height > 2.5 || height.equals(0.0)) {
            errorEditText(binding.edtHeight, getString(R.string.error_data_height))
            return false
        }
        if (weight > 600 || height.equals(0.0)) {
            errorEditText(binding.edtWeight, getString(R.string.error_data_weight))
            return false
        }

        return true
    }

    private fun validationsForm(): Boolean {
        if (edittextIsEmpty(binding.edtHeight)) return false
        if (edittextIsEmpty(binding.edtWeight)) return false

        return true
    }

    private fun edittextIsEmpty(field:TextInputEditText): Boolean {
        if (field.text.isNullOrEmpty()) {
            field.requestFocus()
            field.setError(getString(R.string.required_field))
            return true
        }
        return false
    }

    private fun errorEditText(field:TextInputEditText, message:String){
        field.requestFocus()
        field.setError(message)
    }

    private fun goToResultActivity(imc: IMC) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(EXTRA_RESULT, imc)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_RESULT = "EXTRA_RESULTA"
    }
}