package com.practice;

import java.util.Arrays;

public class PasswordStoring {
/*
    Why password should be stored in char array 'char[]' instead of String?
    What is the best practice for password storage recommended by oracle java?
    Why we should never store the sensitive data like SSN, PAN or Password in String?
*/
/*
 Why should a password be stored in a char[] instead of a String?

 1) String immutability
    - String objects are immutable in Java.
    - Once created, the value cannot be modified or cleared.
    - Sensitive data stored as String remains in memory until garbage collected,
      increasing the risk of exposure through memory dumps.

 2) Ability to explicitly wipe char[]
    - char[] is mutable and can be overwritten after use.
    - Developers can clear the contents using Arrays.fill(password, '\0'),
      minimizing the lifetime of sensitive data in memory.

 3) String pool and long-lived memory
    - String literals and interned Strings may reside in the String pool.
    - Such Strings can remain in memory for the entire JVM lifecycle.
    - This makes String unsafe for storing confidential information.

 4) Better control over sensitive data
    - char[] provides explicit control over when sensitive data is destroyed,
      aligning with secure coding standards.

 What is the best practice for password storage recommended by Oracle Java?

 - Never store passwords in plain text, regardless of data type.
 - Accept passwords as char[] instead of String.
 - Immediately hash passwords using strong, adaptive algorithms.
 - Always use a unique, cryptographically secure salt.
 - Clear the char[] after hashing or validation.

 Oracle-recommended and industry-accepted approaches:
 - PBKDF2WithHmacSHA256 or PBKDF2WithHmacSHA512 (Java standard)
 - bcrypt, scrypt, or Argon2 (via well-maintained libraries)
 - Store only salted and hashed values, never raw passwords.

 Why should sensitive data like SSN, PAN, or passwords never be stored in String?

 - Strings cannot be securely erased from memory.
 - They may be logged, cached, interned, or exposed unintentionally.
 - They are vulnerable to heap inspection and memory dump attacks.
 - Long-lived Strings increase the attack surface for data leaks.

 Secure handling guidelines:
 - Use char[] or byte[] for in-memory handling.
 - Encrypt or hash sensitive data immediately.
 - Minimize data retention time in memory.
 - Avoid logging or serializing sensitive values.

 Summary:
 - String is unsafe for sensitive data due to immutability and memory retention.
 - char[] allows explicit clearing and safer in-memory handling.
 - Always hash, salt, and protect sensitive information following Oracle Java
   and secure coding best practices.
*/
/*
 Why should passwords be stored in char[] instead of String?

 Think of String as writing a password with permanent ink.
 Once written, you cannot erase it.

 - String in Java is immutable, meaning it cannot be changed.
 - If a password is stored in a String, it stays in memory until
   the JVM removes it automatically.
 - You cannot manually clear or erase it.
 - If someone takes a memory dump, the password may be visible.

 char[] is like writing with a pencil.

 - char[] is mutable, so you can change or erase its content.
 - After using the password, you can overwrite it with empty values.
 - This reduces the time the password stays in memory.

 Example:
   Arrays.fill(password, '\0'); // clears the password

 What is the best practice for password storage (Oracle Java recommendation)?

 - Never store passwords in plain text.
 - Take passwords as char[] instead of String.
 - Convert the password into a secure hash immediately.
 - Use salt and strong algorithms like PBKDF2, bcrypt, or Argon2.
 - After hashing, clear the char[] from memory.

 Important point:
 You should store only the hashed value, not the real password.

 Why should we NEVER store sensitive data like SSN, PAN, or Password in String?

 - String data stays in memory for a long time.
 - It cannot be erased manually.
 - It may be accidentally logged or exposed.
 - It can be read from memory dumps or debugging tools.

 Examples of sensitive data:
 - Passwords
 - PAN numbers
 - SSN
 - Credit card details

 Simple rule for freshers:

 ❌ Do NOT store sensitive data in String
 ✔ Use char[] or byte[] for temporary use
 ✔ Hash or encrypt immediately
 ✔ Clear sensitive data as soon as possible

 Final takeaway:
 String is convenient but unsafe for secrets.
 char[] gives you control and better security.
*/
    public static void main(String[] args) {
        // From our application if we take memory dump or Heap memory dump then we can decode the password if it is present in the form of String inside the String pool.
        // That's why we should never store the password in String data type
        /*
            Oracle official Document referances:
            1) https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html
            2) https://docs.oracle.com/en/database/oracle/oracle-database/12.2/tdpsg/encrypting-data-with-oracle-transparent-data-encryption.html
            3) https://docs.oracle.com/en/java/javase/24/security/java-security-overview1.html
        */
        String password = "Password@123";
        System.out.println("Password is : "+password);// Here output will be "Password@123"
        char[] c = new char[]{'P', 'a', 's', 's', 'w', 'o', 'r', 'd', '@', '1', '2', '3'};
        System.out.println("Password is : "+c);// Here output will be some garbage value like "[C@2cdf8d8a"
        // With arrays we can reset the password or change the password on runtime without storing it into Memory
        Arrays.fill(c, '*');
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]); // Here old password got replaced by '*'
        }
        // If JVM is crashed then it will create the server dumps and there is a possibility that from there we can get the JVM dumps and extract the password
    }
}
