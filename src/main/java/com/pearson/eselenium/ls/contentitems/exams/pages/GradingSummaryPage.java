package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Grading summary page
 * 
 * @author Usha
 * 
 */
public class GradingSummaryPage extends BasePageObject {

    /* Elements */
    private UIElement lblTitle = createElement(UIType.Css, "div.tablehead");

    /* Constructor */
    public GradingSummaryPage(UIDriver uidriver) {
        super(uidriver);
        logInstruction("LOG INSTRUCTION: ## GradingSummaryPage ##");
    }

    /**
     * @author Usha ,Method helps to get GradingSummary Page title
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        String message = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE OF  GRADINGSUMMARYPAGE . ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblTitle, waitTime);
            message = lblTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE HEADER TITLE OF  GRADINGSUMMARYPAGE ." + "\n METHOD : getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return message;
    }
}
