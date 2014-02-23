package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class CopyElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

    /*Constructor*/
	public CopyElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click Copy Button
     * 
     * @author soundarya
     * @return void
     * @throws Exception
     */
    public void clickCopyButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON Copy Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Copy Button \n METHOD: clickCopyButton" + e
            		.getLocalizedMessage());
        }
    }
}