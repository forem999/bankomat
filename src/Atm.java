import java.util.HashMap;
import java.util.Map;

public class Atm {
    static int count = 0;
    private int cellValue;
    private int[] keys = {50,100,200,500,1000,2000,5000};
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
        for (int i : keys) {
            this.atmStore.put(i, this.atmStore.get(i) + incoming.get(i));
        }
    }

    public void getMoney(HashMap<Integer, Integer> outgoing) {
        for (int i : keys) {
            this.atmStore.put(i, this.atmStore.get(i) - outgoing.get(i));
        }
    }
}
