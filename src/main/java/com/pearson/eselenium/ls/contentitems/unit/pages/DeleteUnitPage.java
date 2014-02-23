package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class DeleteUnitPage extends BasePageObject {

    /* UIElements of the CourseItemPage */
    private UIElement txtHeader = createElement(UIType.Css, ".tablehead");
    private UIElement chkIAgree = createElement(UIType.Css, "#chkDeleteAgree");
    private UIElement btnDeleteButton = createElement(UIType.Xpath, "//input[@name='bttnSubmit']");
    private UIElement btnCancelButton = createElement(UIType.Css, "input[value='Cancel']");

    private UIElement btnDelete = createElement(
            UIType.Xpath,
            "//input[@value='Delete Unit & Content Items']");
    String strHeader = null;
    String strDeleteHeader = "Delete Unit:";
    String[] strEntireHeader;

    boolean flag = false;

    /* Constructor */
    public DeleteUnitPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "DeleteUnitPage";
        logInstruction("LOG INSTRUCTION: ## COURSE ITEMS PAGE ##");
    }

    /**
     * This method get the header title of Delete Unit Page
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
     * This method check Delete page displayed
     * 
     * @return:String
     * @throws Exception
     * @author soundarya
     */
    public boolean isDeletePageDisplayed() throws Exception {
        flag = false;

        try {
            logInstruction("LOG INSTRUCTION: CHECK DELETE PAGE DISPLAYED");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            strEntireHeader = (txtHeader.getText()).split("Delete Unit:");
            if (strDeleteHeader.endsWith(strEntireHeader[0])) {
                flag = true;
            }
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CHECK CHECK DELETE PAGE DISPLAYED");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK DELETE PAGE DISPLAYED" + "\n METHOD:isDeletePageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method click I Agree checkbox
     * 
     * @throws Exception
     * @author soundarya
     * @return DeleteUnitPage
     */
    public DeleteUnitPage clickIAgreeCheckBox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK I AGREE CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkIAgree, waitTime);
            chkIAgree.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICK I AGREE CHECKBOX");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK I AGREE CHECKBOX" + "\n METHOD:clickIAgreeCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method click Delete Unit Button
     * 
     * @param String
     *            unitHeading
     * @return NextAuthorHomePage
     * @throws Exception
     * @author soundarya
     */
    public NextAuthorHomePage clickDeleteUnitButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK DELETE UNIT BUTTON");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(btnDeleteButton, waitTime);
            btnDeleteButton.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CLICK DELETE UNIT BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK DELETE UNIT BUTTON" + "\n METHOD:clickDeleteUnitButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method click Cancel Button
     * 
     * @return UnitToolboxPage
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
     * This method helps to Delete an Unit
     * 
     * @return NextAuthorHomePage
     * @throws Exception
     * 
     * @author sumanth.sv
     */
    public NextAuthorHomePage deleteUnit() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK I AGREE CHECKBOX");
            frameSwitch.switchToFrameContent();

            if (!chkIAgree.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'I Agree Checkbox' DOES NOT EXISTS \n METHOD: deleteUnit");
            }
            chkIAgree.clickAndWait(waitTime);

            logInstruction("LOG INSTRUCTION: CLICK DELETE UNIT BUTTON");
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS \n METHOD: deleteUnit");
            }
            btnDelete.clickAndWait(waitTime);
            return new NextAuthorHomePage(uiDriver);

        } catch (Exception e) {
            throw new Exception("UNABLE TO DELETE UNIT" + "\n METHOD: deleteUnit \n" + e
                    .getLocalizedMessage());
        }

    }
}
