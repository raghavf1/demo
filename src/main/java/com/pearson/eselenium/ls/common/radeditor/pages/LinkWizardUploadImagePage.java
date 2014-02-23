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
 * This is the Page Object for Link Wizard upload Screen
 * 
 * @author usha
 * 
 */
public class LinkWizardUploadImagePage extends BasePageObject {


    /* Elements */
    private UIElement lbTitle = createElement(UIType.Css, "div.tablehead");
    private UIElement txtDescriptiveText = createElement(UIType.Css, "input#linkTitle");
    private UIElement btnRadio = createElement(
            UIType.Xpath,
            "//table[@role='presentation']//tbody//tr[td[4]/label[contains(text( ),'{1}')]]//input");
    private UIElement txtFileToUpload = createElement(UIType.Css, "input#fileUpload");
    private UIElement btnBack = createElement(UIType.Css, "input#btnBack");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblFolderForContentPosition = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[4]//td[@valign='top']");
    private UIElement lstFolderPosition = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[4]//td[2]");
    private UIElement lblDescriptiveTextAlign = createElement(
            UIType.Xpath,
            "//td[label[contains(text(),'Descriptive')]]");
    private UIElements iconFolder = createElements(UIType.Xpath, "//tr[td[img]]//td//label");
    private UIElement tblPosition = createElement(UIType.Xpath, "//td[@class='tabcontenttable']");
    private UIElement lblFirstNote = createElement(UIType.Xpath, "//td[@class='inlinemessage2']");
    private UIElement lblSecondNote = createElement(UIType.Xpath, "//td[@class='dkgraytext']");
    private UIElement lblInlineError = createElement(UIType.Xpath, "//td[@class='inlineerror']");
    private UIElement lnkSelectImageFromCourseFolder = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Select Image from Course Folder')]");
    private UIElement radButton = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='21']/input[@type='radio']");
    private UIElement radButtonSubFolder = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td[@width='5%']/input[@type='radio']");
    private UIElement txtNewFolderName = createElement(UIType.ID, "newFolderName");
    private UIElement lblRootFolderName = createElement(
            UIType.Xpath,
            "//img[@alt='Folder']/parent::td/following-sibling::td/label");
    private UIElement lblInstructionalText = createElement(
            UIType.Xpath,
            "//input[@id='linkTitle']/parent::td");
    private UIElement lnkUploadImage = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Upload Image')]");
    private UIElement btnBrowze = createElement(UIType.ID, "fileUpload");
    private UIElement radMainFolder = createElement(UIType.Xpath, "//input[@id='mainfolder']");
    private UIElement fldrStructureDisplayedFolder1 = createElement(
            UIType.Xpath,
            "//td//label[contains(text(),'{1}')]");
    private UIElement fldrStructureDisplayedFolder2 = createElement(
            UIType.Xpath,
            "//td//label[contains(text(),'{1}')]");
    private UIElement lblInsTxtDescFld = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[2]/td[2]");
    private UIElement txtDescriptivetext = createElement(UIType.Xpath, "//input[@id='linkTitle']");
    private UIElement btnBrowse = createElement(UIType.Xpath, "//input[@id='fileUpload']");
    private UIElement btnInsertImage = createElement(UIType.Xpath, "//input[@id='btnAddLink']");
    private UIElement txtBoxFileUpload = createElement(UIType.Xpath, "//*[@id='fileUpload']");
    private UIElement iconMusicalFolder = createElement(
            UIType.Xpath,
            "//img[contains(@src,'closedfolderMedia.gif')]");
    UIElement lastFolder;

	/*Variabes*/
    private String descriptiveTextRight = "('label')[0].getBoundingClientRect().right";
    private String textBoxLeft = "('linkTitle').getBoundingClientRect().left";
    private String descriptiveTextBottom = "('label')[0].getBoundingClientRect().bottom";
    private String fileUploadTop = "('label')[1].getBoundingClientRect().top";
    private String fileUploadBottom = "('label')[1].getBoundingClientRect().bottom";
    private String labelNewFolderRight = "('newFolder').getBoundingClientRect().right";
    private String labelNewFolderLeft = "('newFolderName').getBoundingClientRect().left";
    private String buttonBackTop = "('btnBack').getBoundingClientRect().top";
    private String buttonBackAlign = "('btnBack').parentNode[Attr='align']";
    private String buttonInsertImageTop = "('btnAddLink').getBoundingClientRect().top";
    private String buttonInsertImageAlign = "('btnAddLink').parentNode[Attr='align']";
    private String buttonCancelTop = "('btnCancel').getBoundingClientRect().top";
    private String buttonCancelAlign = "('btnCancel').parentNode[Attr='align']";

    private static final String NEW_FOLDER = "New Folder";
    private static final String YELLOW = "yellow";
    private static final String CLASS = "class";
    private static final String REQUIRED = "required";
    private static final String SELECTED = "selected";
    private static final String VALIGN = "valign";
    private static final String TOP = "top";
    private static final String RIGHT = "right";
    
    private int size = 0;
    private int intLocation1 = 0;
    private int intLocation2 = 0;
    private String strResult = null;
    private String strFileName = null;
    private String strLocation1 = null;
    private String strLocation2 = null;
    boolean flag = false;
    List<UIElement> lstIconFolders = new ArrayList<UIElement>();
    List<UIElement> lstFolders = new ArrayList<UIElement>();
    AutoITMethods objAutoITMethods;
    File objFile;

    /* Constructor */
    public LinkWizardUploadImagePage(UIDriver uidriver) {
        super(uidriver);
        logInstruction("LOG INSTRUCTION: ## LinkWizardUploadImage ##");
    }

    /**
     * Method helps to switch to Add Link Page
     * 
     * @author Usha
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadImagePage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO ADDLINK PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO ADDLINK PAGE IS DONE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH THE WINDOW " + "\nMETHOD:switchToAddLinkPage " + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to enter the text in the Descriptive text box
     * 
     * @author ashish.juyal
     * @param String
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public LinkWizardUploadImagePage enterDescriptiveText(String strText) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: ENTER THE TEXT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtDescriptivetext, waitTime);
            txtDescriptivetext.clearAndSendKeys(strText);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'Descriptive Text'" + "\n METHOD:enterDescriptiveText\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to click on the Browse Button
     * 
     * @author ashish.juyal
     * 
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadImagePage clickBrowseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToPopUpContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowse.clickByJavascript();
            } else
                btnBrowse.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Browse' BUTTON" + "\n METHOD:clickBrowseButton:\n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * Method helps to click on back button
     * 
     * @author Usha
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */

    public LinkWizardInsertLinkPage clickBack() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BACK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BACK BUTTON " + "\nMETHOD: clickBack" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * Method helps to click on Insert Image button
     * 
     * @author Usha
     * @throws Exception
     */

    public void clickAddLink() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON ADDLINK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnInsertImage.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ADDLINK BUTTON " + "\nMETHOD: clickAddLink" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Method helps to click on Cancel
     * 
     * @author Usha
     * @throws Exception
     */
    public void clickCancel() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON CANCEL BUTTON " + "\nMETHOD: clickCancel" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to verify LinkWizardUploadImagePage Displayed
     * 
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getLinkWizardUploadImagePageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY LINKWIZARDUPLOADIMAGEPAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lbTitle, waitTime);
            strResult = lbTitle.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LINKWIZARDUPLOADIMAGEPAGE TITLE " + "\nMETHOD: getLinkWizardUploadImagePageTitle " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to Upload file
     * 
     * @author Usha
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadImagePage clickBrowze(String strPath) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON BROWSE BUTTON ");
            strResult = System.getProperty("user.dir") + strPath;
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtFileToUpload, waitTime);
            txtFileToUpload.clearAndSendKeys(strResult);

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BROWSE BUTTON  " + "\nMETHOD: clickBrowze" + e
                    .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to click on radio button
     * 
     * @author usha
     * @param String linkto
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadImagePage selectRadioButton(String strLinkto) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT RADIO BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            btnRadio.replaceValues(strLinkto);
            btnRadio.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON " + "\nMETHOD:selectRadioButton " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to check whether textbox is right of descriptive text label
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if textbox present at right of descriptive text label false otherwise
     * @throws Exception
     */
    public boolean isTextBoxRightToDescriptiveTextLabel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX IS RIGHT OF DESCRIPTIVE TEXT LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + descriptiveTextRight);
            strLocation2 = uiDriver.executeScript("return document.getElementById" + textBoxLeft);
            if (Integer.parseInt(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER TEXTBOX IS RIGHT OF DESCRIPTIVE TEXT LABEL" + "\nMETHOD:isTextBoxRightToDescriptiveTextLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label File to upload below Descriptive text
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if Label FileToUpload present below the Descriptive Text
     * @throws Exception
     */

    public boolean isLabelFileToUploadBelowDescriptiveText() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL FILE TO UPLOAD BELOW DESCRIPTIVE TEXT.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + descriptiveTextBottom);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + fileUploadTop);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER LABEL FILE TO UPLOAD BELOW DESCRIPTIVE TEXT" + "\nMETHOD:isLabelFileToUploadBelowTextToDisplay" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label FolderForContent below FileToUpload
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if Label FolderForContent below FileToUpload else returns false
     * @throws Exception
     */
    public boolean islabelFolderForCotentBelowFileToUpload() throws Exception {
        flag = false;
        strLocation1 = null;
        intLocation1 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL FOLDERFORCONTENT BELOW FILETOUPLOAD.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + fileUploadBottom);
            intLocation1 = lblFolderForContentPosition.getLocation().getY();
            if ((int) Double.parseDouble(strLocation1) < intLocation1)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER LABEL  FOLDERFORCONTENT BELOW FILETOUPLOAD.. " + "\nMETHOD:islabelFolderForCotentBelowFileToUpload" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Folder list is right side of FolderForContent label
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if Folder list is right side of FolderForContent label else returns
     *         false
     * @throws Exception
     */

    public boolean isFolderListRightSideOfFolderForContentLabel() throws Exception {
        flag = false;
        intLocation1 = 0;
        intLocation2 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FOLDER LIST IS RIGHT SIDE OF FOLDERFORCONTENT LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            intLocation1 = lblFolderForContentPosition.getLocation().getX();
            intLocation2 = lstFolderPosition.getLocation().getX();

            if (intLocation1 < intLocation2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER FOLDER LIST IS RIGHT SIDE OF FOLDERFORCONTENT LABEL.. " + "\nMETHOD:isFolderListRightSideOfFolderForContentLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether TextBox is Right To NewFolder Label
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if TextBox Right To NewFolder Label else returns false
     * @throws Exception
     */

    public boolean isTextBoxRightToNewFolderLabel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX RIGHT TO NEWFOLDER LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementById" + labelNewFolderRight);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + labelNewFolderLeft);

            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER WHETHER TEXTBOX RIGHT TO NEWFOLDER LABEL" + "\nMETHOD:isTextBoxRightToNewFolderLabel" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Back Button is Bottom on Right Side
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if Back Button Bottom Right Side else returns false
     * @throws Exception
     */

    public boolean isBackButtonBottomRightSide() throws Exception {
        flag = false;
        strResult = null;
        strLocation1 = null;
        intLocation1 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER BACK BUTTON BOTTOM RIGHT SIDE.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            intLocation1 = tblPosition.getLocation().getY();

            strLocation1 = uiDriver.executeScript("return document.getElementById" + buttonBackTop);

            if (Integer.parseInt(strLocation1) > intLocation1) {
                strResult = uiDriver
                        .executeScript("return document.getElementById" + buttonBackAlign);
                logInstruction("LOG INSTRUCTION: back button present at bottom...Checking for right alignment");
                if (strResult.equalsIgnoreCase(RIGHT)) {
                    flag = true;
                    logInstruction("LOG INSTRUCTION:BACK BUTTON PRESENT AT BOTTOM RIGHT");
                } 
            } 
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER BACK BUTTON BOTTOM RIGHT SIDE" + "\nMETHOD:isBackButtonBottomRightSide" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether InsertImage Button is Bottom on Right Side
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if InsertImage Button Bottom Right Side else returns false
     * @throws Exception
     */
    public boolean isInsertImageButtonBottomRightSide() throws Exception {
        flag = false;
        strResult = null;
        strLocation1 = null;
        intLocation1 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER INSERTIMAGE BUTTON BOTTOM RIGHT SIDE.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);

            intLocation1 = tblPosition.getLocation().getY();

            strLocation1 = uiDriver
                    .executeScript("return document.getElementById" + buttonInsertImageTop);

            if (Integer.parseInt(strLocation1) > intLocation1) {
                strResult = uiDriver
                        .executeScript("return document.getElementById" + buttonInsertImageAlign);
                logInstruction("LOG INSTRUCTION: Insert Image button present at bottom...Checking for right alignment");
                if (strResult.equalsIgnoreCase(RIGHT)) {
                    flag = true;
                    logInstruction("LOG INSTRUCTION:INSERT IMAGE PRESENT AT BOTTOM RIGHT");
                } 
            } 
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER INSERTIMAGE BUTTON BOTTOM RIGHT SIDE" + "\nMETHOD:isInsertImageButtonBottomRightSide" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Cancel Button is Bottom on Right Side
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if Cancel Button Bottom Right Side else returns false
     * @throws Exception
     */

    public boolean isCancelButtonBottomRightSide() throws Exception {
        flag = false;
        strResult = null;
        strLocation1 = null;
        intLocation1 = 0;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER CANCEL BUTTON BOTTOM RIGHT SIDE.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            intLocation1 = tblPosition.getLocation().getY();

            strLocation1 = uiDriver
                    .executeScript("return document.getElementById" + buttonCancelTop);
            if (Integer.parseInt(strLocation1) > intLocation1) {
                strResult = uiDriver
                        .executeScript("return document.getElementById" + buttonCancelAlign);
                logInstruction("LOG INSTRUCTION: CANCEL BUTTON PRESENT AT BOTTOM...CHECKING FOR RIGHT ALIGNMENT");
                if (strResult.equalsIgnoreCase(RIGHT)) {
                    flag = true;
                    logInstruction("LOG INSTRUCTION:CANCEL PRESENT AT BOTTOM RIGHT");
                } 
            } 
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER CANCEL BUTTON BOTTOM RIGHT SIDE" + "\nMETHOD:isCancelButtonBottomRightSide" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get background Color of Input Text
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return String :background color
     * @throws Exception
     */
    public String getInputTextbackgroundColor() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING BACK GROUND COLOR OF INPUT TEXT ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtDescriptiveText, waitTime);
            strResult = txtDescriptiveText.getAttribute(CLASS);
            if (strResult.equalsIgnoreCase(REQUIRED))
                strResult = YELLOW;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET BACK GROUND COLOR OF INPUT TEXT" + "\nMETHOD:getInputTextbackgroundColor" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to check whether descriptive text Present on Top of Left Side
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if descriptive text Present Top Left Side else returns false
     * @throws Exception
     */
    public boolean isDescriptiveTextPresentTopLeftSide() throws Exception {
        flag = false;
        strResult = null;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX IS RIGHT OF DESCRIPTIVE TEXT LABEL.");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + descriptiveTextRight);
            strLocation2 = uiDriver.executeScript("return document.getElementById" + textBoxLeft);
            if (Integer.parseInt(strLocation1) < (int) Double.parseDouble(strLocation2)) {
                logInstruction("LOG INSTRUCTION: DESCRIPTIVE TEXT PRESENT AT LEFT SIDE...CHECKING FOR TOP");
                strResult = lblDescriptiveTextAlign.getAttribute(VALIGN);
                if (strResult.equalsIgnoreCase(TOP)) {
                    logInstruction("LOG INSTRUCTION: DESCRIPTIVE TEXT PRESENT TOP LEFT SIDE");
                    flag = true;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER TEXTBOX IS RIGHT OF DESCRIPTIVE TEXT LABEL" + "\nMETHOD:isDescriptiveTextPresentTopLeftSide" + e
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
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FOLDER ICON DISPLAYED LEFT SIDE  ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            if (StringUtils.isNotBlank(strFolderName)) {
                lstIconFolders = iconFolder.getUIElementsList();
                for (UIElement uiElement : lstIconFolders) {
                    if (uiElement.getText().equalsIgnoreCase(strFolderName))
                        flag = true;
                }
            } else { 
                logInstruction("LOG INSTRUCTION:FOLDER NAME IS BLANK");
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER FOLDER ICON DISPLAYED LEFT SIDE" + "\nMETHOD:isFolderIconDisplayedLeftSide" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether New folder is at last in structure
     * 
     * @category Milestone 2
     * @author Chaitali
     * @return boolean true if New Folder is at last in structure false otherwise
     * @throws Exception
     */
    public boolean isNewFolderAtLastInStructure() throws Exception {
        flag = false;
        strResult = null;

        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER NEW FOLDER IS AT LAST IN STRUCTURE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            lstFolders = iconFolder.getUIElementsList();
            size = lstFolders.size();
            lastFolder = lstFolders.get(size - 1);
            strResult = lastFolder.getText();
            String arr[] = strResult.split(":");
            strResult = arr[0];
            if (strResult.equalsIgnoreCase(NEW_FOLDER)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER NEW FOLDER IS AT LAST IN STRUCTURE" + "\nMETHOD:isNewFolderAtLastInStructure" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get the first note
     * "Once you click Insert Image and your file begins to upload, please refrain from closing the browser or navigating away from this page. The screen will refresh when the file has uploaded successfully."
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
            throw new Exception("UNABLE TO GET NOTE1" + "\nMETHOD:getFirstNote" + e
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
            throw new Exception("UNABLE TO GET NOTE 2" + "\nMETHOD:getSecondNote" + e
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
                    "UNABLE TO GET ERROR MESSAGE" + "\nMETHOD:getInlineErrorMessage" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to click on Select Image From Course Folder Link
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardSelectImagePage clickOnSelectImageFromCourseFolderLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON SELECT IMAGE FROM COURSE FOLDER LINK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkSelectImageFromCourseFolder, waitTime);
            lnkSelectImageFromCourseFolder.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON SELECTIMAGEFROMCOURSEFOLDER LINK" + "\nMETHOD:clickOnSelectImageFromCourseFolderLink" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardSelectImagePage(uiDriver);

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
            if (StringUtils.isNotBlank(strFolderName)) {
                radButton.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(radButton, waitTime);
                flag = radButton.isDisplayedAfterWaiting();
            } else
                logInstruction("LOG INSTRUCTION : PROVIED FOLDER NAME IS NULL");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS DISPLAYED IN FRONT OF FOLDER" + "\nMETHOD:isRadioButtonDisplayedInFrontOfFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click radio button for a folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return {@link LinkWizardUploadImagePage}
     * @throws Exception
     */
    public LinkWizardUploadImagePage clickRadioButtonDisplayedInFrontOfFolder(String strFolderName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF  FOLDER");
            frameSwitch.switchToAddLinkFrame();
            radButton.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(radButton, waitTime);

            if (!radButton.isSelected())
                radButton.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK RADIO BUTTON IN FRONT OF  FOLDER" + "\nMETHOD:clickRadioButtonDisplayedInFrontOfFolder" + e
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
            radButtonSubFolder.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(radButtonSubFolder, waitTime);
            flag = radButtonSubFolder.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS DISPLAYED IN FRONT OF SUB FOLDER" + "\nMETHOD:isRadioButtonDisplayedInFrontOfSubFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click radio button for a sub folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return {@link LinkWizardUploadImagePage}
     * @throws Exception
     */
    public LinkWizardUploadImagePage clickRadioButtonDisplayedInFrontOfSubFolder(
            String strFolderName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF SUB  FOLDER");
            frameSwitch.switchToAddLinkFrame();
            radButtonSubFolder.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(radButtonSubFolder, waitTime);

            if (!radButton.isSelected())
                radButton.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK RADIO BUTTON IN FRONT OF SUB  FOLDER" + "\nMETHOD:clickRadioButtonDisplayedInFrontOfSubFolder" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if focus is on descriptive field
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isFocusOnDescriptiveTextField() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF FOCUS IS ON DESCRIPTIVE FIELD ");
            frameSwitch.switchToAddLinkFrame();
            Point point = uiDriver.switchTo().activeElement().getLocation();
            if (point.x == txtDescriptiveText.getLocation().x && point.y == txtDescriptiveText
                    .getLocation().y) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON DESCRIPTIVE FIELD" + "\nMETHOD:isFocusOnDescriptiveTextField" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to type content in the New Folder text field
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadImagePage
     * @throws Exception
     * 
     */
    public LinkWizardUploadImagePage enterNewFolderName(String strFolderName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : TYPE TEXT IN NEW FOLDER FIELD ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtNewFolderName, waitTime);
            txtNewFolderName.clearAndSendKeys(strFolderName);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO TYPE  TEXT IN NEW FOLDER FIELD" + "\nMETHOD:enterNewFolderName" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get Root Folder Name
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getRootFolderName() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : THIS METHOD IS USED TO GET ROOT FOLDER NAME ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblRootFolderName, waitTime);
            strResult = lblRootFolderName.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ROOT FOLDER NAME" + "\nMETHOD:getRootFolderName" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to get the Instructional Text
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getInstructionalText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET INSTRUCTIONAL TEXT ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblInstructionalText, waitTime);
            strResult = lblInstructionalText.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET INSTRUCTIONAL TEXT" + "\nMETHOD:getInstructionalText" + e
                            .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to upload a file
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadImagePage clickBrowse() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : UPLOAD FILE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtFileToUpload, waitTime);
            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowze.clickByJavascript();
            } else
                btnBrowze.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO UPLOAD THE FILE" + "\nMETHOD:clickBrowse" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if the browse button is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public boolean isBrowseButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE BROWSE BUTTON IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtFileToUpload, waitTime);
            flag = txtFileToUpload.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE BROWSE BUTTON IS DISPLAYED" + "\nMETHOD:isBrowseButtonDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Upload Image Tab is selected
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUploadImageTabSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE UPLOAD IMAGE TAB  IS SELECTED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkUploadImage, waitTime);
            flag = lnkUploadImage.getAttribute(CLASS).contains(SELECTED);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE  UPLOAD IMAGE TAB IS SELECTED" + "\nMETHOD:isUploadImageTabSelected" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Upload Image Tab is present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUploadImageTabPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE UPLOAD IMAGE TAB  IS PRESENT");
            frameSwitch.switchToAddLinkFrame();
            // uiDriver.waitToBeDisplayed(lnkUploadImage, waitTime);
            flag = lnkUploadImage.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE  UPLOAD IMAGE TAB IS PRESENT" + "\nMETHOD:isUploadImageTabPresent" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Select Image From Course Folder Link Is Present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isSelectImageFromCourseFolderLinkPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE SELECT IMAGE FROM COURSE FOLDER LINK IS PRESENT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkSelectImageFromCourseFolder, waitTime);
            flag = lnkSelectImageFromCourseFolder.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE SELECT IMAGE FROM COURSE FOLDER LINK IS PRESENT" + "\nMETHOD:isSelectImageFromCourseFolderLinkPresent" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if radio button is selected in front of a sub folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonSelectedInFrontOfSubFolder(String strSubFolderName)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF RADIO BUTTON IS SELECTED IN FRONT OF SUB FOLDER ");
            frameSwitch.switchToAddLinkFrame();
            radButtonSubFolder.replaceValues(strSubFolderName);
            uiDriver.waitToBeDisplayed(radButtonSubFolder, waitTime);
            flag = radButtonSubFolder.isSelected();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS SELECTED IN FRONT OF SUB FOLDER" + "\nMETHOD:isRadioButtonSelectedInFrontOfSubFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if radio button is selected in front of a folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonSelectedInFrontOfFolder(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF RADIO BUTTON IS SELECTED IN FRONT OF FOLDER");
            frameSwitch.switchToAddLinkFrame();
            radButton.replaceValues(strFolderName);
            uiDriver.waitToBeDisplayed(radButton, waitTime);
            if (radButton.isSelected())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS SELECTED IN FRONT OF FOLDER" + "\nMETHOD:isRadioButtonSelectedInFrontOfFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click add link when mandatory fields are blank
     * 
     * @category Milestone 2
     * @author monica.anand
     * @throws Exception
     * 
     */
    public String clickAddLinkWhenMandatoryFieldsAreBlank() throws Exception {
        strResult = null;
        try {
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            btnInsertImage.clickAndWait(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                strResult = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
            } else {
                strResult = lblInlineError.getText();
            }            
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADD LINK  BUTTON" + "\nMETHOD:clickAddLinkWhenMandatoryFieldsAreBlank" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * method help to click Browse Button For IE Browser
     * 
     * @author Vivek.Singh
     * @return LinkWizardUploadContentPage
     * @throws Exception
     */
    public LinkWizardUploadImagePage clickBrowse(String strAbsoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowze, waitTime);
            btnBrowze.sendKeysToFileInput(strAbsoluteFilePath);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON THE BROWSE BUTTON" + "\nMETHOD:clickBrowse" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on Root folder
     * 
     * @category Milestone 2
     * @author Praveen.Maled
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public LinkWizardUploadImagePage selectRadioButtonRootFolder() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK RADIO BUTTON ROOT FOLDER");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(radMainFolder, waitTime);
            if (!radMainFolder.isSelected())
                radMainFolder.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON RADIO BUTTON OF ROOT FOLDER" + "\nMETHOD:selectRadioButtonRootFolder" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Purpose: to get the the value of text field
     * 
     * @author Bharat.Goel
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getDescriptiveTextFieldText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING DESCRIPTIVE TEXT");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtDescriptiveText.getValue();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET TEXT " + "\nMETHOD:getDescriptiveTextFieldText" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Purpose: to get the the value(Name) of new folder
     * 
     * @author Bharat.Goel
     * @return String
     * @throws Exception
     */
    public String getNewFolderTextFieldText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING NEW FOLDER NAME");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtNewFolderName.getValue();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET TEXT " + "\nMETHOD:getNewFolderTextFieldText" + e
                    .getLocalizedMessage());
        }
        return strResult;
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
            logInstruction("LOG INSTRUCTION: VEIFYING FOLDER STRUCTURE TO DISPLAY IS INSIDE DISPLAYED");
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
                    "UNABLE TO LOCATE FOLDER STRUCTURE" + "\nMETHOD:isFolder2InsideFolder1Disp" + e
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
            logInstruction("LOG INSTRUCTION: VEIFYING FOLDER STRUCTURE TO DISPLAY IS UNDER DISPLAYED");
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
                    "UNABLE TO LOCATE FOLDER STRUCTURE" + "\nMETHOD:isFolder2UnderFolder1Disp" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether instructional text is present below Desc field
     * 
     * @author Bharat.Goel
     * @return boolean
     * 
     * @throws Exception
     * @param instxt
     * @category Milestone 2
     */
    public boolean isInstructionalTextBelowDescField(String strInsText) throws Exception {
        flag = false;
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY WHETHER INSTRUCTIONAL TEXT IS PRESENT BELOW DESC FIELD");
            frameSwitch.switchToAddLinkFrame();
            lblInsTxtDescFld.waitToBePresent(waitTime);
            strResult = lblInsTxtDescFld.getText();
            if (strResult.equalsIgnoreCase(strInsText))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY WHETHER INSTRUCTIONAL TEXT IS PRESENT BELOW DESC FIELD" + "\nMETHOD:isInstructionalTextBelowDescField" + e
                            .getLocalizedMessage());
        }


        return flag;

    }

    /*
     * This method helps to click on the insert image button
     * 
     * @author:ashish.juyal
     * 
     * @throws:Exception
     */
    public void clickInsertImage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING THE INSERT IMAGE BUTTON");

            frameSwitch.switchToAddLinkFrame();

            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            btnInsertImage.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Insert Image' BUTTON" + "\n METHOD:clickInsertImage:\n" + e
                            .getLocalizedMessage());
        }
    }
    
    /**
     * Method will create add text to be displayed, upload's file and selects the specified folder
     * or add new folder name if it's not null
     * 
     * @author Praveen.Maled
     * @param strDescriptiveText
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
    public String createUploadImage(
            String strDescriptiveText,
            boolean flagRootFolder,
            boolean flagSubFolder,
            String strFolderToSelect,
            String strNewFoldername,
            String strRelativeFilePath,
            String strAction,
            String strTag,
    		boolean flagRenameFile) throws Exception {
    	try {
            if (StringUtils.isNotBlank(strDescriptiveText) && StringUtils
                    .isNotBlank(strRelativeFilePath) && StringUtils.isNotBlank(strAction)) {
    			frameSwitch.switchToAddLinkFrame();
    			logInstruction("LOG INSTRUCTION: ENTERING TEXT TO DISLAY METHOD");
    			uiDriver.waitToBeDisplayed(txtDescriptivetext, waitTime);
    			txtDescriptivetext.clearAndSendKeys(strDescriptiveText);
                uploadFileHandler(strRelativeFilePath, strAction, strTag, flagRenameFile);
    			uiDriver.getUIAlert().acceptAlertIfPresent();
    			if(flagRootFolder){
    				logInstruction("LOG INSTRUCTION : CLICK RADIO BUTTON ROOT FOLDER");
    	            if (!radMainFolder.isSelected())
    	                radMainFolder.clickNoWait();
                } else
                    if (flagSubFolder && StringUtils.isNotBlank(strFolderToSelect)) {
    				logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF SUB  FOLDER");
    				radButtonSubFolder.replaceValues(strFolderToSelect);
    				 if (!radButtonSubFolder.isSelected())
    					 radButtonSubFolder.clickNoWait();
                    } else
                        if (StringUtils.isNotBlank(strFolderToSelect)) {
    				logInstruction("LOG INSTRUCTION : CLICK  RADIO BUTTON IN FRONT OF  FOLDER");
    				 radButton.replaceValues(strFolderToSelect);
    		            if (!radButton.isSelected())
    		                radButton.clickNoWait();

    			}
    			if(StringUtils.isNotBlank(strNewFoldername)){
    				logInstruction("LOG INSTRUCTION : TYPE TEXT IN NEW FOLDER FIELD ");
    				txtNewFolderName.clearAndSendKeys(strNewFoldername);
    			}
    			 btnInsertImage.clickAndWait(waitTime);
    			uiDriver.getUIWindowLocator().switchToFirstWindow();
    		}else//if(StringUtils.isNotBlank(strTextToBeDisplay) && StringUtils.isNotBlank(strFilePath) && StringUtils.isNotBlank(strAction))
                throw new Exception(
                        "EITHER 'strDescriptiveText' OR 'strFilePath' OR 'strAction' IS NULL" + "\nMETHOD:createUploadImage\n");

    	} catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING UPLOAD CONTENT LINK \n METHOD : createUploadImage\n" + e
    				.getLocalizedMessage());
    	}
    	return strFileName;
    }
    
    
    /**
     * Method helps to upload the file, based on the parameters file will be renamed and time stamp will append with the file name
     * 
     * @param strRelativeFilePath
     * @param strAction
     * @param strTag
     * @param strRenameFile
     * @param upload
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */
    public LinkWizardUploadImagePage uploadFileHandler(
            String strRelativeFilePath,
            String strAction,
            String strTag,
            boolean strRenameFile) throws Exception {
    	try {
            objAutoITMethods = new AutoITMethods();
        if (getBrowser().equals(Browser.FIREFOX)||getBrowser().equals(Browser.CHROME)) {
            clickBrowse();
                strFileName = objAutoITMethods.uploadFile(
                        strRelativeFilePath,
                        strAction,
                        strTag,
                        strRenameFile);
        }  else
                if (getBrowser().equals(Browser.INTERNETEXPLORER)) {

                    strResult = this.getClass().getResource(strRelativeFilePath).toString();
                    strResult = strResult.split("file:/")[1];
                    if (strRenameFile) {
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
                    "ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading Link Wizard Image File'" + "\n METHOD: uploadFileHandler \n" + e
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
     * This method helps to VERIFYING TEXTBOX NEXT TO THE LABEL FILE TO UPLOAD
     * 
     * @author:bharat.goel
     * @Milestone-2
     * @throws:Exception
     */
    public boolean IsTextboxNextToTheLabelFileToUpload() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING TEXTBOX NEXT TO THE LABEL FILE TO UPLOAD");
            frameSwitch.switchToAddLinkFrame();
            txtBoxFileUpload.waitToBeDisplayed(waitTime);
            flag = txtBoxFileUpload.isDisplayedAfterWaiting(waitTime);
            		
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING TEXTBOX NEXT TO THE LABEL FILE TO UPLOAD " + "\nMETHOD: IsTextboxNextToTheLabelFileToUpload:\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
   
    /*
     * This method helps to VERIFYING WHETHER MUSICAL FOLDER ICON DISPLAYED ON LEFT SIDE OF STREAMING MEDIA 
     * 
     * @author:bharat.goel
     * @Milestone-2
     * @throws:Exception
     */
    public boolean isMusicalFolderIconDisplayedOnLeftSideStreamingMedia() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER MUSICAL FOLDER ICON DISPLAYED ON LEFT SIDE OF STREAMING MEDIA  ");
            frameSwitch.switchToAddLinkFrame();
            iconMusicalFolder.waitToBeDisplayed(waitTime);
            flag = iconMusicalFolder.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER:MUSICAL FOLDER ICON IS NOT DISPLAYED ON LEFT SIDE STREAMING MEDIA  " + "\nMETHOD: isMusicalFolderIconDisplayedOnLeftSideStreamingMedia:\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    
    }
    /*
     * This method helps to VERIFYING BACK INSERT CANCEL BUTTON ARE IN ORDER
     * 
     * @author:bharat.goel
     * @Milestone-2
     * @throws:Exception
     */
    public boolean isBackInsertCancelAreInOrder() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING BACK INSERT CANCEL BUTTON ARE IN ORDER");
            frameSwitch.switchToAddLinkFrame();
            btnBack.waitToBeDisplayed(waitTime);
            btnCancel.waitToBeDisplayed(waitTime);
            btnInsertImage.waitToBeDisplayed(waitTime);
            if (btnBack.getLocation().x < btnInsertImage.getLocation().x && btnInsertImage
                    .getLocation().x < btnCancel.getLocation().x) {
            	flag= true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING BACK INSERT CANCEL BUTTON ARE IN ORDER " + "\nMETHOD: isBackInsertCancelAreInOrder:\n" + e
                            .getLocalizedMessage());
        }
        return flag;
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
    public LinkWizardUploadImagePage enterInvalidPath(String strInvalidPath) throws Exception {
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
