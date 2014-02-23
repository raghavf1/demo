package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditFillTheBlankPage extends BasePageObject {

    /* Elements */
    private UIElement txtGetTextOfResponse = createElement(UIType.Xpath, "//*[@id='RADAnswer{1}']");

    /* Constructor */
    public EditFillTheBlankPage(UIDriver driver) {
        super(driver);
        logInstruction("## EditFillTheBlankPage ##");

    }

    /**
     * Method helps to get Text Of Response 
     * @author Suchi.Singh
     * 
     * @param String
     *            number
     * @return String
     * @throws Exception
     */
    public String getTexOfResponse(String number) throws Exception {
        String TextOfQuestion = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT OF RESPONSE ACCORDING TO THE NUMBER GIVEN.");
            frameSwitch.switchToFrameContent();
            txtGetTextOfResponse.replaceValues(number);
            uiDriver.waitToBeDisplayed(txtGetTextOfResponse, waitTime);
            TextOfQuestion = txtGetTextOfResponse.getAttribute("value");

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING TEXT OF RESPONSE ACCORDING TO THE NUMBER GIVEN." + "\n METHOD : getTexOfResponse \n" + e
                            .getLocalizedMessage());
        }
        return TextOfQuestion;
    }
}
