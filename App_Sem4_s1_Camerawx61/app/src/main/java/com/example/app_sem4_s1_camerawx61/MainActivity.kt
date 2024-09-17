package com.example.app_sem4_s1_camerawx61

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //reconocer el control
        val btCamera = findViewById<Button>(R.id.btCamera)

        btCamera.setOnClickListener {
            checkCameraPermission()
        }
    }

    //verifico si ya tiene el permiso
    private fun checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            //V No tengo permiso
            //Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show()
            requestCameraPermission()
        }
        else{
            Toast.makeText(this, "Si tiene permiso", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            Toast.makeText(this, "Ya se pidio el permiso ANTES. Habilitelo MANUALMENTE!", Toast.LENGTH_SHORT).show()
        }
        else{
            //Aqui pido el permiso
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQUEST_CODE ->{
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Se OTORGO el permiso de la camara", Toast.LENGTH_SHORT).show()
                    //Aqui vendría la funcionalidad del programa
                }
                else{
                    Toast.makeText(this, "No se OTORGO el permiso de la camara", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}