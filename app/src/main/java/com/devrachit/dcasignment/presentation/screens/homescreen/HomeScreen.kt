package com.devrachit.dcasignment.presentation.screens.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.presentation.screens.widgets.FilterChip
import com.devrachit.dcasignment.presentation.screens.widgets.SearchFilterWidget
import com.devrachit.dcasignment.presentation.screens.widgets.ShopHeader
import com.devrachit.dcasignment.ui.theme.TextStyleCentury24Lh36Fw700
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit12Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit16Lh20Fw400
import com.devrachit.dcasignment.utility.constants.Constants
import com.devrachit.dcasignment.presentation.screens.widgets.CategoryDisplayWidget
import com.devrachit.dcasignment.presentation.screens.widgets.convertToCategories
import com.devrachit.dcasignment.presentation.screens.widgets.PromoBanner
import com.devrachit.dcasignment.presentation.screens.widgets.ProductCard

/**
 * Main HomeScreen Composable that displays the complete e-commerce interface
 * Supports multiple views: Home, Wishlist, Cart, and Search Results
 * 
 * Features:
 * - Product browsing with wishlist and cart functionality
 * - Search with text query and category filters
 * - Dynamic header with count updates
 * - Responsive UI with animated transitions
 * 
 * @param uiState Current UI state containing all necessary data
 * @param onWishlistClick Callback when user toggles wishlist for a product
 * @param onCartClick Callback when user toggles cart for a product
 * @param onShowWishlist Callback when user clicks wishlist icon in header
 * @param onShowCart Callback when user clicks cart icon in header
 * @param onPerformSearch Callback to execute search with query and filters
 */
@OptIn(ExperimentalMaterial3Api::class)
@Suppress("UNUSED_PARAMETER")
@Composable
fun HomeScreen(
    uiState: HomeScreenStates,
    onWishlistClick: (String) -> Unit,
    onCartClick: (String) -> Unit,
    onShowWishlist: () -> Unit,
    onShowCart: () -> Unit,
    onPerformSearch: (String, List<String>) -> Unit = { _, _ -> }
) {
    // Local state for bottom sheet management
    var showBottomSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()

    // Local state for search functionality
    var showSearchFilter by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var filterChips by remember {
        mutableStateOf(
            Constants.filterChips.map { chipData ->
                FilterChip(
                    id = chipData.id,
                    label = chipData.label,
                    isSelected = false
                )
            }
        )
    }

    // Category state for category display widget
    val categories = remember { convertToCategories() }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = colorResource(id = R.color.white)),
    ) { paddingValues->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .background(colorResource(R.color.bg_neutral))
                .fillMaxSize()
        ) {
            // Header with search, wishlist, and cart icons
            item {
                ShopHeader(
                    searchCount = 0,
                    favoriteCount = uiState.wishlistCount,
                    cartCount = uiState.cartCount,
                    onSearchClick = {
                        showSearchFilter = !showSearchFilter
                    },
                    onFavoriteClick = {
                        onShowWishlist.invoke()
                    },
                    onCartClick = {
                        onShowCart.invoke()
                    }
                )
            }
            
            // Animated search filter widget - only visible in home view
            if (!uiState.isWishlistView && !uiState.isCartView) {
                item {
                    AnimatedVisibility(
                        visible = showSearchFilter,
                        enter = slideInVertically(
                            animationSpec = tween(durationMillis = 500),
                            initialOffsetY = { -it }
                        ) + fadeIn(
                            animationSpec = tween(durationMillis = 500)
                        ),
                        exit = slideOutVertically(
                            animationSpec = tween(durationMillis = 500),
                            targetOffsetY = { -it }
                        ) + fadeOut(
                            animationSpec = tween(durationMillis = 500)
                        )
                    ) {
                        SearchFilterWidget(
                            searchQuery = searchQuery,
                            onSearchQueryChange = { searchQuery = it },
                            filterChips = filterChips,
                            onFilterChipClick = { chipId ->
                                filterChips = filterChips.map { chip ->
                                    if (chip.id == chipId) {
                                        chip.copy(isSelected = !chip.isSelected)
                                    } else {
                                        chip
                                    }
                                }
                            },
                            onSearchAction = {
                                // Perform search with current query and selected filters
                                val selectedChipIds = filterChips
                                    .filter { it.isSelected }
                                    .map { it.id }
                                
                                onPerformSearch(searchQuery, selectedChipIds)
                                showSearchFilter = false // Hide search widget after search
                            },
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
            
            // Promotional banner - only shown in home view
            if (!uiState.isWishlistView && !uiState.isCartView && !uiState.isSearchView) {
                item {
                    PromoBanner()
                }
            }

            // Category display widget - only shown in home view
            if (!uiState.isWishlistView && !uiState.isCartView && !uiState.isSearchView) {
                item {
                    CategoryDisplayWidget(
                        title = "Categories",
                        categories = categories,
                        showAllBottomSheet = showBottomSheet,
                        onSeeAllClick = { showBottomSheet = true },
                        onCategoryClick = { category ->
                            // Handle category selection (can be extended for category filtering)
                        },
                        onBottomSheetDismiss = { showBottomSheet = false },
                        bottomSheetState = bottomSheetState
                    )
                }
            }
            
            // Dynamic section header based on current view
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when {
                            uiState.isWishlistView -> "Wishlist"
                            uiState.isCartView -> "Cart"
                            uiState.isSearchView -> "Search Results"
                            else -> "New Products"
                        },
                        style = TextStyleCentury24Lh36Fw700(),
                        modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 16.dp),
                        color = colorResource(id = R.color.white)
                    )

                    // "See All" button only visible in normal home view
                    if (!uiState.isWishlistView && !uiState.isCartView && !uiState.isSearchView) {
                        Text(
                            text = "See All",
                            style = TextStyleNeuzeit12Lh16Fw400().copy(
                                textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
                            ),
                            modifier = Modifier
                                .padding(end = 16.dp, top = 24.dp, bottom = 16.dp)
                                .clickable { 
                                    // Handle "See All" click - can navigate to full product list
                                },
                            color = colorResource(id = R.color.white)
                        )
                    }
                }
            }

            // Product list rendering based on current view state
            val displayProductList = when {
                uiState.isWishlistView || uiState.isCartView || uiState.isSearchView -> uiState.filteredProductList
                else -> uiState.productList
            }
            
            displayProductList?.let { productList ->
                if (productList.isEmpty()) {
                    // Empty state display with appropriate messages
                    item {
                        Text(
                            text = when {
                                uiState.isWishlistView -> "No items in wishlist\nAdd products to your wishlist to see them here"
                                uiState.isCartView -> "No items in cart\nAdd products to your cart to see them here"
                                uiState.isSearchView -> "No products found\nTry adjusting your search criteria"
                                else -> "No products available"
                            },
                            style = TextStyleNeuzeit16Lh20Fw400(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white)
                        )
                    }
                } else {
                    // Product cards rendering
                    items(
                        count = productList.size
                    ) { index ->
                        val product = productList[index]
                        ProductCard(
                            productData = product,
                            onWishlistClick = {
                                onWishlistClick(product.productName)
                            },
                            onCartClick = {
                                onCartClick(product.productName)
                            },
                            onProductClick = {
                                // Handle product click - can navigate to product details
                            },
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
