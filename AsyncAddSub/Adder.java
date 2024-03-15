package AsyncAddSub;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
public class Adder implements Callable<Void>{
    Count count;
    Lock l;
    public Adder(Count count,Lock l){
        this.count = count;
        this.l = l;
    }

    public Void call() throws Exception{
        for(int i=1;i<=100000;i++){
            System.out.println("Adders");
            l.lock();
            this.count.value+=1;
            l.unlock();
        }
        return null;
    }

}
