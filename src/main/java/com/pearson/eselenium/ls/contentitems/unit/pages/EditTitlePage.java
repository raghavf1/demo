package com.pearson.eselenium.ls.contentitems.unit.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditTitlePage extends BasePageObject {

    /* UIElements of the CourseItemPage */
    private UIElement txtHeader = createElement(UIType.Css, ".tablehead");
    private UIElement txtTitle = createElement(UIType.Css, "input[id='ToolboxHelper.UnitTitle']");
    private UIElement chkTitle = createElement(
            UIType.Css,
            "input[id='ToolboxHelper.IsUsingTitleInNav']");
    private UIElement btnSaveChangesButton = createElement(
            UIType.Css,
            "input[value='Save Changes']");
    private UIElement btnCancelButton = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblTitle = createElement(
            UIType.Xpath,
            "//input[@id='ToolboxHelper.UnitTitle']");
    /* variables */
    String strHeader = null;
    String strEditTitleHeader = "Edit Unit Title";
    String strEditTitlePageHeader;
    String strTableTitle;
    boolean flag = false;

    /* Constructor */
    public EditTitlePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "EditTitlePage";
        logInstruction("LOG INSTRUCTION: ## Course Items Page ##");
    }

    /**
     * This method get the header title of edit title page
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
     * This method check edit Title Page is Displayed
     * 
     * @return:String
     * @throws Exception
     * @author soundarya
     */
    public boolean isEditTitlePageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK EDIT TITLE PAGE IS DISPLAYED");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            strEditTitlePageHeader = txtHeader.getText();
            if (strEditTitleHeader.equals(strEditTitlePageHeader)) {
                flag = true;
            }
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY CHECK EDIT TITLE PAGE IS DISPLAYED");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK EDIT TITLE PAGE IS DISPLAYED" + "\n METHOD:isEditTitlePageDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method enter Title
     * 
     * @param:String
     * @throws Exception
     * @author soundarya
     * @return EditTitlePage
     */
    public EditTitlePage enterTitle(String title) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTER TITLE");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            txtTitle.clearAndSendKeys(title);
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY ENTER TITLE");

        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TITLE" + "\n METHOD:enterTitle \n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method get Title
     * 
     * 
     * @throws Exception
     * @author soundarya
     * @return String
     */
    public String getTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GET TITLE");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getAttribute("value");
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY GET TITLE");

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET TITLE" + "\n METHOD:getTitle \n" + e
                    .getLocalizedMessage());
        }

        return strTableTitle;
    }

    /**
     * This method click Check box for use Title
     * 
     * @return:EditTitlePage
     * @throws Exception
     * @author soundarya
     */
    public EditTitlePage clickCheckboxuseTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK CHECK BOX FOR USE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkTitle, waitTime);
            if (chkTitle.isSelected() == false) {
                chkTitle.clickAndWait(waitTime);
            }
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICK CHECK BOX  FOR USE TITLE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CHECK BOX  FOR USE TITLE" + "\n METHOD:clickCheckboxuseTitle \n" + e
                            .getLocalizedMessage());
        }
        return this;
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
     * This method helps to edit the unit title
     * 
     * @return EditTitlePage
     * @author ashish.juyal
     * @throws Exception
     */
    public EditTitlePage enterEditUnitTitle(String name) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: EDITING THE UNIT TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblTitle, waitTime);
            lblTitle.sendKeys(Keys.CONTROL + "a");
            lblTitle.sendKeys(Keys.DELETE);
            lblTitle.sendKeys(name);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CANCEL BUTTON" + "\n METHOD:enterEditUnitTitle \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Service method to edit title after clicking editTitle in {@link UnitToolboxPage}
     * 
     * @author Vivek.Singh
     * @Navigates to UnitToolboxPage
     * @param String
     *            ,Boolean
     * @return UnitToolboxPage
     * @throws Exception
     * @category Milestone 2
     * **/
    public UnitToolboxPage editTitle(String strTitle, boolean boolUseTitle) throws Exception {
        logInstruction("LOG INSTRUCTION: EDITING 'Title' OF UNIT.");
        try {
            if (StringUtils.isNotBlank(strTitle)) {
                logInstruction("LOG INSTRUCTION: SENDING KEYS TO 'Textbox'.");
                frameSwitch.switchToFrameContent();
                uiDriver.waitToBeDisplayed(lblTitle, waitTime);
                lblTitle.sendKeysToFileInput(Keys.CONTROL + "a");
                lblTitle.sendKeysToFileInput(Keys.DELETE);
                lblTitle.sendKeysToFileInput(strTitle);

                logInstruction("LOG INSTRUCTION: CHECKING 'Chceckbox' OF 'Use this name in Navigation'.");
                uiDriver.waitToBeDisplayed(chkTitle, waitTime);
                if (boolUseTitle)
                    if (!chkTitle.isSelected()) {
                        chkTitle.clickNoWait();
                    }

                logInstruction("LOG INSTRUCTION: CLICKING 'Save Changes' BUTTON.");
                uiDriver.waitToBeDisplayed(btnSaveChangesButton, waitTime);
                btnSaveChangesButton.clickAndWait(waitTime);
                return new UnitToolboxPage(uiDriver);
            } else
                throw new Exception("'Title' name provided is null.\nMETHOD: editTitle \n");
        } catch (Exception e) {
            throw new Exception("UNABLE TO 'Edit Title' OF UNIT. \nMETHOD: editTitle \n" + e
                    .getLocalizedMessage());
        }
    }
}