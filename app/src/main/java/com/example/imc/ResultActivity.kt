package com.example.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val measurement = intent.getSerializableExtra("MEASUREMENT") as? Measurement

        measurement?.let {
            binding.tvStatus.text = getString(R.string.result_status_format, it.status)
            binding.tvBmi.text = getString(R.string.result_bmi_format, it.bmi)
            binding.ivStatus.setImageResource(it.imageResId)
        }

        binding.btnBackMain.setOnClickListener {
            finish()
        }
    }
}