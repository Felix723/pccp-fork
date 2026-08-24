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
Goetz: 
"motivating factors"

**Resource utilization**. Programs sometimes have to wait for external operations such as input or output, and while waiting can do no useful work. It is more efficient to use that wait time to let another program run.
**Fairness**. Multiple users and programs may have equal claims on the machine's resources. It is preferable to let them share the computer via finer-grained time slicing than to let one program run to completion and then start another.
**Convenience**. It is often easier or more desirable to write several programs that each perform a single task and have them coordinate with each other as necessary than to write a single program that performs all the tasks.

Notes:
**Inherent**: User interfaces and other kinds of input/output.
**Exploitation**: Hardware capable of simultaneously executing multiple streams of statements, a special (but important) case is communication and coordination of independent
computers on the internet.
**Hidden**: Enabling several programs to share some resources in a manner where each can act as if
they had sole ownership.

1. The categories presented by Goetz are concepts that could be used and applied within many different types of concurrent systems, whereas the Concurrency Notes highlight types of systems, which could make use of any of the concepts highlighted by Goetz.
2. We think many apps, inparticular google maps, would fall under the "inherent" category from Concurrency Notes,
   whereas it does not fit in any of the motivating factors from Goetz. Google maps is a user interface and therefore
   fits under the inherent category. Google Maps does not use any "wait" time to execute another program, it is
   constantly showing many important features. There is only one user and one program using many resources at once to
   do many things, not sharing with anything else, meaning it does not fit within fairness or convenience either.


1.5 Mandatory

1. We are both using MacOS. MacOS is running natively on the Macbook hardware. 
2. Both 8 cores, main memory: 24 gb. Cache: multi-level, hierarchical cache design coupled with a Unified Memory Architecture
   (UMA). L1: 192 KB, L2: 12 MB (4 MB for half of the cores), SLC: 8 MB.
3. See `Add.java`. The running code took 1042 nanoseconds 

