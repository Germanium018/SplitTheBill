package com.android.splitthebill.app

import android.app.Application
import android.content.Context
import com.android.splitthebill.model.BillingItem
import com.android.splitthebill.model.User

class MyApp : Application() {
    private val billingList = mutableListOf<BillingItem>()
    val userList = mutableListOf<User>()

    private val prefs by lazy {
        getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }

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

    fun addUser(username: String, password: String) {
        prefs.edit()
            .putString("username", username)
            .putString("password", password)
            .apply()
    }
    fun isValidUser(username: String, password: String): Boolean {
        val savedUsername = prefs.getString("username", null)
        val savedPassword = prefs.getString("password", null)
        return username == savedUsername && password == savedPassword
    }
    fun getSavedUsername(): String? = prefs.getString("username", null)
    fun getSavedPassword(): String? = prefs.getString("password", null)
}


