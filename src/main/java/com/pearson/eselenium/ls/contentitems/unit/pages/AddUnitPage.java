package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods for the AddUnit Page
 * 
 * @author ashish.juyal
 */
public class AddUnitPage extends BasePageObject {

    /* UIElements in the AddUnitPage */

    private UIElement txtTitle = createElement(UIType.Css, "#unitItemTitle");
    private UIElement chkBox = createElement(UIType.Css, "#isUseTitleForDisplay");
    private UIElement drpIntroductionType = createElement(UIType.Css, "#contentType");
    private UIElement btnAddUnit = createElement(UIType.Css, "#AddItem");
    private UIElement btnCancel = createElement(UIType.Css, "#CancelItem");
    private UIElement btnSaveAndAddUnit = createElement(UIType.Css, "#AddAndNew");
    private UIElement txtPageHeader = createElement(UIType.Css, ".tablehead");
    boolean flag = false;
    String strValue = null;

    /* Constructor */
    public AddUnitPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "AddUnitPage";
        logInstruction("LOG INSTRUCTION: ##  Add Unit Page ##");
    }

    /**
     * This method enter text into the title text box
     * 
     * @return:AddUnitPage
     * @param String
     * @author ashish.juyal
     * @throws Exception
     * 
     */
    public AddUnitPage enterTitleText(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER TEXT INTO TITLE TEXTBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            txtTitle.sendKeys(text);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER TEXT INTO TITLE TEXTBOX" + "\n METHOD:enterTitleText \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click the checkbox in AddUnitPage
     * 
     * @return:AddUnitPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddUnitPage clickCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK THE CHECKBOX IN ADD UNIT PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            chkBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK CHECKBOX" + "\n METHOD:clickCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method select the value from the selectIntroductionType dropdown
     * 
     * @author ashish.juyal
     * @param String
     * @return:AddUnitPage
     * @throws Exception
     */
    public AddUnitPage selectIntroductionType(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECTING VALUE FROM INTRODUCTIONTYPE DROPDOWN");
            frameSwitch.switchToFrameContent();
            drpIntroductionType.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT VALUE FROM THE DROPDOWN LIST" + "\n METHOD:selectIntroductionType \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click the AddUnitItemButton in the AddUnitPage
     * 
     * @return:CourseItemPage
     * @throws Exception
     * @author ashish.juyal
     */
    public CourseItemsPage clickAddUnitItemButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON ADD UNIT BUTON IN PAGE DETAILS");
            frameSwitch.switchToFrameContent();
            btnAddUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE ADDUNIT BUTTON" + "\n METHOD:clickAddUnitItemButton \n" + e
                            .getLocalizedMessage());
        }

        return new CourseItemsPage(uiDriver);
    }

    /**
     * This method click the cancel button
     * 
     * @return:CourseItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public CourseItemsPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CANCEL BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new CourseItemsPage(uiDriver);
    }

    /**
     * This method clicks the saveAndAddMoreButton
     * 
     * @return:AddUnitPage
     * @author ashish.juyal
     * @throws Exception
     */
    public AddUnitPage clickSaveAndAddAnotherUnitButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVEANDADDMORE BUTTON");
            frameSwitch.switchToFrameContent();
            btnSaveAndAddUnit.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SAVEANDADDMORE BUTTON" + "\n METHOD:clickSaveAndAndAnotherUnitButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method verify the AddUnitPage
     * 
     * @throws Exception
     * @author ashish.juyal
     * @return: boolean
     * @param String
     */
    public boolean verifyAddUnitPage(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE ADDUNIT PAGE");
            frameSwitch.switchToFrameContent();
            strValue = txtPageHeader.getText();
            if (strValue.equalsIgnoreCase(name)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE ADDUNIT PAGE" + "\n METHOD:verifyAddUnitPage \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /***
     * This method helps add an Unit
     * 
     * @param strUnitName
     * @param strIntroductionType
     * @param flagUseTitle
     * @param flagSaveNAddAnotherUnit
     * @return Object
     * @throws Exception
     * 
     * @author sumanth.sv
     */

    public Object addUnit(
            String strUnitName,
            String strIntroductionType,
            boolean flagUseTitle,
            boolean flagSaveNAddAnotherUnit) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTER TEXT INTO TITLE TEXTBOX");
            frameSwitch.switchToFrameContent();
            if (!txtTitle.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Title Textbox' DOES NOT EXISTS \n METHOD: addUnit");
            }
            txtTitle.sendKeys(strUnitName);

            logInstruction("LOG INSTRUCTION:SELECTING VALUE FROM INTRODUCTIONTYPE DROPDOWN");
            if (!drpIntroductionType.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception(
                        "'Introduction Type Dropbox' DOES NOT EXISTS \n METHOD: addUnit");
            }
            drpIntroductionType.selectByVisibleText(strIntroductionType);

            if (flagUseTitle == true) {
                logInstruction("LOG INSTRUCTION: CLICK THE USE TITLE IN NAVIGATION MENU CHECKBOX");
                if (!chkBox.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Use Title In Navigation Menu Checkbox' DOES NOT EXISTS \n METHOD: addUnit");
                }
                chkBox.clickAndWait(waitTime);
            }
            if (flagSaveNAddAnotherUnit == true) {
                logInstruction("LOG INSTRUCTION: CLICKING ON SAVEANDADDMORE BUTTON");
                if (!btnSaveAndAddUnit.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception(
                            "'Save And Add Another Unit Button' DOES NOT EXISTS \n METHOD: addUnit");
                }
                btnSaveAndAddUnit.clickAndWait(waitTime);
                return new AddUnitPage(uiDriver);
            } else {
                logInstruction("LOG INSTRUCTION: CLICK ADD UNIT BUTTON");
                if (!btnAddUnit.isDisplayedAfterWaiting(waitTime)) {
                    throw new Exception("'Add Unit Button' DOES NOT EXISTS \n METHOD: addUnit");
                }
                btnAddUnit.clickAndWait(waitTime);
                return new CourseItemsPage(uiDriver);
            }

        } catch (Exception e) {
            throw new Exception("UNABLE TO ADD UNIT" + "\n METHOD: addUnit\n" + e
                    .getLocalizedMessage());
        }
    }
}
