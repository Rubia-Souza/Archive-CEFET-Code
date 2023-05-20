package ch.rubia.address.view.concreate;

import ch.rubia.address.model.concreate.PersonProperty;
import ch.rubia.address.util.abstracts.IFastAlert;
import ch.rubia.address.util.concreate.FastAlertWarning;
import ch.rubia.address.view.PersonOverviewController;
import ch.rubia.address.view.abstracts.IPersonManipulation;
import ch.rubia.address.view.abstracts.IShowPersonInfo;
import ch.rubia.address.model.abstracts.IPerson;
import ch.rubia.address.model.concreate.PersonListSingleton;
import ch.rubia.address.windows.concreate.EditPersonStage;
import ch.rubia.address.windows.abstracts.IWindow;

/**
 * Esta classe é a implementação da interface IPersonManipulation
 * 
 * A referência ao Main foi substituida pela instanciação da classe EditPersonStage
 * para abrir a janela
 * 
 * @author rubia
 */
public class OverviewControllerPersonManipulation implements IPersonManipulation {

    private PersonOverviewController controller;
    
    public OverviewControllerPersonManipulation(PersonOverviewController controller){
        
        setController(controller);
        
    }
    
    @Override
    public void deletePerson() {

        int selectedIndex = controller.getPersonTable().getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
            controller.getPersonTable().getItems().remove(selectedIndex);
        }
        else {
            IFastAlert alert = new FastAlertWarning("Nenhuma seleção!", 
                    "Nenhuma pessoa foi selecionada", 
                    "por favor, selecione uma pessoa na tabela."); 
            alert.openAlert();
        }
        
    }

    @Override
    public void newPerson() {
        
        IPerson tempPerson = new PersonProperty();
        IWindow editWindow = new EditPersonStage(tempPerson);
        
        editWindow.open();
        
        if (editWindow.isOpen())
            PersonListSingleton.getInstance().addPerson(tempPerson);
        
    }

    @Override
    public void editPerson() {
        
       IPerson selectedPerson = controller.getPersonTable().getSelectionModel().getSelectedItem();
       
       if (selectedPerson != null) {
           
           IWindow editWindow = new EditPersonStage(selectedPerson);
           editWindow.open();

           if (editWindow.isOpen()) {
               
               IShowPersonInfo infoExhibitor = new ShowOverviewInfo(controller);
               infoExhibitor.loadInfo(selectedPerson);
               
           }
                
        }
        
    }
    
    public PersonOverviewController getController(){
        return controller;
    }
    
    private void setController(PersonOverviewController controller){
        this.controller = controller;
    }
}
