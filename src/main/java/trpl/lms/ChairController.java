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
import trpl.classes.Member;
import trpl.dataaccess.DataAccess;
import trpl.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChairController {
    DataAccess daf = new DataAccessFacade();
    
    public void init() {
        System.out.println("Unsupported");
    }
}
