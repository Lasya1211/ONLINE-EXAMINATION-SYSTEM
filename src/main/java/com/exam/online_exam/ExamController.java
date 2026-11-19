package com.exam.online_exam;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExamController {

    public static class Question {
        public int id;
        public String question;
        public List<String> options;
        public int correctOption;

        public Question(int id, String question, List<String> options, int correctOption) {
            this.id = id;
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    private static final List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question(1, "Which keyword is used to inherit a class in Java?",
                Arrays.asList("implement", "extends", "inherits", "super"), 1));
        questions.add(new Question(2, "What is the size of an int variable in Java?",
                Arrays.asList("2 bytes", "4 bytes", "8 bytes", "1 byte"), 1));
        questions.add(new Question(3, "Which method is the entry point of a Java program?",
                Arrays.asList("start()", "init()", "main()", "run()"), 2));
        questions.add(new Question(4, "Which of these is NOT a Java feature?",
                Arrays.asList("Object-oriented", "Use of pointers", "Portable", "Dynamic"), 1));
        questions.add(new Question(5, "Which collection class allows duplicate elements?",
                Arrays.asList("HashSet", "TreeSet", "ArrayList", "HashMap"), 2));
    }

    @GetMapping("/questions")
    public List<Map<String, Object>> getQuestions() {
        List<Map<String, Object>> response = new ArrayList<>();
        for (Question q : questions) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", q.id);
            map.put("question", q.question);
            map.put("options", q.options);
            response.add(map);
        }
        return response;
    }

    @PostMapping("/submit")
    public Map<String, Object> submitExam(@RequestBody Map<String, Object> payload) {
        String studentName = (String) payload.get("studentName");
        Map<String, Integer> answers = (Map<String, Integer>) payload.get("answers");

        int score = 0;
        for (Question q : questions) {
            String qId = String.valueOf(q.id);
            if (answers != null && answers.containsKey(qId)) {
                if (answers.get(qId) == q.correctOption) {
                    score++;
                }
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("studentName", studentName);
        result.put("score", score);
        result.put("total", questions.size());
        result.put("status", score >= 3 ? "PASS" : "FAIL");
        return result;
    }
}