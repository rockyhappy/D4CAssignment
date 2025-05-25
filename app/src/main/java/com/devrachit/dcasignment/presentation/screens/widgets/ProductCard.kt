package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit12Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit14Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit14Lh16Fw600
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit16Lh20Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit20Lh26Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeitsl14Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleTangerine24Lh30Fw400
import com.devrachit.dcasignment.utility.compose_utility.sdp

/**
 * Data class representing a product with all necessary information for display
 * Contains state information for wishlist, cart, stock status, and product details
 * 
 * @param isWishlisted Whether the product is in user's wishlist
 * @param isBestSeller Whether the product has best seller badge
 * @param isInCart Whether the product is in user's cart
 * @param isInStock Whether the product is currently available
 * @param productImage Resource ID for product image
 * @param productName Display name of the product
 * @param shortDescription Brief product description
 * @param boldPoints Key product features/benefits
 * @param presentAmount Current selling price
 * @param strikethroughAmount Original price (if discounted)
 * @param starRating Product rating out of 5
 * @param reviewCount Number of reviews as display string
 */
data class ProductData(
    val isWishlisted: Boolean = false,
    val isBestSeller: Boolean = false,
    val isInCart: Boolean = false,
    val isInStock: Boolean = true,
    val productImage: Int = R.drawable.product,
    val productName: String = "Premium Face Cream",
    val shortDescription: String = "Short Description of the Product",
    val boldPoints: String = "Bold Description about Quality",
    val presentAmount: String = "Rs. 499",
    val strikethroughAmount: String = "Rs. 700",
    val starRating: Float = 3.5f,
    val reviewCount: String = "205 reviews"
)

/**
 * Product Card Composable that displays a single product with all interactive elements
 * 
 * Features:
 * - Clickable wishlist heart icon with visual state indication
 * - Clickable cart icon with visual state indication
 * - Best seller badge display
 * - Stock status indicator
 * - Price display with discount strikethrough
 * - Star rating visualization
 * - Responsive layout with proper spacing
 * 
 * @param productData Product information to display
 * @param onWishlistClick Callback when wishlist icon is clicked
 * @param onCartClick Callback when cart icon is clicked
 * @param onProductClick Callback when product card is clicked
 * @param modifier Modifier for styling and layout customization
 */
@Composable
fun ProductCard(
    productData: ProductData = ProductData(),
    onWishlistClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onProductClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.sdp, start = 10.sdp, end = 10.sdp)
    ) {
        // Clickable wishlist heart icon positioned at top-left
        Image(
            painter = painterResource(id = if (productData.isWishlisted) R.drawable.ic_heart_filled else R.drawable.ic_heart),
            contentDescription = "Wishlist",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.sdp)
                .background(Color.Black)
                .padding(10.sdp)
                .clickable { onWishlistClick() },
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                if (productData.isWishlisted) colorResource(R.color.e_purple_400) else colorResource(R.color.e_purple_400)
            )
        )
        
        // Background product image for card styling
        Image(
            painter = painterResource(id = R.drawable.bg_product),
            contentDescription = "Product Background",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
        
        // Best seller badge - conditionally displayed
        if (productData.isBestSeller) {
            Text(
                text = "Best Seller",
                style = TextStyleNeuzeitsl14Lh16Fw400(),
                modifier = Modifier
                    .padding(top = 20.sdp, end = 20.sdp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(15.sdp))
                    .background(colorResource(R.color.black))
                    .padding(horizontal = 10.sdp, vertical = 5.sdp),
                color = colorResource(id = R.color.primary_color),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        
        // Main product image
        Image(
            painter = painterResource(id = productData.productImage),
            contentDescription = productData.productName,
            modifier = Modifier
                .padding(top = 50.sdp, end = 20.sdp, start = 20.sdp)
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
        
        // Product details section with background overlay
        Box(
            modifier = Modifier
                .padding(bottom = 20.sdp, end = 20.sdp, start = 20.sdp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            // Background for product information section
            Image(
                painter = painterResource(id = R.drawable.bg_product_title),
                contentDescription = "Product Title Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            // Product information overlay with structured layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                // Header section: Product name and stock status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = productData.productName,
                        style = TextStyleTangerine24Lh30Fw400(),
                        color = colorResource(id = R.color.primary_color),
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.weight(1f)
                    )
                    
                    // Stock status indicator
                    if (productData.isInStock) {
                        Text(
                            text = "● In Stock",
                            style = TextStyleNeuzeit12Lh16Fw400(),
                            color = colorResource(id = R.color.primary_color),
                            textAlign = TextAlign.End,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                }

                // Product details section
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Short description
                    Text(
                        text = productData.shortDescription,
                        style = TextStyleNeuzeit14Lh16Fw400(),
                        color = colorResource(id = R.color.white).copy(alpha = 0.7f),
                        textAlign = TextAlign.Start
                    )
                    
                    // Bold points/features
                    Text(
                        text = productData.boldPoints,
                        style = TextStyleNeuzeit14Lh16Fw600(),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )

                    // Price section with discount display
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        // Current price
                        Text(
                            text = productData.presentAmount,
                            style = TextStyleNeuzeit20Lh26Fw400(),
                            color = colorResource(id = R.color.purple_200),
                            fontWeight = FontWeight.Bold
                        )

                        // Original price with strikethrough (if discount available)
                        if (productData.strikethroughAmount.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = productData.strikethroughAmount,
                                style = TextStyleNeuzeit12Lh16Fw400(),
                                color = Color.Gray,
                                textDecoration = androidx.compose.ui.text.style.TextDecoration.LineThrough
                            )
                        }
                    }
                    
                    // Rating and review section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Star rating visualization
                        val rating = productData.starRating
                        val fullStars = rating.toInt()
                        val hasHalfStar = rating % 1 != 0f

                        // Display full stars
                        repeat(fullStars) {
                            Text(
                                text = "★",
                                style = TextStyleNeuzeit16Lh20Fw400(),
                                color = colorResource(id = R.color.primary_color)
                            )
                        }

                        // Display half star if applicable
                        if (hasHalfStar) {
                            Text(
                                text = "☆",
                                style = TextStyleNeuzeit16Lh20Fw400(),
                                color = colorResource(id = R.color.primary_color)
                            )
                        }

                        // Display remaining empty stars
                        val remainingStars = 5 - fullStars - if (hasHalfStar) 1 else 0
                        repeat(remainingStars) {
                            Text(
                                text = "☆",
                                style = TextStyleNeuzeit16Lh20Fw400(),
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Review count with underline styling
                        Text(
                            text = productData.reviewCount,
                            style = TextStyleNeuzeit12Lh16Fw400().copy(
                                textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
                            ),
                            color = colorResource(id = R.color.white).copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
        
        // Clickable cart button positioned at bottom-right
        Image(
            painter = painterResource(id = if (productData.isInCart) R.drawable.ic_cart_filled else R.drawable.ic_cart_outlined),
            contentDescription = "Add to Cart",
            modifier = Modifier
                .padding(bottom = 20.sdp, end = 20.sdp)
                .align(Alignment.BottomEnd)
                .clip(CircleShape)
                .size(60.sdp)
                .background(Color.Black)
                .border(
                    BorderStroke(1.dp, colorResource(R.color.primary_color)),
                    CircleShape
                )
                .padding(15.sdp)
                .clickable { onCartClick() },
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(colorResource(R.color.primary_color))
        )
    }
}

// Preview composables for development and testing
@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        productData = ProductData(
            isWishlisted = true,
            isBestSeller = true,
            isInCart = false,
            isInStock = true,
            productName = "Premium Face Cream",
            shortDescription = "Nourishing formula for all skin types",
            boldPoints = "Anti-aging • Moisturizing • Natural",
            presentAmount = "Rs. 499",
            strikethroughAmount = "Rs. 700",
            starRating = 4.2f,
            reviewCount = "128 reviews"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ProductCardOutOfStockPreview() {
    ProductCard(
        productData = ProductData(
            isWishlisted = false,
            isBestSeller = false,
            isInCart = true,
            isInStock = false,
            productName = "Luxury Serum",
            shortDescription = "Premium anti-aging serum",
            boldPoints = "Vitamin C • Hyaluronic Acid • Retinol",
            presentAmount = "Rs. 899",
            strikethroughAmount = "",
            starRating = 3.8f,
            reviewCount = "67 reviews"
        )
    )
}
