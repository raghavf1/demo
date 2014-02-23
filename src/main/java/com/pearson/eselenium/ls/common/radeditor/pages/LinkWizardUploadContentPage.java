package com.pearson.eselenium.ls.common.radeditor.pages;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * 
 * This is the Page Object for Upload Content Screen
 * 
 * @author monica.anand
 * 
 */
public class LinkWizardUploadContentPage extends BasePageObject {



    /* UIElements of the page */
    private UIElement lnkContent = createElement(
            UIType.LinkText,
            "Select Content from Course Folder");
    private UIElement txtToDisplayField = createElement(UIType.Css, "#linkTitle");
    private UIElement btnback = createElement(UIType.Xpath, "//input[@value='< Back']");
    private UIElement btnAddLink = createElement(UIType.Xpath, "//input[@value='Add Link']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement divTitle = createElement(UIType.Css, ".tablehead");
    private UIElement btnBrowze = createElement(UIType.ID, "fileUpload");
    private UIElement lblFirstNote = createElement(UIType.Xpath, "//td[@class='inlinemessage2']");
    private UIElement lblSecondNote = createElement(UIType.Xpath, "//td[@class='dkgraytext']");
    private UIElement lblInlineError = createElement(UIType.Xpath, "//td[@class='inlineerror']");
    private UIElement txtNewFolderName = createElement(UIType.ID, "newFolderName");
    private UIElements lstFolderNameList = createElements(UIType.Xpath, "//label");
    private UIElement btnradMainFolder = createElement(UIType.Xpath, "//input[@id='mainfolder']");
    private UIElement btnradButton = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='21']/input[@type='radio']");
    private UIElement btnradButtonSubFolder = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='5%']/input[@type='radio']");
    private UIElement btnCancelDisabled = createElement(
            UIType.Xpath,
            "//input[@disabled='' and  @id='btnCancel']");
    private UIElements lblFolderNames = createElements(UIType.Xpath, "//td[@width='*']");
    private UIElement lnkUpload = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Upload Content')]");
    private UIElement lnkSelect = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Select Content from Course Folder')]");
    private UIElement lblFolderForContentPosition = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[4]//td[@valign='top']");
    private UIElement lstFolderPosition = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[4]//td[2]");
    private UIElements iconFolder = createElements(UIType.Xpath, "//tr[td[img]]//td//label");

    private UIElement imgFolder = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td/img");
    private UIElement fldrStructureDisplayedFolder1 = createElement(
            UIType.Xpath,
            "//td//label[contains(text(),'{1}')]");
    private UIElement fldrStructureDisplayedFolder2 = createElement(
            UIType.Xpath,
            "//td//label[contains(text(),'{1}')]");
    private UIElement txtBoxFileUpload = createElement(UIType.Xpath, "//*[@id='fileUpload']");
    
	/*Constants*/
	UIElement lastFolder;
    private static final String FILETOUPLOADLABELRIGHT = "('label')[1].getBoundingClientRect().right";
    private static final String FILETOUPLOADTEXTBOXLEFT = "('input')[4].getBoundingClientRect().left";
    private static final String FRAMEHEADING = "('tablehead')[0].getBoundingClientRect().bottom";
    private static final String TEXTTODISPLAYTOP = "('label')[0].getBoundingClientRect().top";
    private static final String TEXTTODISPLAYRIGHT = "('label')[0].getBoundingClientRect().right";
    private static final String TEXTTODISPLAYBOTTOM = "('label')[0].getBoundingClientRect().bottom";
    private static final String TEXTTODISPLAYTEXTBOXLEFT = "('linkTitle').getBoundingClientRect().left";
    private static final String FILETOUPLOADTOP = "('label')[1].getBoundingClientRect().top";
    private static final String FILETOUPLOADBOTTOM = "('label')[1].getBoundingClientRect().bottom";
    private static final String NEWFOLDERLABELRIGHT = "('newFolder').getBoundingClientRect().right";
    private static final String NEWFOLDERTEXTBOXLEFT = "('newFolderName').getBoundingClientRect().left";
    private static final String YELLOW = "yellow";
    private static final String NEW_FOLDER = "New Folder";
    private static final String CLASS = "class";
    private static final String REQUIRED = "required";
    private static final String SELECTED = "selected";
    public static String alertMsg;
    boolean flag = false;
    private int intSize = 0;
    private int intLocation1 = 0;
    private int intLocation2 = 0;
    private String strResult = null;
    private String strFileName = null;
    private String strLocation1 = null;
    private String strLocation2 = null;
    List<UIElement> lstFolderNames = new ArrayList<UIElement>();
    List<UIElement> lstIconFolders = new ArrayList<UIElement>();
    List<UIElement> lstIconFolders2 = new ArrayList<UIElement>();
    List<UIElement> lstFolderListElement = new ArrayList<UIElement>();
    AutoITMethods objAutoITMethods;
    File objFile;

	/*Constructor*/
    public LinkWizardUploadContentPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkWizardUploadContentPage";
        logInstruction("LOG INSTRUCTION: ## LinkWizardUploadContentPage ##");
    }
    /**
     * This method is used to click on select content link
     * 
     * @author monica.anand
     * @return LinkWizardSelectContentPage
     * @throws Exception
     * 
     */
    public LinkWizardSelectContentPage clickSelectContent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING LINK ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkContent, waitTime);
            lnkContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK LINK " + "\nMETHOD:clickSelectContent " + e
                    .getLocalizedMessage());
        }
        return new LinkWizardSelectContentPage(uiDriver);
    }

    /**
     * This method is used to type content in the text field
     * 
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     * 
     */
    public LinkWizardUploadContentPage typeTextToDisplay(String strDataToBeEntered)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: TYPE TEXT TO DISLAY METHOD");
            uiDriver.waitToBeDisplayed(txtToDisplayField, waitTime);
            txtToDisplayField.clearAndSendKeys(strDataToBeEntered);

        } catch (Exception e) {
            throw new Exception("UNABLE TO TYPE TEXT" + " \n METHOD : typeTextToDisplay" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click back button
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     * 
     */
    public LinkWizardInsertLinkPage clickBackButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING BACK BUTTON  ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnback, waitTime);
            btnback.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON BACK BUTTON " + "\nMETHOD: clickBackButton " + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);

    }

    /**
     * This method is used to click add link
     * 
     * @author monica.anand
     * 
     * @throws Exception
     * 
     */
    public void clickAddLink() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON ADD LINK ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            btnAddLink.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADD LINK  BUTTON " + "\nMETHOD:clickAddLink " + e
                    .getLocalizedMessage());
        }

    }

    

    /**
     * This method is used to click on cancel button
     * 
     * @author monica.anand
     * @throws Exception
     * 
     */

    public void clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CANCEL BUTTON  ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CANCEL BUTTON " + "\nMETHOD: clickCancelButton " + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used to get the Page title
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getPageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET PAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(divTitle, waitTime);
            strResult = divTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE " + "\nMETHOD:getPageTitle" + e
                    .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to upload a file
     * 
     * @author monica.anand
     * @param path
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage clickBrowse() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON BROWSE BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowze, waitTime);

            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowze.clickByJavascript();
            } else
                btnBrowze.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO UPLOAD THE FILE " + "\nMETHOD: clickBrowse" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method help to click Browse Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage clickBrowse(String strAbsoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowze, waitTime);
            btnBrowze.sendKeysToFileInput(strAbsoluteFilePath);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON THE BROWSE BUTTON " + "\nMETHOD: clickBrowse");
        }
        return this;
    }

    /**
     * This method is used to get the first note " Once you click Add Link and your file begins to
     * upload, please refrain from closing the browser or navigating away from this page. The screen
     * will refresh when the file has uploaded successfully."
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getFirstNote() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET NOTE 1 ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblFirstNote, waitTime);
            strResult = lblFirstNote.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET NOTE1 " + "\nMETHOD: getFirstNote " + e
                    .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to get the second note
     * " Note: File uploads must be completed within 90 minutes. File size limitations will vary based on your connection stability and speed."
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getSecondNote() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET NOTE 2 ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblSecondNote, waitTime);
            strResult = lblSecondNote.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET NOTE 2 " + "\nMETHOD:getSecondNote " + e
                    .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to get the Inline Error Message
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getInlineErrorMessage() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET ERROR MESSAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblInlineError, waitTime);
            strResult = lblInlineError.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ERROR MESSAGE " + "\nMETHOD: getInlineErrorMessage" + e
                    .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to type content in the New Folder text field
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     * 
     */
    public LinkWizardUploadContentPage enterNewFolderName(String strFolderName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : TYPE TEXT IN NEW FOLDER FIELD ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtNewFolderName, waitTime);
            txtNewFolderName.clearAndSendKeys(strFolderName);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO TYPE  TEXT IN NEW FOLDER FIELD " + "\nMETHOD: enterNewFolderName" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if a particular folder is present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @param folderName
     * @return boolean
     * @throws Exception
     */
    public boolean isFolderPresent(String strFolderName) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION : CHECKING IF FOLDER IS PRESENT ");
            frameSwitch.switchToAddLinkFrame();
            List<UIElement> folderListElement = lstFolderNameList.getUIElementsList();
            for (int i = 0; i < folderListElement.size(); i++) {
                if (folderListElement.get(i).getText().contains(strFolderName)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF FOLDER IS PRESENT " + "\nMETHOD:isFolderPresent " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click on Root folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage selectRadioButtonRootFolder() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK RADIO BUTTON ROOT FOLDER");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnradMainFolder, waitTime);
            if (!btnradMainFolder.isSelected())
                btnradMainFolder.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON RADIO BUTTON OF ROOT FOLDER " + "\nMETHOD: selectRadioButtonRootFolder" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if radio button is displayed in front of a folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonDisplayedInFrontOfFolder(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF RADIO BUTTON IS DISPLAYED IN FRONT OF FOLDER");
            frameSwitch.switchToAddLinkFrame();
            btnradButton.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(btnradButton, waitTime);
            flag = btnradButton.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS DISPLAYED IN FRONT OF FOLDER " + "\nMETHOD: isRadioButtonDisplayedInFrontOfFolder " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click radio button for a folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage clickRadioButtonDisplayedInFrontOfFolder(String strFolderName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF  FOLDER");
            frameSwitch.switchToAddLinkFrame();
            btnradButton.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(btnradButton, waitTime);

            if (!btnradButton.isSelected())
                btnradButton.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK RADIO BUTTON IN FRONT OF  FOLDER " + "\nMETHOD: clickRadioButtonDisplayedInFrontOfFolder" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if radio button is displayed in front of a sub folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonDisplayedInFrontOfSubFolder(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF RADIO BUTTON IS DISPLAYED IN FRONT OF SUB FOLDER ");
            frameSwitch.switchToAddLinkFrame();
            btnradButtonSubFolder.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(btnradButtonSubFolder, waitTime);
            flag = btnradButtonSubFolder.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS DISPLAYED IN FRONT OF SUB FOLDER " + "\nMETHOD: isRadioButtonDisplayedInFrontOfSubFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click radio button for a sub folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage clickRadioButtonDisplayedInFrontOfSubFolder(
            String strFolderName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF SUB  FOLDER");
            frameSwitch.switchToAddLinkFrame();
            btnradButtonSubFolder.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(btnradButtonSubFolder, waitTime);

            if (!btnradButton.isSelected())
                btnradButton.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK RADIO BUTTON IN FRONT OF SUB  FOLDER " + "\nMETHOD:clickRadioButtonDisplayedInFrontOfSubFolder " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if Cancel Button Is Disabled
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisabled() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF CANCEL BUTTON IS DISABLED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancelDisabled, waitTime);
            flag = btnCancelDisabled.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  CANCEL BUTTON IS DISABLED " + "\nMETHOD:isCancelButtonDisabled " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to switch to Add Link Page
     * 
     * @author Usha
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadContentPage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("SWITCHING THE WINDOW TO ADDLINK PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH THE WINDOW " + "\nMETHOD:switchToAddLinkPage" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click add link when mandatory fields are blank
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String clickAddLinkWhenMandatoryFieldsAreBlank() throws Exception {
        strResult = null;
        try {
            logInstruction("lOG INSTRUCTION : CLICKING ON ADD LINK WHEN MANDATORY FIELD IS BLANK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            btnAddLink.clickAndWait(waitTime);
                strResult = lblInlineError.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADD LINK  BUTTON " + "\nMETHOD: clickAddLinkWhenMandatoryFieldsAreBlank" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to verify whether Focus On "Text To Display" Field
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFocusOnTextToDisplayField() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF FOCUS ON TEXT TO DISPLAY FIELD ");
            frameSwitch.switchToAddLinkFrame();
            Point point = uiDriver.switchTo().activeElement().getLocation();
            txtToDisplayField.isDisplayedAfterWaiting(waitTime);
            if (point.x == txtToDisplayField.getLocation().x && point.y == txtToDisplayField
                    .getLocation().y)
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON TEXT TO DISPLAY FIELD " + "\nMETHOD:isFocusOnTextToDisplayField " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get the name of the root folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public String getNameOfRootFolder() throws Exception {
        strResult = null;
        try {

            logInstruction("LOG INSTRUCTION : GET ROOT FOLDER NAME");
            frameSwitch.switchToAddLinkFrame();
            lstFolderNames = lblFolderNames.getUIElementsList();
            strResult = lstFolderNames.get(0).getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ROOT FOLDER NAME" + "\nMETHOD:getNameOfRootFolder " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check if the Upload Content Tab is selected
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUploadContentTabSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE UPLOAD CONTENT TAB  IS SELECTED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkUpload, waitTime);
            flag = lnkUpload.getAttribute(CLASS).contains(SELECTED);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE UPLOAD CONTENT TAB  IS SELECTED" + "\nMETHOD:isUploadContentTabSelected " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Upload Content Tab is present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUploadContentTabPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE UPLOAD CONTENT TAB  IS PRESENT");
            frameSwitch.switchToAddLinkFrame();
            flag = lnkUpload.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE  UPLOAD CONTENT TAB IS PRESENT" + "\nMETHOD:isUploadContentTabPresent" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Select Content From Course Folder Link Is Present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isSelectContentFromCourseFolderLinkPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE SELECT CONTENT FROM COURSE FOLDER LINK IS PRESENT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkSelect, waitTime);
            flag = lnkSelect.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE SELECT CONTENT FROM COURSE FOLDER LINK IS PRESENT" + "\nMETHOD:isSelectContentFromCourseFolderLinkPresent" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label Text To Display is below Frame Heading
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */

    public boolean isLabelTextToDisplayBelowFrameHeading() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByClassName" + FRAMEHEADING);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING" + "\nMETHOD:isLabelTextToDisplayBelowFrameHeading" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether textbox is right of Text To Display label
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */

    public boolean isTextBoxRightToTextToDisplayLabel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYRIGHT);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + TEXTTODISPLAYTEXTBOXLEFT);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL" + "\nMETHOD:isTextBoxRightToTextToDisplayLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will Get default Background color of "Text to Display" text box.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return String
     * @throws Exception
     * **/
    public String getDefaultBackgroundColorOfTextToDisplayTextBox() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET DEFAULT BACKGROUND COLOR.");
            frameSwitch.switchToAddLinkFrame();
            if (txtToDisplayField.isDisplayedAfterWaiting(waitTime)) {
                if (txtToDisplayField.getAttribute(CLASS).contains(REQUIRED)) {
                    strResult = YELLOW;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET DEFAULT BACKGROUND COLOR" + "\nMETHOD:getDefaultBackgroundColorOfTextToDisplayTextBox" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to check whether File To Upload Is Below Text To Display
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */

    public boolean isFileToUploadBelowTextToDisplay() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FILE TO UPLOAD IS BELOW TEXT TO DISPLAY");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYBOTTOM);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + FILETOUPLOADTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER FILE TO UPLOAD IS BELOW TEXT TO DISPLAY" + "\nMETHOD:isFileToUploadBelowTextToDisplay" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label FolderForContent below FileToUpload
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean
     * @throws Exception
     */

    public boolean islabelFolderForCotentBelowFileToUpload() throws Exception {
        flag = false;
        strLocation1 = null;
        intLocation1 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL FOLDERFORCONTENT BELOW FILETOUPLOAD.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + FILETOUPLOADBOTTOM);
            intLocation1 = lblFolderForContentPosition.getLocation().getY();
            if ((int) Double.parseDouble(strLocation1) < intLocation1)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER WHETHER LABEL FOLDERFORCONTENT BELOW FILETOUPLOAD" + "\nMETHOD:islabelFolderForCotentBelowFileToUpload" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the browse button is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isBrowseButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE BROWSE BUTTON IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowze, waitTime);
            flag = btnBrowze.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE BROWSE BUTTON IS DISPLAYED" + "\nMETHOD:isBrowseButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether textbox is right of File Upload
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean * @throws Exception
     */

    public boolean isTextBoxRightToFileUpload() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX IS RIGHT OF FILE UPLOAD");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + FILETOUPLOADLABELRIGHT);

            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + FILETOUPLOADTEXTBOXLEFT);

            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE TEXT BOX IS RIGHT TO FILE UPLOAD" + "\nMETHOD:isTextBoxRightToFileUpload" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Folder list is right side of FolderForContent label
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean
     * @throws Exception
     */

    public boolean isFolderListRightSideOfFolderForContentLabel() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FOLDER LIST IS RIGHT SIDE OF FOLDERFORCONTENT LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            intLocation1 = lblFolderForContentPosition.getLocation().getX();
            intLocation2 = lstFolderPosition.getLocation().getX();

            if (intLocation1 < intLocation2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER LIST IS RIGHT SIDE OF FOLDERFORCONTENT LABEL.. " + "\nMETHOD:isFolderListRightSideOfFolderForContentLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether New folder is at last in structure
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean
     * @throws Exception
     */
    public boolean isNewFolderAtLastInStructure() throws Exception {
        flag = false;
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER NEW FOLDER IS AT LAST IN STRUCTURE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            lstIconFolders = iconFolder.getUIElementsList();
            intSize = lstIconFolders.size();
            lastFolder = lstIconFolders.get(intSize - 1);
            strResult = lastFolder.getText();
            String arr[] = strResult.split(":");
            strResult = arr[0];
            flag = strResult.equalsIgnoreCase(NEW_FOLDER);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF NEW FOLDER IS AT LAST IN STRUCTURE" + "\nMETHOD:isNewFolderAtLastInStructure" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Folder Icon is displayed on Left Side
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean
     * @throws Exception
     */
    public boolean isFolderIconDisplayedLeftSide(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FOLDER ICON DISPLAYED ON  LEFT SIDE  ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            if (StringUtils.isNotBlank(strFolderName)) {
                lstIconFolders2 = iconFolder.getUIElementsList();
                for (UIElement uiElement : lstIconFolders2) {
                    if (uiElement.getText().equalsIgnoreCase(strFolderName))
                        flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER FOLDER ICON DISPLAYED ON  LEFT SIDE" + "\nMETHOD:isFolderIconDisplayedLeftSide" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether TextBox is Right To NewFolder Label
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean
     * @throws Exception
     */

    public boolean isTextBoxRightToNewFolderLabel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX RIGHT TO NEWFOLDER LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementById" + NEWFOLDERLABELRIGHT);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + NEWFOLDERTEXTBOXLEFT);

            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER FOLDER ICON DISPLAYED ON  LEFT SIDE  " + "\nMETHOD:isTextBoxRightToNewFolderLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether Back button is displayed.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isBackButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER BACK BUTTON IS DISPLAYED.");
            frameSwitch.switchToAddLinkFrame();
            flag = btnback.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER BACK BUTTON IS DISPLAYED" + "\nMETHOD:isBackButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method will check whether Add Link is Displayed.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isAddLinkButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ADDLINK BUTTON IS DISPLAYED OR NOT.");
            frameSwitch.switchToAddLinkFrame();
            flag = btnAddLink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER ADDLINK BUTTON IS DISPLAYED " + "\nMETHOD:isAddLinkButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether Cancel button is displayed.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return boolean
     * @throws Exception
     * **/
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER CANCEL BUTTON IS DISPLAYED OR NOT.");
            frameSwitch.switchToAddLinkFrame();
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER CANCEL BUTTON IS DISPLAYED " + "\nMETHOD:isCancelButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to check if the folder icon is displayed next to a folder name
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFolderDisplayed(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER IS DISPLAYED");
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToAddLinkFrame();
                imgFolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(imgFolder, waitTime);
                if (imgFolder.isDisplayedAfterWaiting())

                    flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER IS DISPLAYED " + "\nMETHOD:isFolderDisplayed" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method will verify whether folder structure displayed inside
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFolder2InsideFolder1Disp(String strFolder1, String strFolder2)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IF FOLDER 2 IS INSIDE FOLDER 1");
            frameSwitch.switchToAddLinkFrame();
            fldrStructureDisplayedFolder1.replaceValues(strFolder1);
            fldrStructureDisplayedFolder2.replaceValues(strFolder2);
            fldrStructureDisplayedFolder1.isDisplayedAfterWaiting(waitTime);
            fldrStructureDisplayedFolder2.isDisplayedAfterWaiting(waitTime);
            if (fldrStructureDisplayedFolder1.getLocation().x < fldrStructureDisplayedFolder2
                    .getLocation().x && fldrStructureDisplayedFolder1.getLocation().y < fldrStructureDisplayedFolder2
                    .getLocation().y) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF FOLDER 2 IS INSIDE FOLDER 1 " + "\nMETHOD:isFolder2InsideFolder1Disp" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether folder structure displayed inside
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFolder2UnderFolder1Disp(String strFolder1, String strFolder2) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IF FOLDER 2 IS UNDER FOLDER 1");
            frameSwitch.switchToAddLinkFrame();
            fldrStructureDisplayedFolder1.replaceValues(strFolder1);
            fldrStructureDisplayedFolder2.replaceValues(strFolder2);
            fldrStructureDisplayedFolder1.isDisplayedAfterWaiting(waitTime);
            fldrStructureDisplayedFolder2.isDisplayedAfterWaiting(waitTime);
            if (fldrStructureDisplayedFolder1.getLocation().x == fldrStructureDisplayedFolder2
                    .getLocation().x && fldrStructureDisplayedFolder1.getLocation().y < fldrStructureDisplayedFolder2
                    .getLocation().y) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF FOLDER 2 IS UNDER FOLDER 1 " + "\nMETHOD:isFolder2UnderFolder1" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will get entered file path in the input field
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getFilePath() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT FROM 'Text To Display' FIELD");
            frameSwitch.switchToAddLinkFrame();
            strResult = btnBrowze.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING TEXT FROM 'Text To Display' FIELD" + "\nMETHOD:getFilePath\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get entered file path in the input field
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getValueEnteredInTextField() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT FROM 'Text To Display' FIELD");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtToDisplayField.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING TEXT FROM 'Text To Display' FIELD" + "\nMETHOD:getValueEnteredInTextField\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will Verify radio button is selected for specified Option
     * 
     * @author Praveen.Maled
     * @param option
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isOptionSelected(String strOption) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY RADIO BUTTON IS SELECTED FOR SPECIFIED OPTION ");
            if (StringUtils.isNotBlank(strOption)) {
                frameSwitch.switchToAddLinkFrame();
                btnradButtonSubFolder.replaceValues(strOption);
                btnradButtonSubFolder.isDisplayedAfterWaiting(waitTime);
                flag = btnradButtonSubFolder.isSelected();
            } else {
                logInstruction("LOG INSTRUCTION: PROVIDED OPTION IS NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY SELECTED RADIO BUTTON " + "\nMETHOD: isOptionSelected" + e
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
    			if(flagRootFolder){
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
    			if(StringUtils.isNotBlank(strNewFoldername)){
    				logInstruction("LOG INSTRUCTION : TYPE TEXT IN NEW FOLDER FIELD ");
    				txtNewFolderName.clearAndSendKeys(strNewFoldername);
    			}
    			btnAddLink.clickAndWait(waitTime);
    			uiDriver.getUIWindowLocator().switchToFirstWindow();
    		}else//if(StringUtils.isNotBlank(strTextToBeDisplay) && StringUtils.isNotBlank(strFilePath) && StringUtils.isNotBlank(strAction))
                throw new Exception(
                        "EITHER 'strTextToBeDisplay' OR 'strFilePath' OR 'strAction' IS NULL" + "\nMETHOD:createUploadContent\n");

    	} catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING UPLOAD CONTENT LINK " + "\nMETHOD: createUploadContent\n" + e
    				.getLocalizedMessage());
    	}
    	return strFileName;
    }
    
    
    /**
     * Method helps to upload the file, based on the parameters file will be renamed and time stamp will append with the file name
     * @author Praveen.Maled
     * @param path
     * @param strAction
     * @param strTag
     * @param flagRenameFile
     * @param upload
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadContentPage uploadFileHandler(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean flagRenameFile) throws Exception {
    	try {
            objAutoITMethods = new AutoITMethods();
        if (getBrowser().equals(Browser.FIREFOX)||getBrowser().equals(Browser.CHROME)) {
           clickBrowse();
                strFileName = objAutoITMethods.uploadFile(
                        strRelativeFilePath,
                        strAction,
                        strTag,
                        flagRenameFile);
            } else
                if (getBrowser().equals(Browser.INTERNETEXPLORER)) {

                    strResult = this.getClass().getResource(strRelativeFilePath).toString();
                    strResult = strResult.split("file:/")[1];

                    if (flagRenameFile) {
                        strResult = objAutoITMethods.renameUploadFileName(strResult, strTag);
                    }
                    strResult = strResult.replaceAll("/", "\\\\");

                    objFile = new File(strResult);
                    strFileName = objFile.getName();
                    clickBrowse(URLDecoder.decode(strResult, "UTF-8"));
                }else {
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
     * This method is used to type invalid path
     * 
     * @category Milestone 2
     * @author bharat.goel
     * @return LinkWizardUploadImagePage
     * @throws Exception
     * 
     */
    public LinkWizardUploadContentPage enterInvalidPath(String strInvalidPath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTER INVALID PATH ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtBoxFileUpload, waitTime);
            txtBoxFileUpload.clearAndSendKeys(strInvalidPath);

        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER INVALID PATH" + "\nMETHOD:enterInvalidPath\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }


}
