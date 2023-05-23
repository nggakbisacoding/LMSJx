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

public class Login extends Stage {
	public static Login INSTANCE = new Login();
	public static LoginController Controller;

	public void init(Window owner) throws IOException {
		if (Login.INSTANCE.getOwner() == null)
			Login.INSTANCE.initOwner(owner);

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(loader.load());
			Controller = loader.getController();

			resizableProperty().setValue(Boolean.FALSE);
			setScene(scene);
			setTitle("Login");

			Controller.init();

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
}
