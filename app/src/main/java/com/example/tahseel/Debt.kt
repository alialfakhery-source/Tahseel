package com.example.tahseel

data class Debt(
    val id: Long = 0,
    val storeName: String,       // اسم المحل (مثل: شركة ليلاس طبرق)
    val customerName: String,    // اسم الزبون / المسوق (مثل: علي محمد)
    val customerPhone: String,   // رقم الهاتف (مثل: 0925480882)
    val storeAddress: String,    // العنوان (مثل: حي المختار)
    val totalAmount: Double,     // قيمة الفاتورة الإجمالية (مثل: 1645.0)
    val invoiceDate: String,     // تاريخ الفاتورة
    val dueDate: String,         // تاريخ التحصيل (لضبط التنبيه قبله بيوم)
    val isPaid: Boolean = false  // حالة السداد
)
