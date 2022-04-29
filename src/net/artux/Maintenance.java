package net.artux;

import com.sun.tools.javac.Main;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Maintenance {
    private Timer mTimer;
    Queue queue;
    int min, max;  //интервал времени обработки заявки
    int maxSize; //макс размер очереди
    int lost; //кол-во потерянных заявок
    boolean busy; //состояние ПО
    int T0; //текущее модельное время
    Random random = new Random();
    public Maintenance(){
        mTimer = new Timer();
        lost = 0;
        busy = false;
        T0 = 0;
        maxSize = 4;
        min = 1;
        max = 50;
        queue = new Queue();
    }
    private Request createNewRequest(){
        int handleTime = random.nextInt(max-min)+min;
        return new Request(random.nextBoolean(), handleTime,T0);
    }
    public void input(){
        Request request = createNewRequest();
        if(!busy){
            System.out.println("Заявка подана на обработку");
            serve(request);

        }
        else{
            if(queue.getSize() < maxSize){
                queue.addRequest(request);
                System.out.println("Заявка добавлена в очередь");
            }
            else{
                System.out.println("Заявка потеряна");
                lost++;
            }
        }
    }
    private void serve(Request request){
        busy = true;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                int T1 = request.getHandleTime();
                System.out.println("Заявка обработана");
                takeRequest();
            }
        };
        mTimer.schedule(tt,200);

    }
    public void takeRequest(){
        Request request = queue.takeRequest();
        if(request == null) {
            busy = false;
            return;
        }
        serve(request);
    }
    public static void main(String[] args) throws InterruptedException {
        Maintenance m = new Maintenance();
        for(int i = 0; i< 19;i++){
            Thread.sleep(100);
            m.input();
        }
    }

}

