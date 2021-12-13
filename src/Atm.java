import java.util.HashMap;
import java.util.Map;

public class Atm {
    static int count = 0;
    private int cellValue;
    private int[] keys = {50,100,200,500,1000,2000,5000};
    private int[] defValues = {222,222,222,222,222,222,222};
    public  int index;
    public  HashMap<Integer, Integer> atmStore = new HashMap<>();

    public Atm (int index) {
        this.index = index;
        for (int i = 0; i < 7; i++  ) {
            this.atmStore.put(keys[i], defValues[i]);
        }
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
