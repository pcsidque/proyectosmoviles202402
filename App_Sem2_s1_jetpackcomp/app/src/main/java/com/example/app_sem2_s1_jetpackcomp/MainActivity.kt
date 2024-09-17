package com.example.app_sem2_s1_jetpackcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_sem2_s1_jetpackcomp.ui.theme.App_Sem2_s1_jetpackcompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalData(name = "Alberto")
        }
    }
}

@Composable
private fun PersonalData(name: String, modifier: Modifier = Modifier){
    MaterialTheme {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(top = 48.dp)) {
            Text(text = "Buenos días $name", style = MaterialTheme.typography.displayLarge)
            Text(text = "Soy Profesor")
            Text(text = "Correo: pcidque@uuu")

            Image(
                painter = painterResource(id = R.drawable.classdojo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }
    }
}

@Preview
@Composable
private fun PreviewPersonalData(){
    Text(text = "Buenos días Alberto Arturo")
}