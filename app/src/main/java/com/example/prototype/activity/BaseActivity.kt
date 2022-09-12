package com.example.prototype.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>(@LayoutRes val layoutRes: Int) : AppCompatActivity() {
    private var _binding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 초기화된 layoutResId 로 DataBinding 객체 생성
    }
}