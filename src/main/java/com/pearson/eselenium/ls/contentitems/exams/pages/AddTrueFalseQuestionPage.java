package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to AddTrueFalseQuestion Page
 * 
 * @author monica.anand
 * 
 */
public class AddTrueFalseQuestionPage extends BasePageObject {

	/* Elements */
	private UIElement btnAdd = createElement(UIType.ID, "button3");
	private UIElement btnCancel = createElement(UIType.ID, "button2");
	private UIElement txtPoints = createElement(UIType.Name, "RADPoints");
	private UIElement radOption = createElement(UIType.Xpath,
			"//input[@value='{1}']");

	/* Variables */
	private String alertMsg;

	private String questionRadToolId = "RADQuestionText";
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

	private String TrueRadToolId = "RadWindowWrapper_RADTrueExplanation_toolbarMode";
	private String TrueRadFrameId = "RADTrueExplanation_contentIframe";
	private String TrueRadFooterId = "RADTrueExplanation_ModesWrapper";
	private VisualEditor TrueRad = new VisualEditor(uiDriver, TrueRadToolId,
			TrueRadFrameId,TrueRadFooterId);

	private String FalseRadToolId = "RadWindowWrapper_RADFalseExplanation_toolbarMode";
	private String FalseRadFrameId = "RADFalseExplanation_contentIframe";
	private String FalseRadFooterId = "RADFalseExplanation_ModesWrapper";
	private VisualEditor FalseRad = new VisualEditor(uiDriver, FalseRadToolId,
			FalseRadFrameId,FalseRadFooterId);
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	    boolean flag=false;

	

	/* Constructor */
	public AddTrueFalseQuestionPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## AddTrueFalseQuestionPage ##");
	}

	/**
	 * This method will return Question Visual Editor
	 * 
	 * @return Visual Editor
	 * @throws Exception 
	 */
	public VisualEditor getQuestionRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return questionRad;
	}

	/**
	 * This method will return General Explanation Visual Editor
	 * 
	 * @return Visual Editor
	 * @throws Exception 
	 */
	public VisualEditor getGeneralExplanationRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return generalExplanationRad;
	}

	/**
	 * This method will return True Visual Editor
	 * 
	 * @return Visual Editor
	 * @throws Exception 
	 */
	public VisualEditor getTrueRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return TrueRad;
	}

	/**
	 * This method will return False Visual Editor
	 * 
	 * @return Visual Editor
	 * @throws Exception 
	 */
	public VisualEditor getFalseRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return FalseRad;
	}

	/**
	 * This method is used to click the add button on AddTrueFalseQuestionPage
	 * 
	 * @author Suchi.Singh
	 * @return Object
	 * @throws Exception
	 */
	public Object clickAddButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON ADD BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
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
	 * @return {@link String}
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
	 * @author Suchi.Singh
	 */

	public boolean isAlertPresent() throws Exception {
		boolean flag = false;
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
	 * This method is used to click the cancel button on ExamsCreatePage
	 * 
	 * @author monica.anand
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
	 * This method is used to enter points
	 * 
	 * @param pointsToBeEntered
	 * @return AddTrueFalseQuestionPage
	 * @throws Exception
	 */
	public AddTrueFalseQuestionPage enterPoints(String pointsToBeEntered)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE POINTS FOR TRUE / FALSE TYPE QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(pointsToBeEntered);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING THE POINTS FOR TRUE / FALSE TYPE QUESTION."
							+ "\n METHOD : enterPoints \n"
							+ e.getLocalizedMessage());
		}
		return new AddTrueFalseQuestionPage(uiDriver);
	}

	/**
	 * This method is used to select the correct answer radio button
	 * 
	 * @author Kiran.Kumar
	 * @param optionToBeSelected
	 * @return AddTrueFalseQuestionPage
	 * @throws Exception
	 *             value should be 0 for false and 1 for true
	 */
	public AddTrueFalseQuestionPage selectCorrectAnswerRadioButton(
			String _0forfalse1forTrue) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING THE CORRECT ANSWER RADIO BUTTON FOR TRUE / FALSE TYPE QUESTION.");
			frameSwitch.switchToFrameContent();
			radOption.replaceValues(_0forfalse1forTrue);
			uiDriver.waitToBeDisplayed(radOption, waitTime);
			radOption.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SELECTING THE CORRECT ANSWER RADIO BUTTON FOR TRUE / FALSE TYPE QUESTION."
							+ "\n METHOD : selectCorrectAnswerRadioButton \n"
							+ e.getLocalizedMessage());
		}
		return new AddTrueFalseQuestionPage(uiDriver);
	}

	/**
	 * This method is used to get the Confirmation pop-up message
	 * 
	 * @author monica.anand
	 * @throws Exception
	 * @return String
	 */
	public String getConfirmationPopUpMessage() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE CONFIRMATION POPUP MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
			alertMsg = uiDriver.getUIAlert()
					.acceptAlertIfPresentAndGetMessage();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING THE CONFIRMATION POPUP MESSAGE."
							+ "\n METHOD : getConfirmationPopUpMessage \n"
							+ e.getLocalizedMessage());
		}
		return alertMsg;
	}

	/**
	 * This method is used to accept alert
	 * 
	 * @author monica.anand
	 * @return ExamHomePage
	 * @throws Exception
	 * 
	 */
	public ExamHomePage acceptAlert() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ACCEPTING THE ALERT.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();

		} catch (Exception e) {
			throw new Exception("ISSUE IN ACCEPTING THE ALERT."
					+ "\n METHOD : acceptAlert \n" + e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * This Method will check is Question RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isQuestionRADEditorDisplayed() throws Exception {
		boolean flag = false;
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
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isGeneralexplainationRADEditorDisplayed() throws Exception {
		boolean flag = false;
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
	 * This Method will check is TRUE RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isTrueRADEditorDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER TRUE RAD EDITOR IS BEING DISPLAYED");
			if (TrueRad != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER TRUE RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isTrueRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is FALSE RAD Editor Displayed
	 * 
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isFalseRADEditorDisplayed() throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER FALSE RAD EDITOR IS BEING DISPLAYED");
			if (FalseRad != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER FALSE RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isFalseRADEditorDisplayed \n"
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
	 * This is Service level method to Add True False Question Type
	 * 
	 * @author Kapil
	 * @param question
	 * @param	points
	 * @param	answer
	 * @param	trueExplanation
	 * @param	falseExplanation
	 * @param	generalExplanation
	 * @return ExamHomePage
	 */
	public ExamHomePage addTrueFalseQuestion(String question, String points,
			boolean answer, String trueExplanation, String falseExplanation,
			String generalExplanation) throws Exception {
		try {
			getQuestionRadEditor().enterText(question);
			logInstruction("LOG INSTRUCTION: ENTERED QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(points);
			logInstruction("LOG INSTRUCTION: ENTERED POINTS");
			frameSwitch.switchToFrameContent();
			if(answer) {
				radOption.replaceValues("1");
				logInstruction("LOG INSTRUCTION: SELECTING TRUE");
			} else {
				radOption.replaceValues("0");
				logInstruction("LOG INSTRUCTION: SELECTING FALSE");
			}
			uiDriver.waitToBeDisplayed(radOption, waitTime);
			radOption.clickNoWait();
			logInstruction("LOG INSTRUCTION: SELECTED CORRECT ANSWER OPTION");
			getTrueRadEditor().enterText(trueExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED TRUE EXPLANATION");
			getFalseRadEditor().enterText(falseExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED FALSE EXPLANATION");
			getGeneralExplanationRadEditor().enterText(generalExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED GENERAL EXPLANATION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED ON ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT IF PRESENT");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ADDING TRUE FALSE QUESTION TYPE"
							+ "\n METHOD : addTrueFalseQuestion \n"
							+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}
}
