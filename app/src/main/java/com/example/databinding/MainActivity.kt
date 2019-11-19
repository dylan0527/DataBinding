package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit = late initialise(dk what assign to the variable so we late assign the value to it)
    private lateinit var binding: ActivityMainBinding
    //create an instance of Contact Class
    private var myContact: Contact = Contact("Dylan","012-4040482")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.contact = myContact
        binding.buttonDone.setOnClickListener {
            updateNameAndPhone()
        }
    }

    fun updateNameAndPhone(){
        //apply = multiple setter on a single object
        binding.apply {
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()
            //invalidateAll() refresh UI
            this.invalidateAll()
        }
    }
}


