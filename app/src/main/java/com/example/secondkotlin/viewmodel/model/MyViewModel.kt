package com.example.secondkotlin.viewmodel.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondkotlin.viewmodel.bean.User

/**
 * viewModel 存放一个mutableList<User>
 */
class MyViewModel: ViewModel() {
    val userMess: MutableLiveData<MutableList<User>> = MutableLiveData()
    private var count : Int = 0
    init {
        userMess.value = mutableListOf<User>()
    }

    /**
     * 获取一个user，根据id
     * @param id ID
     */
    private fun getUser(id: Int): User ? {
        userMess.value?.forEach {
            if (id == it.id) {
                Log.i("get","${it.toString()}")
                return it
            }
        }
        return null
    }
    fun query(id: Int) : User?{
        return getUser(id)
    }

    fun addUser(user :User) : Boolean{
        return if (getUser(user.id) == null){
            userMess.value?.add(user)
            ++count
            Log.i("add","$count")
            true
        }else{
            false
        }
    }

    fun remove(id: Int): Boolean{
        var user = getUser(id)
        return if (user == null) {
            false
        }else{
            userMess.value?.remove(user)
            --count
            Log.i("remove","$count")

            true
        }
    }

    fun getCount():Int{
        return count
    }

    override fun onCleared() {
        Log.i("MyViewModel","----onCleared----")
        super.onCleared()
    }



}