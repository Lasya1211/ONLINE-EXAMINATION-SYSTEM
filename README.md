# Online Examination System

A full-stack *Online Examination System* built with *Java Spring Boot* and responsive *HTML, CSS, and JavaScript*. Designed for seamless browser and mobile access, it features a live countdown timer, secure backend grading, and instant result generation.

## Features
- *Student Login:* Clean entry screen requiring student full name before starting the exam.
- *Live Countdown Timer:* Automated 5-minute countdown timer with automatic submission when time expires.
- *Secure Backend Evaluation:* Answer keys are stored strictly on the Java server so answers cannot be viewed in browser source code.
- *Instant Results:* Immediate score calculation and PASS / FAIL status display upon submission.
- *Mobile-Responsive UI:* Works smoothly on both desktop browsers and mobile devices.

## Tech Stack
- *Backend:* Java, Spring Boot (Spring Web / Embedded Apache Tomcat)
- *Frontend:* HTML5, CSS3, Vanilla JavaScript (Fetch API)
- *Build Tool:* Apache Maven

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | /api/questions | Fetches the list of multiple-choice questions without exposing correct answers. |
| POST | /api/submit | Evaluates submitted answers on the server and returns the student's score and pass/fail status. |

## How to Run Locally
1. Clone the repository:
   bash
   git clone https://github.com
   
2. Open the project in *VS Code* (with Extension Pack for Java) or *IntelliJ IDEA*.
3. Run OnlineExamApplication.java.
4. Open a browser and visit http://localhost:8080.
