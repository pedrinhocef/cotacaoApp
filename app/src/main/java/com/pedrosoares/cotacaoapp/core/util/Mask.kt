package com.pedrosoares.cotacaoapp.core.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.NumberFormat

class Mask(private val campo : EditText) : TextWatcher{

    private var isUpdating = false

    // Pega a formatacao do sistema, se for brasil R$ se EUA US$
    private val nf = NumberFormat.getCurrencyInstance()

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        // Evita que o método seja executado varias vezes.
        // Se tirar ele entre em loop
        if (isUpdating) {
            isUpdating = false;
            return;
        }

        isUpdating = true;
        var str = s.toString();
        // Verifica se já existe a máscara no texto.
        val hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
                    (str.indexOf(".") > -1 || str.indexOf(",") > -1));

        // Verificamos se existe máscara
        if (hasMask) {
            // Retiramos a máscara
            str = str.replace("[R$]".toRegex(), "").replace("[,]".toRegex(), "").replace("[.]".toRegex(), "");
        }

        try {
            // Transformamos o número que está escrito no EditText em monetário
            str = nf.format(str.toDouble() / 100)
            campo.setText(str)
            campo.setSelection(campo.text.length);

        } catch ( e: NumberFormatException) {
            str = ""
        }

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {}
}
