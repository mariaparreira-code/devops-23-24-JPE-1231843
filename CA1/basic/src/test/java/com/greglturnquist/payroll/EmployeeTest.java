package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void instanceValidEmployee() throws InstantiationException {
        //arrange
        String firstName = "Maria";
        String lastName = "Parreira";
        String description = "Student";
        int jobYears = 1;
        Employee testEmployee = new Employee(firstName,lastName,description,jobYears);
        //act
        testEmployee.getJobYears();
        testEmployee.getFirstName();
        testEmployee.getLastName();
        testEmployee.getDescription();
        //assert
        assertEquals(firstName, testEmployee.getFirstName());
        assertEquals(lastName, testEmployee.getLastName());
        assertEquals(description, testEmployee.getDescription());
        assertEquals(jobYears, testEmployee.getJobYears());
    }

    @Test
    void instanceEmployeeInvalidName() throws InstantiationException {
        //arrange
        String firstName = null;
        String lastName = "";
        String description = "Student";
        int jobYears = 1;
        String expectedMessage = "Invalid arguments";
        //act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName,lastName,description,jobYears)
        );
        String actualMessage = exception.getMessage();
        //assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void instanceEmployeeInvalidDescription() throws InstantiationException {
        //arrange
        String firstName = "Maria";
        String lastName = "Parreira";
        String description = "";
        int jobYears = 1;
        String expectedMessage = "Invalid arguments";
        //act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName,lastName,description,jobYears)
        );
        String actualMessage = exception.getMessage();
        //assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void instanceEmployeeInvalidJobYears() throws InstantiationException {
        //arrange
        String firstName = "Maria";
        String lastName = "Parreira";
        String description = "Student";
        int jobYears = -1;
        String expectedMessage = "Invalid arguments";
        //act
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears)
        );
        String actualMessage = exception.getMessage();
        //assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    


}
