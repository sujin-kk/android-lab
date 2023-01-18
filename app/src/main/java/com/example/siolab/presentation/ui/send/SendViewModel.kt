package com.example.siolab.presentation.ui.send

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SendViewModel : ViewModel() {
    val curSender = MutableStateFlow("KOR")
    val curReceiver = MutableStateFlow("USD")
    val curExchangeRate = MutableStateFlow("1254.32")

    val moneyOfSender: MutableStateFlow<String> = MutableStateFlow("0")
    val moneyOfReceiver: MutableStateFlow<String> = MutableStateFlow("0.00")

    fun calculateMoneyOfReceiver(): String {
        return if (moneyOfSender.value.isNotEmpty()) (moneyOfSender.value.toDouble() / curExchangeRate.value.toDouble()).toString() else ""
    }


    fun calculateMoneyOfSender(): String {
        return if (moneyOfReceiver.value.isNotEmpty()) (moneyOfReceiver.value.toDouble() * curExchangeRate.value.toDouble()).toString() else ""
    }
}