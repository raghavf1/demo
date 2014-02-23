package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to EquellaVideoPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaVideoPage extends BasePageObject {

    /* Constructor */
    public EquellaVideoPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION : ### EquellaVideoPage ###");

    }

    /* UIElement declarations for EquellaVideoPage */

    private UIElement btnSelect = createElement(
            UIType.Xpath,
            "//div[@class='itemlist']//div[//div[h3//a[@title='{1}']]]//div[//div[input]]");

    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : Switching the Window to LinkCourse Tool page");
            List<String> windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            uiDriver.switchTo().window(windows.get(1));
        } catch (Exception e) {
            throw new Exception("Unable to Switch the Window" + e.getLocalizedMessage());
        }

    }

    /**
     * This method is used to click on Select button
     * 
     * @author Pratush.Manglik
     * @param vidName
     * @return EquellaSelectionPage
     * @throws Exception
     */
    public EquellaSelectionPage clickSelectButton(String vidName) throws Exception {
        logInstruction("LOG INSTRUCTION :  CLICK ON SELECT BUTTON");
        try {
            frameSwitch.switchToAddLinkFrame();
            btnSelect.replaceValues(vidName); // EQUELLA Promotional Video
            uiDriver.waitToBeDisplayed(btnSelect, waitTime);
            btnSelect.clickNoWait();
        } catch (Exception e) {
            throw new Exception(" UNABLE TO CLICK ON SELECT BUTTON \n METHOD:clickSelectButton" + e
                    .getLocalizedMessage());
        }
        return new EquellaSelectionPage(uiDriver);
    }

}
