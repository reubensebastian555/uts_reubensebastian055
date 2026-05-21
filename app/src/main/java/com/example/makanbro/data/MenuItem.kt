package com.example.makanbro.data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Icecream

data class MenuItem(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val icon: ImageVector
)

val dummyMenu = listOf(
    MenuItem(
        id = 1,
        name = "Burger Lava",
        price = "Rp 45.000",
        description = "Burger dengan keju meleleh yang melimpah dan daging sapi pilihan yang juicy. Disajikan dengan saus rahasia pedas.",
        icon = Icons.Default.Fastfood
    ),
    MenuItem(
        id = 2,
        name = "Matcha Latte",
        price = "Rp 28.000",
        description = "Minuman matcha autentik Jepang yang dipadukan dengan susu segar yang creamy. Cocok untuk menemani hari santai.",
        icon = Icons.Default.LocalBar
    ),
    MenuItem(
        id = 3,
        name = "Pasta Carbonara",
        price = "Rp 55.000",
        description = "Pasta al dente dengan saus carbonara klasik yang kaya rasa, lengkap dengan potongan smoked beef dan keju parmesan.",
        icon = Icons.Default.Restaurant
    ),
    MenuItem(
        id = 4,
        name = "Orange Mocktail",
        price = "Rp 25.000",
        description = "Kesegaran jeruk pilihan dengan sentuhan mint dan soda yang menyegarkan dahaga.",
        icon = Icons.Default.LocalBar
    ),
    MenuItem(
        id = 5,
        name = "Steak Premium",
        price = "Rp 120.000",
        description = "Daging sirloin pilihan dengan tingkat kematangan sempurna, disajikan dengan potato wedges dan sayuran segar.",
        icon = Icons.Default.Restaurant
    )
)
