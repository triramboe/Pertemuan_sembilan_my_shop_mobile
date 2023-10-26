package com.example.pertemuan9myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pertemuan9myshop.databinding.FragmentCheckOutBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckOutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckOutFragment : Fragment() {


    private lateinit var binding: FragmentCheckOutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckOutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val args : CheckOutFragmentArgs by navArgs()
            textProductName.setText(args.productName)

            btnDone.setOnClickListener{
                findNavController().navigateUp()
            }

            edtAddress.setOnClickListener{
                val action = CheckOutFragmentDirections.actionCheckOutFragmentToAddressFragment()
                findNavController().navigate(action)
            }

            findNavController().currentBackStackEntry?.savedStateHandle?.let {
                handle ->
                handle.getLiveData<String>("address").observe(viewLifecycleOwner){
                    res->
                    edtAddress.setText(res)
                }
            }
        }
    }

}