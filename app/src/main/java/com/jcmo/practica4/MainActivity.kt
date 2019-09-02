package com.jcmo.practica4

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jcmo.practica4.ui.inventario.InventarioFragment





class MainActivity : AppCompatActivity(),comunicador {

    var peluchito : ArrayList<Peluches> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        peluchito.add(Peluches("001","Oso","$1000","100"))
        peluchito.add(Peluches("001","Tigre","$1000","1"))
        peluchito.add(Peluches("001","Leon","$100","10"))
        peluchito.add(Peluches("001","Abeja","$10","8"))
       // var bundle : Bundle? = null
       // bundle!!.putParcelableArrayList("flistaSede",peluchito)

        val bundle = Bundle()
        bundle.putParcelableArrayList("peluchess",peluchito)
        val inventarioFragment = InventarioFragment()
        inventarioFragment.arguments = bundle
        //fragment.setArguments(bundle)

        //val bundle = Bundle()
       // bundle.apply { putParcelableArrayList("aaa",ArrayList<>()) }
        //bundle.putParcelableArrayList("aaa", ArrayList<Parcelable>(fbModel.peluchito))

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_inventario
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun agregarDatos(id: String, nombre: String, precio: String, cantidad: String) {
        val args = Bundle()

        args.putString("id",id)
        args.putString("nombre",nombre)
        args.putString("precio",precio)
        args.putString("cantidad",cantidad)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val datosFragment = InventarioFragment()
        datosFragment.arguments = args
        transaction.replace(R.id.navigation_inventario, datosFragment).commit()


    }

}





