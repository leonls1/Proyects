package javafx.incidentmanager.model.statePattern;

import javafx.incidentmanager.model.entity.Incident;

public interface State {
    public void ToStarted(Incident incident);
    
    public void toInProgress(Incident incident);
    
    public void toFinished(Incident incident);
    
    public void toCancelled(Incident incident);
    
}
