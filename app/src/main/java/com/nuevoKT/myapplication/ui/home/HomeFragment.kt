package com.nuevoKT.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nuevoKT.myapplication.databinding.FragmentHomeBinding
import com.nuevoKT.myapplication.R
import com.nuevoKT.myapplication.nuevaActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var mondayCheckbox: CheckBox
    lateinit var tuesdayCheckbox: CheckBox
    lateinit var wednesdayCheckbox: CheckBox
    lateinit var thursdayCheckbox: CheckBox
    lateinit var fridayCheckbox: CheckBox
    lateinit var saturdayCheckbox: CheckBox
    lateinit var sundayCheckbox: CheckBox
    lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mondayCheckbox = root.findViewById(R.id.caja_lunes)
        tuesdayCheckbox = root.findViewById(R.id.caja_martes)
        wednesdayCheckbox = root.findViewById(R.id.caja_miercoles)
        thursdayCheckbox = root.findViewById(R.id.caja_jueves)
        fridayCheckbox = root.findViewById(R.id.caja_viernes)
        saturdayCheckbox = root.findViewById(R.id.caja_sabado)
        sundayCheckbox = root.findViewById(R.id.caja_domingo)
        saveButton = root.findViewById(R.id.guardar)

        saveButton.setOnClickListener {
            guardarSeleccion()
        }

        return root
    }

    private fun guardarSeleccion() {
        val seleccionados = ArrayList<String>()
        if (mondayCheckbox.isChecked) seleccionados.add("Lunes")
        if (tuesdayCheckbox.isChecked) seleccionados.add("Martes")
        if (wednesdayCheckbox.isChecked) seleccionados.add("Miércoles")
        if (thursdayCheckbox.isChecked) seleccionados.add("Jueves")
        if (fridayCheckbox.isChecked) seleccionados.add("Viernes")
        if (saturdayCheckbox.isChecked) seleccionados.add("Sábado")
        if (sundayCheckbox.isChecked) seleccionados.add("Domingo")

        if (seleccionados.isEmpty()) {
            Toast.makeText(requireContext(), "Debe elegir al menos un día", Toast.LENGTH_SHORT).show()
        } else {
        val irActivity = Intent(requireContext(), nuevaActivity::class.java)
            irActivity.putStringArrayListExtra("dias_seleccionados", seleccionados)
        startActivity(irActivity)
    }

    }
}
