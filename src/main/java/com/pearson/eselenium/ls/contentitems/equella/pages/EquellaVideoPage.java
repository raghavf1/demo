package com.pearson.eselenium.ls.contentitems.equella.pages;

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

    /* UIElement declarations for EquellaVideoPage */
    private UIElement btnSelect = createElement(
            UIType.Xpath,
            "//div[@class='itemlist']//div[//div[h3//a[@title='{1}']]]//div[//div[input]]");

    /* Constructor */
    public EquellaVideoPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION : ### EquellaVideoPage ###");
    }

    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
        	throw new Exception("UNABLE TO SWITCH THE WINDOW" + "\n METHOD : switchToWindow \n" + e
                    .getLocalizedMessage());
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
        logInstruction("LOG INSTRUCTION : CLICK ON SELECT BUTTON");
        try {
            frameSwitch.switchToAddLinkFrame();
            btnSelect.replaceValues(vidName); // EQUELLA Promotional Video
            uiDriver.waitToBeDisplayed(btnSelect, waitTime);
            btnSelect.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON SELECT BUTTON" + "\n METHOD : clickSelectButton \n" + e
                    .getLocalizedMessage());
        }
        return new EquellaSelectionPage(uiDriver);
    }

}
