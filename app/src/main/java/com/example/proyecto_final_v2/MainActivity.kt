package com.example.proyecto_final_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TextComparisonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.viewModel = ViewModelProvider(this)[TextComparisonViewModel::class.java]

        val text1EditText = findViewById<TextView>(R.id.editText1)
        val text2EditText = findViewById<TextView>(R.id.editText2)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val compareButton = findViewById<Button>(R.id.compareButton)

        compareButton.setOnClickListener {
            viewModel.text1.value = text1EditText.text.toString()
            viewModel.text2.value = text2EditText.text.toString()
            viewModel.compareTexts()
        }

        viewModel.comparisonResult.observe(this) { result ->
            if (result != null) {
                resultTextView.text = if (result) "Los textos son iguales" else "Los textos no son iguales"
            }
        }

    }
}