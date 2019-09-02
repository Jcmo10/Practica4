package com.jcmo.practica4

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


class Peluches(var id: String?, var nombre: String?, var precio: String?, var cantidad: String?): Parcelable/*: Serializable   */{


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(precio)
        parcel.writeString(cantidad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Peluches> {
        override fun createFromParcel(parcel: Parcel): Peluches {
            return Peluches(parcel)
        }

        override fun newArray(size: Int): Array<Peluches?> {
            return arrayOfNulls(size)
        }
    }

}
