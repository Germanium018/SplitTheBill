package com.android.splitthebill

import java.io.Serializable

data class BillingItem(
    val title: String,
    val date: String,
    val amount: Double
) : Serializable
