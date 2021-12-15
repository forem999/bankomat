import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Atm {
    static int count = 0;
    //размер ячейки для банкноты;
    private int maxCellValue = 333;
    // массив с номиналами банкнот, и ключи для словаря банкомата
    private int[] keys = {50,100,200,500,1000,2000,5000};
    // массив с дефалтным размером ячейки, используется для конструктора банкомата;
    private int[] defValues = {222,222,222,222,222,222,222};
    // индекс банкомата, порядковый номер;
    public  int index;
    // словарь банкомата;
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
        System.out.println(this.atmStore);
        return summ;
    }

    private void putMoney (HashMap<Integer, Integer> incoming) {
        int[] flags = this.checkCells(incoming);

        if (Arrays.stream(flags).sum() > 0 ) {
            System.out.println("Внесение денег невозможно. Ячейки будут переполнены.");
        } else {
            for (int i : keys) {
                this.atmStore.put(i, this.atmStore.get(i) + incoming.get(i));
            }
        }
    }

    private void getMoney(HashMap<Integer, Integer> outgoing) {
        int[] flags = this.checkCells(outgoing);

        if (Arrays.stream(flags).sum() < 0) {
            System.out.println("Выдача денег невозможна. Не хватает необходимых банкнот.");
        } else {
            for (int i : keys) {
                this.atmStore.put(i, this.atmStore.get(i) - outgoing.get(i));
            }
        }
    }

    private int[] checkCells (HashMap<Integer, Integer> map) {
        int[] flags = {0, 0, 0, 0, 0, 0, 0};
        int c = 0;
        for (int i : keys) {
            if (this.atmStore.get(i) + map.get(i) > maxCellValue) {
                flags[c] = 1;
            }
            if (this.atmStore.get(i) - map.get(i) < 0 ) {
                flags[c] = -1;
            }
            count++;
        }
        return flags;
    }

    private HashMap<Integer, Integer> inputParser(String s) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int k : keys) {
            result.put(k, 0);
        }
        String[] strArr = s.split(" ");
        Integer value = 0;
        if (strArr.length > 1) {
            for (String l : strArr) {
                value = Integer.parseInt(l);
                result.put(value, result.get(value) + 1);
            }
        } else if (strArr.length == 1) {
            value = Integer.parseInt(strArr[0]);
            int left = 0;
            int right = value;
            System.out.println(value);
            for (int i = 6; i > 0; i--) {
                left = right / keys[i];
                right = right % keys[i];
                result.put(keys[i], left);
            }
        }
        return  result;
    }

    public void moneyReceiver () throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Внесение банкнот. Введите банкноты через пробел: ");
        String inputString = reader.readLine();
        HashMap<Integer, Integer> incoming = inputParser(inputString);
        putMoney(incoming);
    }

    public void moneyGiver () throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Выдача банкнот. Введите сумму кратную 50: ");
        String inputString = reader.readLine();
        HashMap<Integer, Integer> incoming = inputParser(inputString);
        getMoney(incoming);
    }
}
