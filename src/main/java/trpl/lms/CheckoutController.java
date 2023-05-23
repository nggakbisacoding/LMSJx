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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import trpl.classes.Address;
import trpl.classes.Author;
import trpl.classes.Book;
import trpl.classes.BookCopy;
import trpl.classes.CheckoutRecord;
import trpl.classes.Member;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckoutController {
	DataAccess daf = new DataAccessFacade();
	@FXML
    private TableColumn checkoutDate;

    @FXML
    private TableColumn checkoutBookCopy;

    @FXML
    private TextField isbn;

    @FXML
    private TableColumn checkoutDueDate;

    @FXML
    private TableColumn checkoutMember;

    @FXML
    private Label availability;

    @FXML
    private TableColumn checkoutId;

    @FXML
    private TextField memberId;
    @FXML
    private TableView<CheckoutRecord> checkoutRecordTable;
    @FXML
    private Button checkoutBtn;

    @FXML
    void findClicked(ActionEvent event) {
    	
    	
    	if(daf.searchCheckout(Integer.parseInt(memberId.getText())).isEmpty()) {
    		availability.setText("No Record Found");
    		availability.setVisible(true);
    	}else {
    		List<CheckoutRecord> checkoutRecords = daf.searchCheckout(Integer.parseInt(memberId.getText()));
    		checkoutRecordTable.getItems().setAll(checkoutRecords);
    		checkoutId.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("id"));
    		checkoutMember.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("member"));
    		checkoutBookCopy.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, BookCopy>("bookCopy"));
    		checkoutDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("checkoutDate"));
    		checkoutDueDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("dueDate"));
    	}
		
		
		
    }

    @FXML
    void searchClicked(ActionEvent event) {
    	
    	Book book = daf.findBook(isbn.getText());
    	if(book==null) {
    		availability.setText("Book Not Found");
    		availability.setVisible(true);
    	}else {
    		if(book.isAvailable()) {
    			availability.setText("Book Found :)");
        		availability.setVisible(true);
        		if(memberId.getText().isEmpty()) {
        			
        		}else {
        			checkoutBtn.setDisable(false);
        		}
        		
    		}else {
    			availability.setText("All Copies is checked out :/");
        		availability.setVisible(true);
    		}
    	}
    	
    }

    @FXML
    void checkoutClicked(ActionEvent event) {
    	Member mmbr = daf.findMember(Integer.parseInt(memberId.getText()));
    	Book book = daf.findBook(isbn.getText());
    	System.out.println(mmbr);
    	System.out.println(book.getCopiesNumbers());
    	
    	if(mmbr!=null && book.isAvailable()) {
    		List<CheckoutRecord> crs = daf.readCheckoutRecordsList();
    		int nextId = crs.size()+1;
    		BookCopy bc= book.checkout();
    		System.out.println(bc);
    		CheckoutRecord cr = new CheckoutRecord(nextId, mmbr, bc);
    		daf.saveCheckoutRecord(cr);
    		daf.saveBook(book);
    		findClicked(event);
    	}else {
    		availability.setText("Book is not available to check out!");
    		availability.setVisible(true);
    	}
    }
	public void init() {
		availability.setVisible(false);
	}
}
