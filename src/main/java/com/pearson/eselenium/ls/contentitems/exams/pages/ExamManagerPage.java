package com.pearson.eselenium.ls.contentitems.exams.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ExamManagerPage extends BasePageObject {

    /* Elements */
    private UIElement btnSave = createElement(UIType.Css, "#btnSaveAnswers2");
    private UIElement btnGrade = createElement(UIType.Css, "#btnSubmitForGrade2");
    private UIElement areaEntercontentinRAD = createElement(UIType.Css, "html>body");
    private UIElement btnAjaxChecker = createElement(
            UIType.Css,
            "a[title='AJAX Spellchecker']>span");
    private UIElement btnSpellchecker = createElement(UIType.Css, "#RadESpellError_0");
    private UIElement tblSpellSuggestion = createElement(
            UIType.Css,
            "div[class='Default reDropDownBody reAjaxSpellCheck']");
    private UIElement lblHighlitedWord = createElement(UIType.Css, "span[id='RadESpellError_0']");
    private String postion = null;
    private UIElement areaTruefalseresponse1 = createElement(UIType.Xpath, "//tbody/tr/td[4]/input");
    private UIElement areaTruefalseresponse2 = createElement(UIType.Xpath, "//tbody/tr/td[8]/input");
    private UIElement txttruefalseresponse1 = createElement(UIType.Xpath, "//tbody/tr/td[4]/label");
    private UIElement txttruefalseresponse2 = createElement(UIType.Xpath, "//tbody/tr/td[8]label");
    private UIElement txtResponseofSA = createElement(
            UIType.Xpath,
            "//tr[td[table[tbody[tr[td[contains(text(),'{1}')]]]]]]/following-sibling::tr[1]/descendant::div");

    /* Constructor */
    public ExamManagerPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Exam Manager Page ##");
    }

    /**
     * This method will click on save btn
     * 
     * @return {@link ExamManagerPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ExamManagerPage clickSaveBtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save' BUTTON" + "\n METHOD : clickSaveBtn \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on submit for grading button
     * 
     * @return {@link ExamManagerPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public ExamManagerPage clickSubmitForGrading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT FOR GRADING BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnGrade, waitTime);
            btnGrade.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Submit For Grading' BUTTON" + "\n METHOD : clickSubmitForGrading \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will Handle Alert
     * 
     * @return {@link boolean}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean clickAlert() throws Exception {
    	boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE ALERT");
            uiDriver.getUIAlert().acceptAlertIfPresent();
            flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: NO ALERT FOUND" + "\n METHOD : clickAlert \n" + e
                            .getLocalizedMessage());           
        }
        return flag;
    }

    /**
     * This Method Will Enter the Content Into the RAD Editor
     * 
     * @param String
     *            position Enter the Position of RAD Editor Eg. 1. for 1st editor,2 for 2nd Editor
     * @param String
     *            content your content which you want to enter
     * @return {@link ExamManagerPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public ExamManagerPage enterContentInRADEditor(String Postion, String content) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTERING DATA TO RAD BODY");
            this.postion = Postion;
            switchToIFrame(Postion);
            uiDriver.waitToBeDisplayed(areaEntercontentinRAD, waitTime);
            areaEntercontentinRAD.sendKeys(content);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING DATA TO RAD BODY" + "\n METHOD : enterContentInRADEditor \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will click on Spell Checker Button On RAD Editor
     * 
     * @return {@link ExamManagerPage}
     * @throws Exception
     */

    public ExamManagerPage clickSpellCheckerButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SPELL CHECKER");
            switchToIFrame(postion);
            uiDriver.waitToBeDisplayed(btnAjaxChecker, waitTime);
            btnAjaxChecker.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON SPELL CHECKER" + "\n METHOD : clickSpellCheckerButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will Switch To IFrame on ExamManager Page
     * 
     * @param number
     *            Question number on which you want to switch
     * @author Shishir.Dwivedi
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void switchToIFrame(String number) throws Exception {
        String id = null;
        List<UIElement> frame = new ArrayList<UIElement>();

        try {
            logInstruction("LOG INSTRUCTION: SWITCHING TO IFRAME");
            frameSwitch.switchToFrameContent();
            frame = (List<UIElement>) uiDriver.findUIElement(UIType.TagName, "iframe");
            for (UIElement name : frame) {
                id = name.getAttribute("id");
                if (id.contains(number)) {
                    uiDriver.switchTo().frame(id);
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SWITCHING TO IFRAME" + "\n METHOD : switchToIFrame \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This Method will check whether spell checker is highlighted or not
     * 
     * @return {@link Boolean}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean istheWordHighlighted() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER THE WORD IS HIGHLITED OR NOT.");
            switchToIFrame(postion);
            uiDriver.waitToBeDisplayed(btnSpellchecker, waitTime);
            if (btnSpellchecker.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING WHETHER THE WORD IS HIGHLITED OR NOT." + "\n METHOD : istheWordHighlighted \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether Spell Suggestion is displayed or not
     * 
     * @return {@link Boolean}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isSpellSuggestionDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER SPELL SUGGESTION DISPLAYED OR NOT. ");
            switchToIFrame(postion);
            uiDriver.waitToBeDisplayed(tblSpellSuggestion, waitTime);
            if (tblSpellSuggestion.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING WHETHER SPELL SUGGESTION DISPLAYED OR NOT." + "\n METHOD : isSpellSuggestionDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method Will click on Highlighted Word
     * 
     * @return {@link ExamManagerPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ExamManagerPage clickHighlitedWord() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON HIGHLITED WORD");
            switchToIFrame(postion);
            uiDriver.waitToBeDisplayed(lblHighlitedWord, waitTime);
            lblHighlitedWord.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON HIGHLITED WORD." + "\n METHOD : clickHighlitedWord \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will give the Student Response .
     * 
     * @return {@link String}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getTrueFalseResponse() throws Exception {
        String data = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING RESPONSE OF STUDENT.");
            frameSwitch.switchToFrameContent();
            if (areaTruefalseresponse1.isEnabled()) {
                data = txttruefalseresponse1.getText().trim();
            } else
                if (areaTruefalseresponse2.isEnabled()) {
                    data = txttruefalseresponse2.getText().trim();
                }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING RESPONSE OF STUDENT." + "\n METHOD : getTrueFalseResponse \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }

    /**
     * This Method will get the Response of the SA Question.
     * @author Shishir.Dwivedi
     * @param questionnumber
     * @return String
     * @throws Exception
     */

    public String getResponseOfSA(String questionnumber) throws Exception {
        String data = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING RESPONSE OF SHORT ANSWER QUESTION.");
            frameSwitch.switchToFrameContent();
            txtResponseofSA.replaceValues(questionnumber);
            uiDriver.waitToBeDisplayed(txtResponseofSA, waitTime);
            data = txtResponseofSA.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN  GETTING RESPONSE OF SHORT ANSWER QUESTION." + "\n METHOD : getResponseOfSA \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }
}
