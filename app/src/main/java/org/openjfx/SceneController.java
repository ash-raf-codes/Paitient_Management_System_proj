/* This class is an attempt to have an elegant scene manager with fxml scenes.
 * It doesn't work. But it's harmless.
 * --Madelyn
 */


package org.openjfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SceneController {
    
    private Stage stage;
    private Scene scene;
    private Parent root2;

    public void switchToAddPatient(ActionEvent event) throws IOException {
        root2 = FXMLLoader.load(getClass().getResource("addpatientscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

}
