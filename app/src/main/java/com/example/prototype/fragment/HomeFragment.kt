package com.example.prototype.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prototype.MainActivity
import com.example.prototype.OffsetItemDecoration
import com.example.prototype.R
import com.example.prototype.adapter.MainAdapter
import com.example.prototype.adapter.ViewPagerBannerAdapter
import com.example.prototype.adapter.ViewPagerTabAdapter
import com.example.prototype.data.BannerData
import com.example.prototype.data.MainContentData
import com.example.prototype.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    lateinit var mainActivity: MainActivity
    lateinit var mainAdapter: MainAdapter
    val mainContentDatas = mutableListOf<MainContentData>()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vpMain.adapter = ViewPagerBannerAdapter(getViewPagerBannerList())
        binding.vpTab.adapter = ViewPagerTabAdapter(getViewPagerTabList())

        binding.vpTab.addItemDecoration(OffsetItemDecoration(20, "tab"))

        binding.rvContent.addItemDecoration(OffsetItemDecoration(40, "content"))
        initRecycler()

    }

    private fun initRecycler() {
        mainAdapter = MainAdapter(mainActivity)
        binding.rvContent.adapter = mainAdapter


        mainContentDatas.apply {
            add(MainContentData(
                contentTitle = "Sunshine in Marshville Blindbox",
                contentText = "마쉬빌이 온통 초록으로 물드는 계절이 다가왔어요.\n" +
                        "빛나는 햇빛 아래에서 친구들은 어떤 일을 하며 시간을 보낼까요?\n" +
                        "따스한 햇살이 비치는 마쉬빌의 천진난만한 모습을 담은 다이노탱의 첫 블라인드 박스 시리즈를 소개합니다.",
                contentImage = R.drawable.main_content1
            ))
            add(MainContentData(
                contentTitle = "온 세상이 너를 응원해!",
                contentText = "Lㅏ ㄸrㄹㅏ하ㅈl □ㅏ...!\n" +
                        "그림 □r음ㄷH로 ㅍㅓ7ㅏ..,,,!\n" +
                        "ㄷH신 초l고심 ol름을 전서l7ㅖ에 알zㅕ..!",
                contentImage = R.drawable.main_content2
            ))
            add(MainContentData(
                contentTitle = "우리의 배경화면이 무르익을 때",
                contentText = "안녕하세요\n" +
                        "날이 요즘 많이 좋아졌어요. 벌써 봄이 오고있네요\n" +
                        "저번에 꽃 그림을 올렸더니 꽃이 벌써 피었다는 지역도 있다는 이야기를 해주셔서\n" +
                        "너무 설레고 행복했어요 !",
                contentImage = R.drawable.main_content3
            ))

            mainAdapter.datas = mainContentDatas
            mainAdapter.notifyDataSetChanged()
        }


    }

    // 뷰 페이저에 들어갈 아이템
    private fun getViewPagerBannerList(): MutableList<BannerData> {
        return mutableListOf<BannerData>().apply {
            add(BannerData(img = R.drawable.house1, title = "간편하게 멋내는 법", susTitle = "다이노탱 이벤트 9.1 ~ 9.30"))
            add(BannerData(img = R.drawable.house2, title = "너뭐돼?", susTitle = "우리들의 자존감 지킴이\n최고심 이벤트 9.1 ~ 9.30"))
            add(BannerData(img = R.drawable.house3, title = "지금 만나러 가요", susTitle = "우이 작가 만나러가기"))
        }
//        return arrayListOf<Int>(R.drawable.house1, R.drawable.house2, R.drawable.house3)
    }

    // 뷰 페이저에 들어갈 탭
    private fun getViewPagerTabList(): ArrayList<String> {
        return arrayListOf<String>("MENU 1", "MENU 2", "MENU 3", "MENU 4", "MENU 5", "MENU 6", "MENU 7")
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }

}