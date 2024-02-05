/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "technician")
public class Technician {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "IDENTITY")
    private Long Id;
    @Column(name = "name", nullable = false)
    
    private String name;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;
    
    @Column(name = "notification_type")
    private String notificationType;

    @ManyToMany(mappedBy = "technicians")
    private List<Specialty> specialities;
    
    @OneToMany
    private List<Incident> incidents;

}
