package com.edwinacubillos.sesionfragments.dinamico_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.edwinacubillos.sesionfragments.BatmanFragment
import com.edwinacubillos.sesionfragments.FlashFragment
import com.edwinacubillos.sesionfragments.R
import com.edwinacubillos.sesionfragments.SupermanFragment

class DinamicoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinamico)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val supermanFragment =
            SupermanFragment()
        transaction.add(R.id.contenedor, supermanFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_superheroes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId){
            R.id.mo_superman -> {
                val supermanFragment =
                    SupermanFragment()
                transaction.addToBackStack(null)
                    .replace(R.id.contenedor, supermanFragment).commit()
            }
            R.id.mo_batman -> {
                val batmanFragment =
                    BatmanFragment()
                transaction.replace(R.id.contenedor, batmanFragment).commit()
            }
            else  -> {
                val flashFragment =
                    FlashFragment()
                transaction.replace(R.id.contenedor, flashFragment).commit()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
