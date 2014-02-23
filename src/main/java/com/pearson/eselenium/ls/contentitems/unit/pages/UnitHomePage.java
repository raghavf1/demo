package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to UnitHomePage
 * 
 * @author ashish.juyal
 * 
 */
public class UnitHomePage extends BasePageObject {

    /* UIElements for the UnitHomePage */
    private UIElement btnUnitContent = createElement(
            UIType.Xpath,
            "//a[contains(.,'Content Items')]");
    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement btnUnitIntroductionButton = createElement(
            UIType.Xpath,
            "//a[contains(.,'Introduction')]");
    private UIElement btnToolBoxButton = createElement(UIType.Xpath, "//a[contains(.,'Toolbox')]");
    private UIElement txtHeaderTitle = createElement(UIType.Css, "div[class='tablehead']");
    private UIElement txtHeader = createElement(UIType.Xpath, "//div[@class='tablehead']");

    private VisualEditor textMultimediaRadEditor;
    private PlainTextEditor textMultimediaPlainEditor;

    /* variables */
    boolean flag = false;
    String[] strValue;
    String strHeaderTitle = null;
    String strText = null;
    String strUnitId = null;
    String[] strParts;

    /* Constructor */
    public UnitHomePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "UnitHomePage";
        logInstruction("LOG INSTRUCTION: ## UNIT HOME PAGE ##");
    }

    /**
     * Method helps to get the visual Editor
     * 
     * @author Kapil
     * @return VisualEditor
     */
    public VisualEditor getVisualEditor() {
        return textMultimediaRadEditor;
    }

    /**
     * Method helps to get the Plain text editor
     * 
     * @author Kapil
     * @return PlainTextEditor
     */
    public PlainTextEditor getPlainTextEditor() {
        return textMultimediaPlainEditor;
    }

    /**
     * This method scroll down till the end of page
     * 
     * @return:UnitHomepage
     * @author ashish.juyal
     */
    public UnitHomePage scrollDown() {
        for (int sec = 0;; sec++) {
            if (sec >= 60) {
                break;
            }
            uiDriver.executeScript("window.scrollBy(0,200)", "");
        }
        return this;
    }

    /**
     * Clicks the contentItem Button
     * 
     * @return:UnitContentItemsPage
     * @author ashish.juyal
     * @throws Exception
     */
    public UnitContentItemsPage clickContentItemsButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitContent, waitTime);
            btnUnitContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE CONTENTITEMBUTTON" + "\n METHOD: clickContentItemsButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitContentItemsPage(uiDriver);
    }

    /**
     * this method verify the unit homepage
     * 
     * @author ashish.juyal
     * @return boolean
     * @param String
     * @throws Exception
     */

    public boolean verifyUnitHomePage(String name) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE UNITHOME PAGE");
            frameSwitch.switchToFrameContent();
            strValue = txtPageTitle.getText().split(":");
            flag = strValue[1].equalsIgnoreCase(name);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE UNITHOME PAGE" + "\n METHOD: verifyUnitHomePage \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This methods click the unitIntroductionbutton
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public UnitIntroductionPage clickUnitIntroductionButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE UNIT INTRODUCTION BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitIntroductionButton, waitTime);
            btnUnitIntroductionButton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE UNIT INTRODUCTION PAGE" + "\n METHOD: clickUnitIntroductionButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitIntroductionPage(uiDriver);
    }

    /**
     * This method clicks the tool box in the unit home page
     * 
     * @author ashish.juyal
     * @return UnitToolboxPage
     * @throws Exception
     */

    public UnitToolboxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE TOOLBOX LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnToolBoxButton, waitTime);
            btnToolBoxButton.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE TOOLBOX LINK" + "\n METHOD: clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitToolboxPage(uiDriver);
    }

    /**
     * This method helps to get the title of the page
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     * 
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);
            strHeaderTitle = txtHeaderTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD: getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strHeaderTitle;
    }

    /**
     * This methods check whether the content item button is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */

    public boolean isUnitContentItemButtonIsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitContent, waitTime);
            flag = btnUnitContent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD:" + " isunitContentItemButtonisDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method check whether the unitIntoduction button is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */

    public boolean isUnitContentIntroductionButtonIsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitIntroductionButton, waitTime);
            flag = btnUnitIntroductionButton.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD: isunitContentIntroductionButtonisDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method check whether the toolbox button is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     */

    public boolean isUnitToolBoxButtonisDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnToolBoxButton, waitTime);
            flag = btnToolBoxButton.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD: isUnitToolBoxButtonisDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to get The Unit Name of the unit
     * 
     * @author ashish.juyal
     * @throws Exception
     */
    public String getUnitName() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE UNIT NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeader);
            strText = txtHeader.getText();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE TEXT" + "\n METHOD: getUnitName \n" + e
                    .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This method helps to get the title of the page
     * 
     * @category milestone 2
     * @author ganapati.bhat
     * @return String
     * @throws Exception
     * 
     */
    public String getUnitNameWithId() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE UNIT HEADER TITLE WITH ID");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);
            strUnitId = txtHeaderTitle.getText().trim();

            strParts = strUnitId.split(":");
            strText = strParts[0];
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD: getUnitNameWithId \n" + e
                    .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This method helps to verify the title of the page
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     * 
     */
    public boolean isHeaderTitleDisplay() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);

            if (txtHeaderTitle.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE HEADER" + "\n METHOD:isHeaderTitleDisplay \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

}
