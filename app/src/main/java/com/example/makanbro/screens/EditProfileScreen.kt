package com.example.makanbro.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makanbro.storage.PreferenceManager
import com.example.makanbro.ui.theme.OrangeModern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    preferenceManager: PreferenceManager,
    onSaveSuccess: () -> Unit,
    onCancel: () -> Unit
) {
    var name by remember { mutableStateOf(preferenceManager.getString(PreferenceManager.KEY_RESTAURANT_NAME, "Sunset Bites")) }
    var address by remember { mutableStateOf(preferenceManager.getString(PreferenceManager.KEY_ADDRESS, "Jl. Modern No. 123, Jakarta")) }
    var desc by remember { mutableStateOf(preferenceManager.getString(PreferenceManager.KEY_DESCRIPTION, "Restoran dengan konsep minimalis modern...")) }
    var hours by remember { mutableStateOf(preferenceManager.getString(PreferenceManager.KEY_OPENING_HOURS, "10:00 - 22:00")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profil", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onCancel) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Batal")
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Restoran") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = desc,
                onValueChange = { desc = it },
                label = { Text("Deskripsi") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                minLines = 3
            )

            OutlinedTextField(
                value = hours,
                onValueChange = { hours = it },
                label = { Text("Jam Buka") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    preferenceManager.saveString(PreferenceManager.KEY_RESTAURANT_NAME, name)
                    preferenceManager.saveString(PreferenceManager.KEY_ADDRESS, address)
                    preferenceManager.saveString(PreferenceManager.KEY_DESCRIPTION, desc)
                    preferenceManager.saveString(PreferenceManager.KEY_OPENING_HOURS, hours)
                    onSaveSuccess()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = OrangeModern),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Simpan Perubahan", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Batal", fontSize = 16.sp, color = Color.Gray)
            }
        }
    }
}
