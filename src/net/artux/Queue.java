package net.artux;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Request> requests = new ArrayList<>();
    public void addRequest(Request request){
        requests.add(request);
    }
    public Request takeRequest() {
        return getHighestPrior();
    }
    private Request getHighestPrior(){
        if(requests == null || requests.size() == 0) return null;
        Request req;
        for(int i = requests.size()-1;i>=0;i--){
            if(requests.get(i).isHighPrior()){
                req = requests.get(i);
                requests.remove(i);
                return req;
            }
        }
        req = requests.get(0);
        requests.remove(0);
        return req;
    }
    public int getSize(){
        return requests.size();
    }
}

