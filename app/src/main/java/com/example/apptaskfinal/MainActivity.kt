package com.example.apptaskfinal

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apptaskfinal.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var productSatu : Product = Product()
    private var productDua : Product = Product()
    private var productTiga : Product = Product()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.productSatu = productSatu
        binding.productDua = productDua
        binding.productTiga = productTiga
    }

    fun ButtonClicked(view: View){
        if(view is Button){
            var clicked = view.isClickable
            binding.firstLayout.visibility = View.GONE
            binding.secondLayout.visibility = View.VISIBLE

            when(view){
                binding.btnTable1 -> {
                    if (clicked){
                        binding.mejaXLayout2.text = binding.btnTable1.text.toString()
                    }
                }
                binding.btnTable2 -> {
                    if (clicked){
                        binding.mejaXLayout2.text = binding.btnTable2.text.toString()
                    }
                }
                binding.btnTable3 -> {
                    if (clicked){
                        binding.mejaXLayout2.text = binding.btnTable3.text.toString()
                    }
                }
                binding.btnTable4 -> {
                    if (clicked){
                        binding.mejaXLayout2.text = binding.btnTable4.text.toString()
                    }
                }
                binding.btnHitung -> {
                    if (clicked){
                        hitungTotal()
                    }
                }
                binding.btnBack2 -> {
                    if (clicked){
                        binding.firstLayout.visibility = View.GONE
                        binding.thirdLayout.visibility = View.GONE
                        binding.secondLayout.visibility = View.VISIBLE
                    }
                }
                else ->{
                    backHome()
                }
            }
        }

    }

    fun mejaSatu(view: View) {
        firstLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE

        meja_x_layout_2.text = btn_table_1.text.toString()
    }
    fun mejaDua(view: View) {
        firstLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE

        meja_x_layout_2.text = btn_table_2.text.toString()
    }
    fun mejaTiga(view: View) {
        firstLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE

        meja_x_layout_2.text = btn_table_3.text.toString()
    }
    fun mejaEmpat(view: View) {
        firstLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE

        meja_x_layout_2.text = btn_table_4.text.toString()
    }

    fun hitungTotal() {
        binding.apply {
        if (etPesanMenu1.text.toString() == "" || etHarga1.text.toString() == "" || etJlh1.text.toString() == ""
            || etPesanMenu2.text.toString() == "" || etHarga2.text.toString() == "" || etJlh2.text.toString() == ""
            || etPesanMenu3.text.toString() == "" || etHarga3.text.toString() == "" || etJlh3.text.toString() == ""){

            Toast.makeText(this@MainActivity, "Masih ada inputan kosong", Toast.LENGTH_SHORT).show()
        }else {
            var totalMenu1 = 0
            var totalMenu2 = 0
            var totalMenu3 = 0
            firstLayout.visibility = View.GONE
            secondLayout.visibility = View.GONE
            thirdLayout.visibility = View.VISIBLE
            mejaXLayout3.text = mejaXLayout2.text.toString()
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
//            textView.text = formatRupiah.format(harga as Double)

            val number = 1000000000.0
            val COUNTRY = "US"
            val LANGUAGE = "en"
            val str = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(number)


            productSatu?.nama = etPesanMenu1.text.toString()
//            tv_pesan_menu1.text = et_pesan_menu1.text.toString()
//            var hargaSatu = etHarga1.text.toString()
            productSatu?.harga = etHarga1.text.toString().toDouble()
//            productSatu?.harga = formatRupiah.format(hargaSatu as Double)!!.toDouble()!!
//            currency(et_harga_1.text.toString().toDouble(), tv_harga_1)
            productSatu!!.jumlah = etJlh1.text.toString().toInt()
//            tv_jlh_1.text = et_jlh_1.text.toString()
//            totalMenu1 = productSatu!!.harga?.toInt()?.times(productSatu!!.jumlah!!) ?: 0
//            currency(totalMenu1!!.toDouble(), tv_jlh_menu_1)
//            tvJlhMenu1.text = formatRupiah.format(totalMenu1 as Double)
//            tvJlhMenu1.text = totalMenu1.toString()

//            tv_pesan_menu2.text = et_pesan_menu2.text.toString()
//            currency(et_harga_2.text.toString().toDouble(), tv_harga_2)
//            tv_jlh_2.text = et_jlh_2.text.toString()
//            totalMenu2 = et_harga_2.text.toString().toInt() * et_jlh_2.text.toString().toInt()
//            currency(totalMenu2!!.toDouble(), tv_jlh_menu_2)

            productDua?.nama = etPesanMenu2.text.toString()
            var hargaDua = etHarga2.text.toString()
            productDua?.harga = hargaDua.toDouble()
//            productDua?.harga = formatRupiah.format(hargaDua as Double).toString().toDouble()
            productDua?.jumlah = etJlh2.text.toString().toInt()
            totalMenu2 = productDua!!.harga?.toInt()?.times(productDua!!.jumlah!!) ?: 0
//            tvJlhMenu2.text = formatRupiah.format(totalMenu2 as Double).toString()
            tvJlhMenu2.text = totalMenu2.toString()
//
//            tv_pesan_menu3.text = et_pesan_menu3.text.toString()
//            currency(et_harga_3.text.toString().toDouble(), tv_harga_3)
//            tv_jlh_3.text = et_jlh_3.text.toString()
//            totalMenu3 = et_harga_3.text.toString().toInt() * et_jlh_3.text.toString().toInt()
//            currency(totalMenu3!!.toDouble(), tv_jlh_menu_3)

            productTiga?.nama = etPesanMenu3.text.toString()
            var hargaTiga = etHarga3.text.toString()
            productTiga?.harga = hargaTiga.toDouble()
//            productTiga?.harga = formatRupiah.format(hargaTiga as Double).toString().toDouble()
            productTiga?.jumlah = etJlh3.text.toString().toInt()
//            totalMenu3 = productTiga!!.harga?.toInt()?.times(productTiga!!.jumlah!!) ?: 0
//            tvJlhMenu3.text = formatRupiah.format(totalMenu3 as Double).toString()
//            tvJlhMenu3.text = totalMenu3.toString()

//            var grandTotal = totalMenu1!! + totalMenu2!! + totalMenu3!!
            jumlahTotal = productSatu!!.total + productDua!!.total + productTiga!!.total

//            tvGrandTotal!!.text = grandTotal.toString()
//            currency(grandTotal!!.toDouble(), tv_grand_total)
        }
            invalidateAll()
        }


    }

    fun editPesanan(view: View) {
        firstLayout.visibility = View.GONE
        thirdLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE
    }

    fun backHome() {
        binding.apply {
        thirdLayout.visibility = View.GONE
        secondLayout.visibility = View.GONE
        firstLayout.visibility = View.VISIBLE

        etPesanMenu1.text.clear()
        etHarga1.text.clear()
        etJlh1.text.clear()

            etPesanMenu2.text.clear()
            etHarga2.text.clear()
            etJlh2.text.clear()

            etPesanMenu3.text.clear()
            etHarga3.text.clear()
            etJlh3.text.clear()

        }

    }

    fun currency(harga: Double, textView: TextView) {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        textView.text = formatRupiah.format(harga as Double)
    }
}