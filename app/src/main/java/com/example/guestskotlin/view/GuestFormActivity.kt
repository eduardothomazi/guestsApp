package com.example.guestskotlin.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.guestskotlin.R
import com.example.guestskotlin.R.layout
import com.example.guestskotlin.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity() {

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_guest_form)
        val saveButton = findViewById<Button>(R.id.save_button);
        val cancelButton = findViewById<Button>(R.id.cancel_button);
        val editName = findViewById<EditText>(R.id.edit_name)
        val radioPresence = findViewById<RadioButton>(R.id.radio_present)
        val radioAbsence = findViewById<RadioButton>(R.id.radio_absent)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        observe()



        saveButton.setOnClickListener {

            val name = editName.text.toString();
            var boolean : Boolean = false;
            if (!radioPresence.isChecked && !radioAbsence.isChecked){
                Toast.makeText(this,"Check one option!",Toast.LENGTH_SHORT).show()
            }else if (radioPresence.isChecked && !radioAbsence.isChecked){
                boolean = true
                mViewModel.save(name,boolean)
                Toast.makeText(this, "$name checked present!",Toast.LENGTH_SHORT).show()
                finish()
            }else{
                mViewModel.save(name,boolean)
                Toast.makeText(this,"$name checked absent!",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
    private fun observe(){
        mViewModel.saveGuest.observe(this, Observer {
            if (it){
                Toast.makeText(this,"Success!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Failure!",Toast.LENGTH_SHORT).show()
            }

        })
    }
}