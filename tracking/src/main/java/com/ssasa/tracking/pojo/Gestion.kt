package com.ssasa.tracking.pojo

import android.widget.ImageView
import com.ssasa.tracking.R

data class Gestion(
        val clientName: String,
        val statusDescription: String,
        val numberGestion: Int,
        val statusGestion: Int
) {

    fun getStatus(statusGestion: Int, imageView: ImageView) {
        when (statusGestion) {
            0 -> //Requiere atención
                imageView.setImageResource(R.drawable.ic_process)

            1 -> //En proceso
                imageView.setImageResource(R.drawable.ic_reload)

            2 -> //Aprobado con observaciones
                imageView.setImageResource(R.drawable.ic_approved_comments)

            3 -> //Finalizado
                imageView.setImageResource(R.drawable.ic_realized)

            4 -> //Denegado
                imageView.setImageResource(R.drawable.ic_error)

        }
    }
}
