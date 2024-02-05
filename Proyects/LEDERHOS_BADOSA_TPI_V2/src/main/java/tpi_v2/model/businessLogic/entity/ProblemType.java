/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.SEQUENCE;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "problem_type")
public class ProblemType {
    
    @Id 
    @Column( nullable = false, unique = true)   
    @GeneratedValue(strategy=SEQUENCE, generator="IDENTITY") 
    private Long id;
    
    private String name;
    
    @Column(name = "stimated_time")
    private int stimatedTime;
    
    @Column(name = "max_time")
    private int maxTime;
    
    @ManyToMany
    private List<Specialty> specialties;
    
    @ManyToMany
    private List<Incident> incidents;   
       
    @ManyToMany   
    private List<Service> services;
    
    
            
}
