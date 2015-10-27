import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AuthenticationGUI2 extends Application {
	int u = 0;
	int LIMIT = 3;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		String[] correctUserName = { "Hollan", "Dean", "Holmes" };
		String[] correctPassword = { "123", "1234", "12345" };

		primaryStage.setTitle("Authentication");

		Label UserNameLbl = new Label("User Name");
		Label PasswordLbl = new Label("Password");
		TextField UserNameTxtFld = new TextField();

		PasswordField PasswordTxtFld = new PasswordField();

		Button submitBtn = new Button("submit");
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			String inputUserName = "";
			String inputPassword = "";

			public void handle(ActionEvent arg0) {

				inputUserName = UserNameTxtFld.getText();
				inputPassword = PasswordTxtFld.getText();
				UserNameTxtFld.clear();
				PasswordTxtFld.clear();
				if (inputUserName.equals(correctUserName[u]) && (inputPassword.equals(correctPassword[u]))) {
					JOptionPane.showMessageDialog(null, "Welcome " + inputUserName + "!");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
					u++;

				}

				if (u == LIMIT) {
					JOptionPane.showMessageDialog(null, "Please contact your adminstrator\n to unlock your account!");
					System.exit(0);
				}

			}
		});
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(UserNameLbl, 0, 0);
		grid.add(PasswordLbl, 0, 1);
		grid.add(UserNameTxtFld, 1, 0);
		grid.add(PasswordTxtFld, 1, 1);
		grid.add(submitBtn, 1, 2);
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

}
