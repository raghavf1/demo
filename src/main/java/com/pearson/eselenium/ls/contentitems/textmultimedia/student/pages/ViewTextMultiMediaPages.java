package com.pearson.eselenium.ls.contentitems.textmultimedia.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewTextMultiMediaPages extends BasePageObject {

    /* Elements */
    private UIElement txtValue = createElement(UIType.Xpath, "//html//body");
    private UIElement lnkDisplayed = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");

    boolean flag = false;
    String strText;
    String strContentText;
    
    /* Constructor */
    public ViewTextMultiMediaPages(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## View Text MultimediaHome Page ##");
    }

    /**
     * This method helps to get the value displayed for the course tab
     * 
     * @author ashish.juyal
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isValueDisplayedasStudentView(String strValueToSearch) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE VALUE");
            frameSwitch.switchToFrameContent();
            if (!txtValue.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Value' DOES NOT EXISTS");
            }

            strText = txtValue.getText();
            if (strText.contains(strValueToSearch)) {
                return flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Value' \n METHOD:isValueDisplayedasStudentView \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to click on the link displayed in ViewTextMultimediaPage
     * 
     * @category Milestone 2
     * @author monica.anand
     *  
     * @param String
     * @throws Exception
     */

    public void clickLink(String strValueToSearch) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE LINK DISPLAYED IN COURSEVIEW PAGE");
            frameSwitch.switchToFrameContent();
            lnkDisplayed.replaceValues(strValueToSearch);
            if (!lnkDisplayed.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Link' DOES NOT EXISTS");
            }

            lnkDisplayed.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Link' \n METHOD:clickLink \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This Method will the tag whether the text is not displayed under the span tag
     * 
     * @param String
     *            text which you want to get
     * @return boolean           
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isSpanNotDisplayed(String strText) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THE SPAN");
            frameSwitch.switchToFrameContent();
            UIElement txtContent = createElement(UIType.Xpath, "//html//body//font");

            strContentText = txtContent.getText();
            if (strContentText.contains(strText)) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE FONT \n METHOD: isSpanNotDisplayed \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check whether Embedded video is present or not
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isEmbeddedVideoDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR IFRAME ");
            frameSwitch.switchToFrameContent();

            UIElement frame = uiDriver.findUIElement(UIType.TagName, "iframe");
            if (frame.isDisplayedAfterWaiting(waitTime))
                flag = true;

        } catch (Exception e) {
        	throw new Exception("LOG INSTRUCTION: unable to get the Iframe");
        }
        return flag;
    }
}
