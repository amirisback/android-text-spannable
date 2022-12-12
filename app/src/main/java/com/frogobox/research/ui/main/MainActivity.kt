package com.frogobox.research.ui.main

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.activity.viewModels
import com.frogobox.research.R
import com.frogobox.research.core.BaseBindActivity
import com.frogobox.research.databinding.ActivityMainBinding

class MainActivity : BaseBindActivity<ActivityMainBinding>() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModels()

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // Call View Model Here
            Log.d(TAG, "View Model : ${viewModel::class.java.simpleName}")
        }
        // TODO : Add your code here

    }

    override fun initView() {
        super.initView()
        binding.apply {

            val simpleText = "Nama : Faisal Amir"
            val tagName = "Faisal Amir"

            tvText.text = simpleText.setColouredSpan(tagName, R.color.teal_700)
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }
    }

    fun String.setColouredSpan(word: String, color: Int) : SpannableString {
        val spannableString = SpannableString(this)
        val start = this.indexOf(word)
        val end = this.indexOf(word) + word.length
        try {
            spannableString.setSpan(ForegroundColorSpan(color),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        } catch (e: IndexOutOfBoundsException) {
            Log.e(TAG, "'$word' was not not found in TextView text")
        }

        return spannableString
    }

    fun SpannableString.setColouredSpan(word: String, color: Int) : SpannableString {
        val spannableString = SpannableString(this)
        val start = this.indexOf(word)
        val end = this.indexOf(word) + word.length
        try {
            spannableString.setSpan(ForegroundColorSpan(color),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        } catch (e: IndexOutOfBoundsException) {
            Log.e(TAG, "'$word' was not not found in TextView text")
        }

        return spannableString
    }

}