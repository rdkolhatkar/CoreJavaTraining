package com.concepts.collection;

public class CollectionFramework {
    /*
        1) What is a Collection?
        -> A collection is simply an object that represents a group of objects, known as its elements.
        2) What is collection framework?
        -> It provides a set of interfaces and classes that help in managing groups of object.
        -> Before the introduction of the Collection Framework in JDK 1.2, Java used to rely on a variety of classes,
           like Vector, Stack, Hashtable and array to store and manipulate groups of objects. But with these classes there were drawbacks like,
           Inconsistency, Lack of inter-operability and no common interface. To resolve these issues java introduced collection framework.
        ---------------------------------------------------------------------------------------------------------------------------------------------------
             * ================================================================
             *                 JAVA COLLECTION FRAMEWORK
             * ================================================================
             *
             * The Java Collection Framework (JCF) is a set of interfaces,
             * classes, and algorithms used to store, retrieve, manipulate,
             * and process groups of objects.
             *
             * Package: java.util
             *
             * MAIN COMPONENTS:
             * 1. Interfaces       -> List, Set, Queue, Deque, Map
             * 2. Implementations  -> ArrayList, HashSet, HashMap, etc.
             * 3. Algorithms       -> Sorting, Searching, Reversing, etc.
             *
             * IMPORTANT:
             * -> Collection is an interface.
             * -> Collections is a utility class.
             * -> Map is part of the Java Collection Framework but does not
             *    extend the Collection interface.
             *
             *
             * ================================================================
             *            1. COLLECTION INTERFACE HIERARCHY
             * ================================================================
             *
             *                         Iterable (Interface)
             *                               |
             *                         Collection (Interface)
             *                               |
             *              +----------------+----------------+
             *              |                |                |
             *             List             Set             Queue
             *              |                |                |
             *              |                |                |
             *    +---------+------+         |         +------+----------+
             *    |         |      |         |         |                 |
             * ArrayList LinkedList Vector  HashSet PriorityQueue     Deque
             *                     |         |                           |
             *                   Stack    LinkedHashSet              ArrayDeque
             *                               |
             *                            (HashSet
             *                            subclass)
             *
             * Additional Set interfaces:
             *
             * Set (Interface)
             *  |
             *  +-- SortedSet (Interface)
             *        |
             *        +-- NavigableSet (Interface)
             *              |
             *              +-- TreeSet (Class)
             *
             * IMPORTANT RELATIONSHIPS:
             * -> LinkedList implements both List and Deque.
             * -> Deque extends Queue.
             * -> Queue extends Collection.
             * -> List extends Collection.
             * -> Set extends Collection.
             * -> Stack extends Vector.
             * -> LinkedHashSet extends HashSet.
             * -> TreeSet implements NavigableSet.
             *
             *
             * ================================================================
             *                       2. LIST INTERFACE
             * ================================================================
             *
             * List (Interface)
             *  |
             *  +-- ArrayList
             *  |
             *  +-- LinkedList
             *  |
             *  +-- Vector
             *        |
             *        +-- Stack
             *
             * FEATURES:
             * -> Maintains insertion order.
             * -> Allows duplicate elements.
             * -> Supports index-based access.
             * -> Generally allows null elements.
             *
             * ArrayList:
             * -> Uses a resizable array.
             * -> Fast random access using indexes.
             * -> Insertion/deletion in the middle can be slower.
             * -> Not synchronized.
             *
             * LinkedList:
             * -> Uses a doubly linked list.
             * -> Implements both List and Deque.
             * -> Efficient insertion/deletion at ends.
             * -> Slower random access compared to ArrayList.
             *
             * Vector:
             * -> Uses a resizable array.
             * -> Synchronized legacy collection.
             * -> Allows duplicate elements.
             *
             * Stack:
             * -> Extends Vector.
             * -> Follows LIFO (Last In, First Out).
             * -> Legacy class; ArrayDeque is generally preferred.
             *
             *
             * ================================================================
             *                       3. SET INTERFACE
             * ================================================================
             *
             * Set (Interface)
             *  |
             *  +-- HashSet
             *  |     |
             *  |     +-- LinkedHashSet
             *  |
             *  +-- SortedSet (Interface)
             *        |
             *        +-- NavigableSet (Interface)
             *              |
             *              +-- TreeSet
             *
             * FEATURES:
             * -> Does not allow duplicate elements.
             * -> Does not support index-based access.
             *
             * HashSet:
             * -> Uses hashing internally.
             * -> Does not guarantee iteration order.
             * -> Allows one null element.
             * -> Average O(1) add, remove, and contains operations.
             *
             * LinkedHashSet:
             * -> Extends HashSet.
             * -> Maintains insertion order.
             * -> Does not allow duplicates.
             * -> Allows one null element.
             *
             * TreeSet:
             * -> Implements NavigableSet.
             * -> Stores elements in sorted order.
             * -> Uses a Red-Black Tree internally.
             * -> Does not allow duplicates.
             * -> Typically O(log n) add, remove, and contains.
             * -> Does not allow null with natural ordering.
             *
             *
             * ================================================================
             *                      4. QUEUE INTERFACE
             * ================================================================
             *
             * Queue (Interface)
             *  |
             *  +-- PriorityQueue
             *  |
             *  +-- Deque (Interface)
             *        |
             *        +-- ArrayDeque
             *        |
             *        +-- LinkedList
             *
             * FEATURES:
             * -> Used for processing elements.
             * -> Many queues follow FIFO (First In, First Out).
             * -> PriorityQueue processes elements based on priority.
             *
             * PriorityQueue:
             * -> Uses a priority heap.
             * -> Elements are processed according to priority.
             * -> Does not guarantee FIFO order.
             * -> Does not allow null elements.
             *
             * Deque (Double-Ended Queue):
             * -> Supports insertion and removal at both ends.
             * -> Can behave as FIFO or LIFO.
             *
             * ArrayDeque:
             * -> Uses a resizable array.
             * -> Can be used as both Stack and Queue.
             * -> Does not allow null elements.
             * -> Usually preferred over legacy Stack.
             *
             * LinkedList:
             * -> Implements both List and Deque.
             * -> Can be used as a Queue or Deque.
             * -> Allows null, but null is discouraged for Queue usage.
             *
             *
             * ================================================================
             *                    5. MAP INTERFACE HIERARCHY
             * ================================================================
             *
             * Map (Interface)
             *  |
             *  +-- HashMap
             *  |     |
             *  |     +-- LinkedHashMap
             *  |
             *  +-- Hashtable
             *  |     |
             *  |     +-- Properties
             *  |
             *  +-- SortedMap (Interface)
             *        |
             *        +-- NavigableMap (Interface)
             *              |
             *              +-- TreeMap
             *
             * Other important Map implementations:
             * -> WeakHashMap
             * -> IdentityHashMap
             * -> EnumMap
             * -> ConcurrentHashMap (java.util.concurrent)
             *
             * FEATURES:
             * -> Stores data in Key-Value pairs.
             * -> Keys must be unique.
             * -> Values can be duplicated.
             * -> Map does not extend Collection.
             *
             * HashMap:
             * -> Does not guarantee iteration order.
             * -> Allows one null key and multiple null values.
             * -> Not synchronized.
             * -> Average O(1) get and put operations.
             *
             * LinkedHashMap:
             * -> Extends HashMap.
             * -> Maintains insertion order by default.
             * -> Can optionally maintain access order.
             * -> Allows one null key and multiple null values.
             *
             * TreeMap:
             * -> Implements NavigableMap.
             * -> Stores entries sorted by key.
             * -> Uses a Red-Black Tree.
             * -> Typically O(log n) get, put, and remove.
             * -> Null keys are not allowed with natural ordering.
             *
             * Hashtable:
             * -> Legacy synchronized Map implementation.
             * -> Does not allow null keys or null values.
             *
             * Properties:
             * -> Extends Hashtable<Object, Object>.
             * -> Commonly used to store configuration properties.
             * -> String keys and values are recommended.
             *
             * ConcurrentHashMap:
             * -> Provides thread-safe concurrent operations.
             * -> Does not allow null keys or null values.
             * -> Preferred over Hashtable for many concurrent use cases.
             *
             *
             * ================================================================
             *                 6. CONCURRENT COLLECTIONS
             * ================================================================
             *
             * Package: java.util.concurrent
             *
             * Concurrent Collections
             *  |
             *  +-- ConcurrentMap (Interface)
             *  |     |
             *  |     +-- ConcurrentHashMap
             *  |     |
             *  |     +-- ConcurrentNavigableMap (Interface)
             *  |           |
             *  |           +-- ConcurrentSkipListMap
             *  |
             *  +-- BlockingQueue (Interface)
             *  |     |
             *  |     +-- ArrayBlockingQueue
             *  |     +-- LinkedBlockingQueue
             *  |     +-- PriorityBlockingQueue
             *  |     +-- DelayQueue
             *  |     +-- SynchronousQueue
             *  |
             *  +-- BlockingDeque (Interface)
             *  |     |
             *  |     +-- LinkedBlockingDeque
             *  |
             *  +-- ConcurrentLinkedQueue
             *  |
             *  +-- ConcurrentLinkedDeque
             *  |
             *  +-- CopyOnWriteArrayList
             *  |
             *  +-- CopyOnWriteArraySet
             *  |
             *  +-- ConcurrentSkipListSet
             *
             * IMPORTANT:
             * -> BlockingQueue extends Queue.
             * -> BlockingDeque extends both BlockingQueue and Deque.
             * -> ConcurrentMap extends Map.
             * -> ConcurrentNavigableMap extends ConcurrentMap
             *    and NavigableMap.
             * -> ConcurrentSkipListSet implements NavigableSet.
             *
             * These collections are designed for multithreaded applications.
             *
             *
             * ================================================================
             *                 7. COLLECTIONS UTILITY CLASS
             * ================================================================
             *
             * java.util.Collections
             *
             * Collections is a utility class containing static methods
             * for performing operations on collections.
             *
             * Important methods:
             *
             * Collections.sort(list)        -> Sorts a List.
             * Collections.reverse(list)     -> Reverses a List.
             * Collections.shuffle(list)     -> Randomly shuffles a List.
             * Collections.max(collection)   -> Finds maximum element.
             * Collections.min(collection)   -> Finds minimum element.
             * Collections.frequency(c, obj) -> Counts occurrences.
             * Collections.binarySearch(...) -> Performs binary search.
             * Collections.synchronizedList() -> Returns synchronized List wrapper.
             *
             *
             * ================================================================
             *                      8. QUICK COMPARISON
             * ================================================================
             *
             * Interface  | Duplicates  | Ordering                | Examples
             * ----------------------------------------------------------------
             * List       | Yes         | Positional/Inserting    | ArrayList
             * Set        | No          | Depends on impl.        | HashSet
             * Queue      | Yes         | Depends on impl.        | PriorityQueue
             * Deque      | Yes         | Double-ended            | ArrayDeque
             * Map        | Values Yes  | Depends on impl.        | HashMap
             *            | Keys No     |                         |
             *
             *
             * ================================================================
             *                 9. IMPORTANT INTERVIEW POINTS
             * ================================================================
             *
             * 1. Collection is the root interface for List, Set, and Queue.
             *
             * 2. Iterable is the superinterface of Collection.
             *
             * 3. Map is separate from the Collection hierarchy.
             *
             * 4. ArrayList is generally preferred for frequent random access.
             *
             * 5. HashSet is useful when uniqueness is required.
             *
             * 6. LinkedHashSet maintains insertion order.
             *
             * 7. TreeSet maintains sorted order.
             *
             * 8. HashMap stores unique keys with associated values.
             *
             * 9. LinkedHashMap maintains insertion order by default.
             *
             * 10. TreeMap maintains sorted keys.
             *
             * 11. ArrayDeque is generally preferred over Stack.
             *
             * 12. ConcurrentHashMap is useful for thread-safe Map operations.
             *
             * 13. The Collection Framework stores objects, not primitives
             *     directly. Wrapper types such as Integer are used.
             *
             * 14. ArrayList, HashSet, and HashMap are not synchronized.
             *
             * 15. Collections is a utility class, whereas Collection
             *     is an interface.
             *
             * ================================================================
             * NOTE:
             * This is a learning-oriented hierarchy of the major interfaces
             * and implementations, not every class in the JDK.
             * ================================================================
    */
}
