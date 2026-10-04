package com.example.tahseel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DebtViewModel
    private lateinit var debtAdapter: DebtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDebts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        debtAdapter = DebtAdapter(emptyList())
        recyclerView.adapter = debtAdapter

        viewModel = ViewModelProvider(this)[DebtViewModel::class.java]

        viewModel.allDebts.observe(this) { debts ->
            debts?.let { debtAdapter.updateDebts(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fabAddDebt)
        fab.setOnClickListener {
            // إضافة دين تجريبي للاختبار عند الضغط على الزر العائم
            val sampleDebt = Debt(name = "محمد أحمد", amount = 150.0)
            viewModel.insert(sampleDebt)
        }
    }
}
