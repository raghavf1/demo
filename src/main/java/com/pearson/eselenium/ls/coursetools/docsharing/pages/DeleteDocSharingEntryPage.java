package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DeleteDocSharingEntry page Follow the below
 * steps to navigate the page: Login as prof Click on the Course Select DocSharing on toolbar Click
 * on delete icon
 * 
 * @author Chaitali
 */
public class DeleteDocSharingEntryPage extends BasePageObject {

    /**
     * @author Chaitali
     * @param uiDriver
     */

    /* UI Elements */
    private UIElement btnDelete = createElement(UIType.Css, "input[value='Delete']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement txtdelete = createElement(UIType.Xpath, "//td[@valign='top']");
    
  /* Variables*/
    
    private boolean flag = false;
    private String strTitle = null;
    
    /* Constructor */
    public DeleteDocSharingEntryPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Delete DocSharingEntry Page ##");
    }

    /**
     * Method helps to click delete button
     * 
     * @author Chaitali
     * @return DocumentSharingHomePage
     * @throws Exception
     */
    public DocSharingPage clickDeleteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' BUTTON" + "\nMETHOD:clickDeleteButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * Method helps to click cancel button
     * 
     * @author Chaitali
     * @return DocumentSharingHomePage
     * @throws Exception
     */
    public DeleteDocSharingEntryPage clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'cancel' BUTTON" + "\n METHOD:clickCancelButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods Helps To verify Whether Delete Button Is Present
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isDeleteButtonPresent() throws Exception {

        
        try {

            logInstruction("LOG INSTRUCTION : VERIFIYING DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            if (btnDelete.isDisplayedAfterWaiting(waitTime));
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'delete' BUTTON" + "\n METHOD:isDeleteButtonPresent\n" + e
                            .getLocalizedMessage());
        }

        return flag;

    }

    /**
     * Methods helps to verify Whether Cancel Button is Present
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isCancelButtonPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : VERIFYING CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            if (btnCancel.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'cancel' BUTTON" + "\n isCancelButtonPresent\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods helps to get Delete Instructional Text
     * 
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPermanentDeleteInstructionalText() {

        
        try {
            logInstruction("LOG INSTRUCTION : GETTING THE DELETE INSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtdelete, waitTime);
            strTitle = txtdelete.getText().trim();
        } catch (Exception e) {
            logInstruction("ISSUE IN GETTING 'delete' INSTRUCTIONAL TEXT" + "\nMETHOD:getPermanentDeleteInstructionalText\n" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

}
