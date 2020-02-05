package com.edwinacubillos.sesionfragments

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class SuperheroesRVAdapter(
    context: Context, superheroesList: ArrayList<Superheroes>
) : RecyclerView.Adapter<SuperheroesRVAdapter.SuperheroesViewHolder>() {

    private var superheroesList = emptyList<Superheroes>()
    private val context: Context

    init {
        this.superheroesList = superheroesList
        this.context = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperheroesRVAdapter.SuperheroesViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)
        return SuperheroesViewHolder(itemView, context)
    }

    override fun getItemCount(): Int {
        return superheroesList.size
    }

    override fun onBindViewHolder(
        holder: SuperheroesRVAdapter.SuperheroesViewHolder,
        position: Int
    ) {
        val superheroes: Superheroes = superheroesList[position]
        holder.bindSuperheroe(superheroes)
    }

    class SuperheroesViewHolder(
        itemView: View, context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private var context: Context

        init {
            this.context = context
        }

        fun bindSuperheroe(superheroe: Superheroes) {
            itemView.tv_nombre.text = superheroe.nombre
            itemView.tv_nombre_real.text = superheroe.nombre_real
            itemView.iv_escudo.setImageResource(superheroe.foto)
            itemView.setOnClickListener {
                Toast.makeText(context, superheroe.nombre, Toast.LENGTH_SHORT).show()
                var intent = Intent(context, SuperheroeDetalleActivity::class.java)
                intent.putExtra("superheroe", superheroe).addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
            itemView.setOnLongClickListener {
                Toast.makeText(context, superheroe.nombre+"Long", Toast.LENGTH_SHORT).show()
                return@setOnLongClickListener true
            }
        }
    }
}













