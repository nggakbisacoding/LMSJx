/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.lms;

/**
 *
 * @author Fandead
 */
import java.util.List;
import java.time.LocalDate;

import trpl.classes.Member;
import trpl.classes.*;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChairBookController {

    DataAccess daf = new DataAccessFacade();

    @FXML
    private TableColumn reservationDate;

    @FXML
    private TableColumn reservationDueDate;

    @FXML
    private TableColumn reservationMember;

    @FXML
    private Label availability;

    @FXML
    private TableColumn chairId;

    @FXML
    private TextField chairNumber;
    
    @FXML
    private TextField chairMember;

    @FXML
    private TableView<Chair> reseravtionRecordTable;

    @FXML
    private Button reservationBtn;

    @FXML
    void findClicked(ActionEvent event) {

        if (daf.searchChairNumber(Integer.parseInt(chairNumber.getText())).isEmpty()) {
            availability.setText("Not Found!");
            availability.setVisible(true);
        } else {
            List<Chair> reservationRecords = daf.searchChairNumber(Integer.parseInt(chairNumber.getText()));
            reseravtionRecordTable.getItems().setAll(reservationRecords);
            chairId.setCellValueFactory(new PropertyValueFactory<Chair, String>("chairNumber"));
            reservationMember.setCellValueFactory(new PropertyValueFactory<Chair, String>("member"));
            reservationDate.setCellValueFactory(new PropertyValueFactory<Chair, String>("resDate"));
            reservationDueDate.setCellValueFactory(new PropertyValueFactory<ChairBook, String>("dueDate"));
            reservationMember.setCellValueFactory(new PropertyValueFactory<Chair, String>("member"));
        }
        chairMember.setDisable(false);

    }

    @FXML
    void searchClicked(ActionEvent event) {

        Chair chair = daf.findChair(Integer.parseInt(chairNumber.getText()));
        System.out.println(chair);
        if (chair == null) {
            availability.setText("Not Found");
            availability.setVisible(true);
        } else {
            if (!chair.getChairBooked()) {
                availability.setText(" Booked Available");
                availability.setVisible(true);
                if (chairMember.getText().isEmpty()) {
                    
                } else {
                    reservationBtn.setDisable(false);
                }

            } else {
                availability.setText("Someone Already Booked");
                availability.setVisible(true);
            }
        }

    }

    @FXML
    private void chairClicked(ActionEvent event) {
        Member mmbr = daf.findMember(Integer.parseInt(chairMember.getText()));
        Chair chair = daf.findChair(Integer.parseInt(chairNumber.getText()));

        if (!chair.getChairBooked() && mmbr != null) {
            LocalDate bc = LocalDate.now();
            chair.setEverything(Integer.parseInt(chairNumber.getText()), true, mmbr, bc.plusDays(1), bc.plusDays(2));
            Chair ch = new Chair(Integer.parseInt(chairNumber.getText()), mmbr, bc);
            daf.saveReservationChair(ch);
            daf.saveChair(chair);
            findClicked(event);
        } else {
            availability.setText("Chair is not available to booked!");
            availability.setVisible(true);
        }
    }

    public void init() {
        availability.setVisible(false);
    }
}
