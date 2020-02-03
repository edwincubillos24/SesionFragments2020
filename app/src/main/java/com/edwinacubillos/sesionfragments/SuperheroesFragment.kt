package com.edwinacubillos.sesionfragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_superheroes.*
import kotlinx.android.synthetic.main.fragment_superheroes.view.*

/**
 * A simple [Fragment] subclass.
 */
class SuperheroesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_superheroes,
            container,
            false)

        var superheroesList: MutableList<Superheroes> = ArrayList()

        superheroesList.add(Superheroes("Superman",
            "Clark Kent",
            R.drawable.superman,
            "Fuerza, velocidad",
            R.drawable.superman))

        rv_superheroes.setHasFixedSize(true)
        rv_superheroes.layoutManager = LinearLayoutManager (
            activity?.applicationContext,
            RecyclerView.VERTICAL,
            false)

        val superheroesRVAdapter = SuperheroesRVAdapter(
            activity!!.applicationContext,
            superheroesList as ArrayList
            )

        rv_superheroes.adapter = superheroesRVAdapter

        return view
    }
}
