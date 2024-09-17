package com.example.app_sem4_s1_recyclerviewwx61

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Bertha", "159357000"))
        contacts.add(Contact("Vero", "559357000"))
        contacts.add(Contact("Sandro", "889357000"))
        contacts.add(Contact("Mark", "999357000"))
        contacts.add(Contact("Vito", "199357000"))
        contacts.add(Contact("Bals", "159357000"))
        contacts.add(Contact("Sandro v2", "889357000"))
        contacts.add(Contact("Isa Mark", "999357000"))
        contacts.add(Contact(" nH. Vito", "199357000"))
        contacts.add(Contact("Balsito", "159357000"))
        contacts.add(Contact("Bertha", "159357000"))
        contacts.add(Contact("Vero", "559357000"))
        contacts.add(Contact("Sandro", "889357000"))
        contacts.add(Contact("Mark", "999357000"))
        contacts.add(Contact("Vito", "199357000"))
        contacts.add(Contact("Bals", "159357000"))
        contacts.add(Contact("Sandro v2", "889357000"))
        contacts.add(Contact("Isa Mark", "999357000"))
        contacts.add(Contact(" nH. Vito", "199357000"))
        contacts.add(Contact("Balsito", "159357000"))
    }
}