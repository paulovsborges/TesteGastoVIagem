package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calcular.setOnClickListener(this)
        edit_autonomy
        edit_distance
        edit_price
        text_value

    }


    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.button_calcular) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = edit_distance.text.toString().toFloat()
                val price = edit_price.text.toString().toFloat()
                val autonomy = edit_autonomy.text.toString().toFloat()
                val result = (distance * price) / autonomy
                text_value.text = "R$ ${"%.2f".format(result)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, "valores inválidos ", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "todos os campos são obrigatórios ", Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {
        return (edit_distance.text.toString() != ""
                && edit_price.text.toString() != ""
                && edit_autonomy.text.toString() != ""
                && edit_distance.text.toString() != "0"
                && edit_price.text.toString() != "0"
                && edit_autonomy.text.toString() != "0")


        /**
         * another way to do it
         *
        if(edit_distance.text.toString() == "" )
        return false
        if(edit_price.text.toString() == "")
        return false
        if(edit_autonomy.text.toString() == "")
        return false
        return true
         */
    }
}


