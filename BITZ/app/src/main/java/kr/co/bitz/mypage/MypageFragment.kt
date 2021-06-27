package kr.co.bitz.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.co.bitz.BuildConfig
import kr.co.bitz.R
import kr.co.bitz.databinding.FragmentMypageBinding

class MypageFragment(val owner: AppCompatActivity) : Fragment() {


    private lateinit var binding : FragmentMypageBinding
    val version = BuildConfig.VERSION_NAME

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentMypageBinding.inflate(inflater,container,false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mypage,container,false)
        binding.my = this
        return binding.root
    }
}
