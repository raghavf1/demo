package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ChangeItemOrderPage extends BasePageObject {

    /* Initializing the UIElements */
    private UIElement txtChangeOrder = createElement(
            UIType.Xpath,
            "//tr[th[label[contains(text(),'{1}')]]]/td/input[1]");
    private UIElement txtGetHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement btnClickSaveChange = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    boolean flag = false;
    String strHeader = null;
    String strData = null;

    /* Constructor */
    public ChangeItemOrderPage(UIDriver driver) {
        super(driver);
        pageTitle = "ChangeItemOrderPage";
        logInstruction("LOG INSTRUCTION: ## Change Item Order Page ##");
    }

    /**
     * This Method Will insert order number according to item name
     * 
     * @param itemName
     *            Name of the item of which you want to change the order
     * @param orderNo
     *            order number which you want to set
     * @return ChangeItemOrderPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public ChangeItemOrderPage enterOrderNumber(String itemName, String orderNo) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER ORDER NUMBER");
            frameSwitch.switchToFrameContent();
            txtChangeOrder.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtChangeOrder, waitTime);
            txtChangeOrder.clearAndSendKeys(orderNo);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER ORDER NUMBER" + "\n METHOD:enterOrderNumber \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This Method will get the Header of the ChangeItemPage
     * 
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtGetHeaderTitle, waitTime);
            strHeader = txtGetHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());

        }
        return strHeader;
    }

    /**
     * This Method will check whether we are at Change Item Order Page or not
     * 
     * @return Boolean
     * @param String
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean isChangeItemOrderPageDisplayed(String ItemOrderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING CHANGEITEMORDER PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtGetHeaderTitle, waitTime);
            strData = txtGetHeaderTitle.getText();
            if (strData.contains(ItemOrderName)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DISPLAY CHANGEITEMORDER PAGE" + "\n METHOD:ischangeItemOrderPageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will get the Order number According to Item Name
     * 
     * @param itemName
     *            Name of the item of which you want order number
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getOrderNumber(String itemName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING ORDER NUMBER");
            frameSwitch.switchToFrameContent();
            txtChangeOrder.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(txtChangeOrder, waitTime);
            strData = txtChangeOrder.getValue();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE ORDER NUMBER" + "\n METHOD:getOrderNumber \n" + e
                            .getLocalizedMessage());
        }
        return strData;
    }

    /**
     * This method will click on Savechanges button
     * 
     * @return UnitToolboxPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public UnitToolboxPage clickSaveChange() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickSaveChange, waitTime);
            btnClickSaveChange.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE SAVE BUTTON" + "\n METHOD:clickSaveChange \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method will click on Cancel button
     * 
     * @return ChangeItemOrderPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ChangeItemOrderPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CANCEL BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /***
     * Method verifies whether savechanges button is present
     * 
     * @author Suchi.Singh
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveChangesButtonPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:SAVE CHANGES BUTTON IS CLICKED");
            frameSwitch.switchToFrameContent();
            if (btnClickSaveChange.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY SAVE CHANGES BUTTON" + "\n METHOD:isSaveChangesbtnPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
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
            txtChangeOrder.replaceValues(strItemName);
            if (!txtChangeOrder.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Order Textbox' DOES NOT EXISTS \n METHOD: changeItemOrder");
            }
            txtChangeOrder.clearAndSendKeys(strOrderNumber);

            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGE BUTTON");
            if (!btnClickSaveChange.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception(
                        "'Save Changes Button' DOES NOT EXISTS \n METHOD: changeItemOrder");
            }
            btnClickSaveChange.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHANGE THE ITEM ORDER " + "\n METHOD: changeItemOrder \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);

    }
}
