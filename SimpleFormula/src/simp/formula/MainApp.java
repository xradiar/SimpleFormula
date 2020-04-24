package simp.formula;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import simp.formula.model.Formula;
import simp.formula.view.FormulaOverviewController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	/*
	 * Data as observable list of foFormula	 * 
	 */
	private ObservableList<Formula> formulaData =FXCollections.observableArrayList();
	
	/*
	 * Return data as an observable list of Formula
	 * 
	 * 
	 */
	public ObservableList<Formula> getFormulaData(){
		return formulaData;
	}
	
	
	/*
	 * Constructor
	 * 
	 */
	public MainApp() {
		// Sample Data
		formulaData.add(new Formula("Name","formula"));
		formulaData.add(new Formula("Name","formula"));
		formulaData.add(new Formula("Name","formula"));
		formulaData.add(new Formula("Name","formula"));
		formulaData.add(new Formula("Name","formula"));
	}
	

	
	
	@Override
	public void start(Stage primaryStage) {
	this.primaryStage = primaryStage;
	this.primaryStage.setTitle("Equation Calculator");
	
	initRootLayout();
	
	showFormulaOverview();
		
	}
	
	/*
	 *  Initializes root Layout
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show scene containing root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showFormulaOverview() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/formulaOverview.fxml"));
			AnchorPane formulaOverview = (AnchorPane) loader.load();
			
			// Set formula overview into center of root layout
			rootLayout.setCenter(formulaOverview);
			
			// Give the controller acces to the main app.
			FormulaOverviewController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
