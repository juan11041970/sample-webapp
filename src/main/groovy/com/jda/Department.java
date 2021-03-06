package com.jda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Department {

    private int id;
    private int deptId;
    private String name;

    private Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return empMap.values();
    }

    public void hire(Employee e) {
        empMap.put(e.getId(), e);
    }

    public void layoff(Employee e) {
        empMap.remove(e.getId());
    }

    public Department plus(Employee e) {
        hire(e);
        return this;
    }

    public Department minus (Employee e) {
        layoff(e);
        return this;
    }

    public Department leftShift(Employee e) {
        hire(e);
        return this;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
