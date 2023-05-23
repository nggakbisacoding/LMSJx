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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CancelBook extends Stage{
    	public static CancelBook INSTANCE = new CancelBook();
	public static CancelBookController controller;
        
	public void init(Window owner) throws IOException {
		try {
			FXMLLoader  loader = new FXMLLoader(getClass().getResource("CancelBook.fxml"));
			Scene scene = new Scene(loader.load());
			controller = loader.getController();
			setScene(scene);
			controller.init();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
