package com.ssasa.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssasa.tracking.adapter.TrackingDetailAdapter
import com.ssasa.tracking.databinding.FragmentTrackingDetailBinding
import com.ssasa.tracking.pojo.Gestion
import com.ssasa.tracking.pojo.GestionDetail
import java.util.*
import kotlin.collections.ArrayList

class TrackingDetailFragment : Fragment() {
    private lateinit var binding: FragmentTrackingDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackingDetailBinding.inflate(inflater, container, false)


        binding.recyclerViewTrackingDetail.setHasFixedSize(true)
        binding.recyclerViewTrackingDetail.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewTrackingDetail.adapter = getAdapter()

        return binding.root
    }

    private fun getAdapter(): TrackingDetailAdapter {
        val dataList = ArrayList<GestionDetail>().apply {
            add(
                GestionDetail(
                    "Instalación de equipo de computo ",
                    "",
                    "IT",
                    1,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Se enviaron los insumos de IT",
                    "Insumos enviados correctamente, se espera que se reciban mañana en la ubicación",
                    "Logistica",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Requerimiento de insumos de técnología",
                    "Favor, enviar insumos solicitados anteriormente",
                    "IT",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Creación de patente de comercio",
                    "La patente de comercio se registró correctamente",
                    "Legal",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Creación de NIT",
                    "El NIT se registró correctamente ante la SAT",
                    "Legal",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Solicitud de insumos de técnología ",
                    "Se solicitan 20 servidores y 5 bobinas de cable UTP",
                    "IT",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Creación de tienda en sistema \"Almacen\" ",
                    "Se creo la tienda código TF1501",
                    "IT",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Repción de solicitud de creación de tienda",
                    "Se procederá con la creación de la tienda",
                    "IT",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
            add(
                GestionDetail(
                    "Creación de solicitud",
                    "Favor, crear nueva tienda para Xela",
                    "Comercial",
                    0,
                    Calendar.getInstance().time,
                    null
                )
            )
        }
        return TrackingDetailAdapter(dataList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val g = Gestion("Tienda Xela", "En proceso", 1, 1)

        with(binding) {
            textViewNombreClienteTrackingDetail.text = g.clientName
            textViewDescripcionEstadoGestionTrackingDetail.text = g.statusDescription

            g.getStatus(g.statusGestion, binding.imageViewEstadoTrackingDetail)
        }
    }

}