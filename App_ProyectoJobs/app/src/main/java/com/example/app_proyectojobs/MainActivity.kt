package com.example.app_proyectojobs

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var jobs: List<Job>
    lateinit var jobAdapter : JobAdapter //3ra parte del RV

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btSearch = findViewById<Button>(R.id.btSearch)
        btSearch.setOnClickListener {
            searchJob()
        }
    }

    private fun searchJob() {
        val etDescription = findViewById<TextInputEditText>(R.id.etDescription)
        val rvJob = findViewById<RecyclerView>(R.id.rvJob)
        val description = etDescription.text.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://test-api-maryjenn05s-projects.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JobService::class.java)
        //val service = retrofit.create(JobService::class.java)

        val request = service.searchJob(description)

        request.enqueue(object : Callback<List<Job>>{
            override fun onResponse(p0: Call<List<Job>>, p1: Response<List<Job>>) {
                jobs = p1.body()!!
                jobAdapter = JobAdapter(jobs) //OJO

                rvJob.adapter = jobAdapter
                rvJob.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(p0: Call<List<Job>>, p1: Throwable) {
                Log.d("MainActivity", p1.toString())
            }
        })
    }
}