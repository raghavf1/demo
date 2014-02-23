package com.pearson.eselenium.ls.coursehome.filemanager.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DeleteFilePage Follow the below steps to
 * navigate the page:
 * 
 * 1 - Login as prof 2 - Click on the Course 3 - Select Author Tab 4 - Click FileManager Tab 5 -
 * click Delete link
 * 
 * @author Soundarya
 * @modifiedBy Vivek.Singh - - Based on code review comments by Lanka Pearson
 */
public class DeleteFilePage extends BasePageObject {

    /* Elements */
    private UIElement btnDeleteButton = createElement(UIType.Css, "input[value='Delete']");
    private UIElement btnCancelButton = createElement(UIType.Css, "input[value='Cancel']");
    private UIElements lnkFileOrFolder = createElements(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table//table//table//td[1]");
    private UIElement lblHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement msgInfoTop = createElement(
            UIType.Css,
            ".innercontenttable>table>tbody>tr:nth-child(1)>td");
    private UIElement msgError = createElement(
            UIType.Css,
            ".inlineerror>table>tbody>tr>td:nth-child(1)");
    private UIElement divPageTitle = createElement(UIType.Css, "div[class='tablehead']");

    /* JavascriptExecutor elements */
    private static final String LBLINSTRUCTIONALTEXT_JS = "$('.innercontenttable>table>tbody>tr>td')[0]";
    private static final String ELELIST_JS = "$('.innercontenttable>table>tbody>tr>td')[1]";

    private static final String STR_RETURN = "return";
    private StringBuilder strScript1 = null;
    private StringBuilder strScript2 = null;
    private String strMessage = "";
    private String strCompleteListOfFiles = "";
    private String strCompleteListOfFilesOrFolders = "";
    private List<UIElement> lstFileOrFolderName = null;
    private int intLocation1 = 0;
    private int intLocation2 = 0;
    private boolean flag = false;

    /* Constructor */
    public DeleteFilePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "Delete Page";
        logInstruction("LOG INSTRUCTION: ## DeletePage ##");
    }

    /**
     * This method clicks on the 'Delete' button. Navigates to {@link FileManagerPage}.
     * 
     * @return {@link FileManagerPage}
     * @author soundarya
     * @throws Exception
     */
    public FileManagerPage clickDeleteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Delete' BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDeleteButton, waitTime);
            btnDeleteButton.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON THE 'Delete' BUTTON.");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Delete' BUTTON. BUTTON IS NOT DISPLAYED. \nMETHOD: clickDeleteButton.\n" + e
                            .getLocalizedMessage());
        }
        return new FileManagerPage(uiDriver);
    }

    /**
     * This method clicks on the 'Cancel' button. Navigates to {@link FileManagerPage}. After
     * clicking this button, the selected folder or file does not gets deleted.
     * 
     * @return {@link FileManagerPage}
     * @author soundarya
     * @throws Exception
     */
    public FileManagerPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Cancel' BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancelButton, waitTime);
            btnCancelButton.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON THE 'Cancel' BUTTON.");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Cancel' BUTTON. BUTTON IS NOT DISPLAYED. \nMETHOD: clickCancelButton.\n" + e
                            .getLocalizedMessage());
        }
        return new FileManagerPage(uiDriver);
    }

    /**
     * This method will provide list of files and folders being deleted. If you are deleting only
     * one it will return list containing only that instance.
     * 
     * @return:String
     * @author Vivek.Singh
     * @throws Exception
     */
    public String getFolderNameList() throws Exception {
        strCompleteListOfFilesOrFolders = null;
        lstFileOrFolderName = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE FILE OR FOLDER NAMES BEING DELETED.");
            frameSwitch.switchToFrameContent();
            lstFileOrFolderName = lnkFileOrFolder.getUIElementsList();
            for (UIElement objUIElement : lstFileOrFolderName) {
                uiDriver.waitToBeDisplayed(objUIElement, waitTime);
                strCompleteListOfFilesOrFolders += objUIElement.getText().split("-")[0].trim();
            }
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY GOT THE FILE/FOLDER NAMES BEING DELETED.");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LIST OF FILES/FOLDERS BEING DELETED. \nMETHOD: getFolderNameList.\n" + e
                            .getLocalizedMessage());
        }

        return strCompleteListOfFilesOrFolders;
    }

    /**
     * This method will provide list of files and folders being deleted. If you are deleting only
     * one it will return list containing only that instance.
     * 
     * @return:String
     * @author Vivek.Singh
     * @throws Exception
     */
    public String getFileNameList() throws Exception {
        strCompleteListOfFiles = null;
        lstFileOrFolderName = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: GET THE FILE NAMES.");
            frameSwitch.switchToFrameContent();
            lstFileOrFolderName = lnkFileOrFolder.getUIElementsList();
            for (UIElement objUIElement : lstFileOrFolderName) {
                uiDriver.waitToBeDisplayed(objUIElement, waitTime);
                strCompleteListOfFiles += "\n" + objUIElement.getText();
            }
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY GETTED THE FILES LIST.");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LIST OF FILES BEING DELETED. \nMETHOD: getFileNameList.\n" + e
                            .getLocalizedMessage());
        }
        return strCompleteListOfFiles;
    }

    /**
     * Method helps to get Header title
     * 
     * @author Chaitali
     * @return String headerTitle
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        strMessage = null;
        logInstruction("LOG INSTRUCTION: GET HEADER TITLE");
        frameSwitch.switchToFrameContent();
        try {
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strMessage = lblHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE. \nMETHOD: getHeaderTitle.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will return the complete information message displayed in the Delete Page
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getCompleteInfo() throws Exception {
        strMessage = null;
        lstFileOrFolderName = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: GETTING COMPLETE INFO OF DELETION OF FILE AND FOLDERS.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgInfoTop, waitTime);
            strMessage = msgInfoTop.getText();
            lstFileOrFolderName = lnkFileOrFolder.getUIElementsList();
            for (UIElement objUIElement : lstFileOrFolderName) {
                uiDriver.waitToBeDisplayed(objUIElement, waitTime);
                strMessage += "\n" + objUIElement.getText();
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO FETCH COMPLETE INFO. \nMETHOD: getCompleteInfo.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will return the instructional message displayed in the Delete Page
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getInstructionalMessage() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Instructional Text'.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgInfoTop, waitTime);
            strMessage = msgInfoTop.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FETCH 'Instructional Text' MESSAGE. \nMETHOD: getInstructionalMessage.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will return the below information message displayed in the Delete Page
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getListOfFilesAndFoldersWithInfo() throws Exception {
        strMessage = "";
        lstFileOrFolderName = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: GETTING COMPLETE INFO OF DELETION OF FILE AND FOLDERS.");
            frameSwitch.switchToFrameContent();
            lstFileOrFolderName = lnkFileOrFolder.getUIElementsList();
            for (UIElement objUIElement : lstFileOrFolderName) {
                uiDriver.waitToBeDisplayed(objUIElement, waitTime);
                strMessage += "\n" + objUIElement.getText();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FETCH COMPLETE INFO OF DELETION OF FILE AND FOLDERS. \nMETHOD: getListOfFilesAndFoldersWithInfo.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether delete button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isDeleteButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Delete' BUTTON IS DISPLAYED OR NOT.");
            flag = btnDeleteButton.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE 'Delete' BUTTON. \nMETHOD: isDeleteButtonDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether cancel button is displayed or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Cancel' BUTTON IS DISPLAYED OR NOT.");
            flag = btnCancelButton.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE 'Cancel' BUTTON. \nMETHOD: isCancelButtonDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether list is below instructional text or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isListBelowInstructionalText() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: LOCATING POSITION OF LIST OF FILES/FOLDERS BEING DELETED BELOW 'Instructional Text'. ");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(
                    LBLINSTRUCTIONALTEXT_JS).append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2.append(ELELIST_JS)
                    .append(".getBoundingClientRect().top").toString()));
            if (intLocation1 <= intLocation2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE POSITION OF LIST OF FILES/FOLDERS BEING DELETED BELOW 'Instructional Text'. \nMETHOD: isListBelowInstructionalText.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will get any error message.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public String getErrorMessage() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgError, waitTime);
            strMessage = msgError.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE. \nMETHOD: getErrorMessage.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * 
     * Method for checking if delete confirmation message displayed or not
     * 
     * @author Chaitali.Barhate
     * @return boolean true if message
     * @throws Exception
     */
    public boolean isDeleteConfirmationPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: GETTING DELETE CONFIRMATION MESSAGE");
            frameSwitch.switchToFrameContent();
            if (!(divPageTitle.isDisplayedAfterWaiting(waitTime))) {
                flag = false;
            }
            strMessage = divPageTitle.getText();
            flag = strMessage.equals("Delete Files and/or Folders");
        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "NOT ABLE TO CHECK WHETHER DELETE CONFIRMATION PAGE DISPLAYED OR NOT. \nMETHOD: isDeleteConfirmationPageDisplayed.\n");
        }
        return flag;
    }
}
