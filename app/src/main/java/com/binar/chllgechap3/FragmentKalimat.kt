package com.binar.chllgechap3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentKalimat(private var getHuruf : String) : Fragment() {
    private lateinit var daftarKata : ArrayList<ListKalimat>
    private lateinit var kalimatAdapter : AdapterKalimat
    private lateinit var rvKata : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kalimat, container, false)
    }

    // Memastikan layout yang dibaca fragment adalah non-null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataKata(getHuruf)
        "Kata yang diawali oleh huruf $getHuruf".also { activity?.title = it }
        (this.activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (this.activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvKata = view.findViewById(R.id.rvKalimat)
        with(rvKata) { setHasFixedSize(true) }
        LinearLayoutManager(context).also { rvKata.layoutManager = it }
        AdapterKalimat(daftarKata).also { kalimatAdapter = it }
        kalimatAdapter.also { rvKata.adapter  }
    }

    private fun dataKata(isiKata : String) {
        daftarKata = if (isiKata == "A") arrayListOf(
            ListKalimat("APA"),
            ListKalimat("AKAN"),
            ListKalimat("ATAU"))
        else if (isiKata == "B") arrayListOf(
            ListKalimat("Bintang"),
            ListKalimat("Bersinar"),
            ListKalimat("Bila"))
        else if (isiKata == "C") arrayListOf(
            ListKalimat("Cinta"),
            ListKalimat("Cika"),
            ListKalimat("Cita"))
        else if (isiKata == "D") arrayListOf(
            ListKalimat("Dekan"),
            ListKalimat("Dokter"),
            ListKalimat("Dan"))
        else if (isiKata == "E") arrayListOf(
            ListKalimat("Eka"),
            ListKalimat("Entah"),
            ListKalimat("Elang"))
        else if (isiKata == "F") arrayListOf(
            ListKalimat("Fuji"),
            ListKalimat("Fiance"),
            ListKalimat("France"))
        else if (isiKata == "G") arrayListOf(
            ListKalimat("Gunung"),
            ListKalimat("Gantung"),
            ListKalimat("Gorilla"))
        else if (isiKata == "H") arrayListOf(
            ListKalimat("Hantu"),
            ListKalimat("Hina"),
            ListKalimat("Hug"))
        else if (isiKata == "I") arrayListOf(
            ListKalimat("Ikan"),
            ListKalimat("Intan"),
            ListKalimat("Inang"))
        else if (isiKata == "J") arrayListOf(
            ListKalimat("Jantung"),
            ListKalimat("Jika"),
            ListKalimat("Jidan"))
        else if (isiKata == "K") arrayListOf(
            ListKalimat("Kali"),
            ListKalimat("Kapan"),
            ListKalimat("Kita"))
        else if (isiKata == "L") arrayListOf(
            ListKalimat("Lesti"),
            ListKalimat("Love"),
            ListKalimat("Lintah"))
        else if (isiKata == "M") arrayListOf(
            ListKalimat("Mama"),
            ListKalimat("Mami"),
            ListKalimat("Mamak"))
        else if (isiKata == "N") arrayListOf(
            ListKalimat("Nana"),
            ListKalimat("Nika"),
            ListKalimat("Nasi"))
        else if (isiKata == "O") arrayListOf(
            ListKalimat("Oh"),
            ListKalimat("Oke"),
            ListKalimat("Oleh-oleh"))
        else if (isiKata == "P") arrayListOf(
            ListKalimat("Petani"),
            ListKalimat("Palang"),
            ListKalimat("Peraturan"))
        else if (isiKata == "Q") arrayListOf(
            ListKalimat("Quail"),
            ListKalimat("Quetzal"),
            ListKalimat("Quokka"))
        else if (isiKata == "R") arrayListOf(
            ListKalimat("Rajin"),
            ListKalimat("Resik"),
            ListKalimat("Ramah"))
        else if (isiKata == "S") arrayListOf(
            ListKalimat("Sigit"),
            ListKalimat("Santoryu"),
            ListKalimat("Samurai"))
        else if (isiKata == "T") arrayListOf(
            ListKalimat("Teman"),
            ListKalimat("Tetangga"),
            ListKalimat("Tante"))
        else if (isiKata == "U") arrayListOf(
            ListKalimat("Ucap"),
            ListKalimat("Ubi"),
            ListKalimat("UwU"))
        else if (isiKata == "V") arrayListOf(
            ListKalimat("Vaksin"),
            ListKalimat("Varian"),
            ListKalimat("Vampir"))
        else if (isiKata == "W") arrayListOf(
            ListKalimat("Wahyu"),
            ListKalimat("Wahid"),
            ListKalimat("Wali"))
        else if (isiKata == "X") arrayListOf(
            ListKalimat("Xantofil"),
            ListKalimat("Xenon"),
            ListKalimat("X-Drake"))
        else if (isiKata == "Y") arrayListOf(
            ListKalimat("Yasopp"),
            ListKalimat("Yakin"),
            ListKalimat("Yahudi"))
        else if (isiKata == "Z") arrayListOf(
            ListKalimat("Zamrud"),
            ListKalimat("Zakat"),
            ListKalimat("Zebra"))
        else {arrayListOf()}
    }
}