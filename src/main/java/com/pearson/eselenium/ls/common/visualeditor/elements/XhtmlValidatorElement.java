package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.XhtmlValidatorPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class XhtmlValidatorElement extends BasicPieceObject {
	
	private boolean flag = false;
	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));

    /*Constructor*/
	public XhtmlValidatorElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click Xhtml Validator Button
     * 
     * @author soundarya
     * @return XhtmlValidatorpage
     * @throws Exception
     */
    public XhtmlValidatorPage clickXhtmlValidatorButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click Xhtml Validator Button");
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Xhtml Validator Button \n METHOD: clickXhtmlValidatorButton" + e
                    .getLocalizedMessage());
        }
        return new XhtmlValidatorPage(uiDriver);
    }

    /**
     * This Method will check whether XHTML Validator is displayed or not
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isXHTMLValidatorDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: checking whether XHTML Validator is Displayed");
            if (root.isDisplayedAfterWaiting(waitTime))
                flag = true;
            else
            	flag = false;

        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the XHTML Validator");
        }
        return flag;
    }
}