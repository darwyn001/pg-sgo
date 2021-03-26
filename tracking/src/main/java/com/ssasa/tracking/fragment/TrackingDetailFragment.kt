package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ssasa.tracking.databinding.FragmentTrackingDetailBinding
import com.ssasa.tracking.pojo.Gestion

class TrackingDetailFragment(
        private val gestion: Gestion
) : Fragment() {
    private lateinit var binding: FragmentTrackingDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTrackingDetailBinding.inflate(inflater, container, false)
        val d = gestion.clientName
        return binding.root
    }

}