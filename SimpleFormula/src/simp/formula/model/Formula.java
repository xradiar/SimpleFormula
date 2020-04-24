package simp.formula.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Formula {
	
	private final StringProperty formulaName;
	private final StringProperty formula;
	
	public Formula()
	{
		this(null, null);
	}

	public Formula(String formulaName, String formula) {

		this.formula = new SimpleStringProperty(formula);
		this.formulaName = new SimpleStringProperty(formulaName);
			
	}
	
	public String getFormulaName() {
		return formula.get();
	}
	
	public StringProperty formulaNameProperty() {
		return formulaName;
	}
	
	public String getFormula() {
		return formulaName.get();
	}
	
	public StringProperty formulaProperty() {
		return formula;
	}
	
	public void setFormulaName(String formulaName) {
		this.formulaName.set(formulaName);
	}
	
	public void setFormula(String formula) {
		this.formula.set(formula);
	}
	

}
