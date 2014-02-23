package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewThreadTopicPage extends BasePageObject {

    /* Elements */
    private UIElement txtTopicName = createElement(
            UIType.Xpath,
            "//table[@role='presentation']//tbody/tr[td/h2/div[@class='tablehead']]");
    private UIElement lnkRespond = createElement(
            UIType.Xpath,
            "//table[@role='presentation']//tbody/tr[td/a[@title='Respond']]");

    boolean flag = false;
    /* Constructor */
    public ViewThreadTopicPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ViewThreadTopicPage";
        logInstruction("## ViewThreadTopic Page ##");

    }

    /**
     * Method helps to verify specified topic name is displayed or not
     * 
     * @param String
     *            -strTopicName
     * @author soundarya
     * @throws Exception
     * @return boolean
     */
    public boolean isTopicNameDisplayed(String strTopicName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING PROVIDED TOPIC NAME '" + strTopicName + "' IS PRESENT OR NOT");
            frameSwitch.switchToFrameContent();
            txtTopicName.replaceValues(strTopicName);
            flag = txtTopicName.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING PROVIDED TOPIC NAME '" + strTopicName + "' IS PRESENT OR NOT" + "\nMETHOD:isTopicNameDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to click respond link
     * 
     * @author soundarya
     * @return ViewRespondTopicPage
     * @throws Exception
     */

    public ViewRespondTopicPage clickRespondLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Respond' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkRespond, waitTime);
            lnkRespond.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Respond' LINK" + "\nMETHOD:clickRespondLink \n" + e
                            .getLocalizedMessage());
        }
        return new ViewRespondTopicPage(uiDriver);
    }
}
