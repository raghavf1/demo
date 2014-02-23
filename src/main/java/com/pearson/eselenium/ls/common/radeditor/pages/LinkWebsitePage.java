package com.pearson.eselenium.ls.common.radeditor.pages;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to LinkWebsite Page
 * 
 * @author Usha
 */
public class LinkWebsitePage extends BasePageObject {

    /* UIElement declarations for LinkToWebsite page */
    private UIElement lblPageTitle = createElement(UIType.Xpath, "//div[@class='tablehead']");
    private UIElement txtwebsiteText = createElement(UIType.Css, "input#linkTitle");
    private UIElement txtwebsiteAddress = createElement(UIType.Css, "input#linkURL");
    private UIElement btnBack = createElement(UIType.Xpath, "//input[@value='< Back']");
    private UIElement btnAddLink = createElement(UIType.Xpath, "//input[@value='Add Link']");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[@value='Cancel']");
    private UIElement lblText = createElement(UIType.Xpath, "//td/label[contains(text(),'{1}')]");
    private UIElement lblAstricSymbol = createElement(
            UIType.Xpath,
            "//tr/td[label[contains(.,'{1}')]]/span[contains(.,'*')]");
    private UIElement txtErrorMessage = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']/table/tbody/tr/td[2]");
    private static final String FRAMEHEADINGBOTTOM = "('tablehead')[0].getBoundingClientRect().bottom";
    private static final String TEXTTODISPLAYTOP = "('label')[0].getBoundingClientRect().top";
    private static final String TEXTTODISPLAYRIGHT = "('label')[0].getBoundingClientRect().right";
    private static final String TEXTTODISPLAYTEXTBOXLEFT = "('linkTitle').getBoundingClientRect().left";
    private static final String TEXTTODISPLAYBOTTOM = "('label')[0].getBoundingClientRect().bottom";
    private static final String WEBSITEADDRESSTOP = "('label')[1].getBoundingClientRect().top";
    private static final String WEBSITEADDRESSRIGHT = "('label')[1].getBoundingClientRect().right";
    private static final String WEBSITEADDRESSTEXTBOXLEFT = "('linkURL').getBoundingClientRect().left";
    private static final String ADDLINKBUTTONBOTTOM = "('buttontd')[0].getBoundingClientRect().bottom";
    private static final String BACKBUTTONBOTTOM = "('buttontd')[1].getBoundingClientRect().bottom";
    private static final String CANCELBUTTONBOTTOM = "('buttontd')[2].getBoundingClientRect().bottom";
    private static final String CLASS = "class";
    private static final String REQUIRED = "required";
    private static final String YELLOW = "yellow";
    private String strResult = null;
    private String strLocation1 = null;
    private String strLocation2 = null;
    private String strLocation3 = null;
    private boolean flag = false;

	/* Constructor */
    public LinkWebsitePage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkWebsitePage";
        logInstruction("LOG INSTRUCTION: ## LinkWebsite ##");
    }
    /**
     * Method helps to switch to add link page
     * 
     * @author usha
     * @return LinkWebsitePage
     * @throws Exception
     */
    public LinkWebsitePage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO 'Add Link' PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH THE 'Add Link' WINDOW" + "\n METHOD :switchToAddLinkPage\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter the Website Text
     * 
     * @author Usha
     * @param text
     * @return LinkWebsitePage
     * @throws Exception
     */
    public LinkWebsitePage enterWebsiteText(String strText) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE 'Website Text' TO DISPLAY");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
            txtwebsiteText.clearAndSendKeys(strText);
            logInstruction("LOG INSTRUCTION: 'Website Text' IS ENTERED");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER 'Website Text'" + "\n METHOD : enterWebsiteText\n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to enter the Website Address
     * 
     * @author Usha
     * @param URL
     * @return LinkWebsitePage
     * @throws Exception
     */
    public LinkWebsitePage enterWebsiteURL(String strURL) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE 'Website URL'");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
            txtwebsiteAddress.clearAndSendKeys(strURL);
            logInstruction("LOG INSTRUCTION: 'Website URL' IS ENTERED");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO ENTER 'Website URL' " + "\nMETHOD : enterWebsiteURL\n" + e
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

            logInstruction("LOG INSTRUCTION: CLICK ON 'Back' BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON 'Back' BUTTON " + "\n METHOD : clickBack" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * Method helps to click on AddLink button
     * 
     * @author Usha
     * @throws Exception
     */

    public void clickAddLink() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON 'Add Link' BUTTON");
            frameSwitch.switchToAddLinkFrame();

            btnAddLink.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Add Link' BUTTON " + "\n METHOD : clickAddLink" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * @author Usha ,Method helps to click on Cancel
     * @return
     * @throws Exception
     */
    public void clickCancel() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: CLICK ON 'Cancel' BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnCancel.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON 'Cancel' BUTTON " + "\n METHOD :clickCancel " + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to verify LinkWebsitePage Displayed
     * 
     * @author Usha
     * @return string
     * @throws Exception
     */
    public String getLinkWebSitePageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY LINKWEBSITEPAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
            strResult = lblPageTitle.getText();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO LINKWEBSITEPAGE TITLE  method : getLinkWebSitePageTitle" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check label is displayed or not
     * 
     * @author praveen.maled
     * @return EmailHomePage
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isLabelDisplayed(String strLabel) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY SPECIFIED 'Label' IS PRESENT OR NOT ");
            if (StringUtils.isNotBlank(strLabel)) {
                frameSwitch.switchToAddLinkFrame();
                lblText.replaceValues(strLabel);
                flag = lblText.isDisplayedAfterWaiting(waitTime);
            } else {
                logInstruction("LOG INSTRUCTION: PROVIDED 'Label' VALUE IS NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN FINDING THE 'Label'" + "\n METHOD :  isLabelDisplayed\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check Text box for text to display filed displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isTextBoxForTextToDisplayFieldDispalyed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY TEXT BOX FOR 'Text To Display' IS DIPLAYED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = txtwebsiteText.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND TEXT BOX FOR 'Text To Display' " + "\n METHOD : isTextBoxForTextToDisplayFieldDispalyed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check Text box for Website Address field displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isTextBoxForWebSiteFieldDispalyed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY TEXT BOX FOR 'Website Address' IS DIPLAYED OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = txtwebsiteAddress.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND TEXT BOX FOR 'Website Address' " + "\n METHOD : isTextBoxForWebSiteFieldDispalyed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will get entered text from the "Text to display" input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getTextToDisplayFieldContents() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET TEXT FROM 'Text To Display' FIELD");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtwebsiteText.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND TEXT  FOR 'Text To Display' " + "\n METHOD :getTextToDisplayFieldContents " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get entered text from the Website address input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getTextFromWebSiteAddressField() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: get text from 'WebSite Address' field");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtwebsiteAddress.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "Unable to find text  for 'WebSite Address' " + "\n METHOD:getTextFromWebSiteAddressField" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get back ground color of text to display input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getBackGroundColorOfTextToDisplayFieldTextBox() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET BACK GROUND COLOR OF 'Text To Display' FIELD");
            frameSwitch.switchToAddLinkFrame();
            if (txtwebsiteText.getAttribute(CLASS).contains(REQUIRED))
                strResult = YELLOW;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND BACK GROUND COLOR OF 'Text To Display' " + "\n METHOD:  getBackGroundColorOfTextToDisplayFieldTextBox" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get background color of WebSite Address input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getBackGroundColorOfWebSiteAddressTextBox() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET BACK GROUND COLOR OF 'Website Address' FIELD");
            frameSwitch.switchToAddLinkFrame();
            if (txtwebsiteAddress.getAttribute(CLASS).contains(REQUIRED))
                strResult = YELLOW;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND BACK GROUND COLOR OF 'Website Address' " + "\n METHOD: getBackGroundColorOfWebSiteAddressTextBox " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check Text to display is focused or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFocusOnTextToDisplayField() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING IF FOCUS IS ON DESCRIPTIVE FIELD ");
            frameSwitch.switchToAddLinkFrame();
            Point point = uiDriver.switchTo().activeElement().getLocation();
            if (point.x == txtwebsiteText.getLocation().x && point.y == txtwebsiteText
                    .getLocation().y) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON DESCRIPTIVE FIELD " + "\n METHOD: isFocusOnTextToDisplayField" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check Asterisk symbol is present in front of specified label or not
     * 
     * @author Praveen.Maled
     * @param fileName
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isAsteriskSymbolDisplayedNextToMandatroryField(String strFileName)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING ASTERISK SYMBOL IS PRESENT OR NOT ");
            if (StringUtils.isNotBlank(strFileName)) {
                frameSwitch.switchToAddLinkFrame();
                lblAstricSymbol.replaceValues(strFileName);
                flag = lblAstricSymbol.isDisplayedAfterWaiting(waitTime);
            } else
                logInstruction("LOG INSTRUCTION : PROVIDED FILENAME IS NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND ASTERISK SYMBOL " + "\n METHOD: isAsteriskSymbolDisplayedNextToMandatroryField" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check is Add Link button displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isAddLinkButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING ADD LINK BUTTON PRESENT OR NOT  ");
            frameSwitch.switchToAddLinkFrame();
            flag = btnAddLink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY ADD LINK BUTTON " + "\n METHOD:isAddLinkButtonDisplayed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check is Cancel button displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING CANCEL BUTTON PRESENT OR NOT ");
            frameSwitch.switchToAddLinkFrame();
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY CANCEL BUTTON " + "\n METHOD:isCancelButtonDisplayed " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will return the error message
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getErrorMessage() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING ERROR MESSAGE ");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtErrorMessage.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET ERROR MESSAGE " + "\n METHOD: getErrorMessage" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to click on AddLink button
     * 
     * @author Praveen.maled
     * @return void
     * @throws Exception
     * @category Milestone 2
     */

    public void clickAddLinkTOGetErrorMessage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ADDLINK BUTTON TO GET ERROR MESSAGE");
            frameSwitch.switchToAddLinkFrame();
            btnAddLink.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON ADDLINK BUTTON " + "\n METHOD: clickAddLinkTOGetErrorMessage" + e
                            .getLocalizedMessage());
        }

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
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByClassName" + FRAMEHEADINGBOTTOM);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER LABEL TEXT TO DISPLAY IS BELOW FRAME HEADING " + "\n METHOD:isLabelTextToDisplayBelowFrameHeading \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether textbox is right of Text To Display label
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
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
                    "UNABLE TO CHECK WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL." + "\n METHOD:isTextBoxRightToTextToDisplayLabel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether label website address is below text to display
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isLabelWebsiteAddressBelowTextToDisplay() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER LABEL WEBSITE ADDRESS IS BELOW TEXT TO DISPLAY");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + TEXTTODISPLAYBOTTOM);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + WEBSITEADDRESSTOP);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER LABEL WEBSITE ADDRESS IS BELOW TEXT TO DISPLAY." + "\n METHOD:isLabelWebsiteAddressBelowTextToDisplay \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether Website Address Text Box Is Displayed On Right Side Of Website
     * Address Label
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isWebsiteAddressTextBoxDisplayedOnRightSideOfWebsiteAddress() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER  WEBSITE ADDRESS TEXT BOX IS DISPLAYED ON RIGHT SIDE OF WEBSITE ADDRESS");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + WEBSITEADDRESSRIGHT);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementById" + WEBSITEADDRESSTEXTBOXLEFT);
            if ((int) Double.parseDouble(strLocation1) < (int) Double.parseDouble(strLocation2))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER TEXTBOX IS RIGHT OF TEXT TO DISPLAY LABEL. " + "\n METHOD:isWebsiteAddressTextBoxDisplayedOnRightSideOfWebsiteAddress \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check whether The Buttons Are Displayed at The Same Level
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return boolean true
     * @throws Exception
     */

    public boolean isAddLinkBackAndCancelButtonDisplayedAtTheSameLevel() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        strLocation3 = null;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING WHETHER ADD LINK ,BACK BUTTON AND CANCEL BUTTON DISPLAYED AT THE SAME LEVEL ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnAddLink, waitTime);
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName" + ADDLINKBUTTONBOTTOM);
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName" + BACKBUTTONBOTTOM);
            strLocation3 = uiDriver
                    .executeScript("return document.getElementsByTagName" + CANCELBUTTONBOTTOM + ".getBoundingClientRect().bottom");
            if ((int) Double.parseDouble(strLocation1) == (int) Double.parseDouble(strLocation2) && (int) Double
                    .parseDouble(strLocation2) == (int) Double.parseDouble(strLocation3))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK WHETHER ADD LINK ,BACK BUTTON AND CANCEL BUTTON DISPLAYED AT THE SAME LEVEL " + "\n METHOD:isAddLinkBackAndCancelButtonDisplayedAtTheSameLevel \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to clear text from web address text box
     * 
     * @return
     * @throws Exception
     * @author saurabh.jain1
     */
    public LinkWebsitePage deleteTextFromWebSiteAddressField() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: DELETING TEXT FROM 'Website Address' FIELD");
            frameSwitch.switchToAddLinkFrame();
            txtwebsiteAddress.clear();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DELETE TEXT FROM 'Website Address' " + "\nMETHOD:deleteTextFromWebSiteAddressField\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }
    
    
    /**
     * Method will create Link from WebSite page
     * @author Praveen.Maled
     * @param strTextToBeDisplayed
     * @param strURL
     * @throws Exception
     * @category Milestone 2
     */
    public void createWebsiteLink(String strTextToBeDisplayed, String strWebsiteAddress)
            throws Exception {
    	try {
            if (StringUtils.isNotBlank(strTextToBeDisplayed) && StringUtils
                    .isNotBlank(strWebsiteAddress)) {
    			logInstruction("LOG INSTRUCTION: CREATING WEBSITE LINK");
    			logInstruction("LOG INSTRUCTION: ENTER THE WEBSITE TEXT TO DISPLAY");
    			frameSwitch.switchToAddLinkFrame();
    			uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
    			txtwebsiteText.clearAndSendKeys(strTextToBeDisplayed);
    			logInstruction("LOG INSTRUCTION: ENTER THE WEBSITE TEXT TO DISPLAY");
    			uiDriver.waitToBeDisplayed(lblPageTitle, waitTime);
    			txtwebsiteAddress.clearAndSendKeys(strWebsiteAddress);
    			logInstruction("LOG INSTRUCTION: CLICKING ON ADD LINK");
    			btnAddLink.clickAndWait(waitTime);
    			uiDriver.getUIWindowLocator().switchToFirstWindow();
    		}else
                throw new Exception(
                        "EITHER PROVIDED LINK TEXT OR URL IS NULL" + "\nMETHOD:createWebsiteLink\n");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CREATING WEBSITELINK " + "\nMETHOD : createWebSiteLink\n" + e
                            .getLocalizedMessage());
        }
    }

}