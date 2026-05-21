package com.example.makanbro.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makanbro.storage.PreferenceManager
import com.example.makanbro.ui.theme.OrangeModern
import com.example.makanbro.ui.theme.DarkNavy

@Composable
fun HomeScreen(
    preferenceManager: PreferenceManager,
    onNavigateToMenu: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    val restaurantName = preferenceManager.getString(PreferenceManager.KEY_RESTAURANT_NAME, "Sunset Bites")
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(OrangeModern.copy(alpha = 0.1f), Color.White)
                )
            )
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier.size(120.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(containerColor = OrangeModern),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = Icons.Default.Restaurant,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Selamat Datang di",
                    fontSize = 18.sp,
                    color = DarkNavy.copy(alpha = 0.7f)
                )

                Text(
                    text = restaurantName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = OrangeModern,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Nikmati pengalaman kuliner terbaik dengan rasa yang autentik dan pelayanan yang hangat.",
                    fontSize = 14.sp,
                    color = DarkNavy.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    onClick = onNavigateToMenu,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeModern),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Default.Restaurant, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Lihat Menu", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = onNavigateToProfile,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = Brush.linearGradient(listOf(OrangeModern, OrangeModern)))
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, tint = OrangeModern)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Profil Restoran", fontSize = 16.sp, color = OrangeModern)
                }
            }
        }
    }
}
