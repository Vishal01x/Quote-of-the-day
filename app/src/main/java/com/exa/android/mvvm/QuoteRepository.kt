package com.exa.android.mvvm

import androidx.lifecycle.LiveData

class QuoteRepository(val quotesDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quotesDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote) {
        quotesDao.insertQuotes(quote)
    }
}