package applications.threading;


/**
 * Category: Threading
 * ID: Example2
 * Description: Illustrates Producer/Consumer pattern with one thread for the Producer
 *              and one thread for the Consumer
 * Taken From:
 *
 * Details:
 *
 *
 */
public class Example3 {


    public static  void main(String[] args){

        Example3 example3 = new Example3();
        SharedResource resource = example3.new SharedResource();
        int counter = 1000;

        Thread t1 = new Thread(example3.new Producer(resource, counter));
        Thread t2 = new Thread(example3.new Consumer(resource, counter));

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){}

    }

    /**
     * The Producer thread
     */
    public class Producer implements Runnable{

        public Producer(SharedResource resource, int counter){
            this.resource = resource;
            this.counter = counter;
        }

        @Override
        public void run(){

            for(int i=0; i< this.counter; ++i){
                this.resource.write(i);
            }
        }

        private SharedResource resource;
        private int counter;
    }

    /**
     * The Consumer thread
     */
    public class Consumer implements Runnable{

        public Consumer(SharedResource resource, int counter){
            this.resource = resource;
            this.counter = counter;
        }

        @Override
        public void run(){

            for(int i=0; i< this.counter; ++i){
                System.out.println("Received: "+this.resource.getValue());
            }
        }

        private SharedResource resource;
        private int counter;
    }

    /**
     * The shared resource
     */
    public class SharedResource {

        public synchronized void write(int i){

            while(!this.writable){

                try{
                    wait();
                }
                catch(InterruptedException e){

                }
            }

            this.value = i;
            this.writable =false;
            notify();
        }


        public synchronized int getValue(){

            while(this.writable){

                try{
                    wait();
                }
                catch(InterruptedException e){

                }
            }

            int tmp = value;
            this.writable = true;
            notify();
            return tmp;
        }


        private boolean writable=true;
        private int value;
    }
}
