package rocket.app.view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.text.NumberFormat;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox cmbTerm;
	@FXML
	private Button button;
	@FXML
	private Label lblMortgagePayment;
	@FXML
	private Label Errors;
	
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		
		if(cmbTerm.getValue() == "15 Years"){
			lq.setiTerm(15);
		}
		else{
			lq.setiTerm(30);
		}
	
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	@SuppressWarnings("null")
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		RateBLL rate = new RateBLL();
		NumberFormat number = NumberFormat.getCurrencyInstance();
		
		Label txtRate = null;
		if (lRequest.getdRate() < 0) {
			System.out.println("Your credit score is too low.");
		}
		else {	
			number.format(lRequest.getdPayment());
			txtRate.setText(number.format(lRequest.getdRate()/100));
		}	
		txtRate.setText("");
		
	}
}
