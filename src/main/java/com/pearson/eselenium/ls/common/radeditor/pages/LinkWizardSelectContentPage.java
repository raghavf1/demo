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
 * This is the Page Object for Select Content Screen
 * 
 * @author monica.anand
 * 
 */
public class LinkWizardSelectContentPage extends BasePageObject {

    /* Elements */
    private UIElement txtToDisplayField = createElement(UIType.Css, "#linkTitle");
    private UIElement btnBack = createElement(UIType.Xpath, "//input[@value='< Back']");
    private UIElement btnAddLink = createElement(UIType.Xpath, "//input[@value='Add Link']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel'] ");
    private UIElement divTitle = createElement(UIType.Css, ".tablehead");
    private UIElement btnradButton = createElement(
            UIType.Xpath,
            "//tbody/tr[td/label/a[contains(.,'{1}')]]/td/input");
    private UIElement lblTextToDisplay = createElement(
            UIType.Xpath,
            "//tr/td/label[contains(text(),'Text to display')]");
    private UIElement txtToDisplayFieldDisplayed = createElement(
            UIType.Xpath,
            "//*[@id='linkTitle']");
    private UIElement txtToDisplayFieldHighlightedYellow = createElement(
            UIType.Xpath,
            "//*[@id='linkTitle']");
    private UIElement lblContentToLinkToDisplay = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[1]");
    private UIElement fldrStructureDisplayedRoot = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/table[1]");
    private UIElement fldrStructureDisplayedFolder = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/table[2]");
    private UIElement lblOfRootFolder = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/table[1]/tbody/tr/td[2]");
    private UIElement fldrStreamingMediaDisplayed = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/table[2]/tbody/tr[1]/td[4]/a");
    private UIElement fldrDisplayedNextToRootFolder = createElement(
            UIType.Xpath,
            "//label[contains(.,'{1}')]");
    private UIElement btnDisplayed = createElement(
            UIType.Xpath,
            "//*[@id='linkContent']/table[3]/tbody/tr/td/table[3]/tbody/tr[4]/td[2]/input[1]");
    private UIElement tabSelectContentFromCourse = createElement(
            UIType.Xpath,
            "//tr[td[@class='selectedG']]/td[contains(.,'Select')]");
    private UIElement radSelectFile = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]/parent::label/parent::td/preceding-sibling::td[@width='21']/input[@type='radio']");
    private UIElement selectfolder = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElements lblFolderNames = createElements(UIType.Xpath, "//td[@width='*']");
    private UIElement lnkUp = createElement(
            UIType.Xpath,
            "//span[@class='screen_readers_only']/parent::a");
    private UIElement txtinstructional = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table//tr[4]/td[contains(.,'Indicates')]");
    private UIElement errorMsg = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//table//tr/td[2]");
    private UIElements fileListAlphaNumerically = createElements(
            UIType.Xpath,
            "//input[@type='radio']/parent::td/following-sibling::td//label//a[contains(text(),'')]");
    private UIElement imgFolder = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]/parent::td/preceding-sibling::td/img[contains(@src,'.gif')]");
    private UIElements lstFolders = createElements(UIType.Xpath, "//a[@href='#']");
    private UIElement imgRootFolder = createElement(
            UIType.Xpath,
            "//td[contains(text(),'{1}')]/preceding-sibling::td/img");

    private UIElement txtDescriptiveText = createElement(UIType.Css, "input#linkTitle");

    private UIElement btnradButtonForFolder = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table[2]//table[2]//tr[td//a[contains(.,'{1}')]]//td[2]/input");

    private static final String FRAMEHEADING = "('tablehead')[0].getBoundingClientRect().bottom";
    private static final String TEXTTODISPLAYTOP = "('label')[0].getBoundingClientRect().top";
    private static final String TEXTTODISPLAYRIGHT = "('label')[0].getBoundingClientRect().right";
    private static final String TEXTTODISPLAYTEXTBOXLEFT = "('linkTitle').getBoundingClientRect().left";
    private static final String SELECTEDG = "selectedG";
    private static final String CLASS = "class";
    private static final String REQUIRED = "required";
    private static final String SRC = "src";
    private static final String OPENFOLDER = "openfolder";
    private static final String ONCLICK = "onclick";
    private static final String ONCLICKTXT = "OnClick";
    boolean flag = false;
    private String strLocation1 = null;
    private String strLocation2 = null;
    private String strResult = null;
    List<UIElement> lstOfFolders = new ArrayList<UIElement>();
    List<String> lstOfFolderNames = new ArrayList<String>();
    List<String> lstnewListOfFolderNames = new ArrayList<String>();
    List<UIElement> lstOfFiles = new ArrayList<UIElement>();
    List<String> lstOfFileNames = new ArrayList<String>();
    List<String> lstnewListOfFileNames = new ArrayList<String>();
    List<UIElement> lstFolderNames2 = new ArrayList<UIElement>();

	/*Constructor*/
    public LinkWizardSelectContentPage(UIDriver driver) {
        super(driver);
        pageTitle = "LinkWizardSelectContentPage";
        logInstruction("LOG INSTRUCTION: ## LinkWizardSelectContentPage ### ");
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
            logInstruction("LOG INSTRUCTION: CLICKING 'Back' BUTTON IN  ADD LINK PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            btnBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Back' BUTTON " + "\n METHOD:clickBackButton \n" + e
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
            logInstruction("LOG INSTRUCTION: CLICKING 'Add Link'  BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            btnAddLink.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Add Link' BUTTON " + "\n METHOD:clickAddLink \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to click on cancel button
     * 
     * @author monica.anand
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING 'Cancel' BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Cancel' BUTTON " + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to type content in the text field
     * 
     * @author monica.anand
     * @return LinkWizardSelectContentPage
     * @throws Exception
     */
    public LinkWizardSelectContentPage typeTextToDisplay(String strDataToBeEntered)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: TYPE TEXT TO DISLAY METHOD");
            uiDriver.waitToBeDisplayed(txtToDisplayField, waitTime);
            txtToDisplayField.clearAndSendKeys(strDataToBeEntered);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT " + "\n METHOD:typeTextToDisplay \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on the radio button
     * 
     * @author monica.anand
     * @return link LinkWizardSelectContentPage
     * @throws Exception
     * 
     */
    public LinkWizardSelectContentPage selectRadioButton(String strLinkto) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT RADIO BUTTON ");
            btnradButton.replaceValues(strLinkto);
            btnradButton.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON  " + "\n METHOD:selectRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get the Page title
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */
    public String getPageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY PAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(divTitle, waitTime);
            strResult = divTitle.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY PAGE TITLE " + "\n METHOD:getPageTitle \n" + e
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
            txtToDisplayFieldDisplayed.isDisplayedAfterWaiting(waitTime);
            if (point.x == txtToDisplayFieldDisplayed.getLocation().x && point.y == txtToDisplayFieldDisplayed
                    .getLocation().y)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON TEXT TO DISPLAY FIELD" + "\n METHOD : isFocusOnTextToDisplayField" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether Select comment is selected or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isSelectContentFromCourseFolderTabSelected() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING SELECT CONTENT TAB IS SELECTED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            tabSelectContentFromCourse.isDisplayedAfterWaiting(waitTime);
            if (SELECTEDG.equalsIgnoreCase(tabSelectContentFromCourse.getAttribute(CLASS)))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY SELECTION OF SELECT CONTENT TAB " + "\nMETHOD: isSelectContentFromCourseFolderTabSelected " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether label is present or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isLabelTextToDisplayDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING TEXT TO DISPLAY LABEL IS DISPLAYD OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = lblTextToDisplay.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND LABEL " + "\nMETHOD:isLabelTextToDisplayDisplayed " + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether Text to Display field is present or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isTextBoxForTextToDisplayFieldDispalyed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING TEXT TO DISPLAY FIELD IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            flag = txtToDisplayFieldDisplayed.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND FIELD " + "\nMETHOD : isTextBoxForTextToDisplayFieldDispalyed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether TEXT TO DISP IS HIGHLIGHTED YELLOW OR NOT
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isTextToDisplayFieldHighlightedYellow() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY TEXT TO DISPLAY FIELD HIGHLIGHTED YELLOW OR NOT ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtToDisplayFieldHighlightedYellow, waitTime);
            if (REQUIRED.equalsIgnoreCase(txtToDisplayFieldHighlightedYellow.getAttribute(CLASS)))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY WHETHER TEXT IS HIGHLIGHTED IS YELLOW OR NOT  " + "\nMETHOD:isTextToDisplayFieldHighlightedYellow\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether content label is present or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isContentTolinkToLabelDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING CONTENT TO LABEL DISPLAY IS DISPLAYEd");
            frameSwitch.switchToAddLinkFrame();
            flag = lblContentToLinkToDisplay.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND CONTENT LABEL" + "\nMETHOD: isContentTolinkToLabelDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether sub folder is next to root folder
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFolderDisplayedNextToRootFolder(String strFolder) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING WHETHER SUB FOLDER IS NEXT TO ROOT FOLDER");
            frameSwitch.switchToAddLinkFrame();
            fldrDisplayedNextToRootFolder.replaceValues(strFolder);
            fldrDisplayedNextToRootFolder.isDisplayedAfterWaiting(waitTime);
            lblOfRootFolder.isDisplayedAfterWaiting(waitTime);
            if (lblOfRootFolder.getLocation().x < fldrDisplayedNextToRootFolder.getLocation().x && lblOfRootFolder
                    .getLocation().y < fldrDisplayedNextToRootFolder.getLocation().y) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND SUB FOLDER IS NEXT TO ROOT FOLDER " + "\nMETHOD:  isFolderDisplayedNextToRootFolder" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether older structure displayed or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFolderStructureDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING FOLDER STRUCTURE TO DISPLAY IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            fldrStructureDisplayedFolder.isDisplayedAfterWaiting(waitTime);
            fldrStructureDisplayedRoot.isDisplayedAfterWaiting(waitTime);
            if (fldrStructureDisplayedRoot.getLocation().x < fldrStructureDisplayedFolder
                    .getLocation().x && fldrStructureDisplayedRoot.getLocation().y < fldrStructureDisplayedFolder
                    .getLocation().y) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE FOLDER STRUCTURE " + "\nMETHOD:isFolderStructureDisplayed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will return the name of root folder
     * 
     * @author Bharat.Goel
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getNameOfTheRootFolder() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETING THE NAME OF ROOT FOLDER");
            frameSwitch.switchToAddLinkFrame();
            lblOfRootFolder.isDisplayedAfterWaiting(waitTime);
            return lblOfRootFolder.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE NAME OF ROOT FOLDER " + "\nMETHOD: getNameOfTheRootFolder" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will verify whether sub folder streaming media is there or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isSubFolderStreamingMediaDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING WHETHER SUB FOLDER STREAMING MEDIA IS PRESENT OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = fldrStreamingMediaDisplayed.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND SUB FOLDER STREAMING MEDIA " + "\nMETHOD: isSubFolderStreamingMediaDisplayed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will verify whether back button is present or not
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isBackButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VEIFYING WHETHER BACK BUTTON IS PRESENT OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnDisplayed.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND BACK BUTTON " + "\nMETHOD: isBackButtonDisplayed " + e
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
    public boolean isRadioButtonDisplayedForFile(String strFileName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF A RADIO BUTTON IS PRESENT FOR A FILE");
            frameSwitch.switchToAddLinkFrame();
            radSelectFile.replaceValues(strFileName);
            flag = radSelectFile.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF RADIO BUTTON IS PRESENT FOR A FILE " + "\nMETHOD: isRadioButtonDisplayedForFile" + e
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
                if (selectfolder.getAttribute(ONCLICK).contains(ONCLICKTXT))
                    flag = true;
            } else
                logInstruction("LOG INSTRUCTION : PROVIDED FOLDER NAME IS NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER NAME IS CLICKABLE " + "\nMETHOD: isFolderClickable" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the uplink is displayed
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
                    "UNABLE TO CHECK IF UP LINK IS DISPLAYED " + "\nMETHOD: isUplinkDisplayed" + e
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
            lstFolderNames2 = lblFolderNames.getUIElementsList();
            strResult = lstFolderNames2.get(0).getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET ROOT FOLDER NAME " + "\nMETHOD: getNameOfRootFolder" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This Function will Select the Folder
     * 
     * @category Milestone 2
     * @param name
     *            Name of the folder
     * @return {@link LinkWizardSelectContentPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public LinkWizardSelectContentPage clickFolder(String strName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : SELECT FOLDER NAME");
            frameSwitch.switchToAddLinkFrame();
            if (StringUtils.isNotBlank(strName)) {
                selectfolder.replaceValues(strName);
                uiDriver.waitToBeDisplayed(selectfolder, waitTime);
                selectfolder.clickNoWait();
            } else {
                logInstruction("LOG INSTRUCTION : Given folder name is not present");
            }
        } catch (Exception e) {
            logInstruction("UNABLE TO SELECT THE FOLDER " + "\nMETHOD: clickFolder");
        }
        return this;
    }

    /**
     * This method is used to click on a file
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public LinkWizardSelectContentPage selectFileToBeUploaded(String strFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO SELECT A FILE TO BE UPLOADED ");
            frameSwitch.switchToAddLinkFrame();
            if (StringUtils.isNotBlank(strFileName)) {
                radSelectFile.replaceValues(strFileName);
                uiDriver.waitToBeDisplayed(radSelectFile, waitTime);
                radSelectFile.clickNoWait();
            } else {
                logInstruction("LOG INSTRUCTION : UNABLE TO SELECT A FILE TO BE UPLOADED METHOD : selectFileToBeUploaded ");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE FILE TO BE UPLOADED" + "\nMETHOD:selectFileToBeUploaded" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to verify Add Link
     * 
     * @category Milestone 2
     * @return
     * @throws Exception
     * @author Usha
     */
    public boolean isAddLinkDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :VERIFY ADD LINK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            flag = btnAddLink.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "GRADEBOOK CALENDAR IS NOT PRESENT" + "\nMETHOD:isAddLinkDisplayed " + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Cancel button AddLink page
     * 
     * @category Milestone 2
     * @return
     * @throws Exception
     * @author Usha
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION :VERIFY CANCEL BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            flag = btnCancel.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CANCEL BUTTON " + "\nMETHOD: isCancelButtonDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get Instructional Text
     * 
     * @category Milestone 2
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getInstructionalText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION :GETTING INSTRUCTIONAL TEXT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtinstructional, waitTime);
            strResult = txtinstructional.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET INSTRUCTIONAL TEXT " + "\nMETHOD: getInstructionalText" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to verify InstructionalText on AddLink page
     * 
     * @category Milestone 2
     * @return
     * @throws Exception
     * @author Usha
     */
    public boolean isInstructionalTextDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("VERIFY INSTRUCTIONAL TEXT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtinstructional, waitTime);
            flag = txtinstructional.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY INSTRUCTIONALTEXT " + "\nMETHOD: isInstructionalTextDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get error message
     * 
     * @author Usha
     * @category Milestone 2
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION :GETTING ERROR MESSAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(errorMsg, waitTime);
            strResult = errorMsg.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE" + "\nMETHOD: getErrorMessage" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to click on up link
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public LinkWizardSelectContentPage clickOnUpLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CLICK ON UP LINK");
            frameSwitch.switchToAddLinkFrame();
            if (lnkUp.isDisplayedAfterWaiting())
                lnkUp.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON  UP LINK " + "\nMETHOD:clickOnUpLink " + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to switch to add to link page
     * 
     * @author Usha
     * @return LinkWizardSelectContentPage
     * @throws Exception
     */
    public LinkWizardSelectContentPage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO ADDLINK PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH THE WINDOW " + "\nMETHOD: switchToAddLinkPage" + e
                    .getLocalizedMessage());
        }
        return this;
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
            logInstruction("LOG INSTRUCTION : CLICKING ON 'Add LiNK' BUTTON WEN MANDATORY FIELDS ARE BLANK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            btnAddLink.clickAndWait(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                strResult = uiDriver.getUIAlert().getAlertMessage();
                uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
            } else {
                strResult = errorMsg.getText();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADD LINK  BUTTON " + "\nMETHOD: clickAddLinkWhenMandatoryFieldsAreBlank " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to check if the folder is displayed
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
            logInstruction("LOG INSTRUCTION : Method to check if the folder name is displayed");
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToAddLinkFrame();
                selectfolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(selectfolder, waitTime);
                if (selectfolder.isDisplayedAfterWaiting())
                    flag = true;
            } else
                logInstruction("LOG INSTRUCTION : Provided folder name is NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FOLDER NAME IS DISPLAYED" + "\nMETHOD:isFolderDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the folder icon is displayed next to folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFolderIconDisplayedForRootFolder(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER IS DISPLAYED");
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToAddLinkFrame();
                imgRootFolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(imgRootFolder, waitTime);
                if (imgRootFolder.isDisplayedAfterWaiting())

                    flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF FOLDER IS DISPLAYED " + "\nMETHOD: isFolderIconDisplayedForRootFolder " + e
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
                    "UNABLE TO CHECK  WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING " + "\nMETHOD:isLabelTextToDisplayBelowFrameHeading" + e
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
                    "UNABLE TO CHECK  WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL." + " \n METHOD :isTextBoxRightToTextToDisplayLabel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the folder icon is displayed next to Streaming Media folder
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isStreamingMediaFolderDisplayed(String strFolderName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE STREAMING MEDIA FOLDER IS DISPLAYED");
            if (StringUtils.isNotBlank(strFolderName)) {
                frameSwitch.switchToAddLinkFrame();
                imgFolder.replaceValues(strFolderName);
                uiDriver.waitToBeDisplayed(imgFolder, waitTime);
                if (imgFolder.isDisplayedAfterWaiting())

                    flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE STREAMING MEDIA FOLDER IS DISPLAYED." + " \n METHOD :isStreamingMediaFolderDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method will check whether file names are alphanumerically sorted or not.
     * 
     * @author Vivek.Singh
     * @return Boolean
     * @throws Exception
     * **/
    public boolean isFilesSortedAlphaNumerically() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR SORTED LIST OF FILES.");
            frameSwitch.switchToAddLinkFrame();
            lstOfFiles = fileListAlphaNumerically.getUIElementsList();
            for (UIElement uiElement : lstOfFiles) {
                lstOfFileNames.add(uiElement.getText());

            }
            lstnewListOfFileNames = lstOfFileNames;
            Collections.sort(lstOfFileNames);
            if (lstOfFileNames.equals(lstnewListOfFileNames))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF THE FILE LIST IS SORTED ALPHANUMERICALLY." + " \n METHOD :isFilesSortedAlphaNumerically \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether folder names are alphanumerically sorted or not.
     * 
     * @category Milestone 2
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
                    1,
                    lstFolders.getUIElementsList().size() - 1);
            for (UIElement uiElement : lstOfFolders) {
                lstOfFolderNames.add(uiElement.getText());

            }
            lstnewListOfFolderNames = lstOfFolderNames;
            Collections.sort(lstOfFolderNames);
            if (lstOfFolderNames.equals(lstnewListOfFolderNames))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "FOLDERS ARE NOT SORTED ALPHANUMERICALLY" + "\n METHOD:isFoldersSortedAlphaNumerically \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to check if the folder is displayed
     * 
     * @category Milestone 2
     * @author bharat.goel
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isFileDisplayed(String strfileName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FILE NAME IS DISPLAYED");
            if (StringUtils.isNotBlank(strfileName)) {
                frameSwitch.switchToAddLinkFrame();
                selectfolder.replaceValues(strfileName);
                if (selectfolder.isDisplayedAfterWaiting(waitTime))
                    flag = true;
            } else
                logInstruction("LOG INSTRUCTION : PROVIDED FOLDER NAME IS NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE FILE NAME IS DISPLAYED" + "\nMETHOD:isFileDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
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
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : METHOD TO CHECK IF THE FOLDER IS ON TOP");
            frameSwitch.switchToAddLinkFrame();
            imgRootFolder.replaceValues(strfolderName);
            uiDriver.waitToBeDisplayed(imgRootFolder, waitTime);
            if (imgRootFolder.isDisplayedAfterWaiting() && imgRootFolder.getAttribute(SRC)
                    .contains(OPENFOLDER))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK IF THE METHOD TO CHECK IF THE FOLDER IS ON TOP " + "\nMETHOD: isFolderIsTopFolder" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to verify radio button is selected for a file
     * 
     * @category Milestone 2
     * @author Usha
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isRadioButtonSelectedForFile(String strLinkto) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING RADIO BUTTON ");
            btnradButton.replaceValues(strLinkto);
            flag = btnradButton.isSelected();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON " + "\n METHOD:selectRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to type content in the text field
     * 
     * @author Usha
     * @return String
     * @throws Exception
     */
    public String getTypeTextToDisplayText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TEXT FROM TEXT TO DISLAY ");
            uiDriver.waitToBeDisplayed(txtToDisplayField, waitTime);
            strResult = txtToDisplayField.getValue();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET TEXT " + "\n METHOD:typeTextToDisplay \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
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
            logInstruction("LOG INSTRUCTION : GETTING 'Descriptive Text'");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtDescriptiveText.getValue();
        } catch (Exception e) {

            throw new Exception(
                    "UNABLE TO GET 'Descriptive Text' " + "\nMETHOD:getDescriptiveTextFieldText" + e
                            .getLocalizedMessage());
        }
        return strResult;

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
            btnradButtonForFolder.replaceValues(strFolderName);
            // uiDriver.waitToBeDisplayed(btnradButton, wait_time);
            flag = btnradButtonForFolder.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF RADIO BUTTON IS DISPLAYED IN FRONT OF FOLDER " + "\nMETHOD: isRadioButtonDisplayedInFrontOfFolder " + e
                            .getLocalizedMessage());
        }
        return flag;
    }
    
    /**
     * METHOD FOR CREATING SELECT CONTENT IN LINKWIZARD
     * 
     * @author bharat.goel
     * @return boolean
     * @throws Exception
     * @param String strTextToBeDisplay
     * 		  String  strFileToSelect
     * @category Milestone 2
     */
    public void createSelectContent(String strTextToBeDisplay, String strFileToSelect)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CREATING SELECT CONTENT LINK IN LINKWIZARD");
            if (StringUtils.isNotBlank(strFileToSelect) || StringUtils
                    .isNotBlank(strTextToBeDisplay)) {
            frameSwitch.switchToAddLinkFrame();
            logInstruction("LOG INSTRUCTION: ENTER TEXT TO BE DISPLAYED");
            uiDriver.waitToBeDisplayed(txtToDisplayField, waitTime);
            txtToDisplayField.clearAndSendKeys(strTextToBeDisplay);
            logInstruction("LOG INSTRUCTION : SELECT A FILE TO BE UPLOADED");
                radSelectFile.replaceValues(strFileToSelect);
                uiDriver.waitToBeDisplayed(radSelectFile, waitTime);
                radSelectFile.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKING ADD LINK BUTTON ");
            btnAddLink.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
            } else {
                throw new Exception("EITHER 'strFileToSelect' OR 'strTextToBeDisplay' IS NULL");
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING LINK FROM SELECT CONTENT PAGE IN LINKWIZARD" + "\nMETHOD:createSelectContent\n" + e
                            .getLocalizedMessage());
        }
       
    }
    
    
    /**
     * Method will get entered file path in the input field
     * 
     * @author Praveen.Maled
     * @return boolean
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

}
