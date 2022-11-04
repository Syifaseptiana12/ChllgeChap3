package com.binar.chllgechap3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdapterAbjad(private val listHurufList: ArrayList<ListAbjad>, private val layoutManager: GridLayoutManager):
    RecyclerView.Adapter<AdapterAbjad.HurufViewHolder>() {
    private val layoutGrid = 1
    private val layoutList = 2

    class HurufViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        // Method tombol huruf kala dalam grid view
        fun gridLayouter(parameterHuruf : ListAbjad){
            val tombolHuruf = itemView.findViewById<Button>(R.id.abjad)
            tombolHuruf.text = parameterHuruf.Abjad
            tombolHuruf.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(tombolHuruf.text.toString())
                with(activity) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment,fragmentKalimat).addToBackStack("fragment").commit()
                }
            }
        }


        fun listLayouter(parameterHuruf : ListAbjad){
            val tombolHuruf = itemView.findViewById<Button>(R.id.btnKalimat)
            tombolHuruf.text = parameterHuruf.Abjad
            tombolHuruf.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(tombolHuruf.text.toString())
                with(activity) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment,fragmentKalimat).addToBackStack("fragment").commit()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HurufViewHolder {
        val view = if(viewType == layoutGrid) LayoutInflater.from(parent.context)
            .inflate(R.layout.list_abjad, parent, false) else LayoutInflater.from(parent.context)
            .inflate(R.layout.list_kalimat, parent, false)
        return HurufViewHolder(view)
    }

    override fun onBindViewHolder(holder: HurufViewHolder, position: Int) =
        if(layoutManager.spanCount == 1) holder.listLayouter(listHurufList[position]) else holder.gridLayouter(listHurufList[position])

    override fun getItemCount(): Int {
        return listHurufList.size
    }

    override fun getItemViewType(position: Int): Int {
        val gridCount: Int = layoutManager.spanCount
        return if(gridCount == 3) {
            layoutGrid
        } else {
            layoutList
        }
    }
}