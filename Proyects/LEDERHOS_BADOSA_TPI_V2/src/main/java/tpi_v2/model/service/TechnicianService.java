/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpi_v2.model.service;

import java.util.List;
import tpi_v2.model.businessLogic.entity.Specialty;
import tpi_v2.model.businessLogic.entity.Technician;


public interface TechnicianService {
    
    public List<Technician> getAll();
    
    public Technician getById(Long id);
    
    public void create(Technician tech);
    
    public void delete(Long id);
    
    public void update(Technician tech, Long id);
    
    public Technician moreResolvedIncidentsInPeriod(int day);
    
    public Technician moreResolvedIncidentsInPeriodBySpecialty(int day,Specialty specialty);
    
    public Technician fasterSolved();
    
    
    
    /*
    c. Quién fue el técnico que más rápido resolvió los incidentes
    */
    
    
}
