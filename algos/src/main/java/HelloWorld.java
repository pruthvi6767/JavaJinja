import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.Math.*;

public class HelloWorld {
    public static  void main(String [] args) throws Exception {
        System.out.println("Hello World!!");

         //Run in Threads
        for(int i=0; i < 10; i++){
            new Thread(new MyThreads()).start();
            //System.out.println("Hello Dates");
        }
      
        //Singleton
        Singleton  s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1 == s2); //true


       // Threads using concurrent.executor

        // create array from range and return sum
       int[] arY = IntStream.range(0, 1000000).toArray();
        System.out.println(Arrays.stream(arY).sum());

        //create big array sequence
//        List<Integer> ls = IntStream.range(0, 100000000)
//                .boxed()
//                .collect(Collectors.toList());
        //Without concurrency or synchronus
//        int sum= 0;
//        for(int i: arY){
//            sum+=i;
//        }
//        System.out.println(sum);
        List<Callable<BigDecimal>> calls = new ArrayList<>();
        for(int i=0; i < 3; i++ ){
//            System.out.println(i* arY.length/3);
//            System.out.println((i+1)* arY.length/3 -1 );

            calls.add(new MyCallables(arY, i* arY.length/3, ((i+1)*arY.length/3) -1));

        }
        //MyCallables mycalls = new MyCallables(arY);
        ExecutorService e = Executors.newFixedThreadPool(3);
        int total= 0;
        for(Future s : e.invokeAll(calls)){
            BigDecimal sum = (BigDecimal) s.get();

            total = total + sum.intValue();

        }
        System.out.println(total);
        e.shutdown();

    }
}
