import java.util.HashMap;

public class AtmDept {

    private static HashMap<Integer, Atm> AtmDeptStore = new HashMap<>();
    private Atm;

    public Atm createNewAtm (int index) {
        Atm atm = new Atm(index);
        AtmDeptStore.put(index, atm);
    }


}
