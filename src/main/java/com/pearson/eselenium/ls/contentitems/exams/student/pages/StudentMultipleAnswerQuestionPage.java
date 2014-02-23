package com.pearson.eselenium.ls.contentitems.exams.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentMultipleAnswerQuestionPage extends BasePageObject {

    /* Elements */
    private UIElement txtEquellaContent = createElement(
            UIType.Xpath,
            "//fieldset/legend/table/tbody/tr/td/a");
    private UIElement btnSave = createElement(UIType.Css, "#btnSaveAnswers");
    private UIElement btnSubmitForGrading = createElement(UIType.Css, "#btnSubmitForGrade");
    private boolean isAlertPresent;
    private String alertMessage;
    String data;

    /* Constructor */
    public StudentMultipleAnswerQuestionPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## StudentMultipleAnswerQuestion Page ##");
    }

    /**
     * This Method will check whether Alert is present or not
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isAlert() throws Exception {
        if (alertMessage != null) {
            isAlertPresent = true;
        } else {
            isAlertPresent = false;
        }
        return isAlertPresent;
     }

    /**
     * This Method will give you the Text of the Equella.
     * 
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getEquellaText() throws Exception {
        data = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT OF THE EQUELLA.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEquellaContent, waitTime);
            data = txtEquellaContent.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING TEXT OF THE EQUELLA." + "\n METHOD : getEquellaText \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }

    /**
     * This Method will click on Save Answer button
     * 
     * @return StudentMultipleAnswerQuestionPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public StudentMultipleAnswerQuestionPage clickSaveAnswer() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.clickNoWait();
            if (isAlert()) {
                alertMessage = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Answer' BUTTON" + "\n METHOD : clickSaveAnswer \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on Submit grading button .
     * 
     * @return StudentMultipleAnswerQuestionPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public StudentMultipleAnswerQuestionPage clickSubmitForGrading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitForGrading, waitTime);
            btnSubmitForGrading.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGrading \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
}
