package br.com.cuiadigital.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cuiadigital.R
import br.com.cuiadigital.databinding.ActivityMainBinding
import br.com.cuiadigital.databinding.ActivityResultBinding
import br.com.cuiadigital.model.IMC
import br.com.cuiadigital.ui.MainActivity.Companion.EXTRA_RESULT

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
        clickListeners()
    }

    private fun clickListeners() {
        binding.btnBackHome.setOnClickListener {
            finish()
        }
    }

    private fun init() {
        if (intent.hasExtra(EXTRA_RESULT)){
            val imc = intent.getParcelableExtra<IMC>(EXTRA_RESULT)
            if (imc != null) {
                binding.txtIMC.text = imc.getIMC().toString()
                binding.txtResultado.text = resultClassification(imc.getIMC())
            }
        }
    }

    private fun resultClassification(imc: Double): String {
        val results = resources.getStringArray(R.array.result_message)

        when{
            imc < 18 -> return results[0]
            imc < 25 -> return results[1]
            imc < 30 -> return results[2]
            imc < 35 -> return results[3]
            imc < 40 -> return results[4]
            else -> return results[5]
        }
    }
}