# 🛍️ DC Assignment - E-Commerce Android App

![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-blue.svg)
![UI](https://img.shields.io/badge/UI-Jetpack%20Compose-orange.svg)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-red.svg)
![Status](https://img.shields.io/badge/Status-Complete-success.svg)

A modern, feature-rich e-commerce Android application built with **Jetpack Compose** and **MVVM
Architecture**. This project demonstrates professional Android development practices, clean code
principles, and comprehensive state management.

---

## 📱 Application Overview

This e-commerce application provides a complete shopping experience with intuitive product browsing,
advanced search functionality, wishlist management, and shopping cart operations. Built as an
internship assignment to showcase modern Android development skills.

### 🎯 Key Features

- ✅ **Product Browsing** - Beautiful product cards with detailed information
- ✅ **Wishlist Management** - Add/remove products with real-time updates
- ✅ **Shopping Cart** - Complete cart functionality with item management
- ✅ **Advanced Search** - Text-based search with category filters
- ✅ **Multiple View States** - Home, Wishlist, Cart, and Search views
- ✅ **Responsive UI** - Smooth animations and transitions
- ✅ **State Management** - Professional MVVM implementation
- ✅ **Clean Architecture** - Separation of concerns and maintainable code

---

## 🎥 Video Demonstration

> **Add your video demonstration here**

[![Video Demo](https://img.shields.io/badge/📹-Watch%20Demo-red.svg?style=for-the-badge)](your-video-link-here)

---

## 📸 Screenshots

> **Add your app screenshots here**

| Home Screen | Wishlist View | Cart View | Search Results |
|-------------|---------------|-----------|----------------|
| ![Home](screenshots/home.png) | ![Wishlist](screenshots/wishlist.png) | ![Cart](screenshots/cart.png) | ![Search](screenshots/search.png) |

---

## 🏗️ Project Architecture

### **MVVM (Model-View-ViewModel) Pattern**

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│      View       │◄──►│   ViewModel     │◄──►│     Model       │
│  (Composables)  │    │ (State & Logic) │    │ (Data Classes)  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

### **Key Components:**

- **View Layer**: Jetpack Compose UI components
- **ViewModel Layer**: State management and business logic
- **Model Layer**: Data classes and constants
- **Navigation**: Type-safe navigation with Hilt integration

---

## 📁 Folder Structure

```
app/
├── src/main/java/com/devrachit/dcasignment/
│   ├── presentation/
│   │   ├── screens/
│   │   │   ├── homescreen/
│   │   │   │   ├── HomeScreen.kt           # Main screen composable
│   │   │   │   ├── HomeScreenStates.kt     # UI state data class
│   │   │   │   └── HomeViewmodel.kt        # ViewModel with business logic
│   │   │   └── widgets/
│   │   │       ├── ProductCard.kt          # Product display component
│   │   │       ├── SearchFilterWidget.kt   # Search functionality
│   │   │       ├── ShopHeader.kt          # Header with counts
│   │   │       ├── CategoryDisplayWidget.kt # Category browsing
│   │   │       └── PromoBanner.kt         # Promotional content
│   │   └── navigation/
│   │       ├── NavHost.kt                 # Navigation setup
│   │       └── Screen.kt                  # Route definitions
│   ├── ui/theme/
│   │   ├── Color.kt                       # App color palette
│   │   ├── Theme.kt                       # Material theme setup
│   │   └── TextStyles.kt                  # Typography definitions
│   ├── utility/
│   │   ├── constants/
│   │   │   └── Constants.kt               # App constants and sample data
│   │   └── compose_utility/
│   │       └── Extensions.kt              # Compose extensions
│   └── MainActivity.kt                    # Entry point
└── res/
    ├── drawable/                          # App icons and images
    ├── values/
    │   ├── colors.xml                     # Color resources
    │   └── strings.xml                    # String resources
    └── ...
```

---

## 🔧 Technical Implementation

### **State Management**

```kotlin
// HomeScreenStates.kt - Complete UI state representation
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
```

### **ViewModel Pattern**

```kotlin
// HomeViewmodel.kt - Professional state management
class HomeViewmodel: ViewModel() {
    private val _uiStates = MutableStateFlow<HomeScreenStates>(HomeScreenStates())
    val uiStates: StateFlow<HomeScreenStates> = _uiStates.asStateFlow()
    
    // Business logic methods
    fun addToWishlist(productName: String) { /* Implementation */ }
    fun addToCart(productName: String) { /* Implementation */ }
    fun performSearch(query: String, filters: List<String>) { /* Implementation */ }
}
```

### **Reactive UI Updates**

```kotlin
// HomeScreen.kt - State-driven UI
@Composable
fun HomeScreen(
    uiState: HomeScreenStates,
    onWishlistClick: (String) -> Unit,
    onCartClick: (String) -> Unit,
    // ... other callbacks
) {
    // UI automatically updates when state changes
    val displayProductList = when {
        uiState.isWishlistView || uiState.isCartView || uiState.isSearchView -> 
            uiState.filteredProductList
        else -> uiState.productList
    }
}
```

---

## ⚡ Features Deep Dive

### **🔍 Advanced Search System**

- **Text Search**: Search across product names, descriptions, and features
- **Category Filtering**: Filter by Beauty, Skincare, Makeup, etc.
- **Combined Search**: Text + category filters simultaneously
- **Real-time Results**: Instant search results with smooth transitions

### **❤️ Wishlist Management**

- **Toggle Functionality**: One-click add/remove from wishlist
- **Visual Feedback**: Heart icon changes color when wishlisted
- **Count Updates**: Header displays current wishlist count
- **Dedicated View**: Separate screen for wishlist items

### **🛒 Shopping Cart Operations**

- **Add/Remove Items**: Seamless cart management
- **Visual States**: Cart icon reflects current state
- **Count Display**: Real-time cart count in header
- **Cart View**: Dedicated screen for cart items

### **🎨 Modern UI/UX**

- **Material Design 3**: Latest design principles
- **Smooth Animations**: Slide transitions and fade effects
- **Responsive Layout**: Adapts to different screen sizes
- **Interactive Elements**: Clickable icons with visual feedback

---

## 🛠️ Technology Stack

| Category | Technology |
|----------|------------|
| **Language** | Kotlin |
| **UI Framework** | Jetpack Compose |
| **Architecture** | MVVM Pattern |
| **State Management** | StateFlow & Compose State |
| **Dependency Injection** | Hilt |
| **Navigation** | Compose Navigation |
| **Async Operations** | Coroutines |
| **UI Testing** | Compose Testing |

---

## 📋 Development Highlights

### **Clean Code Principles**

- ✅ **Comprehensive Documentation** - Detailed KDoc comments
- ✅ **Separation of Concerns** - Clear architectural boundaries
- ✅ **Single Responsibility** - Each class has one purpose
- ✅ **DRY Principle** - No code duplication
- ✅ **Consistent Naming** - Clear and descriptive names

### **Performance Optimizations**

- ✅ **Efficient State Updates** - Minimal recompositions
- ✅ **Lazy Loading** - LazyColumn for large lists
- ✅ **Memory Management** - Proper lifecycle handling
- ✅ **Smooth Animations** - 60fps user experience

### **Error Handling**

- ✅ **Null Safety** - Comprehensive null checks
- ✅ **Empty States** - Proper empty list handling
- ✅ **Edge Cases** - Search with no results
- ✅ **User Feedback** - Clear error messages

---

## 🚀 Getting Started

### **Prerequisites**

- Android Studio Arctic Fox or later
- Kotlin 1.8+
- Android SDK 24+
- Gradle 7.0+

### **Installation**

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/dc-assignment.git
   cd dc-assignment
   ```

2. **Open in Android Studio**
    - File → Open → Select project folder
    - Wait for Gradle sync to complete

3. **Run the application**
    - Select device/emulator
    - Click Run button or press `Ctrl + R`

---

## 🧪 Testing

### **Manual Testing Scenarios**

- ✅ Product browsing and interaction
- ✅ Wishlist add/remove functionality
- ✅ Cart operations and state persistence
- ✅ Search with various queries and filters
- ✅ View transitions and animations
- ✅ Empty state handling

### **UI Testing** (Future Enhancement)

```kotlin
// Example test case
@Test
fun testWishlistFunctionality() {
    // Test wishlist operations
}
```

---

## 🎯 Future Enhancements

### **Planned Features**

- 🔄 **Product Details Screen** - Detailed product information
- 🔄 **User Authentication** - Login and registration
- 🔄 **Order Management** - Checkout and order history
- 🔄 **Push Notifications** - Deal alerts and updates
- 🔄 **Offline Support** - Local data caching
- 🔄 **Social Sharing** - Share products on social media

### **Technical Improvements**

- 🔄 **Unit Testing** - Comprehensive test coverage
- 🔄 **Integration Testing** - End-to-end testing
- 🔄 **Performance Monitoring** - Analytics integration
- 🔄 **Accessibility** - Screen reader support
- 🔄 **Internationalization** - Multi-language support

---

## 👨‍💻 Developer Information

**Project Type**: Internship Assignment

**Development Time**: 8 Hours

**Developer**: Rachit Katiyar

**Contact**: rachitkatiyar869@gmail.com

**LinkedIn**: https://www.linkedin.com/in/rachit-katiyar-800378275/

---

## 📄 License

This project is developed as an internship assignment. All rights reserved.

---

## 🙏 Acknowledgments

- **Jetpack Compose Team** - For the amazing UI toolkit
- **Android Developers** - For comprehensive documentation
- **Material Design** - For beautiful design principles
- **Stack Overflow Community** - For problem-solving support

---

<div align="center">

### 🌟 If you found this project helpful, please give it a star! 🌟

**Built with ❤️ using Jetpack Compose**

</div>