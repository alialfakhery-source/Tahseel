package com.example.tahseel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DebtViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DebtRepository
    val allDebts: LiveData<List<Debt>>

    init {
        val debtsDao = AppDatabase.getDatabase(application).debtDao()
        repository = DebtRepository(debtsDao)
        allDebts = repository.allDebts.asLiveData()
    }

    fun insert(debt: Debt) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(debt)
    }
}
