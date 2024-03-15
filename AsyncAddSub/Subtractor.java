package AsyncAddSub;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
public class Subtractor implements Callable<Void>{
    Count count;
    Lock l;
    public Subtractor(Count count, Lock l){
        this.count = count;
        this.l = l;
    }

    @Override
    public Void call() throws Exception {
        for(int i=1; i<=100000; i++){
            System.out.println("Subtractor");
            l.lock();
            this.count.value -= 1;
            l.unlock();
        }
        return null;
    }
}
