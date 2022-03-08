package com.example.qoutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        setQoute(mainViewModel.getQoute())
    }

    fun setQoute(qoute: Qoute) {
        tvquote.text = qoute.text
        tvqoutes2.text = qoute.author
    }

    fun onPrevious(view: View) {
        setQoute(mainViewModel.previousQoute())
    }

    fun onNext(view: View) {
        setQoute(mainViewModel.nextQoute())
    }
}