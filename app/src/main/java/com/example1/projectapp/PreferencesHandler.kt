package com.example1.projectapp

import android.content.Context
import android.content.SharedPreferences


class PreferencesHandler {
    companion object {
         private fun getEditor(context: Context): SharedPreferences.Editor {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                Constants.PACKAGE_NAME, Context.MODE_PRIVATE
            )
            return sharedPreferences.edit()
        }

         private fun getSharedPref(context: Context): SharedPreferences {
            return context.getSharedPreferences(
                Constants.PACKAGE_NAME, Context.MODE_PRIVATE
            )
        }
          fun setUser(context: Context,id: Int){
            getEditor(context).putInt("userId",id ).commit();
        }
          fun getUser(context: Context):Int {
            return getSharedPref(context).getInt("userId",-1);
        }
    }
}