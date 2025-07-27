# Options Profit Calculator & Learning App (Android)

A Prototype, simple and functional Android app that allows users to register, calculate returns for Options trading, and learn core financial derivatives concepts.

This Android application is designed to help users calculate potential returns from options trading and understand the basics of financial derivatives. It provides a simple, educational interface combined with real-time market data and Firebase integration for user management.

## Features

### 🔐 User Authentication
- Firebase Authentication for secure user registration and login.
- Stores user profile data (name, age, birth date, etc.) using Firebase Realtime Database.

### 📈 Options Return Calculator
- Supports **Call Buy (CB)** and **Put Buy (PB)** strategies.
- Takes input for:
  - Strike Price
  - Expiry
  - Premium
  - Lot Size
- Fetches **real-time spot prices** using a market data API.
- Calculates potential profit/loss and displays whether the trade scenario is profitable.

### 📚 Derivatives Education Module
Interactive content to teach:
- What are Derivatives?
- What are Futures?
- What are Options?
- Call vs Put Options

## Tech Stack

- **Java** (Android)
- **Firebase**
  - Authentication
  - Realtime Database
- **OkHttp** – REST API integration
- **Android SDK** – Material UI components
- **XML** – UI Layouts

### Prerequisites

- Android Studio (latest version)
- Firebase Project (setup required)
- Internet connection for API access
