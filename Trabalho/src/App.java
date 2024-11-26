import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import view.Login;

public class App extends Application{
    private Login login = new Login();

    @Override
    public void start(Stage stage){

        GridPane pane = new GridPane();
        ToggleGroup group = new ToggleGroup();

        ColumnConstraints colLabels = new ColumnConstraints();
        colLabels.setPercentWidth(30);
        ColumnConstraints colTextFields = new ColumnConstraints();
        colTextFields.setPercentWidth(70);
        pane.getColumnConstraints().addAll(colLabels, colTextFields);

        login.telaLogin(pane, group);
        
        Scene scn = new Scene(pane, 600, 400);
        stage.setScene(scn);
        stage.setResizable(false);
        stage.setTitle("login");
        stage.show();
    }
public static void main(String[] args) throws Exception{
    App.launch(App.class, args);
}
}