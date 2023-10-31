
//Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//        Вилки лежат на столе между каждой парой ближайших философов.
//        Каждый философ может либо есть, либо размышлять.
//        Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//        Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//        Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
//        Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

    public class DiningPhilosopher {

    public static void main(String[] args) {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

            for (int i = 0; i < forks.length; i++){
                forks[i] = new Object();
            }
            for (int i = 0; i < philosophers.length; i++){

                Object leftForks = forks[i];
                Object rightForks = forks[(i + 1) % forks.length];

                if (i == philosophers.length - 1 ) {
                    philosophers[i] = new Philosopher(rightForks, leftForks);
                }
                else {
                    philosophers[i] = new Philosopher(leftForks, rightForks);
                }
                Thread t = new Thread(philosophers[i], "Philosopher : " + (i + 1));
                t.start();

            }
    }
}