package com.pearson.eselenium.ls.contentitems.webcontent.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the WebContentToolbox Page
 * 
 * @author Chaitali
 * @Team Beta
 * @Navigation From click on web content item on navigation tree then on ToolBox button
 * 
 */

public class WebContentToolboxPage extends BasePageObject {

    /* UIElements of the page */
    private UIElement btnDelete = createElement(UIType.Xpath, "//a[contains(.,'Delete')]");
    private UIElement lnkEditSchedule = createElement(
            UIType.Xpath,
            "//a[contains(.,'Edit Schedule')]");
    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//td[@width='35%']/following-sibling::td");
    private UIElement lnkdelete = createElement(UIType.Css, "a[title*='Delete']");

    private UIElement txttitle = createElement(UIType.Css, ".pageTitle");

    private boolean flag = false;
    private UIElement btnMove = createElement(UIType.Css, ".toolboxitem>a>img[src*='move']");
    private UIElement btnToolBox = createElement(
            UIType.Xpath,
            "//div[@id='contentMenu']//a[contains(.,'Toolbox')]");

    private UIElement btnSaveChanges = createElement(UIType.ID, "btnname");
    private UIElement chkHideItem = createElement(UIType.ID, "isHidden");
    private UIElement scltAsssignto = createElement(UIType.ID, "newGroupId");

    String strErrorMessage = null;
    String strPageTitle = null;

    /* Constructor */
    public WebContentToolboxPage(UIDriver driver) {
        super(driver);
        pageTitle = "WebContentToolboxPage";
        logInstruction("LOG INSTRUCTION: ## WebcontentToolbox Page ##");
    }

    /**
     * method helps to click on delete
     * 
     * @author Chaitali
     * @throws Exception
     * @returns DeleteWebContentItemPage
     */
    public DeleteWebContentItemPage clickOnDelete() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(" UNABLE TO 'Click On Delete'" + "\n METHOD:clickOnDelete \n" +

            e.getLocalizedMessage());
        }
        return new DeleteWebContentItemPage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to click on Edit Schedule link
     * @author Pratush.Manglik
     * @return EditSchedulePage
     * @throws Exception
     */
    public WebContentEditSchedulePage clickEditScheduleLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule, waitTime);
            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click On Edit Schedule Link' " + "\n METHOD:clickEditScheduleLink \n" + e
                            .getLocalizedMessage());
        }
        return new WebContentEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to get message adjacent to Edit Schedule Link
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getMessageDisplayedNextToEditSchedule() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            strErrorMessage = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Get  Message Adjacent Displayed Next To Edit Schedule '" + "\n METHOD:getMessageDisplayedNextToEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * This methods click the delete link
     * 
     * @category Milestone2
     * @return:WebContentToolboxPage
     * @author amit.deshmukh
     * @throws Exception
     */
    public DeleteWebContentItemPage clickDeleteLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE DELETE LINK");
            frameSwitch.switchToFrameContent();
            lnkdelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Click Delete Link'" + "\n METHOD:clickDeleteLink \n" + e
                            .getLocalizedMessage());
        }
        return new DeleteWebContentItemPage(uiDriver);
    }

    /**
     * Methods helps to get page title
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txttitle, waitTime);
            strPageTitle = txttitle.getText().trim();
            return strPageTitle;
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Get Page Title'" + "\n METHOD:getPageTitle \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * method helps to click on move
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @throws Exception
     * @returns Object
     */

    public MoveWebContentPage clickOnMove() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK ON MOVE LINK");
            frameSwitch.switchToFrameContent();
            btnMove.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Click On Move '" + "\n METHOD:clickOnMove \n" + e
                    .getLocalizedMessage());
        }
        return new MoveWebContentPage(uiDriver);
    }

    /**
     * @author Method helps to determine whether ToolBox tab is present
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isToolBoxPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE TOOLBOX");
            frameSwitch.switchToFrameContent();

            if (btnToolBox.isDisplayedAfterWaiting(waitTime))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY IF 'Toolbox  Is Present '" + "\n METHOD:isToolBoxPresent \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * @category milestone 2
     * method helps to perform hide item and update save changes
     * @author Manjunath.Reddy
     * @param String
     * @param boolean
     * @return WebContentToolboxPage
     * @throws Exception
     */

    public WebContentToolboxPage selectAssignmentTo(String strValue, boolean isHideFromStudent)
            throws Exception {

        try {

            logInstruction("LOG INSTRUCTION:SELECT ASSAIGNMENT ITEMS");
            frameSwitch.switchToFrameContent();

            if (StringUtils.isNotBlank(strValue)) {

                scltAsssignto.selectByVisibleText(strValue);
                logInstruction("LOG INSTRUCTION:SELECTED ASSIGNEE ITEM");

            }

            if (isHideFromStudent == true) {

                uiDriver.waitToBeDisplayed(chkHideItem, waitTime);
                chkHideItem.clickNoWait();
                logInstruction("LOG INSTRUCTION:CLICKED ON THE HIDE CHECKBOX");
            }

            logInstruction("LOG INSTRUCTION:CLICK ON THE SAVE CHANGES BUTTON");
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);

        } catch (Exception e) {

            throw new Exception(

                    "UNABLE TO SELECT  ASSIGNEE ITEMS 'Items are not present '" + "\n METHOD:selectAssignmentTo \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

}
