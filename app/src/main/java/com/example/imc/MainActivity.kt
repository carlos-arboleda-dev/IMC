package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.imc.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.content.res.Configuration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón para calcular el IMC
        binding.btnCalculate.setOnClickListener {
            val weightStr = binding.etWeight.text.toString()
            val heightStr = binding.etHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val heightCm = heightStr.toDouble()
                val heightM = heightCm / 100

                val bmi = weight / (heightM * heightM)
                val (status, imageRes) = getBmiCategory(bmi)

                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                val currentDate = sdf.format(Date())

                val measurement = Measurement(
                    date = currentDate,
                    weight = weight,
                    height = heightCm,
                    bmi = bmi,
                    status = status,
                    imageResId = imageRes
                )

                HistoryManager.historyList.add(measurement)

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("MEASUREMENT", measurement)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.toast_empty_fields), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.btnToggleTheme.setOnClickListener {
            val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

            if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    private fun getBmiCategory(bmi: Double): Pair<String, Int> {
        return when {
            bmi < 18.5 -> Pair(getString(R.string.status_underweight), R.drawable.ic_underweight)
            bmi < 25.0 -> Pair(getString(R.string.status_normal), R.drawable.ic_normal)
            bmi < 30.0 -> Pair(getString(R.string.status_overweight), R.drawable.ic_overweight)
            else -> Pair(getString(R.string.status_obesity), R.drawable.ic_obesity)
        }
    }
}