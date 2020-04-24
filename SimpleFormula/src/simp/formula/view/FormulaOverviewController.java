package simp.formula.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import simp.formula.MainApp;
import simp.formula.model.Formula;

public class FormulaOverviewController {
	
	@FXML
	private TextField formulaNameField;
	
	@FXML
	private TextField formulaField;
	
	@FXML
	private TextField variablesField;
	
	@FXML
	private TableView<Formula> formulaTable;
	
	@FXML
	private TableColumn<Formula, String> formulaNameColumn;
	
	@FXML
	private TableColumn<Formula, String> formulaColumn;
	
	private MainApp mainApp;
	
	/*
	 * The constructor
	 * Called before initialize()
	 */
	public FormulaOverviewController() {
		
	}
	
	/*
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	
	@FXML
	private void intialize() {
		// Initialize the formula table with the two columns.
		formulaNameColumn.setCellValueFactory(cellData -> cellData.getValue().formulaNameProperty());
		formulaColumn.setCellValueFactory(cellData -> cellData.getValue().formulaProperty());
		
		
	}
	
	/*
	 * called by main application to give a reference back to itself
	 * 
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		// Add observable list data to the table
		formulaTable.setItems(mainApp.getFormulaData());

	}
	
}
