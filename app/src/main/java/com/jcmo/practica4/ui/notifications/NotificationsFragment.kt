package com.jcmo.practica4.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcmo.practica4.EliminarAdapter
import com.jcmo.practica4.Peluches
import com.jcmo.practica4.R
import com.jcmo.practica4.ui.inventario.InventarioViewModel

class NotificationsFragment : Fragment() {

    private lateinit var stockViewModel: InventarioViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        var peluchito : ArrayList<Peluches> = ArrayList()
        peluchito.add(Peluches("001","Oso","$1000","100"))
        peluchito.add(Peluches("001","Tigre","$1000","1"))
        peluchito.add(Peluches("001","Leon","$100","10"))
        peluchito.add(Peluches("001","Abeja","$10","8"))
        peluchito.add(Peluches("001","Oso","$250","20"))
        peluchito.add(Peluches("001","Oso","$330","15"))

        //var bundle : Bundle? = getIntent().getExtras();

        //stockViewModel =ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications,container,false)




        recyclerView  = root.findViewById(R.id.recycler2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)

        val pelucheAdapter = context?.let { EliminarAdapter(peluchito, it) }

        recyclerView.adapter = pelucheAdapter

        // Inflate the layout for this fragment
        return root
    }
}