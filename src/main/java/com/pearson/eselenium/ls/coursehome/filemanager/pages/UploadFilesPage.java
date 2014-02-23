package com.pearson.eselenium.ls.coursehome.filemanager.pages;

import java.io.File;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.eselenium.utils.FileIOUtils;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of File manager page Follow the below steps to
 * navigate the page: Login as prof Click on the Course Select Author Tab Click FileManager link
 * click AddFolder link. Clikc on Upload file.
 * 
 * @author Chaitali
 */
public class UploadFilesPage extends BasePageObject {

    /* elements */
    private UIElement btnBrowse = createElement(UIType.Css, "input[name='newFile']");
    private UIElement btnUploadFiles = createElement(UIType.Css, "#btnUpload");
    private UIElement btnCancel = createElement(UIType.Css, "#btnCancel");
    private UIElement chkUnzip = createElement(UIType.Css, "input[name='unzipzipfile']");
    private UIElement msgError = createElement(UIType.Css, ".inlineerror td:nth-child(2)");
    private UIElement msgNote = createElement(
            UIType.Xpath,
            "//*[@id='saveFiles']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/p");
    private UIElement msgInformation = createElement(
            UIType.Xpath,
            "//*[@id='saveFiles']/table/tbody/tr/td/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]");
    private UIElement lblHeader = createElement(UIType.Css, ".tablehead");
    private UIElement lblCurrentLocation = createElement(
            UIType.Css,
            ".innercontenttable tr:nth-child(1)>td:nth-child(2)");

    /* JavascriptExecutoe elements */
    private static final String LBLUPLOADFILESTO_JS = "('td')[8]";
    private static final String LBLCURRENTLOCATION_JS = "('td')[9]";
    private static final String LBLNEWFILE_JS = "('label')[0]";
    private static final String TXTNEWFILE_JS = "('newFile')";
    private static final String CHKUNZIP_JS = "('unzipzipfile')";
    private static final String TBLTABLE_JS = "('table')[0]";
    private static final String BTNUPLOAD_JS = "('btnUpload')";
    private static final String BTNCANCEL_JS = "('btnCancel')";

    private static final String STR_RETURN = "return";
    public static String strAlertMsg = "";
    private StringBuilder strScript1 = null;
    private StringBuilder strScript2 = null;
    private String strFileName = null;
    private String strMessage = null;
    private int intLocation1 = 0;
    private int intLocation2 = 0;
    private int intLocation3 = 0;
    private int intLocation4 = 0;
    private int intLocation5 = 0;
    private int intLocation6 = 0;
    private int intLocation7 = 0;
    private int intLocation8 = 0;
    private boolean flag = false;
    private Browser browser = null;
    private AutoITMethods objAutoITMethods = null;
    private FileIOUtils objFileIOUtil = null;

    /* Constructor */
    public UploadFilesPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "Upload Files";
        logInstruction("LOG INSTRUCTION: ## UploadFilesPage ##");
    }

    /**
     * This method clicks 'Browse' button(FIREFOX) or 'Choose File' button(CHROME). It is used in
     * the respective handlers declared in the test project. This method supports only CHROME and
     * FIREFOX.
     * 
     * @author ashish.juyal
     * @return UploadFilesPage
     * @throws Exception
     */
    public UploadFilesPage clickBrowseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Browse'/'Choose File' BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Browse'/'Choose File' BUTTON. \nMETHOD: clickBrowseButton.\n " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on the 'Upload File' button. If the alert pops up after clicking the
     * button, the method will capture the alert message in the "static variable alertMsg" and
     * accepts the alert by default.
     * 
     * Navigates to {@link FileManagerPage} if file is a valid file as per the application else
     * remains on {@link UploadFilesPage}.
     * 
     * @param: String -- Optional parameter should be "dismiss" OR "accept"
     * @author ashish.juyal
     * @throws Exception
     * @return Object Return Type changed by Vivek.Singh
     * @modifiedBy Sumanth.SV -- Added Thread.sleep() Since clickAndWait() is hanging, performing
     *             the same
     */
    public Object clickUploadFilesButton(String... strAlert) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Upload Files' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadFiles, waitTime);
            browser = getBrowser();
            if (browser.equals(Browser.INTERNETEXPLORER)) {
                btnUploadFiles.clickByJavascript();
                uiDriver.sleep(waitTime, "Since clickAndWait() is hanging"); //
            } else
                // if(browser.equalsIgnoreCase("InternetExplorer"))
                btnUploadFiles.clickAndWait(waitTime);
            if (strAlert.length > 0 && strAlert[0].equalsIgnoreCase("dismiss")) {
                strAlertMsg = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().dismissAlertIfPresent();
            } else
                // if (alertButton.length > 0 &&
                // alertButton[0].equalsIgnoreCase("dismiss"))
                strAlertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            if (isUploadFilesButtonDisplayed())
                return this;
            else
                // if (isUploadFilesButtonDisplayed())
                return new FileManagerPage(uiDriver);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Upload Files' BUTTON. \nMETHOD: clickUploadFilesButton.\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to check whether "Upload Files" button displayed or not.
     * 
     * @author Sumanth SV
     * @return boolean true if button displayed else false
     * @throws Exception
     * @modifiedBy Sumanth.SV -- Required Sleep, as the application is taking time to refresh
     */
    public boolean isUploadFilesButtonDisplayed() throws Exception {
        flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING FOR EXISTENCE OF 'Upload Files' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.sleep(waitTime, "Required Sleep, as the application is taking time to refresh");
            flag = btnUploadFiles.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND 'Upload Files' BUTTON. \nMETHOD: isUploadFilesButtonDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to click on the "Cancel" button. Navigates to {@link FileManagerPage}.
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return FileManagerPage
     * 
     */

    public FileManagerPage clickCancelButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE 'Cancel' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Cancel' BUTTON. \nMETHOD: clickCancelButton.\n" + e
                            .getLocalizedMessage());
        }
        return new FileManagerPage(uiDriver);
    }

    /**
     * This function will Select the 'Unzip' check Box.
     * 
     * @return UploadFilesPage
     * @throws Exception
     * @author Shishir.Dwivedi
     * 
     */

    public UploadFilesPage selectUnzipCheckBox() throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING THE CHECKBOX 'Unzip' OF THE FILE");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkUnzip, waitTime);
            if (!chkUnzip.isSelected())
                chkUnzip.setCheckbox(true);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK CHECKBOX 'Unzip'. \nMETHOD: selectUnzipCheckBox.\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This function will capture the error Message . Error message comes when invalid file is being
     * uploaded.
     * 
     * @return String - The Error Message will be Returned .
     * @throws Exception
     * @author Shishir.Dwivedi
     * 
     */
    public String getErrorMessage() throws Exception {
        strMessage = null;
        logInstruction("LOG INSTRUCTION: GETTING ERROR MESSAGE.");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgError, waitTime);
            strMessage = msgError.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE MESSAGE. \nMETHOD: getErrorMessage.\n " + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * Method helps to get the note message present right column of UPLOAD FILES table header.
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String getNoteMEssage() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING NOTE MESSAGE");
            frameSwitch.switchToFrameContent();
            strMessage = msgNote.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET NOTE MESSAGE. \nMETHOD: getNoteMEssage.\n" + e
                    .getLocalizedMessage());
        }
        return strMessage;
    }

    /***
     * Method for getting the Information Message present below UPLOAD FILES table header.
     * 
     * @author suchi.singh
     * @return String
     * @throws Exception
     */

    public String getInformationMessage() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Information Message'");
            frameSwitch.switchToFrameContent();
            strMessage = msgInformation.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Information Message'. \nMETHOD: getInformationMessage.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /***
     * Method for checking is unzip checkbox checked
     * 
     * @return boolean true if checkbox checked false if unchecked
     * @throws Exception
     */

    public boolean IsUnzipCheckBoxChecked() throws Exception {
        flag = false;
        logInstruction("LOG INSTRUCTION: CHECKING THE 'Unzip' CHECKBOX OF THE FILE");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkUnzip, waitTime);
            flag = chkUnzip.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'Unzip' CHECKBOX. \nMETHOD: IsUnzipCheckBoxChecked.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method for deselecting 'Unzip' checkbox
     * 
     * @author Chaitali.Barhate
     * @return UploadFilesPage
     * @throws Exception
     * @modifiedBy Sumanth.SV -- Since clickAndWait() is hanging, performing the same
     */

    public UploadFilesPage unSelectUnzipCheckBox() throws Exception {
        logInstruction("LOG INSTRUCTION: CHECKING THE 'Unzip' CHECKBOX OF THE FILE");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkUnzip, waitTime);
            if (chkUnzip.isSelected()) {
                chkUnzip.setCheckbox(false);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK 'Unzip' CHECKBOX .\nMETHOD: unSelectUnzipCheckBox.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will provide the 'Upload Files' Table header.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * 
     **/
    public String getTableHeader() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Upload Files' TABLE HEADER.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeader, waitTime);
            strMessage = lblHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Upload Files' TABLE HEADER. \nMETHOD: getTableHeader.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether current location is next to upload file to label.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * 
     **/
    public boolean isCurrentLocationNextToUploadFileTo() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Current Location' NEXT TO 'Upload files to:' LABEL.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append(
                    " document.getElementsByTagName").append(LBLUPLOADFILESTO_JS).append(
                    ".getBoundingClientRect().right").toString())));
            intLocation2 = Integer.parseInt((uiDriver.executeScript(strScript2.append(
                    " document.getElementsByTagName").append(LBLCURRENTLOCATION_JS).append(
                    ".getBoundingClientRect().left").toString())));
            if (intLocation2 >= intLocation1)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO VERIFY 'Current Location' NEXT TO 'Upload files to:' LABEL LEFT LABLE IS GREATER. \nMETHOD: isCurrentLocationNextToUploadFileTo.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Current Location' NEXT TO 'Upload files to:' LABEL. \nMETHOD: isCurrentLocationNextToUploadFileTo.\n " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will provide the current location to which file is being added.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getCurrentLocation() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Current Location'.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblCurrentLocation, waitTime);
            strMessage = lblCurrentLocation.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Current Location'. \nMETHOD: getCurrentLocation.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether find new file label is below upload file to label.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFindNewFileLabelBelowUploadFileTo() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Find new file' LABEL BELOW 'Upload file to:' LABEL.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append(
                    " document.getElementsByTagName").append(LBLUPLOADFILESTO_JS).append(
                    ".getBoundingClientRect().bottom").toString())));
            intLocation2 = (int) Double.parseDouble((uiDriver.executeScript(strScript2.append(
                    " document.getElementsByTagName").append(LBLNEWFILE_JS).append(
                    ".getBoundingClientRect().top").toString())));
            if (intLocation2 >= intLocation1)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO GET 'Find new file' LABEL BELOW 'Upload file to:' LABEL. TOP LABEL IS LESSER \nMETHOD: isFindNewFileLabelBelowUploadFileTo.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Find new file' LABEL BELOW 'Upload file to:' LABEL.\nMETHOD: isFindNewFileLabelBelowUploadFileTo.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether 'Find new file' text below 'Upload file to:' label.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFindNewFileTextBelowUploadFileTo() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Find new file:' BELOW TO 'Upload files to:' LABEL.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append(
                    " document.getElementsByTagName").append(LBLUPLOADFILESTO_JS).append(
                    ".getBoundingClientRect().bottom").toString())));
            intLocation2 = Integer.parseInt((uiDriver.executeScript(strScript2.append(
                    " document.getElementById").append(TXTNEWFILE_JS).append(
                    ".getBoundingClientRect().top").toString())));
            if (intLocation2 >= intLocation1)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO GET 'Find new file:' BELOW TO 'Upload files to:' LABEL TOP LABEL IS LESSER .\nMETHOD: isFindNewFileTextBelowUploadFileTo.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Find new file:' BELOW TO 'Upload files to:' LABEL.\nMETHOD: isFindNewFileTextBelowUploadFileTo.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether 'Find New File' Text Next 'find New File' Label.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFindNewFileTextNextfindNewFileLabel() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Find new file:' TEXT NEXT TO 'Find new file:' LABEL.");
            frameSwitch.switchToFrameContent();
            intLocation1 = (int) Double.parseDouble((uiDriver.executeScript(strScript1.append(
                    " document.getElementsByTagName").append(LBLNEWFILE_JS).append(
                    ".getBoundingClientRect().right").toString())));
            intLocation2 = Integer.parseInt((uiDriver.executeScript(strScript2.append(
                    " document.getElementById").append(TXTNEWFILE_JS).append(
                    ".getBoundingClientRect().left").toString())));
            if (intLocation2 >= intLocation1)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO GET 'Find new file:' TEXT NEXT TO 'Find new file:' LEFT LABEL IS LESSER .\nMETHOD: isFindNewFileTextNextfindNewFileLabel.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Find new file:' TEXT NEXT TO 'Find new file:' LABEL.\nMETHOD: isFindNewFileTextNextfindNewFileLabel.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether 'Unzip' Check Box Below Find New File Text.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isUnzipCheckBoxBelowFindNewFileText() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN);
        strScript2 = new StringBuilder(STR_RETURN);
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Unzip' CHECK BOX BELOW 'Find new file' TEXT");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append(
                    " document.getElementById").append(TXTNEWFILE_JS).append(
                    ".getBoundingClientRect().bottom").toString())));
            intLocation2 = Integer.parseInt((uiDriver.executeScript(strScript2.append(
                    " document.getElementById").append(CHKUNZIP_JS).append(
                    ".getBoundingClientRect().top").toString())));
            if (intLocation2 >= intLocation1)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO GET 'Unzip' CHECK BOX BELOW 'Find new file' TOP TEXT IS LESSER . \nMETHOD: isUnzipCheckBoxBelowFindNewFileText.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Unzip' CHECK BOX BELOW 'Find new file' TEXT. \nMETHOD: isUnzipCheckBoxBelowFindNewFileText.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether 'Upload Files' Button Bottom Right Of Table.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isUploadButtonBottomRightOfTable() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName").append(
                TBLTABLE_JS).append(".getBoundingClientRect().");
        strScript2 = new StringBuilder(STR_RETURN).append(" document.getElementById").append(
                BTNUPLOAD_JS).append(".getBoundingClientRect().");
        intLocation1 = 0;
        intLocation2 = 0;
        intLocation3 = 0;
        intLocation4 = 0;
        intLocation5 = 0;
        intLocation6 = 0;
        intLocation7 = 0;
        intLocation8 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Upload Files' BUTTON BOTTOM RIGHT OF TABLE.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append("top")
                    .toString())));
            intLocation2 = (int) Double.parseDouble((uiDriver.executeScript(strScript1.toString()
                    .replace("top", "bottom"))));
            intLocation3 = Integer.parseInt((uiDriver.executeScript(strScript1.toString().replace(
                    "top",
                    "left"))));
            intLocation4 = Integer.parseInt((uiDriver.executeScript(strScript1.toString().replace(
                    "top",
                    "right"))));
            intLocation5 = intLocation4 - intLocation3;
            intLocation6 = intLocation2 - intLocation1;
            intLocation7 = (int) Double.parseDouble((uiDriver.executeScript(strScript2.append(
                    "bottom").toString())));
            intLocation8 = (int) Double.parseDouble((uiDriver.executeScript(strScript2.toString()
                    .replace("bottom", "right"))));
            if ((intLocation1 <= intLocation7) && (intLocation2 >= intLocation7)) {
                if ((intLocation3 <= intLocation8) && (intLocation4 >= intLocation8)) {
                    logInstruction("LOG INSTRUCTION: BUTTON IS WITHIN TABLE, CHECKING FOR BOTTOM RIGHT CORNER.");
                    if (((((intLocation5 / 4) * 3) + intLocation3) <= intLocation8) && ((((intLocation6 / 4) * 3) + intLocation1) <= intLocation7))
                        flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Upload Files' BUTTON BOTTOM RIGHT OF TABLE. \nMETHOD: isUploadButtonBottomRightOfTable.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will provide the 'Upload File' Button Caption.
     * 
     * @author Vivek.Singh
     * @return String
     * @throws Exception
     * **/
    public String getUploadButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Upload File' BUTTON CAPTION.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadFiles, waitTime);
            strMessage = btnUploadFiles.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Upload File' BUTTON CAPTION. \nMETHOD: getUploadButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * This method will check whether 'Cancel' Button Bottom Right Of Table.
     * 
     * @author Vivek.Singh
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonBottomRightOfTable() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementsByTagName").append(
                TBLTABLE_JS).append(".getBoundingClientRect().");
        strScript2 = new StringBuilder(STR_RETURN).append(" document.getElementById").append(
                BTNCANCEL_JS).append(".getBoundingClientRect().");
        intLocation1 = 0;
        intLocation2 = 0;
        intLocation3 = 0;
        intLocation4 = 0;
        intLocation5 = 0;
        intLocation6 = 0;
        intLocation7 = 0;
        intLocation8 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Cancel' BUTTON BOTTOM RIGHT OF TABLE.");
            frameSwitch.switchToFrameContent();
            intLocation1 = Integer.parseInt((uiDriver.executeScript(strScript1.append("top")
                    .toString())));
            intLocation2 = (int) Double.parseDouble((uiDriver.executeScript(strScript1.toString()
                    .replace("top", "bottom"))));
            intLocation3 = Integer.parseInt((uiDriver.executeScript(strScript1.toString().replace(
                    "top",
                    "left"))));
            intLocation4 = Integer.parseInt((uiDriver.executeScript(strScript1.toString().replace(
                    "top",
                    "right"))));
            intLocation5 = intLocation4 - intLocation3;
            intLocation6 = intLocation2 - intLocation1;
            intLocation7 = (int) Double.parseDouble((uiDriver.executeScript(strScript2.append(
                    "bottom").toString())));
            intLocation8 = Integer.parseInt((uiDriver.executeScript(strScript2.toString().replace(
                    "bottom",
                    "right"))));
            if ((intLocation1 <= intLocation7) && (intLocation2 >= intLocation7)) {
                if ((intLocation3 <= intLocation8) && (intLocation4 >= intLocation8)) {
                    logInstruction("LOG INSTRUCTION: BUTTON IS WITHIN TABLE, CHECKING FOR BOTTOM RIGHT CORNER.");
                    if (((((intLocation5 / 4) * 3) + intLocation3) <= intLocation8) && ((((intLocation6 / 4) * 3) + intLocation1) <= intLocation7))
                        flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Cancel' BUTTON BOTTOM RIGHT OF TABLE.\nMETHOD: isCancelButtonBottomRightOfTable.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether 'Cancel' Button Next To 'Upload File' Button.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonNextToUploadButton() throws Exception {
        flag = false;
        strScript1 = new StringBuilder(STR_RETURN).append(" document.getElementById").append(
                BTNUPLOAD_JS).append(".getBoundingClientRect().");
        strScript2 = new StringBuilder(STR_RETURN).append(" document.getElementById").append(
                BTNCANCEL_JS).append(".getBoundingClientRect().");
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: IS 'Cancel' BUTTON NEXT TO 'Upload File' BUTTON.");
            frameSwitch.switchToFrameContent();
            intLocation1 = (int) Double.parseDouble((uiDriver.executeScript(strScript2.append(
                    "left").toString())));
            intLocation2 = (int) Double.parseDouble((uiDriver.executeScript(strScript1.append(
                    "right").toString())));
            if (intLocation1 >= intLocation2)
                flag = true;
            else
                throw new Exception(
                        "UNABLE TO GET 'Cancel' BUTTON NEXT TO 'Upload File' LEFT BUTTON IS LESSER .\nMETHOD: isCancelButtonNextToUploadButton.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Cancel' BUTTON NEXT TO 'Upload File' BUTTON.\nMETHOD: isCancelButtonNextToUploadButton.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will provide the 'Cancel' Button Caption.
     * 
     * @author Vivek.Singh
     * @return {@link String}
     * @throws {@link Exception}
     * **/
    public String getCancelButtonCaption() throws Exception {
        strMessage = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Cancel' BUTTON CAPTION.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            strMessage = btnCancel.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET 'Cancel' BUTTON CAPTION. \nMETHOD: getCancelButtonCaption.\n" + e
                            .getLocalizedMessage());
        }
        return strMessage;
    }

    /**
     * this method helps to send keys to file path textbox. This method is designed for handling
     * INTERNETEXPLORER browsing issue.
     * 
     * Navigates to {@link UploadFilesPage}
     * 
     * @author chaitali
     * @return UploadFilesPage
     * @throws Exception
     */
    public UploadFilesPage enterPath(String strFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Browse'/'Choose File' BUTTON");
            frameSwitch.switchToFrameContent();
            if (btnBrowse.isDisplayedAfterWaiting(waitTime))
                btnBrowse.sendKeysToFileInput(strFilePath);
            else
                throw new Exception("Textbox not displayed to send keys....");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO THE 'Browse'/'Choose File' BUTTON. \nMETHOD: enterPath.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will check whether 'Unzip' checkbox is enabled or not.
     * 
     * @author Vivek.Singh
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isChkboxEnabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Unzip' CHKBOX ENABLED OR NOT.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkUnzip, waitTime);
            flag = chkUnzip.isEnabled();
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY 'Unzip' CHKBOX. \nMETHOD: isChkboxEnabled.\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether upload file page is contained within Content frame.
     * 
     * @author Vivek.Singh
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isUploadFilePageWithinContentFrame() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER 'Upload Files Page' IS CONTAINED WITHIN 'Content frame'.");
            frameSwitch.switchToFrameContent();
            flag = lblHeader.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "'Upload Files Page' IS NOT CONTAINED WITHIN 'Content frame'. \nMETHOD: isUploadFilePageWithinContentFrame.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on the 'Upload File' button. If the alert pops up after clicking the
     * button, the method will capture the alert message in the "static variable alertMsg" and
     * accepts the alert by default.
     * 
     * Navigates to {@link FileManagerPage}
     * 
     * @param: String -- Optional parameter should be "dismiss" OR "accept"
     * @author praveen.maled
     * @throws Exception
     * @return {@link FileManagerPage}
     * @modifiedBy Sumanth.SV -- Added Thread.sleep() Since clickAndWait() is hanging, performing
     *             the same
     * 
     */
    public FileManagerPage clickOnValidUploadFilesButton(String... strAlert) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Upload Files' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadFiles, waitTime);
            browser = getBrowser();
            if (browser.equals(Browser.INTERNETEXPLORER)) {
                btnUploadFiles.clickByJavascript();
                uiDriver.sleep(waitTime, "Since clickAndWait() is hanging");
            } else {// if (browser.equalsIgnoreCase("InternetExplorer"))
                btnUploadFiles.clickAndWait(waitTime);
            }
            if (strAlert.length > 0 && strAlert[0].equalsIgnoreCase("dismiss")) {
                strAlertMsg = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().dismissAlertIfPresent();
            } else {// if (alertButton.length > 0 &&
                    // alertButton[0].equalsIgnoreCase("dismiss"))
                strAlertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Upload Files' BUTTON. \nMETHOD: clickOnValidUploadFilesButton.\n" + e
                            .getLocalizedMessage());
        }
        return new FileManagerPage(uiDriver);
    }

    /**
     * Method helps to click on the 'Upload File' button for invalid file type so that casting issue
     * be removed. If the alert pops up after clicking the button, the method will capture the alert
     * message in the "static variable alertMsg" and accepts the alert by default.
     * 
     * Navigates to {@link UploadFilesPage}
     * 
     * @param: String -- Optional parameter should be "dismiss" OR "accept"
     * @author praveen.maled
     * @throws Exception
     * @return {@link UploadFilesPage}
     * @modifiedBy Sumanth.SV -- Added Thread.sleep() Since clickAndWait() is hanging, performing
     *             the same
     * 
     */
    public UploadFilesPage clickOnInValidUploadFilesButton(String... strAlert) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Upload Files' BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadFiles, waitTime);
            browser = getBrowser();
            if (browser.equals(Browser.INTERNETEXPLORER)) {
                btnUploadFiles.clickByJavascript();
                uiDriver.sleep(waitTime, "Since clickAndWait() is hanging");
            } else {// if (browser.equalsIgnoreCase("InternetExplorer"))
                btnUploadFiles.clickAndWait(waitTime);
            }
            if (strAlert.length > 0 && strAlert[0].equalsIgnoreCase("dismiss")) {
                strAlertMsg = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().dismissAlertIfPresent(waitTime);
            } else { // if (alertButton.length > 0 &&
                     // alertButton[0].equalsIgnoreCase("dismiss"))
                strAlertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Upload Files' BUTTON. \nMETHOD: clickOnInValidUploadFilesButton.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method help to click 'Browse' Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return UploadFilesPage
     * @throws Exception
     */
    public UploadFilesPage clickBrowseButton(String absoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Browse' BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE 'Browse' BUTTON.\nMETHOD: clickBrowseButton.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This is Service level method to Upload File through FileManger
     * 
     * @author Praveen.Maled
     * @param strRelativeFilePath
     * @param strAction
     * @param strTag
     * @param renameFile
     * @param alertButton
     * @throws Exception
     */
    public void uploadFileManagerFile(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean flagRenameFile,
            String... strAlert) throws Exception {
        try {
            uploadFileHandler(strRelativeFilePath, strAction, strTag, flagRenameFile);
            logInstruction("LOG INSTRUCTION: FILE UPLOAD IS DONE");
            uiDriver.waitToBeDisplayed(btnUploadFiles, waitTime);
            browser = getBrowser();
            if (browser.equals(Browser.INTERNETEXPLORER)) {
                btnUploadFiles.clickByJavascript();
                uiDriver.sleep(waitTime, "Since clickAndWait() is hanging");
            } else {// if (browser.equalsIgnoreCase("InternetExplorer"))
                btnUploadFiles.clickAndWait(waitTime);
            }
            if (strAlert.length > 0 && strAlert[0].equalsIgnoreCase("dismiss")) {
                strAlertMsg = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().dismissAlertIfPresent();
            } else {// if (alertButton.length > 0 &&
                    // alertButton[0].equalsIgnoreCase("dismiss"))
                strAlertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
            }
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Upload File' BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN UPLOAD FILEMANGER PAGE SERVICE LEVEL METHOD FOR 'Uplaoding FileManager File'" + "\n METHOD: uploadFileManagerFile.\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to upload the file
     * 
     * @param path
     * @param strAction
     * @param strTag
     * @param flagRenameFile
     * @param flagAbsolutePath
     * @return UploadFilesPage
     * @throws Exception
     */
    public UploadFilesPage uploadFileHandler(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean flagRenameFile,
            boolean... flagAbsolutePath) throws Exception {
        try {
            objAutoITMethods = new AutoITMethods();
            objFileIOUtil = new FileIOUtils();
            Browser browser = getBrowser();
            if (browser.equals(Browser.FIREFOX) || browser.equals(Browser.CHROME)) {
                clickBrowseButton();
                strFileName = objAutoITMethods.uploadFile(
                        strRelativeFilePath,
                        strAction,
                        strTag,
                        flagRenameFile);
            } else
                if (browser.equals(Browser.INTERNETEXPLORER)) {
                    boolean isParamAbsolutePath = false;
                    if (flagAbsolutePath.length > 0) {
                        isParamAbsolutePath = flagAbsolutePath[0];
                    }
                    String absolutePath = objFileIOUtil.getAbsoluteFilePath(
                            strRelativeFilePath,
                            isParamAbsolutePath);

                    if (flagRenameFile) {

                        absolutePath = objAutoITMethods.renameUploadFileName(absolutePath, strTag);
                    }
                    absolutePath = absolutePath.replaceAll("/", "\\\\");
                    File file = new File(absolutePath);
                    strFileName = file.getName();
                    clickBrowseButton(absolutePath);
                } else {
                    throw new Exception("BROWSER IS NOT SUPPORTED");
                }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading FileManger File'" + "\n METHOD: uploadFileHandler \n" + e
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
    public String getFileName() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Uploaded' FILENAME.");

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET FILE NAME. \nMETHOD: getFileName.\n" + e
                    .getLocalizedMessage());
        }
        return strFileName; // since this variable stores the filename
                            // attached by uploadFileHandler, so not
                            // initialising it within method.
    }
}
