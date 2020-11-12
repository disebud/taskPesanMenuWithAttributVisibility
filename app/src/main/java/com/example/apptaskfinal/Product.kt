package com.example.apptaskfinal

data class Product(var nama : String = "" , var harga : Double = 0.0 , var jumlah : Int = 0){
    val total : Double
    get() = harga * jumlah
}