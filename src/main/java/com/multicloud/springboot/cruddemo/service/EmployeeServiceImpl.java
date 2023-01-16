package com.multicloud.springboot.cruddemo.service;

import com.multicloud.springboot.cruddemo.dao.EmployeeRepository;
import com.multicloud.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    public void setEmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpDetails(int theId) {
        Optional<Employee> theEmp =  employeeRepository.findById(theId);
         Employee tempEmp = null;
        if(theEmp.isPresent()){
            tempEmp = theEmp.get();
        }
        return tempEmp;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}
