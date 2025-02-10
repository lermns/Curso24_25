package com.example.minicalculadora

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.minicalculadora.databinding.ActivityCheckBoxBinding

class CheckBox : AppCompatActivity() {
    private lateinit var binding: ActivityCheckBoxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.button.setOnClickListener {
            val bandera: Boolean = controlError()

            if (bandera) {
                textContent()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var resultado = ""
        when(item.itemId){
            R.id.action_sumar -> {
                if (controlError()){
                    resultado = "Suma = ${binding.operando11.text.toString().toDouble() + binding.operando22.text.toString().toDouble()}"
                    binding.textView2.text = resultado
                }
                return true
            }
            R.id.action_restar -> {
                if (controlError()) {
                    resultado += "\nResta = ${binding.operando11.text.toString().toDouble() - binding.operando22.text.toString().toDouble()}"
                    binding.textView2.text = resultado
                }
                return true
            }
            R.id.action_calcular -> {
                if (controlError())
                    textContent()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun controlError(): Boolean {
        var bandera = true

        if(binding.operando11.text.toString().isEmpty()){
            binding.operando11.error = "Sin valor..."
            bandera = false
        }

        if(binding.operando22.text.toString().isEmpty()){
            binding.operando22.error = "Sin valor..."
            bandera = false
        }

        if (binding.operando11.text.toString().length>4){
            binding.operando11.error = "Valor fuera de rango..."
            bandera = false
        }
        if (binding.operando22.text.toString().length>4){
            binding.operando22.error = "Valor fuera de rango..."
            bandera = false
        }
        return bandera
    }

    private fun textContent(){
        var resultado = ""

        if (binding.checkBoxSum.isChecked)
            resultado = "Suma = ${
                binding.operando11.text.toString()
                    .toDouble() + binding.operando22.text.toString().toDouble()
            }"

        if (binding.checkBoxRest.isChecked)
            resultado += "\nResta = ${
                binding.operando11.text.toString()
                    .toDouble() - binding.operando22.text.toString().toDouble()
            }"

        if (!binding.checkBoxSum.isChecked && !binding.checkBoxRest.isChecked)
            resultado = "Sin operador"
        binding.textView2.text = resultado
    }
}