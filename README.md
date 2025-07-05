
````markdown
# 🧑‍🎓 Student REST API with AI Summary (Java + Spring Boot + Ollama)

A simple REST API built with **Java Spring Boot** that performs **CRUD operations** on student profiles and integrates with **Ollama AI** to generate summaries based on student data (Name, Age, Email).

---

## ✨ Features

- ✅ Create, Read, Update, and Delete students
- 🧠 Generate AI-based summary for a student using Ollama
- 💾 In-memory storage (no database)
- 🛡️ Input validation
- 🚀 Concurrent-safe operations

---

## 🧑‍💻 Tech Stack

- Java 17+
- Spring Boot
- Ollama (local AI inference)
- HTTP Client (Java 11+ built-in)
- ConcurrentHashMap for thread-safe storage

---

## 🚀 How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/student-ai-api.git
cd student-ai-api
````

### 2. Build & Run the Spring Boot App

```bash
./mvnw spring-boot:run
# or if using installed Maven
mvn spring-boot:run
```

By default, it runs on: `http://localhost:8080`

---

## 🤖 Setting up Ollama (for AI summary)

1. **Install Ollama**

Follow the instructions at: [https://ollama.com/download](https://ollama.com/download)

2. **Pull a lightweight model**

Since we only need basic summarization:

```bash
ollama pull mistral
# or for lighter LLaMA3 version:
ollama pull llama3:8b-q4_K_M
```

3. **Run the model**

```bash
ollama run mistral
# or
ollama run llama3:8b-q4_K_M
```

Ollama will now listen on: `http://localhost:11434`

---

## 📦 API Endpoints

| Method | Endpoint                 | Description                      |
| ------ | ------------------------ | -------------------------------- |
| POST   | `/students`              | Create a new student             |
| GET    | `/students`              | Get all students                 |
| GET    | `/students/{id}`         | Get student by ID                |
| PUT    | `/students/{id}`         | Update student by ID             |
| DELETE | `/students/{id}`         | Delete student by ID             |
| GET    | `/students/{id}/summary` | Generate AI summary of a student |

---

## 📬 Sample API Calls

### ▶️ Create Student

```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"name": "Omkar", "age": 21, "email": "om@example.com"}'
```

### 📄 Get Summary

```bash
curl http://localhost:8080/students/1/summary
```

---

## 🧠 Example AI Summary Output

```text
Omkar is a 21-year-old student. You can contact him at om@example.com.
```

---

## 🛠 Project Structure

```
student-api/
├── controller/
│   └── StudentController.java
├── model/
│   └── Student.java
├── service/
│   └── StudentService.java
└── StudentApiApplication.java
```

---

## 📑 License

This project is open source and available under the [MIT License](LICENSE).

---

## 🙋‍♂️ Author

**Omkar Gadam**
🚀 Java & Spring Boot Enthusiast
🌐 [LinkedIn](https://www.linkedin.com/in/your-profile)

```

---

Let me know if you’d like me to add:
- `LICENSE` file
- Sample `application.properties`
- Postman collection
- A badge section (for GitHub stars/forks/etc.)
```
