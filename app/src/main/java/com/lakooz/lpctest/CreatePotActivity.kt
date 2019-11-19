package com.lakooz.lpctest
import com.lakooz.lpctest.databinding.ActivityCreatePotBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class CreatePotActivity : AppCompatActivity() {

    lateinit var binding : ActivityCreatePotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pot)

        binding = ActivityCreatePotBinding.inflate(layoutInflater)
        val model = ViewModelProviders.of(this).get(CreatePotViewModel::class.java)
        binding.viewmodel=model

        model.pot.observe(this, Observer { pot->
            //todo : add to room in VM and display a message here
        })
    }
}
