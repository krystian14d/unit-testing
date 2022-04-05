package pl.javastart.tj.exception1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class SalaryCalculatorServiceTest {

    @Mock
    TaskManagementSystem taskManagementSystem;

    @Test
    public void shouldThrowEmployeeNoLongerWorkingException() {
        //given
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        Employee employee = new Employee("Adam", BigDecimal.ZERO);

        Mockito.when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNoLongerWorkingException());

        //when, then
        Assertions.assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNoLongerWorkingException.class)
                .hasMessage("Could not calculate salary. Reason: Employee is no longer hired");
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        //given
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        Employee employee = new Employee("Adam", BigDecimal.ZERO);

        Mockito.when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNotFoundException());

        //when, then
        Assertions.assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNotFoundException.class)
                .hasMessage("Could not calculate salary. Reason: Employee not found in database");
    }

}
