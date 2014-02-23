package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.MathEquationEditorPage;
import com.pearson.eselenium.ls.coursetools.gradebook.pages.GradebookDetailsUIPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class MathEquationEditorElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public MathEquationEditorElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click Math Equation Editor Button
     * 
     * @author soundarya
     * @return MathEquationEditorPage
     * @throws Exception
     */
    public MathEquationEditorPage clickMathEquationEditorButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK ON Math Equation Editor Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            try {
                if (GradebookDetailsUIPage.name.equalsIgnoreCase("INBOX")) {
                    uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
                    root.clickAndWait(waitTime);
                } else {
                    uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
                    root.clickAndWait(waitTime);
                }
            } catch (Exception e1) {
                throw new Exception(
                        "UNABLE TO CLICK ON MATH EQUATION BUTTON \n METHOD: clickMathEquationEditorButton");
            }
        }

        return new MathEquationEditorPage(uiDriver);
    }
}
