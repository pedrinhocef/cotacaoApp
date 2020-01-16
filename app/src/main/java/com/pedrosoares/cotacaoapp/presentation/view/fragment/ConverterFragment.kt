package com.pedrosoares.cotacaoapp.presentation.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.pedrosoares.cotacaoapp.presentation.view.activity.MainActivity
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseFragment
import com.pedrosoares.cotacaoapp.core.util.Mask
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract
import com.pedrosoares.cotacaoapp.presentation.presenter.ConverterPresenter
import kotlinx.android.synthetic.main.fragment_converter.*
import kotlinx.android.synthetic.main.popup_edit_value.view.*
import java.text.DecimalFormat
import java.text.NumberFormat


class ConverterFragment : BaseFragment<CurrencyContract.ConverterPresenter>(), CurrencyContract.CurrencyListView, AdapterView.OnItemSelectedListener{

    private lateinit var valueFormatted : String
    private var currencyItemList = arrayOf("Dólar americano", "Euro", "Peso argentino","Libra")
    private lateinit var currencySelected : CurrencyDomain
    private val decimalFormat = DecimalFormat("#,###,###,##0.00")
    private lateinit var bidUsd : String
    private lateinit var bidEur : String
    private lateinit var bidArs : String
    private lateinit var bidGbp : String
    private var valueBidUsd = 0f
    private var valueBidEur = 0f
    private var valueBidArs = 0f
    private var valueBidGbp = 0f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter!!.fetchCurrency()
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
            "Dólar americano" -> {
                tvFullName.text = getString(R.string.dolar_text)
                tvCurrencyAbbreviation.text = "USD"
                tvValue.text = "0,00"
                tvCalculateToConvertToReal.text = "R$0,00"
            }
            "Euro" -> {
                tvFullName.text = getString(R.string.euro_text)
                tvCurrencyAbbreviation.text = "EUR"
                tvValue.text = "0,00"
                tvCalculateToConvertToReal.text = "R$0,00"
            }
            "Peso argentino" -> {
                tvFullName.text = getString(R.string.peso_argentine_text)
                tvCurrencyAbbreviation.text = "ARS"
                tvValue.text = "0,00"
                tvCalculateToConvertToReal.text = "R$0,00"
            }
            "Libra" -> {
                tvFullName.text = getString(R.string.gbp_text)
                tvCurrencyAbbreviation.text = "GBP"
                tvValue.text = "0,00"
                tvCalculateToConvertToReal.text = "R$0,00"
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
            when {
                tvCurrencyAbbreviation.text.toString() == "USD" -> {
                    val value = valueBidUsd - 0.01f
                    valueBidUsd = value
                    valueFormatted = decimalFormat.format(valueBidUsd)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                tvCurrencyAbbreviation.text.toString() == "EUR" -> {
                    val value = valueBidEur - 0.01f
                    valueBidEur = value
                    valueFormatted = decimalFormat.format(valueBidEur)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                tvCurrencyAbbreviation.text.toString() == "ARS" -> {
                    val value = valueBidArs - 0.01f
                    valueBidArs = value
                    valueFormatted = decimalFormat.format(valueBidArs)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                else -> {
                    val value = valueBidGbp - 0.01f
                    valueBidGbp = value
                    valueFormatted = decimalFormat.format(valueBidGbp)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
            }
        }

        ivAdd.setOnClickListener {
            when {
                tvCurrencyAbbreviation.text.toString() == "USD" -> {
                    val value = valueBidUsd + 0.01f
                    valueBidUsd = value
                    valueFormatted = decimalFormat.format(valueBidUsd)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                tvCurrencyAbbreviation.text.toString() == "EUR" -> {
                    val value = valueBidEur + 0.01f
                    valueBidEur = value
                    valueFormatted = decimalFormat.format(valueBidEur)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                tvCurrencyAbbreviation.text.toString() == "ARS" -> {
                    val value = valueBidArs + 0.01f
                    valueBidArs = value
                    valueFormatted = decimalFormat.format(valueBidArs)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
                else -> {
                    val value = valueBidGbp + 0.01f
                    valueBidGbp = value
                    valueFormatted = decimalFormat.format(valueBidGbp)
                    convertAnotherCurrencyToReal(valueFormatted.replace(",", ".").toFloat())
                    tvValue.text = valueFormatted
                }
            }
        }

        tvValue.setOnClickListener { showAlertDialogButtonClicked(view) }

    }

    private fun convertAnotherCurrencyToReal(value: Float) {

        val nf = NumberFormat.getCurrencyInstance()
        when (tvFullName.text.toString()) {
            "Dólar Americano com IOF Turismo" -> {
                val newValue = nf.format(value * bidUsd.toFloat())
                tvCalculateToConvertToReal.text = newValue
            }
            "Euro com IOF Turismo" -> {
                val newValue = nf.format(value * bidEur.toFloat())
                tvCalculateToConvertToReal.text = newValue
            }
            "Peso Argentino com IOF Turismo" -> {
                val newValue = nf.format(value * bidArs.toFloat())
                tvCalculateToConvertToReal.text = newValue
            }
            "Libra com IOF Turismo" -> {
                val newValue = nf.format(value * bidGbp.toFloat())
                tvCalculateToConvertToReal.text = newValue
            }
        }
    }



    override fun createPresenter() = ConverterPresenter(this)

    override fun populateCurrency(currencyDomain: CurrencyDomain) {
        currencySelected = currencyDomain
        with(currencySelected){
            bidUsd = this.usd?.bid!! ; valueBidUsd = bidUsd.toFloat()
            bidEur = this.eur?.bid!! ; valueBidEur = bidEur.toFloat()
            bidArs = this.ars?.bid!! ; valueBidArs = bidArs.toFloat()
            bidGbp = this.gbp?.bid!! ; valueBidGbp = bidGbp.toFloat()
        }
    }

    override fun success() {}
    override fun loading() {}
    override fun error() {}





}


