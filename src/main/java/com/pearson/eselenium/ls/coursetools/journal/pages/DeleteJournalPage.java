package com.pearson.eselenium.ls.coursetools.journal.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class DeleteJournalPage extends BasePageObject {

    /* UIElements */
    private UIElement txtDeletePageHeradder = createElement(UIType.Css, ".tablehead");
    private UIElement btnDelete = createElement(UIType.Css, ".buttontd");

    /* Variables */
    String strHeader = null;
    
    /* Constructor */
    public DeleteJournalPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## Setup Delete Journal Page ##");
    }

    /**
     * method to click on Delete button
     * 
     * @author Soundarya
     * @return JournalHomePage
     * @throws Exception
     */
    public JournalHomePage clickDeleteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' BUTTON" + "\nMETHOD:clickDeleteButton\n" + e
                            .getLocalizedMessage());
        }
        return new JournalHomePage(uiDriver);
    }

    /**
     * method to get Delete Page Header Title
     * 
     * @author Soundarya
     * @return String -headder
     * @throws Exception
     */
    public String getDeletePageHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDeletePageHeradder, waitTime);
            strHeader = txtDeletePageHeradder.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header' TITLE" + "\nMETHOD:clickDeleteButton\n");
        }
        return strHeader;
    }
}