package com.pearson.eselenium.ls.contentitems.exams.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.exams.pages.GradingSummaryPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentTrueFalseQuestionPage extends BasePageObject {

    /* Elements */
    private UIElement btnSaveAnswer = createElement(UIType.Css, "#btnSaveAnswers");
    private UIElement btnSubmitForgrading = createElement(UIType.Css, "#btnSubmitForGrade");
    private UIElement txtEquellaContent = createElement(
            UIType.Css,
            "#tdWithStyle>fieldset>legend>table>tbody>tr>td>a");

    /* Constructor */
    public StudentTrueFalseQuestionPage(UIDriver uidriver) {
        super(uidriver);
        logInstruction("LOG INSTRUCTION: ## GradingSummaryPage ##");
    }

    /**
     * Method helps to click Save Answer button
     * 
     * @author soundarya
     * @return StudentTrueFalseQuestionPage
     */
    public StudentTrueFalseQuestionPage clickSaveAnswer() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAnswer, waitTime);
            btnSaveAnswer.click();
            uiDriver.switchTo().alert().accept();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Answer' BUTTON" + "\n METHOD : clickSaveAnswer \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click Submit For Grading button
     * 
     * 
     * @author soundarya
     * @return GradingSummaryPage
     */
    public GradingSummaryPage clickSubmitForGrading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitForgrading, waitTime);
            btnSubmitForgrading.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGrading \n" + e
                            .getLocalizedMessage());
        }
        return new GradingSummaryPage(uiDriver);
    }

    /**
     * Method helps to get Equella Content From The Question Type
     * 
     * 
     * @author soundarya
     * @return String
     */
    public String getEquellaContentFromTheQuestionType() throws Exception {
        String equellaContent = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING EQUELLA CONTENT FROM THE QUESTION TYPE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEquellaContent, waitTime);
            equellaContent = txtEquellaContent.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING EQUELLA CONTENT FROM THE QUESTION TYPE" + "\n METHOD : getEquellaContentFromTheQuestionType \n" + e
                            .getLocalizedMessage());
        }
        return equellaContent;
    }
}
