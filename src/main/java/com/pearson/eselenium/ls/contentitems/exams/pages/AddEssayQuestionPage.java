package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddEssayQuestionPage extends BasePageObject {

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
    private UIElement btnAdd = createElement(UIType.Xpath, "//*[@id='button3']");
    private String alertMsg;
    private UIElement btnCancel = createElement(UIType.ID, "button2");
    private UIElement radpoints = createElement(UIType.ID, "RADPoints");
    private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");

    /* Variables */
    boolean flag;

    /* Constructor */
    public AddEssayQuestionPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION : ### AddEssayQuestionPage ###");
    }

    /**
     * This method will return the Question Visual Editor Object
     * 
     * @return Visual Editor
     * @throws Exception 
     */
    public VisualEditor getQuestionRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return questionRad;
    }

    /**
     * This method will return the General Explanation Visual Editor Object
     * 
     * @return Visual Editor
     * @throws Exception 
     */
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
     * Method helps to verify Alternative Editor Present or not.
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
	 * This is Service level method to Add Essay Question Type
	 * 
	 * @author Kapil
	 * @param question
	 * @param points
	 * @param generalExplanation
	 * @return ExamHomePage
	 */
    public ExamHomePage addEssayQuestion(String question, String points, String generalExplanation) throws Exception {
    	try {
    		getQuestionRadEditor().enterText(question);
    		logInstruction("LOG INSTRUCTION: ENTERED QUESTION");
    		frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radpoints, waitTime);
            radpoints.sendKeys(points);
            logInstruction("LOG INSTRUCTION: ENTERED POINTS");
            getGeneralExplanationRadEditor().enterText(generalExplanation);
            logInstruction("LOG INSTRUCTION: ENTERED GENERAL EXPLANATION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            btnAdd.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON ADD BUTTON");
            uiDriver.getUIAlert().acceptAlertIfPresent();
            logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
    	} catch (Exception e) {
    		throw new Exception(
					"ISSUE IN CREATING ESSAY QUESTION."
							+ "\n METHOD : addEssayQuestion \n"
							+ e.getLocalizedMessage());
    	}
    	return new ExamHomePage(uiDriver);
    	
    }
}
