package com.pearson.eselenium.ls.contentitems.unit.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the method for the CourseItemPage
 * 
 * @author ashish.juyal
 */

public class CourseItemsPage extends BasePageObject {

    /* UIElements of the CourseItemPage */
    private UIElement btnUnit = createElement(UIType.Css, "input[value='Add Unit']");
    private UIElement btnItem = createElement(UIType.Xpath, "//input[@value='Add Items']");
    private UIElement drpRenameItem = createElement(UIType.Css, "#courseItemCategoryIdForRename");
    private UIElement lblPageHeader = createElement(UIType.Css, ".tablehead");
    private UIElement btnClickGo = createElement(UIType.Css, "input[value='Go']");
    private UIElement txtEnterRenameValue = createElement(UIType.Css, "#itemTitle");
    private UIElement btnClickUpdate = createElement(UIType.Css, "input[value='Update']");
    String strValue = null;
    boolean flag = false;

    /* Constructor */
    public CourseItemsPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "CourseItemsPage";
        logInstruction("LOG INSTRUCTION: ## COURSE ITEMS PAGE ##");
    }

    /**
     * This method clicks the AddUnitButton in CourseItemPage
     * 
     * @return:AddUnitPage
     * @throws Exception
     * @author ashish.juyal
     */
    public AddUnitPage clickAddUnitButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE ADDUNITBUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnit, waitTime);

            btnUnit.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE ADDUNITBUTTON" + "\n METHOD:clickAddUnitButton \n" + e
                            .getLocalizedMessage());
        }

        return new AddUnitPage(uiDriver);
    }

    /**
     * This method click the AddItemButton
     * 
     * @return:AddItemPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddItemsPage clickAddItemButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK THE ADD ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnItem, waitTime);
            btnItem.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE ADDITEMBUTTON" + "\n METHOD:clickAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return new AddItemsPage(uiDriver);
    }

    /**
     * @author krishna.kulkarni Method helps to select Item to rename
     * @return CourseItemsPage
     * @param String
     * @throws Exception
     */
    public CourseItemsPage selectToRenameItemInDropDown(String itemName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECT TO RENAME ITEM");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpRenameItem, waitTime);
            Select dropList = new Select(drpRenameItem);
            List<WebElement> optionsList = dropList.getOptions();
            if (optionsList.size() > 0) {
                for (int i = 0; i < optionsList.size(); i++) {
                    if (optionsList.get(i).getText().equalsIgnoreCase(itemName)) {
                        dropList.selectByVisibleText(itemName);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT ON THE RENAME ITEM" + "\n METHOD:selectToRenameItemInDropDown \n" + e
                            .getLocalizedMessage());
        }
        return new CourseItemsPage(uiDriver);
    }

    /**
     * @author krishna.kulkarni Method helps to verify deleted item exist in drop down list
     * @return boolean true=delete item exist, false= delete item not exist
     * @param String
     */
    public boolean isDeletedItemNameExistInRenameCourseItem(String itemName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY DELETED ITEM IN RENAME ITEM DROPDOWN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpRenameItem, waitTime);
            Select dropList = new Select(drpRenameItem);
            List<WebElement> optionsList = dropList.getOptions();
            if (optionsList.size() > 0) {
                for (int i = 0; i < optionsList.size(); i++) {
                    if (optionsList.get(i).getText().equalsIgnoreCase(itemName)) {
                        dropList.selectByVisibleText(itemName);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT TO RENAME ITEM" + "\n METHOD:isDeletedItemNameExistInRenameCourseItem \n" + e
                            .getLocalizedMessage());
        }
        return false;
    }

    /**
     * this method verify the courseItemspage
     * 
     * @author ashish.juyal
     * @return boolean
     * @param String
     * @throws Exception
     */

    public boolean verifyCourseItemsPage(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE COURSEITEMSPAGE");
            frameSwitch.switchToFrameContent();
            strValue = lblPageHeader.getText();
            if (strValue.equalsIgnoreCase(name)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE COURSEITEMSPAGE" + "\n METHOD:verifyCourseItemsPage \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will click On Go Button
     * 
     * @return CourseItemsPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public CourseItemsPage clickGoButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON GO BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickGo, waitTime);
            btnClickGo.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE GO BUTTON" + "\n METHOD:clickGoBtn \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will Enter the rename value in the txt box
     * 
     * @param name
     *            New name of the Item
     * @return CourseItemsPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public CourseItemsPage enterValueToRename(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEnterRenameValue, waitTime);
            txtEnterRenameValue.clearAndSendKeys(name);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE ELEMENT" + "\n METHOD:enterValueToRename \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click on the update button
     * 
     * @return CourseItemsPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public CourseItemsPage clickUpdateButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON UPDATE BTN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickUpdate, waitTime);
            btnClickUpdate.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(" UNABLE TO GET THE UPDATE BTN" + "\n METHOD:clickUpdateBtn \n" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to rename an existing item
     * 
     * @param strExistingItemName
     * @param strNewName
     * @return CourseItemsPage
     * @throws Exception
     * 
     * @author sumanth.sv
     */
    public CourseItemsPage renameItem(String strExistingItemName, String strNewName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT EXISTING ITEM NAME FROM DROPDOWN");
            if (!drpRenameItem.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception(
                        "'Existing Item Names Dropbox' DOES NOT EXISTS \n METHOD: renameItem");
            }
            drpRenameItem.selectByVisibleText(strExistingItemName);

            logInstruction("LOG INSTRUCTION: CLICK GO BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnClickGo.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Go Button' DOES NOT EXISTS \n METHOD: renameItem");
            }
            btnClickGo.clickAndWait(waitTime);

            logInstruction("LOG INSTRUCTION: ENTER NEW NAME");
            if (!txtEnterRenameValue.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Name Textbox' DOES NOT EXISTS \n METHOD: renameItem");
            }
            txtEnterRenameValue.clearAndSendKeys(strNewName);

            logInstruction("LOG INSTRUCTION: CLICK UPDATE BUTTON");
            if (!btnClickUpdate.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Update Button' DOES NOT EXISTS \n METHOD: renameItem");
            }
            btnClickUpdate.clickAndWait(waitTime);
            return new CourseItemsPage(uiDriver);

        } catch (Exception e) {
            throw new Exception("UNABLE TO RENAME ITEM" + "\n METHOD: renameItem \n" + e
                    .getLocalizedMessage());
        }

    }
}
