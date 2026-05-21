package com.example.makanbro.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makanbro.storage.PreferenceManager
import com.example.makanbro.ui.theme.OrangeModern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    preferenceManager: PreferenceManager,
    onNavigateToEdit: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val name = preferenceManager.getString(PreferenceManager.KEY_RESTAURANT_NAME, "Sunset Bites")
    val address = preferenceManager.getString(PreferenceManager.KEY_ADDRESS, "Jl. Modern No. 123, Jakarta")
    val desc = preferenceManager.getString(PreferenceManager.KEY_DESCRIPTION, "Restoran dengan konsep minimalis modern yang menyajikan hidangan lezat dengan bahan berkualitas tinggi.")
    val hours = preferenceManager.getString(PreferenceManager.KEY_OPENING_HOURS, "10:00 - 22:00")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profil Restoran", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = OrangeModern
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(120.dp),
                shape = CircleShape,
                color = OrangeModern.copy(alpha = 0.1f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Storefront,
                        contentDescription = null,
                        tint = OrangeModern,
                        modifier = Modifier.size(60.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            ProfileInfoCard(
                icon = Icons.Default.LocationOn,
                title = "Alamat",
                content = address
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileInfoCard(
                icon = Icons.Default.Info,
                title = "Deskripsi",
                content = desc
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileInfoCard(
                icon = Icons.Default.AccessTime,
                title = "Jam Buka",
                content = hours
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = onNavigateToEdit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = OrangeModern),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.Edit, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Edit Profil", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ProfileInfoCard(icon: ImageVector, title: String, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = OrangeModern,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}
