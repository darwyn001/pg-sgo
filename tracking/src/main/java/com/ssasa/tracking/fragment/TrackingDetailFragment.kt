package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssasa.tracking.adapter.TrackingDetailAdapter
import com.ssasa.tracking.databinding.FragmentTrackingDetailBinding
import com.ssasa.tracking.pojo.GestionDetail
import java.util.*
import kotlin.collections.ArrayList

class TrackingDetailFragment : Fragment() {
    private lateinit var binding: FragmentTrackingDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, dInstanceState: Bundle?): View {
        binding = FragmentTrackingDetailBinding.inflate(inflater, container, false)

        val gestion = TrackingDetailFragmentArgs.fromBundle(requireArguments()).gestion

        with(gestion) {
            with(binding) {
                textViewNombreClienteTrackingDetail.text = clientName
                textViewDescripcionEstadoGestionTrackingDetail.text = statusDescription
                getStatus(statusGestion, imageViewEstadoTrackingDetail)

                recyclerViewTrackingDetail.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                recyclerViewTrackingDetail.adapter = getAdapter()
            }
        }

        return binding.root
    }

    private fun getAdapter(): TrackingDetailAdapter {
        /*TODO: consume API to get gestion details*/

        val gestionParams = ArrayList(listOf(1, 2, 3, 4))

        val calendar = Calendar.getInstance()
        val detailData = ArrayList(
                listOf(
                        GestionDetail("Revisión DPI", "No se ven claras las fotos del DPI, por favor, subirlas nuevamente", "Créditos", 1, calendar.time, gestionParams),
                        GestionDetail("Revisión DPI", "Se están revisando los número de CUI", "Créditos", 0, calendar.time, null),
                        GestionDetail("Revisión DPI", "Se están revisando los número de CUI", "Créditos", 0, calendar.time, null),
                        GestionDetail("Revisión DPI", "Se están revisando los número de CUI", "Créditos", 0, calendar.time, null),
                        GestionDetail("Revisión DPI", "Se están revisando los número de CUI", "Créditos", 0, calendar.time, null),
                        GestionDetail("Revisión DPI", "Se están revisando los número de CUI", "Créditos", 0, calendar.time, null)
                )
        )


        return TrackingDetailAdapter(detailData)
    }

}