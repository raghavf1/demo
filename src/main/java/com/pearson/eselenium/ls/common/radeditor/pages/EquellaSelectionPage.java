package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.unit.pages.UnitIntroductionPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to EquellaSelectionPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaSelectionPage extends BasePageObject {

    /* Constructor */
    public EquellaSelectionPage(UIDriver uiDriver) {
        super(uiDriver);

        logInstruction("LOG INSTRUCTION : ### EquellaSelectionPage ###");
    }

    /* UIElement declarations for EquellaSelectionPage */

    private UIElement txtSelection = createElement(UIType.Css, ".odd>td");
    private UIElement titleHeader = createElement(UIType.Xpath, "//h2");
    private UIElement btnReturn = createElement(UIType.Xpath, "//input[contains(@value,'Return')]");

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
     * This method is used to get text from the mySelection textbox
     * 
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getTextFromMySelectionTextBox() throws Exception {
        String selection = null;
        logInstruction("LOG INSTRUCTION : GET TEXT FROM MY SELECTION  BOX ");
        try {
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtSelection, waitTime);
            selection = txtSelection.getText();
        } catch (Exception e) {
            throw new Exception(
                    " CANNOT GET TEXT FROM MYSELECTION TEXTBOX \n METHOD :getTextFromMySelectionTextBox");
        }
        return selection;
    }

    /**
     * This method is used to get the header title
     * 
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        String title = null;
        logInstruction("LOG INSTRUCTION : GET HEADER TITLE");
        try {
            uiDriver.waitToBeDisplayed(titleHeader, waitTime);
            title = titleHeader.getText();
        } catch (Exception e) {
            throw new Exception(" CANNOT GET TITLE OF HEADER \n METHOD :getHeaderTitle" + e
                    .getLocalizedMessage());
        }
        return title;
    }

    /**
     * This method is used to click on return selection button
     * 
     * @author Pratush.Manglik
     * @return
     * @throws Exception
     */
    public UnitIntroductionPage clickReturnSelection() throws Exception {
        logInstruction("LOG INSTRUCTION : CLICK ON RETURN SELECTION BUTTON");
        try {
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnReturn, waitTime);
            btnReturn.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CLICK ON RETURN SELECTION BUTTON \n METHOD :clickReturnSelection" + e
                            .getLocalizedMessage());
        }
        return new UnitIntroductionPage(uiDriver);
    }

}
