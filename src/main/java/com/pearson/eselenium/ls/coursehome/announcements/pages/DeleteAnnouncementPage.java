package com.pearson.eselenium.ls.coursehome.announcements.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DeleteAnnouncement
 * 
 * @author Hemant.Kumar
 */
public class DeleteAnnouncementPage extends BasePageObject {

    private UIElement btnDelete = createElement(UIType.Xpath, "//input[@value='Delete']");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[@value='Cancel']");
    private UIElement lblHeaderTitle = createElement(
            UIType.Xpath,
            "//h2[@class='headertitle']//div[contains(.,'Announcement')]");
    private UIElement lblWarningMsg = createElement(
            UIType.Xpath,
            "//td[contains(.,'To permanently delete this announcement')]");
    private UIElement lblAnnouncementTitle = createElement(
            UIType.Xpath,
            "//h1[contains(.,'Announcements')]");
    private boolean flag = false;
    String strTableHeader = null;
    String strWarningMessage = null;
    String strAnnouncementTitle = null;

    /**
     * Constructor
     * 
     * @param driver
     */
    public DeleteAnnouncementPage(UIDriver driver) {
        super(driver);
        pageTitle = "Delete Announcement Page";
        logInstruction("LOG INSTRUCTION: ## DeleteAnnouncementPage ##");
    }

    /**
     * this method helps to click the delete button
     * 
     * @author ashish.juyal
     * @return NextAuthorHomePage
     * @throws Exception
     */
    public NextAuthorHomePage clickDeleteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE TO '  Delete Button'" + "\n METHOD:clickDeleteButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * this method helps to click the cancel button
     * 
     * @author ashish.juyal
     * @return NextAuthorHomePage
     * @throws Exception
     */
    public NextAuthorHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE TO 'Click The Cancel Button'" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /***
     * This methods helps to find whether the page is DeleteAnnouncementPage or not
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */
    public String getDeleteAnouncementPageHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING DELETE ANOUNCEMENT PAGE HEADER TITLE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strTableHeader = lblHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: Unable To 'Get Delete Anouncement Page Header Title' " + "\n METHOD:getDeleteAnouncementPageHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strTableHeader;
    }

    /**
     * This method is for getting warning message on delete page.
     * 
     * @return String - warningMessage
     * @throws Exception
     * @author saurabh.jain1
     */
    public String getDeleteAnouncementWarningMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING WARNING MESSAGE ON DELETE PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblWarningMsg, waitTime);
            strWarningMessage = lblWarningMsg.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: Unable To 'Get Warning Message On Delete Page' " + "\n METHOD:getDeleteAnouncementWarningMessage \n" + e
                            .getLocalizedMessage());
        }
        return strWarningMessage;
    }

    /**
     * Method is for verifying cancel button.
     * 
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE CANCEL BUTTON");
            frameSwitch.switchToFrameContent();

            if (btnCancel.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: Unable  To 'Check If Cancel Button Is Displayed'" + "\n METHOD:isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is for verifying delete button.
     * 
     * @return boolean
     * @throws Exception
     * @author saurabh.jain1
     */
    public boolean isDeleteButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();

            if (btnDelete.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: Unable  To Check 'If Delete Button Is Displayed '" + "\n METHOD:isDeleteButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get the Announcements Title
     * 
     * @author ganapati.bhat
     * @return String - announcementTitle
     * @throws Exception
     */
    public String getAnnouncementsTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: VERIFY ANNOUNCEMENT TITLE");
            frameSwitch.switchToFrameContent();
            if (lblAnnouncementTitle.isDisplayedAfterWaiting(waitTime)) {
                strAnnouncementTitle = lblAnnouncementTitle.getText();
            }
        } catch (Exception e) {

            throw new Exception(
                    "LOG INSTRUCTION: Unable  To 'Get Announcements Title'" + "\n METHOD:getAnnouncementsTitle \n" + e
                            .getLocalizedMessage());
        }
        return strAnnouncementTitle;
    }

}
