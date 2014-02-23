package com.pearson.eselenium.ls.contentitems.unit.pages;

/**Class contains all the methods related to ItemToolBoxPage
 * Course-authortab-item-toolbox
 * 
 * @author kiran kumar
 * @throws Exception
 * @returns string
 */
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ItemToolBoxPage extends BasePageObject {

    private UIElement lblGetHeader = createElement(UIType.Css, "h2>div");
    private UIElement lnkClickContentlnk = createElement(UIType.LinkText, "Content");
    private UIElement btnClickEditBtn = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Edit Schedul')]");
    private UIElement btnClickMoveBtn = createElement(UIType.Xpath, "//a[contains(text(),'Move')]");
    private UIElement btnClickDeleteBtn = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Delete')]");
    private UIElement drpSelectAssignDrpDwn = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']//td//select");
    private UIElement chkClickHideformChkBox = createElement(UIType.ID, "isHidden");
    private UIElement btnClickSaveChangesBtn = createElement(
            UIType.Css,
            "input[value='Save Changes']");
    private UIElement btnToolBox = createElement(UIType.ID, "Content");
    private UIElement btnClickDeletConfirm = createElement(UIType.Css, "input[value='Delete']");

    /* variables */
    boolean flag = false;
    String strValue = null;

    /* constructor */

    public ItemToolBoxPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ItemToolBoxPage";
        logInstruction("LOG INSTRUCTION: ## ITEMTOOLBOXPAGE ##");
    }

    /**
     * method helps to get the header text
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns string
     */

    public String getHeader() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER");
            frameSwitch.switchToFrameContent();
            strValue = lblGetHeader.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO FETCH HEADER" + "\n METHOD:getHeader \n" + e
                    .getLocalizedMessage());

        }
        return strValue;
    }

    /**
     * method helps to click on content button
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns ItemToolBoxPage
     */

    public ItemToolBoxPage clickOnContent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK CONTENT");
            frameSwitch.switchToFrameContent();
            lnkClickContentlnk.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICKON CONTENT" + "\n METHOD:clickOnContent \n" + e
                    .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps to click edit schedule
     * 
     * @author kiran kumar
     * @throws Exception
     * @return ItemToolBoxPage
     */

    public ItemToolBoxPage clickOnEditSchedule() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK EDIT SCHEDULE");
            frameSwitch.switchToFrameContent();
            btnClickEditBtn.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON EDIT" + "\n METHOD:clickOnEditSchedule \n" + e
                    .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps to click on move
     * 
     * @author kiran kumar
     * @throws Exception
     * @return MoveItemNamePage
     */

    public MoveItemNamePage clickOnMove() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK ON MOVE LINK");
            frameSwitch.switchToFrameContent();
            btnClickMoveBtn.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON MOVE" + "\n METHOD:clickOnMove \n" + e
                    .getLocalizedMessage());

        }
        return new MoveItemNamePage(uiDriver);
    }

    /**
     * method helps to click on delete
     * 
     * @author kiran kumar
     * @throws Exception
     * @return DeleteUnitPage
     */
    public DeleteUnitPage clickOnDelete() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            btnClickDeleteBtn.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON DELETE" + "\n METHOD:clickOnDelete \n" + e
                    .getLocalizedMessage());
        }
        return new DeleteUnitPage(uiDriver);
    }

    /**
     * method helps to select value from dropdown
     * 
     * @author kiran kumar
     * @throws Exception
     * @param String
     * @return ItemToolBoxPage
     */

    public ItemToolBoxPage selectAssigntoDropDown(String value) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            drpSelectAssignDrpDwn.selectByVisibleText(value);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT FROM DRPDWN" + "\n METHOD:selectAssigntodrpDwn \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method helps to click chk box
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns ItemToolBoxPage
     */

    public ItemToolBoxPage clickHideStudentCheckBox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK ON CHECK BOX");
            frameSwitch.switchToFrameContent();
            chkClickHideformChkBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CHK BOX" + "\n METHOD:clickHideStudentchkBox \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps to click save changes
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns ItemToolBoxPage
     */
    public ItemToolBoxPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVECHANGES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickSaveChangesBtn, waitTime);
            btnClickSaveChangesBtn.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SAVE CHANGES" + "\n METHOD:clickSavechangesBtn \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps verify the toolbox
     * 
     * @author kiran kumar
     * @throws Exception
     * @return boolean
     */

    public boolean isItemToolBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING TOOLBOX PAGE");
            frameSwitch.switchToFrameContent();
            flag = btnToolBox.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE TOOL BOX" + "\n METHOD:isItemToolBoxDisplayed \n" + e
                            .getLocalizedMessage());

        }
        return flag;
    }

    /**
     * This Method will delete item On the Confirmation Page
     * 
     * @return ItemToolBoxPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public ItemToolBoxPage clickDeleteOnConfirmationPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE ITEM ON CONFIRM PAGE");
            uiDriver.waitToBeDisplayed(btnClickDeletConfirm, waitTime);
            btnClickDeletConfirm.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO GET THE DELETE BUTTON" + "\n METHOD:clickDeleteOnConfirmationPage \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
}
