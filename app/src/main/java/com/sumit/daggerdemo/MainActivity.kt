package com.sumit.daggerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sumit.daggerdemo.adapter.CryptocurrencyAdapter
import com.sumit.daggerdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

    /*@AndroidEntryPoint annotation which will make the component
    class(activity, fragments, views, services, and broadcast receiver)
    ready for injection. Also, we will get our ViewModel in MainActivity
    by using by viewModels() delegate.*/
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var cryptocurrencyList: RecyclerView

    // viewModels() delegate used to get
    // by view models will automatically construct the viewmodels using Hilt
    private val viewModel : MainViewModel  by  viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cryptocurrencyList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()

    }
    // Observing the live  data
    private fun observeCryptoCurrency() {
        viewModel.cryptocurrencyEmitter.observe(this) {
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}