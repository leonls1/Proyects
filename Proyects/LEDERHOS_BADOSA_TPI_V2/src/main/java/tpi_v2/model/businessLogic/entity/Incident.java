/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import lombok.Data;
import tpi_v2.model.businessLogic.entity.incidentPatternState.State;

@Data
@Entity
@Table(name = "incident")
public class Incident {
   
    @Id 
    @Column( nullable = false, unique = true)   
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY")  
    private Long id;
    
    private String title;
    
    private String description;
    
    @Column(name = "entry_date")
    private LocalDate entryDate;
    
    @Column(name = "resolution_date")
    private LocalDate resolutionDate;
    
    private State state;

    @ManyToMany(mappedBy = "incidents")
    private List<ProblemType> problemsType;
    
    @ManyToOne
    @JoinColumn(name = "fk_technician", referencedColumnName = "id")
    private Technician technician;
    
    @ManyToOne
    @JoinColumn(name = "fk_service", referencedColumnName = "id")
    private Service service;
    
    @ManyToOne
    @JoinColumn(name = "fk_operator", referencedColumnName = "id")
    private Operator operator;
    
}
