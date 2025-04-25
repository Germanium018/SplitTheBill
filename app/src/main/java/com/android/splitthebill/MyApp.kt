package com.android.splitthebill

import android.app.Application

class MyApp : Application() {
    private val billingList = mutableListOf<BillingItem>()

    companion object {
        lateinit var instance: MyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun addBillingItem(item: BillingItem) {
        billingList.add(item)
    }

    fun getAllBillings(): List<BillingItem> {
        return billingList
    }
}


