package andrewchristensonscheduling;

import andrewchristensonscheduling.model.DBConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author andrewchristenson
 */
public class AndrewChristensonScheduling extends Application {
    static Stage stage;
    
    public static Stage getStage() {
        return stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/andrewchristensonscheduling/view/login.fxml"));
        
        Scene scene = new Scene(root);
        
        this.stage = stage;
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        launch(args);
    }  
}
