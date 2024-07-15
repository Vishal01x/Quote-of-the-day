package com.exa.android.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exa.android.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActViewModel
    lateinit var quoteAdapter : QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val Dao = QuotesDb.getDatabase(this).quoteDao()
        val repo = QuoteRepository(Dao)

        viewModel = ViewModelProvider(this, ActFactory(repo))[ActViewModel::class.java]

        quoteAdapter = QuoteAdapter()
        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = quoteAdapter
        }

        binding.btn.setOnClickListener {
            val name = binding.author.text.toString()
            val text = binding.text.text.toString()

            viewModel.insertQuote(Quote(0, text, name))

            viewModel.getQuotes().observe(this, Observer {
                it?.let {
                     quoteAdapter.submitList(it)
                }
            })

        }

    }
}