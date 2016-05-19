import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
 
public class ConsumerThread implements Runnable {
    private KafkaStream<byte[], byte[]> stream;
    private int threadNumber;
 
    public ConsumerThread(KafkaStream<byte[], byte[]> a_stream, int a_threadNumber) {
        threadNumber = a_threadNumber;
        stream = a_stream;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext())
            System.out.println("Thread " + threadNumber + ": " + new String(it.next().message()));
        System.out.println("Shutting down Thread: " + threadNumber);
    }
}