# Day16 Thread Demos

Compile all demos:

```powershell
javac src\*.java
```

Run each demo:

```powershell
java -cp src MyThreadDemo
java -cp src RunnableDemo
java -cp src LifecycleDemo
java -cp src CounterRaceDemo
java -cp src DeadlockDemo
```

What each demo shows:

- `MyThreadDemo`: `extends Thread`, `start()`, `sleep()`
- `RunnableDemo`: `implements Runnable`, named class, lambda, `Thread` constructor
- `LifecycleDemo`: `NEW`, `RUNNABLE`, `BLOCKED`, `TERMINATED`, `isAlive()`, `join()`
- `CounterRaceDemo`: race condition without `synchronized`, then correct result with `synchronized`
- `DeadlockDemo`: deadlock with opposite lock ordering, then fixed lock ordering

