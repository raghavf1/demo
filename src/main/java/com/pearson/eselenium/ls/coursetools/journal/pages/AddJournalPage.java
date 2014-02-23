package com.pearson.eselenium.ls.coursetools.journal.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddJournalPage extends BasePageObject {

    /* UI Element */
    private UIElement btnisXHTMLValidator = createElement(
            UIType.Css,
            "a[title='XHTML Validator']>span");

    /* Constructor */
    public AddJournalPage(UIDriver uiDriver) {
        super(uiDriver);

    }

    /**
     * This Method Will check Whether XHTML Validator is Present Or Not
     * 
     * @return {@link Boolean}
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean isXHTMLValidatorDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERIFIYING XHTML EDITOR");
            frameSwitch.switchToFrameContent();
            return btnisXHTMLValidator.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'xhtml' EDITOR" + "\nMETHOD:isXHTMLValidatorDisplayed\n");
        }

    }

}
