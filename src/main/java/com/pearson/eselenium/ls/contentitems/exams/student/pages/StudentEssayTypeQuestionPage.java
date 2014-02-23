package com.pearson.eselenium.ls.contentitems.exams.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentEssayTypeQuestionPage extends BasePageObject {

    /* Elements */
    private UIElement btnSaveAnswer = createElement(UIType.Css, "#btnSaveAnswers");
    private UIElement lblEquellaText = createElement(UIType.Css, ".examQuestionTextSpace>label>a");
    private UIElement btnSubmitForGrading = createElement(UIType.Css, "#btnSubmitForGrade2");

    String data;
    boolean flag;
    
    /* Constructor */
    public StudentEssayTypeQuestionPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## StudentEssayTypeQuestion Page ##");
    }

    /**
     * This Method will click on Save answer button on Student Exam Page
     * 
     * @return StudentEssayTypeQuestionPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public StudentEssayTypeQuestionPage clickSaveAnswer() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAnswer, waitTime);
            btnSaveAnswer.clickNoWait();
            if (isAlert())
                uiDriver.getUIAlert().acceptAlertIfPresent();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Answer' BUTTON" + "\n METHOD : clickSaveAnswer \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will give the Text of the Equella Content.
     * 
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getEquellaText() throws Exception {
        data = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT OF EQUELLA. ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEquellaText, waitTime);
            data = lblEquellaText.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING TEXT OF EQUELLA." + "\n METHOD : getEquellaText \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }

    /**
     * This Method will click on Submit for Grading button
     * 
     * @return StudentGradingSummaryPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public StudentGradingSummaryPage clickSubmitForGrading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitForGrading, waitTime);
            btnSubmitForGrading.clickNoWait();
            if (isAlert())
                uiDriver.getUIAlert().acceptAlertIfPresent();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGradingButton \n" + e
                            .getLocalizedMessage());
        }
        return new StudentGradingSummaryPage(uiDriver);
    }

    /**
     * This Method will check whether Alert is present or not
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean isAlert() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR ALERT");
            uiDriver.switchTo().alert();
            flag = true;
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO GET THE ALERT");
            throw new Exception("ISSUE IN CHECKING FOR ALERT" + "\n METHOD : isAlert \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

}
