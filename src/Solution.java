import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) throws Exception {

        Atm atm = new Atm(1);
        System.out.println(atm.getTotal());

        HashMap<Integer, Integer> incoming = new HashMap<>();
        incoming.put(50, 222);
        incoming.put(100, 222);
        incoming.put(200, 222);
        incoming.put(500, 222);
        incoming.put(1000, 222);
        incoming.put(2000, 222);
        incoming.put(5000, 222);

        atm.putMoney(incoming);

        System.out.println(atm.getTotal());

        atm.getMoney(incoming);

        System.out.println(atm.getTotal());

        atm.getMoney(incoming);

        System.out.println(atm.getTotal());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите банкноты через пробел: 1");
        String str = reader.readLine();
        atm.inputParcer(str);
    }
}
