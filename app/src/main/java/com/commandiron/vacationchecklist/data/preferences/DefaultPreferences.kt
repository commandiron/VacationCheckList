package com.commandiron.vacationchecklist.data.preferences

import android.content.SharedPreferences
import com.commandiron.vacationchecklist.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveShouldShowHotSplash(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_HOT_SPLASH, shouldShow)
            .apply()
    }

    override fun loadShouldShowHotSplash(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_HOT_SPLASH,
            true
        )
    }

    override fun saveActiveVacationId(id: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_SAVE_LOAD_ACTIVE_VACATION, id)
            .apply()
    }

    override fun loadActiveVacationId(): Int {
        return sharedPref.getInt(
            Preferences.KEY_SAVE_LOAD_ACTIVE_VACATION,
            0
        )
    }

    override fun saveShouldDoubleCheck(shouldDoubleCheck: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_DOUBLE_CHECK, shouldDoubleCheck)
            .apply()
    }

    override fun loadShouldDoubleCheck(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_DOUBLE_CHECK,
            false
        )
    }

    override fun saveShouldShowGridView(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_GRID_VIEW, shouldShow)
            .apply()
    }

    override fun loadShouldShowGridView(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_GRID_VIEW,
            false
        )
    }

    override fun saveListScale(scale: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_SAVE_LOAD_LIST_SCALE, scale)
            .apply()
    }

    override fun loadListScale(): Int {
        return sharedPref.getInt(
            Preferences.KEY_SAVE_LOAD_LIST_SCALE,
            2
        )
    }
}