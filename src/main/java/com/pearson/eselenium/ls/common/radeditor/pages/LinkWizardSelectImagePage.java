package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * 
 * This is the Page Object for Select Image Screen
 * 
 * @author usha
 */
public class LinkWizardSelectImagePage extends BasePageObject {

    /* Elements */
    private UIElement lbLinkWizardSelectImageTab = createElement(UIType.Css, ".notselectedG>a");
    private UIElement btnRadio = createElement(
            UIType.Xpath,
            "//table[@role='presentation']//tbody//tr[td[4]//label//a[contains(text(),'{1}')]]//input");
    private UIElement lbTitle = createElement(UIType.Css, "div.tablehead");
    private UIElement txtDescriptiveText = createElement(UIType.Css, "input#linkTitle");
    private UIElement btnBack = createElement(UIType.Xpath, "//input[@value='< Back']");
    private UIElement btnInsertImage = createElement(UIType.Xpath, "//input[@value='Insert Image']");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[@value='Cancel']");
    private UIElement selectfolder = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement lnkSelectImage = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Select Image from Course Folder')]");
    private UIElement lnkradSelectFile = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]/parent::label/parent::td/preceding-sibling::td[@width='21']/input[@type='radio']");
    private UIElements lstFileNameList = createElements(UIType.Xpath, "//label");
    private UIElement lnkUp = createElement(
            UIType.Xpath,
            "//span[@class='screen_readers_only']/parent::a");
    private UIElement imgUp = createElement(
            UIType.Xpath,
            "//img[@alt='Up to Content/parent Folder']");
    private UIElement lblInstruction = createElement(
            UIType.Xpath,
            "//span[@class='redtext']/parent::td");
    private UIElement imgFolder = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]/parent::td/preceding-sibling::td/img[contains(@src,'.gif')]");
    private UIElement lblDescriptiveText = createElement(UIType.Xpath, "//td[@width='150']//label");
    private UIElements lblInstructionMessages = createElements(
            UIType.Xpath,
            "//span[@class='redtext']/parent::td");
    private UIElement imgRootFolder = createElement(
            UIType.Xpath,
            "//td[contains(text(),'{1}')]/preceding-sibling::td/img");
    private UIElements lblFolderNames = createElements(
            UIType.Xpath,
            "//input[@type='radio']/parent::td/following-sibling::td[@width='*']");
    private UIElement lnkUploadImage = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Upload Image')]");
    private UIElements lstFolders = createElements(UIType.Xpath, "//a[@href='#']");
    private UIElement lblInlineError = createElement(UIType.Xpath, "//td[@class='inlineerror']");

    private UIElement lblInsTxtDescFld = createElement(
            UIType.Xpath,
            "//td[@class='tabcontenttable']//tr[2]/td[2]");
    private UIElement imgStreamingMedia = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'Streaming Media')]]/preceding-sibling::td/img");
    private UIElements radFileNames = createElements(UIType.Xpath, "//input[@type='radio']");
    
	/*Constants*/
	private static final String FRAMEHEADING = "('tablehead')[0].getBoundingClientRect().bottom";
    private static final String DESCRIPTIVELABELTOP = "('label')[0].getBoundingClientRect().top";
    private static final String DESCRIPTIVELABELRIGHT = "('label')[0].getBoundingClientRect().right";
    private static final String DESCRIPTIVETEXBOXLEFT = "('linkTitle').getBoundingClientRect().left";
    private static final String FOLDERSTRUCTURE = "('table')[5].getBoundingClientRect().left";
    private static final String IMAGETOINSERTLABEL = "('td')[11].getBoundingClientRect().right";
    private static final String SRC = "src";
    private static final String OPENFOLDER = "openfolder";
    private static final String ONCLICK = "onclick";
    private static final String ONCLICKTXT = "OnClick";
    private static final String CLOSEDFOLDER = "closedfolder";
    private static final String CLASS = "class";
    private static final String SELECTED = "selected";
    private static final String REQUIRED = "required";
    private static final String YELLOW = "yellow";
    private String strResult = null;
    private String strLocation1 = null;
    private String strLocation2 = null;
    private boolean flag = false;
    List<UIElement> lstfolderListElement = new ArrayList<UIElement>();
    List<UIElement> lstFolderNames = new ArrayList<UIElement>();
    List<UIElement> lstFolderNames2 = new ArrayList<UIElement>();
    List<UIElement> lstOfFolders = new ArrayList<UIElement>();
    List<String> lstOfFolderNames = new ArrayList<String>();
    List<String> lstNewListOfFolderNames = new ArrayList<String>();
    List<UIElement> lstFileNames2 = new ArrayList<UIElement>();
    List<UIElement> lstMessages = new ArrayList<UIElement>();

    /* Constructor */
    public LinkWizardSelectImagePage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkWizardSelectImagePage";
        logInstruction("LOG INSTRUCTION: ## LinkWizardSelectImage ##");
    }

    /**
     * Method helps to switch to add to link page
     * 
     * @author Usha
     * @return LinkWizardSelectImagePage
     * @throws Exception
     */
    public LinkWizardSelectImagePage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO ADDLINK PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH THE WINDOW" + " \nMETHOD:switchToAddLinkPage " + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter the DescriptiveText
     * 
     * @author Usha
     * @param text
     * @return LinkWizardSelectImagePage
     * @throws Exception
     */
    public LinkWizardSelectImagePage enterDescriptiveText(String strText) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE WEBSITE TEXT TO DISPLAY");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtDescriptiveText, waitTime);
            txtDescriptiveText.clearAndSendKeys(strText);
            logInstruction("LOG INSTRUCTION: DESCRIPTIVE TEXT IS ENTERED ");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER DESCRIPTIVE TEXT  " + " \nMETHOD: enterDescriptiveText" + e
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

            logInstruction("LOG INSTRUCTION: CLICK ON BACKBUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnBack.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON BACK BUTTON " + " \nMETHOD: clickBack" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * Method helps to click on Cancel
     * 
     * @author Usha
     * 
     * @throws Exception
     */
    public void clickCancel() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON CANCEL BUTTON" + " \nMETHOD:clickCancel " + e
                    .getLocalizedMessage());
        }

    }

    /**
     * method helps to click on the AddLink button
     * 
     * @author Usha
     * 
     * @throws Exception
     */
    public void clickAddLink() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON ADDLINK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnInsertImage.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
            // uiDriver.switchTo().window(windows.get(0));

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ADDLINK BUTTON" + " \nMETHOD:clickAddLink " + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Method helps to click on LinkWizardSelectImage tab
     * 
     * @author Usha
     * @return LinkWizardSelectImagePage
     * @throws Exception
     */

    public LinkWizardSelectImagePage clickLinkWizardSelectImageTab() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON LINKWIZARDSELECTIMAGE TAB");
            frameSwitch.switchToAddLinkFrame();
            lbLinkWizardSelectImageTab.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LINKWIZARDSELECTIMAGE TAB " + " \nMETHOD:clickLinkWizardSelectImageTab " + e
                            .getLocalizedMessage());
        }
        return this;
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
            logInstruction("LOG INSTRUCTION: VERIFY LINKWIZARDSELECTIMAGEPAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lbTitle, waitTime);
            strResult = lbTitle.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LINKWIZARDUPLOADIMAGEPAGE TITLE " + " \nMETHOD: getLinkWizardUploadImagePageTitle" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to click on radio button
     * 
     * @author usha
     * @param linkto
     * @return LinkWizardSelectImagePage
     * @throws Exception
     */

    public LinkWizardSelectImagePage selectRadioButton(String strLinkto) throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: SELECT RADIO BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            btnRadio.replaceValues(strLinkto);
            btnRadio.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON " + " \nMETHOD: selectRadioButton" + e
                    .getLocalizedMessage());

        }

        return this;

    }

    /**
     * This Function will Select the Folder
     * 
     * @param name
     *            Name of the folder
     * @return LinkWizardSelectImagePage
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public LinkWizardSelectImagePage selectFolder(String strName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELCTING THE FOLDER");
            frameSwitch.switchToAddLinkFrame();
            selectfolder.replaceValues(strName);
            uiDriver.waitToBeDisplayed(selectfolder, waitTime);
            selectfolder.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: UNABLE TO GET THE FOLDER " + " \nMETHOD:  selectFolder");
        }
        return this;
    }

    /**
     * This method is used to check if the SelectImageFromCourseFolderLink is selected
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isSelectImageFromCourseFolderLinkSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE SELECTIMAGEFROMCOURSEFOLDERLINK IS SELECTED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkSelectImage, waitTime);
            flag = lnkSelectImage.getAttribute(CLASS).contains(SELECTED);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE SELECTIMAGE FROM COURSE FOLDER LINK IS SELECTED " + " \nMETHOD: isSelectImageFromCourseFolderLinkSelected" + e
                            .getLocalizedMessage());
        }
        return flag;
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
                    "UNABLE TO CHECK  IF FOCUS IS ON DESCRIPTIVE FIELD " + " \nMETHOD: isFocusOnDescriptiveTextField" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click on a file
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardSelectImagePage
     * @throws Exception
     */
    public LinkWizardSelectImagePage selectFileToUpload(String strFileName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : METHOD TO SELECT A FILE TO BE UPLOADED ");
            frameSwitch.switchToAddLinkFrame();
            lnkradSelectFile.replaceValues(strFileName);
            uiDriver.waitToBeDisplayed(lnkradSelectFile, waitTime);
            lnkradSelectFile.clickNoWait();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE FILE TO BE UPLOADED " + " \nMETHOD: selectFileToUpload" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if a particular file is present
     * 
     * @category Milestone 2
     * @author monica.anand
     * @param fileName
     * @return boolean
     * @throws Exception
     */
    public boolean isFileDisplayed(String strFileName) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION : CHECKING IF FILE  IS PRESENT ");
            frameSwitch.switchToAddLinkFrame();
            lstfolderListElement = lstFileNameList.getUIElementsList();
            for (int i = 0; i < lstfolderListElement.size(); i++) {
                if (lstfolderListElement.get(i).getText().contains(strFileName)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF FILE IS PRESENT " + " \nMETHOD:isFileDisplayed " + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the radio button is present for a file
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isRadioButtonPresent(String strFileName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF A RADIO BUTTON IS PRESENT FOR A FILE");
            frameSwitch.switchToAddLinkFrame();
            lnkradSelectFile.replaceValues(strFileName);
            flag = lnkradSelectFile.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF RADIO BUTTON IS PRESENT FOR A FILE " + " \nMETHOD: isRadioButtonPresent" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to check if the up link is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUplinkDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF UP LINK IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            flag = lnkUp.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF UP LINK IS DISPLAYED " + " \nMETHOD: isUplinkDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the up link icon is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isUplinkIconDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF UP LINK ICON  IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(imgUp, waitTime);
            flag = imgUp.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF UP LINK ICON IS DISPLAYED " + " \nMETHOD: isUplinkIconDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click on up link
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public LinkWizardSelectImagePage clickOnUpLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CLICK ON UP LINK");
            frameSwitch.switchToAddLinkFrame();

            if (lnkUp.isDisplayedAfterWaiting(waitTime))
                lnkUp.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON  UP LINK " + " \nMETHOD:  clickOnUpLink" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if the Back Button Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isBackButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE BACK BUTTON   IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            flag = btnBack.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE BACK BUTTON  IS DISPLAYED " + " \nMETHOD: isBackButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Insert Image Button Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isInsertImageButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE INSERT IMAGE BUTTON   IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            flag = btnInsertImage.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE INSERT IMAGE BUTTON  IS DISPLAYED " + " \nMETHOD: isInsertImageButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Insert Image Button Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE CANCEL BUTTON   IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE CANCEL BUTTON  IS DISPLAYED " + " \nMETHOD: isCancelButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the instructional text message is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isInstructionalTextDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF INSTRUCTIONAL TEXT MESSAGE IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblInstruction, waitTime);
            flag = lblInstruction.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF INSTRUCTIONAL TEXT MESSAGE IS DISPLAYED " + " \nMETHOD:  isInstructionalTextDisplayed" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method is used to check if the folder name is clickable
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFolderClickable(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER NAME IS CLICKABLE");
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToAddLinkFrame();
                selectfolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(selectfolder, waitTime);
                if (selectfolder.getAttribute(ONCLICK).contains(ONCLICKTXT)) {
                    flag = true;
                }
            } else
                // if(StringUtils.isNotBlank(folderName))
                throw new Exception("PROVIDED FOLDER NAME IS NULL");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER NAME IS CLICKABLE " + " \nMETHOD: isFolderClickable" + e
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
            } else
                // if(StringUtils.isNotBlank(folderName))
                throw new Exception("PROVIDED FOLDER NAME IS NULL");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER IS DISPLAYED " + " \nMETHOD:isFolderDisplayed" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method is used to check if the Label Descriptive Text Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isLabelDescriptiveTextDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF LABEL DESCRIPTIVE TEXT IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblDescriptiveText, waitTime);
            flag = lblDescriptiveText.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF LABEL DESCRIPTIVE TEXT IS DISPLAYED " + " \nMETHOD: isLabelDescriptiveTextDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Descriptive Text field Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isTextBoxForDescriptiveTextDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF TEXT BOX FOR  DESCRIPTIVE TEXT IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtDescriptiveText, waitTime);
            flag = txtDescriptiveText.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF TEXT BOX DESCRIPTIVE TEXT IS DISPLAYED " + " \nMETHOD: isTextBoxForDescriptiveTextDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get background color Of Descriptive Text
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     */

    public String getBackGroundColorOfDescriptiveText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET BACK GROUND COLOR OF 'TEXT TO DISPLAY' FIELD");
            frameSwitch.switchToAddLinkFrame();
            if (REQUIRED.equalsIgnoreCase(txtDescriptiveText.getAttribute(CLASS)))
                strResult = YELLOW;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND BACK GROUND COLOR OF 'TEXT TO DISPLAY " + " \nMETHOD: getBackGroundColorOfDescriptiveText' " + e
                            .getLocalizedMessage());

        }
        return strResult;

    }

    /**
     * This method is used to get instructional text
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getInstructionalTextDisplayed() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO GET INSTRUCTIONAL ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblInstruction, waitTime);
            strResult = lblInstruction.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF INSTRUCTIONAL TEXT MESSAGE IS DISPLAYED " + " \nMETHOD:  getInstructionalTextDisplayed" + e
                            .getLocalizedMessage());
        }

        return strResult;
    }

    /**
     * This method is used to check if the Label Image To Insert Is Displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isLabelImagetoInsertDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF  LABEL IMAGE TO INSERT IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            flag = btnInsertImage.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "uNABLE TO CHECK  LABEL IMAGE TO INSERT IS DISPLAYED " + " \nMETHOD: isLabelImagetoInsertDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if a particular instruction message is getting displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @param message
     * @return boolean
     * @throws Exception
     */
    public boolean isInstructionalTextDisplayed(String strMessage) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION : CHECKING IF AN INSTRUCTION MESSAGE IS PRESENT");
            frameSwitch.switchToAddLinkFrame();
            lstMessages = lblInstructionMessages.getUIElementsList();
            for (int i = 0; i < lstMessages.size(); i++) {
                if (lstMessages.get(i).getText().contains(strMessage)) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF AN INSTRUCTION MESSAGE IS PRESENT " + " \nMETHOD:  isInstructionalTextDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the Folder Icon is displayed for root folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isFolderIconDisplayedForRootFolder(String strRootFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER ICON IS DISPLAYED FOR ROOT FOLDER");
            frameSwitch.switchToAddLinkFrame();
            imgRootFolder.replaceValues(strRootFolderName);
            uiDriver.waitToBeDisplayed(imgRootFolder, waitTime);
            flag = imgRootFolder.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER ICON IS DISPLAYED FOR ROOT FOLDER " + " \nMETHOD: isFolderIconDisplayedForRootFolder" + e
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
            for (int i = 0; i < lstFolderNames.size(); i++) {
                strResult = lstFolderNames.get(0).getText();
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ROOT FOLDER NAME " + " \nMETHOD: getNameOfRootFolder" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check if a folder name is displayed
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isFolderNameDisplayed(String strFolderName) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION : CHECK IF FOLDER NAME IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            lstFolderNames2 = lblFolderNames.getUIElementsList();
            for (int i = 0; i < lstFolderNames2.size(); i++) {
                if (lstFolderNames2.get(i).getText().contains(strFolderName)) {
                    flag = true;
                    break;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOLDER NAME " + " \nMETHOD: isFolderNameDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods helps to click on Upload Image
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return LinkWizardUploadImagePage
     * @throws Exception
     */

    public LinkWizardUploadImagePage clickOnUploadImageLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON UPLOAD IMAGE LINK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkUploadImage, waitTime);
            lnkUploadImage.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON UPLOAD IMAGE LINK " + " \nMETHOD:clickOnUploadImageLink " + e
                            .getLocalizedMessage());
        }
        return new LinkWizardUploadImagePage(uiDriver);

    }

    /**
     * Method helps to check whether label Label Descriptive Text is displayed towards top
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isLabelDescriptiveTextDisplayedTowardsTop() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABELDESCRIPTIVETEXT IS DISPLAYED TOWARDS TOP");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkUploadImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByClassName" + FRAMEHEADING);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + DESCRIPTIVELABELTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF LABELDESCRIPTIVETEXT IS DISPLAYED TOWARDS TOP." + " \n METHOD :isLabelDescriptiveTextDisplayedTowardsTop \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * Method helps to check whether textbox is right of Descriptive Text label
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true label false otherwise
     * @throws Exception
     */

    public boolean isTextBoxRightToDescriptiveTextLabel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXTBOX IS RIGHT OF LABEL DESCRIPTIVE TEXT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkUploadImage, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + DESCRIPTIVELABELRIGHT);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + DESCRIPTIVETEXBOXLEFT);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  TEXTBOX IS RIGHT OF LABEL DESCRIPTIVE TEXT." + " \n METHOD :isTextBoxRightToDescriptiveTextLabel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether folder names are alphanumerically sorted or not.
     * 
     * @author monica.anand
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFoldersSortedAlphaNumerically() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR SORTED LIST OF FOLDERS.");
            frameSwitch.switchToAddLinkFrame();
            lstOfFolders = lstFolders.getUIElementsList().subList(
                    2,
                    lstFolders.getUIElementsList().size() - 1);
            for (UIElement uiElement : lstOfFolders) {
                lstOfFolderNames.add(uiElement.getText());

            }
            lstNewListOfFolderNames = lstOfFolderNames;
            Collections.sort(lstOfFolderNames);
            flag = lstOfFolderNames.equals(lstNewListOfFolderNames);
        } catch (Exception e) {
            throw new Exception(
                    "FOLDERS ARE NOT SORTED ALPHANUMERICALLY" + "\n METHOD:isFoldersSortedAlphaNumerically \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Folder Structure Is Displayed On Right Side Of Image To Insert
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isFolderStructureDisplayedOnRightSideOfImageToInsert() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER FOLDER STRUCTURE IS  DISPLAYED ON RIGHT SIDE OF IMAGE TO INSERT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblDescriptiveText, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + FOLDERSTRUCTURE);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + IMAGETOINSERTLABEL);
            if ((int) Double.parseDouble(strLocation1) > (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "FOLDER STRUCTURE IS NOT DISPLAYED ON RIGHT SIDE OF IMAGE TO INSERT" + "\n METHOD:isFolderStructureDisplayedOnRightSideOfImageToInsert \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Purpose: to get the the value of text field
     * 
     * @author Bharat.Goel
     * @return String
     * @category Milestone-2
     * @throws Exception
     */
    public String getDescriptiveTextFieldText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING DESCRIPTIVE TEXT");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtDescriptiveText.getValue();
        } catch (Exception e) {
            
            throw new Exception("UNABLE TO GET TEXT " + " \nMETHOD:getDescriptiveTextFieldText" + e
                    .getLocalizedMessage());
        }
        return strResult;

    }

    /***
     * Method helps to verify the existence of the alert
     * 
     * @category Milestone-2
     * @return boolean
     * @author Bharat.goel
     */
    public boolean isAlertPresent() {
        flag = true;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING FOR ALERT");
            uiDriver.switchTo().alert();
        } 
        catch (Exception Ex) {
            flag = false;
        } 
        return flag;
    }

    /**
     * This method is used to click add link when mandatory fields are blank
     * 
     * @category Milestone-2
     * @return boolean
     * @author Bharat.goel
     * @throws Exception
     * 
     */
    public String clickInsertImageWhenMandatoryFieldsAreBlank() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING ERROR MESSAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnInsertImage, waitTime);
            btnInsertImage.clickAndWait(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                if (isAlertPresent()) {
                    strResult = uiDriver.getUIAlert().getAlertMessage();
                    uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
                } else
                    strResult = lblInlineError.getText().trim();
            } else {
                strResult = lblInlineError.getText();
            }
            
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ERROR MESSGE AFTER CLICKING ON ADD LINK  BUTTON " + " \nMETHOD:clickInsertImageWhenMandatoryFieldsAreBlank" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * THIS METHOD TO CHECK IF THE FOLDER IS ON TOP
     * 
     * @category Milestone 2
     * @author bharat.goel
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFolderIsTopFolder(String strfolderName) throws Exception {
    	flag=false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER IS ON TOP");
            frameSwitch.switchToAddLinkFrame();
            imgRootFolder.replaceValues(strfolderName);
            uiDriver.waitToBeDisplayed(imgRootFolder, waitTime);
            if(imgRootFolder.isDisplayedAfterWaiting() && imgRootFolder.getAttribute(SRC)
                    .contains(OPENFOLDER))
            	flag=true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE METHOD TO CHECK IF THE FOLDER IS ON TOP " + " \nMETHOD: isFolderIsTopFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether instructional text is present below Desc field
     * 
     * @author Usha
     * @return boolean
     * @throws Exception
     * @param instxt
     * @category Milestone 2
     */
    public boolean isInstructionalTextBelowDescField(String strInsText) throws Exception {
    	flag=false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFY WHETHER INSTRUCTIONAL TEXT IS PRESENT BELOW DESC FIELD");
            frameSwitch.switchToAddLinkFrame();
            lblInsTxtDescFld.waitToBePresent(waitTime);
            if(lblInsTxtDescFld.getText().equalsIgnoreCase(strInsText))
            	flag=true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY WHETHER INSTRUCTIONAL TEXT IS PRESENT BELOW DESC FIELD " + " \nMETHOD:isInstructionalTextBelowDescField \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to check if the Folder Icon is displayed for root folder
     * 
     * @category Milestone 2
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isFolderIconDisplayedForStreamingMedia() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER ICON IS DISPLAYED FOR STREAMING MEDIA FOLDER");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(imgStreamingMedia, waitTime);
            flag = imgStreamingMedia.isDisplayedAfterWaiting();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER ICON IS DISPLAYED FOR STREAMING MEDIA FOLDER " + " \nMETHOD: isFolderIconDisplayedForStreamingMedia" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
    
    /**
     * METHOD FOR CREATING SELECT IMAGE IN LINKWIZARD
     * 
     * @author bharat.goel
     * @return boolean
     * @throws Exception
     * @param String strTextToBeDisplay
     * 		  String  strFileToSelect
     * @category Milestone 2
     */
    public void createSelectImage(String strTextToBeDisplay, String strFileToSelect)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CREATING SELECT IMAGE IN LINKWIZARD");
            if (StringUtils.isNotBlank(strFileToSelect) || StringUtils
                    .isNotBlank(strTextToBeDisplay)) {
            logInstruction("LOG INSTRUCTION: ENTER THE TEXT TO BE DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtDescriptiveText, waitTime);
            txtDescriptiveText.clearAndSendKeys(strTextToBeDisplay);
            
            logInstruction("LOG INSTRUCTION :SELECT A FILE TO BE UPLOADED ");
            lnkradSelectFile.replaceValues(strFileToSelect);
            lnkradSelectFile.clickNoWait();
            
            logInstruction("LOG INSTRUCTION: CLICK ON ADDLINK BUTTON");
            btnInsertImage.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
            } else {
                throw new Exception("EITHER 'strFileToSelect' OR 'strTextToBeDisplay' IS NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING LINK FROM SELECT IMAGE PAGE IN LINKWIZARD " + " \nMETHOD:createSelectImage\n" + e
                            .getLocalizedMessage());
        }
       
    }

/**
     * THIS METHOD TO CHECK IF FILE IS SELECTED
     * 
     * @category Milestone 2
     * @author bharat.goel
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFileSelected() throws Exception {
        flag = false;
		try {
			logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF FILE IS SELECTED");
			frameSwitch.switchToAddLinkFrame();
			if (radFileNames.areAllPresent()) {
                lstFileNames2 = radFileNames.getUIElementsList();

                for (int i = 0; i < lstFileNames2.size(); i++) {
                    flag = lstFileNames2.get(i).isSelected();
				}
			}
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO CHECK IF THE METHOD TO CHECK IF FILE IS SELECTED " + " \nMETHOD: isFileSelected" + e
                            .getLocalizedMessage());
		}
        return flag;
    }

 /**
     * THIS METHO TO CHECK WHETHER WE BACK TO FOLDER STRUCTURE AFTER CLICKING UP LINK
     * 
     * @category Milestone 2
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isBackToFolderStructureAfterClickingUPLink(String strFolderName)
            throws Exception {
        flag = false;
		try {
			logInstruction("LOG INSTRUCTION : METHOD TO CHECK WHETHER WE BACK TO FOLDER STRUCTURE AFTER CLICKING UP LINK");
			if (StringUtils.isNotBlank(strFolderName)) {
				frameSwitch.switchToAddLinkFrame();
				imgFolder.replaceValues(strFolderName);
				selectfolder.replaceValues(strFolderName);
				uiDriver.waitToBeDisplayed(imgFolder, waitTime);
				uiDriver.waitToBeDisplayed(selectfolder, waitTime);
                if (imgFolder.getAttribute(SRC).contains(CLOSEDFOLDER) && selectfolder
                        .getAttribute(ONCLICK).contains(ONCLICK)) {
					flag = true;
				}
			} else
                throw new Exception(
                        "Provided folder name is NULL " + " \nMETHOD: isBackToFolderStructureAfterClickingUPLink");
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO CHECK WHETHER WE BACK TO FOLDER STRUCTURE AFTER CLICKING UP LINK " + " \nMETHOD: isBackToFolderStructureAfterClickingUPLink" + e
                            .getLocalizedMessage());
		}
		return flag;
	}
}