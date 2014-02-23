package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.util.Map;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddFillInTheBlankQuestionPage extends BasePageObject {

	/* Elements */
	private String questionRadToolId = "RadWindowWrapper_RADQuestionText_toolbarMode";
	private String questionRadFrameId = "RADQuestionText_contentIframe";
	 private String questionRadFooterId = "RADQuestionText_ModesWrapper";
	    private VisualEditor questionRad = new VisualEditor(
	            uiDriver,
	            questionRadToolId,
	            questionRadFrameId,questionRadFooterId);
	private String generalExplanationRadToolId = "RadWindowWrapper_RADGeneralExplanation_toolbarMode";
	private String generalExplanationRadFrameId = "RADGeneralExplanation_contentIframe";
	private String generalExplanationRadFooterId = "RADGeneralExplanation_ModesWrapper";
    private VisualEditor generalExplanationRad = new VisualEditor(
            uiDriver,
            generalExplanationRadToolId,
            generalExplanationRadFrameId,generalExplanationRadFooterId);
	private String alertMsg;
	private UIElement btnAdd = createElement(UIType.Xpath, "//*[@id='button3']");
	private UIElement btnCancel = createElement(UIType.ID, "button2");
	private UIElement txtResponse = createElement(UIType.Xpath,
			"//label[contains(text(),'{1}')]/following-sibling::input");
	private UIElement txtPoints = createElement(UIType.Name, "RADPoints");
	   private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	    boolean flag=false;
	   String response;
	/* Constructor */
	public AddFillInTheBlankQuestionPage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION : ### AddFillInTheBlankQuestionPage ###");
	}

	public VisualEditor getQuestionRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return questionRad;
	}

	public VisualEditor getGeneralExplanationRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return generalExplanationRad;
	}

	/**
	 * This Method will click on add button.
	 * 
	 * @return object
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public Object clickAddButton() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:CLICKING ON ADD BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickAndWait(waitTime);
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
			if (alertMsg.contains("Question Added Successfully.")) {
				return new ExamHomePage(uiDriver);
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Add' BUTTON"
					+ "\n METHOD : clickAddButton \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This Method will give you the Alert Message.
	 * 
	 * @return String
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public String getAlertMessage() {
		return alertMsg;
	}

	/**
	 * This Method will check whether Alert is present or not.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean isAlertPresent() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR ALERT");
			if (alertMsg != null) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CHECKING FOR ALERT"
					+ "\n METHOD : isAlertPresent \n" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is Question RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isQuestionRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER QUESTION RAD EDITOR IS BEING DISPLAYED");
			if (questionRad != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER QUESTION RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isQuestionRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is general Explanation RAD Editor Displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isGeneralexplainationRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER GENERAL EXPLANATION RAD EDITOR IS BEING DISPLAYED");
			if (generalExplanationRad != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER GENERAL EXPLANATION RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isGeneralexplainationRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify Alternative Editor Present or not..
	 * 
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author suchi.singh
	 */
	public boolean isEditorSwitchDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
		try {
		  	flag = lnkEditorSwitch.isDisplayedAfterWaiting(waitTime);
	      	  logInstruction("LOG INSTRUCTION: VERIFYING ALTERNATIVE EDITOR PRESENT");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to click the cancel button on ExamsCreatePage
	 * 
	 * @author Suchi.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 */
	public ExamHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Cancel' BUTTON"
					+ "\n METHOD : clickCancelButton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * This method helps to get the response text from the response in Fill in the blank
	 * question type page
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 * @param String
	 *            reponseno
	 * @return String
	 */
	public String getReponse(String reponseno) throws Exception {
		response = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE RESPONSE TEXT");
			frameSwitch.switchToFrameContent();
			txtResponse.replaceValues(reponseno);
			uiDriver.waitToBeDisplayed(txtResponse, waitTime);
			response = txtResponse.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Response'"
					+ "\n METHOD : getReponse \n" + e.getLocalizedMessage());
		}
		return response;
	}

	/**
	 * This method is used to enter points
	 * @author ashish.juyal
	 * @param pointsToBeEntered
	 * @return AddFillInTheBlankQuestionPage
	 * @throws Exception
	 */
	public AddFillInTheBlankQuestionPage enterPoints(String pointsToBeEntered)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE POINTS FOR FILL IN THE BLANK TYPE QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(pointsToBeEntered);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING THE POINTS FOR FILL IN THE BLANK TYPE QUESTION."
							+ "\n METHOD : enterPoints \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method helps to enter the response text in blank question type page
	 * 
	 * @author Suchi.Singh
	 * @throws Exception
	 * @param String
	 *            reponseno, String ResponseText
	 * @return AddFillInTheBlankQuestionPage
	 */
	public AddFillInTheBlankQuestionPage enterReponse(String reponseno,
			String ResponseText) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE RESPONSE TEXT");
			frameSwitch.switchToFrameContent();
			txtResponse.replaceValues(reponseno);
			uiDriver.waitToBeDisplayed(txtResponse, waitTime);
			txtResponse.sendKeys(ResponseText);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'Response'"
					+ "\n METHOD : enterReponse \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This is Service level method to Add Multiple Choice Question Type
	 * 
	 * @author Kapil
	 * @param question
	 * @param points
	 * @param acceptedResponses
	 * @param generalExplanation
	 * @return ExamHomePage
	 */
	public ExamHomePage addFillInTheBlankQuestion(String question, String points, Map<String, String> acceptedResponses, String generalExplanation) throws Exception {
		try {
			getQuestionRadEditor().enterText(question);
			logInstruction("LOG INSTRUCTION: ENTERED QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(points);
			logInstruction("LOG INSTRUCTION: ENTERED POINTS");
			for(Map.Entry<String, String> responses: acceptedResponses.entrySet()) {
				txtResponse.replaceValues(responses.getKey());
				uiDriver.waitToBeDisplayed(txtResponse, waitTime);
				txtResponse.sendKeys(responses.getValue());
			}
			logInstruction("LOG INSTRUCTION: ENTERED RESPONSES");
			getGeneralExplanationRadEditor().enterText(generalExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED GENERAL EXPLANATION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch(Exception e) {
			throw new Exception(
					"ISSUE IN CREATING FILL IN THE BLANK QUESTION."
							+ "\n METHOD : addFillInTheBlankQuestion \n"
							+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}
}
