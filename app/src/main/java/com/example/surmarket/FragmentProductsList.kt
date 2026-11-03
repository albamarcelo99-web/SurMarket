package com.example.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surmarket.models.product

class FragmentProductsList : Fragment(){
    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETXProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    private lateinit var adapterProducts: AdapterProducts

    private var listaProductos = mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeViews(view)
        configureListeners()
        configureRecyclerView()
        loadSampleProducts()
    }

    private fun initalizeViews(view: View)
    {
        IMV_FRGProductsList_ShoppingCart= view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)
        IMV_FRGProductsList_Search= view.findViewById(R.id.IMV_FRGProductsList_Search)
        ETXProductsList_Search= view.findViewById(R.id.ETXProductsList_Search)
        BTN_FRGProductsList_AddProduct= view.findViewById(R.id.BTN_FRGProductsList_AddProduct)
        RCV_FRGProductsList_ProductsList= view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
    }
    private fun configureListeners()
    {

    }
    private fun configureRecyclerView()
    {
        adapterProducts  = AdapterProducts(
            productsList = listaProductos,
              clickOnBuy = { product ->
               Toast.makeText(requireContext(),getString(R.string.addCart)+ "${ product.name}",
                   Toast.LENGTH_SHORT).show()
           }
        )
        RCV_FRGProductsList_ProductsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterProducts
        }
    }
    private fun loadSampleProducts(){
        val productsSample = listOf(
            product(
                id = 1,
                name = "Polera",
                category = "Ropa masculine",
                price = 42.0,
                imagenUrl = "",
                description = "Talla L, Lacoste, verde",
                availabel = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Short",
                category = "Ropa masculine",
                price = 240.0,
                imagenUrl = "",
                description = "Talla 42, GasOlio, negro",
                availabel = true,
                stock = 1
            ),
            product(
                id = 3,
                name = "Calzado",
                category = "Ropa masculine",
                price = 380.0,
                imagenUrl = "",
                description = "Talla 38, Nike, Blanca",
                availabel = true,
                stock = 1
            ),
            product(
                id = 4,
                name = "Corbata",
                category = "Ropa masculine",
                price = 75.0,
                imagenUrl = "",
                description = " Imperial, red",
                availabel = true,
                stock = 1
            ),
            product(
                id = 5,
                name = "Camisa",
                category = "Ropa masculine",
                price = 42.0,
                imagenUrl = "",
                description = "Talla L, I-Rum, negro",
                availabel = true,
                stock = 1
            )
        )
        listaProductos.clear()
        listaProductos.addAll(productsSample)
        adapterProducts.notifyChanged()
    }
}