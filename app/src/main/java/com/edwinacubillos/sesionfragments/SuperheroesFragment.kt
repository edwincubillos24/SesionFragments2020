package com.edwinacubillos.sesionfragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            false
        )

        var superheroesList: MutableList<Superheroes> = ArrayList()

        superheroesList.add(
            Superheroes(
                context!!.getString(R.string.superman),
                "Clark Kent",
                R.drawable.superman,
                context!!.getString(R.string.superman_poderes),
                R.drawable.superman
            )
        )
        superheroesList.add(
            Superheroes(
                context!!.getString(R.string.batman),
                "Bruce Wayne",
                R.drawable.batman,
                context!!.getString(R.string.batman_poderes),
                R.drawable.batman
            )
        )
        superheroesList.add(
            Superheroes(
                context!!.getString(R.string.flash),
                "Clark Kent",
                R.drawable.flash,
                context!!.getString(R.string.flash_poderes),
                R.drawable.flash
            )
        )
        //  val rv_superheroes: RecyclerView = view.findViewById(R.id.rv_superheroes)
        view.rv_superheroes.setHasFixedSize(true)
        view.rv_superheroes.layoutManager = LinearLayoutManager(
            activity?.applicationContext,
            RecyclerView.VERTICAL,
            false
        )

        val superheroesRVAdapter = SuperheroesRVAdapter(
            activity!!.applicationContext,
            superheroesList as ArrayList
        )

        view.rv_superheroes.adapter = superheroesRVAdapter

        return view
    }
}
