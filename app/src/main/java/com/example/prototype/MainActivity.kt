package com.example.prototype

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.prototype.activity.CameraActivity
import com.example.prototype.databinding.ActivityMainBinding
import com.example.prototype.fragment.HomeFragment
import com.example.prototype.fragment.MapFragment
import com.example.prototype.fragment.MyFragment

private const val TAG_HOME = "home_fragment"
//private const val TAG_CAMERA = "camera_fragment"
private const val TAG_MAP = "map_fragment"
private const val TAG_MY = "my_fragment"

class MainActivity : AppCompatActivity() {

    var menuPos = 0
    private lateinit var binding: ActivityMainBinding
//    lateinit var mainAdapter: MainAdapter
//    val mainContentDatas = mutableListOf<MainContentData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_menu_home -> { //홈 아이콘 클릭시
                    // 홈 프래그먼트
                    // 상태바 흰색 유지
                    menuPos = 0
                    setFragment(TAG_HOME, HomeFragment())
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                }
                R.id.bottom_menu_camera -> { //카메라 아이콘 클릭시
                    // 카메라 액티비티
                    // 카메라 전체화면
                    var cameraIntent = Intent(this@MainActivity, CameraActivity::class.java)
                    startActivity(cameraIntent)

                }
                R.id.bottom_menu_map -> { //지도 아이콘 클릭시
                    // 지도 프래그먼트 ? 액티비티?
                    menuPos = 1
                    setFragment(TAG_MAP, MapFragment())
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                }
                R.id.bottom_menu_my -> { //마이 아이콘 클릭시
                    // 마이 프래그먼트
                    // 상태바 블립과 동일하게
                    menuPos = 2
                    setFragment(TAG_MY, MyFragment())
                    window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                }
            }
            true
        }

//        binding.vpMain.adapter = ViewPagerBannerAdapter(getViewPagerBannerList())
//        binding.vpTab.adapter = ViewPagerTabAdapter(getViewPagerTabList())
//
//        binding.vpTab.addItemDecoration(OffsetItemDecoration(20, "tab"))
//
//        binding.rvContent.addItemDecoration(OffsetItemDecoration(40, "content"))
//        initRecycler()
    }

    private fun setFragment(tag: String, fragment: Fragment){

        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if(manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
//        val camera = manager.findFragmentByTag(TAG_CAMERA)
        val map = manager.findFragmentByTag(TAG_MAP)
        val my = manager.findFragmentByTag(TAG_MY)

        if(home != null) {
            fragTransaction.hide(home)
        }
//        if(camera != null) {
//            fragTransaction.hide(camera)
//        }
        if(map != null) {
            fragTransaction.hide(map)
        }
        if(my != null) {
            fragTransaction.hide(my)
        }

        if(tag == TAG_HOME) {
            if(home != null) {
                fragTransaction.show(home)
            }
        } else if(tag == TAG_MAP) {
            if(map != null) {
                fragTransaction.show(map)
            }
        } else if(tag == TAG_MY) {
            if(my != null) {
                fragTransaction.show(my)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}