package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains methods related to EquellaImagesPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaImagesPage extends BasePageObject {

    /* Constructor */
    public EquellaImagesPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION :  ### EquellaImagesPage ###");

    }

    /* UIElement declarations for EquellaImagesPage */

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
            logInstruction("LOG INSTRUCTION : Switching the window to LinkCourse Tool page");
            List<String> windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            uiDriver.switchTo().window(windows.get(1));
        } catch (Exception e) {
            throw new Exception("Unable to switch the window" + e.getLocalizedMessage());
        }

    }

    /**
     * This method is used to click on Select button
     * 
     * @author Pratush.Manglik
     * @param imgName
     * @return EquellaSelectionPage
     * @throws Exception
     */
    public EquellaSelectionPage clickSelectButton(String imgName) throws Exception {
        logInstruction("LOG INSTRUCTION :  CLICK ON SELECT BUTTON");
        try {
            frameSwitch.switchToAddLinkFrame();
            btnSelect.replaceValues(imgName); // Sample content - The Overland Track
            uiDriver.waitToBeDisplayed(btnSelect, waitTime);
            btnSelect.click();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CLICK ON SELECT BUTTON \n METHOD :clickSelectButton" + e
                            .getLocalizedMessage());
        }
        return new EquellaSelectionPage(uiDriver);
    }
}
