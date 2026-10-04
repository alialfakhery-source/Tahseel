package com.example.tahseel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DebtDao {
    @Insert
    suspend fun insertDebt(debt: Debt)

    @Query("SELECT * FROM debts")
    fun getAllDebts(): Flow<List<Debt>>
}
