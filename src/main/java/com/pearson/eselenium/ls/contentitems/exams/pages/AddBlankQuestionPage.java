package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddBlankQuestionPage extends BasePageObject {

    /* Elements */
    private UIElement txtResponse = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/following-sibling::input");
    private UIElement btnAdd = createElement(UIType.Css, "#button3");

    /* Variables */
    String response;
    
    /* Constructor */
    public AddBlankQuestionPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION : ### AddBlankQuestionPage ###");
    }

    /**
     * This method helps to get the response text from the response in blank question type page
     * 
     * @author ashish.juyal
     * @throws Exception
     * @param String
     *             reponseno
     * @return String
     */
    public String getResponse(String reponseno) throws Exception {
        response = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE RESPONSE TEXT");
            frameSwitch.switchToFrameContent();
            txtResponse.replaceValues(reponseno);
            uiDriver.waitToBeDisplayed(txtResponse, waitTime);
            response = txtResponse.getText();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Response'" + "\n METHOD : getResponse \n" + e
                    .getLocalizedMessage());
        }
        return response;
    }

    /**
     * This methods helps to click the add button
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return ExamHomePage
     */
    public ExamHomePage clickAddButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE RESPONSE TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            btnAdd.clickNoWait();
            uiDriver.switchTo().alert().accept();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Add' BUTTON" + "\n METHOD : clickAddButton \n" + e
                            .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }

}
