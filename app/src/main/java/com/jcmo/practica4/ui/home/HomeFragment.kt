package com.jcmo.practica4.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jcmo.practica4.R
import com.jcmo.practica4.comunicador
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.ClassCastException

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var interfaz : comunicador ?= null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {


        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        /*val textView: TextView = root.findViewById(R.id.eid)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        root.bEnviar.setOnClickListener{
            var id = root.eid.text.toString()
            var nom = root.eNombre.text.toString()
            var pre = root.ePrecio.text.toString()
            var cant = root.eCantidad.text.toString()
            if(id.isEmpty() || nom.isEmpty() || pre.isEmpty() || cant.isEmpty()){
                Toast.makeText(context, "Campos Vacios", Toast.LENGTH_SHORT).show()
            }else{
                interfaz?.agregarDatos(id,nom,pre,cant)
            }

        }
        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            interfaz = context as comunicador
        }catch (e: ClassCastException){
            Log.d("exception", e.toString())
        }
    }
}