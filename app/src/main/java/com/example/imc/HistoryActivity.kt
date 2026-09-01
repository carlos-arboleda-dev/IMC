package com.example.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val historyText = StringBuilder()

        if (HistoryManager.historyList.isEmpty()) {
            historyText.append(getString(R.string.history_empty))
        } else {
            for (item in HistoryManager.historyList.reversed()) {
                historyText.append(getString(R.string.history_item_date, item.date)).append("\n")
                historyText.append(getString(R.string.history_item_details, item.weight, item.height)).append("\n")
                historyText.append(getString(R.string.history_item_result, item.bmi, item.status)).append("\n")
                historyText.append("-----------------------------------\n")
            }
        }

        binding.tvHistoryList.text = historyText.toString()

        binding.btnBackMainHistory.setOnClickListener {
            finish()
        }
    }
}