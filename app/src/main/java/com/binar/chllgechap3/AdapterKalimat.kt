package com.binar.chllgechap3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AdapterKalimat(daftarKata: ArrayList<ListKalimat>)

    class KalimatViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bindView(listKalimat: ListKalimat) {
            val tombolKata = view.findViewById<Button>(R.id.btnKalimat)
            tombolKata.text = listKalimat.Kata
            tombolKata.setOnClickListener {
                val activity = view.context as MainActivity
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=${listKalimat.kata}")
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KalimatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_kalimat, parent, false)
        return KalimatViewHolder(view)
    }

    override fun onBindViewHolder(holder: KalimatViewHolder, position: Int) {
        holder.bindView(listKalimatList[position])
    }

    override fun getItemCount(): Int {
        return listKalimatList.size
    }{
}