package com.example.imc

import java.io.Serializable

data class Measurement(
    val date: String,
    val weight: Double,
    val height: Double,
    val bmi: Double,
    val status: String,
    val imageResId: Int
) : Serializable

object HistoryManager {
    val historyList = mutableListOf<Measurement>()
}