package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class ZoomElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

	/*Constructor*/
	public ZoomElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click ZoomButton on RadEditor
     * 
     * @author monica.anand
     * @return ZoomElement
     * @throws Exception
     */
    public ZoomElement clickZoomButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ZoomButton");
            //switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON ZoomButton \n METHOD:clickZoomButton" + e.getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to select zoom option
     * 
     * @author monica.anand
     * @return ZoomElement
     * @throws Exception
     */
    public ZoomElement selectZoomOption(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT ZoomOption");
            switchToFrame.switchToFrameContent();
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.selectByVisibleText(text);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT ZoomOption \n METHOD: selectZoomOption" + e.getLocalizedMessage());
        }
        return this;

    }
}
