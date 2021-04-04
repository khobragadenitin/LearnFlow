package com.nmks.kotlinflowdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var listView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = PhotoRepository(DataSource.names, this)
        val useCase = UseCase(repository, DataSource.names)
        val viewModel = ViewModelProvider(this, MyViewModelFactory(useCase))
            .get(FlowDemoViewModel::class.java)

        listView = findViewById(R.id.flowDemoListView)
        val adapter = UserListAdapter()
        listView.adapter = adapter


        lifecycleScope.launch {
            viewModel.userFlow.collect {users ->
                Log.e("MYTAG", "onCreate: >>"+users )
                adapter.submitList(users)
            }
        }




    }
}