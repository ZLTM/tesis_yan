package com.example.senthil.kotlin_tablayout.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.senthil.kotlin_tablayout.R

class DatosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //this receives the var

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos, container, false)
    }
}
