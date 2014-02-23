package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to thread toolBox page
 * 
 * @author ganapati.bhat
 * 
 */
public class ThreadToolBoxPage extends BasePageObject {

    /* Elements */

    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//td[@width='35%']/following-sibling::td");
    private UIElement txtReorder = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr[td//label[contains(text(),'{1}')]]/td[2]/input[1]");
    private UIElements btnSaveChanges = createElements(UIType.Css, "input[value='Save Changes']");
    private UIElement chkIAgreeBox = createElement(UIType.Css, "input#isConfirmed");
    private UIElement btndeleteContentAndresponses = createElement(UIType.Css, "#deleteButtton");
    private UIElement lblToolBoxTitle = createElement(UIType.Css, ".tablehead");
    private UIElement chkSelectSetTopicReadOnly = createElement(
            UIType.ID,
            "isReadOnlyAfterScheduledDates");
    private UIElement chkSelectEditResponse = createElement(UIType.ID, "isResponsesEnabled");
    private UIElement chkSelectHideItem = createElement(UIType.ID, "isThreadHidden");
    private UIElement btnClickSaveChanges = createElement(UIType.Css, ".buttontd");
    private UIElement imgMoveContent = createElement(UIType.Css, ".toolboxitem>a>img[src*='move']");
    private UIElement lnkEditSchedule = createElement(
            UIType.Xpath,
            "//a[contains(.,'Edit Schedule')]");
    private UIElement lblpagetitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lblheader = createElement(UIType.Css, ".tablehead");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement btnDelete = createElement(UIType.LinkText, "Delete {1}");
    private UIElement selAssignTo = createElement(UIType.Css, "#GroupID");
    private UIElement chkReadOnly = createElement(UIType.Css, "#isReadOnlyAfterScheduledDates");
    private UIElement chkEditResponse = createElement(UIType.Css, "#isResponsesEnabled");
    private UIElement chkHideThread = createElement(UIType.Css, "#isThreadHidden");

    boolean flag = false;
    String strResult = null;
    
    /* Constructor */
    public ThreadToolBoxPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ThreadToolBoxPage";
        logInstruction("LOG INSTRUCTION: ## Thread Tool Box Page ##");
    }

    /**
     * Method helps to click on the delete item
     * 
     * @author ganapati.bhat
     * @param strItem
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage clickDeleteItem(String strItem) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Delete' ITEM ");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(strItem);
            btnDelete.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Delete' ITEM");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'Delete' ITEM" + "\nMETHOD:clickDeleteItem \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select the 'I Agree' check box
     * 
     * @author ganapati.bhat
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage selectIAgreeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING 'I Agree' CHECK BOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkIAgreeBox, waitTime);
            chkIAgreeBox.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'I Agree' CHECK BOX SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'I Agree' CHECK BOX" + "\nMETHOD:selectIAgreeCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on the 'Delete' content and responses button
     * 
     * @author ganapati.bhat
     * @return NextAuthorHomePage
     * @throws Exception
     */
    public NextAuthorHomePage clickDeleteContentAndResponsesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Delete Content And Responses' BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btndeleteContentAndresponses, waitTime);
            btndeleteContentAndresponses.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Delete Content And Responses' BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Content And Responses' BUTTON" + "\nMETHOD:clickDeleteContentAndResponsesButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * Method helps to verify the toolBox page table header 'Discussion Toolbox' with provided
     * String
     * 
     * @param strTableHeader
     * @author ganapati.bhat
     * @return boolean
     * @throws Exception
     */
    public boolean VerifyToolBoxTitle(String strTableHeader) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING TABLE HEADER '" + strTableHeader + "' IS DISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblToolBoxTitle, waitTime);
            if (StringUtils.isNotBlank(lblToolBoxTitle.getText().trim())) {
                if (lblToolBoxTitle.getText().trim().equalsIgnoreCase(strTableHeader)) {
                    flag = true;
                } else {
                    throw new Exception(
                            "ISSUE IN VALIDATING TABLE HEADER" + "\nMETHOD:VerifyToolBoxTitle \n");
                }
            } else {
                throw new Exception(
                        "TABLE HEADER STRING IS NULL " + "\nMETHOD:VerifyToolBoxTitle \n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING TABLE HEADER" + "\nMETHOD:VerifyToolBoxTitle \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on ReadOnlyAfterScheduledDates
     * 
     * @author hemant.kumar
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage selectReadOnlyAfterScheduledDatesCheckbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING 'Read Only After Schedule Date' CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectSetTopicReadOnly, waitTime);
            chkSelectSetTopicReadOnly.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'Read Only After Schedule Date' CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'Read Only After Schedule Date' CHECKBOX" + "\nMETHOD:selectReadOnlyAfterScheduledDatesCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to check the checkbox is selected or not
     * 
     * @author hemant.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isReadOnlyAfterScheduledDatesCheckboxSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Read Only After Schedule Date' CHECKBOX SELECTED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectSetTopicReadOnly, waitTime);
            flag = chkSelectSetTopicReadOnly.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Read Only After Schedule Date' CHECKBOX SELECTED" + "\nMETHOD:isReadOnlyAfterScheduledDatesCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on ResponsesEnabled Checkbox
     * 
     * @author hemant.kumar
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage selectResponsesEnabledCheckbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING 'Response Enabled' CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectEditResponse, waitTime);
            chkSelectEditResponse.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'Response Enabled' CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'Response Enabled' CHECKBOX" + "\nMETHOD:selectResponsesEnabledCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to to get the status of 'Response Enabled' checkbox
     * 
     * @author hemant.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isResponsesEnabledCheckboxSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Response Enabled' CHECKBOX SELECTED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectEditResponse, waitTime);
            flag = chkSelectEditResponse.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Response Enabled' CHECKBOX SELECTED" + "\nMETHOD:isResponsesEnabledCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to select on ThreadHidden CheckBox
     * 
     * @author hemant.kumar
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage selectThreadHiddenCheckbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING 'Thread Hidden' CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectHideItem, waitTime);
            chkSelectHideItem.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'Thread Hidden' CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'Thread Hidden' CHECKBOX" + "\nMETHOD:selectThreadHiddenCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to to get the status of 'Thread Hidden' checkBox
     * 
     * @author hemant.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isThreadHiddenCheckboxSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS 'Thread Hidden' CHECKBOX SELECTED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkSelectHideItem, waitTime);
            flag = chkSelectHideItem.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING IS 'Thread Hidden' CHECKBOX SELECTED" + "\nMETHOD:isThreadHiddenCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on Save Changes button
     * 
     * @author hemant.kumar
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'SaveChanges' BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnClickSaveChanges, waitTime);
            btnClickSaveChanges.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'SaveChanges' BUTTON IS CLICKED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'SaveChanges' BUTTON" + "\nMETHOD:clickSaveChangesButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will click on 'Move' link image
     * 
     * @author Praveen.Maled
     * @return ThreadMovePage
     * @throws Exception
     */
    public ThreadMovePage clickOnMove() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Move' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgMoveContent);
            imgMoveContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Move' LINK" + "\nMETHOD:clickOnMove \n" + e
                    .getLocalizedMessage());
        }
        return new ThreadMovePage(uiDriver);
    }

    /**
     * Method will click on the save changes button of reorder content items
     * 
     * @author Praveen.Maled
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage clickOnReorderSaveChanges() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Save Changes' OF REORDERING CONTENT ITEMS");
            frameSwitch.switchToFrameContent();
            List<UIElement> buttons = btnSaveChanges.getUIElementsList();
            /*
             * There are two save buttons with same parameters, we need click on the 2nd or last
             * button
             */
            buttons.get(buttons.size() - 1).clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Save Changes' OF REORDERING CONTENT ITEMS" + "\nMETHOD:clickOnReorderSaveChanges \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will enter order number for specified content item for reordering
     * 
     * @author Praveen.Maled
     * @param strContentItem
     * @param intNewOrderNumber
     * @return ThreadToolBoxPage
     * @throws Exception
     */
    public ThreadToolBoxPage enterContentItemNewOrder(String strContentItem, int intNewOrderNumber)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING CONTENT ITEM 'New Order Number'");
            txtReorder.replaceValues(strContentItem);
            uiDriver.waitToBeDisplayed(txtReorder);
            txtReorder.clearAndSendKeys(String.valueOf(intNewOrderNumber));
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING CONTENT ITEM 'New Order Number'" + "\nMETHOD:enterContentItemNewOrder \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will verify whether delete confirmation page is displayed or not, checking for check
     * box in confirmation page
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isDeleteVerificationPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Delete Confirmation' PAGE DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkIAgreeBox);
            flag = chkIAgreeBox.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'Delete Confirmation' PAGE" + "\nMETHOD:isDeleteVerificationPageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to click on Edit Schedule link
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return EditSchedulePage
     * @throws Exception
     */
    public ThreadDiscussionEditSchedulePage clickEditScheduleLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Edit Schedule' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule, waitTime);
            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Edit Schedule' LINK" + "\nMETHOD:clickEditScheduleLink \n" + e
                            .getLocalizedMessage());
        }
        return new ThreadDiscussionEditSchedulePage(uiDriver);
    }

    /**
     * Method is used to get message adjacent to Edit Schedule Link
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getMessageDisplayedNextToEditSchedule() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING MESSAGE 'Adjacent To Edit Schedule' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            strResult = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING MESSAGE 'Adjacent To Edit Schedule' LINK" + "\nMETHOD:getMessageDisplayedNextToEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method get the page title
     * 
     * @return String
     * @category Milestone2
     * @throws Exception
     * @author amit.deshmukh
     */
    public String getPageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Page Title'");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblpagetitle, waitTime);
            strResult = lblpagetitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'Page Title'" + "\nMETHOD:getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to get header title from Text Threaded page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     */

    public String getHeaderTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Header Title' FROM TEXT THREAD PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblheader, waitTime);
            strResult = lblheader.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Header Title' FROM TEXT THREAD PAGE" + "\nMETHOD:getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to click on Cancel button
     * 
     * @author amit.deshmukh
     * @return ThreadToolBoxPage
     * @category Milestone2
     * @throws Exception
     */
    public ThreadToolBoxPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Cancel' BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Cancel' BUTTON" + "\nMETHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click the checkbox
     * 
     * @return: ThreadToolBoxPage
     * @author ashish.juyal
     * @throws Exception
     */
    public ThreadToolBoxPage clickIAgreeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkIAgreeBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE CHECKBOX" + "\n clickIAgreeCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * METHOD IS USED TO SELECT ASSIGN TO
     * 
     * @category milestone 2
     * @author Pratush.Manglik
     * @param AssignTo
     * @param readOnly
     * @param editResponse
     * @param hideFromStudent
     * @return ThreadHomePage
     * @throws Exception
     */
    public ThreadHomePage selectAssignTo(
            String AssignTo,
            boolean readOnly,
            boolean editResponse,
            boolean hideFromStudent) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : SELECT ASSIGN TO");
            frameSwitch.switchToFrameContent();

            if (StringUtils.isNotBlank(AssignTo)) {

                logInstruction("LOG INSTRUCTION : SELECT ASSIGN TO");
                uiDriver.waitToBeDisplayed(selAssignTo, waitTime);
                selAssignTo.selectByVisibleText(AssignTo);
            }

            logInstruction("LOG INSTRUCTION : CLICK READ ONLY CHECKBOX");
            if (readOnly == true) {
                uiDriver.waitToBeDisplayed(chkReadOnly, waitTime);
                chkReadOnly.clickAndWait(waitTime);
            }
            logInstruction("LOG INSTRUCTION : CLICK EDIT RESPONSE CHECKBOX");
            if (editResponse == true) {
                uiDriver.waitToBeDisplayed(chkEditResponse, waitTime);
                chkEditResponse.clickAndWait(waitTime);
            }
            logInstruction("LOG INSTRUCTION : CLICK HIDE FROM STUDENT CHECKBOX");
            if (hideFromStudent == true) {
                uiDriver.waitToBeDisplayed(chkHideThread, waitTime);
                chkHideThread.clickAndWait(waitTime);
            }

            logInstruction("LOG INSTRUCTION: CLICKING ON 'SaveChanges' BUTTON");
            uiDriver.waitToBeDisplayed(btnClickSaveChanges, waitTime);
            btnClickSaveChanges.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: 'SaveChanges' BUTTON IS CLICKED");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT ASSIGN TO" + "\n METHOD : selectAssignTo \n" + e
                    .getLocalizedMessage());
        }

        return new ThreadHomePage(uiDriver);
    }
}
