package com.pearson.eselenium.ls.contentitems.exams.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.exams.pages.ExamHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentShortAnswerQuestionPage extends BasePageObject {

    /**
     * Initializing the elements
     * 
     */
    private UIElement btnSaveAnswer = createElement(UIType.Xpath, "//input[@id='btnSaveAnswers']");
    private UIElement btnSubmitForGrading = createElement(
            UIType.Xpath,
            "//input[@id='btnSubmitForGrade']");
    private UIElement lblhrefContent = createElement(
            UIType.Xpath,
            "//a[contains(@href,'EquellaLink')]");
    private UIElement btnBeginTestNow = createElement(
            UIType.Xpath,
            "//input[@value='Begin ExamTest Now']");
    private UIElement btnBeginTest = createElement(UIType.Xpath, "//input[@value='Begin ExamTest']");

    /* Constructor */
    public StudentShortAnswerQuestionPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## AddTrueFalseQuestionPage ##");

    }

    /**
     * Method helps to click on save answer button.
     * 
     * @return ExamHomePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ExamHomePage clickSaveAnswerButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAnswer, waitTime);
            btnSaveAnswer.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Answer' BUTTON" + "\n METHOD : clicksaveAnswerButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }

    /**
     * Method helps to click on submit for grading.
     * 
     * @return ExamHomePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ExamHomePage clickSubmitForGradingButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitForGrading, waitTime);
            btnSubmitForGrading.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGradingButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }

    /**
     * Method helps to get equella content
     * 
     * @return StudentShortAnswerQuestionPage
     * @throws Exception
     * @author saurabh.jain1
     */
    public StudentShortAnswerQuestionPage getEquellaContentFromTheQuestionType() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING EQUELLA CONTENT FROM THE QUESTION TYPE");

            uiDriver.waitToBeDisplayed(lblhrefContent, waitTime);
            lblhrefContent.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING EQUELLA CONTENT FROM THE QUESTION TYPE" + "\n METHOD : getEquellaContentFromTheQuestionType \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to click on begin test button.
     * 
     * @return ExamHomePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ExamHomePage clickBeginTestButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBeginTest, waitTime);
            btnBeginTest.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Begin' BUTTON" + "\n METHOD : clickBeginTestButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }

    /**
     * Method helps to click on begin test now button.
     * 
     * @return ExamHomePage
     * @throws Exception
     * @author saurabh.jain1
     */
    public ExamHomePage clickBeginTestNowButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN NOW BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBeginTestNow, waitTime);
            btnBeginTestNow.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Begin Now' BUTTON" + "\n METHOD : clickBeginTestNowButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }

}
