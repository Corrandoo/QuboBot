package xyz.ikuznetsov.qubobot.helper;

import org.telegram.telegrambots.api.objects.Message;

public class SimpleQuestion {
    private int score = 0;
    private boolean isQuestion;
    public boolean simpleQuestionDetector(Message message){
        String text = message.getText().toLowerCase();
        detector(text);
        decider();
        return isQuestion;
    }
    private void detector(String text){
        if(text.contains("?"))
            score += 3;
        if(text.contains("что") || text.contains("кто")) {
            score += 1;
            if(text.contains("такое") || text.contains("такой") || text.contains("такая"))
                score += 2;
        }
        if(text.contains("определение"))
            score += 2;
        if(text.contains("это"))
            score += 1;

    }
    private void decider(){
        if(score >= 4)
            isQuestion = true;
        else
            isQuestion = false;
    }
}
