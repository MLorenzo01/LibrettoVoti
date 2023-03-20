package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
/**
 * Sample Skeleton for 'main.fxml' Controller Class
 */
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
	private Libretto model;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbPunti"
    private ComboBox<Integer> cmbPunti; // Value injected by FXMLLoader

    @FXML // fx:id="selData"
    private DatePicker selData; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtResults"
    private TextArea txtResults; // Value injected by FXMLLoader


	public void setModel(Libretto model) {
		this.model = model;
		txtResults.setText(this.model.toString());

	}
	@FXML
    void handleInserisci(ActionEvent event) {
		String corso = txtCorso.getText();
		Integer punti = cmbPunti.getValue();
		LocalDate data = selData.getValue();
		Voto v = new Voto(corso, punti, data);
		this.model.add(v);
		
		txtResults.setText(this.model.toString());
		

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResults != null : "fx:id=\"txtResults\" was not injected: check your FXML file 'main.fxml'.";
        for(int p=18; p<=30; p++) {
        	cmbPunti.getItems().add(p);
        }
    }
}
