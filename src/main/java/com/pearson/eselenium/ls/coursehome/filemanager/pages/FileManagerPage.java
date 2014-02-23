package com.pearson.eselenium.ls.coursehome.filemanager.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoAlertPresentException;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DeleteFilePage Follow the below steps to
 * navigate the page:
 * 
 * 1 - Login as prof 2 - Click on the Course 3 - Select Author Tab 4 - Click FileManager Tab
 * 
 * @author Chaitali
 * @modifiedBy Vivek.Singh - - Based on code review comments by Lanka Pearson
 */
public class FileManagerPage extends BasePageObject {

    /* Elements */
    private UIElement lnkUploadFiles = createElement(UIType.Css, "a[title='Upload Files']");
    private UIElement lnkDownlodFiles = createElement(UIType.Css, "a[title='Download Files']");
    private UIElement lnkAddFolder = createElement(UIType.Css, "a[title='Add Folder']");
    private UIElement lnkDelete = createElement(UIType.Css, "a[title='Delete']");
    private UIElement lnkFileOrFolder = createElement(UIType.Xpath, "//a[contains(.,'{1}')]");
    private UIElement lnkFileOrFolderImg = createElement(
            UIType.Xpath,
            "//tr[td//a[contains(.,'{1}')]]/td[3]/img");
    private UIElement chkFileOrFolder = createElement(
            UIType.Xpath,
            "//tr[td//a[contains(.,'{1}')]]/td/input");
    private UIElement lnkUp = createElement(UIType.Xpath, "//td[@width='*']/a");
    private UIElement msgErrorMessage = createElement(
            UIType.Xpath,
            "//*[@id='folderInstance']/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]");
    private UIElement lblHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement lnkStreamingMediaFolder = createElement(
            UIType.Css,
            "a[title='Streaming Media']");
    private UIElement imgMediaIcon = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table[2]//tr[td//a[contains(.,'{1}')]]//td[3]//img");
    private UIElement txtRootFolderName = createElement(
            UIType.Xpath,
            "//table[2]//table//table[1]//tr[2]/td[2]");
    private UIElement upIconExists = createElement(
            UIType.Css,
            ".innercontenttable>table>tbody>tr>td>a>img");
    private UIElement imgFolder = createElement(UIType.Css, "img[alt='Closed Folder']");
    private UIElement txtRootFolderNameHomePage = createElement(
            UIType.Xpath,
            "//table[2]//table//table[1]//td[2]");
    private UIElement lnkFolderStructure = createElement(
            UIType.Xpath,
            "//label/a[contains(.,'{1}')]");
    private UIElement lnkNewStreamingMedia = createElement(
            UIType.Css,
            "td>label>a[title='Streaming Media']");
    private UIElement lblPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement btnFileManagerTab = createElement(
            UIType.Css,
            "a[class='contentNavigationON']");
    private UIElements lnkFolderList = createElements(UIType.Css, "a[href*='ListFolderView']");
    private UIElements lnkFileList = createElements(UIType.Css, "a[href*='DownloadFile']");
    private UIElements lnkFolderListSubFolder = createElements(
            UIType.Xpath,
            "//td[@width='*']/label/a");
    private UIElements lnkFolderListWithSubFolder = createElements(UIType.Xpath, "//td[@width='*']");
    private UIElements chkFilesOrFolders = createElements(UIType.Css, "input[type='checkbox']");
    private UIElement lnkFile = createElement(UIType.Xpath, "//a[contains(.,'{1}')]");

    /* JavascriptExecutor locators */
    private static final String TXTHEADER_JS = "('div')[8]";
    private static final String LNKUPLOADFILES_JS = "('a')[3]";
    private static final String LNKUPLOADFILESTITLE_JS = "('a')[3][Attr='title']";
    private static final String LNKDOWNLOADFILES_JS = "('a')[4]";
    private static final String LNKDOWNLOADFILESTITLE_JS = "('a')[3][Attr='title']";
    private static final String LNKADDFOLDER_JS = "('a')[5]";
    private static final String LNKADDFOLDERTITLE_JS = "('a')[5][Attr='title']";
    private static final String LNKDELETE_JS = "('a')[6]";
    private static final String LNKDELETETITLE_JS = "('a')[6][Attr='title']";
    private static final String LNKFOLDERSTRUCTURE_JS = "('td')[10]";
    private static final String DELETE = "Delete";
    private static final String ADD_FOLDER = "Add Folder";
    private static final String DOWNLOAD_FILES = "Download Files";
    private static final String UPLOAD_FILES = "Upload Files";

    private static final String STR_RETURN = "return";
    private StringBuilder strScript1 = null;
    private StringBuilder strScript2 = null;
    private StringBuilder strScript3 = null;
    private StringBuilder strScript4 = null;
    private String strTitle = "";
    private String strCourseTitle = null;
    private String strMessage = null;
    private String[] strArray = null;
    private List<UIElement> lstListOfFolder = null;
    private List<String> lstListOfFolderNames = null;
    private List<String> lstNewListOfFolderNames = null;
    private int intFileNo = 0;
    private int intTotalList = 0;
    private int intLocation1 = 0;
    private int intLocation2 = 0;
    private int intLocation3 = 0;
    private int intLocation4 = 0;
    private boolean flag = false;

    /* Constructor */
    public FileManagerPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "File Manager";
        logInstruction("LOG INSTRUCTION: ## FileManagerPage ##");
    }

    /**
     * This method helps to click on the 'Upload File' link. Navigates to {@link UploadFilesPage}.
     * 
     * @throws Exception
     * @author ashish.juyal
     * @return {@link UploadFilesPage}
     */
    public UploadFilesPage clickUploadFilesButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE 'Upload File' LINK");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkUploadFiles, waitTime);
            lnkUploadFiles.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Upload File' BUTTON. \nMETHOD: clickUploadFilesButton.\n" + e
                            .getLocalizedMessage());

        }
        return new UploadFilesPage(uiDriver);
    }

    /**
     * This method helps to click on 'Download files' link. On clicking this link aa window pop-up
     * will occur for Firefox and IE. In chrome download will start automatically.
     * 
     * @return {@link FileManagerPage}
     * @author ashish.juyal
     * @throws Exception
     * @modifiedBy Sumanth.SV -- Since clickAndWait() is hanging, performing the same by
     *             clickByJavascript and then uiDriver.sleep() - For IE
     */
    public FileManagerPage clickDownloadFileButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING 'Download files' LINK");
        try {
            Browser browser = getBrowser();
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkDownlodFiles, waitTime);
            if (browser.equals(Browser.INTERNETEXPLORER)) {
                lnkDownlodFiles.clickByJavascript();
                uiDriver.sleep(waitTime, "Since clickAndWait() is hanging, performing the same");
            } else {
                lnkDownlodFiles.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Download' BUTTON. \nMETHOD: clickDownloadFileButton.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click the 'Add Folder' link. Navigates to {@link AddFolderPage}.
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return AddFolderPage
     */
    public AddFolderPage clickAddFolderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE 'Add Folder' LINK");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkAddFolder, waitTime);
            lnkAddFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Add Folder' LINK. \nMETHOD: clickAddFolderButton.\n" + e
                            .getLocalizedMessage());
        }
        return new AddFolderPage(uiDriver);
    }

    /**
     * This method helps to click the 'Delete' link. Navigates to {@link DeleteFilePage}.
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return DeleteFilePage
     */
    public DeleteFilePage clickDeleteButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE 'Delete' LINK.");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkDelete, waitTime);
            lnkDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Delete' link. \nMETHOD: clickDeleteButton.\n" + e
                            .getLocalizedMessage());
        }
        return new DeleteFilePage(uiDriver);
    }

    /**
     * This Function will be used To click on a particular file.
     * 
     * @return {@link FileManagerPage}
     * @Throws Exception
     * @author shishir.Dwivedi
     * @param {@link String} filename - file to be clicked for downloading.
     * @modifiedBy Sumanth.SV -- Since clickAndWait() is hanging, performing the same by
     *             clickByJavascript and then uiDriver.sleep() - For IE
     */

    public FileManagerPage clickOnFile(String strFilename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON " + strFilename);
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strFilename)) {
                if (isFileDisplayed(strFilename)) {
                    lnkFileOrFolder.replaceValues(strFilename);
                    uiDriver.waitToBeDisplayed(lnkFileOrFolder, 2000);
                    if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                        lnkFileOrFolder.clickByJavascript();
                        uiDriver.sleep(
                                waitTime,
                                "Since clickAndWait() is hanging, performing the same by clickByJavascript and then uiDriver.sleep()");
                    } else {
                        lnkFileOrFolder.clickAndWait(waitTime);
                    }
                } else
                    throw new Exception("THIS IS NOT A FILE \n METHOD:clickOnFile.\n");
            } else {
                throw new Exception("FILE NAME IS NULL \n METHOD:clickOnFile.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON FILE " + strFilename + ". \nMETHOD: clickOnFile.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This function will check whether given input argument is File or folder in the Page
     * 
     * @param {@link String}-- name-- Name of the file which you want to check.
     * @return boolean
     * @throws Exception
     * @author shishir.Dwivedi
     * 
     */
    public boolean isFileDisplayed(String strName) throws Exception {
        flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR " + strName + "IS DISPLAYED OR NOT.");
        try {
            if (StringUtils.isNotBlank(strName)) {
                frameSwitch.switchToFrameContent();
                lnkFileOrFolderImg.replaceValues(strName);
                if (lnkFileOrFolderImg.isDisplayedAfterWaiting(waitTime) == false) {
                    flag = false;
                }
                flag = !(lnkFileOrFolderImg.getAttribute("alt").equalsIgnoreCase("Closed Folder"));
            } else
                throw new Exception("FILE NAME IS NULL \n METHOD: isFileDisplayed.\n");
        } catch (Exception e) {
            throw new Exception(strName + " IS NOT A FILE TYPE. \nMETHOD: isFileDisplayed.\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Function Will Click a Particular Folder
     * 
     * @param {@link String} -- strFolderName --Name of the folder on which you want to click
     * @return {@link FileManagerPage}
     * @throws Exception
     * @author shishir.Dwivedi
     * 
     */
    public FileManagerPage clickOnFolder(String strFolderName) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON FOLDER: " + strFolderName);
        try {
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToFrameContent();
                lnkFileOrFolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(lnkFileOrFolder, waitTime);
                lnkFileOrFolder.clickAndWait(waitTime);
            } else
                throw new Exception("FOLDER NAME IS NULL \n METHOD: clickOnFolder.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON FOLDER: " + strFolderName + ". \nMETHOD: clickOnFolder.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method selects File or folder on basis of given input
     * 
     * @param String
     *            - strFilename
     * @return {@link FileManagerPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     * @modifiedBy Sumanth.SV -- Since clickAndWait() is hanging, performing the same by
     *             clickByJavascript and then uiDriver.sleep() - For IE
     */
    public FileManagerPage selectFileorFolder(String strFilename) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON 'checkbox' OF " + strFilename);
        try {
            if (StringUtils.isNotBlank(strFilename)) {
                frameSwitch.switchToFrameContent();
                chkFileOrFolder.replaceValues(strFilename);
                uiDriver.waitToBeDisplayed(chkFileOrFolder, waitTime);
                if (!chkFileOrFolder.isSelected()) {
                    chkFileOrFolder.setCheckbox(true);
                }
            } else
                throw new Exception("FILE/FOLDER NAME IS NULL \n METHOD: selectFileorFolder.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE FILE/FOLDER: " + strFilename + ". \nMETHOD: selectFileorFolder.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * 
     * Method check the checkbox is present or not
     * 
     * @param String
     *            strFileOrFolderName
     * @author suchi.singh
     * @return boolean
     * @throws Exception
     * 
     * @modifiedBy Vivek.Singh since it is not returning false for Streaming Media Folder
     */
    public boolean isCheckBoxExist(String strFileOrFolderName) throws Exception {
        flag = false;
        try {
            if (StringUtils.isNotBlank(strFileOrFolderName)) {
                logInstruction("LOG INSTRUCTION: CHECKING 'CheckBox' EXIST FOR: " + strFileOrFolderName);
                frameSwitch.switchToFrameContent();
                chkFileOrFolder.replaceValues(strFileOrFolderName);
                flag = chkFileOrFolder.getAttribute("type").equalsIgnoreCase("checkbox");
            } else
                throw new Exception("FILE/FOLDER NAME IS NULL \n METHOD: isCheckBoxExist.\n");
        } catch (Exception e) {
            throw new Exception(
                    "CHECKBOX DOES NOT EXIST FOR: " + strFileOrFolderName + ".\nMETHOD: isCheckBoxExist.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * *Method helps to check the 'Up' link is displayed or not.
     * 
     * @author suchi.singh
     * @return boolean
     * @throws Exception
     */
    public boolean isUpLinkDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Up' LINK DISPLAYED.");
            frameSwitch.switchToFrameContent();
            flag = lnkUp.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("'Up' LINK IS NOT DISPLAYED. \nMETHOD: isUpLinkDisplayed.\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * * Method for clicking 'Up' link. Navigates to base folder of current folder.
     * 
     * @author suchi.singh
     * @return {@link FileManagerPage}
     * @throws Exception
     */
    public FileManagerPage clickUpLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON 'Up' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkUp, waitTime);
            lnkUp.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON 'Up' LINK. \nMETHOD: clickUpLink.\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * 
     * Method for getting error message
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            strMessage = msgErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE. \nMETHOD: getErrorMessage.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method for getCourseTitleText
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */
    public String getCourseTitleText() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING COURSE TITLE TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strMessage = lblHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET COURSE TITLE TEXT. \nMETHOD: getCourseTitleText.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method for click Streaming media folder
     * 
     * @author Chaitali
     * @return FileManagerPage
     * @throws Exception
     */
    public FileManagerPage clickOnStreamingMediaFolder() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK ON 'Streaming Media' FOLDER.");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkStreamingMediaFolder, waitTime);
            lnkStreamingMediaFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Streaming Media' FOLDER. \nMETHOD: clickOnStreamingMediaFolder.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Function Will check whether streaming media folder is present or not. This method will
     * verify that you are in root folder or not.
     * 
     * @return Boolean
     * @throws Exception
     * @author Vivek.Singh
     * 
     */
    public boolean isStreamingMediaFolderPresent() throws Exception {
        flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR 'Streaming Media' FOLDER.");
        try {
            frameSwitch.switchToFrameContent();
            flag = lnkStreamingMediaFolder.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Streaming Media' FOLDER. \nMETHOD: isStreamingMediaFolderPresent.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for checking file or folder with specified name exist or not
     * 
     * @return boolean true if found false if not found
     * @param String
     *            - strName
     * @throws Exception
     * @author Suchi.Singh
     */
    public boolean isFileOrFolderExists(String strName) throws Exception {
        flag = false;
        try {
            if (StringUtils.isNotBlank(strName)) {
                logInstruction("LOG INSTRUCTION: CHECKING FOR " + strName + " EXISTENCE");
                frameSwitch.switchToFrameContent();
                lnkFileOrFolder.replaceValues(strName);
                flag = lnkFileOrFolder.isDisplayedAfterWaiting(waitTime);
            } else
                throw new Exception("FILE/FOLDER NAME IS NULL \n METHOD: isFileOrFolderExists.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND " + strName + ".\nMETHOD: isFileOrFolderExists.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether file is present in sub folder.
     * 
     * @author Vivek.Singh
     * @param String
     *            - strName
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFileExistsInSubFolder(String strName) throws Exception {
        flag = false;
        try {
            if (StringUtils.isNotBlank(strName)) {
                logInstruction("LOG INSTRUCTION: CHECKING FOR FILE OR FOLDER EXISTS: " + strName);
                frameSwitch.switchToFrameContent();
                lnkFolderStructure.replaceValues(strName);
                flag = lnkFolderStructure.isDisplayedAfterWaiting(waitTime);
            } else
                throw new Exception("FILE NAME IS NULL \n METHOD: isFileExistsInSubFolder.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND FILE OR FOLDER: " + strName + ".\nMETHOD: isFileExistsInSubFolder.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether media icon exists for given file name
     * 
     * @author Vivek.Singh
     * @param String
     *            - strFileName
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isMediaFolderIconExists(String strFileName) throws Exception {
        flag = false;
        try {
            if (StringUtils.isNotBlank(strFileName)) {
                logInstruction("LOG INSTRUCTION: CHECKING MEDIA FOLDER ICON.");
                frameSwitch.switchToFrameContent();
                imgMediaIcon.replaceValues(strFileName);
                uiDriver.waitToBeDisplayed(imgMediaIcon, waitTime);
                flag = imgMediaIcon.getAttribute("src").contains("Media");
            } else
                throw new Exception("FOLDER NAME IS NULL \n METHOD: isMediaFolderIconExists.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY MEDIA FOLDER ICON. \nMETHOD: isMediaFolderIconExists.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether folder names are alpha numerically sorted or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFoldersSortedInStreamingMediaFolder() throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING FOR SORTED LIST OF FOLDERS.");
        flag = false;
        lstListOfFolder = new ArrayList<UIElement>();
        lstListOfFolderNames = new ArrayList<String>();
        lstNewListOfFolderNames = new ArrayList<String>();
        try {
            frameSwitch.switchToFrameContent();
            lstListOfFolder = lnkFolderList.getUIElementsList();
            for (UIElement uiElement : lstListOfFolder) {
                lstListOfFolderNames.add(uiElement.getAttribute("title"));
            }
            lstNewListOfFolderNames = lstListOfFolderNames;
            Collections.sort(lstListOfFolderNames);
            flag = lstListOfFolderNames.equals(lstNewListOfFolderNames);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LIST OF FOLDERS. \nMETHOD: isFoldersSortedInStreamingMediaFolder.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether file names are alpha numerically sorted or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFilesSorted() throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING FOR SORTED LIST OF FILES.");
        flag = false;
        lstListOfFolder = new ArrayList<UIElement>();
        lstListOfFolderNames = new ArrayList<String>();
        lstNewListOfFolderNames = new ArrayList<String>();
        try {
            frameSwitch.switchToFrameContent();
            lstListOfFolder = lnkFileList.getUIElementsList();
            for (UIElement uiElement : lstListOfFolder) {
                lstListOfFolderNames.add(uiElement.getAttribute("title"));
            }
            lstNewListOfFolderNames = lstListOfFolderNames;
            Collections.sort(lstListOfFolderNames);
            flag = lstListOfFolderNames.equals(lstNewListOfFolderNames);
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET LIST OF FILES. \nMETHOD: isFilesSorted.\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether files are below folders are not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * 
     **/
    public boolean isFilesBelowFolders() throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING WHETHER FILES BELOW FOLDERS.");
        lstListOfFolder = new ArrayList<UIElement>();
        intFileNo = 0;
        flag = false;
        try {
            frameSwitch.switchToFrameContent();
            lstListOfFolder = lnkFolderListSubFolder.getUIElementsList();
            for (UIElement uiElement : lstListOfFolder) {
                if ((uiElement.getAttribute("href").contains("DownloadFile"))) {
                    intFileNo = 1;
                }
                if ((!(uiElement.getAttribute("href").contains("DownloadFile"))) && (intFileNo == 1)) {
                    intFileNo = 0;
                    break;
                }
            }
            if (intFileNo == 1)
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET LIST OF FOLDERS AND FILES. \nMETHOD: isFilesBelowFolders.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether the newly added folder is below the mentioned folder or not.
     * 
     * @author Vivek.Singh
     * @param String
     *            - parentFolder, newfolder
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFolderPresentBelowGivenFolder(String strParentFolder, String strNewFolder)
            throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING WHETHER " + strNewFolder + " IS PRESENT BELOW " + strParentFolder);
        flag = false;
        lstListOfFolder = new ArrayList<UIElement>();
        try {
            intFileNo = 0;
            lstListOfFolder = lnkFolderListWithSubFolder.getUIElementsList();
            if (StringUtils.isNotBlank(strParentFolder) && StringUtils.isNotBlank(strNewFolder)) {
                if (strParentFolder.equalsIgnoreCase("Streaming Media")) {
                    uiDriver.waitToBeDisplayed(lnkStreamingMediaFolder, waitTime);
                    intFileNo = 1;
                } else { // if (strParentFolder.equalsIgnoreCase("Streaming Media"))
                    for (UIElement uiElement : lstListOfFolder) {
                        uiDriver.waitToBeDisplayed(uiElement, waitTime);
                        if (uiElement.getText().equals(strParentFolder)) {
                            intFileNo = 2;
                            break;
                        }
                    }
                }
                if (intFileNo == 1 || intFileNo == 2) {
                    if (strNewFolder.equalsIgnoreCase("Streaming Media")) {
                        for (UIElement uiElement : lstListOfFolder) {
                            if (uiElement.getText().equals(strParentFolder)) {
                                flag = true;
                            }
                        }
                    } else { // if (strNewFolder.equalsIgnoreCase("Streaming Media")) {
                        List<UIElement> listOfCheckableFolders = lnkFolderListSubFolder
                                .getUIElementsList();
                        for (UIElement uiElement : listOfCheckableFolders) {
                            uiDriver.waitToBeDisplayed(uiElement, waitTime);
                            if (uiElement.getText().equals(strNewFolder)) {
                                flag = true;
                                break;
                            }
                        }
                    }

                } else { // if (intFileNo == 1 || intFileNo == 2) {
                    logInstruction("LOG INSTRUCTION: PARENT ELEMENT IS NOT FOUND. ");
                }
            } else
                // if (StringUtils.isNotBlank(strParentFolder) &&
                // StringUtils.isNotBlank(strNewFolder)) {
                throw new Exception(
                        "EITHER BOTH PARAMETERS OR ONE IS NULL. \nMETHOD: isFolderPresentBelowGivenFolder.\n");
        } catch (Exception e) {
            throw new Exception(
                    "FOLDER: " + strNewFolder + " IS NOT PRESENT BELOW " + strParentFolder + ".\nMETHOD: isFolderPresentBelowGivenFolder.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for unchecking any checkbox already checked
     * 
     * @author Chaitali.Barhate
     * @return FileManagerPage
     * @throws Exception
     */
    public FileManagerPage UncheckAllCheckboxes() throws Exception {
        lstListOfFolder = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: UNCHECKING ALL 'Checkboxes'.");
            frameSwitch.switchToFrameContent();
            lstListOfFolder = chkFilesOrFolders.getUIElementsList();
            intTotalList = lstListOfFolder.size();
            for (int i = 0; i < intTotalList; i++) {
                if (lstListOfFolder.get(i).isSelected()) {
                    lstListOfFolder.get(i).setCheckbox(false);
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO PERFORM UNCHECKED ACTION ON 'Checkbox'. \nMETHOD: UncheckAllCheckboxes.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * 
     * Method for seleting all checkboxes
     * 
     * @author Chaitali.Barhate
     * @return FileManagerPage
     * @throws Exception
     */
    public FileManagerPage checkAllCheckbox() throws Exception {
        lstListOfFolder = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: CHECKING ALL 'Checkboxes'.");
            frameSwitch.switchToFrameContent();
            lstListOfFolder = chkFilesOrFolders.getUIElementsList();
            intTotalList = lstListOfFolder.size();
            for (int i = 0; i < intTotalList; i++) {
                if (!(lstListOfFolder.get(i).isSelected())) {
                    lstListOfFolder.get(i).setCheckbox(true);
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO PERFORM SELECT 'Checkbox' ACTION. \nMETHOD: checkAllCheckbox.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * 
     * Method for get root folder name
     * 
     * @author Chaitali.Barhate
     * @return String
     * @throws Exception
     */

    public String getRootFolderText() throws Exception {
        strCourseTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ROOT FOLDER TEXT");
            frameSwitch.switchToFrameContent();
            if (isUpLinkDisplayed()) {
                strCourseTitle = txtRootFolderName.getText();
            } else {
                strCourseTitle = txtRootFolderNameHomePage.getText();
            }
            logInstruction("LOG INSTRUCTION: Root Folder Text is:" + strCourseTitle);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ROOT FOLDER TEXT. \nMETHOD: getRootFolderText.\n" + e
                            .getLocalizedMessage());
        }
        return strCourseTitle;
    }

    /**
     * 
     * Method for verifying uoload file button should be present below the table heading on the top
     * left with the caption "Upload Files"
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isUploadButtonBelowTableHeading() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName");
        strScript2 = new StringBuilder(strScript1.toString());
        strScript3 = new StringBuilder(strScript1.toString());
        strMessage = "";
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Upload' LINK BELOW 'Table' HEADING. ");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(TXTHEADER_JS)
                    .append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = (int) Double.parseDouble(uiDriver.executeScript(strScript2.append(
                    LNKUPLOADFILES_JS).append(".getBoundingClientRect().top").toString()));
            strMessage = uiDriver.executeScript(strScript3.append(LNKUPLOADFILESTITLE_JS)
                    .toString());
            if (intLocation1 < intLocation2) {
                if (UPLOAD_FILES.equalsIgnoreCase(strMessage))
                    flag = true;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK FOR 'Upload' LINK BELOW 'Table' HEADING CAPTION IS NOT MATCHED. \nMETHOD: isUploadButtonBelowTableHeading.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR 'Upload' LINK BELOW 'Table' HEADING. \nMETHOD: isUploadButtonBelowTableHeading.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for verifying upload file button should be present below the table heading on the top
     * left with the caption "Upload Files"
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isDownoadButtonBelowTableHeading() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName");
        strScript2 = new StringBuilder(strScript1.toString());
        strScript3 = new StringBuilder(strScript1.toString());
        strScript4 = new StringBuilder(strScript1.toString());
        strMessage = "";
        intLocation1 = 0;
        intLocation2 = 0;
        intLocation3 = 0;
        intLocation4 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Download' LINK BELOW 'Table' HEADING. ");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(TXTHEADER_JS)
                    .append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = (int) (Double.parseDouble(uiDriver.executeScript(strScript2.append(
                    LNKDOWNLOADFILES_JS).append(".getBoundingClientRect().top").toString())));
            intLocation3 = (int) (Double.parseDouble(uiDriver.executeScript(strScript3.append(
                    LNKUPLOADFILES_JS).append(".getBoundingClientRect().right").toString())));
            intLocation4 = (int) (Double.parseDouble(uiDriver.executeScript(strScript4.append(
                    LNKDOWNLOADFILES_JS).append(".getBoundingClientRect().left").toString())));
            strMessage = uiDriver
                    .executeScript("return document.getElementsByTagName" + LNKDOWNLOADFILESTITLE_JS);
            if ((intLocation1 < intLocation2) && (intLocation3 < intLocation4)) {
                if (DOWNLOAD_FILES.equalsIgnoreCase(strMessage))
                    flag = true;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK FOR 'Download' LINK BELOW 'Table' HEADING CAPTION IS NOT MATCHED. \nMETHOD: isDownoadButtonBelowTableHeading.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR 'Download' LINK BELOW 'Table' HEADING. \nMETHOD: isDownoadButtonBelowTableHeading.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for verifying Add Folder file button should be present below the table heading on the
     * top left of Download Files button with the caption "Add Folder"
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isAddFolderBelowTableHeadingRigthDownload() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName");
        strScript2 = new StringBuilder(strScript1.toString());
        strScript3 = new StringBuilder(strScript1.toString());
        strScript4 = new StringBuilder(strScript1.toString());
        strMessage = "";
        intLocation1 = 0;
        intLocation2 = 0;
        intLocation3 = 0;
        intLocation4 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Add Folder' LINK BELOW 'Table' HEADING LEFT OF 'Download Files'. ");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(TXTHEADER_JS)
                    .append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = (int) Double.parseDouble(uiDriver.executeScript(strScript2.append(
                    LNKADDFOLDER_JS).append(".getBoundingClientRect().top").toString()));
            intLocation3 = (int) Double.parseDouble(uiDriver.executeScript(strScript3.append(
                    LNKDOWNLOADFILES_JS).append(".getBoundingClientRect().right").toString()));
            intLocation4 = (int) Double.parseDouble(uiDriver.executeScript(strScript4.append(
                    LNKADDFOLDER_JS).append(".getBoundingClientRect().left").toString()));
            strMessage = uiDriver
                    .executeScript("return document.getElementsByTagName" + LNKADDFOLDERTITLE_JS);
            if ((intLocation1 < intLocation2) && (intLocation3 < intLocation4)) {
                if (ADD_FOLDER.equals(strMessage))
                    flag = true;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK FOR 'Add Folder' LINK BELOW 'Table' HEADING CAPTION IS NOT MATCHED. \nMETHOD: isAddFolderBelowTableHeadingRigthDownload.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR 'Add Folder' LINK BELOW 'Table' HEADING LEFT OF 'Download Files'. \nMETHOD: isAddFolderBelowTableHeadingRigthDownload\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for verifying Delete button should be present below the table heading on the top left
     * of Add Folder button with the caption "Delete"
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isDeleteBelowTableHeadingRigthAddFolder() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName");
        strScript2 = new StringBuilder(strScript1.toString());
        strScript3 = new StringBuilder(strScript1.toString());
        strScript4 = new StringBuilder(strScript1.toString());
        strMessage = "";
        intLocation1 = 0;
        intLocation2 = 0;
        intLocation3 = 0;
        intLocation4 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Delete' LINK BELOW 'Table' HEADING RIGHT OF 'Add Folder'.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(TXTHEADER_JS)
                    .append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = (int) (Double.parseDouble(uiDriver.executeScript(strScript2.append(
                    LNKDELETE_JS).append(".getBoundingClientRect().top").toString())));
            intLocation3 = (int) Double.parseDouble(uiDriver.executeScript(strScript3.append(
                    LNKADDFOLDER_JS).append(".getBoundingClientRect().right").toString()));
            intLocation4 = (int) Double.parseDouble(uiDriver.executeScript(strScript4.append(
                    LNKDELETE_JS).append(".getBoundingClientRect().top").toString()));
            strMessage = uiDriver
                    .executeScript("return document.getElementsByTagName" + LNKDELETETITLE_JS);
            if ((intLocation1 < intLocation2) && (intLocation3 < intLocation4)) {
                if (ADD_FOLDER.equals(strMessage))
                    flag = true;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK POSITIONING OF BUTTONS CAPTION IS NOT MATCHED. \nMETHOD: isDeleteBelowTableHeadingRigthAddFolder.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK POSITIONING OF BUTTONS \nMETHOD: isDeleteBelowTableHeadingRigthAddFolder.\n");
        }
        return flag;

    }

    /**
     * 
     * Method for verifying folder structure
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isFolderStructureUnderCommandButtton() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName");
        strScript2 = new StringBuilder(strScript1.toString());
        strScript3 = new StringBuilder(strScript1.toString());
        strMessage = "";
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR FOLDER STRUCTURE UNDER COMMAND BUTTTON");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt(uiDriver.executeScript(strScript1.append(TXTHEADER_JS)
                    .append(".getBoundingClientRect().bottom").toString()));
            intLocation2 = Integer.parseInt(uiDriver.executeScript(strScript2.append(
                    LNKFOLDERSTRUCTURE_JS).append(".getBoundingClientRect().top").toString()));
            strMessage = uiDriver.executeScript(strScript2.append(LNKDELETETITLE_JS).toString());
            if (intLocation1 < intLocation2) {
                if (DELETE.equals(strMessage))
                    flag = true;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK POSITIONING OF BUTTONS CAPTION IS NOT MATCHED. \nMETHOD: isFolderStructureUnderCommandButtton.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK POSITIONING OF BUTTONS. \nMETHOD: isFolderStructureUnderCommandButtton.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method for verifying folder structure
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isRootFolderNameMatched() throws Exception {
        flag = false;
        strTitle = "";
        strArray = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING ROOT FOLDER NAME MATCHED WITH COURSE CODE");
            frameSwitch.switchToFrameContent();
            strTitle = getCourseTitleText();
            if (strTitle.contains(":")) {
                strArray = strTitle.split(":");
            } else
                strArray = strTitle.split(">");
            strTitle = strArray[strArray.length - 1].trim();
            logInstruction("LOG INSTRUCTION: COURSE TITLE IS: " + strTitle);
            logInstruction("LOG INSTRUCTION: ROOT FOLDER NAME IS: " + getRootFolderText().trim());
            if (strTitle.contains(getRootFolderText()))
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK ROOT FOLDER NAME MATCHED. \nMETHOD: isRootFolderNameMatched.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for verifying uplink with upIcon exists
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean isUpLinkWithUpIconExists() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR 'Up' ICON");
            frameSwitch.switchToFrameContent();
            if (isUpLinkDisplayed() == true) {
                if (upIconExists.isDisplayedAfterWaiting())
                    flag = true;
                else
                    flag = false;
            } else {
                throw new Exception(
                        "UNABLE TO CHECK FOR 'Up' LINK WITH 'Up' TEXT. isUpLinkDisplayed RETURNS FALSE \nMETHOD: isUpLinkWithUpIconExists()");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR 'Up' LINK WITH 'Up' TEXT. \nMETHOD: isUpLinkWithUpIconExists.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * 
     * Method for checking if folders present in the root view.
     * 
     * @author Chaitali.Barhate
     * @return boolean
     * @throws Exception
     */

    public boolean getFolderListSize() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: GETTING FOLDER LIST");
            frameSwitch.switchToFrameContent();
            flag = imgFolder.isPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET FOLDER LIST SIZE. \nMETHOD: getFolderListSize.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks whether alert is present or not
     * 
     * @return boolean
     * @author ashish.juyal
     */
    public boolean isAlert() {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING TO ALERT");
            uiDriver.getUIAlert();
            flag = true;
        } catch (NoAlertPresentException e) {
            flag = false;
        }
        return flag;
    }

    /**
     * This method will check for new Streaming Media Folder if Created.
     * 
     * @return Boolean
     * @author Vivek.Singh
     * **/
    public boolean isNewStreamingMediaAdded() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: SEARCHING FOR NEWLY CREATED FOLDER.");
            frameSwitch.switchToFrameContent();
            flag = lnkNewStreamingMedia.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE NEW 'Streaming Media' FOLDER IN ROOT FOLDER. \nMETHOD: isNewStreamingMediaAdded.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * this method will return the current foldername.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getFolderNameInSubFolder() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GET CURRENT FOLDER NAME.");
            frameSwitch.switchToFrameContent();
            txtRootFolderName.isDisplayedAfterWaiting(waitTime);
            strMessage = txtRootFolderName.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CURRENT FOLDER NAME. \nMETHOD: getFolderNameInSubFolder.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the page title.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getPageTitle() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Page title'.");
            frameSwitch.switchToFrameContent();
            lblPageTitle.isDisplayedAfterWaiting(waitTime);
            strMessage = lblPageTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO FETCH 'Page title'. \nMETHOD: getPageTitle.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the upload files caption
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getUploadFilesButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Upload files' CAPTION.");
            frameSwitch.switchToFrameContent();
            if (lnkUploadFiles.isDisplayedAfterWaiting(waitTime))
                strMessage = lnkUploadFiles.getText().trim();
            else
                throw new Exception(
                        "UNABLE TO GET CAPTION OF 'Upload files' CAPTION LINK NOT DISPLAYED. \nMETHOD: getUploadFilesButtonCaption()");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CAPTION OF 'Upload files' CAPTION. \nMETHOD: getUploadFilesButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the download files caption
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getDownloadFilesButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Download file' BUTTON CAPTION.");
            frameSwitch.switchToFrameContent();
            if (lnkDownlodFiles.isDisplayedAfterWaiting(waitTime))
                strMessage = lnkDownlodFiles.getText().trim();
            else
                throw new Exception(
                        "UNABLE TO GET CAPTION OF 'Download files' CAPTION BUTTON NOT DISPLAYED. \nMETHOD: getDownloadFilesButtonCaption()");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CAPTION OF 'Download files' CAPTION. \nMETHOD: getDownloadFilesButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the Add Folder button caption
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getAddFolderButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Add Folder' LINK CAPTION.");
            frameSwitch.switchToFrameContent();
            if (lnkAddFolder.isDisplayedAfterWaiting(waitTime))
                strMessage = lnkAddFolder.getText().trim();
            else
                throw new Exception(
                        "UNABLE TO GET CAPTION OF 'Add Folder' LINK NOT DISPLAYED . \nMETHOD: getAddFolderButtonCaption()");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CAPTION OF 'Add Folder' LINK . \nMETHOD: getAddFolderButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the delete button caption
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getDeleteButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Delete' LINK CAPTION.");
            frameSwitch.switchToFrameContent();
            if (lnkDelete.isDisplayedAfterWaiting(waitTime))
                strMessage = lnkDelete.getText().trim();
            else
                throw new Exception(
                        "UNABLE TO GET CAPTION OF 'Delete' LINK NOT DISPLAYED. \nMETHOD: getDeleteButtonCaption()");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CAPTION OF 'Delete' LINK. \nMETHOD: getDeleteButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the caption of streaming media folder
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getStreamingMediaFolderCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CAPTION OF 'Streaming Media' FOLDER");
            frameSwitch.switchToFrameContent();
            if (lnkStreamingMediaFolder.isDisplayedAfterWaiting(waitTime))
                strMessage = lnkStreamingMediaFolder.getText().trim();
            else
                throw new Exception(
                        "UNABLE TO GET CAPTION OF 'Streaming Media' FOLDER NOT DISPLAYED");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET CAPTION OF 'Streaming Media' FOLDER" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method will return the caption of FileManager tab
     * 
     * @author Chaitli
     * @return String
     * @throws Exception
     * **/
    public String getFileManagerTabCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CAPTION OF 'File Manager' TAB");
            frameSwitch.switchToFrameContent();
            if (btnFileManagerTab.isDisplayedAfterWaiting(waitTime))
                strMessage = btnFileManagerTab.getText().trim();
            else
                throw new Exception("UNABLE TO GET CAPTION OF 'File Manager' TAB NOT DISPLAYED");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET CAPTION OF 'File Manager' TAB.\nMETHOD: getFileManagerTabCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether selected folder is opened or not.
     * 
     * @author Vivek.Singh
     * @param {@link String}
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isSelectedFolderOpened(String strFolderName) throws Exception {
        flag = false;
        lstListOfFolder = new ArrayList<UIElement>();
        try {
            logInstruction("LOG INSTRUCTION: SEARCHING FOR FOLDER OPENED NAME.");
            if (StringUtils.isNotBlank(strFolderName)) {
                lstListOfFolder = lnkFolderListWithSubFolder.getUIElementsList();
                for (UIElement uiElement : lstListOfFolder) {
                    if (uiElement.getText().equals(strFolderName)) {
                        flag = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "NOT INSIDE THE MENTIONED FOLDER " + strFolderName + ": \nMETHOD: isSelectedFolderOpened.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This is a service method to download a file/folder.
     * 
     * @author Vivek.Singh
     * @param {@link String}
     * @return {@link FileManagerPage}
     * @category Milestone 1
     * @throws Exception
     * **/
    public FileManagerPage selectFileToDownlaod(String strFileOrFolderName) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECTING FILE/FOLDER TO DOWNLOAD.");
        try {
            if (StringUtils.isNotBlank(strFileOrFolderName)) {
                logInstruction("LOG INSTRUCTION: CHECKING 'Chceckbox' OF FILE/FOLDER TO BE SELECTED.");
                Browser browser = getBrowser();
                frameSwitch.switchToFrameContent();
                chkFileOrFolder.replaceValues(strFileOrFolderName);
                uiDriver.waitToBeDisplayed(chkFileOrFolder, waitTime);
                if (!chkFileOrFolder.isSelected()) {
                    chkFileOrFolder.setCheckbox(true);
                }

                logInstruction("LOG INSTRUCTION: CLICKING 'Download' BUTTON.");
                uiDriver.waitToBeDisplayed(lnkDownlodFiles, waitTime);
                if (browser.equals(Browser.INTERNETEXPLORER)) {
                    lnkDownlodFiles.clickByJavascript();
                    uiDriver.sleep(
                            waitTime,
                            "ClickAndWait is hanging and page is not getting loaded");
                } else {
                    lnkDownlodFiles.clickAndWait(waitTime);
                }

            } else
                throw new Exception(
                        "'Filename/FolderName' TO BE SELECTED TO 'Download' IS NULL. \nMETHOD: selectFileToDownlaod \n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Download' FILE/FOLDER: " + strFileOrFolderName + ".\nMETHOD: selectFileToDownlaod \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This is a service method to download a file/folder.
     * 
     * @author Vivek.Singh
     * @param {@link String}
     * @return {@link DeleteFilePage}
     * @category Milestone 1
     * @throws Exception
     * **/
    public DeleteFilePage selectFileOrFolderToDelete(String strFileOrFolder) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECTING FILE/FOLDER TO DELETE.");
        try {
            if (StringUtils.isNotBlank(strFileOrFolder)) {
                logInstruction("LOG INSTRUCTION: CHECKING 'Chceckbox' OF FILE/FOLDER TO BE SELECTED.");
                frameSwitch.switchToFrameContent();
                chkFileOrFolder.replaceValues(strFileOrFolder);
                uiDriver.waitToBeDisplayed(chkFileOrFolder, waitTime);
                if (!chkFileOrFolder.isSelected()) {
                    chkFileOrFolder.setCheckbox(true);
                }

                logInstruction("LOG INSTRUCTION: CLICKING 'Delete' BUTTON.");
                uiDriver.waitToBeDisplayed(lnkDelete, waitTime);
                lnkDelete.clickAndWait(waitTime);

            } else
                throw new Exception(
                        "'Filename/FolderName' TO BE SELECTED TO 'Delete' IS NULL. \nMETHOD: selectFileOrFolderToDelete \n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO 'Delete' FILE/FOLDER: " + strFileOrFolder + ".\nMETHOD: selectFileOrFolderToDelete \n" + e
                            .getLocalizedMessage());
        }

        return new DeleteFilePage(uiDriver);
    }

    /**
     * This method will check whether file is listed below the folder.
     * 
     * @author bharat.goel
     * @param {@link String} {@link String}
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isFileBelowFolder(String strFolderName, String strFileName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: FILE IS BELOW FOLDER NAME PROVIDED.");
            if (StringUtils.isNotBlank(strFolderName) && StringUtils.isNotBlank(strFileName)) {
                lnkFile.replaceValues(strFileName);
                lnkFileOrFolder.replaceValues(strFolderName);
                lnkFile.isDisplayedAfterWaiting(waitTime);
                lnkFileOrFolder.isDisplayedAfterWaiting(waitTime);
                if (lnkFileOrFolder.getLocation().y < lnkFile.getLocation().y && lnkFileOrFolder
                        .getLocation().x == lnkFile.getLocation().x) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "FILE IS NOT BELOW FOLDER NAME PROVIDED \nMETHOD: isFileIsBelowFOlder()" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}
