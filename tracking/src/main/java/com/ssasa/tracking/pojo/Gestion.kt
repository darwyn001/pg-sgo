package com.ssasa.tracking.pojo

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import com.ssasa.tracking.R

data class Gestion(
        val clientName: String,
        val statusDescription: String,
        val numberGestion: Int,
        val statusGestion: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(clientName)
        parcel.writeString(statusDescription)
        parcel.writeInt(numberGestion)
        parcel.writeInt(statusGestion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gestion> {
        override fun createFromParcel(parcel: Parcel): Gestion {
            return Gestion(parcel)
        }

        override fun newArray(size: Int): Array<Gestion?> {
            return arrayOfNulls(size)
        }
    }

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