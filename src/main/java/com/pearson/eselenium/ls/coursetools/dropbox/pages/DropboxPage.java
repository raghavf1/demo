package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods of Dropbox page.
 * 
 * @author Vivek.Singh
 * @team Beta
 * @navigation from clicking on GO in dropbox item under Whats New.
 * **/
public class DropboxPage extends BasePageObject {

    /* UIElements */

	private UIElement lnkClickUploadedFile = createElement(
			UIType.Xpath,
			"//tr[td[@class='threadborder']]//a//img[@title= '{1}']");
    private UIElement chkReturn = createElement(UIType.Css, "input[title*='Return {1}']");
    private UIElement chkReturnAll = createElement(UIType.Css, "#returnall");
    private UIElement btnSaveChanges = createElement(UIType.Css, "#save");
    private UIElement txtAreaPlainTextEditor = createElement(
            UIType.Xpath,
            "//a[@id='RadCourseText_simpleEditor']");
    private UIElement btnSubmitStudentAssignment = createElement(
            UIType.Css,
            "a[title='Submit Assignment']");
    private UIElement btnCancelStudentAssignment = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table:nth-of-type(3)>tbody>tr>td:nth-of-type(2)>input:nth-of-type(2)");
    private UIElements imgFileAttached = createElements(
            UIType.Xpath,
            "//a[@href[contains(.,'DownloadAttachment')]]//img");
    private UIElement btnDeleteDropboxBasket = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[3]/a/img");
    private UIElement btnDeleteDropboxItem = createElement(
            UIType.Xpath,
            "//th[a[contains(text(),'{1}')]]/following-sibling::td[3]/a/img");
    private UIElement lnkDropboxItemName = createElement(
            UIType.Xpath,
            "//tr/th/a[contains(text(),'{1}')]");
    private UIElement btnSubmitAssignment = createElement(UIType.Css, "#btnSubmitAssignmentTop");
    private UIElement lnkClickInboxItem = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnClickSaveNClose = createElement(UIType.ID, "SaveAndClose");
    private UIElement btnClickDelete = createElement(
            UIType.Css,
            "input[value='Delete Basket & All Items']");
    private UIElement lnkBasketsTab = createElement(
            UIType.Xpath,
            "//div/a[contains(text(),'Baskets')]");
    private UIElement lnkStudentsTab = createElement(
            UIType.Xpath,
            "//a[@class='contentNavigation'][text()='Students']");
    private UIElement lnkEntireInboxTab = createElement(
            UIType.Xpath,
            "//a[@class='contentNavigation'][text()='Entire Inbox']");

    private UIElement imgAttachedFile = createElement(
            UIType.Xpath,
            "//a[@href[contains(.,'DownloadAttachment')]]/img[@title='{1}']");
    private UIElement lnkDownloadAttchments = createElement(
            UIType.Css,
            "a[title='Download Attachments']");

    private UIElement lblHeaderTitle = createElement(UIType.Css, ".tablehead");

    private UIElement btnClickAttachmentLinkInOutbox = createElement(
            UIType.Xpath,
            "//table[@summary='Dropbox Items recently submitted']//tr[th[a[text()='{1}']]]//a//img[@title='{2}']");
    private UIElement txtDropBoxPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lnkBasketItem = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement btnDeleteBasket = createElement(UIType.Css, "input[value='Delete Basket']");
	private UIElement lnkBasket=createElement(UIType.LinkText, "{1}");
	private UIElement lstItem = createElement(UIType.Xpath,
			"//th[@class='tableitem']//a");
	private UIElement lnkOutbox=createElement(UIType.LinkText, "Outbox");

	/*  Variables */
    private boolean flag = false;
    private String strParent = null;
    private String strChild = null;
    private String strResult = null;
    private Set<String> strWindows = null;
    private Iterator<String> strIterator = null;
    private List<UIElement> lstUIElement = null;
    private int intTotalList = 0;
    
    /* Constructor */
    public DropboxPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## DropboxPage ##");
        pageTitle = "Dropbox";
    }

    /**
     * This method will select a particular checkbox against given student name on Dropbox Page.
     * 
     * @author Vivek.Singh
     * @param String
     *            strStudentName
     * @return {@link DropboxPage}
     * @throws Exception
     * **/
    public DropboxPage selectReturnCheckbox(String strStudentName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING RETURN CHECKBOX OF STUDENT " + strStudentName);
			frameSwitch.switchToFrameContent();
			// This will put the studentName in to the css selector of
			// chkReturn.
			if (StringUtils.isNotBlank(strStudentName)) {
				chkReturn.replaceValues(strStudentName);
				uiDriver.waitToBeDisplayed(chkReturn, waitTime);
				chkReturn.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION: SELECTED RETURN CHECKBOX OF STUDENT " + strStudentName);
			} else
				throw new Exception("STUDENT NAME IS BLANK \n METHOD: selectReturnCheckbox ");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT CHECKBOX OF STUDENT \n METHOD: selectReturnCheckbox " + strStudentName + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will select all checkbox on Dropbox Page.
     * 
     * @author Vivek.Singh
     * @return {@link DropboxPage}
     * @throws Exception
     * **/
    public DropboxPage selectReturnAllCheckbox() throws Exception {
        try {
			logInstruction("LOG INSTRUCTION: SELECTING RETURN ALL CHECKBOX.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(chkReturnAll, waitTime);
			chkReturnAll.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: SELECTED RETURN ALL CHECKBOX.");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT ALL CHECKBOX.\n METHOD: selectReturnAllCheckbox" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click Save Changes Button on Dropbox Page.
     * 
     * @author Vivek.Singh
     * @return {@link DropboxPage}
     * @throws Exception
     * **/
    public DropboxPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SAVE CHANGES BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED SAVE CHANGES BUTTON.");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES BUTTON.\n METHOD:clickSaveChangesButton " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to submit Assignment For Student
     * 
     * @author amit.deshmukh
     * @param content
     * @return {@link DropboxPage}
     * @throws Exception
     */

    public DropboxPage submitStudentAssignment() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SUBMIT STUDENT ASSIGNMENT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitStudentAssignment, waitTime);
            btnSubmitStudentAssignment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SUBMIT STUDENT ASSIGNMENT \n METHOD: submitStudentAssignment" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to click Cancel Assignment For Student
     * 
     * @author amit.deshmukh
     * @param content
     * @return {@link DropboxPage}
     * @throws Exception
     */

    public DropboxPage cancelStudentAssignment() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CANCEL STUDENT ASSIGNMENT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitStudentAssignment, waitTime);
            btnCancelStudentAssignment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CANCEL STUDENT ASSIGNMENT \n METHOD: cancelStudentAssignment" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method checks if file is attached or not
     * 
     * @return boolean
     * @author chaitali
     * @throws Exception
     */
    public boolean isFileAttachedDisplayed(String strNameOfFile) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION: CHECKING SELECTED FILE ATTACHED OR NOT");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strNameOfFile)) {
                lstUIElement = imgFileAttached.getUIElementsList();
                intTotalList = lstUIElement.size();
                for (int i = 0; i < intTotalList; i++) {
                    if (lstUIElement.get(i).getAttribute("title").equals(strNameOfFile)) {
                        flag = true;
                        break;
                    }
                    uiDriver.sleep(1000, "Unable to get filename in IE.");
                }
            } else {
                logInstruction("LOG INSTRUCTION: FILE NAME BLANK");
                flag = false;
            }
        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("NOT ABLE TO FIND ATTACHED FILE \n METHOD:isFileAttachedDisplayed");
        }
        return flag;
    }

    /**
     * Methods helps to click on submit assignment link
     * 
     * @author Chaitali
     * @return DropboxPage
     * @throws Exception
     */

    public AssignmentPage clickSubmitAssignmentLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING SUBMIT ASSIGNMENT LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitStudentAssignment, waitTime);
            if(getBrowser().equals(Browser.INTERNETEXPLORER))
            	btnSubmitStudentAssignment.clickByJavascript();
            else
            btnSubmitStudentAssignment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO CLICK ON SUBMIT ASSIGNMENT LINK \n METHOD:clickSubmitAssignmentLink" + e
                            .getLocalizedMessage());
        }
        return new AssignmentPage(uiDriver);

    }

    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Methods helps to delete a dropbox basket
     * 
     * @author Raghavendra
     * @return dropbox
     * @throws Exception
     */
    public DropboxPage clickDeleteDropboxBasket(String strDropboxBasketName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: DELETING DROPBOX BASKEt");
            frameSwitch.switchToFrameContent();
            if(StringUtils.isNotBlank(strDropboxBasketName)){
            btnDeleteDropboxBasket.replaceValues(strDropboxBasketName);
            uiDriver.waitToBeDisplayed(btnDeleteDropboxBasket, waitTime);
            btnDeleteDropboxBasket.clickAndWait(waitTime);
            }else
                throw new Exception(
                        "DROPBOX BASKET NAME IS EMPTY \n METHOD:clickDeleteDropboxBasket");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DELETE DROPBOX BASKET \n METHOD:clickDeleteDropboxBasket" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to delete a dropbox item
     * 
     * @author Raghavendra
     * @return void
     * @throws Exception
     */
    public void deleteDropboxItem(String strDropBoxItem) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: DELETING DROPBOX ITEM");
            frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strDropBoxItem)) {
				btnDeleteDropboxItem.replaceValues(strDropBoxItem);
				uiDriver.waitToBeDisplayed(btnDeleteDropboxItem, waitTime);
				btnDeleteDropboxItem.clickAndWait(waitTime);
			} else
				throw new Exception("DROPBOX ITEM IS EMPTY \n METHOD:deleteDropboxItem");
        } catch (Exception e) {
            throw new Exception("UNABLE TO DELETE DROPBOX ITEM \n METHOD:deleteDropboxItem" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to delete a dropbox item
     * 
     * @author Raghavendra
     * @return void
     * @throws Exception
     */
    public DropboxPage clickDropboxItem(String strDropBoxItem) throws Exception {
        try {
			logInstruction("LOG INSTRUCTION: CLICKING DROPBOX ITEM");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strDropBoxItem)) {
				lnkDropboxItemName.replaceValues(strDropBoxItem);
				uiDriver.waitToBeDisplayed(lnkDropboxItemName, waitTime);
				lnkDropboxItemName.clickAndWait(waitTime);
			} else
				throw new Exception("DROPBOX ITEM IS BLANK \n METHOD:clickDropboxItem");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK DROPBOX ITEM \n METHOD:clickDropboxItem" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to delete a dropbox item
     * 
     * @author Raghavendra
     * @return void
     * @throws Exception
     */
    public boolean isDropboxItemPresent(String strDropBoxItem) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERFYING DROPBOX ITEM");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strDropBoxItem)) {
				lnkDropboxItemName.replaceValues(strDropBoxItem);
                flag = lnkDropboxItemName.isDisplayedAfterWaiting(waitTime);
			} else
				throw new Exception("DROPBOX ITEM IS BLANK");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK DROPBOX ITEM \n METHOD:isDropboxItemPresent" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods helps to submit Assignment For Student
     * 
     * @author amit.deshmukh
     * @param content
     * @return {@link DropboxPage}
     * @throws Exception
     */

    public DropboxPage clickSubmitAssignment() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SUBMIT ASSIGNMENT BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSubmitAssignment, waitTime);
            btnSubmitAssignment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK SUBMIT ASSIGNMENT BUTTON \n METHOD: clickSubmitAssignment" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to submit an assignment
     * 
     * @author kiran kumar
     * @return
     * @throws Exception
     */

    public DropboxPage clickSubmitAssgnment() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SUBMIT ASSIGNMENT");
            frameSwitch.switchToFrameContent();
            btnSubmitAssignment.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SUBMIT ASSIGNMENT \n METHOD:clickSubmitAssgnment");
        }
        return this;
    }

    /**
     * Methods helps to click inbox button and reply
     * 
     * @author kiran kumar
     * @return
     * @throws Exception
     */

    public DropboxPage clickInboxItemAndReply(String strRadcontents, String strStudName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: REPLYING TO THE ASSIGNMENT");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strRadcontents) && StringUtils.isNotBlank(strStudName)) {
                lnkClickInboxItem.replaceValues(strStudName);
            uiDriver.waitToBeDisplayed(lnkClickInboxItem, waitTime);
            lnkClickInboxItem.clickAndWait(waitTime);
                strWindows = uiDriver.getWindowHandles();
                strIterator = strWindows.iterator();
                strParent = strIterator.next();
                strChild = strIterator.next();
                uiDriver.switchTo().window(strChild);
            frameSwitch.switchToNewWindowBottomFrame();

            // visualEditor.clickRadEditorIcon(
            // VisualEditorElementsEnum.MOVE_FOCUS_TO_TEXT_EDITOR,
            // tableid);
                uiDriver.sendKeysToBrowser(strRadcontents);
            uiDriver.switchTo().defaultContent();
            frameSwitch.switchToNewWindowBottomFrame();
            btnClickSaveNClose.clickAndWait(waitTime);
                uiDriver.switchTo().window(strParent);
            }else
            	throw new Exception("RAD CONTENTS OR STUDENT NAME IS BLANK");
        } catch (Exception e) {
            throw new Exception("UNABLE TO REPLY \n METHOD:clickInboxItemAndReply" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to click delete without assignment
     * 
     * @param String
     *            - dropboxBasketName
     * @author kiran kumar
     * @return DropboxPage
     * @throws Exception
     */
    public DropboxPage clickDeleteDropbox(String strDropboxBasketName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: DELETING DROPBOX BASKET");
            frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strDropboxBasketName)) {
				btnDeleteDropboxBasket.replaceValues(strDropboxBasketName);
				uiDriver.waitToBeDisplayed(btnDeleteDropboxBasket, waitTime);
				btnDeleteDropboxBasket.clickAndWait(waitTime);
				uiDriver.waitToBeDisplayed(btnClickDelete, waitTime);
				btnClickDelete.clickAndWait(waitTime);
			} else
            	throw new Exception("DROPBOX BASKET NAME IS BLANK");
        } catch (Exception e) {
            throw new Exception("UNABLE TO DELETE DROPBOX BASKET \n METHOD:clickDeleteDropbox" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to select Baskets tab
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return DropboxPage
     * @throws Exception
     */
    public BasketHomePage selectBasketsTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON BASKETS TAB");
            frameSwitch.switchToFrameContent();
            if (lnkBasketsTab.isDisplayedAfterWaiting(waitTime)) {
                lnkBasketsTab.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON BASKETS TAB");
            } else
                logInstruction("LOG INSTRUCTION:BASKETS TAB NOT DISPLEYED...");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BASKETS TAB \n METHOD:selectBasketsTab" + e
                    .getLocalizedMessage());
        }
        return new BasketHomePage(uiDriver);
    }

    /**
     * Methods helps to select Students tab
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return DropboxPage
     * @throws Exception
     */
    public DropboxPage selectStudentsTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON STUDENT TAB");
            frameSwitch.switchToFrameContent();
            if (lnkStudentsTab.isDisplayedAfterWaiting(waitTime)) {
                lnkStudentsTab.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON STUDENTS TAB");
            } else
                logInstruction("LOG INSTRUCTION:STUDENTS TAB NOT DISPLAYED...");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON STUDENTS TAB \n METHOD:selectStudentsTab" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to select Entire Inbox tab
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return DropboxPage
     * @throws Exception
     */
    public DropboxPage selectEntireInboxTab() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON ENTIRE INBOX TAB");
            frameSwitch.switchToFrameContent();
            if (lnkEntireInboxTab.isDisplayedAfterWaiting(waitTime)) {
                lnkEntireInboxTab.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON ENTIRE INBOX TAB");
            } else
                logInstruction("LOG INSTRUCTION:ENTIRE INBOX TAB NOT DISPLAYED...");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ENTIRE INBOX TAB \n METHOD:selectEntireInboxTab" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to click on upload file link
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @param studentname
     * @return void
     * @throws Exception
     */
    public void clickOnUploadedFile(String strStudName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON UPLOADED FILE");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strStudName)) {
                lnkClickUploadedFile.replaceValues(strStudName);
                if (lnkClickUploadedFile.isDisplayedAfterWaiting(waitTime)) {
                	 if (getBrowser().equals(Browser.INTERNETEXPLORER)){
                		 lnkClickUploadedFile.clickByJavascript();
                	 }else
                    lnkClickUploadedFile.clickAndWait(waitTime);
                    logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON UPLOADED FILE");
                } else
                    logInstruction("LOG INSTRUCTION:UPLOADED FILE NOT DISPLAYED...");
            } else {
                logInstruction("LOG INSTRUCTION:STUDENT NAME IS BLANK");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON UPLOADED FILE \n METHOD:clickOnUploadedFile" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to click on download Attachments
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return void
     * @throws Exception
     */
    public void clickOnDownloadAttachments() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON DOWNLOAD ATTACHMENTS");
            frameSwitch.switchToFrameContent();
            if (lnkDownloadAttchments.isDisplayedAfterWaiting(waitTime)) {
                lnkDownloadAttchments.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON DOWNLOAD ATTACHEMENTS");
            } else
                logInstruction("LOG INSTRUCTION:DOWNLOAD ATTCHMENTS LINK NOT DISPLAYED..");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON DOWNLOAD ATTACHMENTS \n METHOD:clickOnDownloadAttachments" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to get header title of submit students assignment page
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:GETTING SUBMIT ASSIGNMENT PAGE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            if (lblHeaderTitle.isDisplayedAfterWaiting(waitTime))
                strResult = lblHeaderTitle.getText().trim();
            else
                logInstruction("LOG INSTRUCTION:SUBMIT ASSIGNMENTS PAGE TITLE NOT DISPLAYED");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DISPLAY SUBMIT ASSIGNMENT PAGE HEADER TITLE \n METHOD:getHeaderTitle" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to click attachments link displayed in outbox
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @param String
     *            basketName and attachedFileName
     * @return void
     * @throws Exception
     */
    public void clickAttachmentLinkInOutbox(String strBasketName, String strAttachedFileName)
            throws Exception {
        try {

            logInstruction("LOG INSTRUCTION:CLICKING ON ATTACHMENTS LINK IN OUTBOX TAB");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strBasketName) && StringUtils
                    .isNotBlank(strAttachedFileName)) {
                btnClickAttachmentLinkInOutbox.replaceValues(strBasketName, strAttachedFileName);
                if (btnClickAttachmentLinkInOutbox.isDisplayedAfterWaiting(waitTime))
                    btnClickAttachmentLinkInOutbox.clickAndWait(waitTime);
                else
                    logInstruction("LOG INSTRUCTION:ATTACHMENTS LINK IN OUTBOX NOT FOUND");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ATTCHMENTS LINK IN OUTBOX \n METHOD:clickAttachmentLinkInOutbox" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method check DropBox page is displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isDropBoxPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR DROPBOX PAGE DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            if ("Dropbox".equalsIgnoreCase(txtDropBoxPageTitle.getText())) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "NOT ABLE TO VERIFY SUBMIT ASSIGNMENT PAGE \n METHOD: isDropBoxPageDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method return text of DropBox Page Title.
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getDropBoxPageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : Getting the text of DropBox Page");
            frameSwitch.switchToFrameContent();
            strResult = txtDropBoxPageTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "NOT ABLE TO GET TEXT OF DROPBOX PAGE \n METHOD:getDropBoxPageTitle");
        }
        return strResult;
    }

    /**
     * This Method will select Basket Item
     * 
     * @param name
     * @return {@link DropBoxPOPUPPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public DropBoxPOPUPPage selectBasketItem(String strName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : SELECTING DROPBOX ITEM");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strName)) {
                lnkBasketItem.replaceValues(strName);
            uiDriver.waitToBeDisplayed(lnkBasketItem, waitTime);
	            lnkBasketItem.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
            }else
            	throw new Exception("BASKET ITEM NAME IS BLANK");

        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT THE ITEM \n METHOD :selectBasketItem ");
        }
        return new DropBoxPOPUPPage(uiDriver);
    }

    /**
	 * This method checks whether whether the simple editor is displayed or not
	 * @author ashish.juyal
	 * @return:boolean
	 * @throws Exception 
	 * 
	 */
	
    public boolean isSimpleEditorNotDisplayed() throws Exception {
        flag = false;
		try{
			logInstruction("checking for the plain text editor");
			frameSwitch.switchToFrameContent();
			flag=txtAreaPlainTextEditor.isAbsent();
		}catch(Exception e){
            throw new Exception("cannot execute the simpleeditor displayed method" + e
                    .getLocalizedMessage());
	}
	return flag;
    }
	/**
	 * This method will click on basket item and redirect you to same page for nummeric grade entry
	 * @param itemname
	 * @return {@link DropboxPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
    public BasketHomePage clickBasketItem(String strItemname) throws Exception {
		try {
			logInstruction("LOG INSTRCUTION: CLICKING ON BASKET ITEM");
			frameSwitch.switchToFrameContent();
            lnkBasket.replaceValues(strItemname);
			uiDriver.waitToBeDisplayed(lnkBasket,waitTime);
			lnkBasket.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON ITEM \n METHOD:clickBasketItem ");
		}
		return new BasketHomePage(uiDriver);
	}
	
	/**
	 * This Method will click on Student Tab
	 * @return {@link DropboxPage}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public StudentBasketHomePage clickStudentTab() throws Exception{
		try {
			logInstruction("LOG INSTRCUTION: CLICKING ON STUDENT TAB");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkStudentsTab, waitTime);
			lnkStudentsTab.clickAndWait(waitTime);
			
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON STUDENT TAB \n METHOD: clickStudentTab");
		}
		return new StudentBasketHomePage(uiDriver);
	}
	
    


    /**
     * Methods helps to click on delete * Category Milestone 2
     * 
     * @param String
     *            - dropboxBasketName
     * @author Raghav
     * @return DropboxPage
     * @throws Exception
     */
    public DropboxPage clickDeleteWithOutAssignment() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDeleteBasket, waitTime);
            btnDeleteBasket.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DELETE DROPBOX BASKET \n METHOD:clickDeleteWithOutAssignment" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on files attached in outbox or inbox view of Student login.
     * 
     * @author Vivek.Singh
     * @param String
     * @return {@link BasketHomePage}
     * @throws Exception
     * **/
    public DropboxPage clickOnFile(String strFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SELECTED FILE TO DOWNLOAD.");
            frameSwitch.switchToFrameContent();
            if(StringUtils.isNotBlank(strFileName)){
            imgAttachedFile.replaceValues(strFileName);
            uiDriver.waitToBeDisplayed(imgAttachedFile, waitTime);
                if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                imgAttachedFile.clickByJavascript();
            } else
                imgAttachedFile.clickAndWait(waitTime);
            }else
            	throw new Exception("FILE NAME IS BLANK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON FILE: " + strFileName + ".\nMETHOD: clickOnFile()\n." + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
    /**
	 * Methods helps to check items in dropbox
	 * 
	 * @author bharat.goel
	 * @return DropboxPage
	 * @throws Exception
	 */
	public boolean isItemsDisplayedInBasket() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: C HECKING ITEMS IN DROPBOX");
			frameSwitch.switchToFrameContent();
			flag = lstItem.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION:UNABLE CHECK ITEMS IN DROPBOX \n METHOD:isItemsDisplayedInBasket"
							+ e.getLocalizedMessage());
		}
		return flag;

	}

	/**
	 * Methods clicks on Outbox
	 * 
	 * @author Shishir
	 * @return DropboxPage
	 * @throws Exception
	 */
	public DropboxPage clickOnOutbox() throws Exception{
    	try {
    		logInstruction("LOG INSTRCUTION: CLICKING ON OUT BOX");
    		frameSwitch.switchToFrameContent();
    		uiDriver.waitToBeDisplayed(lnkOutbox, waitTime);
    		lnkOutbox.clickAndWait(waitTime);
			
		} catch (Exception e) {
			logInstruction("LOG INSTRCUTION: NOT ABLE TO CLICK ON OUTBOX LINK \n METHOD: clickOnOutbox");
		}
    	return this;
    }
}
