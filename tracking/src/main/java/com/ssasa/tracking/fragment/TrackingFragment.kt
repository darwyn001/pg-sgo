package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssasa.tracking.adapter.TrackingAdapter
import com.ssasa.tracking.databinding.FragmentTrackingBinding
import com.ssasa.tracking.interfaces.OnItemClickListener
import com.ssasa.tracking.pojo.Gestion

class TrackingFragment : Fragment() {
    private lateinit var binding: FragmentTrackingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTrackingBinding.inflate(layoutInflater, container, false)

        linkViews()

        return binding.root
    }

    private fun linkViews() {
        binding.recyclerViewTracking.setHasFixedSize(true)
        binding.recyclerViewTracking.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewTracking.adapter = getAdapter()
    }

    private fun getAdapter(): TrackingAdapter {
        val fakeData = mutableListOf<Gestion>();
        fakeData.add(Gestion("Amigo 1", "HOLAAAAA", 1, 1))
        fakeData.add(Gestion("Amigo 2", "HOLAAAAA", 2, 2))
        fakeData.add(Gestion("Amigo 3", "HOLAAAAA", 3, 3))
        fakeData.add(Gestion("Amigo 4", "HOLAAAAA", 4, 4))
        fakeData.add(Gestion("Amigo 5", "HOLAAAAA", 5, 5))

        return TrackingAdapter(fakeData, object : OnItemClickListener {
            override fun OnItemClickListener(view: View, selectedItem: Any) {

            }
        })
    }

}