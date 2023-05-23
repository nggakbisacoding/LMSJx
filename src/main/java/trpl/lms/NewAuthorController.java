/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.lms;

/**
 *
 * @author Fandead
 */
import java.net.URL;
import java.util.ResourceBundle;

import trpl.classes.Address;
import trpl.classes.Author;
import trpl.classes.Member;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewAuthorController  {

	@FXML
	private TextField zip;

	@FXML
	private TextField id;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField city;

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField street;

	@FXML
	private TextField state;

	@FXML
	private Button saveBtn;
	@FXML
	private TextField credentials;
	@FXML
	private TextField shortBio;
	

	@FXML
	void saveAction(ActionEvent event) {
		Address address = new Address(street.getText(), city.getText(), state.getText(),
				Integer.parseInt(zip.getText()));
		Author a = new Author(Integer.parseInt(id.getText()), firstName.getText(), lastName.getText(), address, phoneNumber.getText(),
				credentials.getText(), shortBio.getText());

		NewBook.INSTANCE.controller.authors.add(a);
		
		NewAuthor.INSTANCE.hide();
		NewBook.INSTANCE.controller.init();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		NewAuthor.INSTANCE.hide();
	}

	
	public void init() {

	}

}

