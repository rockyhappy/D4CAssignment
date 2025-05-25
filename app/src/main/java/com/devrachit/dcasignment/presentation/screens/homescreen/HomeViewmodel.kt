package com.devrachit.dcasignment.presentation.screens.homescreen

import androidx.lifecycle.ViewModel
import com.devrachit.dcasignment.utility.constants.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for HomeScreen that manages all UI state and business logic
 * Handles product list management, wishlist/cart operations, and search functionality
 */
class HomeViewmodel: ViewModel() {

    // Private mutable state flow for internal state management
    private val _uiStates = MutableStateFlow<HomeScreenStates>(HomeScreenStates())
    
    // Public read-only state flow exposed to UI
    val uiStates : StateFlow<HomeScreenStates> = _uiStates.asStateFlow()
    
    init {
        loadInitialData()
    }

    /**
     * Loads initial product data from Constants and sets up initial state
     * Called during ViewModel initialization
     */
    fun loadInitialData() {
        _uiStates.value = _uiStates.value.copy(
            productList = Constants.productList,
            wishlistCount = Constants.productList.count { it.isWishlisted },
            cartCount = Constants.productList.count { it.isInCart }
        )
    }

    /**
     * Toggles wishlist status for a specific product
     * Updates both main product list and filtered list if in wishlist view
     * @param productName Name of the product to toggle wishlist status
     */
    fun addToWishlist(productName: String) {
        val updatedProducts = _uiStates.value.productList?.map { product ->
            if (product.productName == productName) {
                product.copy(isWishlisted = !product.isWishlisted)
            } else {
                product
            }
        }

        val newWishlistCount = updatedProducts?.count { it.isWishlisted } ?: 0

        _uiStates.value = _uiStates.value.copy(
            productList = updatedProducts,
            wishlistCount = newWishlistCount
        )

        // Update filtered list if currently viewing wishlist
        if (_uiStates.value.isWishlistView) {
            val filteredList = updatedProducts?.filter { it.isWishlisted }
            _uiStates.value = _uiStates.value.copy(
                filteredProductList = filteredList
            )
        }
    }

    /**
     * Toggles cart status for a specific product
     * Updates both main product list and filtered list if in cart view
     * @param productName Name of the product to toggle cart status
     */
    fun addToCart(productName: String) {
        val updatedProducts = _uiStates.value.productList?.map { product ->
            if (product.productName == productName) {
                product.copy(isInCart = !product.isInCart)
            } else {
                product
            }
        }

        val newCartCount = updatedProducts?.count { it.isInCart } ?: 0

        _uiStates.value = _uiStates.value.copy(
            productList = updatedProducts,
            cartCount = newCartCount
        )

        // Update filtered list if currently viewing cart
        if (_uiStates.value.isCartView) {
            val filteredList = updatedProducts?.filter { it.isInCart }
            _uiStates.value = _uiStates.value.copy(
                filteredProductList = filteredList
            )
        }
    }

    /**
     * Shows wishlist view with filtered products or toggles back to home view
     * Implements toggle behavior - second click returns to home
     */
    fun showWishlist() {
        val currentState = _uiStates.value
        
        if (currentState.isWishlistView) {
            // Toggle back to home view
            showHomeView()
        } else {
            // Show wishlist view with filtered products
            val currentList = currentState.productList
            val filteredList = currentList?.filter { it.isWishlisted }
            _uiStates.value = currentState.copy(
                filteredProductList = filteredList,
                isWishlistView = true,
                isCartView = false,
                isSearchView = false
            )
        }
    }

    /**
     * Shows cart view with filtered products or toggles back to home view
     * Implements toggle behavior - second click returns to home
     */
    fun showCart() {
        val currentState = _uiStates.value
        
        if (currentState.isCartView) {
            // Toggle back to home view
            showHomeView()
        } else {
            // Show cart view with filtered products
            val currentList = currentState.productList
            val filteredList = currentList?.filter { it.isInCart }
            _uiStates.value = currentState.copy(
                filteredProductList = filteredList,
                isWishlistView = false,
                isCartView = true,
                isSearchView = false
            )
        }
    }

    /**
     * Performs search operation based on query and selected filter chips
     * Filters products by name, description, and bold points
     * @param query Search query string
     * @param selectedChipIds List of selected filter chip IDs
     */
    fun performSearch(query: String, selectedChipIds: List<String>) {
        val currentState = _uiStates.value
        val currentList = currentState.productList ?: return
        
        // If no search query and no filters, return to home view
        if (query.isBlank() && selectedChipIds.isEmpty()) {
            showHomeView()
            return
        }
        
        var filteredList = currentList
        
        // Apply text search filter if query is not empty
        if (query.isNotBlank()) {
            filteredList = filteredList.filter { product ->
                product.productName.contains(query, ignoreCase = true) ||
                product.shortDescription.contains(query, ignoreCase = true) ||
                product.boldPoints.contains(query, ignoreCase = true)
            }
        }
        
        // Apply category filters based on selected chips
        if (selectedChipIds.isNotEmpty()) {
            filteredList = filteredList.filter { product ->
                selectedChipIds.any { chipId ->
                    when (chipId) {
                        "1" -> product.boldPoints.contains("Beauty", ignoreCase = true) || 
                               product.productName.contains("Beauty", ignoreCase = true)
                        "2" -> product.boldPoints.contains("Skincare", ignoreCase = true) || 
                               product.productName.contains("Skincare", ignoreCase = true) ||
                               product.productName.contains("Cream", ignoreCase = true) ||
                               product.productName.contains("Serum", ignoreCase = true)
                        "3" -> product.boldPoints.contains("Makeup", ignoreCase = true) || 
                               product.productName.contains("Makeup", ignoreCase = true)
                        "4" -> product.boldPoints.contains("Fragrance", ignoreCase = true) || 
                               product.productName.contains("Fragrance", ignoreCase = true)
                        "5" -> product.boldPoints.contains("Hair", ignoreCase = true) || 
                               product.productName.contains("Hair", ignoreCase = true)
                        "6" -> product.boldPoints.contains("Body", ignoreCase = true) || 
                               product.productName.contains("Body", ignoreCase = true)
                        "7" -> product.boldPoints.contains("Anti-aging", ignoreCase = true) || 
                               product.productName.contains("Anti-aging", ignoreCase = true)
                        "8" -> product.boldPoints.contains("Moisturiz", ignoreCase = true) || 
                               product.productName.contains("Moisturiz", ignoreCase = true)
                        else -> false
                    }
                }
            }
        }
        
        // Update state with search results
        _uiStates.value = currentState.copy(
            filteredProductList = filteredList,
            isWishlistView = false,
            isCartView = false,
            isSearchView = true
        )
    }

    /**
     * Returns to normal home view
     * Resets all view flags and clears filtered lists
     */
    fun showHomeView() {
        _uiStates.value = _uiStates.value.copy(
            filteredProductList = null,
            isWishlistView = false,
            isCartView = false,
            isSearchView = false
        )
    }
}
