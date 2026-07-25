# Full-Stack E-Commerce Web Application

A modern, full-stack e-commerce web application built with Spring Boot 3, React 18, TypeScript, and Redux Toolkit.

## 🛠️ Tech Stack

### Backend
* **Java 21** & **Spring Boot 3.2.3**
* **Spring Data JPA** (MySQL Database)
* **Spring Data Redis** (Basket & Caching)
* **Spring Security & JWT** (Authentication)
* **SpringDoc OpenAPI / Swagger UI**

### Frontend
* **React 18** + **TypeScript** (Vite)
* **Redux Toolkit** (Global State Management)
* **Material UI (MUI)** (Styling & Design)
* **React Hook Form + Yup** (Validation)

---

## 🚀 Getting Started Locally

### 1. Database & Cache (Docker)
```bash
docker-compose -f docker/docker-compose.yml up -d
```

### 2. Backend Server
```bash
./mvnw spring-boot:run
```
* Backend API: `http://localhost:8081`
* Swagger UI: `http://localhost:8081/swagger-ui.html`

### 3. Frontend Client
```bash
cd client
npm install
npm run dev
```

---

## 📄 License
This project is open-source and free to use.