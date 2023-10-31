

public class  Philosopher implements Runnable {

    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  " + action);
        Thread.sleep(((int) (Math.random() * 3500)));

    }


    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + " : Размышляющий филосов ");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + " : Филосов поднял левую вилку ");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + " : Филосов поднял правую вилку - начал есть" );
                        doAction(System.nanoTime() + " : Филосов поел - отложил правую вилку");

                    }
                    doAction(System.nanoTime() + " : Филосов отложил левую вилку - приступил к размышлениям");
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
