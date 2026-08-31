# Reading material notes for mandatory chapters in PCCP


## Chapter 2
Thread safety...
### Race condition definition
"A race condition occurs when the correctness of a computation depends on the
relative timing or interleaving of multiple threads by the runtime;"
### Data race definition
"data race happens when synchronization is not used to coordinate all access to a shared nonfinal field"
### Synchronization
"Making an object thread-safe requires using synchronization to coordinate access to its mutable state;"

In Java, `synchronized` provides exclusive locking. 
`Volatile`, ...
`Explicit locks`, ...
`Atomic variables`, ...



## Chapter 2.3

Use `AtomicLong` for to manage state of a counter or similar in a thread-safe manner.
Use `AtomicReference` to manage object references in a thread-safe manner.
But using these two avoids not race condition.
Use the synchronized block instead... we did this in /exercises01


