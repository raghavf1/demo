package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
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
 * Class contains the method related to LinkCourseContent page
 * 
 * @author saurabh.jain1
 */
public class LinkCourseContentPage extends BasePageObject {

    // UI element declaration

    private UIElement lblHeaderTitle = createElement(UIType.Css, "div.tablehead");
    private UIElement txtTextToDisplay = createElement(UIType.ID, "linkTitle");
    private UIElement drpConnectToLink = createElement(UIType.ID, "selectedUnitID");
    private UIElement btnAddLink = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Add Link')]");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElement btnBack = createElement(UIType.Xpath, "//input[contains(@value,'Back')]");
    private UIElement lblradValue = createElement(UIType.Xpath, "//tr/td/label[contains(.,'{1}')]"); 
    private UIElement lblText;
    private UIElement lblLink;
    private UIElement drpDown = createElement(UIType.Css, "select.#selectedUnitID");
    private UIElements lstOption;
    private UIElements lstItemSection;
    private UIElement txtInstruction;
    private UIElement lblAsterix;
    private UIElement txtError;
    private UIElement btnRadio;
    private UIElement btnRadioDefault;
    private UIElement btnBrowze;
    private UIElement radSelected = createElement(
            UIType.Xpath,
            "//label[contains(@for,'courseItem')]");
    private UIElement btnAllignment = createElement(
            UIType.Xpath,
            "//table//tbody//tr//td//table[2]//tbody//tr[4]//td[2]");

    private static final String CLASSATTRIBUTE = "class";
    private static final String ALIGNATTRIBUTE = "align";
    private static final String RIGHT = "right";
    private static final String REQUIREDATTRIBUTE = "required";
    private static final String YELLOW = "Yellow";
    private static final String FRAMEHEADING = "('tablehead')[0].getBoundingClientRect().bottom";
    private static final String TEXTTODISPLAYTOP = "('label')[0].getBoundingClientRect().top";
    private static final String TEXTTODISPLAYRIGHT = "('label')[0].getBoundingClientRect().right";
    private static final String TEXTTODISPLAYTEXTBOXLEFT = "('linkTitle').getBoundingClientRect().left";
    private static final String TEXTTODISPLAYBOTTOM = "('label')[0].getBoundingClientRect().bottom";
    private static final String CONTENTTOLINKTOTOP = "('label')[1].getBoundingClientRect().top";
    private static final String CONTENTTOLINKTORIGHT = "('label')[1].getBoundingClientRect().right";
    private static final String UNITDROPDOWNLEFT = "('selectedUnitID').getBoundingClientRect().left";
    private boolean flag = false;
    private String strResult = null;
    private String strLocation1 = null;
    private String strLocation2 = null;
    List<UIElement> lstItemSectionList = new ArrayList<UIElement>();

    public LinkCourseContentPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkCourseContentPage";
        logInstruction("LOG INSTRUCTION: ## LinkCourseContentPage ##");
    }

    /**
     * @author saurabh.jain1
     * @return header
     * @throws Exception
     *             This method is to verify whether header is displaying or not.
     */

    public String getLinkCourseContentHeaderTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING HEADER TITLE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strResult = lblHeaderTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "COURSE CONTENT HEADER NOT DISPLAYED" + "\nMETHOD:getLinkCourseContentHeaderTitle\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @author saurabh.jain1
     * @throws Exception
     *             This method is for switching window.
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH ON WINDOW" + "\nMETHOD:switchToWindow\n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * @author saurabh.jain1
     * @return LinkCourseContentPage
     * @throws Exception
     *             This method is entering text into text field.
     */
    public LinkCourseContentPage enterTextIntoTextField(String strText) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE CONTENT INTO TEXTBOX");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtTextToDisplay, waitTime);
            txtTextToDisplay.clearAndSendKeys(strText);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER INTO TEXT FIELD" + "\n METHOD:enterTextIntoTextField\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to upload a file
     * 
     * @category Milestone 2
     * @author Soundarya
     * @return LinkCourseContentPage
     * @throws Exception
     */
    public LinkCourseContentPage clickBrowse() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : UPLOAD FILE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBrowze, waitTime);
            if (getBrowser().equals(Browser.FIREFOX)) {
                btnBrowze.clickByJavascript();
            } else
                btnBrowze.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO UPLOAD THE FILE" + "\nMETHOD: clickBrowse\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author saurabh.jain1
     * @param unitID
     * @return LinkCourseContentPage
     * @throws Exception
     *             This method is for selecting value from dropdown.
     */

    public LinkCourseContentPage selectValueFromConnectToLinkDropBox(String strUnitID)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT VALUE FROM DROPDOWN");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(drpConnectToLink, waitTime);
            drpConnectToLink.selectByVisibleText(strUnitID);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT FROM DROPDOWN" + "\n METHOD: selectValueFromConnectToLinkDropBox\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author saurabh.jain1
     * @param linkto
     * @return LinkCourseContentPage
     * @throws Exception
     *             This method is for selecting radio button.
     */
    public LinkCourseContentPage selectAnyFromRadioButton(String strLinkto) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECTING A RADIO BUTTON");
            frameSwitch.switchToAddLinkFrame();
            lblradValue.replaceValues(strLinkto);
            uiDriver.waitToBeDisplayed(lblradValue, waitTime);
            lblradValue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON" + "\nMETHOD: selectAnyFromRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author saurabh.jain1
     * @return
     * @throws Exception
     *             This method is for clicking on Add Link Button.
     */
    public void clickOnAddLinkButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ADD LINK BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            /*
             * List<String> windows = new ArrayList<String>();
             * windows.addAll(uiDriver.getWindowHandles());
             */
            btnAddLink.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    "ADD LINK BUTTON IS NOT CLICKED" + "\nMETHOD: clickOnAddLinkButton\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @author saurabh.jain1
     * @return
     * @throws Exception
     *             This method is for clicking on cancel button.
     */

    public void clickOnCancelButton() throws Exception {
        try {

            frameSwitch.switchToAddLinkFrame();
            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "CANCEL BUTTON IS NOT CLICKED" + "\n METHOD :clickOnCancelButton\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @author saurabh.jain1
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     *             This method is for clicking on Back button.
     */
    public LinkWizardInsertLinkPage clickOnBackButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BACK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            btnBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("BACK BUTTON IS NOT CLICKED" + "\nMETHOD :clickOnBackButton\n" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * This method will check whether label "Text to display" is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isLabelTextToDisplayFieldDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL TEXT TO DISPLAY DISPLAYED ");
            frameSwitch.switchToAddLinkFrame();
            flag = lblText.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE LABEL : TEXT TO DISPLAY" + "\nMETHOD:isLabelTextToDisplayFieldDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether Text box of label "Text to display" is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isTextToDisplayTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER TEXT BOX TEXT TO DISPLAY DISPLAYED. ");
            frameSwitch.switchToAddLinkFrame();
            flag = txtTextToDisplay.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE TAXT BOX : TEXT TO DISPLAY" + "\nMETHOD: isTextToDisplayTextBoxDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: GET DEFAULT BACKGROUND COLOR");
            frameSwitch.switchToAddLinkFrame();
            if (txtTextToDisplay.isDisplayedAfterWaiting(waitTime))
                if (txtTextToDisplay.getAttribute(CLASSATTRIBUTE).contains(REQUIREDATTRIBUTE))
                    strResult = YELLOW;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET DEFAULT BACKGROUND COLOR" + "\nMETHOD: getDefaultBackgroundColorOfTextToDisplayTextBox\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method will check whether label "Content to link to:" is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isLabelContentToLinkToDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER CONTENT TO LINK TO: DISPLAYED.");
            frameSwitch.switchToAddLinkFrame();
            flag = lblLink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE LABEL CONTENT TO LINK TO" + "\nMETHOD: isLabelContentToLinkToDisplayed\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether unit dropdown is displayed.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isUnitDropDownListDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER DROPDOWN DISPLAYED.");
            frameSwitch.switchToAddLinkFrame();
            flag = drpDown.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "CANNOT LOCATE DROPDOWN" + "\n METHOD: isUnitDropDownListDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will get default value of unit dropdown.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link String}
     * @throws Exception
     * **/
    public String getDefaultValueOfUnitDropDown() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING DEFAULT DROPDOWN VALUE.");
            frameSwitch.switchToAddLinkFrame();
            if (lstOption.areAllPresent()) {
                List<UIElement> listOptions = lstOption.getUIElementsList();
                for (UIElement uiElement : listOptions) {
                    if (uiElement.isSelected())
                        strResult = uiElement.getText();
                }
            } else { // if(option.areAllPresent()){
                logInstruction("LOG INSTRUCTION: NO DEFAULT VALUE IS AVAILABLE IN UNIT DROPDOWN.");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET DEFAULT VALUE OF DRPDOWN" + "\n METHOD: getDefaultValueOfUnitDropDown\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method will check whether content item section is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isContentItemSectionDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER CONTENT ITEM SECTION IS DISPLAYED.");
            frameSwitch.switchToAddLinkFrame();
            if (lstItemSection.areAllPresent()) {
                lstItemSectionList = lstItemSection.getUIElementsList();
                if (lstItemSectionList.size() > 0)
                    flag = true;
            } else { // if(itemSection.areAllPresent()){
                logInstruction("LOG INSTRUCTION: No Content Item Section is displayed.");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE ITEM SECTION" + "\n METHOD : isContentItemSectionDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether radio button is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @param {@link String} - - Name of the item opposite to which radio button is to be expected
     *        to display.
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isRadioButtonDisplayed(String strItemName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER RADIO BUTTON IS DISPLAYED.");
            frameSwitch.switchToAddLinkFrame();
            if (StringUtils.isNotBlank(strItemName)) {
                btnRadio.replaceValues(strItemName);
                flag = btnRadio.isDisplayedAfterWaiting(waitTime);
            } else { // if(StringUtils.isNotBlank(itemName)){
                logInstruction("LOG INSTRUCTION: " + strItemName + " Radio button is not displayed.");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE RADIO BUTTON FOR" + strItemName + "\n METHOD: isRadioButtonDisplayed\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether unit homepage radio button is selected by default.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isUnitHomePageRadioButtonSelectedByDefault() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER RADIO BUTTON IS DISPLAYED FOR UNIT HOMEPAGE.");
            frameSwitch.switchToAddLinkFrame();
            btnRadioDefault.isDisplayedAfterWaiting(waitTime);
            flag = btnRadio.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK RADIO BUTTON OF UNIT HOME PAGE" + "\n METHOD : isUnitHomePageRadioButtonSelectedByDefault\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether instructional message is displayed or not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isInstructionalMessageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER INSTRUCTIONAL TEXT IS DISPLAYED OR NOT. ");
            frameSwitch.switchToAddLinkFrame();
            flag = txtInstruction.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE INSTRUCTIONAL TEXT" + "\nMETHOD : isInstructionalMessageDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether asterix sign(mandatory) is displayed in instructional text or
     * not.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isAsterixSymbolDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ASTERIC SIGN IS DISPLAYED OR NOT.");
            frameSwitch.switchToAddLinkFrame();
            flag = lblAsterix.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE ASTERIX SYMBOL IN INSTRUCTIONAL TEXT" + "\n METHOD : isAsterixSymbolDisplayed\n" + e
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
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER BACK BUTTON IS DISPLAYED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnBack.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE BACK BUTTON" + "\n METHOD :isBackButtonDisplayed \n" + e
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
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ADDLINK BUTTON IS DISPLAYED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnAddLink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE BACK BUTTON" + "\nMETHOD : isAddLinkButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether Cancel button is displayed.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link Boolean}
     * @throws Exception
     * **/
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER CANCEL BUTTON IS DISPLAYED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LOCATE BACK BUTTON" + "\n METHOD : isCancelButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will get inline error message when text to display field is blank.
     * 
     * @author Vivek.Singh
     * @category Milestone2
     * @return {@link String}
     * @throws Exception
     * **/
    public String getInlineErrorMessage() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ERROR MESSAGE. METHOD : getInlineErrorMessage");
            frameSwitch.switchToAddLinkFrame();
            if (txtError.isDisplayedAfterWaiting(waitTime)) {
                strResult = txtError.getText();
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE. " + e.getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is for clicking on Add Link Button when Text to display field is left blank.
     * 
     * @author Vivek.Singh
     * @return void
     * @throws Exception
     * **/
    public void clickOnInvalidAddLinkButton() throws Exception {
        try {
            frameSwitch.switchToAddLinkFrame();
            logInstruction("LOG INSTRUCTION: CLICK ON INVALID ADD LINK BUTTON ");
            btnAddLink.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ADD LINK BUTTON IS NOT CLICKED" + "\nMETHOD : clickOnInvalidAddLinkButton\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to check if focus is on Text To Display Field
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */
    public boolean isFocusOnTextToDisplayField() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF FOCUS IS ON TEXT TO DISPLAY FIELD");
            frameSwitch.switchToAddLinkFrame();
            Point point = uiDriver.switchTo().activeElement().getLocation();
            if (point.x == txtTextToDisplay.getLocation().x && point.y == txtTextToDisplay
                    .getLocation().y) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON TEXT TO DISPLAY FIELD" + "\nMETHOD : isFocusOnTextToDisplayField\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label Text To Display is below Frame Heading
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isLabelTextToDisplayBelowFrameHeading() throws Exception {
        strLocation1 = null;
        strLocation2 = null;
        flag = false;
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
                    " UNABLE TO CHECK WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING" + "\n METHOD:isLabelTextToDisplayBelowFrameHeading \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether textbox is right of Text To Display label
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true if textbox present at right Text To Display label label false otherwise
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
                    " UNABLE TO CHECK WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL." + "\n METHOD:isTextBoxRightToTextToDisplayLabel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether content to link to label is below text to display
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true if Label Content To Link To Is Below Text To Display
     * @throws Exception
     */

    public boolean isLabelContentToLinkToBelowTextToDisplay() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL CONTENT TO LINK TO IS BELOW TEXT TO DISPLAY");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYBOTTOM);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + CONTENTTOLINKTOTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK WHETHER LABEL CONTENT TO LINK TO IS BELOW TEXT TO DISPLAY." + "\n METHOD:isLabelContentToLinkToBelowTextToDisplay \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether unit dropdown list is right of content to link to
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean
     * @throws Exception
     */

    public boolean isUnitDropDownListRightOfContentToLinkTo() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER UNIT DROPDOWN LIST IS RIGHT OF CONTENT TO LINK TO");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + CONTENTTOLINKTORIGHT);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + UNITDROPDOWNLEFT);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CHECK WHETHER WHETHER UNIT DROPDOWN LIST IS RIGHT OF CONTENT TO LINK TO" + "\n METHOD:isUnitDropDownListRightOfContentToLinkTo \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to get contents of text field
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     * 
     */
    public String getTextToDisplayContents() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET CONTENTS OF TEXT TO DISPLAY FIELD");
            uiDriver.waitToBeDisplayed(txtTextToDisplay, waitTime);
            strResult = txtTextToDisplay.getValue();

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO GET CONTENTS OF TEXT TO DISPLAY FIELD" + "\n METHOD:getTextToDisplayContents \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method is used to get the selected Radio button value
     * 
     * @author Pratush.Manglik
     * @category Milestone2
     * @return
     * @throws Exception
     */
    public String getSelectedRadioButton() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET THE SELECTED RADIO BUTTON VALUE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(radSelected, waitTime);
            strResult = radSelected.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET SELECTED RADIO BUTTON VALUE" + "\n METHOD : getSelectedRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to check whether The Buttons Are Displayed at The Same Level
     * 
     * @author Pratush.Manglik
     * @category Milestone-2
     * @return
     * @throws Exception
     */
    public boolean isAddLinkBackAndCancelButtonDisplayedAtTheSameLevel() throws Exception {
        flag = false;
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ADD LINK ,BACK BUTTON AND CANCEL BUTTON DISPLAYED AT THE SAME LEVEL ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAllignment, waitTime);
            strResult = btnAllignment.getAttribute(ALIGNATTRIBUTE);
            if (strResult.contains(RIGHT))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER ADD LINK ,BACK BUTTON AND CANCEL BUTTON DISPLAYED AT THE SAME LEVEL " + "\n METHOD:isAddLinkBackAndCancelButtonDisplayedAtTheSameLevel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
    
    /** Method will create Link from Link to Course Content page
     * @author Praveen.Maled
    * @param strTextToBeDisplay
    * @param strToolToLink
    * @throws Exception
    * @category Milestone 2
    */
    public void createCourseContentLink(
            String strTextToBeDisplay,
            String strUnitID,
            String strContentItem) throws Exception {
    	try {
            if (StringUtils.isNotBlank(strTextToBeDisplay) && StringUtils.isNotBlank(strUnitID) && StringUtils
                    .isNotBlank(strContentItem)) {
       			logInstruction("LOG INSTRUCTION: CREATING WEBSITE LINK");
       			logInstruction("LOG INSTRUCTION: ENTER THE TEXT TO DISPLAY");
       			frameSwitch.switchToAddLinkFrame();
       			uiDriver.waitToBeDisplayed(txtTextToDisplay, waitTime);
       			txtTextToDisplay.clearAndSendKeys(strTextToBeDisplay);
       			logInstruction("LOG INSTRUCTION: SELECTING UNIT");
                drpConnectToLink.selectByVisibleText(strUnitID);
                logInstruction("LOG INSTRUCTION: CLICKING ON ADD LINK");
                lblradValue.replaceValues(strContentItem);
                uiDriver.waitToBeDisplayed(lblradValue, waitTime);
                lblradValue.clickAndWait(waitTime);
       			btnAddLink.clickAndWait(waitTime);
       			uiDriver.getUIWindowLocator().switchToFirstWindow();
       		}else
                throw new Exception(
                        "EITHER PROVIDED LINK TEXT OR UNITNAME OR CONTENT ITEM NAME IS NULL" + "\nMETHOD: createCourseContentLink\n");
           } catch (Exception e) {
               throw new Exception(
                       "ISSUE IN CREATING WEBSITELINK \nMETHOD : createCourseContentLink\n" + e
                               .getLocalizedMessage());
           }
    }

}
