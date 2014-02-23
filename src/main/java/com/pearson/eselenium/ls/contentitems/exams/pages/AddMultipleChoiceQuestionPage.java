package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.util.ArrayList;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddMultipleChoiceQuestionPage extends BasePageObject {

	/* Elements */
	private String questionRadToolId = "RadWindowWrapper_RADQuestionText_toolbarMode";
	private String questionRadFrameId = "RADQuestionText_contentIframe";
	 private String questionRadFooterId = "RADQuestionText_ModesWrapper";
	    private VisualEditor questionRad = new VisualEditor(
	            uiDriver,
	            questionRadToolId,
	            questionRadFrameId,questionRadFooterId);
	private int responsesCount;
	private String[] responseRadToolId;
	private String[] responseRadFrameId;
	private String[] responseRadFooterId;
	private String[] explanationRadToolId;
	private String[] explanationRadFrameId;
	private String[] explanationRadFooterId;
	private VisualEditor[] responseRadList;
	private VisualEditor[] explanationRadList;
	private String generalExplanationRadToolId = "RadWindowWrapper_RADGeneralExplanation_toolbarMode";
	private String generalExplanationRadFrameId = "RADGeneralExplanation_contentIframe";
	 private String generalExplanationRadFooterId = "RADGeneralExplanation_ModesWrapper";
	    private VisualEditor generalExplanationRad = new VisualEditor(
	            uiDriver,
	            generalExplanationRadToolId,
	            generalExplanationRadFrameId,generalExplanationRadFooterId);
	private UIElement btnCancel = createElement(UIType.ID, "button2");
	private UIElement btnAdd = createElement(UIType.Xpath, "//*[@id='button3']");;
	private UIElement txtPoints = createElement(UIType.Name, "RADPoints");
	private UIElement radOption = createElement(UIType.Css, "#RADCorrectAnswer{1}");
	private String alertMsg;
	  private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	    boolean flag=false;
	  
	/* Constructor */
	public AddMultipleChoiceQuestionPage(UIDriver driver) {
		super(driver);
		setResponsesCount();
		ArrayList<VisualEditor> responseRadListArray = new ArrayList<VisualEditor>();
		ArrayList<VisualEditor> explanationRadListArray = new ArrayList<VisualEditor>();
		for (int i = 0; i < responsesCount; i++) {
			responseRadToolId[i] = "RadWindowWrapper_RADresponse" + i
					+ "_toolbarMode";
			responseRadFrameId[i] = "RADresponse" + i + "_contentIframe";
			responseRadFooterId[i] = "RADresponse" + i + "_ModesWrapper";
			responseRadListArray.add(new VisualEditor(uiDriver,
					responseRadToolId[i], responseRadFrameId[i],responseRadFooterId[i]));
		}
		responseRadList = responseRadListArray.toArray(new VisualEditor[responsesCount]);
		for (int i = 0; i < responsesCount; i++) {
			explanationRadToolId[i] = "RadWindowWrapper_RADexplanation" + i
					+ "_toolbarMode";
			explanationRadFrameId[i] = "RADexplanation" + i + "_contentIframe";
			explanationRadFooterId[i] = "RADexplanation" + i + "_ModesWrapper";
			explanationRadListArray.add(new VisualEditor(uiDriver,
					explanationRadToolId[i], explanationRadFrameId[i],explanationRadFooterId[i]));
		}
		explanationRadList = explanationRadListArray.toArray(new VisualEditor[responsesCount]);
		logInstruction("LOG INSTRUCTION: ## Add Multiple Choice Question ##");
	}

	private void setResponsesCount() {
		this.responsesCount = 5;
		//Todo
		responseRadToolId = new String[this.responsesCount];
		responseRadFrameId = new String[this.responsesCount];
		responseRadFooterId = new String[this.responsesCount];
		explanationRadToolId = new String[this.responsesCount];
		explanationRadFrameId = new String[this.responsesCount];	
		explanationRadFooterId = new String[this.responsesCount];
	}

	public VisualEditor getQuestionRadEditor() throws Exception {
		 frameSwitch.switchToFrameContent();
		return questionRad;
	}

	public VisualEditor getResponseRadEditor(int index) throws Exception {
		 frameSwitch.switchToFrameContent();
		return responseRadList[index];
	}

	public VisualEditor getExplanationRadEditor(int index) throws Exception {
		 frameSwitch.switchToFrameContent();
		return explanationRadList[index];
	}

	public VisualEditor getGeneralExplanationRadEditor() throws Exception {
		 frameSwitch.switchToFrameContent();
		return generalExplanationRad;
	}

	/**
	 * This Method will click on Add button if all the mandatory data is
	 * entered.
	 * 
	 * @return examHomePage
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
	 * This Method will check is Question RAD Editor Displayed
	 * 
	 * @return boolean
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
	 * This Method will check is Response RAD Editor Displayed
	 * 
	 * @return boolean
	 * @param	index
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isResponseRadEditorDisplayed(int index) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER RESPONSE RAD EDITOR IS DISPLAYED");
			if (responseRadList[index-1] != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER RESPONSE RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isResponseRadEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is Explanation RAD Editor Displayed
	 * 
	 * @return boolean
	 * @param	index
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isExplanationRadEditorDisplayed(int index) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER EXPLANATION RAD EDITOR IS DISPLAYED");
			if (explanationRadList[index-1] != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER EXPLANATION RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isExplanationRadEditorDisplayed \n"
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
	 * This Method will check whether Alert is present or not.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
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
     * This method is used to select the correct answer radio button
     * 
     * @author Suchi.Singh
     * @param String index
     * @return AddMultipleChoiceQuestionPage
     * @throws Exception
     *             
     */
    public AddMultipleChoiceQuestionPage selectCorrectAnswer(String index)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE CORRECT ANSWER RADIO BUTTON FOR MULTIPLE CHOICE QUESTION TYPE QUESTION.");
            frameSwitch.switchToFrameContent();
            radOption.replaceValues(index);
            uiDriver.waitToBeDisplayed(radOption, waitTime);
            radOption.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE CORRECT ANSWER RADIO BUTTON FOR MULTIPLE CHOICE QUESTION." + "\n METHOD : selectCorrectAnswer \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    
	/**
	 * This method is used to enter points
	 * @author Suchi.Singh
	 * @param pointsToBeEntered
	 * @return AddMultipleChoiceQuestionPage
	 * @throws Exception
	 */
	public AddMultipleChoiceQuestionPage enterPoints(String pointsToBeEntered)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE POINTS FOR TRUE / FALSE TYPE QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(pointsToBeEntered);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING THE POINTS FOR MULTIPLE CHOICE QUESTION."
							+ "\n METHOD : enterPoints \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This is Service level method to Add Multiple Choice Question Type
	 * 
	 * @author Kapil
	 * @param question
	 * @param points
	 * @param responses
	 * @param numberOfResponses
	 * @param correctResponseIndex
	 * @param generalExplanation
	 * @return ExamHomePage
	 */
	public ExamHomePage addMultipleChoiceQuestion(String question,
			String points, String[] responses, String[] explanations,
			int numberOfResponses, int correctResponseIndex,
			String generalExplanation) throws Exception {
		try {
			getQuestionRadEditor().enterText(question);
			logInstruction("LOG INSTRUCTION: ENTERED QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(points);
			logInstruction("LOG INSTRUCTION: ENTERED POINTS");
			for(int i = 0; i < numberOfResponses && i < responsesCount ; i++) {
				responseRadList[i].enterText(responses[i]);
				logInstruction("LOG INSTRUCTION: ENTERED RESPONSE " + i);
				explanationRadList[i].enterText(explanations[i]);
				logInstruction("LOG INSTRUCTION: ENTERED EXPLANATION " + i);
			}
			frameSwitch.switchToFrameContent();
            radOption.replaceValues(Integer.toString(correctResponseIndex));
            uiDriver.waitToBeDisplayed(radOption, waitTime);
            radOption.clickAndWait(waitTime);
			getGeneralExplanationRadEditor().enterText(generalExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED GENERAL EXPLANATION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CREATING MULTIPLE CHOICE QUESTION."
							+ "\n METHOD : addMultipleChoiceQuestion \n"
							+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}
}
