import java.util.HashMap;
import java.util.Map;

public class Atm {
    static int count = 0;
    private int cellValue;
    public  int index;
    public  HashMap<Integer, Integer> atmStore = new HashMap<>();

    public Atm (int index) {
        this.index = index;
        this.atmStore.put(50, 222);
        this.atmStore.put(100, 222);
        this.atmStore.put(200, 222);
        this.atmStore.put(500, 222);
        this.atmStore.put(1000, 222);
        this.atmStore.put(2000, 222);
        this.atmStore.put(5000, 222);
    }

    public int getTotal () {
        int summ = 0;
        for (Map.Entry<Integer, Integer> k: this.atmStore.entrySet()) {
            summ += k.getKey() * k.getValue();
        }
        return summ;
    }

    public void putMoney (HashMap<Integer, Integer> incoming) {
        this.atmStore.put(50, this.atmStore.get(50) + incoming.get(50));
        this.atmStore.put(100, this.atmStore.get(100) + incoming.get(100));
        this.atmStore.put(200, this.atmStore.get(200) + incoming.get(200));
        this.atmStore.put(500, this.atmStore.get(500) + incoming.get(500));
        this.atmStore.put(1000, this.atmStore.get(1000) + incoming.get(1000));
        this.atmStore.put(2000, this.atmStore.get(2000) + incoming.get(2000));
        this.atmStore.put(5000, this.atmStore.get(5000) + incoming.get(5000));
    }

    public void getMoney(HashMap<Integer, Integer> outgoing) {
        this.atmStore.put(50, this.atmStore.get(50) - outgoing.get(50));
        this.atmStore.put(100, this.atmStore.get(100) - outgoing.get(100));
        this.atmStore.put(200, this.atmStore.get(200) - outgoing.get(200));
        this.atmStore.put(500, this.atmStore.get(500) - outgoing.get(500));
        this.atmStore.put(1000, this.atmStore.get(1000) - outgoing.get(1000));
        this.atmStore.put(2000, this.atmStore.get(2000) - outgoing.get(2000));
        this.atmStore.put(5000, this.atmStore.get(5000) - outgoing.get(5000));
    }

}
