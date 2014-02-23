package com.pearson.eselenium.ls.coursetools.journal.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class JournalStudentPage extends BasePageObject {

    /* UI Elements */
    private UIElement btnediticon = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnaddentry = createElement(UIType.Css, "input[value='Add Entry']");
    private UIElement lblheaderjournal = createElement(UIType.Xpath, "//div[@class='tablehead']");
    private UIElement lbljournaltitle = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement lblusername = createElement(
            UIType.Xpath,
            "//*[@id='journal0_collapsed']/th/a");
    private UIElement btndelete = createElement(UIType.Css, "input[value='Delete']");
    private UIElement btndeletebutton = createElement(
            UIType.Xpath,
            "//tr[th[a[contains(text(),'{1}')]]]/td[4]/a/img");
    
    /* Variables */
    String strHeaderName = null;
    String strTitleName = null;
    String strUserName = null;
    /* Constructor */
    public JournalStudentPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("## Journal Student Page ##");
    }

    /**
     * Method helps to click add entry.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public AddJournalEntryPage clickAddEntry() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnaddentry, waitTime);
            btnaddentry.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'add' ENTRY BUTTON" + "\nMETHOD:clickAddEntry\n" + e
                            .getLocalizedMessage());
        }
        return new AddJournalEntryPage(uiDriver);
    }

    /**
     * Method helps to click edit icon.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public JournalStudentPage clickEditIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON EDIT ICON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnediticon, waitTime);
            btnediticon.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'edit' ICON BUTTON" + "\nMETHOD:clickEditIcon\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to get header title.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getHeaderTitle() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblheaderjournal, waitTime);
            strHeaderName = lblheaderjournal.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'header' TITLE" + "\nMETHOD:getHeaderTitle\n" + e
                    .getLocalizedMessage());
        }

        return strHeaderName;
    }

    /**
     * Method helps get title.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getTitle() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE JOURNAL TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbljournaltitle, waitTime);
            strTitleName = lbljournaltitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'journal' TITLE" + "\nMETHOD:getTitle\n" + e
                    .getLocalizedMessage());
        }

        return strTitleName;
    }

    /**
     * Method helps to get user name.
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getUsername() throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE USER NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblusername, waitTime);
            strUserName = lblusername.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'user' NAME" + "\nMETHOD:getUsername\n" + e
                    .getLocalizedMessage());
        }

        return strUserName;
    }

    /**
     * Method helps to click on delete button.
     * 
     * @return
     * @author saurabh.jain1
     * @throws Exception
     */
    public JournalStudentPage clickonDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK ON DELETE BUTTON");
            uiDriver.waitToBeDisplayed(btndeletebutton, waitTime);
            btndeletebutton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING  'delete' BUTTON" + "\nMETHOD:clickonDeleteButton\n" + e
                            .getLocalizedMessage());

        }

        return this;

    }

    /**
     * Method helps to click on delete icon
     * 
     * @param FileName
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */

    public JournalStudentPage clickOnDelete(String FileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICK ON  " + FileName + "DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btndelete.replaceValues(FileName.trim());
            uiDriver.waitToBeDisplayed(btndelete, waitTime);
            btndelete.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN DELETING THE 'file'" + "\nMETHOD:clickOnDelete\n" + e
                    .getLocalizedMessage());
        }
        return this;

    }
}
