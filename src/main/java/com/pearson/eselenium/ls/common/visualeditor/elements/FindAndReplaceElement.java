package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.FindAndReplacePage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class FindAndReplaceElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public FindAndReplaceElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Find And Replace Button
     * 
     * @author soundarya
     * @return FindAndReplacePage
     * @throws Exception
     */
    public FindAndReplacePage clickFindAndReplaceButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK Find And Replace BUTTON");
            root.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Find And Replace Button \n METHOD: clickFindAndReplaceButton" + e
                    .getLocalizedMessage());
        }
        return new FindAndReplacePage(uiDriver);
    }
}