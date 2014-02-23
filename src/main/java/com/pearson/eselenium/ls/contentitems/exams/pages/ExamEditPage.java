package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * Class contains methods related to ExamEditPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class ExamEditPage extends BasePageObject {

    /* Constructor */
    public ExamEditPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("### ExamEditPage ###");
    }

    /* Elements */
    private UIElement txtTitle;
    private UIElement btnSaveChanges;
   
    /**
     * @category Milestone 2
     * @author Pratush.Manglik Method is used to enter text in title field
     * @param title
     * @return ExamEditPage
     * @throws Exception
     */
    public ExamEditPage setTitle(String title) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTER TEXT IN TITLE FIELDS");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            txtTitle.sendKeys(title);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT IN TITLE FIELD" + "\n METHOD : setTitle \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @category Milestone 2
     * Method is used to Click on save changes
     * @author Pratush.Manglik
     * @return ExamHomePage
     * @throws Exception
     */
    public ExamHomePage clickSaveChanges() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ON SAVE CHANGES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.click();
            uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON SAVE CHANGES" + "\n METHOD : clickSaveChanges \n" + e
                    .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }
}
