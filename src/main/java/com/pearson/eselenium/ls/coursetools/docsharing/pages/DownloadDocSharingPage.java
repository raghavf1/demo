package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to DownloadDocSharingPage
 * 
 * @category Milestone 2
 * @author Raghav S
 * @param uiDriver
 */

public class DownloadDocSharingPage extends BasePageObject {

    /* UI element declarations for DownloadDocSharingPage */
    private UIElement gettitle = createElement(UIType.Css, "div[class='tablehead']");
    private UIElement lbldisplayed = createElement(UIType.Xpath, "//th[contains(text(),'{1}')]");;
    private UIElement lbltimedisplayed = createElement(UIType.Css, ".dkgraytext");;
    private UIElement lnkname = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    
    /* Variables*/
    
    private String strHeaderName = null;
    private String strTimedDisplay = null;
    boolean flag = false;
    
    
    
    /* Constructor */
    public DownloadDocSharingPage(UIDriver driver) {
        super(driver);
        logInstruction("LOGINSTRUCTION:#####DownloadDocSharingPage######");

    }

    /**
     * It accepts header-File/Description,Owner,Date/Time,Size,Share,Name
     * 
     * @category Milestone 2
     * @author Raghav Method helps to Verify a Header is Present or not
     * @return
     * @throws Exception
     */
    public boolean isLabelDisplayed(String header) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING THE LABEL");
            uiDriver.switchTo().defaultContent();
            lbldisplayed.replaceValues(header);
            return lbldisplayed.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFIYING THE LABEL" + "\nMETHOD:isLabelDisplayed\n");
        }
    }

    /**
     * @category Milestone 2
     * @author Raghav Method helps to getHeadertitle
     * @return
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOGINSTRUCTION:GETTING THE HEADER TITLE");
            uiDriver.switchTo().defaultContent();
            uiDriver.waitToBeDisplayed(gettitle, waitTime);
            strHeaderName = gettitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'header' TITLE" + "\nMETHOD:getHeaderTitle\n");
        }
        return strHeaderName;
    }

    /**
     * Method helps to Verify a * Times are displayed in (GMT+05:30) Chennai, Kolkata, Mumbai, New
     * Delhi is Present or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return
     * @throws Exception
     */

    public boolean isTimesDisplayed() throws Exception {
       

        try {
            logInstruction("LOGINSTRUCTION:VERIFIYING THE TIME DISPLAYED");
            uiDriver.switchTo().defaultContent();
            lbltimedisplayed.isDisplayedAfterWaiting(waitTime);
            strTimedDisplay = lbltimedisplayed.getText().trim();
            if (strTimedDisplay != null) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFIYING 'time' DISPLAYED" + "\nisTimesDisplayed\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on the Link in DownloadDocSharingPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return
     * @throws Exception
     */

    public DownloadDocSharingPage clickOnLink(String linkname) throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:CLICK ON THE LINK");
            uiDriver.switchTo().defaultContent();
            String browser = System.getProperty("browser.NAME");
            lnkname.replaceValues(linkname);
            lnkname.isDisplayedAfterWaiting(waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                lnkname.clickByJavascript();
                Thread.sleep(waitTime); // Since clickByJavascript() is hanging, performing the same
            } else {
                lnkname.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE LINK" + "\nMETHOD:clickOnLink\n");
        }
        return this;

    }
}
