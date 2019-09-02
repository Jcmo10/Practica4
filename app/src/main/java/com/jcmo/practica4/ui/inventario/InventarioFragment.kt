package com.jcmo.practica4.ui.inventario

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcmo.practica4.Peluches
import com.jcmo.practica4.R
import com.jcmo.practica4.peluchesAdapter


class InventarioFragment : Fragment() {

    private lateinit var stockViewModel: InventarioViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        var peluchito : MutableList<Peluches> = ArrayList()
        //var bundle : Bundle? = null

        //var peluchito : ArrayList<Peluches> =

        //Bundle extras = getIntent().getExtras()
        //ArrayList<ObjectName> arraylist  = extras.getParcelableArrayList("arraylist")

        peluchito.add(Peluches("001","Oso","$1000","100"))
        peluchito.add(Peluches("001","Tigre","$1000","1"))
        peluchito.add(Peluches("001","Leon","$100","10"))
        peluchito.add(Peluches("001","Abeja","$10","8"))
        peluchito.add(Peluches("001","Oso","$250","20"))
        peluchito.add(Peluches("001","Oso","$330","15"))

        //var bundle : Bundle? = getIntent().getExtras();

        //stockViewModel =ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inventario,container,false)

        /*var id = arguments?.getString("id")
        var nomb = arguments?.getString("nombre")
        var pre = arguments?.getString("precio")
        var cant = arguments?.getString("cantidad")

        if(id!!.isEmpty() || nomb!!.isEmpty() || pre!!.isEmpty() || cant!!.isEmpty()){
            Toast.makeText(context, "Campos Vacios", Toast.LENGTH_SHORT).show()
        }else{
            peluchito.add(Peluches(id,nomb,pre,cant))
        }*/


        recyclerView  = root.findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        val pelucheAdapter = context?.let { peluchesAdapter(peluchito, it) }

        recyclerView.adapter = pelucheAdapter

        // Inflate the layout for this fragment
        return root
    }


}
