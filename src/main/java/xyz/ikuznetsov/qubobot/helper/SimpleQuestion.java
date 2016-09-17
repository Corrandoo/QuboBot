package xyz.ikuznetsov.qubobot.helper;

import org.telegram.telegrambots.api.objects.Message;

public class SimpleQuestion {
    // Класс, определяющий признаки простого вопроса в сообщении для передачи его парсеру

    private int score = 0;
    private boolean isQuestion;
    public boolean simpleQuestionDetector(Message message){ // Основной метод. Единственный публичный в классе.
        String text = message.getText().toLowerCase();
        detector(text);
        decider();
        return isQuestion;
    }
    private void detector(String text){ // Метод с основной логикой
        String str[] = text.split(" ");
        if(text.contains("?"))
            score += 3;
        if(text.contains("что") || text.contains("кто")) {
            score += 1;
            if(text.contains("такое") || text.contains("такой") || text.contains("такая"))
                score += 2;
        }
        if(text.contains("определение"))
            score += 2;
        if(text.contains("это")) {
            score += 1;
            if(str.length < 4)
                score += 3;
        }
    }
    private void decider(){ // Метод, решающий, вопрос это или нет по количеству баллов.
        isQuestion = score >= 2;
    }
}
