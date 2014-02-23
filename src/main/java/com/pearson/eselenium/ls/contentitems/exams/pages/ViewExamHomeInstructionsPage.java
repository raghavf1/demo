package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewExamHomeInstructionsPage extends BasePageObject {

    /* Elements */
    private UIElement btnBeginNow = createElement(UIType.Css, ".buttontd");

    /* Constructor */
    public ViewExamHomeInstructionsPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## ViewExamHomeInstructionsPage ##");
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
            logInstruction("Clicked Begin Now button.");
            return new ViewExamPage(uiDriver);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Begin Now' BUTTON" + "\n METHOD : clickBeginNowButton \n" + e
                            .getLocalizedMessage());
        }
    }

}
