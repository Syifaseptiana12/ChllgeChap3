package com.binar.chllgechap3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alphabetsFragment = FragmentAbjad()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment, alphabetsFragment)
        fragmentTransaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, FragmentAbjad()).commit()
        return super.onSupportNavigateUp()
    }
}