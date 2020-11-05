package com.example.apptaskfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ButtonClicked(view: View){
        if(view is Button){
            var clicked = view.isClickable

            when(view){
                btn_table_1 -> {
                    if (clicked){
                        firstLayout.visibility = View.GONE
                        secondLayout.visibility = View.VISIBLE

                        meja_x_layout_2.text = btn_table_1.text.toString()
                    }
                }
                btn_table_2 -> {
                    if (clicked){
                        firstLayout.visibility = View.GONE
                        secondLayout.visibility = View.VISIBLE

                        meja_x_layout_2.text = btn_table_2.text.toString()
                    }
                }
                btn_table_3 -> {
                    if (clicked){
                        firstLayout.visibility = View.GONE
                        secondLayout.visibility = View.VISIBLE

                        meja_x_layout_2.text = btn_table_3.text.toString()
                    }
                }
                btn_table_4 -> {
                    if (clicked){
                        firstLayout.visibility = View.GONE
                        secondLayout.visibility = View.VISIBLE

                        meja_x_layout_2.text = btn_table_4.text.toString()
                    }
                }
                btn_hitung -> {
                    if (clicked){
                        hitungTotal()
                    }
                }
                btn_back_2 -> {
                    if (clicked){
                        firstLayout.visibility = View.GONE
                        thirdLayout.visibility = View.GONE
                        secondLayout.visibility = View.VISIBLE
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

        if (et_pesan_menu1.text.toString() == "" || et_harga_1.text.toString() == "" || et_jlh_1.text.toString() == ""
            || et_pesan_menu2.text.toString() == "" || et_harga_2.text.toString() == "" || et_jlh_2.text.toString() == ""
            || et_pesan_menu3.text.toString() == "" || et_harga_3.text.toString() == "" || et_jlh_3.text.toString() == ""){

            Toast.makeText(this, "Masih ada inputan kosong", Toast.LENGTH_SHORT).show()
        }else {
            var totalMenu1 = 0
            var totalMenu2 = 0
            var totalMenu3 = 0
            firstLayout.visibility = View.GONE
            secondLayout.visibility = View.GONE
            thirdLayout.visibility = View.VISIBLE
            meja_x_layout_3.text = meja_x_layout_2.text.toString()

            tv_pesan_menu1.text = et_pesan_menu1.text.toString()
            currency(et_harga_1.text.toString().toDouble(), tv_harga_1)
            tv_jlh_1.text = et_jlh_1.text.toString()
            totalMenu1 = et_harga_1.text.toString().toInt() * et_jlh_1.text.toString().toInt()
            currency(totalMenu1!!.toDouble(), tv_jlh_menu_1)


            tv_pesan_menu2.text = et_pesan_menu2.text.toString()
            currency(et_harga_2.text.toString().toDouble(), tv_harga_2)
            tv_jlh_2.text = et_jlh_2.text.toString()
            totalMenu2 = et_harga_2.text.toString().toInt() * et_jlh_2.text.toString().toInt()
            currency(totalMenu2!!.toDouble(), tv_jlh_menu_2)

            tv_pesan_menu3.text = et_pesan_menu3.text.toString()
            currency(et_harga_3.text.toString().toDouble(), tv_harga_3)
            tv_jlh_3.text = et_jlh_3.text.toString()
            totalMenu3 = et_harga_3.text.toString().toInt() * et_jlh_3.text.toString().toInt()
            currency(totalMenu3!!.toDouble(), tv_jlh_menu_3)

            var grandTotal = totalMenu1 + totalMenu2 + totalMenu3
            currency(grandTotal!!.toDouble(), tv_grand_total)
        }

    }

    fun editPesanan(view: View) {
        firstLayout.visibility = View.GONE
        thirdLayout.visibility = View.GONE
        secondLayout.visibility = View.VISIBLE
    }

    fun backHome() {
        thirdLayout.visibility = View.GONE
        secondLayout.visibility = View.GONE
        firstLayout.visibility = View.VISIBLE

        et_pesan_menu1.text.clear()
        et_harga_1.text.clear()
        et_jlh_1.text.clear()

        et_pesan_menu2.text.clear()
        et_harga_2.text.clear()
        et_jlh_2.text.clear()

        et_pesan_menu3.text.clear()
        et_harga_3.text.clear()
        et_jlh_3.text.clear()

    }

    fun currency(harga: Double, textView: TextView) {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        textView.text = formatRupiah.format(harga as Double)
    }
}