package com.nuevoKT.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nuevoKT.myapplication.databinding.FragmentDashboardBinding
import org.w3c.dom.Text
import kotlin.math.pow

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val alturaEdit: EditText = binding.altura
        val pesoEdit: EditText = binding.peso
        val btn_calcular: Button = binding.calcular
        val ver_resultado: TextView = binding.resultado
        val btn_reset: Button = binding.buttonReset

        btn_calcular.setOnClickListener {
            val alturaTxt = alturaEdit.text.toString()
            val pesoTxt = pesoEdit.text.toString()

            if (alturaTxt.isNotEmpty() && pesoTxt.isNotEmpty()) {
                val altura = alturaTxt.toFloat() / 100
                val peso = pesoTxt.toFloat()

                val res = peso / (altura.pow(2))

                ver_resultado.text = "Tu IMC es: %.2f".format(res)
            } else {
                ver_resultado.text = "Ingresa altura y peso"
            }

            btn_reset.setOnClickListener {
                alturaEdit.text.clear()
                pesoEdit.text.clear()
                ver_resultado.text = ""
                Toast.makeText(requireContext(), "Campos limpiados, puede ingresar nuevos valores", Toast.LENGTH_SHORT).show()

            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}