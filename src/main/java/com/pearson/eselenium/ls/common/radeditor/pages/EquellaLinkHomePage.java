package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains methods related to EquellaHomePage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaLinkHomePage extends BasePageObject {

    /* Constructor */
    public EquellaLinkHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION : ### EquellaHomePage ###");

    }

    /* UIElwement declarations for EquellaHomePage */

    private UIElement lnkBrowseResourceByFormat = createElement(
            UIType.Xpath,
            "//a[text()='Browse resources by format ']");

    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : Switching the Window to LinkCourse Tool Page");
            List<String> windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            uiDriver.switchTo().window(windows.get(1));
        } catch (Exception e) {
            throw new Exception("Unable to switch the window" + e.getLocalizedMessage());
        }

    }

    /**
     * This method is used to click on browse resource by format link
     * 
     * @author Pratush.Manglik
     * @return BrowseResourceByFormatPage
     * @throws Exception
     */
    public BrowseResourceByFormatPage clickBrowseResourceByFormat() throws Exception {
        logInstruction("LOG INSTRUCTION : Click Browse Resource by Format Link");
        try {
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lnkBrowseResourceByFormat, waitTime);
            lnkBrowseResourceByFormat.clickNoWait();
        } catch (Exception e) {
            throw new Exception(" Unable to Click Browse Resource by Format Link" + e
                    .getLocalizedMessage());
        }
        return new BrowseResourceByFormatPage(uiDriver);

    }

}
