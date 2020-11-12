package com.example.apptaskfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.apptaskfinal.databinding.FragmentHasilBinding
import com.example.apptaskfinal.databinding.FragmentMenuBinding

class HasilFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHasilBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_hasil, container, false)

        binding.btnMain2.setOnClickListener {  view :View ->
            view.findNavController().navigate(R.id.action_hasilFragment_to_mejaFragment)
//            view.findNavController().navigate(HasilFragmentDirections.actionHasilFragmentToMejaFragment())
        }

        binding.btnBack2.setOnClickListener {  view :View ->
            view.findNavController().navigate(R.id.action_hasilFragment_to_menuFragment)
        }

        val args = HasilFragmentArgs.fromBundle(requireArguments())
        val productSatu : Product = args.product1
        val productDua : Product = args.product2
        val productTiga : Product = args.product3

        binding.productSatu3 = productSatu
        binding.productDua3 = productDua
        binding.productTiga3 = productTiga

        binding.jumlahTotal3 = productSatu!!.total + productDua!!.total + productTiga!!.total

        binding.mejaLayout3 = args.meja3

        return  binding.root

    }


}