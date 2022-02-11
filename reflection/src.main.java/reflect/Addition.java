package reflection.reflect;

/**
 * @author: lijinhao
 * @date: 2022/02/07 13:23
 */
public class Addition implements MathOperation{
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}
