package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewExamHomePage extends BasePageObject {

    /* Elements */
    private UIElement btnBegin = createElement(UIType.Css, ".buttontd");
    private UIElement lblHeaderTitle = createElement(UIType.Xpath, "html/body/h1/div");
    private UIElement lblQuestionDisplayed = createElement(
            UIType.Xpath,
            "//*[@id='tdWithStyle']/fieldset/legend/table/tbody/tr/td[contains(.,'{1}')]");
    private UIElement lblTextRelatedQuestionDisplayed = createElement(
            UIType.Xpath,
            "//*[@id='tdWithStyle']/div/label[contains(.,'{1}')]");

    /* Constructor */
    public ViewExamHomePage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## ViewExamHomePage ##");
    }

    
    /**
     * This method will get the header title
     * 
     * @author Suchi.Singh
     * @return String
     * @throws Exception
     * **/
    public String getHeaderTitle() throws Exception {
        String hearderTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            hearderTitle = lblHeaderTitle.getText();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE HEADER TITLE." + "\n METHOD : getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return hearderTitle;
    }

    /**
     * This method will check whether particular question is being displayed except fill in the
     * blanks, Short Answer & Essay type Questions
     * 
     * @author Suchi.Singh
     * @param String
     *            Question
     * @return boolean
     * @throws Exception
     * **/
    public boolean isQuestionDisplayed(String Question) throws Exception {
        boolean QuestionDisplayed = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE QUESTION WHETHER IT IS BEING DISPLAYED OR NOT.");
            frameSwitch.switchToFrameContent();
            lblQuestionDisplayed.replaceValues(Question);
            uiDriver.waitToBeDisplayed(lblQuestionDisplayed, waitTime);
            if (lblQuestionDisplayed.isDisplayedAfterWaiting(waitTime)) {
                QuestionDisplayed = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING FOR THE QUESTION WHETHER IT IS BEING DISPLAYED OR NOT." + "\n METHOD : isQuestionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return QuestionDisplayed;
    }

    /**
     * This method will check whether fill in the blanks, Short Answer & Essay type Question is
     * being displayed
     * 
     * @author Suchi.Singh
     * @param String
     *            Question
     * @return boolean
     * @throws Exception
     * **/
    public boolean isTextRelatedQuestionDisplayed(String Question) throws Exception {
        boolean QuestionDisplayed = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE QUESTION WHETHER IT IS BEING DISPLAYED OR NOT.");
            frameSwitch.switchToFrameContent();
            lblTextRelatedQuestionDisplayed.replaceValues(Question);
            uiDriver.waitToBeDisplayed(lblTextRelatedQuestionDisplayed, waitTime);
            if (lblTextRelatedQuestionDisplayed.isDisplayedAfterWaiting(waitTime)) {
                QuestionDisplayed = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING FOR THE QUESTION WHETHER IT IS BEING DISPLAYED OR NOT." + "\n METHOD : isTextRelatedQuestionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return QuestionDisplayed;
    }

    /**
     * This method will click the Begin button on the first page of Exam to be taken.
     * 
     * @author Suchi.Singh
     * @return ViewExamHomeInstructionsPage
     * @throws Exception
     * **/
    public ViewExamHomeInstructionsPage clickBeginButton() throws Exception {
        try {
            logInstruction("Clicking Begin button.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBegin, waitTime);
            btnBegin.clickNoWait();
            logInstruction("Clicked Begin button.");
            return new ViewExamHomeInstructionsPage(uiDriver);
        } catch (Exception e) {
            throw new Exception("Unable to click Begin button" + e.getLocalizedMessage());
        }
    }
}
