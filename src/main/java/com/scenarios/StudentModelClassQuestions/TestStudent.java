package com.scenarios.StudentModelClassQuestions;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {
/*
INTERVIEW EXPLANATION (with internal working)

1) System.out.println(s);
   ---------------------
   Here, 's' is a reference variable of type Student.

2) println(Object obj) internally does this:
   ------------------------------------------
   It calls:
       String.valueOf(obj)

3) String.valueOf(Object obj) internally:
   ---------------------------------------
   public static String valueOf(Object obj) {
       if (obj == null)
           return "null";
       return obj.toString();   // <-- IMPORTANT
   }

4) So finally, obj.toString() is executed.

---------------------------------------------------
CASE 1: toString() is NOT overridden in Student class
---------------------------------------------------

• Student class automatically extends Object class.
• So Object class's toString() method is called.

Object class toString() looks like this:

   public String toString() {
       return getClass().getName() + "@" + Integer.toHexString(hashCode());
   }

• Output will be:
   com.scenarios.StudentModelClassQuestions.Student@1a2b3c4d

• This output:
   - Does NOT show name, marks, age, rollNumber
   - It only shows:
        ClassName + memory hash code
   - Hence, it is NOT meaningful.

---------------------------------------------------
CASE 2: toString() IS overridden in Student class
---------------------------------------------------

• JVM finds Student's overridden toString() method.
• That method is executed instead of Object's toString().

• Your overridden method:

   @Override
   public String toString() {
       return "Student{" +
               "name='" + name + '\'' +
               ", rollNumber=" + rollNumber +
               ", marks=" + marks +
               ", age=" + age +
               '}';
   }

• Output becomes meaningful:
   Student{name='Yamini', rollNumber=1, marks=90, age=27}

---------------------------------------------------
FINAL INTERVIEW ONE-LINER ANSWER:
---------------------------------------------------

System.out.println(s) prints readable object data only
because toString() is overridden. Otherwise, it prints
Object class default output (ClassName + hashCode).
*/

    public static void main(String[] args) {
        Student s1 = new Student("Yamini", 1, 90, 27);
        Student s2 = new Student("Varchaswini", 2, 80, 27);
        Student s3 = new Student("Chitra", 3, 95, 27);
        Student s4 = new Student("Dayna", 4, 68, 27);
        Student s5 = new Student("Nivedita", 5, 50, 27);

        // Add all Student Objects to the ArrayList
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        // Check the total Number of Students which is nothing but the size of arraylist
        System.out.println("Total Number of Students : "+studentList.size()); // Output of this line is = Total Number of Students : 5
        for(Student s : studentList){
            System.out.println(s);
            /*
                Below is the output of the loop
                Student{name='Yamini', rollNumber=1, marks=90, age=27}
                Student{name='Varchaswini', rollNumber=2, marks=80, age=27}
                Student{name='Chitra', rollNumber=3, marks=95, age=27}
                Student{name='Dayna', rollNumber=4, marks=68, age=27}
                Student{name='Nivedita', rollNumber=5, marks=50, age=27}
            */
        }
        // Using Streams
        studentList.forEach(e-> System.out.println(e));
        /*
            Below is the output of above stream
                Student{name='Yamini', rollNumber=1, marks=90, age=27}
                Student{name='Varchaswini', rollNumber=2, marks=80, age=27}
                Student{name='Chitra', rollNumber=3, marks=95, age=27}
                Student{name='Dayna', rollNumber=4, marks=68, age=27}
                Student{name='Nivedita', rollNumber=5, marks=50, age=27}
        */
        // Find the students who are having the marks Greater than 80
        studentList.stream().filter(e -> e.getMarks() > 80).forEach(e -> System.out.println(e.getName() +" : "+e.getMarks()));
        /*
            This is the output of above code where students who are having the marks Greater than 80
            Yamini : 90
            Chitra : 95
        */
        // Name of the person who got the highest marks
        // First we will calculate the Highest marks from the Students List
        int highestMarks = studentList.stream().map(e -> e.getMarks()).max(Integer:: compare).get();
        System.out.println("Highest Marks = "+highestMarks); // Output : Highest Marks = 95
        // Then based on the Highest marks we will find Who got the highest marks
        studentList.stream().filter(e -> e.getMarks() == highestMarks).forEach(e -> System.out.println(e));
        // Output: Student{name='Chitra', rollNumber=3, marks=95, age=27}
    }
}
