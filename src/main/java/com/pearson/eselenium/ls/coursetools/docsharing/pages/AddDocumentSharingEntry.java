package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddDocumentSharingEntry extends BasePageObject {

    /* UI Elements */
    private UIElement txtdescription = createElement(UIType.Css, "#fileDescriptions[0]");
    private UIElement btnaddEntry = createElement(UIType.Css, "#AddEntry");
    private UIElement txtOwner = createElement(UIType.ID, "SubmitterDisplayName");
    
    /*variables*/
    private boolean flag = false;
    
    /* Constructor */
    public AddDocumentSharingEntry(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## AddDocumentSharingEntry ##");

    }

    /**
     * @author Raghavendra
     * @return
     * @throws Exception
     *             This method is for clicking Cancel button
     */

    public AddDocumentSharingEntry enterDescription(String descriptionValue) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:ENTERING THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtdescription, waitTime);
            txtdescription.clearAndSendKeys(descriptionValue);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'entering' THE DESCRIPTION" + "\n METHOD:enterDescription\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author Raghavendra
     * @return
     * @throws Exception
     *             This method is for clicking clickAddEntryButton
     */
    public DocSharingPage clickAddEntryButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnaddEntry, waitTime);
            btnaddEntry.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'addentry' BUTTON" + "\n METHOD:clickAddEntryButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * Methods helps to Verify Whether Add Entry is Present
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isAddEntryPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : VERFIYING ADD ENRTY BUTTON");
            frameSwitch.switchToFrameContent();
            if (btnaddEntry.isDisplayedAfterWaiting(waitTime))
            	flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFIYING 'addentry' BUTTON" + "\n METHOD:isAddEntryPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Methods Helps to Enter the Owner Name
     * 
     * @author Raghav
     * @return
     * @throws Exception
     */
    public AddDocumentSharingEntry enterOwnerName(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTERING THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            txtOwner.clearAndSendKeys(name);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'owner' NAME" + "\nMETHOD:enterOwnerName\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
    
    
    /** This method is helps to enter description and Click on Add Entry Button
     * @ServicelevelMethods
	*	@author Raghav 
     * @return
     * @throws Exception
     *             
     */
    public DocSharingPage enterDescriptionandClickAddEntry(String descriptionValue) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTERING DESC AND CLICK ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtdescription, waitTime);
            txtdescription.clearAndSendKeys(descriptionValue);
            uiDriver.waitToBeDisplayed(btnaddEntry, waitTime);
            btnaddEntry.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING AND CLICKING ON 'addentry' BUTTON" + "\n METHOD:clickAddEntryButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

}
