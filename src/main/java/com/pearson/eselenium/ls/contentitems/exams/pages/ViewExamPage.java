package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewExamPage extends BasePageObject {

    /* UIElements */
    private UIElement btnBegin = createElement(UIType.Css, ".buttontd");
    private UIElement btnBeginNow = createElement(UIType.Css, ".buttontd");
    private UIElement btnSaveAnswer = createElement(UIType.Css, "#btnSaveAnswers2");
    private UIElement btnSubmitForGrading = createElement(UIType.Css, "#btnSubmitForGrade2");
    private UIElement chkAnswer = createElement(UIType.Css, "#{1}{2}{3}");
    private UIElement txtExamCompleteTableText = createElement(UIType.Css, ".dkgraytext");
    private UIElement valAccessDate = createElement(
            UIType.Xpath,
            "//tr[th[contains(text(),'Access dates:')]]//td");
    private UIElement valReviewGradebookOn = createElement(
            UIType.Xpath,
            "//tr[th[contains(text(),'Can be reviewed in Gradebook on:')]]//td");
    private UIElement btnBeginExam = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Begin')]");

    private String ShortAnswerRadToolId = "radEntryText";
    private String ShortAnswerRadFrameId = "radEntryText_contentIframe";
    private VisualEditor ShortAnswerRad = new VisualEditor(
            uiDriver,
            ShortAnswerRadToolId,
            ShortAnswerRadFrameId,ShortAnswerRadToolId);
    private String EssayRadToolId = "radEntryText";
    private String EssayRadFrameId = "radEntryText_contentIframe";
    private VisualEditor EssayRad = new VisualEditor(uiDriver, EssayRadToolId, EssayRadFrameId,EssayRadToolId);
 private UIElement txtStartDateValue = createElement(UIType.Xpath, "//div[contains(.,'{1}')]");

    boolean flag = false;

    /* Constructor */
    public ViewExamPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## ExamHomePage ##");
    }

    public VisualEditor getShortAnswerRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return ShortAnswerRad;
    }

    public VisualEditor getEssayRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return EssayRad;
    }
    /**
     * This Method is used to get text from the exam page
     * 
     * @return String
     * @throws Exception
     * @author Soundarya
     */
    public String getContentFromPlainText() throws Exception {
    	String text ;
        try {
            logInstruction("get text of plain text editor");
            frameSwitch.switchToFrameContent();
            UIElement content = createElement(UIType.Xpath, "//form/table[2]//table//fieldset/legend/table//tr/td");

            text= content.getText();
            
        } catch (Exception e) {
            throw new Exception("unable to get the text" + e.getLocalizedMessage());

        }
        return text;
    }

    /**
     * This method will click the Begin button on the first page of Exam to be taken.
     * 
     * @author Vivek.Singh
     * @return ViewExamPage
     * @throws Exception
     * **/
    public ViewExamPage clickBeginButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBegin, waitTime);
            btnBegin.clickNoWait();
            logInstruction("LOG INSTRUCTION: Clicked Begin button.");
            return this;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Begin' BUTTON" + "\n METHOD : clickBeginButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will click the Begin Now button on the second page of Exam to be taken.
     * 
     * @author Vivek.Singh
     * @return ViewExamPage
     * @throws Exception
     * **/
    public ViewExamPage clickBeginNowButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN NOW BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBeginNow, waitTime);
            btnBeginNow.clickNoWait();
            logInstruction("LOG INSTRUCTION: Clicked Begin Now button.");
            return this;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Begin Now' BUTTON" + "\n METHOD : clickBeginNowButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will click the Save Answers Button on Exam page.
     * 
     * @author Vivek.Singh
     * @return ViewExamPage
     * @throws Exception
     * **/
    public ViewExamPage clickSaveAnswersButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE ANSWER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveAnswer, waitTime);
            btnSaveAnswer.clickNoWait();
            uiDriver.switchTo().alert().accept();
            logInstruction("LOG INSTRUCTION: CLICKED ON SAVE ANSWER BUTTON.");
            return this;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Answer' BUTTON" + "\n METHOD : clickSaveAnswersButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will click the Submit for Grading Button on Exam page.
     * 
     * @author Vivek.Singh
     * @return ViewExamPage
     * @throws Exception
     * **/
    public ViewExamPage clickSubmitForGradingButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitForGrading, waitTime);
            btnSubmitForGrading.clickNoWait();
            uiDriver.switchTo().alert().accept();
            logInstruction("LOG INSTRUCTION: CLICKED ON SUBMIT FOR GRADING BUTTON.");
            return this;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGradingButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will select answer to the true false type. provide the following Strings for
     * respective question type. True false for True/False MultipleChoice for Multiple Choice
     * ManyMultipleChoice for Many Multiple Choice.
     * 
     * @param String
     *            questionType, String questionNumber, String option
     * @return {@link ViewExamPage}
     * @throws Exception
     **/
    public ViewExamPage selectAnswer(String questionType, String questionNumber, String option)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING ANSWER. ");
            frameSwitch.switchToFrameContent();

            // This will check for the type question.
            if (questionType.equalsIgnoreCase("Truefalse") || questionType
                    .equalsIgnoreCase("ManyMultipleChoice"))
                option = "_" + option;
            else
                if (questionType.equalsIgnoreCase("MultipleChoice"))
                    option = "_0_" + option;

            // This will put the questiontype, questionNumber and option in to
            // the css selector of
            // chkTruefalse.
            chkAnswer.replaceValues(questionType, questionNumber, option);

            uiDriver.waitToBeDisplayed(chkAnswer, waitTime);
            chkAnswer.clickNoWait();
            logInstruction("LOG INSTRUCTION: Selected Answer.");
            return this;
        } catch (Exception e) {
            throw new Exception("ISSUE IN SELECTING ANSWER." + "\n METHOD : selectAnswer \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * method will get the table text from the exam completed page
     * 
     * @author Praveen.Maled
     * @param String
     *            verifyString
     * @return boolean
     * @throws Exception
     */
    public boolean isExamCompletedPageDisplayed(String verifyString) throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: GET EXAM COMPLETE PAGE TABLE TEXT");
            verifyString = verifyString.toLowerCase();

            uiDriver.waitToBeDisplayed(txtExamCompleteTableText);
            if (txtExamCompleteTableText.isDisplayed()) {
                flag = txtExamCompleteTableText.getText().toLowerCase().contains(verifyString);
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING EXAM IS COMPLETED OR NOT." + "\n METHOD : isExamCompletedPageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category milestone 2 Method is used to get values from Access Date Field
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getAccessDateFieldValues() throws Exception {
        String value = null;
        try {
            logInstruction("LOG INSTRUCTION: GET VALUES FROM ACCESS DATE FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(valAccessDate, waitTime);
            value = valAccessDate.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET VALUES FROM ACCESS DATE FIELD." + "\n METHOD : getAccessDateFieldValues \n" + e
                            .getLocalizedMessage());
        }
        return value;
    }

    /**
     * @category milestone 2 Method is used to get values from can be reviewed in Gradebook On Field
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getCanBeReviewedInGradebookOnMessage() throws Exception {
        String message = null;
        try {
            logInstruction("LOG INSTRUCTION: GET VALUES FROM CAN BE REVIEWED IN GRADEBOOK ON FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(valReviewGradebookOn, waitTime);
            message = valReviewGradebookOn.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET VALUES FROM CAN BE REVIEWD IN GRADEBOOK ON FIELD." + "\n METHOD : getCanBeReviewedInGradebookOnMessage \n" + e
                            .getLocalizedMessage());
        }
        return message;
    }

    /**
     * @category milestone 2 Method is used to verify Begin Exam button
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isBeginExamButtonDisplayed() throws Exception {
        boolean isButtonDisplayed = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY BEGIN EXAM BUTTON");
            frameSwitch.switchToFrameContent();

            isButtonDisplayed = btnBeginExam.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET VERIFY BEGIN EXAM BUTTON." + "\n METHOD : getCanBeReviewedInGradebookOnMessage \n" + e
                            .getLocalizedMessage());
        }
        return isButtonDisplayed;
    }

    /**
     * @category milestone 2 Method is used to get values from Access Date Field
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isAccessDateFieldValuesWithBothCheckBoxEnabled(String date) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE DATES IN ACCESS DATE FILED");
            frameSwitch.switchToFrameContent();
            txtStartDateValue.replaceValues(date);
            flag = txtStartDateValue.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET VALUES FROM ACCESS DATE FIELD." + "\n METHOD : getAccessDateFieldValuesWithBothCheckBoxEnabled \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

}
