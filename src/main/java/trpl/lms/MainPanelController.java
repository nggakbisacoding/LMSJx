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
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import trpl.classes.*;
import trpl.classes.Chair;

public class MainPanelController {

	@FXML
	private Tab membersTab;

	@FXML
	private Tab booksTab;

	@FXML
	private MenuBar menubar;

	@FXML
	private Tab checkoutTab;

	@FXML
	private TableView<Member> memberTable;

	@FXML
	private TableColumn memberTableFirstName;

	@FXML
	private TableColumn memberTableId;

	@FXML
	private TableColumn memberTablePhone;

	@FXML
	private TableColumn memberTableAddress;

	@FXML
	private TableColumn memberTableLastName;

	@FXML
	private TableView<Book> booksTable;

	@FXML
	private TableColumn title;

	@FXML
	private TableColumn authors;

	@FXML
	private TableColumn isbn;

	@FXML
	private TableColumn checkoutLength;

	@FXML
	private TableColumn copies;

    @FXML
    private TableColumn available;

	@FXML
	private TableView<CheckoutRecord> checkoutRecordTable;

	@FXML
	private TableColumn checkoutBookCopy;

	@FXML
	private TableColumn checkoutDueDate;

	@FXML
	private TableColumn checkoutMember;

	@FXML
	private TableColumn checkoutDate;

	@FXML
	private TableColumn checkoutId;
        
        @FXML
        private TableView<Chair> reservationRecordTable;

	@FXML
	private TableColumn chairId;
        
        @FXML
        private TableColumn isBooked;

	@FXML
	void fillMemberTable(ActionEvent event) throws IOException {

	}

	public void init() {
		populateMembersTable();
		populateBooksTable();
		populateCheckoutRecordsTable();
                populateReservationRecordsTable();
	}

	public void populateMembersTable() {
		DataAccess daf = new DataAccessFacade();
		List<Member> members = daf.readMembersList();
		// System.out.println(members);
		memberTable.getItems().setAll(members);
		memberTableId.setCellValueFactory(new PropertyValueFactory<Member, Integer>("memberId"));
		memberTableFirstName.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
		memberTableLastName.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));
		memberTableAddress.setCellValueFactory(new PropertyValueFactory<Member, String>("address"));
		memberTablePhone.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
	}

	public void populateBooksTable() {
		DataAccess daf = new DataAccessFacade();
		List<Book> books = daf.readBooksList();
		booksTable.getItems().setAll(books);
		title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		isbn.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
		checkoutLength.setCellValueFactory(new PropertyValueFactory<Book, String>("checkoutLength"));
		copies.setCellValueFactory(new PropertyValueFactory<Book, Integer>("noOfCopy"));
		authors.setCellValueFactory(new PropertyValueFactory<Book, Author>("authors"));
		available.setCellValueFactory(new PropertyValueFactory<Book, Integer>("availableBookNo"));
	}

	public void populateCheckoutRecordsTable() {
		DataAccess daf = new DataAccessFacade();
		List<CheckoutRecord> checkoutRecords = daf.readCheckoutRecordsList();
		checkoutRecordTable.getItems().setAll(checkoutRecords);
		checkoutId.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("id"));
		checkoutMember.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("member"));
		checkoutBookCopy.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, BookCopy>("bookCopy"));
		checkoutDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("checkoutDate"));
		checkoutDueDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("dueDate"));

	}
        
        public void populateReservationRecordsTable() {
		DataAccess daf = new DataAccessFacade();
		List<Chair> reservationRecords = daf.readReservationChairList();
		reservationRecordTable.getItems().setAll(reservationRecords);
		chairId.setCellValueFactory(new PropertyValueFactory<Chair, String>("chairNumber"));
		isBooked.setCellValueFactory(new PropertyValueFactory<Chair, String>("chairBooked"));

	}

	@FXML
	void openNewMemberWindow(ActionEvent event) throws Exception {
		NewMember.INSTANCE.init(Root.getRootStage());
		NewMember.INSTANCE.show();

	}

	@FXML
	void update(ActionEvent event) {
		populateBooksTable();
		populateMembersTable();
		populateCheckoutRecordsTable();
                populateReservationRecordsTable();
	}

	@FXML
	void newBook(ActionEvent event) throws Exception {
		NewBook.INSTANCE.init(Root.getRootStage());
		NewBook.INSTANCE.show();

	}

	@FXML
	void editMemberClicked(ActionEvent event) throws Exception {
		EditMember.INSTANCE.init(Root.getRootStage());
		EditMember.INSTANCE.show();

	}

	@FXML
	void editBookClicked(ActionEvent event) throws Exception {
		EditBook.INSTANCE.init(Root.getRootStage());
		EditBook.INSTANCE.show();

	}

	@FXML
	void addCopyClicked(ActionEvent event) throws Exception {
		AddBookCopy.INSTANCE.init(Root.getRootStage());
		AddBookCopy.INSTANCE.show();

	}

	@FXML
	void newCheckoutClicked(ActionEvent event) throws Exception {
		Checkout.INSTANCE.init(Root.getRootStage());
		Checkout.INSTANCE.show();
	}
        
        @FXML
	void newChairClicked(ActionEvent event) throws Exception {
		ChairBook.INSTANCE.init(Root.getRootStage());
		ChairBook.INSTANCE.show();
	}
}
