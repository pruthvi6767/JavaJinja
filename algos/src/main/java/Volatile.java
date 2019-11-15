public class Volatile {
     /// memory consistency error example
        private static  boolean sayHello = false;
       // private static volatile boolean sayHello = false;

        public static void main(String[] args) throws InterruptedException {

            Thread thread = new Thread(() -> {
                while(!sayHello) {
                }

                System.out.println("Hello World!");

                while(sayHello) {
                }

                System.out.println("Good Bye!");
            });

            thread.start();

            Thread.sleep(10000);
            System.out.println("Say Hello..");
            sayHello = true;

            Thread.sleep(10000);
            System.out.println("Say Bye..");
            sayHello = false;
        }


}
