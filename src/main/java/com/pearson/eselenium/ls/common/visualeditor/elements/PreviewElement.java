package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class PreviewElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

	/*Constructor*/
	public PreviewElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click PreviewButton on RadEditor
     * 
     * @author monica.anand
     * @return PreviewElement
     * @throws Exception
     */
    public PreviewElement clickPreviewButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on PreviewButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON PreviewButton \n METHOD: clickPreviewButton" + e.getLocalizedMessage());
        }
        return this;
    }
}
