package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentCart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_cart,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // CONTENEDOR DE LOS PRODUCTOS
        val productsView = view.findViewById<View>(
            R.id.INC_FRGCart_Products
        )

        // CONFIGURAR BOTONES DE CANTIDAD
        configurarBotones(
            productsView,
            R.id.CV_ItemCart_Tea_Quantity
        )

        configurarBotones(
            productsView,
            R.id.CV_ItemCart_Fideo_Quantity
        )

        configurarBotones(
            productsView,
            R.id.CV_ItemCart_DulceLeche_Quantity
        )

        // BOTON FINALIZAR COMPRA
        val btnCheckout = view.findViewById<Button>(
            R.id.BTN_FRGCart_Checkout
        )

        btnCheckout.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "GRACIAS POR SU COMPRA",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // CONFIGURAR BOTONES MAS Y MENOS
    private fun configurarBotones(
        productsView: View,
        selectorId: Int
    ) {

        val selector = productsView.findViewById<View>(
            selectorId
        )

        // BOTON MAS
        val btnMas = selector.findViewById<TextView>(
            R.id.TXV_ItemCart_Increase
        )

        btnMas.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "MAS",
                Toast.LENGTH_SHORT
            ).show()
        }

        // BOTON MENOS
        val btnMenos = selector.findViewById<TextView>(
            R.id.TXV_ItemCart_Decrease
        )

        btnMenos.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "MENOS",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}