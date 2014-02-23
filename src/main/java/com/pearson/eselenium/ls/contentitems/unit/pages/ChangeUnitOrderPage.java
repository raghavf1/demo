package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ChangeUnitOrderPage extends BasePageObject {

    /* UIElements of the CourseItemPage */

    private UIElement txtHeader = createElement(UIType.Css, ".tablehead");
    private UIElement txtOrder = createElement(
            UIType.Xpath,
            "//th[label[contains(text(),'{1}')]]/following-sibling::td/input[1]");
    private UIElement btnSaveChangesButton = createElement(
            UIType.Css,
            "input[value='Save Changes']");
    private UIElement btnCancelButton = createElement(UIType.Css, "input[value='Cancel']");
    boolean flag = false;
    String strHeader = null;
    String strOrderNo = null;
    String header = null;

    /* Constructor */
    public ChangeUnitOrderPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ChangeUnitOrderPage";
        logInstruction("LOG INSTRUCTION: ## CHANGE UNIT ORDER PAGE ##");
    }

    /**
     * This method get the header title of change unit order page
     * 
     * @return:String
     * @throws Exception
     * @author soundarya
     */
    public String getHeader() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            strHeader = txtHeader.getText();
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY GET HEADER TITLE");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE" + "\n METHOD:getHeader \n" + e
                    .getLocalizedMessage());
        }
        return strHeader;
    }

    /**
     * This method check Unit Order Page Displayed
     * 
     * @param:String
     * @return boolean
     * @throws Exception
     * @author soundarya
     */
    public boolean isChangeUnitOrderPageDisplayed(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK UNIT ORDER PAGE DISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            header = txtHeader.getText();
            if (header.equals(name)) {
                flag = true;
            }
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CHECK UNIT ORDER PAGE DISPLAYED");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK UNIT ORDER PAGE DISPLAYED" + "\n METHOD:isChangeUnitOrderPageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method click Save Changes Button
     * 
     * @return:UnitToolboxPage
     * @throws Exception
     * @author soundarya
     */
    public UnitToolboxPage clickSaveChangesButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChangesButton, waitTime);
            btnSaveChangesButton.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICK SAVE CHANGES BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES BUTTON" + "\n METHOD:clickSaveChangesButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method click Cancel Button
     * 
     * @return:UnitToolboxPage
     * @throws Exception
     * @author soundarya
     */
    public UnitToolboxPage clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancelButton, waitTime);
            btnCancelButton.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICK CANCEL BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CANCEL BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method enter Order
     * 
     * @param:String
     * @param String
     * @throws Exception
     * @author soundarya
     * @return ChangeUnitOrderPage
     */
    public ChangeUnitOrderPage enterOrder(String unitName, String orderno) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTER ORDER");
            frameSwitch.switchToFrameContent();
            txtOrder.replaceValues(unitName);
            uiDriver.waitToBeDisplayed(txtOrder, waitTime);
            txtOrder.clearAndSendKeys(orderno);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY ENTER ORDER");
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER ORDER" + "\n METHOD:enterOrder \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method get Order No
     * 
     * @param String
     * @throws Exception
     * @author soundarya
     * @return String
     */
    public String getOrderNo(String unitName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET ORDER NUMBER");
            frameSwitch.switchToFrameContent();
            txtOrder.replaceValues(unitName);
            uiDriver.waitToBeDisplayed(txtOrder, waitTime);
            strOrderNo = txtOrder.getAttribute("value");
            logInstruction("LOG INSTRUCTION: SUCESSFULLY GET TITLE");

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ORDER NO" + "\n METHOD:getOrderNo \n" + e
                    .getLocalizedMessage());
        }

        return strOrderNo;
    }

    /**
     * This method helps to change the item order
     * 
     * @param strItemName
     * @param strOrderNumber
     * @return UnitToolboxPage
     * @throws Exception
     * 
     * @author sumanth.sv
     */
    public UnitToolboxPage changeItemOrder(String strItemName, String strOrderNumber)
            throws Exception {

        try {

            logInstruction("LOG INSTRUCTION:ENTER ORDER NUMBER");
            frameSwitch.switchToFrameContent();
            txtOrder.replaceValues(strItemName);
            if (!txtOrder.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Order Textbox' DOES NOT EXISTS \n METHOD: changeItemOrder");
            }
            txtOrder.clearAndSendKeys(strOrderNumber);

            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGE BUTTON");
            if (!btnSaveChangesButton.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception(
                        "'Save Changes Button' DOES NOT EXISTS \n METHOD: changeItemOrder");
            }
            btnSaveChangesButton.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHANGE THE ITEM ORDER " + "\n METHOD: changeItemOrder \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);

    }

}
