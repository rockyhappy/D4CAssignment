package com.devrachit.dcasignment.presentation.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devrachit.dcasignment.R
import com.devrachit.dcasignment.ui.theme.TextStyleCentury24Lh36Fw700
import com.devrachit.dcasignment.ui.theme.TextStyleNeuzeit12Lh16Fw400
import com.devrachit.dcasignment.utility.compose_utility.sdp
import com.devrachit.dcasignment.utility.constants.Constants

data class CategoryItem(
    val id: String,
    val name: String,
    val image: Int
)

// Stateless component with state hoisting
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDisplayWidget(
    title: String,
    categories: List<CategoryItem>,
    showAllBottomSheet: Boolean,
    onSeeAllClick: () -> Unit,
    onCategoryClick: (CategoryItem) -> Unit,
    onBottomSheetDismiss: () -> Unit,
    bottomSheetState: SheetState,
    modifier: Modifier = Modifier,
    maxVisibleItems: Int = 10
) {
    Column(modifier = modifier) {
        // Header Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyleCentury24Lh36Fw700(),
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 16.dp),
                color = colorResource(id = R.color.white)
            )
            
            Text(
                text = "See All",
                style = TextStyleNeuzeit12Lh16Fw400().copy(
                    textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
                ),
                modifier = Modifier
                    .padding(end = 16.dp, top = 24.dp, bottom = 16.dp)
                    .clickable { onSeeAllClick() },
                color = colorResource(id = R.color.white)
            )
        }
        
        // Horizontal Category List
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val visibleCategories = categories.take(maxVisibleItems)
            items(visibleCategories.size) { index ->
                CategoryItemHorizontal(
                    category = visibleCategories[index],
                    onClick = { onCategoryClick(visibleCategories[index]) }
                )
            }
        }
        
        // Modal Bottom Sheet
        GenericModalBottomSheet(
            showBottomSheet = showAllBottomSheet,
            onDismissRequest = onBottomSheetDismiss,
            sheetState = bottomSheetState
        ) {
            CategoryBottomSheetContent(
                categories = categories,
                onCategoryClick = { category ->
                    onCategoryClick(category)
                    onBottomSheetDismiss()
                }
            )
        }
    }
}

@Composable
private fun CategoryItemHorizontal(
    category: CategoryItem,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 4.dp)
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = category.name,
            modifier = Modifier
                .padding(10.sdp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.black))
                .size(90.sdp)
                .padding(6.sdp)
        )
        
        Text(
            text = category.name,
            style = TextStyleNeuzeit12Lh16Fw400(),
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun CategoryBottomSheetContent(
    categories: List<CategoryItem>,
    onCategoryClick: (CategoryItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "All Categories",
            style = TextStyleCentury24Lh36Fw700(),
            color = colorResource(id = R.color.white),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            items(categories) { category ->
                CategoryItemGrid(
                    category = category,
                    onClick = { onCategoryClick(category) }
                )
            }
        }
    }
}

@Composable
private fun CategoryItemGrid(
    category: CategoryItem,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = category.name,
            modifier = Modifier
                .clip(CircleShape)
                .background(colorResource(id = R.color.black))
                .size(80.dp)
                .padding(6.dp)
        )
        
        Spacer(modifier = Modifier.padding(4.dp))
        
        Text(
            text = category.name,
            style = TextStyleNeuzeit12Lh16Fw400(),
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

// Converter function to convert Constants.Category to CategoryItem
fun convertToCategories(): List<CategoryItem> {
    return Constants.category.map { category ->
        CategoryItem(
            id = category.name.lowercase().replace(" ", "_"),
            name = category.name,
            image = category.image
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryDisplayWidgetPreview() {
    val sampleCategories = convertToCategories()
    
    // Note: This preview won't show the bottom sheet functionality
    // since we can't provide real state management in preview
    Column {
        Text("Preview - Bottom sheet functionality requires real state")
    }
}
