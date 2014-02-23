package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the UnitToolBoxPage
 * 
 * @author ashish.juyal
 */
public class UnitToolboxPage extends BasePageObject {

    /* UIElements for the UnitToolBoxPage */
    private UIElement lnkDelete = createElement(UIType.Xpath, "//a[contains(.,'Delete')]");
    private UIElement chkAgree = createElement(UIType.Xpath, "//input[@id='chkDeleteAgree']");
    private UIElement btnDeletContent = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Delete')]");
    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement btnEditSheduleContent = createElement(UIType.Css, "a[title='Edit Schedule']");
    private UIElement txtSelectDueDateBox = createElement(UIType.Css, "#DueDate");
    private UIElement btnClickSaveCloseButton = createElement(UIType.Css, "#cmdAddEntry");
    private UIElement lnkEditSchedule = createElement(UIType.Css, "a[title='Edit Schedule']");
    private UIElement tabUnitToolbox = createElement(UIType.Css, ".tablehead>b");
    private UIElement txtGetHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement btnDelete = createElement(UIType.Xpath, "//a[contains(text(),'Delete {1}')]");
    private UIElement txtEditUnitTitle = createElement(
            UIType.Css,
            "a[href*='javascript:lnkEditUnitTitle_onclick()']");
    private UIElement btnClickChangeItemOrder = createElement(
            UIType.Css,
            "a[title='Change Item Order']");
    private UIElement btnClickChangeUnitOrder = createElement(
            UIType.Css,
            "a[href*='javascript:lnkReorderUnits_onclick()']");

    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']//tbody//tr[td[a[contains(.,'Edit Schedule')]]]//td[2]");
    /* variables */
    boolean flag = false;
    String strText = null;
    String strData = null;
    String strErrorMessage = null;
    String value = null;

    /* Constructor */
    public UnitToolboxPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "UnitToolboxPage";
        logInstruction("LOG INSTRUCTION: ## Unit Toolbox Page ##");
    }

    /**
     * This methods click the delete link
     * 
     * @return:UnitToolboxPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitToolboxPage clickDeleteLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE DELETE LINK");
            frameSwitch.switchToFrameContent();
            lnkDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE DELETE LINK" + "\n METHOD:clickDeleteLink \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click the check box
     * 
     * @return:UnitToolboxPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitToolboxPage clickCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkAgree.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE CHECKBOX" + "\n METHOD:clickCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method clicks the delete button
     * 
     * @return:NextCourseHomePage
     * @throws Exception
     * @author ashish.juyal
     */
    public NextCourseHomePage clickDeleteUnitButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDeletContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE DELETE BUTTON" + "\nMETHOD:clickDeleteUnitButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * this method Select Due Date
     * 
     * @return:NextCourseHomePage
     * @param String
     * @throws Exception
     * @author hemant.kumar
     */
    public UnitToolboxPage selectDueDate(String mmddyyyy) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE DUE DATE");
            frameSwitch.switchToFrameContent();
            btnEditSheduleContent.isDisplayedAfterWaiting(waitTime);
            btnEditSheduleContent.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
            frameSwitch.switchToAddLinkFrame();
            txtSelectDueDateBox.sendKeys(mmddyyyy);
            btnClickSaveCloseButton.isDisplayedAfterWaiting(waitTime);
            btnClickSaveCloseButton.clickAndWait(waitTime);
            frameSwitch.switchToParentWindow();

        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT DUE DATE" + "\n METHOD:selectDueDate \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method verify the toolbox page
     * 
     * @author ashish.juyal
     * @return:boolean value
     * @param String
     * @throws Exception
     */
    public boolean verifyToolBoxPage(String name) throws Exception {
        value = null;
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE TOOLBOX PAGE");
            frameSwitch.switchToFrameContent();
            value = txtPageTitle.getText();
            if (value.equalsIgnoreCase(name)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY TOOLBOX PAGE" + "\nMETHOD: verifyToolBoxPage \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * method will click on edit schedule link
     * 
     * @author Praveen.Maled
     * @return UnitToolboxPage
     * @throws Exception
     */
    public UnitToolboxPage clickOnEditSchedule() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE TOOLBOX PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule);
            lnkEditSchedule.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY TOOLBOX PAGE" + "\n METHOD:clickOnEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will check if we are at unit toolbox page or not.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isToolBoxPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING TOOLBOXPAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(tabUnitToolbox, waitTime);
            strData = tabUnitToolbox.getText();
            if (strData.contains("Unit Toolbox")) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE PAGE TITLE" + "\n METHOD: isToolBoxPage \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method Will Give you the header title of the Page
     * 
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtGetHeader, waitTime);
            strData = txtGetHeader.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADING" + "\n METHOD: getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strData;
    }

    /**
     * This Method will click On EditSchedule Link.
     * 
     * @return UnitEditSchedulePage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public UnitEditSchedulePage clickEditSchedule() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON EDIT SCHEDULE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule, waitTime);
            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
            logInstruction("SWITCHED TO NEW WINDOW");

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE BUTTON" + "\n METHOD: clickEditSchedule \n" + e
                    .getLocalizedMessage());
        }
        return new UnitEditSchedulePage(uiDriver);
    }

    /**
     * This Method Will click On Edit Unit Title
     * 
     * @return UnitToolboxPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public EditTitlePage clickEditUnitTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON EDIT UNIT TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtEditUnitTitle, waitTime);
            txtEditUnitTitle.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(" UNABLE TO GET THE LINK" + "\n METHOD:clickEditUnitTitle \n" + e
                    .getLocalizedMessage());
        }
        return new EditTitlePage(uiDriver);
    }

    /**
     * This Method will click on change item order
     * 
     * @return ChangeItemOrderPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ChangeItemOrderPage clickChangeItemOrder() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CHANGE ITEM ORDER BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickChangeItemOrder, waitTime);
            btnClickChangeItemOrder.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE LINK" + "\nMETHOD: clickChangeItemOrder \n" + e
                    .getLocalizedMessage());
        }
        return new ChangeItemOrderPage(uiDriver);
    }

    /**
     * This Method Will click on Change Unit Order Link
     * 
     * @return UnitToolboxPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public ChangeItemOrderPage clickChangeUnitOrder() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CHANGE UNIT ORDER");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickChangeUnitOrder, waitTime);
            btnClickChangeUnitOrder.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE LINK" + "\n METHOD: clickChangeUnitOrder \n" + e
                    .getLocalizedMessage());
        }
        return new ChangeItemOrderPage(uiDriver);
    }

    /**
     * This Method will click on Delete unit Link.
     * 
     * @return DeleteUnitPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public DeleteUnitPage clickDeleteUnit() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE UNIT LINK");
            frameSwitch.switchToFrameContent();
            lnkDelete.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE LINK " + "\n METHOD: clickDeleteUnit \n" + e
                    .getLocalizedMessage());
        }
        return new DeleteUnitPage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to get message adjacent to Edit Schedule Link
     * @author saurabh.jain1
     * @return String
     * @throws Exception
     */
    public String getMessageNextToEditSchedule() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            strErrorMessage = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK" + "\n METHOD: getMessageNextToEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * @category Milestone 2 Method is used to verify message adjacent to Edit Schedule Link
     * @author saurabh.jain1
     * @return boolean
     * @throws Exception
     */
    public boolean isMessageDisplayedNextToEditSchedule() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY MESSAGE ADJACENT TO EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            if (lblEditSchedule.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY MESSAGE ADJACENT TO EDIT SCHEDULE LINK" + "\n METHOD:isMessageDisplayedNextToEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method helps to click on delete
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns UnitToolboxPage
     * @param String
     */
    public UnitToolboxPage clickOnDelete(String strItemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(strItemName);
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS");
            }

            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Button' \n METHOD: clickOnDelete \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method is used to click the checkbox
     * 
     * @return:UnitToolboxPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitToolboxPage clickIAgreeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkAgree.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE CHECKBOX" + "\n METHOD:clickCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click the check box
     * 
     * @return:UnitEditSchedulePage
     * @author Ganapati
     * @throws Exception
     */
    public UnitEditSchedulePage switchToNewWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHTONEWWINDOW");
            frameSwitch.switchToFrameContent();
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO NEW WINDOW" + "\n  switchToNewWindow()\n" + e
                    .getLocalizedMessage());
        }
        return new UnitEditSchedulePage(uiDriver);
    }

}
