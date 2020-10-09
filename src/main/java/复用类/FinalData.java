package 复用类;

import java.util.Random;

/**
 * @author tengwz
 */
public class FinalData {
    //静态变量应该怎么用????可能是为了被静态方法调用
    private static Random random = new Random(47);
    private String id;
    public FinalData(String  id){
        this.id = id;
    }

    private final int valueOne = 9;

    private final static int VALUE_TWO = 99;

    public final static int VALUE_THREE = 39;

    private final int i4 = random.nextInt(20);

    static final int INT_5 = random.nextInt(20);




}
