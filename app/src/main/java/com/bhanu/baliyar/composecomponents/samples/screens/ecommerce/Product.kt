package com.bhanu.baliyar.composecomponents.samples.screens.ecommerce

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val isSelected: Boolean = false,
    val rating: Float = 0f,
    val reviewCount: Int = 0
)

fun sampleProducts() = listOf(
    Product(1, "Small Plant Sill for desk", "Made from wood, fits 3 plants", "£89.99", "https://images.pexels.com/photos/3076899/pexels-photo-3076899.jpeg", true, 5f),
    Product(2, "Agent Mug", "Handcrafted porcelain mug", "£19.00", "https://images.pexels.com/photos/1325463/pexels-photo-1325463.jpeg", false, 4f),
    Product(3, "Hardwood Stool", "Classic design, timeless material", "£99.00", "https://images.pexels.com/photos/1866149/pexels-photo-1866149.jpeg", false, 5f),
    Product(4, "Ceramic Plate Set", "Made in our personal kiln", "£59.99", "https://images.pexels.com/photos/395187/pexels-photo-395187.jpeg", true, 4f, 84)
)