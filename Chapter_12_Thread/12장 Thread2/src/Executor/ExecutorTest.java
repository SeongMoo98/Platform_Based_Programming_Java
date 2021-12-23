package Executor;
/**
 * ***High Level Concurrency
 * Thread를 new해서 사용하지않고 Runnable처럼 Functional Programming
 * Lock Object, Executors, Concurrnet Collections, Atomic Variable
 *
 * ***Lock Objects
 * 장점 : Lock을 Back out 할 수 있다
 * tryLock() - lock을 얻는다
 * unLock() - lock을 푼다
 * ==> 두 Thread의 lock을 모두 얻어야지 실행 (하나의 Thread는 하나의 Lock을 가질 수 있다)
 * 못 얻으면 unLock으로 Lock을 풀고(Back out) 실행하지 않는다
 *
 *
 * In Large Scale Application
 * Thread Managemene와 나머지 Application을 분리 시킬 필요가 있다
 *
 * ExecutorService - Executor의 subInterface
 * : 개별 task와 Executor의 Life Cycle 관리에 도움을 준다
 *
 * execute(Runnable) - executes it asynchronously
 * submit(Runnable) - takes a Runnable implementation, but returns a Future object. (returns null)
 * submit(Callable) - takes a Java Callable instead of a Runnable
 * invokeAny(...) - takes a collection of Callable objects. Just one of the ones that finish. (cancelled)
 * invokeAll(...) - invokes all of the Callable objects you pass to it in the collection
 *
 *
 * Executors
 * newSingleThreadExecutor() - 하나의 Thread로 등록된 Task 순차 처리
 * newCachedThreadPool() - OS Resource가 허용하는 만큼 Thread를 생성하여 Task를 동시처리
 * newFixedThreadPool(n) - 동시에 실행할 Thread 개수를 지정하여 Task를 동시 처리
 *
 */

/*
 * *** Callable<T> interface
 * result를 계산하거나, 수행 할 수 없으면 Exception return
 * Future<V> interface - 작업결과를 나타냄
 * V get() - 필요한 경우, 계산이 완료될 때까지 기다린다==>결과를 검색
 */

/*
 * <T> Future<T> submit(Callable<T> Task) - Runnable 말고 Callable 수행
 * Future<T> return
 *
 * Future<> submit(Runnable Task) - Runnable을 수행하고 Future return
 * Future<T> return 하지만 null이다
 */




import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //submit() - Runnable implementation이다
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        //Callable<T>
        Future<String> future = executor.submit(()->{
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Callable task is done!"; //Future
        });
        System.out.println(future.get());
        executor.shutdown();
    }
}
