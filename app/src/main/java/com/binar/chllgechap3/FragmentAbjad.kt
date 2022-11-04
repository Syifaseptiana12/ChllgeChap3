package com.binar.chllgechap3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentAbjad  : Fragment() {
    private lateinit var listHurufList : ArrayList<ListAbjad>
    private lateinit var hurufAdapter : AdapterAbjad
    private lateinit var rvHuruf : RecyclerView
    private lateinit var layoutManager : GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_abjad, container, false)
    }

    // Memastikan layout yang dibaca fragment adalah non-null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        "Daftar Huruf".also { activity?.title = it }
        (this.activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (this.activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        dataHuruf()
        rvHuruf = view.findViewById(R.id.rvHuruf)
        with(rvHuruf) { setHasFixedSize(true) }
        GridLayoutManager(context, 3).also { layoutManager = it }
        layoutManager.also { rvHuruf.layoutManager = it }
        AdapterAbjad(listHurufList,layoutManager).also { hurufAdapter = it }
        hurufAdapter.also { rvHuruf.adapter = it }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.activity?.menuInflater?.inflate(R.menu.header_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnKalimat -> {
                when (layoutManager.spanCount) {
                    3 -> {
                        layoutManager.spanCount = 1
                        item.setIcon(R.drawable.ic_kotak).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                    }
                    else -> {
                        layoutManager.spanCount = 3
                        item.setIcon(R.drawable.ic_kotak).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                    }
                }
                hurufAdapter.notifyItemRangeChanged(0,hurufAdapter.itemCount)
            } else -> {
            return false
        }
        }
        return true
    }

    private fun dataHuruf() {
        arrayListOf(
            ListAbjad("A"),
            ListAbjad("B"),
            ListAbjad("C"),
            ListAbjad("D"),
            ListAbjad("E"),
            ListAbjad("F"),
            ListAbjad("G"),
            ListAbjad("H"),
            ListAbjad("I"),
            ListAbjad("J"),
            ListAbjad("K"),
            ListAbjad("L"),
            ListAbjad("M"),
            ListAbjad("N"),
            ListAbjad("O"),
            ListAbjad("P"),
            ListAbjad("Q"),
            ListAbjad("R"),
            ListAbjad("S"),
            ListAbjad("T"),
            ListAbjad("U"),
            ListAbjad("V"),
            ListAbjad("W"),
            ListAbjad("X"),
            ListAbjad("Y"),
            ListAbjad("Z")
        ).also { listHurufList = it }
    }
}