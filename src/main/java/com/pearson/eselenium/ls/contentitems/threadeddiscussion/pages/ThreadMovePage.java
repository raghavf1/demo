package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class Contains All Methods Related To Thread Move Page
 * 
 * @author amit.deshmukh
 * @category Milestone2
 */

public class ThreadMovePage extends BasePageObject {

    private UIElement lblHeaderTitle = createElement(UIType.Xpath, "//table[3]");
    private UIElement btnCancel = createElement(
            UIType.Xpath,
            "//form/table[2]//tbody/tr[4]/td/input[2]");

    private UIElement btnSaveChangesTop = createElement(
            UIType.Xpath,
            "//table[1]/tbody/tr[1]/td/table[2]/tbody/tr[4]/td/input[1]");
    private UIElement selMoveToUnit = createElement(UIType.Css, "#moveToUnitSubId");
    private UIElement txtOrderNumber = createElement(
            UIType.Xpath,
            "//td[contains(text(),'{1}')]/following-sibling::td[input[contains(@id,'NewOrderNumber')]]");
    private UIElement btnSaveChangesBottom = createElement(
            UIType.Xpath,
            "//table[2]/tbody/tr[1]/td/table[2]/tbody/tr[4]/td/input[1]");
    private boolean flag = false;

    public ThreadMovePage(UIDriver driver) {
        super(driver);
        pageTitle = "ThreadMovePage";
        logInstruction("###Thread Move Page###");
    }

    /**
     * Methods helps to find Whether ReorderUnits Within Item/Section Is Present Or Not
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return boolean 
     * @throws Exception
     */

    public boolean isHeaderTitleDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THREAD MOVE PAGE 'ReorderUnits' IS DISPLAYED OR NOT ");
            frameSwitch.switchToFrameContent();
            flag = lblHeaderTitle.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'ReorderUnits' DISPLAYED OR NOT" + "\nMETHOD:isHeaderTitleDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method helps to click on Cancel button
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @throws Exception
     * @returns ThreadToolBoxPage
     */
    public ThreadToolBoxPage clickOnCancel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON 'Cancel' BUTTON");
            frameSwitch.switchToFrameContent();
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'Cancel' BUTTON" + "\nMETHOD:clickOnCancel \n" + e
                            .getLocalizedMessage());
        }
        return new ThreadToolBoxPage(uiDriver);
    }

    /**
     * METHOD IS USED TO SELECT UNIT TO MOVE
     * 
     * @category milestone 2
     * @author Pratush.Manglik
     * @param strUnitName
     * @throws Exception
     */
    public void selectUnitToMove(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTON : SELECT 'Unit' TO MOVE");
            frameSwitch.switchToFrameContent();

            if (StringUtils.isNotBlank(strUnitName)) {
                logInstruction("LOG INSTRUCTION : SELECT 'Unit'");
                uiDriver.waitToBeDisplayed(selMoveToUnit, waitTime);
                selMoveToUnit.selectByVisibleText(strUnitName);
            }

            logInstruction("LOG INSTRUCTION : CLICK 'Save Changes' BUTTON");
            uiDriver.waitToBeDisplayed(btnSaveChangesTop, waitTime);
            btnSaveChangesTop.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT  'Unit' TO MOVE TO" + "\n METHOD : selectUnitToMove \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * METHOD IS USED TO REORDER ITEM
     * 
     * @category milestone 2
     * @author Pratush.Manglik
     * @param strContentItem
     * @param orderNumber
     * @throws Exception
     */
    public void reOrderFrItem(String strContentItem, String orderNumber) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : REORDER FOR ITEM");
            frameSwitch.switchToFrameContent();

            if (StringUtils.isNotBlank(strContentItem)) {
                logInstruction("LOG INSTRUCTION : ENTER ORDER");
                txtOrderNumber.replaceValues(strContentItem);
                uiDriver.waitToBeDisplayed(txtOrderNumber, waitTime);
                txtOrderNumber.clearAndSendKeys(orderNumber);
            }

            logInstruction("LOG INSTRUCTION : CLICK 'Save Changes' BUTTON");
            uiDriver.waitToBeDisplayed(btnSaveChangesBottom, waitTime);
            btnSaveChangesBottom.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO REORDER ITEM" + "\n METHOD : reOrderFrItem \n" + e
                    .getLocalizedMessage());
        }

    }
}
