package com.devrachit.dcasignment.utility.constants

import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.presentation.screens.widgets.ProductData

class Constants {
    companion object{
        data class Category(val name: String, val image: Int)
        
        val category: List<Category> = listOf(
            Category("Day Wear", R.drawable.category),
            Category("Night Wear", R.drawable.category),
            Category("Face Cream", R.drawable.category),
            Category("Party Wear", R.drawable.category),
            Category("Sunscreen", R.drawable.category),
            Category("Lipstick", R.drawable.category),
            Category("Perfume", R.drawable.category)
        )
        
        data class FilterChipData(val id: String, val label: String)
        
        val filterChips: List<FilterChipData> = listOf(
            FilterChipData("1", "Beauty"),
            FilterChipData("2", "Skincare"),
            FilterChipData("3", "Makeup"),
            FilterChipData("4", "Fragrance"),
            FilterChipData("5", "Hair Care"),
            FilterChipData("6", "Body Care"),
            FilterChipData("7", "Anti-Aging"),
            FilterChipData("8", "Moisturizer")
        )
        
        val productList: List<ProductData> = listOf(
            ProductData(
                isWishlisted = true,
                isBestSeller = true,
                isInCart = false,
                isInStock = true,
                productImage = R.drawable.product,
                productName = "Premium Face Cream",
                shortDescription = "Nourishing formula for all skin types",
                boldPoints = "Anti-aging • Moisturizing • Natural",
                presentAmount = "Rs. 499",
                strikethroughAmount = "Rs. 700",
                starRating = 4.2f,
                reviewCount = "205 reviews"
            ),
            ProductData(
                isWishlisted = false,
                isBestSeller = false,
                isInCart = true,
                isInStock = true,
                productImage = R.drawable.product,
                productName = "Luxury Serum",
                shortDescription = "Premium anti-aging serum",
                boldPoints = "Vitamin C • Hyaluronic Acid • Retinol",
                presentAmount = "Rs. 899",
                strikethroughAmount = "Rs. 1200",
                starRating = 3.8f,
                reviewCount = "67 reviews"
            ),
            ProductData(
                isWishlisted = false,
                isBestSeller = true,
                isInCart = false,
                isInStock = false,
                productImage = R.drawable.product,
                productName = "Organic Moisturizer",
                shortDescription = "100% natural ingredients",
                boldPoints = "Organic • Paraben-free • Gentle",
                presentAmount = "Rs. 350",
                strikethroughAmount = "",
                starRating = 4.5f,
                reviewCount = "142 reviews"
            ),
            ProductData(
                isWishlisted = true,
                isBestSeller = false,
                isInCart = true,
                isInStock = true,
                productImage = R.drawable.product,
                productName = "Vitamin C Cleanser",
                shortDescription = "Brightening facial cleanser",
                boldPoints = "Brightening • Deep cleansing • pH balanced",
                presentAmount = "Rs. 299",
                strikethroughAmount = "Rs. 399",
                starRating = 3.9f,
                reviewCount = "89 reviews"
            ),
            ProductData(
                isWishlisted = false,
                isBestSeller = false,
                isInCart = false,
                isInStock = true,
                productImage = R.drawable.product,
                productName = "Night Recovery Mask",
                shortDescription = "Intensive overnight treatment",
                boldPoints = "Repairing • Hydrating • Overnight",
                presentAmount = "Rs. 799",
                strikethroughAmount = "Rs. 999",
                starRating = 4.1f,
                reviewCount = "156 reviews"
            ),
            ProductData(
                isWishlisted = true,
                isBestSeller = true,
                isInCart = false,
                isInStock = false,
                productImage = R.drawable.product,
                productName = "Sunscreen SPF 50",
                shortDescription = "Broad spectrum sun protection",
                boldPoints = "SPF 50 • Water resistant • Non-greasy",
                presentAmount = "Rs. 450",
                strikethroughAmount = "",
                starRating = 4.0f,
                reviewCount = "234 reviews"
            ),
            ProductData(
                isWishlisted = false,
                isBestSeller = false,
                isInCart = true,
                isInStock = true,
                productImage = R.drawable.product,
                productName = "Exfoliating Scrub",
                shortDescription = "Gentle daily exfoliation",
                boldPoints = "Gentle • Natural beads • Refreshing",
                presentAmount = "Rs. 199",
                strikethroughAmount = "Rs. 250",
                starRating = 3.7f,
                reviewCount = "76 reviews"
            )
        )
    }
}
