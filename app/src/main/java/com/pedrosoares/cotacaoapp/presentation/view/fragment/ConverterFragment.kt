package com.pedrosoares.cotacaoapp.presentation.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.pedrosoares.cotacaoapp.MainActivity
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.util.Mask
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import kotlinx.android.synthetic.main.fragment_converter.*
import kotlinx.android.synthetic.main.popup_edit_value.view.*
import java.lang.Float
import java.text.DecimalFormat
import java.text.NumberFormat


class ConverterFragment : Fragment(), AdapterView.OnItemSelectedListener{

    lateinit var valueFormatted : String
    var currencyItemList = arrayOf("Dólar Americano", "Euro", "Peso Argentino","Libra")
    private var valueExchange = 1.00f
    private lateinit var currencySelected : CurrencyDomain
    private val decimalFormat = DecimalFormat("#,###,###,##0.00")
    private var bid = 0f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpinner()
        managerClickListeners()
    }

    private fun initSpinner() {
        spnItemName.onItemSelectedListener = this
        val arrayAdapter = ArrayAdapter(context as MainActivity, android.R.layout.simple_spinner_item, currencyItemList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnItemName.adapter = arrayAdapter
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (currencyItemList[position]) {
            "Dólar Americano" -> {
                tvFullName.text = getString(R.string.dolar_text)
                tvCurrencyAbbreviation.text = "USD"
                tvCalculateToConvertToReal.text = "R$4,02"
            }
            "Euro" -> {
                tvFullName.text = getString(R.string.euro_text)
                tvCurrencyAbbreviation.text = "EUR"
                tvCalculateToConvertToReal.text = "R$4,02"
            }
            "Peso Argentino" -> {
                tvFullName.text = getString(R.string.peso_argentine_text)
                tvCurrencyAbbreviation.text = "ARS"
                tvCalculateToConvertToReal.text = "R$4,02"
            }
            "Libra" -> {
                tvFullName.text = getString(R.string.gbp_text)
                tvCurrencyAbbreviation.text = "GBP"
                tvCalculateToConvertToReal.text = "R$4,02"
            }
        }
    }

    private fun showAlertDialogButtonClicked(view: View?) {
        val builder = AlertDialog.Builder(context)
        val customLayout = layoutInflater.inflate(R.layout.popup_edit_value, null)
        builder.setView(customLayout)
        customLayout.etValueDialog.addTextChangedListener( Mask(customLayout.etValueDialog))

        builder.setPositiveButton("OK") { _, _ ->
            val valueTyped = customLayout.etValueDialog.text.toString()
            if (valueTyped.isEmpty()){
                Toast.makeText(context,"Campo valor está vazio.",Toast.LENGTH_SHORT).show()
            }else{
                tvValue.text = valueTyped.replace("R$","")
                val valueDialog = valueTyped.replace(",",".").replace(".","").replace("R$","")
                convertAnotherCurrencyToReal(valueDialog.toFloat() / 100)
            }
        }
        builder.create().show()
    }

    private fun managerClickListeners() {

        ivMinus.setOnClickListener {
            val value = valueExchange - 0.01f
            valueExchange = value
            valueFormatted = decimalFormat.format(Float.valueOf(valueExchange))
            tvValue.text = valueFormatted.replace(".", ",")
            //convertAnotherCurrencyToReal(verifyArguments())
            convertAnotherCurrencyToReal(value)
        }

        ivAdd.setOnClickListener {
            val value = valueExchange + 0.01f
            valueExchange = value
            valueFormatted = decimalFormat.format(Float.valueOf(valueExchange))
            tvValue.text = valueFormatted.replace(".", ",")
            //convertAnotherCurrencyToReal(verifyArguments())
            convertAnotherCurrencyToReal(value)
        }

        tvValue.setOnClickListener { showAlertDialogButtonClicked(view) }

    }

    private fun convertAnotherCurrencyToReal(value: kotlin.Float) {

        val nf = NumberFormat.getCurrencyInstance()
        val newValue = nf.format(value * 4.0619)
        //currencySelected.usd?.bid?.let {
            when (tvFullName.text.toString()) {
                "Dólar Americano com IOF Turismo" -> {
                    tvCalculateToConvertToReal.text = newValue
                }
                "Euro com IOF Turismo" -> {
                    tvCalculateToConvertToReal.text = newValue
                }
                "Peso Argentino com IOF Turismo" -> {
                    tvCalculateToConvertToReal.text = newValue
                }
                "Libra com IOF Turismo" -> {
                    tvCalculateToConvertToReal.text = newValue
                }
            }
        //}
    }




    private fun verifyArguments() : CurrencyDomain{

        arguments?.let {
            currencySelected = it.getParcelable("currency")!!
            return currencySelected
        }
        return CurrencyDomain()
    }

    fun getCurrencyDataSelected(bundle: Bundle) {
        //bundle = this.arguments
        if (bundle != null) {
            val usd = bundle.getString("usd")
            usd.let {
                valueFormatted = usd.replace(".","")
                bid = valueFormatted.toFloat() / 10000

            }
        }

    }



}


