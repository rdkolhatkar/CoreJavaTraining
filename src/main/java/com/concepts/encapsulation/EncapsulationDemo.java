package com.concepts.encapsulation;

/*
 * ================================================================
 *                 ENCAPSULATION IN JAVA
 * ================================================================
 *
 * This is a COMPLETE runnable example of Encapsulation in Java.
 *
 * You can save this file as:
 *
 *     EncapsulationDemo.java
 *
 * and run it directly.
 *
 * ================================================================
 *
 * WHAT IS ENCAPSULATION?
 *
 * Encapsulation means:
 *
 *     1. Bundling DATA (variables/fields)
 *        and
 *        BEHAVIOR (methods)
 *        together inside a class.
 *
 *     2. Restricting direct access to the internal state of
 *        an object.
 *
 *     3. Providing controlled access through methods.
 *
 * In simple words:
 *
 *     "Hide the internal implementation and expose only what
 *      is necessary."
 *
 *
 * Example:
 *
 *     BankAccount
 *
 *     balance should NOT be directly accessible:
 *
 *         account.balance = -50000;   // BAD
 *
 *     Instead:
 *
 *         account.deposit(1000);
 *         account.withdraw(500);
 *         account.getBalance();
 *
 * The class controls HOW its data can be changed.
 *
 * ================================================================
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EncapsulationDemo {

    /*
     * ============================================================
     * 1. BASIC EXAMPLE OF ENCAPSULATION
     * ============================================================
     *
     * The simplest way to implement encapsulation is:
     *
     *     private fields
     *     +
     *     public methods
     *
     * The fields cannot be accessed directly from outside
     * the class.
     */

    static class Student {

        // private = DATA HIDING
        //
        // These variables cannot be directly accessed from
        // outside the Student class.
        private String name;
        private int age;

        /*
         * Getter
         *
         * A getter is used to READ private data.
         */
        public String getName() {
            return name;
        }

        /*
         * Setter
         *
         * A setter is used to MODIFY private data.
         */
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    /*
     * ============================================================
     * 2. WHY DATA HIDING IS IMPORTANT
     * ============================================================
     *
     * Without encapsulation:
     *
     *     student.age = -100;
     *
     * There is nothing stopping the caller from putting invalid
     * data into the object.
     *
     * With encapsulation:
     *
     *     setAge()
     *
     * can validate the value before storing it.
     */

    static class ValidatedStudent {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {

            // Validation is possible because the field is private.
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Name cannot be empty"
                );
            }

            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {

            // Business rule:
            // Student age must be between 1 and 120.
            if (age <= 0 || age > 120) {
                throw new IllegalArgumentException(
                        "Age must be between 1 and 120"
                );
            }

            this.age = age;
        }
    }


    /*
     * ============================================================
     * 3. ENCAPSULATION USING CONSTRUCTORS
     * ============================================================
     *
     * Sometimes we don't want an object to be created with
     * invalid data.
     *
     * Instead of:
     *
     *     Student student = new Student();
     *     student.setAge(-10);
     *
     * We can force valid data during object creation.
     */

    static class Employee {

        private final int id;
        private String name;
        private double salary;

        /*
         * Constructor controls how the object is initialized.
         */
        public Employee(int id, String name, double salary) {

            if (id <= 0) {
                throw new IllegalArgumentException(
                        "Employee ID must be positive"
                );
            }

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Employee name cannot be empty"
                );
            }

            if (salary < 0) {
                throw new IllegalArgumentException(
                        "Salary cannot be negative"
                );
            }

            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        /*
         * Notice:
         *
         * There is NO setId().
         *
         * ID is final and cannot be changed after construction.
         *
         * This is stronger encapsulation.
         */

        public void increaseSalary(double percentage) {

            if (percentage <= 0) {
                throw new IllegalArgumentException(
                        "Percentage must be greater than zero"
                );
            }

            salary = salary + (salary * percentage / 100);
        }
    }


    /*
     * ============================================================
     * 4. ENCAPSULATION IS NOT JUST GETTERS AND SETTERS
     * ============================================================
     *
     * This is a VERY IMPORTANT interview concept.
     *
     * Many beginners think:
     *
     *     Encapsulation = private + getters/setters
     *
     * Not exactly.
     *
     * The real purpose is:
     *
     *     Protect object state
     *     +
     *     Control how the state changes
     *     +
     *     Hide implementation details
     *
     * Therefore, sometimes we should NOT provide setters.
     *
     * Example:
     *
     * BankAccount
     */

    static class BankAccount {

        private final String accountNumber;

        // Private state.
        private double balance;

        public BankAccount(String accountNumber, double initialBalance) {

            if (accountNumber == null || accountNumber.isBlank()) {
                throw new IllegalArgumentException(
                        "Account number cannot be empty"
                );
            }

            if (initialBalance < 0) {
                throw new IllegalArgumentException(
                        "Initial balance cannot be negative"
                );
            }

            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        /*
         * Getter allows READ access.
         */
        public double getBalance() {
            return balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        /*
         * Notice:
         *
         * We do NOT have:
         *
         *     setBalance()
         *
         * Why?
         *
         * Because this would be dangerous:
         *
         *     account.setBalance(-50000);
         *
         * Instead, we expose BUSINESS OPERATIONS.
         */

        public void deposit(double amount) {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Deposit amount must be greater than zero"
                );
            }

            balance += amount;
        }

        public void withdraw(double amount) {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Withdrawal amount must be greater than zero"
                );
            }

            if (amount > balance) {
                throw new IllegalArgumentException(
                        "Insufficient balance"
                );
            }

            balance -= amount;
        }
    }


    /*
     * ============================================================
     * 5. ACCESS MODIFIERS AND ENCAPSULATION
     * ============================================================
     *
     * Java provides four important access levels:
     *
     *     private
     *     default/package-private
     *     protected
     *     public
     *
     * private:
     *     Accessible only inside the same class.
     *
     * default:
     *     Accessible inside the same package.
     *
     * protected:
     *     Accessible inside the same package and subclasses.
     *
     * public:
     *     Accessible from anywhere.
     *
     * For strong encapsulation, fields are normally:
     *
     *     private
     *
     * and controlled methods are exposed.
     */

    static class AccessModifierExample {

        private String privateData;

        String packageData;

        protected String protectedData;

        public String publicData;

        public AccessModifierExample() {

            privateData = "Private";
            packageData = "Package";
            protectedData = "Protected";
            publicData = "Public";
        }

        public String getPrivateData() {
            return privateData;
        }
    }


    /*
     * ============================================================
     * 6. IMMUTABLE CLASS
     * ============================================================
     *
     * Encapsulation can be taken further by creating an
     * IMMUTABLE object.
     *
     * Immutable means:
     *
     *     Once the object is created,
     *     its state cannot be changed.
     *
     * Common examples from Java:
     *
     *     String
     *     Integer
     *     Long
     *     BigDecimal
     *
     * Typical rules for an immutable class:
     *
     *     1. Make class final.
     *     2. Make fields private.
     *     3. Make fields final.
     *     4. Initialize fields through constructor.
     *     5. Don't provide setters.
     *     6. If fields are mutable objects, use defensive copies.
     */

    static final class ImmutableEmployee {

        private final int id;
        private final String name;
        private final double salary;

        public ImmutableEmployee(
                int id,
                String name,
                double salary
        ) {

            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        /*
         * No setters.
         *
         * Once created:
         *
         * ImmutableEmployee employee =
         *      new ImmutableEmployee(1, "John", 50000);
         *
         * employee.setSalary(60000);
         *
         * is impossible because setSalary() doesn't exist.
         */
    }


    /*
     * ============================================================
     * 7. DEFENSIVE COPYING
     * ============================================================
     *
     * This is an ADVANCED encapsulation concept.
     *
     * Suppose a class stores a mutable object such as:
     *
     *     List
     *     Date
     *     ArrayList
     *     HashMap
     *
     * Simply making the field private is NOT always enough.
     *
     * Example:
     *
     *     private List<String> skills;
     *
     * If we return the actual list:
     *
     *     public List<String> getSkills() {
     *         return skills;
     *     }
     *
     * External code can modify our internal state:
     *
     *     employee.getSkills().clear();
     *
     * This breaks encapsulation.
     *
     * Solution:
     *
     *     Defensive copy
     *
     * or
     *
     *     Unmodifiable collection.
     */

    static class EmployeeWithSkills {

        private final List<String> skills;

        public EmployeeWithSkills(List<String> skills) {

            /*
             * Defensive copy during construction.
             *
             * We don't store the caller's original list.
             */
            this.skills = new ArrayList<>(skills);
        }

        public List<String> getSkills() {

            /*
             * Return an unmodifiable view.
             *
             * Caller can READ the list,
             * but cannot modify it.
             */
            return Collections.unmodifiableList(skills);
        }

        public void addSkill(String skill) {

            if (skill == null || skill.isBlank()) {
                throw new IllegalArgumentException(
                        "Skill cannot be empty"
                );
            }

            skills.add(skill);
        }
    }


    /*
     * ============================================================
     * 8. ENCAPSULATING COLLECTIONS
     * ============================================================
     *
     * A common mistake:
     *
     *     private List<String> names;
     *
     * but then:
     *
     *     public List<String> getNames() {
     *         return names;
     *     }
     *
     * This allows external code to modify the list.
     *
     * Better:
     *
     *     return Collections.unmodifiableList(names);
     *
     * Or in modern Java:
     *
     *     List.copyOf(names)
     *
     * depending on whether you need a snapshot or a view.
     */

    static class ShoppingCart {

        private final List<String> products = new ArrayList<>();

        public void addProduct(String product) {

            if (product == null || product.isBlank()) {
                throw new IllegalArgumentException(
                        "Product cannot be empty"
                );
            }

            products.add(product);
        }

        public void removeProduct(String product) {
            products.remove(product);
        }

        public List<String> getProducts() {

            /*
             * Caller gets read-only access.
             */
            return Collections.unmodifiableList(products);
        }

        public int getProductCount() {
            return products.size();
        }
    }


    /*
     * ============================================================
     * 9. ENCAPSULATION + INHERITANCE
     * ============================================================
     *
     * Private fields are NOT directly accessible by subclasses.
     *
     * Example:
     *
     * Parent:
     *
     *     private String name;
     *
     * Child cannot directly do:
     *
     *     name = "John";    // ERROR
     *
     * Instead, the parent can expose controlled methods.
     *
     * This protects the parent's internal state.
     */

    static class Person {

        private String name;

        public Person(String name) {
            setName(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Name cannot be empty"
                );
            }

            this.name = name;
        }
    }


    static class Manager extends Person {

        private String department;

        public Manager(String name, String department) {

            super(name);

            setDepartment(department);
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {

            if (department == null || department.isBlank()) {
                throw new IllegalArgumentException(
                        "Department cannot be empty"
                );
            }

            this.department = department;
        }
    }


    /*
     * ============================================================
     * 10. ENCAPSULATION + ABSTRACTION
     * ============================================================
     *
     * Encapsulation and abstraction are related but different.
     *
     * ENCAPSULATION:
     *
     *     Protect the internal state and implementation.
     *
     * ABSTRACTION:
     *
     *     Expose only essential functionality while hiding
     *     unnecessary implementation details.
     *
     * Example:
     *
     *     BankAccount.deposit()
     *
     * User knows:
     *
     *     deposit(1000)
     *
     * User doesn't need to know:
     *
     *     how balance is stored
     *     how transaction is logged
     *     how database is updated
     *     how validation is performed
     *
     * Those details are encapsulated.
     */

    interface PaymentService {

        void pay(double amount);
    }


    static class CreditCardPayment implements PaymentService {

        private double totalPaid;

        @Override
        public void pay(double amount) {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Payment must be greater than zero"
                );
            }

            /*
             * Internal implementation is hidden.
             */
            processCreditCardPayment(amount);

            totalPaid += amount;
        }

        private void processCreditCardPayment(double amount) {

            System.out.println(
                    "Processing credit card payment: " + amount
            );
        }

        public double getTotalPaid() {
            return totalPaid;
        }
    }


    /*
     * ============================================================
     * 11. ENCAPSULATING BUSINESS RULES
     * ============================================================
     *
     * A good encapsulated class doesn't merely expose its fields.
     *
     * It exposes meaningful operations.
     *
     * BAD:
     *
     *     account.setBalance(account.getBalance() + 1000);
     *
     * GOOD:
     *
     *     account.deposit(1000);
     *
     * The second approach is better because the class itself
     * controls the operation.
     */

    static class Product {

        private final String productCode;
        private String name;
        private double price;

        public Product(
                String productCode,
                String name,
                double price
        ) {

            if (productCode == null || productCode.isBlank()) {
                throw new IllegalArgumentException(
                        "Product code is required"
                );
            }

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Product name is required"
                );
            }

            if (price < 0) {
                throw new IllegalArgumentException(
                        "Price cannot be negative"
                );
            }

            this.productCode = productCode;
            this.name = name;
            this.price = price;
        }

        public String getProductCode() {
            return productCode;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        /*
         * Instead of allowing:
         *
         *     product.setPrice(-100);
         *
         * we expose a controlled operation.
         */

        public void applyDiscount(double percentage) {

            if (percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException(
                        "Discount must be between 0 and 100"
                );
            }

            price = price - (price * percentage / 100);
        }
    }


    /*
     * ============================================================
     * 12. THREAD-SAFE ENCAPSULATION
     * ============================================================
     *
     * Encapsulation also becomes important in multithreaded
     * applications.
     *
     * If multiple threads modify the same object, we need to
     * protect its internal state.
     *
     * synchronized can be used to ensure that only one thread
     * executes the method at a time.
     */

    static class ThreadSafeCounter {

        private int count;

        public synchronized void increment() {

            count++;
        }

        public synchronized int getCount() {

            return count;
        }
    }


    /*
     * ============================================================
     * 13. READ-ONLY ACCESS
     * ============================================================
     *
     * Encapsulation does not require both:
     *
     *     getter
     *     setter
     *
     * We can provide:
     *
     *     getter only
     *
     * when the caller should only be able to read data.
     */

    static class User {

        private final String username;

        public User(String username) {

            if (username == null || username.isBlank()) {
                throw new IllegalArgumentException(
                        "Username is required"
                );
            }

            this.username = username;
        }

        /*
         * Read-only property.
         */
        public String getUsername() {
            return username;
        }

        /*
         * No setter.
         *
         * Username cannot be changed.
         */
    }


    /*
     * ============================================================
     * 14. FULL REAL-WORLD EXAMPLE
     * ============================================================
     *
     * Let's combine multiple encapsulation concepts.
     *
     * This example represents a BankAccount.
     *
     * Concepts used:
     *
     *     - private fields
     *     - final field
     *     - constructor validation
     *     - getter
     *     - no setter for balance
     *     - business methods
     *     - validation
     *     - internal private method
     */

    static class RealWorldBankAccount {

        // Private = cannot be directly accessed externally.
        private final String accountNumber;

        private String accountHolder;

        private double balance;

        public RealWorldBankAccount(
                String accountNumber,
                String accountHolder,
                double initialBalance
        ) {

            validateAccountNumber(accountNumber);
            validateAccountHolder(accountHolder);

            if (initialBalance < 0) {
                throw new IllegalArgumentException(
                        "Initial balance cannot be negative"
                );
            }

            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }

        /*
         * Getters provide controlled READ access.
         */

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public double getBalance() {
            return balance;
        }

        /*
         * Controlled WRITE operation.
         */
        public void changeAccountHolder(String newName) {

            validateAccountHolder(newName);

            this.accountHolder = newName;
        }

        /*
         * Business operation.
         */
        public void deposit(double amount) {

            validateAmount(amount);

            balance += amount;
        }

        /*
         * Business operation.
         */
        public void withdraw(double amount) {

            validateAmount(amount);

            if (amount > balance) {
                throw new IllegalArgumentException(
                        "Insufficient balance"
                );
            }

            balance -= amount;
        }

        /*
         * Private helper methods.
         *
         * These implementation details are hidden from the caller.
         */

        private void validateAmount(double amount) {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Amount must be greater than zero"
                );
            }
        }

        private void validateAccountNumber(String accountNumber) {

            if (accountNumber == null ||
                    accountNumber.isBlank()) {

                throw new IllegalArgumentException(
                        "Account number is required"
                );
            }
        }

        private void validateAccountHolder(String accountHolder) {

            if (accountHolder == null ||
                    accountHolder.isBlank()) {

                throw new IllegalArgumentException(
                        "Account holder is required"
                );
            }
        }
    }


    /*
     * ============================================================
     *                      MAIN METHOD
     * ============================================================
     *
     * Everything above can be tested from this main method.
     */

    public static void main(String[] args) {

        System.out.println(
                "================================================"
        );

        System.out.println(
                "        ENCAPSULATION IN JAVA DEMO"
        );

        System.out.println(
                "================================================"
        );


        /*
         * ========================================================
         * BASIC ENCAPSULATION
         * ========================================================
         */

        System.out.println("\n1. BASIC ENCAPSULATION");

        Student student = new Student();

        student.setName("Rahul");
        student.setAge(25);

        System.out.println(
                "Student Name: " + student.getName()
        );

        System.out.println(
                "Student Age: " + student.getAge()
        );

        /*
         * This would NOT compile:
         *
         * student.age = -100;
         *
         * because age is private.
         */


        /*
         * ========================================================
         * VALIDATION
         * ========================================================
         */

        System.out.println("\n2. ENCAPSULATION + VALIDATION");

        ValidatedStudent validatedStudent =
                new ValidatedStudent();

        validatedStudent.setName("Amit");
        validatedStudent.setAge(25);

        System.out.println(
                "Name: " + validatedStudent.getName()
        );

        System.out.println(
                "Age: " + validatedStudent.getAge()
        );

        /*
         * Uncomment this to see validation:
         *
         * validatedStudent.setAge(-10);
         *
         * It will throw:
         *
         * IllegalArgumentException
         */


        /*
         * ========================================================
         * CONSTRUCTOR ENCAPSULATION
         * ========================================================
         */

        System.out.println("\n3. CONSTRUCTOR ENCAPSULATION");

        Employee employee =
                new Employee(
                        101,
                        "John",
                        50000
                );

        System.out.println(
                "Employee ID: " + employee.getId()
        );

        System.out.println(
                "Employee Name: " + employee.getName()
        );

        System.out.println(
                "Salary: " + employee.getSalary()
        );

        employee.increaseSalary(10);

        System.out.println(
                "Salary after 10% increase: "
                        + employee.getSalary()
        );


        /*
         * ========================================================
         * BANK ACCOUNT
         * ========================================================
         */

        System.out.println("\n4. BANK ACCOUNT");

        BankAccount account =
                new BankAccount(
                        "ACC1001",
                        10000
                );

        System.out.println(
                "Initial Balance: "
                        + account.getBalance()
        );

        account.deposit(5000);

        System.out.println(
                "After Deposit: "
                        + account.getBalance()
        );

        account.withdraw(2000);

        System.out.println(
                "After Withdrawal: "
                        + account.getBalance()
        );

        /*
         * Notice:
         *
         * We never directly modified balance.
         *
         * We used:
         *
         *     deposit()
         *     withdraw()
         *
         * This is good encapsulation.
         */


        /*
         * ========================================================
         * IMMUTABLE OBJECT
         * ========================================================
         */

        System.out.println("\n5. IMMUTABLE OBJECT");

        ImmutableEmployee immutableEmployee =
                new ImmutableEmployee(
                        101,
                        "Alice",
                        70000
                );

        System.out.println(
                "ID: " + immutableEmployee.getId()
        );

        System.out.println(
                "Name: " + immutableEmployee.getName()
        );

        System.out.println(
                "Salary: " + immutableEmployee.getSalary()
        );

        /*
         * There is no setter.
         *
         * The object cannot be modified after creation.
         */


        /*
         * ========================================================
         * DEFENSIVE COPYING
         * ========================================================
         */

        System.out.println("\n6. DEFENSIVE COPYING");

        List<String> skills = new ArrayList<>();

        skills.add("Java");
        skills.add("Selenium");

        EmployeeWithSkills employeeWithSkills =
                new EmployeeWithSkills(skills);

        /*
         * Original list can be modified.
         *
         * But EmployeeWithSkills is protected because it created
         * its own copy.
         */

        skills.add("Python");

        System.out.println(
                "Employee skills: "
                        + employeeWithSkills.getSkills()
        );

        /*
         * Output:
         *
         * [Java, Selenium]
         *
         * Python is not present.
         *
         * This demonstrates defensive copying.
         */

        employeeWithSkills.addSkill("Playwright");

        System.out.println(
                "After adding skill: "
                        + employeeWithSkills.getSkills()
        );


        /*
         * ========================================================
         * ENCAPSULATED COLLECTION
         * ========================================================
         */

        System.out.println("\n7. ENCAPSULATED COLLECTION");

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop");
        cart.addProduct("Mouse");
        cart.addProduct("Keyboard");

        System.out.println(
                "Products: " + cart.getProducts()
        );

        System.out.println(
                "Product count: "
                        + cart.getProductCount()
        );

        /*
         * This would throw UnsupportedOperationException:
         *
         * cart.getProducts().clear();
         *
         * because getProducts() returns an unmodifiable list.
         */


        /*
         * ========================================================
         * INHERITANCE + ENCAPSULATION
         * ========================================================
         */

        System.out.println("\n8. INHERITANCE + ENCAPSULATION");

        Manager manager =
                new Manager(
                        "Robert",
                        "IT"
                );

        System.out.println(
                "Manager Name: " + manager.getName()
        );

        System.out.println(
                "Department: " + manager.getDepartment()
        );

        /*
         * Manager cannot directly access:
         *
         *     name
         *
         * because name is private in Person.
         *
         * It must use:
         *
         *     getName()
         *
         * or a controlled method.
         */


        /*
         * ========================================================
         * ABSTRACTION + ENCAPSULATION
         * ========================================================
         */

        System.out.println("\n9. ABSTRACTION + ENCAPSULATION");

        PaymentService payment =
                new CreditCardPayment();

        payment.pay(5000);

        /*
         * Caller only knows:
         *
         *     payment.pay(5000);
         *
         * Caller does NOT need to know:
         *
         *     how credit card processing works
         *     how totalPaid is stored
         *     how validation happens
         *
         * These details are encapsulated.
         */


        /*
         * ========================================================
         * PRODUCT BUSINESS RULE
         * ========================================================
         */

        System.out.println("\n10. BUSINESS RULE ENCAPSULATION");

        Product product =
                new Product(
                        "P1001",
                        "Laptop",
                        100000
                );

        System.out.println(
                "Original Price: "
                        + product.getPrice()
        );

        product.applyDiscount(10);

        System.out.println(
                "After 10% discount: "
                        + product.getPrice()
        );


        /*
         * ========================================================
         * THREAD-SAFE ENCAPSULATION
         * ========================================================
         */

        System.out.println("\n11. THREAD-SAFE ENCAPSULATION");

        ThreadSafeCounter counter =
                new ThreadSafeCounter();

        counter.increment();
        counter.increment();
        counter.increment();

        System.out.println(
                "Counter: " + counter.getCount()
        );


        /*
         * ========================================================
         * READ-ONLY OBJECT
         * ========================================================
         */

        System.out.println("\n12. READ-ONLY ACCESS");

        User user =
                new User("john123");

        System.out.println(
                "Username: " + user.getUsername()
        );

        /*
         * There is no setUsername().
         *
         * Therefore username is read-only.
         */


        /*
         * ========================================================
         * COMPLETE REAL-WORLD EXAMPLE
         * ========================================================
         */

        System.out.println(
                "\n13. COMPLETE REAL-WORLD EXAMPLE"
        );

        RealWorldBankAccount bankAccount =
                new RealWorldBankAccount(
                        "SB10001",
                        "Ratnakar",
                        25000
                );

        System.out.println(
                "Account Number: "
                        + bankAccount.getAccountNumber()
        );

        System.out.println(
                "Account Holder: "
                        + bankAccount.getAccountHolder()
        );

        System.out.println(
                "Balance: "
                        + bankAccount.getBalance()
        );

        bankAccount.deposit(5000);

        System.out.println(
                "After deposit: "
                        + bankAccount.getBalance()
        );

        bankAccount.withdraw(3000);

        System.out.println(
                "After withdrawal: "
                        + bankAccount.getBalance()
        );

        bankAccount.changeAccountHolder(
                "Ratnakar Kolhatkar"
        );

        System.out.println(
                "Updated Account Holder: "
                        + bankAccount.getAccountHolder()
        );


        /*
         * ========================================================
         * FINAL SUMMARY
         * ========================================================
         */

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "             ENCAPSULATION SUMMARY"
        );

        System.out.println(
                "================================================"
        );

        System.out.println(
                """
                
                1. Encapsulation = Bundling data + methods.
                
                2. Data hiding = Restricting direct access to data.
                
                3. Use private fields to protect internal state.
                
                4. Getters provide controlled READ access.
                
                5. Setters provide controlled WRITE access.
                
                6. Setters can validate incoming values.
                
                7. Not every field needs a setter.
                
                8. Prefer business methods when appropriate.
                
                   Example:
                       deposit()
                       withdraw()
                       applyDiscount()
                
                   instead of:
                       setBalance()
                       setPrice()
                
                9. final fields prevent reassignment.
                
                10. Constructor validation prevents invalid objects.
                
                11. Immutable classes cannot change after creation.
                
                12. Mutable collections require special protection.
                
                13. Defensive copying prevents external modification.
                
                14. Unmodifiable collections provide read-only access.
                
                15. Private members protect state even from subclasses.
                
                16. Encapsulation hides implementation details.
                
                17. Encapsulation and abstraction are related,
                    but they are NOT the same thing.
                
                18. Encapsulation can also help make classes
                    thread-safe when state changes are synchronized.
                
                19. Good encapsulation protects BUSINESS RULES.
                
                20. The main goal is:
                
                    "Don't allow outside code to freely manipulate
                     the internal state of an object."
                
                ==================================================
                
                INTERVIEW DEFINITION:
                
                Encapsulation is an OOP principle of bundling data
                and the methods that operate on that data within a
                class while restricting direct access to the
                object's internal state and providing controlled
                access through a well-defined interface.
                
                ==================================================
                """
        );
    }
}
