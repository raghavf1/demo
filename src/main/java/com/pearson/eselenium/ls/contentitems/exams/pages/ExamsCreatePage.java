package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Exam Create page
 * 
 * @author monica.anand
 * 
 */

public class ExamsCreatePage extends BasePageObject {

    /* Elements */
    private UIElement btnAdd = createElement(UIType.Name, "addquestion");
    private UIElement clickToolbox = createElement(UIType.LinkText, "Toolbox");

    /* Constructor */
    public ExamsCreatePage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## ExamsCreatePage ##");

    }

    /**
     * This method is used to click the add button on ExamsCreatePage
     * 
     * @author monica.anand
     * @return AddTrueFalseQuestionPage
     * @throws Exception
     */

    public AddTrueFalseQuestionPage clickAddButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON ADD BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            btnAdd.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Add' BUTTON" + "\n METHOD : clickAddButton \n" + e
                            .getLocalizedMessage());
        }
        return new AddTrueFalseQuestionPage(uiDriver);
    }

    /**
     * This method is click on tool box
     * 
     * @author kiran kumar
     * @return ExamToolboxPage
     * @throws Exception
     */

    public ExamToolboxPage clicktoolbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON TOOLBOX BUTTON");
            frameSwitch.switchToFrameContent();
            clickToolbox.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'ToolBox' BUTTON" + "\n METHOD : clicktoolbox \n" + e
                            .getLocalizedMessage());
        }
        return new ExamToolboxPage(uiDriver);
    }
}
