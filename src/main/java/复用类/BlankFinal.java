package 复用类;

public class BlankFinal {
    private final int i;

    //我只能说编译器是真的牛批!
    public BlankFinal(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        BlankFinal blankFinal = new BlankFinal(5);
        System.out.println(blankFinal.i);
    }
}
