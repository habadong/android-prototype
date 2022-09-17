package com.example.prototype.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.prototype.R
import com.example.prototype.databinding.FragmentMyBinding

class MyFragment : BaseFragment<FragmentMyBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMyBinding {
        return FragmentMyBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeInclude.toolbar.title = "마이 페이지"
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

}