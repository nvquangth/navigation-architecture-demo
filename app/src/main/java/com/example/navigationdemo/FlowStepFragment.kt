package com.example.navigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        val safeArgs: FlowStepFragmentArgs by navArgs()
        val flowStep = safeArgs.flowStepNumber

        return when (flowStep) {
            1 -> inflater.inflate(R.layout.fragment_step_one, container, false)
            else -> inflater.inflate(R.layout.fragment_step_two, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_next).setOnClickListener {
//            findNavController().navigate(R.id.action_next)
//        }

        view.findViewById<Button>(R.id.button_next).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_next)
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}