package lab1.io;

public class Question<T> {
    private final Askable<T> askable;
    private T answer;

    public Question(String msg, Askable<T> askable) {
        this.askable = askable;
        while (true) {
            try {
                System.out.print(msg + " ");
                T ans = this.askable.ask();
                answer = ans;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public T getAnswer() {
        return answer;
    }
}