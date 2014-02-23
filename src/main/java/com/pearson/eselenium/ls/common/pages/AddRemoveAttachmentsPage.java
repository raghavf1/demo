package com.pearson.eselenium.ls.common.pages;

import java.io.File;
import java.util.List;

import com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages.AddTopicPage;
import com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages.ThreadRespondPage;
import com.pearson.eselenium.ls.coursetools.dropbox.pages.AssignmentPage;
import com.pearson.eselenium.ls.coursetools.dropbox.pages.DropboxInboxPage;
import com.pearson.eselenium.ls.coursetools.email.pages.EmailHomePage;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.eselenium.utils.FileIOUtils;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class has methods to add and remove attachments
 *
 * @author Vivek.Singh
 */
public class AddRemoveAttachmentsPage extends BasePageObject {

    /* UIElements */
    private UIElement btnBrowse = createElement(UIType.Xpath, "//input[@id='fileinput']");
    private UIElement btnAttachFile = createElement(UIType.Xpath, "//input[@value='Attach File']");
    private UIElement btnSaveAndAttachFile = createElement(
            UIType.Xpath,
            "//input[@value='Save & Attach Another File']");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[@value='Cancel']");
    private UIElement btnDone = createElement(UIType.Css, "#btnCancel");
    private UIElement btnDelete = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table[2]//tr[3]//table//tr[td[contains(.,'{1}')]]//td//a//img");
    private UIElement lblTableHead = createElement(UIType.Css, ".tablehead");
    private UIElement lblFirstRowData = createElement(
            UIType.Xpath,
            "//table[@style[contains(.,'BORDER')]]//tr[2]/td[1]");
    private UIElement lblCompleteName = createElement(UIType.Xpath, "//td[text()='{1}']");
    private UIElement lblLastRowData = createElement(
            UIType.Xpath,
            "//tr[last()]/td[1][@class='tableitem']");
    private UIElement tblAttachment = createElement(UIType.Css, "table[style*='BORDER']");
    private UIElement lblAttachFileTo = createElement(UIType.Css, "label");
    private UIElements tblAttachedFiles = createElements(UIType.Css, ".tableitem");
    private UIElements tblTitleCount = createElements(UIType.Css, ".tableheading");
    private UIElements tblAttachmentRows = createElements(
            UIType.Xpath,
            "//table[@style[contains(.,'BORDER')]]//tr[1]");
    private UIElement lblattachstudent = createElement(
            UIType.Xpath,
            "//tr[th[contains(text(),'{1}')]]/td/a/img");

    private UIElements lstAttachedFiles = createElements(
            UIType.Xpath,
            "//tr//td[@class='tableitem'][1]");
    
    /* Variables */
    private static final String DROPBOX_INBOX_PAGE = "DropboxInboxPage";
    private static final String EMAIL_HOME_PAGE = "EmailHomePage";
    private static final String THREAD_RESPOND_PAGE = "ThreadRespondPage";
    private static final String ASSIGNMENT_PAGE = "AssignmentPage";
    private static final String ADD_TOPIC_PAGE = "AddTopicPage";
    private static final String IE = "Internetexplorer";
    private Object obj;
    private String browser = "";
    public String strAlertMsg = "";
    private String strFileName = "";
    private boolean isFileAttached = false;
    private boolean isPresent = false;
    private String msg = "";
    private int count = 0;

    /* JavascriptExecutor Elements */
    private static final String btnCancel_JS = "('btnCancel')";
    private static final String btnSaveAndAttach_JS = "('btnSaveAndAttachFile')";
    private static final String tblTable1_JS = "('table')[1]";
    private static final String btnAttachFile_JS = "('btnAttachFile')";
    private static final String btnBrowse_JS = "('fileinput')";
    private static final String lblLabel_JS = "('label')[0]";
    private static final String tbltd_JS = "('td')[5]";
    private static final String lblHeader_JS = "('tablehead')[0]";
    private static final String msgError_JS = "('td')[6]";
    private static final String tbltable2_JS = "('table')[5]";
    private static final String tbltable3_JS = "('table')[6]";

    /* Constructor */
    public AddRemoveAttachmentsPage(UIDriver driver, Object obj) throws Exception{
        super(driver);
        this.obj = obj;
        pageTitle = "AddRemoveAttachmentsPage";
        try {
            objectIdentification();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CONSTRUCTOR OF ADD REMOVE ATTACHMENTS PAGE. \n" + e.getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: ## AddRemoveAttachmentsPage ##");
    }

    /**
     * This method is a common method for clicking buttons on AddremoveAttachmentsViewpage
     * 
     * @author Vivek.Singh
     * @param UIElement
     * @return void
     * @throws Exception
     * @modifiedBy Sumanth.SV -- Since clickAndWait() is hanging, performing the same
     * **/
    private void clickElement(UIElement element) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ELEMENT CLICKING");
            uiDriver.waitToBeDisplayed(element, waitTime);
            browser = System.getProperty("browser.NAME");
            if (!(browser.equalsIgnoreCase(IE))) {
                element.clickAndWait(waitTime);
            } else {
                element.clickByJavascript();
                uiDriver.sleep(waitTime);
            }
            logInstruction("LOG INSTRUCTION: ELEMENT CLICKED");
        } catch (Exception e) {
            throw new Exception("FAILED TO CLICK BUTTON. \nMETHOD: clickElement \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'Browse' button
     * 
     * @author Vivek.Singh
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsPage clickBrowseButton() throws Exception {
        try {
            logInstruction(" LOG INSTRUCTION: CLICKING 'Browse' BUTTON.");
            clickElement(btnBrowse);
            logInstruction(" LOG INSTRUCTION: 'Browse' BUTTON CLICKED.");
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK 'Browse' BUTTON. \nMETHOD: clickBrowseButton(). " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the 'Attach File' button. Navigates to the object attached by the calling
     * method of this page. Object is identified by objectIdentification() method.
     * 
     * @author Vivek.Singh
     * @return Object
     * @throws Exception
     * **/
    public Object clickAttachFileButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Attach File' BUTTON");
            clickElement(btnAttachFile);
            if (!(DROPBOX_INBOX_PAGE.equalsIgnoreCase(obj.getClass().getSimpleName())))
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            logInstruction("LOG INSTRUCTION: 'Attach File' BUTTON CLICKED.");
            return obj;
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK 'Attach File'. \nMETHOD: clickAttachFileButton(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Clicking on Attach File Button.
     * 
     * @author Chaitali.Barhate
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     */
    public AddRemoveAttachmentsPage clickInvalidAttachFileButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Attach File' BUTTON");
            clickElement(btnAttachFile);
            logInstruction("LOG INSTRUCTION: 'Attach File' BUTTON CLICKED.");
            browser = System.getProperty("browser.NAME");
            if (browser.equalsIgnoreCase(IE)) {
                strAlertMsg = getErrorMessage();
            } else
                if (browser.equalsIgnoreCase("CHROME")) {
                    strAlertMsg = uiDriver.getUIAlert().getAlertMessage();
                    uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
                }
            return this;
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK 'Attach File'. \nMETHOD: clickInvalidAttachFileButton(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'Save And Attach File' button.
     * 
     * @author Vivek.Singh
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsPage clickSaveAndAttachFileButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Save And Attach File' BUTTON");
            clickElement(btnSaveAndAttachFile);
            logInstruction("LOG INSTRUCTION: 'Save And Attach File' BUTTON CLICKED.");
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK 'Save And Attach File'. \nMETHOD: clickSaveAndAttachFileButton(). " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the 'Cancel' button. Navigates to the object attached by the calling
     * method of this page. Object is identified by objectIdentification() method.
     * 
     * @author Vivek.Singh
     * @return Object
     * @throws Exception
     * **/
    public Object clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Cancel' BUTTON");
            clickElement(btnCancel);
            if (!(DROPBOX_INBOX_PAGE.equalsIgnoreCase(obj.getClass().getSimpleName())))
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            logInstruction("LOG INSTRUCTION: 'Cancel' BUTTON CLICKED.");
            return obj;
        } catch (Exception e) {
            throw new Exception("FAILED TO CLICK 'Cancel'. \nMETHOD: clickCancelButton(). " + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'Done' button. Navigates to the object attached by the calling method
     * of this page. Object is identified by objectIdentification() method.
     * 
     * @author Vivek.Singh
     * @return Object
     * @throws Exception
     * **/
    public Object clickDoneButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Done' BUTTON");
            clickElement(btnDone);
            if (!(DROPBOX_INBOX_PAGE.equalsIgnoreCase(obj.getClass().getSimpleName())))
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            logInstruction("LOG INSTRUCTION: 'Done' BUTTON CLICKED.");
            return obj;
        } catch (Exception e) {
            throw new Exception("FAILED TO CLICK 'Done'. \nMETHOD: clickDoneButton(). " + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'Delete' button corresponding to the file chosen.
     * 
     * @author Vivek.Singh
     * @param String
     *            fileName
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsPage deleteAttachedFile(String fileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING DELETE BUTTON FOR FILE " + fileName);
            btnDelete.replaceValues(fileName);
            clickElement(btnDelete);
            logInstruction("LOG INSTRUCTION: DELETE BUTTON CLICKED.");
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK DELETE FOR: " + fileName + ". \nMETHOD: deleteAttachedFile()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method checks whether the 'Cancel' button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonExist() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Cancel' BUTTON");
            return btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Cancel' BUTTON IS NOT DISPLAYED. \nMETHOD: isCancelButtonExist(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method checks whether the 'Done' button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isDoneButtonExist() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Done' BUTTON");
            return btnDone.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("'Done' BUTTON IS NOT DISPLAYED. \nMETHOD: isDoneButtonExist().");
        }
    }

    /**
     * This method checks whether the attached file is listed or not.
     * 
     * @author Vivek.Singh
     * @param String
     *            fileName
     * @return boolean
     * @throws Exception
     * 
     * 
     * **/
    public boolean isAttachedFileListed(String fileName) throws Exception {
        isFileAttached = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR NEWLY ATTACHED FILE: " + fileName);
            if (tblAttachedFiles.areAllPresent()) {
                java.util.List<UIElement> listOfElementsInTable = tblAttachedFiles
                        .getUIElementsList();
                for (UIElement element : listOfElementsInTable) {
                    if (element.getText().equals(fileName)) {
                        isFileAttached = true;
                        break;
                    }
                }
            }
            return isFileAttached;
        } catch (Exception e) {
            throw new Exception(
                    "FILE NOT ATTACHED: " + fileName + ". \nMETHOD: isAttachedFileListed(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether Attachment table not present below File To Attach, Browse
     * button row.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachmentsTablePresentBelowRowOfItems() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING 'Attachment Table' PRESENCE BELOW 'File to attach' LABEL AND 'Browse' BUTTON.");
            int itemsRowBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tbltable2_JS + ".getBoundingClientRect().bottom")));
            int attachmentTableTop = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tbltable3_JS + ".getBoundingClientRect().top")));
            if (itemsRowBottom <= attachmentTableTop) {
                isPresent = true;
            }
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "'Attachment Table' NOT PRESENT BELOW 'File to attach' LABEL AND 'Browse' BUTTON ROW. \nMETHOD: isAttachmentsTablePresentBelowRowOfItems(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get Attachments table title count. Title count is the Column names present.
     * 
     * @author Vivek.Singh
     * @return int
     * @throws Exception
     * **/
    public int getAttachmentTableTitleCount() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING ATTACHEMENT TABLE TITLE. ");
            List<UIElement> tblTitle = tblTitleCount.getUIElementsList();
            return tblTitle.size();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET COUNT OF ATTACHMENT TABLE COLUMNS. \nMETHOD: getAttachmentTableTitleCount(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get Attachments table columns title i.e. "Attached Files" and "Remove".
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getAttachmentTableColumnsTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING ATTACHEMENT TABLE TITLE. ");
            List<UIElement> tblTitle = tblTitleCount.getUIElementsList();
            String tblTitles = "";
            for (UIElement uiElement : tblTitle) {
                uiElement.isDisplayedAfterWaiting(waitTime);
                tblTitles += uiElement.getText();
            }
            return tblTitles;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET COUNT OF ATTACHMENT TABLE COLUMNS. \nMETHOD: getAttachmentTableColumnsTitle(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will chcek whether Attachment title is to the left of table or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachmentTitleToTheLeftOfTable() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING ATTACHEMENT TABLE TITLE FOR ATTACHMENT. ");
            List<UIElement> tblColumnList = tblAttachmentRows.getUIElementsList();
            tblColumnList.get(0).isDisplayedAfterWaiting(waitTime);
            return tblColumnList.get(0).getText().split(" ")[0].equalsIgnoreCase("Attachment");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY WHETHER ATTACHMENT COLUMNS IS LEFT OR RIGHT. \nMETHOD: isAttachmentTitleToTheLeftOfTable()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will chcek whether Remove title is to the left of table or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isRemoveTitleToTheRightOfTable() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: checking attachement table title for Remove. ");
            List<UIElement> tblColumnList = tblAttachmentRows.getUIElementsList();
            tblColumnList.get(1).isDisplayedAfterWaiting(waitTime);
            return tblColumnList.get(0).getText().split(" ")[1].equalsIgnoreCase("Remove");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY WHETHER ATTACHMENT COLUMNS IS LEFT OR RIGHT. \nMETHOD: isRemoveTitleToTheRightOfTable(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get 'Attachment' column heading.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getAttachmentColumnHeading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Attachment' TABLE TITLE. ");
            List<UIElement> tblColumnList = tblAttachmentRows.getUIElementsList();
            tblColumnList.get(0).isDisplayedAfterWaiting(waitTime);
            return tblColumnList.get(0).getText().split(" ")[0];
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET HEADING OF 'Attachment' TABLE COLUMN. \nMETHOD: getAttachmentColumnHeading(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get 'Remove' column heading.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getRemoveColumnHeading() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Remove' TABLE TITLE. ");
            List<UIElement> tblColumnList = tblAttachmentRows.getUIElementsList();
            tblColumnList.get(1).isDisplayedAfterWaiting(waitTime);
            return tblColumnList.get(0).getText().split(" ")[1];
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET HEADING OF 'Remove' TABLE COLUMN. \nMETHOD: getRemoveColumnHeading().  " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether attached file is in the first row or not.
     * 
     * @author Vivek.Singh
     * @param String attachedFileName
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachedFileInFirstRow(String attachedFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ATTACHED FILE: " + attachedFileName + " IS IN FIRST ROW OR NOT.");
            lblFirstRowData.isDisplayedAfterWaiting(waitTime);
            return lblFirstRowData.getText().equalsIgnoreCase(attachedFileName);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE ATTACHED FILE: " + attachedFileName + ". \nMETHOD: isAttachedFileInFirstRow(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will chcek attached file is in last row or not.
     * 
     * @author Vivek.Singh
     * @param String attachedFileName
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachedFileInLastRow(String attachedFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ATTACHED FILE: " + attachedFileName + " IS IN LAST ROW OR NOT.");
            lblLastRowData.isDisplayedAfterWaiting(waitTime);
            return lblLastRowData.getText().equalsIgnoreCase(attachedFileName);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE ATTACHED FILE: " + attachedFileName + ". \nMETHOD: isAttachedFileInLastRow(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will return the complete name of the file attached.
     * 
     * @author Vivek.Singh
     * @param String
     * @return String
     * @throws Exception
     * **/
    public String getAttachedFileFormat(String fileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING COMPLETE NAME OF ATTACHED FILE.");
            lblCompleteName.replaceValues(fileName);
            lblCompleteName.isDisplayedAfterWaiting(waitTime);
            return lblCompleteName.getText();
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE ATTACHED FILE. \nMETHOD: getAttachedFileFormat(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether delete icon exists for attached file name. Provide the
     * filename needed to be deleted or checked for delete option.
     * 
     * @author Vivek.Singh
     * @param String attachedFileName
     * @return boolean
     * @throws Exception
     * **/
    public boolean isDeleteIconExist(String attachedFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Delete' BUTTON PRESENT NEXT TO FILE: " + attachedFileName);
            btnDelete.replaceValues(attachedFileName);
            return btnDelete.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Delete' BUTTON NOT PRESENT AGAINST " + attachedFileName + ".\nMETHOD: isDeleteIconExist(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get any error message on the page.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getErrorMessage() throws Exception {        
        try {
            logInstruction("LOG INSTRUCTION: GETTING ERROR MESSAGE. ");
            if (IE.equalsIgnoreCase(System.getProperty("browser.NAME"))) {
                msg = uiDriver
                        .executeScript("return document.getElementsByTagName" + msgError_JS + ".innerText");
            } else
                msg = uiDriver
                        .executeScript("return document.getElementsByTagName" + msgError_JS + ".textContent");
            msg = msg.replaceAll("“", "\"");
            msg = msg.replaceAll("”", "\"");
            return msg;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET INLINE ERROR MESSAGE. \nMETHOD: getErrorMessage(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get instructional text.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getInstructionalText() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Instructional Message'. ");
            if (IE.equalsIgnoreCase(System.getProperty("browser.NAME")))
                return (uiDriver
                        .executeScript("return document.getElementsByTagName" + tbltd_JS + ".innerText"))
                        .trim();
            else
                return (uiDriver
                        .executeScript("return document.getElementsByTagName" + tbltd_JS + ".textContent"))
                        .trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Instructional Message'. \nMETHOD: getInstructionalText(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check 'Instructional text' is below header or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isInstructionalTextBelowHeader() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Instructional message' BELOW PAGE HEADER. ");
            int headerBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + lblHeader_JS + ".getBoundingClientRect().bottom")));
            int instructTop = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tbltd_JS + ".getBoundingClientRect().top")));
            if (headerBottom < instructTop)
                isPresent = true;
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Instructional message' BELOW PAGE HEADER. \nMETHOD: isInstructionalTextBelowHeader()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get 'File to Attach' label.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getFileToAttachLabel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING LABEL TEXT. ");
            lblAttachFileTo.isDisplayedAfterWaiting(waitTime);
            return lblAttachFileTo.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LABEL: 'File to Attach'.\nMETHOD: getFileToAttachLabel()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get check whether File to Attach label is below intructional text.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isFileToAttachLabelBelowInstructionalText() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Instructional message' ABOVE 'File to attach' LABEL. ");
            int instructBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tbltd_JS + ".getBoundingClientRect().bottom")));
            int lblTop = (int) Double
                    .parseDouble((uiDriver
                            .executeScript("return document.getElementsByTagName" + lblLabel_JS + ".getBoundingClientRect().top")));
            if (instructBottom < lblTop)
                isPresent = true;
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE POSITION OF 'Instructional message' ABOVE 'File to attach' LABEL. \nMETHOD: isFileToAttachLabelBelowInstructionalText()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will chcek whether 'text box' is next to 'Attach file' label.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isTextBoxNextTofileToAttachLabel() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'text box' NEXT 'file to attach' LABEL. ");
            int lblRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + lblLabel_JS + ".getBoundingClientRect().right")));
            int txtLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnBrowse_JS + ".getBoundingClientRect().left")));
            if (lblRight <= txtLeft)
                isPresent = true;
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "Unable to locate position of 'text box' NEXT 'file to attach' LABEL. \nMETHOD: isTextBoxNextTofileToAttachLabel()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will chcek whether text box is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isTextBoxDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING TEXT BOX DISPLAYED OR NOT. ");
            return btnBrowse.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO LOCATE TEXT BOX. \nMETHOD: isTextBoxDisplayed()." + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method will get 'Attach file' button caption.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getAttachFileButtonCaption() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Add Attachment' CAPTION. ");
            btnAttachFile.isDisplayedAfterWaiting(waitTime);
            return btnAttachFile.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Add Attachment' BUTTON'S CAPTION. \nMETHOD: getAttachFileButtonCaption()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether 'attach file' bottom right of 'table'
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachFileBottomRightOfTable() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Attach File' BUTTON BOTTOM RIGHT OF 'Table'");
            int tblTop = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().top")));
            int tblBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().bottom")));
            int tblLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().left")));
            int tblRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().right")));
            int tblWidth = tblRight - tblLeft;
            int tblHeight = tblBottom - tblTop;
            int btnBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnAttachFile_JS + ".getBoundingClientRect().bottom")));
            int btnRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnAttachFile_JS + ".getBoundingClientRect().right")));
            if ((tblTop <= btnBottom) && (tblBottom >= btnBottom)) {
                if ((tblLeft <= btnRight) && (tblRight >= btnRight)) {
                    logInstruction("LOG INSTRUCTION: BUTTON IS WITHIN TABLE, CHECKING FOR BOTTOM RIGHT CORNER.");
                    if (((((tblWidth / 4) * 3) + tblLeft) <= btnRight) && ((((tblHeight / 4) * 3) + tblTop) <= btnBottom))
                        isPresent = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LOCATION OF 'Attach File' BUTTON BOTTOM RIGHT OF 'Table'. \nMETHOD: isAttachFileBottomRightOfTable(). " + e
                            .getLocalizedMessage());
        }
        return isPresent;
    }

    /**
     * This method will get Save and Attach Another caption
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getSaveAndAttachAnotherCaption() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Save And Add Attachment' CAPTION. ");
            btnSaveAndAttachFile.isDisplayedAfterWaiting(waitTime);
            return btnSaveAndAttachFile.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Save And Attach Another' BUTTON'S CAPTION. \nMETHOD: getSaveAndAttachAnotherCaption()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether 'Save And Attach Another' bottom right of 'table'
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isSaveAndAddAttachmentBottomRightOfTable() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Save And Attach Another' BUTTON BOTTOM RIGHT OF 'Table'");
            int tblTop = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().top")));
            int tblBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().bottom")));
            int tblLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().left")));
            int tblRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().right")));
            int tblWidth = tblRight - tblLeft;
            int tblHeight = tblBottom - tblTop;
            int btnBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnSaveAndAttach_JS + ".getBoundingClientRect().bottom")));
            int btnRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnSaveAndAttach_JS + ".getBoundingClientRect().right")));
            if ((tblTop <= btnBottom) && (tblBottom >= btnBottom)) {
                if ((tblLeft <= btnRight) && (tblRight >= btnRight)) {
                    logInstruction("LOG INSTRUCTION: BUTTON IS WITHIN TABLE, CHECKING FOR BOTTOM RIGHT CORNER.");
                    if (((((tblWidth / 4) * 3) + tblLeft) <= btnRight) && ((((tblHeight / 4) * 3) + tblTop) <= btnBottom))
                        isPresent = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LOCATION OF  'Save And Attach Another' BUTTON BOTTOM RIGHT OF 'Table'. \nMETHOD: isSaveAndAddAttachmentBottomRightOfTable()." + e
                            .getLocalizedMessage());
        }
        return isPresent;
    }

    /**
     * This method will check whether 'Save And Attach another' button next to 'attach file' button.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isSaveAndAttachAnotherNextToAttachFileButton() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Save And Attach Another' BUTTON NEXT TO 'Attach file' BUTTON. ");
            int attachFileRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnAttachFile_JS + ".getBoundingClientRect().right")));
            int saveAndAttachLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnSaveAndAttach_JS + ".getBoundingClientRect().left")));
            if (attachFileRight <= saveAndAttachLeft)
                isPresent = true;
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET POSITION OF 'Save And Attach Another' BUTTON NEXT TO 'Attach file' BUTTON. \nMETHOD: isSaveAndAttachAnotherNextToAttachFileButton()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether Attachments table is displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAttachmentsTableDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHEKING WHETHER ATTACHMENTS TABLE IS DISPALYED OR NOT.");
            return tblAttachment.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ATTACHMENTS TABLE NOT PRESENT. \nMETHOD: isAttachmentsTableDisplayed(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will get 'Cancel' button caption.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getCancelCaption() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Cancel' CAPTION. ");
            btnCancel.isDisplayedAfterWaiting(waitTime);
            return btnCancel.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Cancel' BUTTON'S CAPTION. \nMETHOD: getCancelCaption(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether 'Cancel' button bottom right of 'table'.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelBottomRightOfTable() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Cancel' BUTTON BOTTOM RIGHT OF 'Table'.");
            int tblTop = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().top")));
            int tblBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().bottom")));
            int tblLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().left")));
            int tblRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementsByTagName" + tblTable1_JS + ".getBoundingClientRect().right")));
            int tblWidth = tblRight - tblLeft;
            int tblHeight = tblBottom - tblTop;
            int btnBottom = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnCancel_JS + ".getBoundingClientRect().bottom")));
            int btnRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnCancel_JS + ".getBoundingClientRect().right")));
            if ((tblTop <= btnBottom) && (tblBottom >= btnBottom)) {
                if ((tblLeft <= btnRight) && (tblRight >= btnRight)) {
                    logInstruction("LOG INSTRUCTION: BUTTON IS WITHIN TABLE, CHECKING FOR BOTTOM RIGHT CORNER.");
                    if (((((tblWidth / 4) * 3) + tblLeft) <= btnRight) && ((((tblHeight / 4) * 3) + tblTop) <= btnBottom))
                        isPresent = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LOCATION OF 'Cancel' BUTTON BOTTOM RIGHT OF 'Table'. \nMETHOD: isCancelBottomRightOfTable(). " + e
                            .getLocalizedMessage());
        }
        return isPresent;
    }

    /**
     * This method will check whether 'Cancel' next to 'Save and Attach Another' button.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelNextToSaveAndAttachAnotherButton() throws Exception {
        isPresent = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Cancel' BUTTON NEXT TO 'Save and Attach Another' BUTTON. ");
            int saveAndAttachRight = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnSaveAndAttach_JS + ".getBoundingClientRect().right")));
            int cancelLeft = Integer
                    .parseInt((uiDriver
                            .executeScript("return document.getElementById" + btnCancel_JS + ".getBoundingClientRect().left")));
            if (saveAndAttachRight <= cancelLeft)
                isPresent = true;
            return isPresent;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET POSITION OF 'Cancel' BUTTON NEXT TO 'Save and Attach Another' BUTTON. \nMETHOD: isCancelNextToSaveAndAttachAnotherButton()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will check whether Add Remove Attachments Page is Displayed or not.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAddRemoveAttachementPageDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE TITLE.");
            return lblTableHead.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Add Remove Attachments' PAGE NOT DISPLAYED. \nMETHOD: isAddRemoveAttachementPageDisplayed()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method returns Title of AddRemove Attachment Page.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE TITLE. getHeaderTitle");
            return lblTableHead.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "Error while getting PAGE TITLE OF ADDREMOVE ATTACHMENTS PAGE \n METHOD : getHeaderTitle" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * method help to click 'Browse' Button For IE Browser.
     * 
     * @author Vivek.Singh
     * @param String absoluteFilePath
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     */
    public AddRemoveAttachmentsPage clickBrowseButton(String absoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Browse' BUTTON");
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Browse' BUTTON. \nMETHOD: clickBrowseButton()." + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will check for object type provided from constructor to return the desired page
     * object.
     * 
     * @author Vivek.Singh
     * @return void
     * @throws Exception
     * **/
    public void objectIdentification() throws Exception {
        try {
            if (obj != null) {
                String className = obj.getClass().getSimpleName();
                if (EMAIL_HOME_PAGE.equalsIgnoreCase(className)) {
                    obj = new EmailHomePage(uiDriver);
                } else
                    if (THREAD_RESPOND_PAGE.equalsIgnoreCase(className)) {
                        obj = new ThreadRespondPage(uiDriver);
                    } else
                        if (DROPBOX_INBOX_PAGE.equalsIgnoreCase(className)) {
                            obj = new DropboxInboxPage(uiDriver);
                        } else
                            if (ASSIGNMENT_PAGE.equalsIgnoreCase(className)) {
                                obj = new AssignmentPage(uiDriver);
                            } else
                                if (ADD_TOPIC_PAGE.equalsIgnoreCase(className)) {
                                    obj = new AddTopicPage(uiDriver);
                                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO IDENTIFY THE OBJECT. \nMETHOD: objectIdentification()." + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to get count of attached files
     * 
     * @author Chaitali
     * @return int
     * @throws Exception 
     * **/
    public int getAttachedFilesCount() throws Exception {        
        try {
            logInstruction("LOG INSTRUCTION: GETTING COUNT OF ATTACHED FILE");
            if (lstAttachedFiles.areAllDisplayed()) {
                java.util.List<UIElement> listOfElementsInTable = lstAttachedFiles
                        .getUIElementsList();
                count = listOfElementsInTable.size();
            }
            return count;
        } catch (Exception e) {
            throw new Exception(
                    "NOT ABLE TO GET LIST OF FILES ATTACHED: \nMETHOD: getAttachedFilesCount(). " + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method clicks the 'Delete' button in drop box for Student Login
     * 
     * @Category Milestone2
     * @author Raghav S
     * @param String
     *            fileName
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     * **/
    public AddRemoveAttachmentsPage deleteAttachedFileForStudent(String fileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING DELETE BUTTON FOR FILE " + fileName);
            lblattachstudent.replaceValues(fileName);
            clickElement(lblattachstudent);
            logInstruction("LOG INSTRUCTION: DELETE BUTTON CLICKED.");
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK DELETE FOR: " + fileName + ". \nMETHOD: deleteAttachedFileForStudent()." + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
    
    /**
     * Method helps to upload the file
     * 
     * @author Vivek.Singh
     * @param String strRelativeFilePath
     * @param String strAction
     * @param String strTag
     * @param boolean boolRenameFile
     * @param boolean... boolAbsolutePath
     * @return AddRemoveAttachmentsPage
     * @throws Exception
     */
    public AddRemoveAttachmentsPage uploadFileHandler(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean boolRenameFile,
            boolean... boolAbsolutePath) throws Exception {
    	try {
    		AutoITMethods objAutoITMethods = new AutoITMethods();
    		FileIOUtils objFileIOUtil = new FileIOUtils();
    		Browser browser = getBrowser();
    		if (browser.equals(Browser.FIREFOX)
    				|| browser.equals(Browser.CHROME)) {
    			clickBrowseButton();
    			strFileName = objAutoITMethods.uploadFile(strRelativeFilePath, strAction, strTag, boolRenameFile);
    		} else if (browser.equals(Browser.INTERNETEXPLORER)) {
    			boolean isParamAbsolutePath = false;
    			if (boolAbsolutePath.length > 0) {
    				isParamAbsolutePath = boolAbsolutePath[0];
    			}
    			String absolutePath = objFileIOUtil.getAbsoluteFilePath(strRelativeFilePath, isParamAbsolutePath);

    			if (boolRenameFile) {

    				absolutePath = objAutoITMethods.renameUploadFileName(absolutePath, strTag);
    			}
    			absolutePath = absolutePath.replaceAll("/", "\\\\");
    			File file = new File(absolutePath);
    			strFileName = file.getName();
    			clickBrowseButton(absolutePath);
    		}else {
    			throw new Exception("BROWSER IS NOT SUPPORTED");
    		}

    	} catch (Exception e) {
    		throw new Exception(
    				"ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading FileManger File'"
    						+ "\n METHOD: uploadFileHandler \n"
    						+ e.getLocalizedMessage());
    	}
    	return this;
    }

    /**
     * Method will return the FileName created in UploadFIleMethod
     * 
     * @author Vivek.Singh
     * @return strFileName
     */
    public String getFileName() {
        return strFileName;
    }
}
