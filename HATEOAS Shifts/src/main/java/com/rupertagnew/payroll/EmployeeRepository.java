
package com.rupertagnew.payroll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


//public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//}
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}

