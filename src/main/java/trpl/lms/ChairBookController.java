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
    private TableColumn memberId;

    @FXML
    private TableView<Chair> chairRecordTable;

    @FXML
    private Button reservationBtn;

    @FXML
    void findClicked(ActionEvent event) {

        if (daf.searchChairNumber(Integer.parseInt(memberId.getText())).isEmpty()) {
            System.out.println(daf.searchChairNumber(Integer.parseInt(memberId.getText())));
            availability.setText("Not Found!");
            availability.setVisible(true);
        } else {
            List<Chair> reservationRecords = daf.searchChairNumber(Integer.parseInt(chairNumber.getText()));
            chairRecordTable.getItems().setAll(reservationRecords);
            chairId.setCellValueFactory(new PropertyValueFactory<Chair, String>("chairNumber"));
            reservationMember.setCellValueFactory(new PropertyValueFactory<Chair, String>("member"));
            reservationDate.setCellValueFactory(new PropertyValueFactory<Chair, String>("resDate"));
            reservationDueDate.setCellValueFactory(new PropertyValueFactory<Chair, String>("dueDate"));
        }

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
                availability.setText("Chair Available)");
                availability.setVisible(true);
                if (memberId.getText().isEmpty()) {

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
        Member mmbr = daf.findMember(Integer.parseInt(memberId.getText()));
        Chair chair = daf.findChair(Integer.parseInt(chairNumber.getText()));
        System.out.println(mmbr);
        System.out.println(chair.getChairBooked());

        if (!chair.getChairBooked() && mmbr != null) {
            List<Chair> cr = daf.readReservationChairList();
            int nextId = cr.size() + 1;
            chair.setChairBooked(true);
            LocalDate bc = LocalDate.now();
            System.out.println(bc);
            Chair ch = new Chair(nextId, mmbr, bc);
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
