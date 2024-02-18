package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import javafx.incidentmanager.model.enums.EmployeeType;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @Column(name = "birth-date")
    private LocalDate birthDate;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String email;

    @ManyToMany
    private Set<Specialty> specialties;

    @Enumerated(value = EnumType.STRING)
    private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(String name, String surname, LocalDate birthDate, LocalDate entryDate, Long phoneNumber, String email, EmployeeType employeeType) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + ", entryDate=" + entryDate + ", phoneNumber=" + phoneNumber + ", email=" + email + ", employeeType=" + employeeType + '}';
    }

}
