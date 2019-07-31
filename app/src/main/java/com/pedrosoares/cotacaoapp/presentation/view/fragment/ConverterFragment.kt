package com.pedrosoares.cotacaoapp.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.pedrosoares.cotacaoapp.MainActivity
import com.pedrosoares.cotacaoapp.R
import kotlinx.android.synthetic.main.fragment_converter.*


class ConverterFragment : Fragment(), AdapterView.OnItemSelectedListener{

    var currencyItemList = arrayOf("Dólar Americano", "Euro", "Peso Argentino","Libra")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            //val currencyName = it.getString("name")
            //val currencyValues = it.getString("value")
        }

        spnItemName.onItemSelectedListener = this

        val arrayAdapter = ArrayAdapter(context as MainActivity, android.R.layout.simple_spinner_item, currencyItemList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnItemName.adapter = arrayAdapter

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (currencyItemList[position]) {
            "Dólar Americano" -> tvFullName.text = "Dólar Americano com IOF Turismo"
            "Euro" -> tvFullName.text = "Euro com IOF Turismo"
            "Peso Argentino" -> tvFullName.text = "Peso Argentino com IOF Turismo"
            "Libra" -> tvFullName.text = "Libra com IOF Turismo"
        }
    }




}
