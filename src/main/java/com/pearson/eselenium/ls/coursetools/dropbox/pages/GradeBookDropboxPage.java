package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class GradeBookDropboxPage extends BasePageObject {

    /* UIElement declarations for the GradeBookDropbox Page */

    private UIElement lnkRespondOrSubmit = createElement(
            UIType.Xpath,
            "//form[@id='DetailView']//td[@id='respondControl']//a[contains(text(),'Respond')]");
    private UIElement radEditor = createElement(UIType.ID, "RadeEntryText_contentIframe");
    private UIElement btnSubmitAssignment = createElement(
            UIType.Xpath,
            "//input[@value='Submit Assignment']");

    private boolean flag = false;
    /* Constructor */
    public GradeBookDropboxPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## GradeBookDropbox Page ##");
    }

    /**
     * This method helps to click on ResponsdOnsubmit Link
     * 
     * @author Usha
     * @throws Exception
     */
    public SubmissionPage clickResponsdOnsubmitLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON RESPONSDONSUBMIT LINK");
            frameSwitch.switchToFrameContent();
            if (lnkRespondOrSubmit.isDisplayedAfterWaiting(waitTime))
                lnkRespondOrSubmit.clickAndWait(waitTime);
            else
                logInstruction("LOG INSTRUCTION: UNABLE TO CLICK ON RESPONSDONSUBMIT LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON RESPONSDONSUBMIT LINK \n METHOD : clickResponsdOnsubmitLink" + e
                            .getLocalizedMessage());
        }
        return new SubmissionPage(uiDriver);
    }

    /**
     * This method helps to click on SubmitAssignment button
     * 
     * @author Usha
     * @throws Exception
     */
    public StudentPage clickSubmitAssignmentButton() throws Exception {
        try {
            logInstruction("CLICKING ON SUBMITASSIGNMENT BUTTON");
            frameSwitch.switchToFrameContent();
            if (btnSubmitAssignment.isDisplayedAfterWaiting(waitTime))
                btnSubmitAssignment.clickAndWait(waitTime);
            else
                logInstruction("LOG INSTRUCTION: UNABLE TO CLICK ON SUBMIT ASSIGNMENT BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SUBMITASSIGNMENT BUTTON \n METHOD : clickSubmitAssignmentButton" + e
                            .getLocalizedMessage());
        }
        return new StudentPage(uiDriver);
    }

    /**
     * Method helps to check RadEditorDisplayed For GradeBookDropbox Page
     * 
     * @return
     * @author usha.reddy
     * @throws Exception
     */

    public boolean isRadEditorDisplayedForGradeBookDropboxPage() throws Exception {
        flag = false;
        try {
            logInstruction("CHECK IF THE RAD EDITOR IS DISPLAYED FOR GRADEBOOKDROPBOX PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radEditor, waitTime);
            flag = radEditor.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "RAD EDITOR IS NOT DISPLAYED FOR GRADEBOOKDROPBOX PAGE \n METHOD : isRadEditorDisplayedForGradeBookDropboxPage" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

}
