package AsyncAddSub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(String[] rags) throws Exception {
        Count cnt = new Count();
        Lock l = new ReentrantLock();
        ExecutorService es = Executors.newFixedThreadPool(2);
        Adder add = new Adder(cnt,l);
        Subtractor sub = new Subtractor(cnt,l);
        Future<Void> val1 = es.submit(add);
        Future<Void> val2 = es.submit(sub);
        val2.get();
        val1.get();
        System.out.println(cnt.value);
        es.close();
    }
}
