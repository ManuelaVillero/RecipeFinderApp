Recipe Finder App 🍽️

Android Recipe Finder application built using Jetpack Compose, MVVM, Retrofit, and Room Database.

Features
Search recipes from online API
View recipe details
Scrollable instructions
Add recipes to favorites
View saved favorites
Local persistence using Room database
Clean MVVM architecture
Jetpack Compose UI
Navigation between screens
Screens
Search Screen
Recipe Details Screen
Favorites Screen
Tech Stack
Kotlin
Jetpack Compose
MVVM Architecture
Retrofit (API calls)
Room Database (Local storage)
Navigation Component
StateFlow / ViewModel
API Used

The app uses TheMealDB API:

https://www.themealdb.com/api.php

Example endpoint:
https://www.themealdb.com/api/json/v1/1/search.php?s=chicken

How It Works
User searches for a recipe
App calls API using Retrofit
Results displayed in Compose UI
User selects recipe
Details screen shows instructions
User adds recipe to favorites
Favorites stored locally using Room
Favorites screen displays saved recipes
Architecture

MVVM Pattern:

UI (Compose Screens)
↓
ViewModel (State Management)
↓
Repository (Data Handling)
↓
Retrofit API + Room Database

Project Structure
data/
network/
viewmodel/
navigation/
screens/
ui.theme/
Demo Video

YouTube Demo:
(Add your YouTube link here)

Author

Manuela Villero
Mobile App Development - Android Project
