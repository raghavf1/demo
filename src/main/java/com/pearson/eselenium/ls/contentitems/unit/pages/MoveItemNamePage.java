package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This Class contains all methods related to the move item page
 * 
 * @author kiran.kumar
 * @param uiDriver
 */
public class MoveItemNamePage extends BasePageObject {

    private UIElement drpSelectMoveTo = createElement(UIType.ID, "moveToUnitSubId");
    private UIElement btnMoveOrderBox = createElement(
            UIType.Xpath,
            "//td[label[contains(text(),'{1}')]]/following-sibling::td/input[1]");
    private UIElement btnClickReorderSaveChanges = createElement(
            UIType.Css,
            "input[onclick='javascript:btnSaveChangesReorder_onclick()']");
    private UIElement btnClickCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblHeader = createElement(UIType.Xpath, "//div[@class='tablehead']");
    private UIElement btnClickSaveChangesForDropDown = createElement(
            UIType.Css,
            "input[value='Save Changes']");
    private UIElement btnClickSaveChangesUnderUnit = createElement(
            UIType.Xpath,
            "//table[4]//tr[4]//td/input[1]");

    /* variables */

    String strValue = null;
    String strText = null;
    boolean flag = false;

    /* constructor */
    public MoveItemNamePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "MoveItemNamePage";
        logInstruction("LOG INSTRUCTION: ## MOVEITEMNAMEPAGE ##");

    }

    /**
     * This method used to select the item to move
     * 
     * @author kiran.kumar
     * @param String
     * @return MoveItemNamePage
     * @throws Exception
     */
    public MoveItemNamePage selectItemMoveDropDown(String itemname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE ITEM TO MOVE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpSelectMoveTo);
            drpSelectMoveTo.selectByVisibleText(itemname);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT" + "\n METHOD: selectItemMoveDrpDwn \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method used to enter order number
     * 
     * @author kiran.kumar
     * @param String
     * @param String
     * @return MoveItemNamePage
     * @throws Exception
     */
    public MoveItemNamePage setOrderNumber(String orderNumber, String itemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE ITEM TO NUMBER");
            frameSwitch.switchToFrameContent();
            btnMoveOrderBox.replaceValues(orderNumber);
            uiDriver.waitToBeDisplayed(btnMoveOrderBox);
            btnMoveOrderBox.clearAndSendKeys(itemName);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER ITEM NO." + "\n METHOD:setOrdernumber \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method used to get order number
     * 
     * @author kiran.kumar
     * @param String
     * @return MoveItemNamePage
     * @throws Exception
     */
    public String getOrderNumber(String itemName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: FETCHING THE ITEM TO NUMBER");
            frameSwitch.switchToFrameContent();
            btnMoveOrderBox.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(btnMoveOrderBox);
            strValue = btnMoveOrderBox.getValue();

        } catch (Exception e) {
            throw new Exception("UNABLE TO FETCH ITEM NO." + "\n METHOD:getOrdernumber \n" + e
                    .getLocalizedMessage());
        }
        return strValue;
    }

    /**
     * This method helps to click on save changes
     * 
     * @author kiran.kumar
     * 
     * @return ItemToolBoxPage
     * @throws Exception
     */
    public ItemToolBoxPage clickReorderSavebutton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickReorderSaveChanges, waitTime);
            btnClickReorderSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES" + "\n METHOD:clickReorderSavebutton \n" + e
                            .getLocalizedMessage());
        }
        return new ItemToolBoxPage(uiDriver);
    }

    /**
     * This method helps to click on cancel
     * 
     * @author kiran.kumar
     * 
     * @return MoveItemNamePage
     * @throws Exception
     */
    public MoveItemNamePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickCancel, waitTime);
            btnClickCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK CANCEL" + "\n METHOD:clickCancelbtn \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This page checks the header title of the move
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public boolean isMovePageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE HEADER OF THE MOVE PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeader, waitTime);
            strText = lblHeader.getText();
            if (strText.contains("Move")) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK THE MOVE PAGE HEADER" + "\n METHOD:isMovePageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This methods helps to select the drop down value from move to
     * 
     * @author ashish.juyal
     * @param String
     * @return MoveItemNamePage
     * @throws Exception
     */

    public MoveItemNamePage selectValueFromMoveTo(String courseName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE MOVE TO DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(drpSelectMoveTo, waitTime);
            drpSelectMoveTo.selectByVisibleText(courseName);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE VALUE FROM MOVE TO" + "\n METHOD:selectValueFromMoveTo \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on save changes present on the top
     * 
     * @author kiran.kumar
     * @param
     * @return ItemToolBoxPage
     * @throws Exception
     */
    public ItemToolBoxPage clickSaveButtonForDropdown() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickSaveChangesForDropDown, waitTime);
            btnClickSaveChangesForDropDown.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES" + "\n METHOD:clickSaveButtonForDropdown \n");
        }
        return new ItemToolBoxPage(uiDriver);
    }

    /**
     * This method helps to click on save changes present below for items under theunit
     * 
     * @author kiran.kumar
     * @param
     * @return ItemToolBoxPage
     * @throws Exception
     */
    public ItemToolBoxPage clickReorderSaveButtonUnderUnit() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickSaveChangesUnderUnit, waitTime);
            btnClickSaveChangesUnderUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES" + "\n METHOD:clickReorderSavebuttonUnderUnit \n" + e
                            .getLocalizedMessage());
        }
        return new ItemToolBoxPage(uiDriver);
    }

}
