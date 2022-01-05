package com.example.guestskotlin.service.repository

import com.example.guestskotlin.service.model.GuestModel

class GuestRepository {

    fun getAll() : List<GuestModel>{
        val guestList : MutableList<GuestModel> = ArrayList()
        return guestList
    }
    fun getPresent() : List<GuestModel>{
        val presentsList : MutableList<GuestModel> = ArrayList()
        return presentsList
    }
    fun getAbsent() : List<GuestModel>{
        val absentsList : MutableList<GuestModel> = ArrayList()
        return absentsList
    }

    fun save(guest : GuestModel){

    }
}