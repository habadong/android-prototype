package com.example.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prototype.adapter.ViewPagerBannerAdapter
import com.example.prototype.adapter.ViewPagerTabAdapter
import com.example.prototype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.vpMain.adapter = ViewPagerBannerAdapter(getViewPagerBannerList())
        binding.vpTab.adapter = ViewPagerTabAdapter(getViewPagerTabList())

        binding.vpTab.addItemDecoration(OffsetItemDecoration(20, "tab"))
    }

    // 뷰 페이저에 들어갈 아이템
    private fun getViewPagerBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.house1, R.drawable.house2, R.drawable.house3)
    }

    private fun getViewPagerTabList(): ArrayList<String> {
        return arrayListOf<String>("MENU 1", "MENU 2", "MENU 3", "MENU 4", "MENU 5", "MENU 6", "MENU 7")
    }
//   본문 어댑터 생성?? 해야 될까 음음음음음음ㅇ므
//    private fun get
}