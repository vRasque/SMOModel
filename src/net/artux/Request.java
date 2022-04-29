package net.artux;

public class Request {
    private boolean isHighPrior;
    private int handleTime; //время обработки
    private int arriveTime; //время поступления
    Request(boolean isHighPrior,int handleTime, int arriveTime){
        this.isHighPrior = isHighPrior;
        this.handleTime = handleTime;
        this.arriveTime = arriveTime;
    }

    public boolean isHighPrior() {
        return isHighPrior;
    }

    public int getHandleTime() {
        return handleTime;
    }
    public int getArriveTime() {
        return arriveTime;
    }
}
