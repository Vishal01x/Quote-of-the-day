package com.exa.android.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuotesDb : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {

        @Volatile
        private var INSTANCE: QuotesDb? = null

        fun getDatabase(context: Context): QuotesDb {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context, QuotesDb::class.java, "quote Database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}

//if you want to take data from assests then use .createfromassests(pass assets file)