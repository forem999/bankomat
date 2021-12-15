import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) throws Exception {

        Atm atm = new Atm(1);
        System.out.println(atm.getTotal());
//        atm.moneyReceiver();
//        System.out.println(atm.getTotal());
        atm.moneyGiver();
        System.out.println(atm.getTotal());

    }
}
