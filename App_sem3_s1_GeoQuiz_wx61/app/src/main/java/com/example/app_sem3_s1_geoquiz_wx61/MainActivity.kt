package com.example.app_sem3_s1_geoquiz_wx61

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("¿Es Arequipa capital de Lima?", false))
        questions.add(Question("¿Es Lima capital de Perú?", true))
        questions.add(Question("¿Es Santiago capital de Chile?", true))
        questions.add(Question("¿Es Santiago capital de Lima?", false))
        questions.add(Question("¿Es Quito capital de Lima?", false))
        questions.add(Question("¿Es Quito capital de Ecuador?", true))
    }

    private fun setupViews() {
        //1.	Vincular los componentes con la lógica
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)

        tvQuestion.text = questions[position].sentence

        //doy acción a los botones
        btYes.setOnClickListener {
            if (questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNo.setOnClickListener {
            if (!questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNext.setOnClickListener {
            position++
            tvQuestion.text = questions[position].sentence
        }

    }
}