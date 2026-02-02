# 🔮 Cosmic Astrology – AI Powered Web Application

Cosmic Astrology is a **full-stack AI-powered astrology web application** built using **Spring AI and Google Gemini**.  
It generates personalized astrological insights based on a user’s **birth details and questions**, presented in a clean, professional UI.

---

## 🌟 Features

- AI-generated astrology responses using **Google Gemini**
- **Spring AI PromptTemplate** for structured prompts
- Two-panel professional UI
  - Left: User input form
  - Right: AI-generated formatted answer
- Animated **processing / loading indicator**
- Properly formatted output:
  - Headings
  - Sub-headings
  - Bold key points
  - Bullet points
- Responsive dark-themed UI
- Easily customizable prompts and styling

---

## 🧠 Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring AI
- Google AI Studio (Gemini API)

### Frontend
- HTML5
- CSS3
- Bootstrap 5
- jQuery
- JavaScript

---

## 🏗️ Architecture Overview

Frontend (HTML + Bootstrap)
|
| REST API (JSON)
↓
Spring Boot Controller
|
Spring AI PromptTemplate
|
Google Gemini (AI Studio)
|
Formatted Astrology Response


---

## 📥 Input Parameters

- Date of Birth
- Time of Birth
- Place of Birth
- User Question

---

## 📤 Output

- Structured astrological insights
- Professionally formatted text including:
  - Major headings
  - Section sub-headings
  - Highlighted key points
  - Bullet lists
- Displayed dynamically on the right panel of the UI

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Smriti-1/CosmicAstro-SpringAI.git
cd CosmicAstro-SpringAI
2️⃣ Backend Configuration
Add your Google AI Studio API key in application.yml:

spring:
  ai:
    google:
      genai:
        api-key: YOUR_GOOGLE_API_KEY
        model: gemini-1.5-flash
Run the backend:

mvn spring-boot:run
Backend URL:

http://localhost:8080
3️⃣ Frontend Setup
Open index.html directly in a browser
OR

Use Live Server / Nginx

Frontend API call:

POST http://localhost:8080/api/astrology/ask
🧪 Sample API Request
{
  "dateOfBirth": "12-11-2001",
  "timeOfBirth": "10:30 AM",
  "placeOfBirth": "Delhi, India",
  "question": "Will my career improve this year?"
}


