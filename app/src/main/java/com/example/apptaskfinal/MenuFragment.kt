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

                if (etPesanMenu1.text.toString() == "" || etHarga1.text.toString() == "" || etJlh1.text.toString() == ""
                    || etPesanMenu2.text.toString() == "" || etHarga2.text.toString() == "" || etJlh2.text.toString() == ""
                    || etPesanMenu3.text.toString() == "" || etHarga3.text.toString() == "" || etJlh3.text.toString() == ""
                ) {
                    Toast.makeText(activity, "Masih ada inputan kosong", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    hitungMenu(binding)
                    view.findNavController().navigate(
                        MenuFragmentDirections.actionMenuFragmentToHasilFragment(
                            productSatuD,
                            productDuaD,
                            productTigaD,
                            args.meja
                        )
                    )
                }
            }
            invalidateAll()
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