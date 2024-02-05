package tpi_v2.model.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import tpi_v2.model.businessLogic.entity.Specialty;
import tpi_v2.model.businessLogic.entity.Technician;
import tpi_v2.model.businessLogic.entity.incidentPatternState.Finished;
import tpi_v2.model.persistence.TechnicianRepository;
import tpi_v2.model.businessLogic.entity.Incident;

public class TechnicianImp implements TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    @Override
    public List<Technician> getAll() {
        return repository.findAll();
    }

    @Override
    public Technician getById(Long id) {
        return repository.findById(id).
                orElseThrow();
    }

    @Override
    public void create(Technician tech) {
        repository.save(tech);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Technician tech, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Technician moreResolvedIncidentsInPeriod(int day) {

        Long maxSolved = 0L;
        Long actualIncidntsCount = 0L;
        Technician techies = new Technician();
        List<Technician> techs = getAll();

        LocalDate fechaNdaysAntes = LocalDate.now().minusDays(day);

        for (Technician tech : techs) {
            actualIncidntsCount = tech.getIncidents()
                    .stream()
                    .filter(incident -> incident.getState() instanceof Finished)
                    .filter(incident -> incident.getResolutionDate().isAfter(fechaNdaysAntes))
                    .count();
            if (actualIncidntsCount > maxSolved) {
                maxSolved = actualIncidntsCount;
                techies = tech;
            }
        }
        return techies;

    }

    @Override
    public Technician moreResolvedIncidentsInPeriodBySpecialty(int day, Specialty specialty) {

        Long maxSolved = 0L;
        Long actualIncidntsCount = 0L;
        Technician techies = new Technician();
        LocalDate fechaNdaysAntes = LocalDate.now().minusDays(day);

        List<Technician> techs = getAll()
                .stream()
                .filter(tech
                        -> tech.getSpecialities()
                        .contains(specialty))
                .collect(Collectors.toList());

        for (Technician tech : techs) {
            actualIncidntsCount = tech.getIncidents()
                    .stream()
                    .filter(incident -> incident.getState() instanceof Finished)
                    .filter(incident -> incident.getResolutionDate().isAfter(fechaNdaysAntes))
                    .count();
            if (actualIncidntsCount > maxSolved) {
                maxSolved = actualIncidntsCount;
                techies = tech;
            }
        }
        
        return techies;
    }

    @Override
    public Technician fasterSolved() {
        Technician techies = new Technician();
        Long hoursMin = Long.MAX_VALUE;
        Long hours = 0L;
        
        List<Incident> incidents = null;
        List<Technician> techs = getAll();
        
        for(Technician tech : techs ){
            incidents = tech.getIncidents();
            for(Incident incident : incidents){
                hours = ChronoUnit.HOURS.between(
                        incident.getEntryDate(), 
                        incident.getResolutionDate());
                if(hours < hoursMin){
                    hoursMin = hours;
                    techies = tech;
                }
            }                       
        }          
        return techies;
    }

}
