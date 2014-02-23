package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewRespondTopicPage extends BasePageObject {

    /* Elements */

    private UIElement lnkAddRemove = createElement(UIType.Xpath, "//a[@title='Add/Remove']");
    private UIElement areaRadEditor = createElement(UIType.ID, "RadeEntryText_contentIframe");
    private UIElement lblHeaderTitle = createElement(UIType.Css, "div.pageTitle>h1");
    private UIElement lnkExpandAll = createElement(UIType.ID, "tableExpandedAll");
    private UIElement lnkRespond = createElement(
            UIType.Xpath,
            "//table[@class='threadborder']//a[@title='Respond']");
    private String strTitle = null;
    boolean flag = false;

    /* Constructor */
    public ViewRespondTopicPage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "ViewRespondTopicPage";
        logInstruction("## View Respond Topic Page ##");
    }

    /**
     * Method helps to check RadEditorDisplayed For View Respond Topic Page
     * 
     * @return boolean
     * @author usha.reddy
     * @throws Exception
     */

    public boolean isRadEditorDisplayedForViewRespondTopicPage() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING 'Rad Editor' IS DISPLAYED FOR VIEWRESPONDTOPIC PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(areaRadEditor, waitTime);
            flag = areaRadEditor.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING 'Rad Editor'" + "\nMETHOD:isRadEditorDisplayedForViewRespondTopicPage \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for AddRemove Link
     * 
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isAddRemoveLinkDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING 'AddRemove' LINK IS DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkAddRemove, waitTime);
            flag = lnkAddRemove.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING 'AddRemove' LINK" + "\nMETHOD:isAddRemoveLinkDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to get View Respond topic Page Header name
     * 
     * @author Usha
     * @return String - title
     * @throws Exception
     */
    public String getHeaderName() throws Exception {
        strTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'View Respond topic Page Header'");
            frameSwitch.switchToFrameContent();
            strTitle = lblHeaderTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'View Respond topic Page Header'" + "\nMETHOD:getHeaderName \n" + e
                            .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * Method helps to click on the respond link
     * 
     * @author Usha
     * @return ThreadRespondPage
     * @throws Exception
     */
    public ThreadRespondPage clickRespondLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Respond' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkRespond, waitTime);
            lnkRespond.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'Respond' LINK" + "\nMETHOD:clickRespondLink \n" + e
                            .getLocalizedMessage());
        }
        return new ThreadRespondPage(uiDriver);
    }

    /**
     * Method helps to click on the ExpandAll link
     * 
     * @author Usha
     * @return void
     * @throws Exception
     */
    public void clickExpandAllButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE 'ExpandAll' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkExpandAll, waitTime);
            lnkExpandAll.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'ExpandAll' LINK" + "\nMETHOD:clickExpandAllButton \n" + e
                            .getLocalizedMessage());
        }
    }

}
