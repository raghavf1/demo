package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.PastePlainTextPage;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class PastePlainTextElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));

	/*Constructor*/
	public PastePlainTextElement(UIElement element) {
        super(element);
    }

    /**	
     * Method helps to click Paste Plain Text Button
     * 
     * @author soundarya
     * @return PastePlainTextPage
     * @throws Exception
     */
    public PastePlainTextPage clickPastePlainTextButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK Paste Plain Text Button");
            root.clickAndWait(waitTime);
            if(System.getProperty("browser.NAME").equalsIgnoreCase("internetexplorer")){
            	AutoITMethods autoITMethods=new AutoITMethods();
            	autoITMethods.handleClipboardAccessPopUp("Allow");
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Paste Plain Text Button \n METHOD: clickPastePlainTextButton" + e
                    .getLocalizedMessage());
        }
        return new PastePlainTextPage(uiDriver);
    }
}
