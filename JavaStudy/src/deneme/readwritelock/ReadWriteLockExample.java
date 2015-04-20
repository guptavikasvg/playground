package deneme.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void sleep(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Writer extends Thread {
        private Dictionary dictionary = null;

        public Writer(Dictionary d, String threadName) {
            this.dictionary = d;
            this.setName(threadName);
        }

        @Override
        public void run() {
            while (true) {
                //updating dictionary with WRITE LOCK
                dictionary.set("time = " + System.currentTimeMillis());

                //update every seconds
                ReadWriteLockExample.sleep(2);
            }
        }
    }

    class Reader extends Thread {

        private Dictionary dictionary = null;

        public Reader(Dictionary d, String threadName) {
            this.dictionary = d;
            this.setName(threadName);
        }

        @Override
        public void run() {
            while (true) {
                //reading from dictionary with READ LOCK
                System.out.println("thread = " + getName() + ": value = " + dictionary.get());

                //update every seconds
                ReadWriteLockExample.sleep(1);
            }
        }
    }

    class Dictionary {

        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        private final Lock read = readWriteLock.readLock();

        private final Lock write = readWriteLock.writeLock();

        private Object dictionary = null;

        public void set(Object value) {
            write.lock();
            try {
                System.out.println("setting value = " + value);
                dictionary = value;
            } finally {
                write.unlock();
            }
        }

        public Object get() {
            read.lock();
            try {
                return dictionary;
            } finally {
                read.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new ReadWriteLockExample().new Dictionary();
        Writer writer = new ReadWriteLockExample().new Writer(dictionary, "Writer thread");
        writer.start();

        for (int i = 0; i < 5; i++) {
            new ReadWriteLockExample().new Reader(dictionary, "Reader thread " + i).start();
        }
    }
}