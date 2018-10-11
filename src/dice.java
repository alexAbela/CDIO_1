import java.util.Random;

public class dice {
    Random random= new Random();
    private final int maxValue = 6;
    private int value;
    public dice() {
        value = 1;
    }
    public int roll() {
        value = random.nextInt(maxValue) + 1;
        return value;
    }
    public int getValue(){
        return value;
    }
}
