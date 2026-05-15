
package app;



import config.JPAUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        
        launch(args);
    }

    @SuppressWarnings("exports")
	@Override
    public void start(Stage stage) throws Exception {
        Parent p1 = FXMLLoader.load(getClass().getResource("/views/Borrow.fxml"));

        
        Scene s = new Scene(p1);
        stage.setScene(s);
        stage.setTitle("Library Management System");
        stage.show();
    }
    
    
    @Override
    public void stop()  {
        JPAUtil.closeEMF();
    }

    
}
