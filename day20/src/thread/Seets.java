package thread;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Seets implements Runnable {
	int count = 5;
	ReentrantLock lock = new ReentrantLock();

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.lock();
		sale();
		lock.unlock();
	}

	private synchronized void sale() {
		if (count > 0) {
			System.out.println("第" + count + "个位置" + "被第" + Thread.currentThread().getName() + "观众抢到");
			count--;
		}
	}

	public static void main(String[] args) {
		Seets seets = new Seets();
		for (int i = 0; i < 30; i++) {
			new Thread(seets, "" + i).start();
		}
	}
}
