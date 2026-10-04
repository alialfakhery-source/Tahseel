package com.example.tahseel

import kotlinx.coroutines.flow.Flow

class DebtRepository(private val debtDao: DebtDao) {

    val allDebts: Flow<List<Debt>> = debtDao.getAllDebts()

    suspend fun insert(debt: Debt) {
        debtDao.insertDebt(debt)
    }
}
