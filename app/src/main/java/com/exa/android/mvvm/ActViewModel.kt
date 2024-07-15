package com.exa.android.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }


    fun insertQuote(quote: Quote) {
        CoroutineScope(Dispatchers.IO).launch {
            quoteRepository.insertQuotes(quote)
        }
    }

}