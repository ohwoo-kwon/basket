package kr.co.bitz.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.bitz.adapter.RegionAdapter
import kr.co.bitz.model.Region
import kr.co.bitz.databinding.FragmentHomeBinding

class HomeFrgament(private val owner: AppCompatActivity) : Fragment() {


    private lateinit var binding :FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val list = mutableListOf(
            Region("서울"),
            Region("경기"),
            Region("인천"),
            Region("대전"),
            Region("대구"),
            Region("충북"),
            Region("충남"),
            Region("부산"),
            Region("경북"),
            Region("울산"),
            Region("광주"),
            Region("강원"),
            Region("전북")
        )

        val adpater = RegionAdapter(list ,owner)
        binding.regionRecyclerview.layoutManager = LinearLayoutManager(owner,LinearLayoutManager.HORIZONTAL,false)
        binding.regionRecyclerview.adapter = adpater
        return binding.root
    }



}