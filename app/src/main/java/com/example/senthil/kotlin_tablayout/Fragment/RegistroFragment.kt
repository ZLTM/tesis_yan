package com.example.senthil.kotlin_tablayout.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.R


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val receivingFragment = AboutUsFragment()
        val args = Bundle()
        args.putString("Key", "Value")
        receivingFragment.setArguments(args)

        fragmentManager!!.beginTransaction().add(R.id.container, receivingFragment).commit()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
