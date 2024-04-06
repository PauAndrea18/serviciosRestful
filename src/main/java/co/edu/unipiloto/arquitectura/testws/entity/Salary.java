/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.arquitectura.testws.entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement
public class Salary {
    private int salary;

    /**
     * @return the averageSalary
     */
    @XmlElement
    public int getSalary() {
        return salary;
    }

    /**
     * @param averageSalary the averageSalary to set
     */
    public void setSalary(int averageSalary) {
        this.salary = averageSalary;
    }
    
}
