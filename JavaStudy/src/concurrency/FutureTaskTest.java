package concurrency;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

public class FutureTaskTest {

	@Test
	public void test1() {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				while (true) {
					System.out.println(new Date());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						break;
					}
				}
				System.out.println("cancelled");
				return "cancelled";
			}
		};

		Future<String> future = Executors.newFixedThreadPool(1).submit(callable);

		while (!future.isCancelled() || !future.isDone()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Trying to cancel: " + System.currentTimeMillis());
			future.cancel(true);
		}
	}

	@Test
	public void test2() {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				try {
					for (int i = 0; i < 5; i++) {
						System.out.println(new Date());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println("got exception. ignoring.");
						}
					}
				} catch (Throwable e) {
					e.printStackTrace();
					return "exception";
				}
				return "noexception";
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(callable);

		while (!future.isDone()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Trying to cancel: " + System.currentTimeMillis());
            future.cancel(false);
		}


		try {
//			executorService.awaitTermination(9999, TimeUnit.DAYS);
			Thread.sleep(5000);
			String s = future.get();
			System.out.println("Got from future:" + s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}