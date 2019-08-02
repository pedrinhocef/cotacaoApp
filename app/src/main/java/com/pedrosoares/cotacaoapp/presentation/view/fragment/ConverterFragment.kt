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
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import kotlinx.android.synthetic.main.fragment_converter.*
import java.lang.Float
import java.text.DecimalFormat


class ConverterFragment : Fragment(), AdapterView.OnItemSelectedListener{

    lateinit var valueFormatted: String
    var currencyItemList = arrayOf("Dólar Americano", "Euro", "Peso Argentino","Libra")
    private var valueExchange = 1.00f
    private lateinit var currencySelected : CurrencyDomain

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initViews()

        managerButtonClick()
    }

    private fun initViews() {
        spnItemName.onItemSelectedListener = this
        val arrayAdapter = ArrayAdapter(context as MainActivity, android.R.layout.simple_spinner_item, currencyItemList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnItemName.adapter = arrayAdapter
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (currencyItemList[position]) {
            "Dólar Americano" -> tvFullName.text = getString(R.string.dolar_text)
            "Euro" -> tvFullName.text = getString(R.string.euro_text)
            "Peso Argentino" -> tvFullName.text = getString(R.string.peso_argentine_text)
            "Libra" -> tvFullName.text = getString(R.string.gbp_text)
        }
    }



    private fun managerButtonClick() {


        val decimalFormat = DecimalFormat("#,###,###,##0.00")


        ivMinus.setOnClickListener {
            val value = valueExchange - 0.01f
            valueExchange = value
            valueFormatted = decimalFormat.format(java.lang.Float.valueOf(valueExchange))
            tvCurrencyExchange.text = valueFormatted.replace(".", ",")
            convertAnotherCurrencyToReal(verifyArguments())
        }

        ivAdd.setOnClickListener {
            val value = valueExchange + 0.01f
            valueExchange = value
            valueFormatted = decimalFormat.format(java.lang.Float.valueOf(valueExchange))
            tvCurrencyExchange.text = valueFormatted.replace(".", ",")
            convertAnotherCurrencyToReal(verifyArguments())
        }



    }

    private fun convertAnotherCurrencyToReal(currencySelected: CurrencyDomain) {
        currencySelected.usd?.bid?.let {
            when (tvFullName.text.toString()) {
                "Dólar Americano com IOF Turismo" -> {
                    val value = Float.valueOf(it.trim()).plus(Float.valueOf(it.trim()).times(1.1))
                    tvCalculationExchange.text = " $valueExchange USD  = $value"
                }
                "Euro com IOF Turismo" -> {
                    tvCalculationExchange.text = " $valueExchange EUR  = 3,453 BRL"
                }
                "Peso Argentino com IOF Turismo" -> {
                    tvCalculationExchange.text = " $valueExchange ARS  = 3,453 BRL"
                }
                "Libra com IOF Turismo" -> {
                    tvCalculationExchange.text = " $valueExchange GBP  = 3,453 BRL"
                }
            }
        }
    }

    private fun verifyArguments() : CurrencyDomain{

        arguments?.let {
            currencySelected = it.getParcelable("currency")!!
            return currencySelected
        }
        return CurrencyDomain()
    }


}
