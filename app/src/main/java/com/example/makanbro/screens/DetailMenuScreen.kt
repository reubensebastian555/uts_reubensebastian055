package com.example.makanbro.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makanbro.data.dummyMenu
import com.example.makanbro.ui.theme.OrangeModern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMenuScreen(
    menuId: Int,
    onNavigateBack: () -> Unit
) {
    val menuItem = dummyMenu.find { it.id == menuId }
    var rating by remember { mutableStateOf(4) }
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Menu", fontWeight = FontWeight.Bold) },
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
        if (menuItem != null) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + expandVertically(),
                modifier = Modifier.padding(padding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = OrangeModern.copy(alpha = 0.1f))
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Icon(
                                imageVector = menuItem.icon,
                                contentDescription = null,
                                tint = OrangeModern,
                                modifier = Modifier.size(120.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = menuItem.name,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = menuItem.price,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrangeModern
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Rating",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        repeat(5) { index ->
                            IconButton(
                                onClick = { rating = index + 1 },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = if (index < rating) Icons.Default.Star else Icons.Outlined.StarOutline,
                                    contentDescription = null,
                                    tint = OrangeModern
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Deskripsi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = menuItem.description,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        lineHeight = 24.sp
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = onNavigateBack,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = OrangeModern),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Pesan Sekarang", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
