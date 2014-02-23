package com.pearson.eselenium.ls.contentitems.unit.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ui.Select;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the method for the UnitContentItemsPage
 * 
 * @author ashish.juyal
 */
public class UnitContentItemsPage extends BasePageObject {

    /* UIElements of the UnitContentItemsPage */
    private UIElement btnUnitContent = createElement(UIType.LinkText, "Unit Content Items");
    private UIElement btnAddItem = createElement(UIType.Css, "input[value='Add Items']");
    private UIElement btnToolBox = createElement(UIType.Xpath, "//a[contains(.,'Toolbox')]");
    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement drpRenameItems = createElement(UIType.Css, "#renameItemId");
    private UIElement btnGoClick = createElement(UIType.Css, "input[value='Go']");
    private UIElement txtName = createElement(UIType.ID, "itemTitle");
    private UIElement btnUpdate = createElement(UIType.Xpath, "//input[@value='Update']");
    private UIElement tabToolBox = createElement(UIType.Xpath, "//a[contains(.,'Toolbox')]");
    private UIElement lblRenameItem = createElement(UIType.Xpath, "//div[contains(.,'{1}')]");
    private UIElement lblMessage = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']//table//td[contains(.,'{1}')]");
    private UIElement lblName = createElement(UIType.Xpath, "//input[@id='itemTitle']");
    private UIElement btnUpdateButton = createElement(UIType.Xpath, "//input[@value='Update']");

    private UIElement lblHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement txtPageTitleUnit = createElement(UIType.Css, ".pageTitle");

    /* variables */
    boolean flag = false;
    String strUnitName = null;
    String[] strPart;
    String strValue = null;
    String strText = null;

    /* Constructor */
    public UnitContentItemsPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "UnitContentItemsPage";
        logInstruction("LOG INSTRUCTION: ## UNIT CONTENT ITEMS PAGE ##");
    }

    /**
     * This method clicks the contentButton in UnitContentItemsPage page
     * 
     * @return:UnitContentItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitContentItemsPage clickContentButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CONTENT BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitContent, waitTime);
            btnUnitContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE CONTENT BUTTON" + "\n clickContentButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the AddItemButton
     * 
     * @return:AddItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddItemsPage clickAdditemButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE ADD ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            btnAddItem.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE ADD ITEM BUTTON" + "\n clickAdditemButton \n" + e
                            .getLocalizedMessage());
        }
        return new AddItemsPage(uiDriver);
    }

    /**
     * this method clicks the toolbox button
     * 
     * @return:UnitToolboxPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitToolboxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: THIS METHOD CLICKS THE TOOLBOX BUTTON");
            frameSwitch.switchToFrameContent();
            btnToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE TOOLBOX BUTTON" + "\n clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method check is the Unit name is displayed
     * 
     * @param String
     * @return boolean
     * @author ashish.juyal
     * @throws Exception
     */
    public boolean isUnitContentPageNameDisplayed(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: THIS METHOD CHECK IS THE UNIT NAME IS DISPLAYED");
            frameSwitch.switchToFrameContent();
            strUnitName = txtPageTitle.getText();
            strPart = strUnitName.split(":");
            flag = strPart[1].equalsIgnoreCase(name);
            return flag;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY UNIT CONTENT PAGE" + "\n isUnitContentPageNameDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to select the thread from the dropdown
     * 
     * @param threadName
     * @return UnitContentItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitContentItemsPage selectThreadFromDropDownAndClickGo(String threadName)
            throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: SELECT THREAD FROM DROPDOWN");
            uiDriver.waitToBeDisplayed(drpRenameItems, waitTime);
            Select dropList = new Select(drpRenameItems);
            dropList.selectByVisibleText(threadName);
            btnGoClick.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE TOOLBOX BUTTON" + "\n selectThreadFromDropDownAndClickGo \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method checks whether the name is in the text
     * 
     * @author ashish.juyal
     * @param threadName
     * @return boolean
     * @throws Exception
     */
    public boolean verifyNameFields(String threadName) throws Exception {
        flag = false;
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: VERIFY NAME TEXT");
            strValue = txtName.getAttribute("value");
            flag = strValue.equalsIgnoreCase(threadName);
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY NAME FIELD TEXT" + "\n verifyNameFields \n" + e
                    .getLocalizedMessage());
        }

        return flag;

    }

    /**
     * this method enters text into the name field
     * 
     * @param threadName
     * @return UnitContentItemsPage
     * @throws Exception
     * @author ashish.juyal
     */
    public UnitContentItemsPage enterNewThreadName(String threadName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTER THE NAME IN NAME FIELD");
            frameSwitch.switchToFrameContent();
            /* modified from send Keys to clearAndSendKeys as its trying to update with old name */
            txtName.clearAndSendKeys(threadName);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT" + "\n enterNewThreadName \n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method to click on update button
     * 
     * @author Praveen.Maled
     * @return UnitContentItemsPage
     * @throws Exception
     */
    public UnitContentItemsPage clickOnUpdate() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE NAME IN NAME FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUpdate, waitTime);
            btnUpdate.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT" + "\n clickOnUpdate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method will select tool box tab
     * 
     * @author Praveen.Maled
     * @return UnitToolboxPage
     * @throws Exception
     */
    public UnitToolboxPage selectToolBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE NAME IN NAME FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(tabToolBox, waitTime);
            tabToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT" + "\n selectToolBox \n" + e
                    .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This methods helps to check whether the rename items heading is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @param String
     * @throws Exception
     */

    public boolean isRenameItemHeaderDisplayed(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THE RENAME ITEM HEADER");
            frameSwitch.switchToFrameContent();
            lblRenameItem.replaceValues(name);
            uiDriver.waitToBeDisplayed(lblRenameItem, waitTime);
            strText = lblRenameItem.getText();
            if (strText.equalsIgnoreCase(name)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE RENAME TITLE HEADER" + "\n isRenameItemheaderDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to click the go button
     * 
     * @author ashish.juyal
     * @return UnitContentItemsPage
     * @throws Exception
     */

    public UnitContentItemsPage clickGoButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE GO BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnGoClick, waitTime);
            btnGoClick.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE GO BUTTON" + "\n clickGoButton \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to get the message which is at the bottom of the rename item dropdown list
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */
    public String getMessage() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblMessage, waitTime);
            strText = lblMessage.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE MESSAGE" + "\n getMessage \n" + e
                    .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This method helps to enter the name
     * 
     * @author ashish.juyal
     * @return UnitContentItemsPage
     * @throws Exception
     */

    public UnitContentItemsPage enterName(String Name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING NAME IN THE NAME FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblName, waitTime);
            lblName.sendKeys(Name);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE NAME" + "\n enterName \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on the update button
     * 
     * @author ashish.juyal
     * @return UnitContentItemsPage
     * @throws Exception
     */

    public UnitContentItemsPage clickUpdateButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE UPDATE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUpdateButton, waitTime);
            btnUpdateButton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE UPDATE BUTTON" + "\n clickUpdateButton \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select the thread from the drop down
     * 
     * @author Praveen
     * @param String
     * @return UnitContentItemsPage
     * @throws Exception
     */
    public UnitContentItemsPage selectThreadFromDropDown(String threadName) throws Exception {
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: SELECT THREAD FROM DROPDOWN");
            uiDriver.waitToBeDisplayed(drpRenameItems, waitTime);
            Select dropList = new Select(drpRenameItems);
            dropList.selectByVisibleText(threadName);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE TOOLBOX BUTTON" + "\n selectThreadFromDropDown \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to get the text from the name field
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */

    public String getNameValue() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE NAME FIELD VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblName, waitTime);
            strValue = lblName.getAttribute("value");

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE VALUE" + "\n getNameValue \n" + e
                    .getLocalizedMessage());
        }
        return strValue;
    }

    /**
     * Method helps to select the thread from the dropdown
     * 
     * @author Chaitali.Barhate
     * @param threadName
     * @return boolean
     * @throws Exception
     */
    public boolean isItemPresentInRenameDropDown(String threadName) throws Exception {
        flag = false;
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CHECKING FOR ITEM IN DROPDOWN");
            uiDriver.waitToBeDisplayed(drpRenameItems, waitTime);
            Select dropList = new Select(drpRenameItems);
            for (int i = 0; i < dropList.getOptions().size(); i++) {
                if (dropList.getOptions().get(i).getText().equals(threadName)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE TOOLBOX BUTTON" + "\n isItemPresentInRenameDropDown \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods Helps to Determine Header title is Present
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return boolean
     * @throws Exception
     */

    public boolean isHeaderTitlePresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING HEADER TITLE");
            frameSwitch.switchToFrameContent();

            if (lblHeaderTitle.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("HEADER TITLE NOT FOUND" + "\n isHeaderTitlePresent \n" + e
                    .getLocalizedMessage());
        }

        return flag;

    }

    /**
     * This method helps to get the page title of the page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     * @throws Exception
     */
    public String getPageTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtPageTitleUnit, waitTime);
            strValue = txtPageTitleUnit.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strValue;
    }

    /**
     * service method to rename a item in a unit.
     * 
     * @author Vivek.Singh
     * @param String
     * @param String
     * @return UnitContentItemsPage
     * @throws Exception
     * **/
    public UnitContentItemsPage renameItem(String currrentItemName, String newItemName)
            throws Exception {
        logInstruction("LOG INSTRUCTION: 'Renaming' A CONTENT ITEM.");
        try {
            if (StringUtils.isNotBlank(currrentItemName)) {
                logInstruction("LOG INSTRUCTION: SELECTING 'Dropdown' OF ITEM TO BE SELECTED.");
                frameSwitch.switchToFrameContent();
                uiDriver.waitToBeDisplayed(drpRenameItems, waitTime);
                Select dropList = new Select(drpRenameItems);
                dropList.selectByVisibleText(currrentItemName);

                logInstruction("LOG INSTRUCTION: CLICKING 'Go' BUTTON.");
                uiDriver.waitToBeDisplayed(btnGoClick, waitTime);
                btnGoClick.clickNoWait();

                logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'Textbox'.");
                uiDriver.waitToBeDisplayed(txtName, waitTime);
                txtName.clearAndSendKeys(newItemName);

                logInstruction("LOG INSTRUCTION: CLICKING 'Update' BUTTON.");
                uiDriver.waitToBeDisplayed(btnUpdate, waitTime);
                btnUpdate.clickAndWait(waitTime);
                return this;
            } else
                throw new Exception("'Current Item Name' IS BLANK. \nMETHOD: renameItem\n");
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'rename' ITEM. \nMETHOD: renameItem\n" + e
                    .getLocalizedMessage());
        }
    }

}
