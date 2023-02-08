package lab1.io;

import java.util.NoSuchElementException;

import lab1.app.App;

public class Question<T> {
    private final Askable<T> askable;
    private T answer;
    private String msg;

    public Question(Askable<T> askable) {
        this.askable = askable;
        run();
    }
    void run(){
        while (true) {
            try {
                if(msg!=null) System.out.print(msg + "");
                T ans = this.askable.ask();
                answer = ans;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("\n Ввод закончен");
                App.getInstanse().exit();

            }
        }
    }
    public Question(String msg, Askable<T> askable) {
        this.askable = askable;
        this.msg = msg;
        run();
    }

    public T getAnswer() {
        return answer;
    }
}