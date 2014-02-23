package com.pearson.eselenium.ls.contentitems.webcontent.pages;

import java.io.File;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the WebContentUpload Page
 * 
 * @author Chaitali
 * @Team Beta
 * @Navigation From Create new web content upload item click on newly created web content item on
 *             navigation tree
 */

public class EditWebContentUploadPage extends BasePageObject {

    private UIElement btnBrowseButton = createElement(UIType.Css, "#findNewFile");
    private UIElement btnUploadButton = createElement(UIType.Xpath, "//input[@id='btnupload']");
    private UIElement txtIsWebUploadedFile = createElement(UIType.Xpath, "//tr[2]/td[2]");
    private UIElement btnToolBoxButton = createElement(
            UIType.Xpath,
            "//div[@id='contentMenu']//a[contains(.,'Toolbox')]");
    private UIElement txtTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement txtToDisplayField = createElement(UIType.Css, "#linkTitle");
    private UIElement btnradMainFolder = createElement(UIType.Xpath, "//input[@id='mainfolder']");
    private UIElement btnradButton = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='21']/input[@type='radio']");
    private UIElement btnradButtonSubFolder = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='5%']/input[@type='radio']");
    private UIElement txtNewFolderName = createElement(UIType.ID, "newFolderName");
    private UIElement btnAddLink = createElement(UIType.Xpath, "//input[@value='Add Link']");
    String strTableTitle = null;
    boolean flag = false;
    String strFileName = null;
    AutoITMethods objAutoITMethods;

    /**
     * @author Chaitali
     * @param uiDriver
     */
    /* Constructor */
    public EditWebContentUploadPage(UIDriver driver) {
        super(driver);
        pageTitle = "EditWebContentUploadPage";
        logInstruction("LOG INSTRUCTION: ## EDIT WEB CONTENT UPLOAD PAGE ##");
    }

    /**
     * this method clicks the browse button
     * 
     * @author Chaitali
     * @return EditWebContentUploadPage
     * @throws Exception
     */
    public EditWebContentUploadPage clickBrowseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowseButton, waitTime);
            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowseButton.clickAndWait(waitTime);
            } else
                btnBrowseButton.clickAndWait(waitTime);
            // browseButton.clickByJavascript();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE BROWSE BUTTON" + "\n METHOD:clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method helps to click on the Upload Files button
     * 
     * @author Chaitali
     * @throws Exception
     * @return EditWebContentUploadPage
     */
    public EditWebContentUploadPage clickUploadFilesButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON THE UPLOAD FILES BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadButton, waitTime);
            btnUploadButton.clickAndWait(waitTime);
            try {
                uiDriver.getUIAlert().acceptAlertIfPresent();
            } catch (Exception e) {
                logInstruction("LOG INSTRUCTION:ALERT NOT PRESENT");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE UPLOAD BUTTON" + "\n METHOD:clickUploadFilesButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method helps to check if uploded file exists or not
     * 
     * @author Chaitali
     * @throws Exception
     * @return boolean
     * @param String
     */
    public boolean isWebUploadedFileDisplayed(String fileName) throws Exception {
        flag = false;

        logInstruction("LOG INSTRUCTION: CHECKING FOR THE UPLOADED FILE EXISTS OR NOT");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtIsWebUploadedFile, waitTime);
            strFileName = txtIsWebUploadedFile.getText();
            if (strFileName.equals(fileName)) {
                return true;
            } else
                return false;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE UPLOAD BUTTON" + "\n METHOD:isWebUploadedFileDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * method help to click Browse Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return EditWebContentUploadPage
     * @throws Exception
     * @param String
     */
    public EditWebContentUploadPage clickBrowseButton(String absoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowseButton, waitTime);
            btnBrowseButton.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE BROWSE BUTTON" + "\nMETHOD: clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * CLICKING ON THE TOOLBOX BUTTON.
     * 
     * @category milestone 2
     * @return WebContentToolboxPage
     * @throws Exception
     */

    public WebContentToolboxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE TOOLBOX BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnToolBoxButton, waitTime);
            btnToolBoxButton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE TOOLBOX BUTTON" + "\n METHOD: clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new WebContentToolboxPage(uiDriver);
    }

    /**
     * @category milestone 2 Methods helps to get header title
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE" + "\n METHOD: getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * @author Method helps to determine whether ToolBox tab is present
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isToolBoxPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: TOOLBOX IS VERIFYING ");
            frameSwitch.switchToFrameContent();

            if (btnToolBoxButton.isDisplayedAfterWaiting(waitTime))
                flag = true;
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND TOOLBOX" + "\n isToolBoxPresent \n" + e
                    .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * Method will create add text to be displayed, upload's file and selects the specified folder
     * or add new folder name if it's not null
     * 
     * @author Praveen.Maled
     * @param strTextToBeDisplay
     * @param strFolderToSelect
     * @param strNewFoldername
     * @param strRelativeFilePath
     * @param strAction
     * @param strTag
     * @param flagRenameFile
     * @param classObject
     * @throws Exception
     * @category Milestone 2
     */

    // uploadWebContentFile(String path,String action, String tag,boolean renameFile,Object
    // ClassObject)
    public String createUploadContent(
            String strTextToBeDisplay,
            boolean flagRootFolder,
            boolean flagSubFolder,
            String strFolderToSelect,
            String strNewFoldername,
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean flagRenameFile) throws Exception {

        try {
            if (StringUtils.isNotBlank(strTextToBeDisplay) && StringUtils
                    .isNotBlank(strRelativeFilePath) && StringUtils.isNotBlank(strAction)) {
                frameSwitch.switchToAddLinkFrame();
                logInstruction("LOG INSTRUCTION: ENTERING TEXT TO DISLAY METHOD");
                uiDriver.waitToBeDisplayed(txtToDisplayField, waitTime);
                txtToDisplayField.clearAndSendKeys(strTextToBeDisplay);
                uploadFileHandler(strRelativeFilePath, strAction, strTag, flagRenameFile);
                uiDriver.getUIAlert().acceptAlertIfPresent();
                if (flagRootFolder) {
                    logInstruction("LOG INSTRUCTION : CLICK RADIO BUTTON ROOT FOLDER");
                    if (!btnradMainFolder.isSelected())
                        btnradMainFolder.clickNoWait();
                } else
                    if (flagSubFolder && StringUtils.isNotBlank(strFolderToSelect)) {
                        logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF SUB  FOLDER");
                        btnradButtonSubFolder.replaceValues(strFolderToSelect);
                        if (!btnradButton.isSelected())
                            btnradButton.clickNoWait();
                    } else
                        if (StringUtils.isNotBlank(strFolderToSelect)) {
                            logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF  FOLDER");
                            btnradButton.replaceValues(strFolderToSelect);
                            if (!btnradButton.isSelected())
                                btnradButton.clickNoWait();
                        }
                if (StringUtils.isNotBlank(strNewFoldername)) {
                    logInstruction("LOG INSTRUCTION : TYPE TEXT IN NEW FOLDER FIELD ");
                    txtNewFolderName.clearAndSendKeys(strNewFoldername);
                }
                btnAddLink.clickAndWait(waitTime);
                uiDriver.getUIWindowLocator().switchToFirstWindow();
            } else
                // if(StringUtils.isNotBlank(strTextToBeDisplay) &&
                // StringUtils.isNotBlank(strFilePath) && StringUtils.isNotBlank(strAction))
                throw new Exception(
                        "EITHER 'strTextToBeDisplay' OR 'strFilePath' OR 'strAction' IS NULL" + "\nMETHOD:createUploadContent\n");

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING UPLOAD CONTENT LINK \n METHOD : createUploadContent\n" + e
                            .getLocalizedMessage());
        }
        return strFileName;
    }

    /**
     * Method helps to upload the file, based on the parameters file will be renamed and time stamp
     * will append with the file name
     * 
     * @author Praveen.Maled
     * @param path
     * @param strAction
     * @param strTag
     * @param flagRenameFile
     * @param upload
     * @return String
     * @throws Exception
     */
    public EditWebContentUploadPage uploadFileHandler(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean flagRenameFile) throws Exception {
        try {
            objAutoITMethods = new AutoITMethods();
            if (getBrowser().equals(Browser.FIREFOX) || getBrowser().equals(Browser.CHROME)) {
                clickBrowseButton();
                strFileName = objAutoITMethods.uploadFile(
                        strRelativeFilePath,
                        strAction,
                        strTag,
                        flagRenameFile);
            } else
                if (getBrowser().equals(Browser.INTERNETEXPLORER)) {

                    String absolutePath = this.getClass().getResource(strRelativeFilePath)
                            .toString();
                    absolutePath = absolutePath.split("file:/")[1];

                    if (flagRenameFile) {
                        absolutePath = objAutoITMethods.renameUploadFileName(absolutePath, strTag);
                    }
                    absolutePath = absolutePath.replaceAll("/", "\\\\");

                    File file = new File(absolutePath);
                    strFileName = file.getName();
                    clickBrowse(URLDecoder.decode(absolutePath, "UTF-8"));
                } else {
                    throw new Exception("BROWSER IS NOT SUPPORTED");
                }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading Link Wizard Upload Content File'" + "\n METHOD: uploadFileHandler \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will return the FileName created in UploadFIleMethod
     * 
     * @author Praveen.Maled
     * @return strFileName
     */
    public String getFileName() {
        return strFileName;
    }

    /**
     * method help to click Browse Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public EditWebContentUploadPage clickBrowse(String absoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowseButton, waitTime);
            btnBrowseButton.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON THE BROWSE BUTTON \n METHOD : clickBrowse");
        }
        return this;
    }

}
