package ch.rubia.address.util.abstracts;

import javafx.scene.control.Alert;

/**
 * Esta interface remove a responsabilidade dos controllers de criar um alerta
 * e exibi-lo na tela. Assim, ela cumpre o (SRP) e o (ISP).
 *
 * @author rubia
 */
public interface IFastAlert {
    
    public void openAlert();
    public Alert getAlert();
    public void setAlert(Alert alert);
    public void setHeader(String header);
    public void setTitle(String title);
    public void setContentText(String text);
    
}
