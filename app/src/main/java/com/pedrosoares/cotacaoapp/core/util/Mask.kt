package com.pedrosoares.cotacaoapp.core.util

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import java.text.NumberFormat

class Mask(private val campo : EditText) : TextWatcher{

    private var isUpdating = false

    private val nf = NumberFormat.getCurrencyInstance()

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        if (isUpdating) {
            isUpdating = false
            return
        }

        isUpdating = true;
        var str = s.toString();
        val hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
                    (str.indexOf(".") > -1 || str.indexOf(",") > -1))

        if (hasMask) {
            str = str.replace("[R$]".toRegex(), "").replace("[,]".toRegex(), "").replace("[.]".toRegex(), "")
        }

        try {
            str = nf.format(str.toDouble() / 100)
            campo.setText(str)
            campo.setSelection(campo.text.length)

        } catch ( e: NumberFormatException) {
            str = ""
            Log.e("ERRO NA MASCARA","Não foi possível colocar mascara neste formato $str")
        }

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {}
}
