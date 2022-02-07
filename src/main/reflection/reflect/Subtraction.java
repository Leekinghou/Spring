package reflection.reflect;

/**
 * @author: lijinhao
 * @date: 2022/02/07 13:24
 */

public class Subtraction implements MathOperation{
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}
