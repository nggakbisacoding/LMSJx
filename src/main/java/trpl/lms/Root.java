/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.lms;

/**
 *
 * @author Fandead
 */
import trpl.classes.UserRole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

public class Root extends Application {
	public static Stage rootStage;
	public static UserRole userRole;
	
	public static Stage getRootStage() {
		return rootStage;
	}



	public static void setRootStage(Stage rootStage) {
		Root.rootStage = rootStage;
	}



	public static UserRole getUserRole() {
		return userRole;
	}



	public static void setUserRole(UserRole userRole) {
		Root.userRole = userRole;
	}



	@Override
	public void start(Stage primaryStage) throws IOException{
		rootStage = primaryStage;
		primaryStage.setTitle("Library management System");
		Login.INSTANCE.init(primaryStage);
		Login.INSTANCE.show();
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}
}


/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Root extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
*/
