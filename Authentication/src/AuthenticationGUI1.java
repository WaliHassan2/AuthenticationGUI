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
public class AuthenticationGUI1 extends Application{

	public static void main(String[] args){
		launch(args);
	}

	public void start(Stage primaryStage){
		String[] correctUserName = { "Hollan", "Dean", "Holmes" };
		String[] correctPassword = { "123", "1234", "12345" };
		String[] accounts = { "Admin", "Student", "Staff" };
		int u = 0;

		primaryStage.setTitle("Authentication");

		Label UserNameLbl = new Label("User Name");
		Label PasswordLbl = new Label("Password");
		TextField UserNameTxtFld = new TextField();
		PasswordField PasswordTxtFld = new PasswordField();
		Button submitBtn = new Button("submit");
		submitBtn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent arg0){
				boolean Loop = true;
				String inputUserName = UserNameTxtFld.getText();
				String inputPassword = PasswordTxtFld.getText();

				if(inputUserName.equals(correctUserName[u]) && (inputPassword.equals(correctPassword[u]))){
					Loop = false;
				
					do{String userInput3 = (String) JOptionPane.showInputDialog(null, "Choose account type below",
							"Account Type", JOptionPane.QUESTION_MESSAGE, null, accounts, accounts[2]);
					while ((userInput3 != null) && userInput3.equals(accounts[u])){
						switch(userInput3){
						case "Admin":
							JOptionPane.showMessageDialog(null, "Welcome Hollan!");
							break;
						case "Student":
							JOptionPane.showMessageDialog(null, "Welcome Dean!");
							break;
						case "Staff":
							JOptionPane.showMessageDialog(null, "Welcome Holmes!");
							break;
						}System.exit(0);
					}
					}while(Loop==false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
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
