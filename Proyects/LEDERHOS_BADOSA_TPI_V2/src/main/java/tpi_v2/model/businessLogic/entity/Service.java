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
@Table(name = "service")
public class Service {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "IDENTITY")
    private Long Id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "support_hours", nullable = false)
    private int hoursSupport;
    
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")    
    private Client clients;
    
    @ManyToMany(mappedBy = "services")
    private List<ProblemType> problemsType;
    
    @OneToMany
    private List<Incident> incidents;

}
