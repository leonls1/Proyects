/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpi_v2.model.businessLogic.entity.incidentPatternState;

import tpi_v2.model.businessLogic.entity.Incident;


public interface State {
    
    void toStarted(Incident incident);
    
    void toInProgress(Incident incident);
    
    void toFinished(Incident incident);
    
}
