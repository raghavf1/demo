/**
 * 
 */
package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @author Kiran.Kumar2
 * @date Nov 1, 2013
 */

public class ThreadDeletePage extends BasePageObject {

    /* Elements */
    private UIElement btnDelete = createElement(UIType.ID, "deleteButton");
    private UIElement chkIAgreeBox = createElement(UIType.Css, "input#isConfirmed");

    /* Constructor */
    public ThreadDeletePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Thread delete page ##");
    }

    /**
     * Methods helps to click on Delete button
     * 
     * @author Kiran.Kumar2
     * @return ThreadDeletePage
     * @date Nov 1, 2013
     */
    public ThreadDeletePage clickDeletebtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS");
            }

            btnDelete.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Button' \n METHOD: clickDeletebtn \n" + e
                            .getLocalizedMessage());
        }
        return new ThreadDeletePage(uiDriver);
    }

    /**
     * Method helps to select the I agree check box
     * 
     * @author ganapati.bhat
     * @return ThreadDeletePage
     * @throws Exception
     */

    public ThreadDeletePage selectIAgreeCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING I AGREE CHECKBOX");
            frameSwitch.switchToFrameContent();
            if (!chkIAgreeBox.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'I Agree Checkbox' DOES NOT EXISTS");
            }

            chkIAgreeBox.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: I AGREE CHECK BOX CLICKED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'I Agree Checkbox' \n METHOD: selectIAgreeCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return new ThreadDeletePage(uiDriver);
    }

    /**
     * METHOD IS USED TO DELETE CONTENT ITEM
     * 
     * @category milestone 2
     * @author Pratush.Manglik
     * @return NextAuthorHomePage
     * @throws Exception
     */
    public NextAuthorHomePage deleteContentItem() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : DELETE CONTENT ITEM");
            frameSwitch.switchToFrameContent();

            logInstruction("LOG INSTRUCTION : CLICK I AGREE CHECKBOX");
            if (!chkIAgreeBox.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'I Agree Checkbox' DOES NOT EXISTS");
            }
            chkIAgreeBox.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: I AGREE CHECK BOX CLICKED");

            logInstruction("LOG INSTRUCTION : CLICK DELETE BUTTON");
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS");
            }
            btnDelete.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: DELETE BUTTON CLICKED");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO DELETE CONTENT ITEM" + "\n METHOD : deleteContentItem \n" + e
                            .getLocalizedMessage());
        }

        return new NextAuthorHomePage(uiDriver);
    }
}
