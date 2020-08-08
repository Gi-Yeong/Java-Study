package sec06.exam05_wait_notify;

public class DataBox {
    private String data;

    synchronized public String getData() {
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        String returnValue = data;
        System.out.println("ConsumerThread 가 읽은 데이터: " + returnValue);
        data = null;
        notify();

        return returnValue;
    }

    synchronized public void setData(String data) {
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.data = data;
        System.out.println("ProducerThread 가 읽은 데이터: " + data);
        notify();
    }
}
