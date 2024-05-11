package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_shopping_list)

        val items = listOf("1 small onion", "beef mince", "eggs", "vegetable oil",
                "4 burger buns", "tomato", "beetroot", "horseradish sauce", "mayonnaise", "ketchup",
                "iceberg lettuce", "rocket", "watercress"
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = ShoppingListAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}