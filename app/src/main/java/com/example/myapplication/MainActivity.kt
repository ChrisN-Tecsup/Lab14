package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val paymentStatus = "Pago Pendiente"
    val nextRoute = "Av. Ejército -> Centro Histórico"
    val timeEstimate = "15 minutos"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Información del Pago y Ruta",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Estado de Pago: $paymentStatus", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Ruta Siguiente: $nextRoute", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Tiempo Estimado: $timeEstimate", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /* Acción para realizar el pago */ },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Pagar ahora")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}

