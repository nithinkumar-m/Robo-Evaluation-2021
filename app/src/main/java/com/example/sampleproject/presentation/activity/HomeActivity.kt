package com.example.sampleproject.presentation.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.presentation.adapter.ImageListAdapter
import com.example.sampleproject.presentation.viewmodel.HomeViewModel
import com.example.sampleproject.utils.setImage
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.layout_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var imageListAdapter: ImageListAdapter
    private var pageSize = PAGE_SIZE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        updateToolbar()
        initView()
        callApi()
        observables()
    }

    private fun initView() {
        //Create Adapter and set up recycler view with adapter
        imageListAdapter = ImageListAdapter()
        recycler_image_list?.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = imageListAdapter
            addOnScrollListener(recyclerPageScrollListener)
        }
    }

    private val recyclerPageScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!recyclerView.canScrollVertically(1)) {
                setProgressBarVisibility(true)
                pageSize += 10
                viewModel.updatePage(pageSize)
            }
        }
    }

    private fun callApi() {
        viewModel.getBannerImage()
        viewModel.getImageList(pageSize)
    }

    private fun observables() {
        viewModel.bannerDetails.observe(this, Observer { banner ->
            expandedImage.setImage(
                banner.src.original
            )
        })

        viewModel.imageListLiveData.observe(this, Observer { imageList ->
            imageListAdapter.imageList = imageList
        })

        searchText.doAfterTextChanged {

        }
    }

    private fun updateToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        var isShow = true
        var scrollRange = -1
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1) {
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                toolbar_layout.title = "PHOTOPLAY"
                toolbar.visibility = View.VISIBLE
                isShow = true
            } else if (isShow) {
                toolbar_layout.title =
                    " " //careful there should a space between double quote otherwise it wont work
                isShow = false
                toolbar.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}