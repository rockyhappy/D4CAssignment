package com.devrachit.dcasignment.presentation.screens.homescreen

import com.devrachit.dcasignment.presentation.screens.widgets.ProductData

/**
 * Data class representing the complete UI state for HomeScreen
 * Contains all necessary state information for proper UI rendering and user interactions
 * 
 * @param isLoading Loading state indicator for async operations
 * @param wishlistCount Current count of items in wishlist for header display
 * @param cartCount Current count of items in cart for header display
 * @param productList Main list of all available products
 * @param filteredProductList Filtered list based on current view (wishlist/cart/search)
 * @param isWishlistView Flag indicating if currently viewing wishlist
 * @param isCartView Flag indicating if currently viewing cart
 * @param isSearchView Flag indicating if currently viewing search results
 */
data class HomeScreenStates(
    val isLoading: Boolean = false,
    val wishlistCount: Int = 0,
    val cartCount: Int = 0,
    val productList: List<ProductData>? = null,
    val filteredProductList: List<ProductData>? = null,
    val isWishlistView: Boolean = false,
    val isCartView: Boolean = false,
    val isSearchView: Boolean = false
)
