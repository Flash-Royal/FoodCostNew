package com.example.foodcost.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodcost.db.entity.Good
import com.example.foodcost.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val rep: Repository
): ViewModel(){
    private val _goods = MutableLiveData<List<Good>>()
    val goods: LiveData<List<Good>>
        get() = _goods

    fun getGoods() {
        viewModelScope.launch {
            _goods.value = rep.getGoods()
        }
    }

    fun insertGood(good: Good) {
        viewModelScope.launch {
            rep.insertGood(good)
            _goods.value = rep.getGoods()
        }
    }

    fun deleteGood(good: Good) {
        viewModelScope.launch {
            rep.deleteGood(good)
            _goods.value = rep.getGoods()
        }
    }
}