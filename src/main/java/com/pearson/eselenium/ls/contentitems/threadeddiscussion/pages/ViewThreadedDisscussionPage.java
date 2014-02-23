package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewThreadedDisscussionPage extends BasePageObject {

    private UIElement lblEquellaDisplayed = createElement(UIType.Css, "#listThreadsView>a");
    private UIElement imgEmailIcon = createElement(
            UIType.Xpath,
            "//table[tbody[tr[td[a[contains(.,'{1}')]]]]]//td[5]//a[@title='Email this Author']//img");

    boolean flag;
    
    public ViewThreadedDisscussionPage(UIDriver driver) {
        super(driver);
        pageTitle = "ViewThreadedDisscussionPage";
        logInstruction("## View Threaded Discussion Page ##");
    }

    /**
     * This Method will check whether given Equell content is dispalyed or not.
     * 
     * @param strEquellContent
     *            content which you are searching
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isEquellaContentDisplayed(String strEquellContent) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING EQUELLACONTENT '" + strEquellContent + "' IS DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEquellaDisplayed, waitTime);
            if (StringUtils.isNotBlank(lblEquellaDisplayed.getText().trim())) {
                if (lblEquellaDisplayed.getText().trim().equalsIgnoreCase(strEquellContent)) {
                    flag = true;
                } else {
                    throw new Exception(
                            "ISSUE IN VALIDATING EQUELLACONTENT '" + strEquellContent + "' IS DISPLAYED OR NOT" + "\nMETHOD:isEquellaContentDisplayed \n");
                }
            } else {
                throw new Exception(
                        "EQUELLACONTENT IS NULL '" + strEquellContent + "' IS DISPLAYED OR NOT" + "\nMETHOD:isEquellaContentDisplayed \n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING EQUELLACONTENT '" + strEquellContent + "' IS DISPLAYED OR NOT" + "\nMETHOD:isEquellaContentDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click on the Email icon for response
     * 
     * @param strResponseTitle
     * @author Usha
     * @return EmailResponsePage
     * @throws Exception
     */
    public EmailResponsePage clickEmailIcon(String strResponseTitle) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Email' ICON FOR RESPONSE '" + strResponseTitle + "'");
            frameSwitch.switchToFrameContent();
            imgEmailIcon.replaceValues(strResponseTitle);
            uiDriver.waitToBeDisplayed(imgEmailIcon, waitTime);
            imgEmailIcon.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Email' ICON FOR RESPONSE '" + strResponseTitle + "'" + "\nMETHOD:clickEmailIcon \n" + e
                            .getLocalizedMessage());
        }
        return new EmailResponsePage(uiDriver);
    }
}
