package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.util.ArrayList;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddMatchingQuestionPage extends BasePageObject {

    /* Elements */
    private String questionRadToolId = "RadWindowWrapper_RADQuestionText_toolbarMode";
    private String questionRadFrameId = "RADQuestionText_contentIframe";
    private String questionRadFooterId = "RADQuestionText_ModesWrapper";
    private VisualEditor questionRad = new VisualEditor(
            uiDriver,
            questionRadToolId,
            questionRadFrameId,questionRadFooterId);
    private int responsesCount;
	private String[] matchingTextRadToolId;
	private String[] matchingTextRadFrameId;
	private String[] matchingTextRadFooterId;
	private String[] matchingAnswerRadToolId;
	private String[] matchingAnswerRadFrameId;
	private String[] matchingAnswerRadFooterId;
	private VisualEditor[] matchingTextRadList;
	private VisualEditor[] matchingAnswerRadList;
    private String generalExplanationRadToolId = "RadWindowWrapper_RADGeneralExplanation_toolbarMode";
    private String generalExplanationRadFrameId = "RADGeneralExplanation_contentIframe";
    private String generalExplanationRadFooterId = "RADGeneralExplanation_ModesWrapper";
    private VisualEditor generalExplanationRad = new VisualEditor(
            uiDriver,
            generalExplanationRadToolId,
            generalExplanationRadFrameId,generalExplanationRadFooterId);
    private UIElement btnAdd = createElement(UIType.Xpath, "//*[@id='button3']");
    private String alertMsg;
    private UIElement btnCancel = createElement(UIType.ID, "button2");
    private UIElement txtPoints = createElement(UIType.Name, "RADPoints");
    private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
    boolean flag=false;
    
    /* Constructor */
    public AddMatchingQuestionPage(UIDriver driver) {
        super(driver);
        setResponsesCount();
		ArrayList<VisualEditor> matchingTextRadListArray = new ArrayList<VisualEditor>();
		ArrayList<VisualEditor> matchingAnswerRadListArray = new ArrayList<VisualEditor>();
		for (int i = 0; i < responsesCount; i++) {
			matchingTextRadToolId[i] = "RadWindowWrapper_RADMatchingLeft" + i
					+ "_toolbarMode";
			matchingTextRadFrameId[i] = "RADMatchingLeft" + i + "_contentIframe";
			matchingTextRadFooterId[i] = "RADMatchingLeft" + i + "_ModesWrapper";
			matchingTextRadListArray.add(new VisualEditor(uiDriver,
					matchingTextRadToolId[i], matchingTextRadFrameId[i],matchingTextRadFooterId[i]));
		}
		matchingTextRadList = matchingTextRadListArray.toArray(new VisualEditor[responsesCount]);
		for (int i = 0; i < responsesCount; i++) {
			matchingAnswerRadToolId[i] = "RadWindowWrapper_RADMatchingRight" + i
					+ "_toolbarMode";
			matchingAnswerRadFrameId[i] = "RADMatchingRight" + i + "_contentIframe";
			matchingAnswerRadFooterId[i] = "RADMatchingRight" + i + "_ModesWrapper";
			matchingAnswerRadListArray.add(new VisualEditor(uiDriver,
					matchingAnswerRadToolId[i], matchingAnswerRadFrameId[i],matchingAnswerRadFooterId[i]));
		}
		matchingAnswerRadList = matchingAnswerRadListArray.toArray(new VisualEditor[responsesCount]);
        logInstruction("LOG INSTRUCTION : ### AddMatchingQuestionPage ###");
    }

    private void setResponsesCount() {
		this.responsesCount = 5;
		//Todo
		matchingTextRadToolId = new String[this.responsesCount];
		matchingTextRadFrameId = new String[this.responsesCount];
		matchingTextRadFooterId = new String[this.responsesCount];
		matchingAnswerRadToolId = new String[this.responsesCount];
		matchingAnswerRadFrameId = new String[this.responsesCount];
		matchingAnswerRadFooterId = new String[this.responsesCount];
	}
    
    public VisualEditor getQuestionRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return questionRad;
    }

    public VisualEditor getMatchingTextRadEditor(int index) throws Exception {
    	 frameSwitch.switchToFrameContent();
        return matchingTextRadList[index];
    }

    public VisualEditor getMatchingAnswerRadEditor(int index) throws Exception {
    	 frameSwitch.switchToFrameContent();
        return matchingAnswerRadList[index];
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
            btnAdd.clickNoWait();
            alertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            if (alertMsg.contains("Question Added Successfully.")) {
                return new ExamHomePage(uiDriver);
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Add' BUTTON" + "\n METHOD : clickAddButton \n" + e
                            .getLocalizedMessage());
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
            throw new Exception("ISSUE IN CHECKING FOR ALERT" + "\n METHOD : isAlertPresent \n" + e
                    .getLocalizedMessage());
        }
        return flag;
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
                    "ISSUE IN VERIFYING WHETHER QUESTION RAD EDITOR IS DISPLAYED OR NOT" + "\n METHOD : isQuestionRADEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check is MATCHING TEXT RAD Editor Displayed
     * @param index
     * @return boolean
     * @throws Exception
     * @author Suchi.Singh
     */
    public boolean isMatchingTextRadEditorDisplayed(int index) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING WHETHER MATCHING TEXT RAD EDITOR IS DISPLAYED");
            if (matchingTextRadList[index-1] != null) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER MATCHING TEXT RAD EDITOR IS DISPLAYED OR NOT" + "\n METHOD : isMatchingTextRadEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check is MATCHING ANSWER RAD Editor Displayed
     * @param index
     * @return boolean
     * @throws Exception
     * @author Suchi.Singh
     */
    public boolean isMatchingAnswerRadEditorDisplayed(int index) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING WHETHER MATCHING ANSWER RAD EDITOR IS DISPLAYED");
            if (matchingAnswerRadList[index-1] != null) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER MATCHING ANSWER RAD EDITOR IS DISPLAYED OR NOT" + "\n METHOD : isMatchingAnswerRadEditorDisplayed \n" + e
                            .getLocalizedMessage());
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
                    "ISSUE IN VERIFYING WHETHER GENERAL EXPLANATION RAD EDITOR IS DISPLAYED OR NOT" + "\n METHOD : isGeneralexplainationRADEditorDisplayed \n" + e
                            .getLocalizedMessage());
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
                    "ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION." + "\n METHOD : isEditorSwitchDisplayed \n" + e
                            .getLocalizedMessage());
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
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Cancel' BUTTON" + "\n METHOD : clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }
    
    /**
	 * This method is used to enter points
	 * 
	 * @param pointsToBeEntered
	 * @return AddMatchingQuestionPage
	 * @throws Exception
	 */
	public AddMatchingQuestionPage enterPoints(String pointsToBeEntered)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE POINTS FOR MATCHING TYPE QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(pointsToBeEntered);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING THE POINTS FOR MATCHING TYPE QUESTION."
							+ "\n METHOD : enterPoints \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This is Service level method to Add Multiple Answer Question Type
	 * 
	 * @author Kapil
	 * @param question
	 * @param points
	 * @param matchingText
	 * @param matchingAnswers
	 * @param numberOfResponses
	 * @param generalExplanation
	 * @return ExamHomePage
	 */
	public ExamHomePage addMatchingQuestion(String question,
			String points, String[] matchingText, String[] matchingAnswers,
			int numberOfResponses, String generalExplanation) throws Exception {
		try {
			getQuestionRadEditor().enterText(question);
			logInstruction("LOG INSTRUCTION: ENTERED QUESTION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPoints, waitTime);
			txtPoints.clearAndSendKeys(points);
			logInstruction("LOG INSTRUCTION: ENTERED POINTS");
			for (int i = 0; i < numberOfResponses && i < responsesCount; i++) {
				matchingTextRadList[i].enterText(matchingText[i]);
				logInstruction("LOG INSTRUCTION: ENTERED MATCHING TEXT " + i);
				matchingAnswerRadList[i].enterText(matchingAnswers[i]);
				logInstruction("LOG INSTRUCTION: ENTERED MATCHING ANSWER " + i);
			}
			getGeneralExplanationRadEditor().enterText(generalExplanation);
			logInstruction("LOG INSTRUCTION: ENTERED GENERAL EXPLANATION");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception("ISSUE IN CREATING MULTIPLE ANSWER QUESTION."
					+ "\n METHOD : addMultipleAnswerQuestion \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}
}
