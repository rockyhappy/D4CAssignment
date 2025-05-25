package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit12Lh16Fw400
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit14Lh18Fw400
import com.devrachit.dcasignment.utility.compose_utility.sdp

data class FilterChip(
    val id: String,
    val label: String,
    val isSelected: Boolean = false
)

// Stateless component with state hoisting
@Composable
fun SearchFilterWidget(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    filterChips: List<FilterChip>,
    onFilterChipClick: (String) -> Unit,
    onSearchAction: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search products..."
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Search Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(colorResource(id = R.color.white))
                .border(
                    1.dp,
                    Color.Gray.copy(alpha = 0.3f),
                    RoundedCornerShape(24.dp)
                )
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_search_24),
                    contentDescription = "Search",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                BasicTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier.weight(1f),
                    textStyle = TextStyleNeuzeit14Lh18Fw400().copy(
                        color = colorResource(id = R.color.black)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onSearchAction()
                            keyboardController?.hide()
                        }
                    ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyleNeuzeit14Lh18Fw400(),
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                )
                
                if (searchQuery.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                        contentDescription = "Clear",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onSearchQueryChange("") }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Filter Chips
        if (filterChips.isNotEmpty()) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filterChips) { chip ->
                    FilterChipItem(
                        chip = chip,
                        onClick = { onFilterChipClick(chip.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun FilterChipItem(
    chip: FilterChip,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (chip.isSelected) {
                    colorResource(id = R.color.primary_color)
                } else {
                    Color.White
                }
            )
            .border(
                1.dp,
                if (chip.isSelected) {
                    colorResource(id = R.color.primary_color)
                } else {
                    Color.Gray.copy(alpha = 0.3f)
                },
                RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = chip.label,
            style = TextStyleNeuzeit12Lh16Fw400(),
            color = if (chip.isSelected) {
                Color.White
            } else {
                colorResource(id = R.color.black)
            }
        )
    }
}

// Stateful wrapper component (optional - for components that need to manage their own state)
@Composable
fun StatefulSearchFilterWidget(
    initialSearchQuery: String = "",
    initialFilters: List<FilterChip> = emptyList(),
    onSearchAction: (String, List<FilterChip>) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search products..."
) {
    var searchQuery by remember { mutableStateOf(initialSearchQuery) }
    var filterChips by remember { mutableStateOf(initialFilters) }
    
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
            onSearchAction(searchQuery, filterChips.filter { it.isSelected })
        },
        modifier = modifier,
        placeholder = placeholder
    )
}

@Preview(showBackground = true)
@Composable
fun SearchFilterWidgetPreview() {
    val sampleFilters = listOf(
        FilterChip("1", "Beauty", false),
        FilterChip("2", "Skincare", true),
        FilterChip("3", "Makeup", false),
        FilterChip("4", "Fragrance", false)
    )
    
    StatefulSearchFilterWidget(
        initialFilters = sampleFilters,
        onSearchAction = { query, filters ->
            // Handle search action
        }
    )
}
