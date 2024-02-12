/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi_v2.model.businessLogic.entity.incidentPatternState;

import tpi_v2.model.businessLogic.entity.Incident;


public class InProgress implements State {
    public InProgress(){
    }

    public void toStarted(Incident incident) {
            System.out.println("This is not possible");
    }

    public void toInProgress(Incident incident) {
        System.out.println("It's already in progresss");
    }

    public void toFinished(Incident incident) {
            incident.setState(new Finished());
    }
}
