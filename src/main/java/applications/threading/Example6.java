package applications.threading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Category: Threading
 * ID: Example6
 * Description: Illustrates the Lock interface
 * Taken From:
 *
 * Details:
 * A critical region can be created b y using locks. Each object is associated with a lock in the form of a monitor which
 * ensures that only one thread at a time can execute the code in a critical  region.
 * Java provides the Lock interface for modeling locks. Several classes implement it.
 * The principle is simple. Before accessing the critical region the thread must obtain the lock. Once exiting it, it must release the lock.
 *  Since code can always throw exceptions, we must place the unlocking into the finally block.
 */

public class Example6 {

    public class Task implements Runnable
    {

        private Lock lock;

        public Task(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run(){

            try {
                lock.lock();

                System.out.println("HelloWorld from thread: " + Thread.currentThread().getName()+ " with id: "+Thread.currentThread().getId());
            }
            finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args){

        Example6 example6 = new Example6();
        Lock lock = new ReentrantLock();
        ExecutorService executorService = newFixedThreadPool(3);
        executorService.submit(example6.new Task(lock));
        executorService.submit(example6.new Task(lock));
        executorService.submit(example6.new Task(lock));
        executorService.submit(example6.new Task(lock));
        executorService.submit(example6.new Task(lock));
        executorService.shutdown();

    }

}
