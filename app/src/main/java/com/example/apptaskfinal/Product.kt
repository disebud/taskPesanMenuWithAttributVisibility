package com.example.apptaskfinal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat
import java.util.*

@Parcelize
data class Product(var nama : String = "" , var harga : Int = 0 , var jumlah : Int = 0):Parcelable{
    val total : Int
    get() = harga * jumlah
    val hargaRupiah : String
    get() {
        if (harga != 0){
            val locale = Locale("in","ID")
            val numberFormat = NumberFormat.getNumberInstance(locale)
            return "Rp. " + numberFormat.format(harga)
        }
        return "Rp.0"
    }
    val totalRupiah : String
        get() {
            if (total != 0){
                val locale = Locale("in","ID")
                val numberFormat = NumberFormat.getNumberInstance(locale)
                return "Rp. " + numberFormat.format(total)
            }
            return "Rp.0"
        }

}