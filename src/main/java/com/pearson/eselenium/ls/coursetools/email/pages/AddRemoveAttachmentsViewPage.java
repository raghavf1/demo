package com.pearson.eselenium.ls.coursetools.email.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the AddRemoveAttachmentsViewPage under Email
 * 
 * @author Vivek Singh
 * @Team Beta
 * @NavigationFrom EmailPage when Add/Remove is clicked
 */
public class AddRemoveAttachmentsViewPage extends BasePageObject {

    /* Constructor */
    public AddRemoveAttachmentsViewPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "Add Remove Attachments ViewPage";
        logInstruction("LOG INSTRUCTION: ## AddRemoveAttachmentsViewPage ##");
    }

    /* UIElements */
    private UIElement btnBrowse = createElement(UIType.Css, "#fileinput");
    private UIElement btnAttachFile = createElement(UIType.Css, "#btnAttachFile");
    private UIElement btnSaveAndAttachFile = createElement(UIType.Css, "#btnSaveAndAttachFile");
    private UIElement btnCancel = createElement(UIType.Css, "#btnCancel");
    private UIElement btnDone = createElement(UIType.Css, "#btnCancel");
    private UIElement btnDelete = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table[2]//tr[3]//table//tr[td[contains(.,'{1}')]]//td//a//img");
    private UIElements tblAttachedFiles = createElements(UIType.Css, ".tableitem");
    boolean flag = false;

    /**
     * This method is a common method for clicking buttons on AddremoveAttachmentsViewpage
     * 
     * @author Vivek.Singh
     * @param UIElement
     * @return void
     * @throws Exception
     * **/
    private void clickElement(UIElement element) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING A BUTTON ");
            uiDriver.waitToBeDisplayed(element, waitTime);

            if (getBrowser().equals(Browser.FIREFOX)) {
                element.clickByJavascript();
            } else
                element.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO 'click Button'" + "\n METHOD:clickElement \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This function is a common function that will verify whether element is displayed or not.
     * 
     * @author Vivek Singh
     * @param UIElement
     * @return boolean
     * @throws Exception
     * **/
    private boolean isElementDisplayed(UIElement element) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECK IF ELEMENT IS DISPLAYED");
            uiDriver.waitToBeDisplayed(element, waitTime);
            return element.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  CHECK IF 'Element Is Displayed'" + "\n METHOD:isElementDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the Browse button
     * 
     * @author Vivek.Singh
     * @return AddRemoveAttachmentsViewPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsViewPage clickBrowseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING BROWSE BUTTON");

            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);

            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowse.clickByJavascript();
            } else
                btnBrowse.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Browse Button'" + "\n METHOD:clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the AttachFile button
     * 
     * @author Vivek.Singh
     * @return EmailHomePage
     * @throws Exception
     * **/
    public EmailHomePage clickAttachFileButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ATTACH FILE BUTTON");
            clickElement(btnAttachFile);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Attach File Button'" + "\n METHOD:clickAttachFileButton \n" + e
                            .getLocalizedMessage());
        }

        return new EmailHomePage(uiDriver);
    }

    /**
     * This method clicks the browse button
     * 
     * @author Vivek.Singh
     * @return AddRemoveAttachmentsViewPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsViewPage clickSaveAndAttachFileButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SAVE AND ATTACH FILE BUTTON");
            clickElement(btnSaveAndAttachFile);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Save And Attach File Button'" + "\n METHOD:clickSaveAndAttachFileButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the Cancel button
     * 
     * @author Vivek.Singh
     * @return EmailHomePage
     * @throws Exception
     * **/
    public EmailHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CANCEL BUTTON");
            clickElement(btnCancel);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Cancel Button'" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new EmailHomePage(uiDriver);
    }

    /**
     * This method clicks the Done button
     * 
     * @author Vivek.Singh
     * @return EmailHomePage
     * @throws Exception
     * **/
    public EmailHomePage clickDoneButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING DONE BUTTON");
            clickElement(btnDone);
            frameSwitch.switchToParentWindow();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Done Button'" + "\n METHOD:clickDoneButton \n" + e
                            .getLocalizedMessage());
        }
        return new EmailHomePage(uiDriver);
    }

    /**
     * This method clicks the Delete button corresponding to the file chosen
     * 
     * @author Vivek.Singh
     * @param String
     *            fileName
     * @return AddRemoveAttachmentsViewPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsViewPage deleteAttachedFile(String strFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING DELETE BUTTON FOR ATTACHED FILE " + strFileName);
            btnDelete.replaceValues(strFileName);
            clickElement(btnDelete);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  'Click Delete Attached File '" + "\n METHOD:deleteAttachedFile \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method checks whether the Cancel button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonExist() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR CANCEL BUTTON");
            return isElementDisplayed(btnCancel);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  CHECK 'If Cancel Button Exists '" + "\n METHOD:isCancelButtonExist \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method checks whether the Done button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isDoneButtonExist() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR DONE BUTTON");
            return isElementDisplayed(btnDone);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  CHECK 'If Done Button Exists '" + "\n METHOD:isDoneButtonExist \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method checks whether the Attached file is listed or not. Modified by Chaitali: added
     * swithoFrame() statement Removed switch to frame since no frame unavailable
     * 
     * @author Vivek.Singh
     * @param String
     *            fileName
     * @return boolean
     * @throws Exception
     * 
     * 
     * **/
    public boolean isAttachedFileListed(String strFileName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECKING IF ATTACHED FILE IS LISTED");
            java.util.List<UIElement> listOfElementsInTable = tblAttachedFiles.getUIElementsList();
            for (UIElement element : listOfElementsInTable) {
                if (element.getText().equals(strFileName)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                logInstruction("LOG INSTRUCTION: " + strFileName + " attached");
            }
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO  CHECK 'If Attached File Is Listed  '" + "\n METHOD:isAttachedFileListed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method help to click Browse Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return AddRemoveAttachmentsViewPage
     * @throws Exception
     */
    public AddRemoveAttachmentsViewPage clickBrowseButton(String strAbsoluteFilePath)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:  CLICKING THE BROWSE BUTTON");
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.sendKeysToFileInput(strAbsoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE  TO   'click Browse Button  '" + "\n METHOD:clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
}
