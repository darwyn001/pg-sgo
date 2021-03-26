package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ssasa.tracking.databinding.FragmentTrackingMainBinding

class TrackingMain : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentTrackingMainBinding.inflate(inflater, container, false).root
    }
}