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

public class CancelBookController {

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
        Member mmbr = daf.findMember(Integer.parseInt(chairMember.getText()));
        if (mmbr == null) {
            availability.setText("Member not Found!");
            availability.setVisible(true);
        } else {
            List<Chair> reservationRecords = daf.readReservationChairList();
            for (Chair cr : reservationRecords) {
                if(cr.getChairBooked()){
                    reseravtionRecordTable.getItems().setAll(reservationRecords);
                    chairId.setCellValueFactory(new PropertyValueFactory<Chair, String>("chairNumber"));
                    reservationMember.setCellValueFactory(new PropertyValueFactory<Chair, String>("member"));
                    reservationDate.setCellValueFactory(new PropertyValueFactory<Chair, String>("resDate"));
                    reservationDueDate.setCellValueFactory(new PropertyValueFactory<Chair, String>("dueDate"));
                    reservationMember.setCellValueFactory(new PropertyValueFactory<Chair, String>("member")); 
                }
	    }
            if (chairMember.getText().isEmpty()) {
                    
            } else {
                reservationBtn.setDisable(false);
            }
        }

    }

    @FXML
    private void chairClicked(ActionEvent event) {
        Member mmbr = daf.findMember(Integer.parseInt(chairMember.getText()));
        Chair chair = daf.findChair(Integer.parseInt(chairNumber.getText()));

        if (mmbr != null && chair.getChairNumber() == Integer.parseInt(chairNumber.getText())) {
            LocalDate bc = LocalDate.of(1111, 1, 1);
            chair.setEverything(Integer.parseInt(chairNumber.getText()), false, null, bc, bc);
            Chair ch = new Chair(Integer.parseInt(chairNumber.getText()), mmbr, bc);
            daf.saveReservationChair(ch);
            daf.saveChair(chair);
            findClicked(event);
        } else {
            availability.setText("Not Your!");
            availability.setVisible(true);
        }
    }

    public void init() {
        availability.setVisible(false);
    }
}
