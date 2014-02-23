package com.pearson.eselenium.ls.contentitems.webcontent.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class Contains Methods Of Move Web Content Page
 * 
 * @category Milestone2
 * @author amit.deshmukh
 */
public class MoveWebContentPage extends BasePageObject {

    private UIElement txtHeaderTitle = createElement(UIType.Xpath, "//h2[2]/div");

    private UIElement btnClickCancel = createElement(
            UIType.Xpath,
            "//form/table[1]//tbody/tr[4]/td/input[2]");
    private UIElement txtTitle = createElement(UIType.Css, ".pageTitle");
    boolean flag = false;
    String strPageTitle = null;

    /**
     * Constructor
     * 
     * @param driver
     */
    public MoveWebContentPage(UIDriver driver) {
        super(driver);
        pageTitle = "MoveWebContentPage";
        logInstruction("## Move Web Content Page ##");
    }

    /**
     * Methods helps to find Whether ReorderUnits Within Item/Section Is Present Or Not
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return boolean
     */

    public boolean isHeaderTitleDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: checking for the header of the move page");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK THE MOVE PAGE HEADER" + "\n isHeaderTitleDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method helps to click on Cancel
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @throws Exception
     * @returns WebContentToolboxPage
     */
    public WebContentToolboxPage clickOnCancel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on cancel Button");
            frameSwitch.switchToFrameContent();
            btnClickCancel.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON CANCEL" + "\n clickOnCancel \n" + e
                    .getLocalizedMessage());
        }
        return new WebContentToolboxPage(uiDriver);
    }

    /**
     * Methods helps to get page title
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : Get Page Title");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strPageTitle = txtTitle.getText().trim();
            return strPageTitle;
        } catch (Exception e) {
            throw new Exception("unable to get page title" + e.getLocalizedMessage());
        }

    }

}
