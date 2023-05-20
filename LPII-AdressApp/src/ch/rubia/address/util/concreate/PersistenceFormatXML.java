package ch.rubia.address.util.concreate;

import ch.rubia.address.MainApp;
import ch.rubia.address.model.abstracts.IListWrapper;
import ch.rubia.address.model.abstracts.IPerson;
import ch.rubia.address.model.concreate.PersonListSingleton;
import ch.rubia.address.model.concreate.PersonProperty;
import ch.rubia.address.util.abstracts.IPersistenceFormat;
import ch.rubia.address.windows.concreate.PrimaryStageInstanceException;
import ch.rubia.address.windows.concreate.PrimaryStageSingleton;
import ch.rubia.address.windows.concreate.PrimaryStageSingletonInstanceException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * Essa classe implementa a forma como os dados do programa devem ser salvos
 * por meio do XML.
 * 
 * @author rubia
 */
public class PersistenceFormatXML implements IPersistenceFormat<File, File> {

    private Unmarshaller unmarshaller;
    private Marshaller marshaller;
    private Preferences appPreferences;
    private JAXBContext context;
    private IListWrapper saveWrapper;
    
    public PersistenceFormatXML(Class context, IListWrapper wrapper) throws JAXBException {
        
        setContext(JAXBContext.newInstance(context));
        setWrapper(wrapper);
        
        unmarshaller = this.context.createUnmarshaller();
        
        marshaller = this.context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        appPreferences = Preferences.userNodeForPackage(MainApp.class);

    }
    
    @Override
    public void save(File data) {
        
        ArrayList<PersonProperty> personPropertyList = new ArrayList();
            
        for(IPerson p : PersonListSingleton.getInstance().getObservableList())
            personPropertyList.add((PersonProperty) p);
            
        try {
            
            saveWrapper.setList(personPropertyList);
            
            marshaller.marshal(saveWrapper, data);
            
            setFilePath(data);
            
        } catch (JAXBException ex) {
            
            System.out.println("Não foi possível salvar dados do arquivo:\n" 
                               + data.getPath() + "\n" + ex);
            
        } catch (PrimaryStageInstanceException | PrimaryStageSingletonInstanceException ex) {
            
            System.out.println("Não foi possível salvar dados do arquivo. Erro: " + ex);
            
        }
            
    }

    @Override
    public List load(File data) {

        IListWrapper loadWrapper = null;
        
        try {
            
            loadWrapper = (IListWrapper) unmarshaller.unmarshal(data);
            
        } catch (JAXBException ex) {
            
            System.out.println("Não foi possível carregar dados do arquivo\n"
                               + data.getPath() + "\n" + ex);
            
        }
        
        if (loadWrapper == null)
            return null;
        
        return loadWrapper.getList();
        
    }
    
    public void setFilePath(File file) throws PrimaryStageInstanceException, PrimaryStageSingletonInstanceException {
        
        if (file != null) {
            appPreferences.put("filePath", file.getPath());
            PrimaryStageSingleton.getInstance().setTitle("App de Endereços - " + file.getName());
        }
        else {
            appPreferences.remove("filePath");
            PrimaryStageSingleton.getInstance().setTitle("App de Endereços");
        }
        
    }
    
    public File getFilePath() {
        
        String filePath = appPreferences.get("filePath", null);
        
        if (filePath != null) {
            return new File(filePath);
        }
        else {
            return null;
        }
        
    }
    
    public void setContext(JAXBContext context) {
        
        this.context = context;
        
    }
    
    public void setWrapper(IListWrapper wrapper) {
        
        this.saveWrapper = wrapper;
        
    }
    
    public JAXBContext getContext() { 
        
        return context;
        
    }
    
    public IListWrapper getIListWrapper() { 
        
        return saveWrapper; 
    
    }
    
}
