1.1 Mandatory

1. We get output values close to 20.000.000, but never reach it exactly or exceeding it. This was expected, because of the data race resulting in a race condition.
2. This could be because of the lower chance of interleaving between atomic operations. It is not guaranteed, as the risk of interleaving is still there.
3. Yes it would make a difference since the operations, when unrolled, are not atomic and thereby increase the risk of interleaving. However, we do not see any difference in the result(200 every time).
4. The reason why our solution is correct and no other output is possible is because, we have implemented mutual
   exclusion. Only one thread can enter the critical section (the increment function). We have ensured the absence of
   deadlock (there is not even an error to catch from the increment function, but we have a finally block to ensure the thread will give up its lock upon completion). If a thread is ready to enter the critical section, it will eventually do so assuming the scheduler picks it. 
5. Our critical section is one line, and contains the only object reference that is shared memory being read and written to. 


1.2 Mandatory


1. See `Printer.java`.
2. An interleaving where leaving faults could be described as follows(in bold); t1(1), t2(1), **t1(2), t2(2)**, t2(3), t2(4), t1(3), t2(4), t2(1). So this happens when the schedular chooses to switch threads after entering the print function. 
3. It is impossible for incorrect patterns to occur because the critical section includes both print statements in the
   correct order. The section is locked so the pattern must be completed before the next thread can enter it. Any
   interleaving between threads will not effect the pattern.

1.3 Mandatory

1. See `CounterThreads2.java`.
2. We have added a if statement to the critical section. It checks a static value against the counter. It becomes a part of the critical section because there would be a data race between the two threads, since the counter is shared memory which is written to. We have enclosed the critical section with locks, so only one thread can access the counter at any given time, ensuring mutual exclusion. We had a deadlock, since we forgot to unlock the thread before it returns from the loop upon reaching 15000.

1.4 Mandatory

1. 