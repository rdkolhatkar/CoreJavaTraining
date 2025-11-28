package com.assessment;

public class TestOverrideStatic {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.display();               // Calls Parent static method

        Child c = new Child();
        c.display();               // Calls Child static method

        Parent ref = new Child();
        ref.display();             // ❗ Calls Parent static method (NOT Child)
        // This proves overriding DID NOT happen
    }
}
