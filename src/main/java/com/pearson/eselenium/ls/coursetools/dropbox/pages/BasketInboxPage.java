package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods of Assignment Page. Navigation --> 1) Login as Prof/Admin 2) Select Course
 * 3) Click 'Dropbox' 4) Click 'Basket' Tab 5) Click Student Name.
 * 
 * @author soundarya
 * @modifiedBy Vivek.Singh -- as per code review comments by Lanka Pearson
 * **/
public class BasketInboxPage extends BasePageObject {

    /* UIElements */
    private UIElement lnkInbox = createElement(
            UIType.Xpath,
            "//table[2]//tr/td[@class='tableheadtabON']");
    private UIElement imgEmail = createElement(UIType.Xpath, "//a[contains(.,'Send Email')]");

	private boolean flag = false;
    /* Constructor */
    public BasketInboxPage(UIDriver driver) {
        super(driver);
        pageTitle = "Basket Inbox";
        logInstruction("LOG INSTRUCTION: ##  BasketInboxPage ##");
    }

    /**
     * This method will check 'Inbox' link is displayed or not.
     * 
     * @author soundarya
     * @return boolean
     * @throws Exception
     **/
    public boolean isInboxDisplayed() throws Exception {
		flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK 'Inbox' LINK DISPLAYED");
            frameSwitch.switchToFrameContent();
			flag = lnkInbox.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
					"UNABLE TO CHECK 'Inbox' LINK DISPLAYED. \nMETHOD: isInboxDisplayed.\n"
							+ e.getLocalizedMessage());
        }
		return flag;
    }

    /**
     * This method will click eamil icon. Navigates to {@link GradeBookDropboxPage}.
     * 
     * @author soundarya
     * @return {@link GradeBookDropboxPage}
     * @throws Exception
     **/
    public GradeBookDropboxPage clickEmailIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK 'Email' ICON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgEmail, waitTime);
            imgEmail.clickAndWait(waitTime);
        } catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK 'Email' ICON. \nMETHOD: clickEmailIcon.\n"
							+ e.getLocalizedMessage());
        }
        return new GradeBookDropboxPage(uiDriver);
    }
}
