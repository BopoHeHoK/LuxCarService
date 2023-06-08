package com.test.luxcarservice.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.test.luxcarservice.domain.data.repository.UserStorage

class SharedPreferences(
    private val context: Context
) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override fun setUserId(userId: Long) {
        sharedPreferences.edit().putLong(USER_ID, userId).apply()
    }

    override fun getUserId(): Long {
        return sharedPreferences.getLong(USER_ID, 0L)
    }

    companion object SharedPrefs {
        const val SHARED_PREFS = "shared_prefs"
        const val USER_ID = "shared_prefs_user_id"
    }
}