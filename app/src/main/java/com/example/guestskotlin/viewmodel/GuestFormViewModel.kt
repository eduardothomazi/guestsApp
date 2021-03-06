package com.example.guestskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.guestskotlin.service.model.GuestModel
import com.example.guestskotlin.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository : GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest : LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence : Boolean){
        val guest = GuestModel(null,name, presence)
        mSaveGuest.value = mGuestRepository.save(guest)
    }
}