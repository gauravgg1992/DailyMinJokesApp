package com.gaurav.jokesclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.jokesclient.data.model.APIResponse
import com.gaurav.jokesclient.databinding.ActivityMainBinding
import com.gaurav.jokesclient.presentation.adapter.JokesAdapter
import com.gaurav.jokesclient.presentation.viewmodel.JokesViewModel
import com.gaurav.jokesclient.presentation.viewmodel.JokesViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
     val factory: JokesViewModelFactory by inject()
     val jokesAdapter: JokesAdapter by inject()
    val viewModel by viewModel<JokesViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var country = "us"
    private var page = 1
    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false
    private var pages = 0
    private var jokesList= mutableListOf<APIResponse>()
    private var linearLayoutManager:LinearLayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {

        viewModel.getJokesList()
        viewModel.jokesList.observe(this,{ response->
            when(response){
                is com.gaurav.jokesclient.data.util.Resource.Success->{

                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG","came here ${it.size}")


                        jokesAdapter.differ.submitList(it.asReversed())
                        binding.rvNews.smoothScrollToPosition(it.size)


                    }
                }
                is com.gaurav.jokesclient.data.util.Resource.Error->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(this,"An error occurred : $it", Toast.LENGTH_LONG).show()
                        Log.e("Error",it)
                    }
                }

                is com.gaurav.jokesclient.data.util.Resource.Loading->{
                    showProgressBar()
                }

            }
        })
    }

    private fun initRecyclerView() {
        linearLayoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,true)
        binding.rvNews.apply {
            adapter = jokesAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(this@MainActivity.onScrollListener)
        }
        binding.rvNews.scrollToPosition(5)

    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        binding.progressBar.visibility = View.GONE
    }

    private val onScrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }

        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
           /* val layoutManager = binding.rvNews.layoutManager as LinearLayoutManager
            val sizeOfTheCurrentList = layoutManager.itemCount
            val visibleItems = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()

            val hasReachedToEnd = topPosition+visibleItems >= sizeOfTheCurrentList
            val shouldPaginate = !isLoading && !isLastPage && hasReachedToEnd && isScrolling
            if(shouldPaginate){
                page++
                viewModel.getNewsHeadLines()
                isScrolling = false

            }*/


        }
    }



}