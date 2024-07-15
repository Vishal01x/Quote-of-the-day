package com.exa.android.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuotes(quote: Quote)

    @Query("select * from quote")
    fun getQuotes(): LiveData<List<Quote>>


}