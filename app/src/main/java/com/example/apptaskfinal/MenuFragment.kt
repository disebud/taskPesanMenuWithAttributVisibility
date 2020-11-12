package com.example.apptaskfinal

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

    lateinit var productSatu: Product
    lateinit var productDua: Product
    lateinit var productTiga: Product


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val binding: FragmentMenuBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_menu, container, false)
//        binding.productSatu = productSatu
//        binding.productDua = productDua
//        binding.productTiga = productTiga

        binding.apply {

            if (etPesanMenu1.text.toString() == "" || etHarga1.text.toString() == "" || etJlh1.text.toString() == ""
                || etPesanMenu2.text.toString() == "" || etHarga2.text.toString() == "" || etJlh2.text.toString() == ""
                || etPesanMenu3.text.toString() == "" || etHarga3.text.toString() == "" || etJlh3.text.toString() == ""
            ) {

                Toast.makeText(requireContext(), "Masih ada inputan kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                productSatu =  Product()
                productDua =  Product()
                productTiga =  Product()
                productSatu!!.nama = etPesanMenu1.text.toString()
                productSatu!!.harga = etHarga1.text.toString().toInt()
                productSatu!!.jumlah = etJlh1!!.text.toString().toInt()

                productDua!!.nama = etPesanMenu2.text.toString()
                var hargaDua = etHarga2.text.toString()
                productDua!!.harga = hargaDua.toInt()
                productDua!!.jumlah = etJlh2.text.toString().toInt()

                productTiga!!.nama = etPesanMenu3.text.toString()
                var hargaTiga = etHarga3.text.toString()
                productTiga!!.harga = hargaTiga.toInt()
                productTiga!!.jumlah = etJlh3.text.toString().toInt()

//            var grandTotal = totalMenu1!! + totalMenu2!! + totalMenu3!!


                invalidateAll()
            }
        }

        val args = MenuFragmentArgs.fromBundle(requireArguments())
        binding.mejaLayout = args.meja
        binding.btnHitung.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            view.findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToHasilFragment(
                    productSatu,
                    productDua,
                    productTiga,
                    args.meja
                )
            )
        }

//        return inflater.inflate(R.layout.fragment_menu, container, false)

        return  binding.root

    }

}