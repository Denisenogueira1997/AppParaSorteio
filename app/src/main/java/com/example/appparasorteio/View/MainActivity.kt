package com.example.appparasorteio.View
import com.example.appparasorteio.ViewModel.ItemViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.appparasorteio.ViewModel.ItemViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ItemViewModelFactory(applicationContext)
        viewModel = ViewModelProvider(this, factory).get(ItemViewModel::class.java)

        setContent {
            AppNavigation(viewModel = viewModel)
        }
    }
}




