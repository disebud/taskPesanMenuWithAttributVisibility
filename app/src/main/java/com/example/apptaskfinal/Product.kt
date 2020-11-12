package com.example.apptaskfinal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(var nama : String = "" , var harga : Int = 0 , var jumlah : Int = 0):Parcelable{
    val total : Int
    get() = harga * jumlah
}