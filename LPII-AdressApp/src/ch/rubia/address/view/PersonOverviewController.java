package ch.rubia.address.view;

import ch.rubia.address.view.abstracts.IPersonManipulation;
import ch.rubia.address.view.concreate.OverviewControllerPersonManipulation;
import ch.rubia.address.view.concreate.ShowOverviewInfo;
import ch.rubia.address.view.abstracts.IShowPersonInfo;
import ch.rubia.address.model.abstracts.IPerson;
import ch.rubia.address.model.abstracts.IPersonProperty;
import ch.rubia.address.model.concreate.PersonListSingleton;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import ch.rubia.address.view.abstracts.IController;

/**
 * As implementações dos seus métodos foram divididas em outras classes para que o 
 * PersonOverviewController tenha como única responsabilidade associar quais ações
 * devem ser tomadas em determinados eventos. (SRP)
 * 
 * A segregação das funcionalidades em outras classes/interfaces atende o OCP,
 * o ISP e o DIP.
 * 
 * Todas as referências ao main foram retiradas. As referencias a lista de pessoas e
 * ao primaryStage foram substituidas pelos seus respectivos singletons
 * 
 * @author rubia
 */
public class PersonOverviewController implements IController {
    
    @FXML private TableView<IPerson> personTable;
    @FXML private TableColumn<IPersonProperty, String> firstNameColumn;
    @FXML private TableColumn<IPersonProperty, String> lastNameColumn;
    
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label streetLabel;
    @FXML private Label postalCodeLabel;
    @FXML private Label cityLabel;
    @FXML private Label birthdayLabel;

    private IPersonManipulation personManipulator;
    private IShowPersonInfo infoExhibitor;
    
    public PersonOverviewController() {
        
        personManipulator = new OverviewControllerPersonManipulation(this);
        infoExhibitor = new ShowOverviewInfo(this);
        
    }
    
    @FXML
    private void initialize() {
        
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFirstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getLastNameProperty());
        
        infoExhibitor.hideInfo();
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
        
    }
    
    private void showPersonDetails(IPerson person) {
        infoExhibitor.loadInfo(person);
    }
    
    @FXML
    private void handelDeletePerson() {
        personManipulator.deletePerson();
    }
    
    @FXML
    private void handleNewPerson() {
        personManipulator.newPerson();
    }
    
    @FXML
    private void handleEditPerson() {
        personManipulator.editPerson();
    }
    
    public TableView<IPerson> getPersonTable() {
        return personTable;
    }

    public TableColumn<IPersonProperty, String> getFirstNameColumn() {
        return firstNameColumn;
    }

    public TableColumn<IPersonProperty, String> getLastNameColumn() {
        return lastNameColumn;
    }

    public Label getFirstNameLabel() {
        return firstNameLabel;
    }

    public Label getLastNameLabel() {
        return lastNameLabel;
    }

    public Label getStreetLabel() {
        return streetLabel;
    }

    public Label getPostalCodeLabel() {
        return postalCodeLabel;
    }

    public Label getCityLabel() {
        return cityLabel;
    }

    public Label getBirthdayLabel() {
        return birthdayLabel;
    }
    
    public void setTableItems() {

        personTable.setItems(PersonListSingleton.getInstance().getObservableList());
        
    }
    
}
