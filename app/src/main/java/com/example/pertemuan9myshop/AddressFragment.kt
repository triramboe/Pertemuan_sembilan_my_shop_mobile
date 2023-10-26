package com.example.pertemuan9myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pertemuan9myshop.databinding.FragmentAddressBinding


class AddressFragment : Fragment() {

   private lateinit var binding: FragmentAddressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnDone.setOnClickListener{
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.
                            set("address", edtAddressText.text.toString())
                }.navigateUp()
            }
        }
    }
}