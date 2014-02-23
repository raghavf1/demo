package com.pearson.eselenium.ls.contentitems.unit.microsoftofficedocument.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages.MicrosoftOfficeDocumentToolBoxPage;
import com.pearson.eselenium.ls.contentitems.unit.pages.UnitContentItemsPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class Contains all Methods Related to UnithomePageMicrosoftOfficeDocument
 * 
 * @author amit.deshmukh
 * @category Milestone2
 */

public class UnitHomePageForMicrosoftOfficeDocumentPage extends BasePageObject {

    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");

    private UIElement btnToolBox = createElement(UIType.Xpath, "//a[contains(.,'Toolbox')]");
    private UIElement btnUnitContent = createElement(
            UIType.Xpath,
            "//a[contains(.,'Content Items')]");
    private UIElement btnUnitIntroduction = createElement(
            UIType.Xpath,
            "//a[contains(.,'Introduction')]");
    private UIElement txtHeaderTitle = createElement(UIType.Css, "div[class='tablehead']");
    String strHeaderTitle = null;
    String strTitle = null;
    boolean flag = false;

    /**
     * constructor
     * 
     * @param driver
     */
    public UnitHomePageForMicrosoftOfficeDocumentPage(UIDriver driver) {
        super(driver);
        pageTitle = "UnitHomePageForMicrosoftOfficeDocumentPage";
        logInstruction("LOG INSTRUCTION ### UnitHomePageForMicrosoftOfficeDocumentPage #####");

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

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
            strHeaderTitle = txtPageTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD:getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strHeaderTitle;
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

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);
            strTitle = txtHeaderTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * This method clicks the tool box in the unit homepage
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     */

    public MicrosoftOfficeDocumentToolBoxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicking the toolbox link");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnToolBox, waitTime);
            btnToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE TOOLBOX BUTTON" + "\n METHOD:clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new MicrosoftOfficeDocumentToolBoxPage(uiDriver);
    }

    /**
     * Clicks the contentItem Button
     * 
     * @return:UnitContentItemsPage
     * @author amit.deshmukh
     * @category Milestone2
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
     * This method check whether the unitIntoduction button is displayed or not
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return boolean
     */

    public boolean isUnitContentIntroductionButtonisDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();

            flag = btnUnitIntroduction.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD:isUnitContentIntroductionButtonisDisplayed \n" + e
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

    public boolean isUnitContentItemButtonisDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE UNIT CONTENT ITEM BUTTON");
            frameSwitch.switchToFrameContent();

            flag = btnUnitContent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE UNIT CONTENT BUTTON" + "\n METHOD:isUnitContentItemButtonisDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to verify the title of the page
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     * 
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
            throw new Exception("UNABLE TO VERIFY THE HEADER" + "\n isHeaderTitleDisplay \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

}
