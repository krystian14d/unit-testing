package pl.javastart.tj.mocking1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class SalaryCalculatorServiceTest {

    @Mock
    TaskManagementSystem taskManagementSystem;

    private SalaryCalculatorService salaryCalculatorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
    }

    @Test
    public void shouldHaveNoBonus() {
        //given
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(9);

        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2000));
    }

    @Test
    public void shouldHave1000Bonus() {
        //given
        Employee employee = new Employee("Jan", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(20);

        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(3000));
    }

    @Test
    public void shouldHave500Bonus() {
        //given
        Employee employee = new Employee("Tomasz", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(15);

        //when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        //then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2500));
    }
}