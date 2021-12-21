import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) throws Exception {

        Atm atm = new Atm(1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("5")) {
            System.out.print("Выбeрите действие:\n" +
                    "Получить деньги: 1;\n" +
                    "Положить деньги: 2;\n" +
                    "Узнать общую сумму: 3;\n" +
                    "Узнать информацию по ячейкам: 4;\n" +
                    "Выход: 5;\n" +
                    "---->");
            input = reader.readLine();
            switch (input) {
                case ("1"):
                    atm.moneyGiver();
                    break;
                case ("2"):
                    atm.moneyReceiver();
                    break;
                case ("3"):
                    System.out.println(atm.getTotal());
                    break;
                case ("4"):
                    atm.getCellsInfo();
                    break;
                case ("5"):
            }
        }
    }
}
