package com.pearson.eselenium.ls.contentitems.unit.webcontent.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.webcontent.pages.WebContentToolboxPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class Contains Methods Related To unit Home Page WebContent
 * 
 * @category Milestone2
 * @author amit.deshmukh
 */
public class UnitHomePageForWebContent extends BasePageObject {

    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement txtHeaderTitle = createElement(UIType.Css, ".tablehead");
    private UIElement btnToolBox = createElement(UIType.Xpath, "//a[contains(.,'Toolbox')]");
    private UIElement btnUnitContent = createElement(
            UIType.Xpath,
            "//a[contains(.,'Content Items')]");
    private UIElement btnUnitIntroduction = createElement(
            UIType.Xpath,
            "//a[contains(.,'Introduction')]");

    String headerTitle;
    String title ;
    
    boolean flag;
    
    public UnitHomePageForWebContent(UIDriver driver) {
        super(driver);

        logInstruction("## Unit Home Page Web Content ##");
    }

    /**
     * This method helps to get the page title of the page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     * @throws Exception
     */
    public String getPageTitle() throws Exception {
    	headerTitle= null;

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
            headerTitle = txtPageTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD:getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return headerTitle;
    }

    /**
     * This method helps to get the header title of the page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        title = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);
            title = txtHeaderTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return title;
    }

    /**
     * This method clicks the tool box in the unit homepage
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     */

    public WebContentToolboxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE TOOLBOX LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnToolBox, waitTime);
            btnToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE TOOLBOX BUTTON" + "\n METHOD:clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new WebContentToolboxPage(uiDriver);
    }

    /**
     * Clicks the contentItem Button
     * 
     * @return:UnitHomePageWebContentPage
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     */
    public UnitHomePageForWebContent clickContentItemsButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitContent, waitTime);
            btnUnitContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE CONTENTITEMBUTTON" + "\n METHOD:clickContentItemsButton \n" + e
                            .getLocalizedMessage());
        }
        return new UnitHomePageForWebContent(uiDriver);
    }

    /**
     * This method check whether the unitIntoduction button is displayed or not
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return boolean
     */

    public boolean isUnitContentIntroductionButtonIsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUnitIntroduction, waitTime);
            flag = btnUnitIntroduction.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD:isUnitContentIntroductionButtonIsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This methods check whether the content item button is displayed or not
     * 
     * @author amit.deshmukh
     * @category Milestone2
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
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD:isUnitContentItemButtonIsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to verify the title of the page
     * 
     * @author ashish.juyal
     * @return String
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
            throw new Exception("UNABLE TO VERIFY THE HEADER" + "\n METHOD:isHeaderTitleDisplay \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

}
