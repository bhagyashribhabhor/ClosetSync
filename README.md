👗 ClosetSync

Smart Digital Wardrobe & AI Outfit Planner

ClosetSync is an Android application designed to help users organize
their wardrobe digitally, plan outfits, keep track of previously created
outfits, manage clothing-care reminders, maintain a wishlist, and
receive AI-powered styling assistance.

📱 Overview

Choosing what to wear can take time, especially when users have many
clothes but no simple way to organize them.

ClosetSync aims to solve this problem by bringing wardrobe management
and outfit planning into one Android application.

The application is designed to help users

👗 Organize clothing items digitally

🎨 Store clothing details such as category, color, season, and
occasion

👚 Create and save outfit combinations

📖 View previously created outfits

🔔 Schedule clothing-care reminders

❤️ Maintain a clothing wishlist

🤖 Get AI-based fashion and styling assistance

📸 Use camera or gallery images for styling-related features

🎯 Objectives

Create a simple digital wardrobe.

Make daily outfit planning easier.

Allow users to organize clothing information.

Maintain a history of created outfits.

Provide clothing maintenance reminders.

Provide a wishlist for clothing items.

Integrate AI-based styling assistance.

Provide a clean and user-friendly Android experience.

✨ Main Features

🔐 Authentication

Sign Up

Login

Local user information storage for the current prototype

👗 Digital Wardrobe

Users can add clothing information including: - Clothing name -
Category - Color - Season - Occasion

👚 Outfit Planner

Users can create outfit combinations using: - Outfit name - Top -
Bottom - Shoes - Occasion

📖 Outfit History

Provides a place to view previously saved outfit combinations.

🔔 Clothing Maintenance

Users can select a date and time for a clothing-care reminder.

❤️ Wishlist

Users can save clothing items they are interested in buying or adding
later.

🤖 AI Stylist

The AI Stylist is designed to support: - Fashion-related questions -
Outfit suggestions - Styling ideas - Clothing/outfit analysis -
Personalized styling assistance

📸 Camera & Gallery

Users can capture or select outfit images for styling-related
functionality.

🛠️ Technology Stack

Technology

Purpose

Android Studio

Android application development

Kotlin

Application logic

XML

User interface design

ConstraintLayout

Flexible UI layout

Material Components

Modern Android UI components

MaterialCardView

Card-based interface

SharedPreferences

Local key-value storage

JSON

Structured local data

Intent

Activity navigation and Android actions

AlarmManager

Reminder scheduling

BroadcastReceiver

Receiving scheduled events

Notification

Displaying reminders

OkHttp

Planned API/network communication

AI API

Planned AI-powered styling features

🏗️ Application Structure

ClosetSync
│
├── Welcome
├── Authentication
│   ├── Sign Up
│   └── Login
├── Home Dashboard
├── Wardrobe
│   └── Add Clothing
├── Outfit Planner
├── Outfit History
├── Clothing Maintenance
│   └── Reminder
├── Wishlist
└── AI Stylist
    ├── Chat with AI
    ├── Outfit Suggestions
    ├── Styling Ideas
    └── Outfit Photo Analysis

💾 Data Storage

The current prototype uses SharedPreferences for small amounts of
local application data.

Clothing, outfit, and wishlist records can be represented using JSON
so multiple records can be stored in a structured format.

Example:

{
  "name": "White Shirt",
  "category": "Shirt",
  "color": "White",
  "season": "Summer",
  "occasion": "College"
}

For a larger production application, the storage can be migrated to Room
Database, SQLite, Firebase, or another cloud-backed solution.

🔔 Maintenance Reminder Flow

User selects date and time
          ↓
     AlarmManager
          ↓
   BroadcastReceiver
          ↓
      Notification
          ↓
         User

🤖 AI Stylist Flow

User
  ↓
ClosetSync Android App
  ↓
AI API
  ↓
AI Model
  ↓
Generated Response
  ↓
ClosetSync App
  ↓
User

Note: AI integration is part of the ongoing development and should
be considered an in-progress feature until fully implemented and
tested.

🎨 UI Design

ClosetSync follows a simple, clean, card-based design.

Primary: Lavender / Purple

Secondary: Light Pink

Background: Light / White

Layout: ConstraintLayout

Components: MaterialCardView and Material Components

Design Goal: Simple, clean, and easy to navigate

🚧 Development Roadmap

Area

Status

Android project setup

Completed

Basic UI design

Completed / In Progress

Screen navigation

In Progress

Login & Sign Up functionality

In Progress

Wardrobe functionality

In Progress

Add Clothing functionality

In Progress

Outfit Planner functionality

In Progress

Outfit History functionality

In Progress

Wishlist functionality

In Progress

Maintenance Reminder

In Progress

AI Stylist UI

In Progress

Camera / Gallery integration

In Progress

AI API integration

Planned / In Progress

Complete application testing

Planned

Final UI polishing

Planned

Production-ready data storage

Future Scope

🔮 Future Scope

☁️ Cloud synchronization

🗄️ Room Database

🤖 Improved AI personalization

📸 Automatic clothing recognition

🌦️ Weather-based outfit recommendations

🎨 Smart color matching

👗 Advanced outfit recommendations

📊 Clothing usage statistics

🔐 Improved authentication and data security

📅 Calendar-based outfit planning

🎓 Academic Project Purpose

ClosetSync is being developed as an Android application project to
demonstrate practical knowledge of:

Android application development

Kotlin programming

XML UI design

Activity and Intent navigation

Local data storage

JSON data handling

Android notifications

Alarm scheduling

Camera and gallery integration

API communication

AI-assisted application development

👩‍💻 Developer

Bhagyashri Bhabhor
Information Technology Student

🔗 GitHub Repository

ClosetSync: https://github.com/bhagyashribhabhor/ClosetSync
