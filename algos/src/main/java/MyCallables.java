import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;

public class MyCallables implements Callable<BigDecimal> {
    private BigDecimal sum = new BigDecimal(0);
    private int start;
    private  int end;
    private int[] arr;

    MyCallables(int[] arr, int start , int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    public BigDecimal call() throws Exception {

//        synchronized (this) {
//            for (int i = start; i < end + 1; i++) {
//                //sum. + Integer(arr[i]);
//                //sum = Math.addExact(sum, arr[i]); // Throws int overflow exception on overflow
//                sum = sum.add(BigDecimal.valueOf( (arr[i] ) ));
//            }
//        }
        for (int i = start; i < end + 1; i++) {
            //sum. + Integer(arr[i]);
            //sum = Math.addExact(sum, arr[i]); // Throws int overflow exception on overflow
            sum = sum.add(BigDecimal.valueOf( (arr[i] ) ));
        }
        System.out.println(Thread.currentThread().getName());

        return sum;
    }
}
