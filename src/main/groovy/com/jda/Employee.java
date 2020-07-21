package com.jda;

public class Employee {

    private int id;
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public static void main (String ... args) {

        Employee emp = new Employee();
//        emp.setName("Juan");
//        emp.setId(20);

        emp.processEmp(emp);

        System.out.println(emp.getId());
        System.out.println(emp.getName());
    }

    public void processEmp(Employee emp) {

        Employee emp2 = emp;
        Employee emp3 = new Employee();
        emp3.setName("Juan");
        emp3.setId(20);
////
////        emp2 = new Employee();
////        emp2.setName("Carlos");
////        emp2.setId(200);

    }
}
