package com.example.app_sem4_s1_recyclerviewwx61

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactAdapter(var contacts: ArrayList<Contact>): Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        //metodo que se encarga de "inflar" los datos en el prototype
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_contact,parent,false)

        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bind(contacts.get(position))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //vincular los componentes del prototypo con el adapter
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvTelephone = itemView.findViewById<TextView>(R.id.tvTelephone)

    //vamos a crear una función "bind" que vincule el control con la clase COntact
    fun bind(contact: Contact){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
    }
}