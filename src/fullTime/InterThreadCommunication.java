package fullTime;

/**
 * Created by Biyanta on 14/11/17.
 */
class Chat {
    boolean flag = false;

    public synchronized void Question(String message) {
        if (flag) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(message);
        flag = true;
        notify();
    }

    public synchronized void Answer(String message) {
        if (!flag) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
        flag = false;
        notify();
    }
}
class T1 implements Runnable {
    Chat chat;
    String[] question = {"Hi!", "How are you?", "I am good too"};

    public T1(Chat ch1) {
       chat = ch1;
       new Thread(this, "Question").start();
    }

    @Override
    public void run() {

        for (int i = 0; i < question.length; i++) {
            chat.Question(question[i]);
        }
    }
}

class T2 implements Runnable {
    Chat chat2;
    String[] answer = {"Hi!", "I am good, How are you?", "That is good to hear !"};

    public T2(Chat ch2) {
        chat2 = ch2;
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {

        for (int i = 0; i < answer.length; i++) {
            chat2.Answer(answer[i]);
        }
    }
}
public class InterThreadCommunication {

    public static void main(String[] args) {
        Chat ch = new Chat();
        new T1(ch);
        new T2(ch);

    }

}
