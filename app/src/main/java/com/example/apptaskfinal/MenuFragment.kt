package com.example.apptaskfinal

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.apptaskfinal.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

//    lateinit var productSatu: Product
//    lateinit var productDua: Product
//    lateinit var productTiga: Product

        private var productSatuD: Product = Product()
    private var productDuaD: Product = Product()
    private var productTigaD: Product = Product()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_menu, container, false)
//        binding.productSatu = productSatu
//        binding.productDua = productDua
//        binding.productTiga = productTiga

        binding.apply {

            productSatu = productSatuD
            productDua = productDuaD
            productTiga = productTigaD

            val args = MenuFragmentArgs.fromBundle(requireArguments())
            mejaLayout = args.meja

            btnHitung.setOnClickListener { view: View ->
//             // Init Product 1
                val product1 = Product(etPesanMenu1.text.toString())
                if(etHarga1.text.isNotEmpty())
                {
                    product1.harga = etHarga1.text.toString().toInt()
                }
                if(etJlh1.text.isNotEmpty())
                {
                    product1.jumlah=etJlh1.text.toString().toInt()
                }
                // Init Product 2
                val product2 = Product(etPesanMenu2.text.toString())
                if(etHarga2.text.isNotEmpty())
                {
                    product2.harga = etHarga2.text.toString().toInt()
                }
                if(etJlh2.text.isNotEmpty())
                {
                    product2.jumlah=etJlh2.text.toString().toInt()
                }
                // Init Product 3
                val product3 = Product(etPesanMenu3.text.toString())
                if(etHarga3.text.isNotEmpty())
                {
                    product3.harga = etHarga3.text.toString().toInt()
                }
                if(etJlh3.text.isNotEmpty())
                {
                    product3.jumlah=etJlh3.text.toString().toInt()
                }

                invalidateAll()

                if(product1.nama != "" && product1.harga != 0 && product1.jumlah != 0){
                    if(product2.harga == 0 || product2.jumlah == 0){
                        product2.nama = "-"
                        product2.harga = 0
                        product2.jumlah = 0
                    }
                    if(product3.harga == 0 || product3.jumlah == 0){
                        product3.nama = "-"
                        product3.harga = 0
                        product3.jumlah = 0
                    }
                 view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToHasilFragment(product1,product2,product3,args.meja))
                }


            }

        }
//        return inflater.inflate(R.layout.fragment_menu, container, false)
        return  binding.root

    }

    private fun hitungMenu(binding: FragmentMenuBinding){
        binding.apply {
                productSatu?.nama = etPesanMenu1.text.toString()
                productSatu?.harga = etHarga1.text.toString().toInt()
                productSatu?.jumlah = etJlh1.text.toString().toInt()

                productDua!!.nama = etPesanMenu2.text.toString()
                var hargaDua = etHarga2.text.toString()
                productDua!!.harga = hargaDua.toInt()
                productDua!!.jumlah = etJlh2.text.toString().toInt()

                productTiga!!.nama = etPesanMenu3.text.toString()
                var hargaTiga = etHarga3.text.toString()
                productTiga!!.harga = hargaTiga.toInt()
                productTiga!!.jumlah = etJlh3.text.toString().toInt()

            invalidateAll()
        }
    }




}