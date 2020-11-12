package com.example.apptaskfinal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.apptaskfinal.databinding.FragmentMejaBinding


class MejaFragment : Fragment(),View.OnClickListener {

    private lateinit var binding : FragmentMejaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_meja,container,false)
//        return inflater.inflate(R.layout.fragment_meja, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTable1.setOnClickListener(this)
        binding.btnTable2.setOnClickListener(this)
        binding.btnTable3.setOnClickListener(this)
        binding.btnTable4.setOnClickListener(this)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
                || NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
    }


    override fun onClick(v: View?) {
        when(v){
            binding.btnTable1 -> {
//                v.findNavController()?.navigate(R.id.action_mejaFragment_to_menuFragment)
                v.findNavController().navigate(MejaFragmentDirections.actionMejaFragmentToMenuFragment("Meja 1"))
            }
            binding.btnTable2 -> {
//                v.findNavController()?.navigate(R.id.action_mejaFragment_to_menuFragment)
                v.findNavController().navigate(MejaFragmentDirections.actionMejaFragmentToMenuFragment("Meja 2"))
            }
            binding.btnTable3 -> {
//                v.findNavController()?.navigate(R.id.action_mejaFragment_to_menuFragment)
                v.findNavController().navigate(MejaFragmentDirections.actionMejaFragmentToMenuFragment("Meja 3"))
            }
            binding.btnTable4 -> {
//                v.findNavController()?.navigate(R.id.action_mejaFragment_to_menuFragment)
                v.findNavController().navigate(MejaFragmentDirections.actionMejaFragmentToMenuFragment("Meja 4"))
            }
        }
    }


}