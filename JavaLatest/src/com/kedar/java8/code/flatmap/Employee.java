package com.kedar.java8.code.flatmap;

import java.util.List;

/**
 * @author Kedar Erande
 */
public class Employee {
    private int employeeId;
    private List<Address> address;

    public Employee(int employeeId, List<Address> address) {
        this.employeeId = employeeId;
        this.address = address;
    }

}
