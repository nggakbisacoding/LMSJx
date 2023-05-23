/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.lms;

/**
 *
 * @author Fandead
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import trpl.classes.Address;
import trpl.classes.Author;
import trpl.classes.Book;
import trpl.classes.Member;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewBookController {

	public List<Author> authors = new ArrayList<>();
	@FXML
	private Button cancelBtn;

	@FXML
	private TextField isbn;

	@FXML
	private TextField checkoutLength;

	@FXML
	private TextField title;

	@FXML
	private TextField noOfCopy;

	@FXML
	private Button saveBtn;

	@FXML
	private Label authorsLabel;

	@FXML
	void saveAction(ActionEvent event) {
		Book book = new Book(title.getText(), isbn.getText(), authors, Integer.parseInt(noOfCopy.getText()),
				Integer.parseInt(checkoutLength.getText()));
		DataAccess da = new DataAccessFacade();
		da.saveBook(book);
		NewBook.INSTANCE.close();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		NewBook.INSTANCE.close();
	}

	public void init() {
		authorsLabel.setText(authors.toString());
	}

	@FXML
	void addAuthor(ActionEvent event) throws Exception {
		NewAuthor.INSTANCE.init(Root.getRootStage());
		NewAuthor.INSTANCE.show();
	}

}
