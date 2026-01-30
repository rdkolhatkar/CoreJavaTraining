# Java Interview Guide: Versions 8 to 21

## Table of Contents
1. [Version Comparison Table](#version-comparison)
2. [Java 8 Features & Questions](#java-8)
3. [Java 9 Features & Questions](#java-9)
4. [Java 10 Features & Questions](#java-10)
5. [Java 11 Features & Questions](#java-11)
6. [Java 12-16 Features & Questions](#java-12-16)
7. [Java 17 Features & Questions](#java-17)
8. [Java 18-21 Features & Questions](#java-18-21)
9. [Migration Strategy & Challenges](#migration)
10. [Coding & Scenario Questions](#coding-scenarios)
11. [References](#references)

---

## <a name="version-comparison"></a>Version Comparison Table

| Feature Category | Java 8 (2014) | Java 11 (LTS - 2018) | Java 17 (LTS - 2021) | Java 21 (LTS - 2023) |
|-----------------|---------------|---------------------|---------------------|---------------------|
| **Language Features** | Lambda Expressions, Stream API, Optional, Method References | Local Variable Type Inference (var) | Sealed Classes, Pattern Matching (Preview), Records | Pattern Matching (Final), Record Patterns, Virtual Threads |
| **API Additions** | CompletableFuture, DateTime API, Nashorn JS Engine | HttpClient, String Methods (repeat, strip, etc.) | New macOS Rendering Pipeline, Foreign Function API | Sequenced Collections, Structured Concurrency, Scoped Values |
| **JVM/Performance** | PermGen removed, Metaspace added | Epsilon GC, ZGC (Experimental) | ZGC (Production), Enhanced Pseudo-Random | Generational ZGC, Key Encapsulation API |
| **Module System** | Not Available | JPMS (Java Platform Module System) | Strong Encapsulation by Default | Deprecation of Security Manager |
| **Memory Management** | - | Flight Recorder, Low-Overhead Heap Profiling | Foreign Memory API | Virtual Threads (Lightweight Threads) |
| **Deprecations** | Applet API, CMS Collector | Nashorn JS Engine, Applet API | Security Manager (Deprecated) | - |

---

## <a name="java-8"></a>Java 8 Features & Questions

### Q1: What are Lambda Expressions and Functional Interfaces in Java 8?

**Answer:**
Lambda expressions enable functional programming by allowing you to pass behavior as arguments to methods. They work with functional interfaces (interfaces with a single abstract method).

```java
// Functional Interface definition
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Lambda expression implementation
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;
        
        System.out.println("Addition: " + addition.calculate(5, 3));       // Output: 8
        System.out.println("Multiplication: " + multiplication.calculate(5, 3)); // Output: 15
        
        // Using with existing functional interfaces
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        
        // Lambda with forEach
        names.forEach(name -> System.out.println(name));  // Output: John Jane Jack
        
        // Method reference
        names.forEach(System.out::println);  // Same output
    }
}
```

**Explanation:**
- Line 3-6: Defines a functional interface with single abstract method
- Line 11-12: Lambda expressions implementing the interface
- Line 18: Lambda expression with forEach
- Line 21: Method reference (shorthand for lambdas)

### Q2: Explain the Stream API with Examples

**Answer:**
The Stream API provides a functional approach to process collections of data with operations like filter, map, reduce, etc.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers and square them
        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)          // Intermediate operation: filters even numbers
            .map(n -> n * n)                  // Intermediate operation: squares each number
            .collect(Collectors.toList());    // Terminal operation: collects to list
        
        System.out.println("Squared even numbers: " + result); 
        // Output: [4, 16, 36, 64, 100]
        
        // Reduce operation - sum of all numbers
        int sum = numbers.stream()
            .reduce(0, Integer::sum);         // Terminal operation: reduces to single value
        
        System.out.println("Sum: " + sum);    // Output: 55
        
        // Parallel stream
        List<Integer> parallelResult = numbers.parallelStream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        
        System.out.println("Numbers > 5: " + parallelResult); // Output: [6, 7, 8, 9, 10]
    }
}
```

---

## <a name="java-9"></a>Java 9 Features & Questions

### Q3: Explain the Java Platform Module System (JPMS)

**Answer:**
JPMS (Project Jigsaw) introduces modules to Java, providing strong encapsulation and reliable configuration. A module is a group of packages with a module descriptor (module-info.java).

```java
// module-info.java - Module descriptor
module com.example.myapp {
    requires java.base;           // Implicitly required
    requires java.sql;            // Requires SQL module
    requires transitive com.utils; // Transitive dependency
    exports com.example.api;      // Exports package
    opens com.example.internal;   // Opens for reflection
}

// Using modules
public class ModuleExample {
    public static void main(String[] args) {
        // Before Java 9 - Classpath hell
        // After Java 9 - Module path with explicit dependencies
        
        Module module = ModuleExample.class.getModule();
        System.out.println("Module name: " + module.getName()); // Output: com.example.myapp
    }
}
```

**Advantages:**
1. Strong encapsulation: Internal APIs are hidden
2. Reliable configuration: Explicit dependencies
3. Smaller runtime: Custom JRE with only required modules
4. Better security: Reduced attack surface

### Q4: What are Factory Methods for Collections?

**Answer:**
Java 9 introduced factory methods to create immutable collections easily.

```java
import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionFactoryExample {
    public static void main(String[] args) {
        // Before Java 9 - Verbose
        List<String> oldList = Arrays.asList("A", "B", "C");
        
        // Java 9 - Factory methods
        List<String> newList = List.of("A", "B", "C");
        Set<String> newSet = Set.of("A", "B", "C");
        Map<String, Integer> newMap = Map.of("A", 1, "B", 2, "C", 3);
        
        // Map with more than 10 entries
        Map<String, Integer> bigMap = Map.ofEntries(
            Map.entry("A", 1),
            Map.entry("B", 2),
            Map.entry("C", 3),
            Map.entry("D", 4)
        );
        
        System.out.println("List: " + newList);   // Output: [A, B, C]
        System.out.println("Set: " + newSet);     // Output: [A, B, C] (order may vary)
        System.out.println("Map: " + newMap);     // Output: {A=1, B=2, C=3}
        
        // These collections are immutable
        // newList.add("D"); // Throws UnsupportedOperationException
    }
}
```

---

## <a name="java-10"></a>Java 10 Features & Questions

### Q5: Explain Local Variable Type Inference (var)

**Answer:**
The `var` keyword allows local variable type inference, reducing boilerplate while maintaining static typing.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VarExample {
    public static void main(String[] args) {
        // Before Java 10 - Explicit types
        String explicitString = "Hello";
        List<String> explicitList = new ArrayList<>();
        Map<String, List<Integer>> explicitMap = new HashMap<>();
        
        // Java 10 - Type inference with var
        var inferredString = "Hello";                    // Inferred as String
        var inferredList = new ArrayList<String>();      // Inferred as ArrayList<String>
        var inferredMap = new HashMap<String, List<Integer>>(); // Inferred as HashMap<String, List<Integer>>
        
        // Valid uses
        var numbers = List.of(1, 2, 3, 4, 5);           // Inferred as List<Integer>
        var stream = numbers.stream();                  // Inferred as Stream<Integer>
        var sum = numbers.stream().mapToInt(n -> n).sum(); // Inferred as int
        
        System.out.println("String: " + inferredString); // Output: Hello
        System.out.println("Sum: " + sum);               // Output: 15
        
        // Invalid uses (compile-time errors)
        // var nullVar = null;           // Cannot infer type
        // var lambda = () -> "Hello";   // Cannot infer functional interface
        // var array = {1, 2, 3};        // Array initializer needs explicit type
        
        // var can be used in for-loops
        for (var number : numbers) {
            System.out.println(number); // Output: 1 2 3 4 5
        }
    }
}
```

**Restrictions:**
1. Can only be used for local variables
2. Cannot be used for method parameters, return types, or fields
3. Must be initialized immediately
4. Cannot be reassigned with different type

---

## <a name="java-11"></a>Java 11 Features & Questions

### Q6: What New String Methods Were Introduced in Java 11?

**Answer:**
Java 11 added several useful methods to the String class.

```java
public class StringMethodsExample {
    public static void main(String[] args) {
        String text = "  Hello World!  ";
        String multiline = "Line 1\nLine 2\nLine 3";
        String repeated = "Java ";
        
        // strip() - Removes whitespace from both ends (Unicode-aware)
        System.out.println("strip(): '" + text.strip() + "'"); 
        // Output: 'Hello World!'
        
        // stripLeading() and stripTrailing()
        System.out.println("stripLeading(): '" + text.stripLeading() + "'");
        // Output: 'Hello World!  '
        System.out.println("stripTrailing(): '" + text.stripTrailing() + "'");
        // Output: '  Hello World!'
        
        // isBlank() - Checks if string is empty or contains only whitespace
        System.out.println("isBlank(): " + "   ".isBlank()); // Output: true
        System.out.println("isEmpty(): " + "   ".isEmpty()); // Output: false
        
        // lines() - Returns stream of lines
        multiline.lines()
            .forEach(line -> System.out.println("Line: " + line));
        // Output: 
        // Line: Line 1
        // Line: Line 2  
        // Line: Line 3
        
        // repeat() - Repeats string n times
        System.out.println("repeat(3): " + repeated.repeat(3));
        // Output: Java Java Java 
    }
}
```

### Q7: What is the HTTP Client API in Java 11?

**Answer:**
Java 11 introduced a new HTTP Client API that supports HTTP/1.1 and HTTP/2, replacing the old HttpURLConnection.

```java
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        // Create HttpClient
        HttpClient client = HttpClient.newBuilder()
            .version(Version.HTTP_2)           // Use HTTP/2
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
        
        // Create request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/google"))
            .header("Accept", "application/json")
            .timeout(Duration.ofSeconds(5))
            .GET()                             // GET request
            .build();
        
        // Synchronous request
        HttpResponse<String> response = client.send(
            request, 
            HttpResponse.BodyHandlers.ofString()
        );
        
        System.out.println("Status Code: " + response.statusCode()); // Output: 200
        System.out.println("Headers: " + response.headers().map());
        System.out.println("Body length: " + response.body().length());
        
        // Asynchronous request
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(
            request,
            HttpResponse.BodyHandlers.ofString()
        );
        
        future.thenApply(HttpResponse::body)
              .thenAccept(body -> System.out.println("Async body received: " + body.length()))
              .join(); // Wait for completion
    }
}
```

**Advantages over HttpURLConnection:**
1. Modern API design (builder pattern)
2. HTTP/2 support
3. Better performance
4. Asynchronous support
5. WebSocket support

---

## <a name="java-12-16"></a>Java 12-16 Features & Questions

### Q8: What are Records (Java 14/16) and How Do They Reduce Boilerplate?

**Answer:**
Records are transparent data carriers that automatically generate constructors, getters, equals(), hashCode(), and toString() methods.

```java
// Before Records - Verbose class
public class PersonOld {
    private final String name;
    private final int age;
    
    public PersonOld(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override
    public boolean equals(Object o) { /* boilerplate */ }
    @Override
    public int hashCode() { /* boilerplate */ }
    @Override
    public String toString() { /* boilerplate */ }
}

// With Records (Java 16) - Concise
public record Person(String name, int age) {
    // Compact constructor for validation
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
    }
    
    // Custom methods can be added
    public boolean isAdult() {
        return age >= 18;
    }
}

public class RecordExample {
    public static void main(String[] args) {
        // Creating record instance
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        Person person3 = new Person("Alice", 25);
        
        // Auto-generated methods
        System.out.println(person1);           // Output: Person[name=Alice, age=25]
        System.out.println("Name: " + person1.name()); // Getter (no 'get' prefix)
        System.out.println("Age: " + person1.age());
        System.out.println("Equals: " + person1.equals(person3)); // Output: true
        System.out.println("HashCode: " + person1.hashCode());
        System.out.println("Is Adult: " + person1.isAdult()); // Output: true
        
        // Records are immutable
        // person1.name = "Charlie"; // Compile error - records are final
        
        // Pattern matching with records (Java 16+)
        if (person1 instanceof Person p) {
            System.out.println("Pattern matched: " + p.name());
        }
    }
}
```

**Key Points:**
1. Records are final classes
2. All fields are private final
3. Automatically generates canonical constructor
4. Components are accessed via `component()` not `getComponent()`
5. Can implement interfaces but cannot extend classes

### Q9: Describe Sealed Classes (Java 15/17)

**Answer:**
Sealed classes restrict which classes can extend them, providing controlled inheritance hierarchies and enhancing type safety.

```java
// Sealed class declaration
public sealed class Shape 
    permits Circle, Rectangle, Triangle {  // Explicitly permits these subclasses
    private final String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public String getColor() { return color; }
    public abstract double area();
}

// Permitted subclasses must be final, sealed, or non-sealed
public final class Circle extends Shape {
    private final double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public non-sealed class Rectangle extends Shape {
    private final double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() {
        return width * height;
    }
}

// Non-sealed classes can have further subclasses
public class Square extends Rectangle {
    public Square(String color, double side) {
        super(color, side, side);
    }
}

public sealed class Triangle extends Shape permits EquilateralTriangle {
    protected final double base, height;
    
    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

public final class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(String color, double side) {
        super(color, side, side * Math.sqrt(3) / 2);
    }
}

public class SealedClassExample {
    public static double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream()
            .mapToDouble(Shape::area)
            .sum();
    }
    
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Square("Green", 3.0),
            new EquilateralTriangle("Yellow", 4.0)
        );
        
        double totalArea = calculateTotalArea(shapes);
        System.out.println("Total Area: " + totalArea);
        
        // Pattern matching with sealed classes (Java 17)
        for (Shape shape : shapes) {
            String description = switch (shape) {
                case Circle c -> "Circle with radius " + // Pattern variable c
                    c.area() + " area";
                case Rectangle r -> "Rectangle with area " + r.area();
                case Square s -> "Square with area " + s.area();
                case Triangle t -> "Triangle with area " + t.area();
                // No default needed - exhaustive with sealed classes
            };
            System.out.println(description);
        }
    }
}
```

**Benefits:**
1. Controlled inheritance hierarchy
2. Exhaustive pattern matching without default case
3. Better domain modeling
4. Compile-time safety

---

## <a name="java-17"></a>Java 17 Features & Questions

### Q10: What is Pattern Matching for switch (Preview in Java 17, Final in Java 21)?

**Answer:**
Pattern matching for switch extends switch expressions to work with patterns, including type patterns, and allows more complex conditions.

```java
public class PatternMatchingSwitch {
    // Before pattern matching
    public static String oldStyle(Object obj) {
        if (obj instanceof String s) {
            return "String: " + s.toUpperCase();
        } else if (obj instanceof Integer i) {
            return "Integer: " + (i * 2);
        } else if (obj instanceof Double d && d > 0) {
            return "Positive Double: " + d;
        } else {
            return "Unknown: " + obj;
        }
    }
    
    // With pattern matching for switch (Java 17 preview, Java 21 final)
    public static String newStyle(Object obj) {
        return switch (obj) {
            case String s -> "String: " + s.toUpperCase();
            case Integer i -> "Integer: " + (i * 2);
            case Double d when d > 0 -> "Positive Double: " + d;  // Guard condition
            case Double d -> "Non-positive Double: " + d;
            case null -> "Null object";  // Explicit null handling
            case int[] array -> "Array of length: " + array.length;
            default -> "Unknown: " + obj;
        };
    }
    
    // Pattern matching with sealed classes (exhaustive)
    public static String describeShape(Shape shape) {
        return switch (shape) {
            case Circle c -> "Circle with radius area " + c.area();
            case Rectangle r -> "Rectangle area " + r.area();
            case Triangle t -> "Triangle area " + t.area();
            // No default needed - compiler knows it's exhaustive
        };
    }
    
    // Nested patterns (Java 21)
    public static String processObject(Object obj) {
        return switch (obj) {
            case Point(var x, var y) -> "Point at (" + x + ", " + y + ")";
            case Line(Point p1, Point p2) -> "Line from " + p1 + " to " + p2;
            case null, default -> "Unknown";
        };
    }
    
    public static void main(String[] args) {
        System.out.println(newStyle("hello"));      // Output: String: HELLO
        System.out.println(newStyle(42));           // Output: Integer: 84
        System.out.println(newStyle(3.14));         // Output: Positive Double: 3.14
        System.out.println(newStyle(-1.5));         // Output: Non-positive Double: -1.5
        System.out.println(newStyle(null));         // Output: Null object
        System.out.println(newStyle(new int[]{1,2,3})); // Output: Array of length: 3
    }
}

// Supporting records for nested patterns
record Point(int x, int y) {}
record Line(Point start, Point end) {}
```

### Q11: What are the New Features in Java 17 Regarding Security and Performance?

**Answer:**
Java 17 introduced several security and performance enhancements:

```java
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Java17Features {
    public static void main(String[] args) {
        // 1. Enhanced Pseudo-Random Number Generators
        RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");
        System.out.println("Random number: " + rng.nextInt());
        
        // List all available algorithms
        RandomGeneratorFactory.all()
            .map(f -> f.name() + ": " + f.group())
            .sorted()
            .forEach(System.out::println);
        
        // 2. Strong encapsulation of internal APIs
        // sun.misc.*, com.sun.* are strongly encapsulated
        // Use --add-opens to access if needed
        
        // 3. New macOS rendering pipeline
        // Uses Apple Metal API instead of deprecated OpenGL
        
        // 4. Foreign Function & Memory API (Incubator)
        // Enables Java to interoperate with native code
    }
}
```

---

## <a name="java-18-21"></a>Java 18-21 Features & Questions

### Q12: What are Virtual Threads (Java 21)?

**Answer:**
Virtual threads are lightweight threads managed by the JVM, not the OS, enabling massive concurrency with minimal overhead.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class VirtualThreadsExample {
    // Traditional platform threads (heavyweight)
    public static void platformThreads() throws Exception {
        try (var executor = Executors.newFixedThreadPool(100)) {
            for (int i = 0; i < 10_000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000); // Simulate I/O
                        System.out.println("Task " + taskId + " completed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
    
    // Virtual threads (lightweight)
    public static void virtualThreads() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000); // Simulate I/O
                        System.out.println("Virtual task " + taskId + " completed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
    
    // Structured Concurrency (Java 21)
    public static String fetchUserData() throws Exception {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Subtask<String> userSubtask = scope.fork(() -> fetchUser());
            Subtask<String> orderSubtask = scope.fork(() -> fetchOrders());
            Subtask<String> prefSubtask = scope.fork(() -> fetchPreferences());
            
            scope.join();           // Wait for all subtasks
            scope.throwIfFailed();  // Propagate exception if any
            
            return String.format("User: %s, Orders: %s, Prefs: %s",
                userSubtask.get(), orderSubtask.get(), prefSubtask.get());
        }
    }
    
    private static String fetchUser() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        return "John Doe";
    }
    
    private static String fetchOrders() {
        try { Thread.sleep(200); } catch (InterruptedException e) {}
        return "5 orders";
    }
    
    private static String fetchPreferences() {
        try { Thread.sleep(150); } catch (InterruptedException e) {}
        return "Dark mode";
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Platform Threads (Limited) ===");
        long start = System.currentTimeMillis();
        platformThreads();
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
        
        System.out.println("\n=== Virtual Threads (Scalable) ===");
        start = System.currentTimeMillis();
        virtualThreads();
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
        
        System.out.println("\n=== Structured Concurrency ===");
        String result = fetchUserData();
        System.out.println("Result: " + result);
    }
}
```

**Key Differences:**
| Aspect | Platform Threads | Virtual Threads |
|--------|-----------------|-----------------|
| **Cost** | ~1MB stack, expensive | ~200 bytes, cheap |
| **Creation** | Slow (OS resource) | Fast (JVM managed) |
| **Concurrency** | Thousands limit | Millions possible |
| **Blocking Cost** | High (OS thread blocked) | Low (carrier thread reused) |
| **Use Case** | CPU-intensive tasks | I/O-bound tasks |

### Q13: What are Sequenced Collections in Java 21?

**Answer:**
Sequenced collections provide a defined encounter order with convenient methods for accessing first and last elements.

```java
import java.util.*;

public class SequencedCollectionsExample {
    public static void main(String[] args) {
        // SequencedCollection (List, Deque implementations)
        SequencedCollection<String> list = new ArrayList<>();
        list.add("B");
        list.addFirst("A");    // New method: addFirst
        list.addLast("C");     // New method: addLast
        
        System.out.println("First: " + list.getFirst());   // Output: A
        System.out.println("Last: " + list.getLast());     // Output: C
        System.out.println("Reversed: " + list.reversed()); // Output: [C, B, A]
        
        // SequencedSet (LinkedHashSet, TreeSet)
        SequencedSet<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.addFirst(1);
        set.addLast(3);
        
        System.out.println("\nSet first: " + set.getFirst()); // Output: 1
        System.out.println("Set last: " + set.getLast());     // Output: 3
        
        // SequencedMap (LinkedHashMap)
        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        map.put("B", 2);
        map.putFirst("A", 1);      // New method
        map.putLast("C", 3);       // New method
        
        System.out.println("\nMap first entry: " + map.firstEntry()); // A=1
        System.out.println("Map last entry: " + map.lastEntry());     // C=3
        System.out.println("Reversed map: " + map.reversed());        // {C=3, B=2, A=1}
        
        // Poll methods (remove and return)
        System.out.println("\nPoll first from list: " + list.pollFirst()); // A
        System.out.println("Poll last from list: " + list.pollLast());     // C
        System.out.println("Remaining list: " + list);                     // [B]
    }
}
```

---

## <a name="migration"></a>Migration Strategy & Challenges

### Q14: Why migrate from Java 8 to Java 21?

**Answer:**
1. **Performance**: 2-10x performance improvements in various areas
2. **Security**: Modern security features and patches
3. **Productivity**: New language features reduce boilerplate
4. **Maintainability**: Better APIs and tooling
5. **Cost**: Free LTS versions (Oracle JDK 17+ requires license for commercial use)
6. **Support**: Java 8 extended support ended in 2030, but early migration recommended

### Q15: What are the key considerations before starting migration?

**Answer:**
1. **Dependencies**: Check third-party library compatibility
2. **Build Tools**: Update Maven/Gradle plugins
3. **CI/CD Pipeline**: Update JDK versions in pipelines
4. **Testing**: Comprehensive test suite for regression testing
5. **Incremental Migration**: Consider multi-release JARs
6. **Tooling**: Use jdeps, jdeprscan, and jlink tools

### Q16: Can Java 8 code run on Java 21 JDK without recompilation?

**Answer:**
Mostly yes, due to backward compatibility, but there are exceptions:

```java
// Example of potential incompatibility
public class CompatibilityExample {
    // 1. Removed APIs - Will fail at runtime
    // sun.misc.BASE64Encoder - Use java.util.Base64 instead
    
    // 2. Strong encapsulation - May fail if using internal APIs
    // sun.misc.Unsafe - Use VarHandle or other alternatives
    
    // 3. Behavioral changes
    public static void main(String[] args) {
        // TLS 1.0/1.1 disabled by default in Java 21
        // System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
        
        // New reserved keywords
        // var, yield, sealed, permits, non-sealed, record
        
        // Check compatibility
        System.out.println("Java Version: " + System.getProperty("java.version"));
        
        // Use jdeps to check dependencies
        // jdeps --jdk-internals your-application.jar
    }
}
```

**Migration Steps:**
1. Compile with Java 8 target
2. Run on Java 21 with `--illegal-access=warn`
3. Fix warnings incrementally
4. Recompile with Java 21
5. Use multi-release JARs for gradual migration

### Q17: What are potential runtime issues when migrating?

**Answer:**
1. **Module System Conflicts**: Automatic modules, split packages
2. **Removed APIs**: Nashorn JavaScript Engine, CORBA, Java EE modules
3. **Security Manager**: Deprecated in Java 17, may be removed
4. **Reflection Changes**: Strong encapsulation limits reflection
5. **Behavioral Changes**: TLS defaults, date formatting, GC changes

```java
// Common migration issues and solutions
public class MigrationIssues {
    // Issue 1: Using removed API
    public void removedAPI() {
        // Java 8 - Using sun.misc.BASE64Encoder
        // sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        // String encoded = encoder.encode(data);
        
        // Java 21 - Use java.util.Base64
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        // String encoded = encoder.encodeToString(data);
    }
    
    // Issue 2: Reflection on internal classes
    public void reflectionIssue() throws Exception {
        // Java 8 - Allowed
        // Class<?> clazz = Class.forName("sun.misc.Unsafe");
        
        // Java 21 - Requires --add-opens
        // Add to JVM args: --add-opens java.base/jdk.internal.misc=ALL-UNNAMED
    }
    
    // Issue 3: Date formatting locale differences
    public void localeIssue() {
        // Behavior may change between versions
        // Always specify locale for consistent behavior
        String date = java.time.LocalDate.now()
            .format(java.time.format.DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .withLocale(Locale.US));
    }
}
```

---

## <a name="coding-scenarios"></a>Coding & Scenario Questions

### Q18: How to refactor Java 8 code to use modern features?

**Answer:**

```java
// Before - Java 8 style
public class LegacyCode {
    public void processUsers(List<User> users) {
        // Resource handling without try-with-resources
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Complex null checks
                if (users != null) {
                    for (User user : users) {
                        if (user != null && user.getName() != null) {
                            if (user.getAge() > 18) {
                                System.out.println(user.getName());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// After - Modern Java (17/21)
public class ModernCode {
    public void processUsers(List<User> users) {
        // 1. Try-with-resources (Java 7+)
        try (var reader = Files.newBufferedReader(Path.of("data.txt"))) {
            reader.lines()
                .forEach(line -> processLine(line, users));
        } catch (IOException e) {
            // Better exception handling
            throw new UncheckedIOException("Failed to read file", e);
        }
    }
    
    private void processLine(String line, List<User> users) {
        // 2. Optional and Stream API for null safety
        Optional.ofNullable(users)
            .orElseGet(Collections::emptyList)
            .stream()
            .filter(Objects::nonNull)
            // 3. Pattern matching for instanceof
            .filter(user -> user instanceof PremiumUser pu && pu.isActive())
            .map(User::getName)
            .filter(Objects::nonNull)
            // 4. Method references
            .forEach(System.out::println);
    }
    
    // 5. Records instead of POJOs
    public record User(String name, int age, Address address) {}
    public record Address(String street, String city) {}
    
    // 6. Sealed classes for type hierarchy
    public sealed interface Account permits Savings, Checking, Investment {}
    public final class Savings implements Account {}
    public final class Checking implements Account {}
    public non-sealed class Investment implements Account {}
}
```

### Q19: How to use virtual threads for legacy applications?

**Answer:**

```java
public class VirtualThreadMigration {
    private final ExecutorService legacyExecutor = 
        Executors.newFixedThreadPool(100); // Legacy thread pool
    
    // Legacy implementation
    public CompletableFuture<Void> processLegacy(List<Task> tasks) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        
        for (Task task : tasks) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                // I/O bound task
                try {
                    Thread.sleep(100); // Simulate I/O
                    task.execute();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, legacyExecutor);
            
            futures.add(future);
        }
        
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }
    
    // Modern implementation with virtual threads
    public CompletableFuture<Void> processModern(List<Task> tasks) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<CompletableFuture<Void>> futures = tasks.stream()
                .map(task -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(100); // I/O bound - perfect for virtual threads
                        task.execute();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }, executor))
                .toList();
            
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        }
    }
    
    // Gradual migration - wrapper pattern
    public ExecutorService createMigratedExecutor(boolean useVirtualThreads) {
        if (useVirtualThreads) {
            return Executors.newVirtualThreadPerTaskExecutor();
        } else {
            return Executors.newThreadPerTaskExecutor(
                Thread.ofVirtual().factory()
            );
        }
    }
    
    // Structured concurrency for complex workflows
    public UserProfile fetchUserProfile(String userId) throws Exception {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userTask = scope.fork(() -> fetchUser(userId));
            var ordersTask = scope.fork(() -> fetchOrders(userId));
            var preferencesTask = scope.fork(() -> fetchPreferences(userId));
            
            scope.join();
            scope.throwIfFailed();
            
            return new UserProfile(
                userTask.get(),
                ordersTask.get(),
                preferencesTask.get()
            );
        }
    }
    
    // Helper methods
    private User fetchUser(String userId) { /* ... */ return null; }
    private List<Order> fetchOrders(String userId) { /* ... */ return null; }
    private Preferences fetchPreferences(String userId) { /* ... */ return null; }
    
    // Record for result
    record UserProfile(User user, List<Order> orders, Preferences prefs) {}
    
    class Task {
        void execute() { /* task logic */ }
    }
}
```

### Q20: How to use pattern matching with complex conditions?

**Answer:**

```java
public class PatternMatchingComplex {
    // Complex object hierarchy
    interface Expression {}
    record Constant(int value) implements Expression {}
    record Variable(String name) implements Expression {}
    record Add(Expression left, Expression right) implements Expression {}
    record Multiply(Expression left, Expression right) implements Expression {}
    record Negate(Expression expr) implements Expression {}
    
    // Before - Complex instanceof chains
    public static int evaluateOld(Expression expr, Map<String, Integer> context) {
        if (expr instanceof Constant c) {
            return c.value();
        } else if (expr instanceof Variable v) {
            return context.getOrDefault(v.name(), 0);
        } else if (expr instanceof Add a) {
            return evaluateOld(a.left(), context) + evaluateOld(a.right(), context);
        } else if (expr instanceof Multiply m) {
            return evaluateOld(m.left(), context) * evaluateOld(m.right(), context);
        } else if (expr instanceof Negate n) {
            return -evaluateOld(n.expr(), context);
        } else {
            throw new IllegalArgumentException("Unknown expression: " + expr);
        }
    }
    
    // After - Pattern matching with switch
    public static int evaluateNew(Expression expr, Map<String, Integer> context) {
        return switch (expr) {
            case Constant c -> c.value();
            case Variable v -> context.getOrDefault(v.name(), 0);
            case Add a -> evaluateNew(a.left(), context) + evaluateNew(a.right(), context);
            case Multiply m -> evaluateNew(m.left(), context) * evaluateNew(m.right(), context);
            case Negate n -> -evaluateNew(n.expr(), context);
            // No default needed for sealed hierarchy
        };
    }
    
    // Nested patterns (Java 21)
    public static String describeExpression(Expression expr) {
        return switch (expr) {
            case Constant(var value) -> "Constant: " + value;
            case Variable(var name) -> "Variable: " + name;
            case Add(var left, var right) -> 
                "Add: " + describeExpression(left) + " + " + describeExpression(right);
            case Multiply(Constant c, Variable v) -> 
                "Multiply constant " + c.value() + " with variable " + v.name();
            case Multiply(var left, var right) ->
                "Multiply: " + describeExpression(left) + " * " + describeExpression(right);
            case Negate(var inner) -> "Negate: " + describeExpression(inner);
        };
    }
    
    // Pattern matching with guards
    public static String analyzeExpression(Expression expr) {
        return switch (expr) {
            case Constant c when c.value() > 100 -> "Large constant: " + c.value();
            case Constant c when c.value() < 0 -> "Negative constant: " + c.value();
            case Constant c -> "Small constant: " + c.value();
            case Add(Constant c, Variable v) when c.value() == 0 -> 
                "Adding zero to variable: " + v.name();
            case Add(Constant c, Variable v) -> 
                "Adding " + c.value() + " to variable: " + v.name();
            case null -> "Null expression";
            default -> "Complex expression";
        };
    }
    
    public static void main(String[] args) {
        Expression expr = new Add(
            new Constant(5),
            new Multiply(new Constant(2), new Variable("x"))
        );
        
        Map<String, Integer> context = Map.of("x", 10);
        
        System.out.println("Result: " + evaluateNew(expr, context)); // Output: 25
        System.out.println("Description: " + describeExpression(expr));
        // Output: Add: Constant: 5 + Multiply: Constant: 2 * Variable: x
    }
}
```

---

## <a name="references"></a>References

### Official Documentation
1. [Oracle Java Documentation](https://docs.oracle.com/javase/)
2. [JDK Release Notes](https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html)
3. [Java Language Updates](https://openjdk.org/projects/jdk/)

### Migration Guides
4. [Migrating from Java 8 to Java 11](https://openjdk.org/projects/jdk/11/migration-guide/)
5. [Migrating from Java 11 to Java 17](https://openjdk.org/projects/jdk/17/migration-guide/)
6. [Migrating from Java 17 to Java 21](https://openjdk.org/projects/jdk/21/migration-guide/)

### Tools
7. [jdeps - Java Dependency Analysis Tool](https://docs.oracle.com/javase/9/tools/jdeps.htm)
8. [jdeprscan - Deprecated API Scanner](https://docs.oracle.com/javase/9/tools/jdeprscan.htm)
9. [jlink - Java Runtime Creator](https://docs.oracle.com/javase/9/tools/jlink.htm)

### Community Resources
10. [OpenJDK Project](https://openjdk.org/)
11. [Java Community Process](https://jcp.org/)
12. [Stack Overflow - Java Tags](https://stackoverflow.com/questions/tagged/java)

### Books
13. "Effective Java" by Joshua Bloch
14. "Java Concurrency in Practice" by Brian Goetz
15. "Modern Java in Action" by Raoul-Gabriel Urma

---

## Best Practices for Interview Preparation

1. **Understand Fundamentals**: Ensure strong grasp of OOP, collections, exceptions
2. **Version-Specific Features**: Know what was introduced in each version
3. **Migration Experience**: Be prepared to discuss real migration challenges
4. **Code Examples**: Practice writing clean, modern Java code
5. **Performance Implications**: Understand trade-offs of new features
6. **Tooling**: Familiarize with modern Java development tools

## Quick Revision Cheat Sheet

### Java 8
- Lambda Expressions: `(a, b) -> a + b`
- Stream API: `stream().filter().map().collect()`
- Optional: `Optional.ofNullable(value)`
- Method References: `String::toUpperCase`
- Default Methods in Interfaces
- New Date/Time API: `LocalDate`, `LocalTime`, `Instant`

### Java 11
- Local Variable Type Inference: `var list = new ArrayList<String>()`
- HTTP Client API: `HttpClient.newHttpClient()`
- New String Methods: `isBlank()`, `lines()`, `repeat()`
- Launch Single-File Programs: `java HelloWorld.java`
- Flight Recorder (JFR): Low-overhead profiling

### Java 17
- Sealed Classes: `sealed class Shape permits Circle, Rectangle`
- Pattern Matching: `switch` with type patterns
- Records: `record Point(int x, int y)`
- Strong Encapsulation: Internal APIs hidden
- Foreign Function & Memory API (Incubator)

### Java 21
- Virtual Threads: `Thread.startVirtualThread(() -> {})`
- Structured Concurrency: `StructuredTaskScope`
- Sequenced Collections: `getFirst()`, `getLast()`, `reversed()`
- Record Patterns: `case Point(var x, var y)`
- Pattern Matching Final: Exhaustive switches
- String Templates (Preview): `STR."Hello \{name}"`

---

*Last Updated: Java 21 (LTS)*  
*Note: Features marked as "Preview" may change in future releases*  
*Always check official documentation for the most current information*