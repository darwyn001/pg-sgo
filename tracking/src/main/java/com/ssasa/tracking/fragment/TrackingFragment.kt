package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssasa.tracking.ConfigTracking
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
        return TrackingAdapter(ConfigTracking.getInstance().mainList, object : OnItemClickListener {
            override fun OnItemClickListener(view: View, selectedItem: Any) {
                val action = TrackingFragmentDirections.actionTrackingFragmentToTrackingDetailFragment()
                action.gestion = selectedItem as Gestion
                Navigation.findNavController(view).navigate(action)

            }
        })
    }

}