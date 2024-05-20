package project.commandmanager.utilities.factories;

import project.commandmanager.model.persistence.*;


public class DAOFactory {

    public CommandDAO getCommand(){
        return new CommandImp();
    }
    
    public ItemDAO getItemDAO(){
        return  new ItemImp();
    }
    
    public PurchaseDAO getPurchaseDAO(){
        return new PurchaseImp();
    }
    
    public PurchaseDetailDAO getDetail(){
        return new PurchaseDetailImp();
    }
    
    public StreetDAO getStreetDAO(){
        return new StreetImp();
    }
    
    
    public TypeDAO getTypeDAO(){
        return new TypeImp();
    }
    
    
}
