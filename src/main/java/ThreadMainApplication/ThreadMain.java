package ThreadMainApplication;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("The name of the Thread is " + Thread.currentThread().getName());
//                System.out.println("The Priority of the currecnt thread is " + Thread.currentThread().getPriority());
                throw  new RuntimeException("Interal Exception");
            }
        });

//        thread.setName("ThreadCool");
//        thread.setPriority(Thread.MAX_PRIORITY);
//        System.out.println("Before thread" + Thread.currentThread().getName());
//        thread.start();  //to start the thread
//        System.out.println("After Thread" + Thread.currentThread().getName());
//        Thread.sleep(100);

        thread.setName("Exception Example");

        //gets the exception wherever the exception occues in thread
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical Exception has been thrown " + t.getStackTrace());

            }
        });
       // thread.start();
    }
}
