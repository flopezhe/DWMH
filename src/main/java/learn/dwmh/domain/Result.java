package learn.dwmh.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private T payload;
    private final List<String> messages = new ArrayList<>();
    private boolean success;

    public T getPayload(){
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void addMessage(String message){
        messages.add(message);
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }
}
