package com.pearson.eselenium.ls.contentitems.unit.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewUnitPages extends BasePageObject {

    /* elements */
    private UIElement txtEquella = createElement(
            UIType.Xpath,
            "//radeditor/a[contains(.,'Sample content - The Overland Track')]");
    private UIElement txtValue = createElement(UIType.Xpath, "//body");
    private UIElement lnkDisplayed = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement lblHeaderTitle = createElement(UIType.Xpath, "//div[@class='pageTitle']");

    /* variables */
    boolean flag = false;
    String strTableTitle = null;
    String strValue = null;

    /* Constructor */
    public ViewUnitPages(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ViewUnitPages";
        logInstruction("LOG INSTRUCTION: ## VIEW UNIT PAGES ##");
    }

    /**
     * This method check Equella Content Displayed
     * 
     * @param String
     *            -equellaContent
     * @return:boolean
     * @author soundarya
     * @throws Exception
     */
    public boolean isEquellaContentDisplayed(String equellaContent) throws Exception {
        flag = false;
        try {
            logInstruction("CHECK EQUELLA CONTENT DISPLAYED");
            frameSwitch.switchToFrameContent();
            txtEquella.replaceValues(equellaContent);
            if (txtEquella.isDisplayedAfterWaiting(waitTime)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK EQUELLA CONTENT DISPLAYED" + "\n METHOD:isEquellaContentDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to get the value displayed for the course tab
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public boolean isValueDisplayedAsStudentView(String valueToSearch) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtValue, waitTime);
            strValue = txtValue.getText();
            if (strValue.contains(valueToSearch)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK FOR THE VALUE" + "\nMETHOD: isValueDisplayedasStudentView \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click on the link displayed in ViewUnitPage
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return
     * @param String
     * @throws Exception
     */

    public void clickLink(String valueToSearch) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON THE LINK DISPLAYED IN VIEWUNITPAGE PAGE");
            frameSwitch.switchToFrameContent();
            lnkDisplayed.replaceValues(valueToSearch);

            if (lnkDisplayed.isDisplayedAfterWaiting(waitTime))
                lnkDisplayed.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE  LINK  DISPLAYED IN VIEWUNITPAGE PAGE" + "\n METHOD:clickLink \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * @category Milestone2 METHOD IS USED TO GET HEADER TITLE
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET HEADER TITLE");
            frameSwitch.switchToContentFrameWithoutMain();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strTableTitle = lblHeaderTitle.getText();
        } catch (Exception e) {

            throw new Exception("UNABLE TO GET HEADER TITLE" + "\n METHOD : getHeaderTitle" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

}