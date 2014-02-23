package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;

public class EditTrueFalsePage extends BasePageObject {

    /* Elements */

    private String questionRadToolId = "RADQuestionText";
    private String questionRadFrameId = "RADQuestionText_contentIframe";
    private String questionRadFooterId = "RADQuestionText_ModesWrapper";
    private VisualEditor questionRad = new VisualEditor(
            uiDriver,
            questionRadToolId,
            questionRadFrameId,questionRadFooterId);

    private String generalExplanationRadToolId = "RadWindowWrapper_RADGeneralExplanation_toolbarMode";
    private String generalExplanationRadFrameId = "RADGeneralExplanation_contentIframe";
    private String generalExplanationRadFooterId = "RADGeneralExplanation_ModesWrapper";
    private VisualEditor generalExplanationRad = new VisualEditor(
            uiDriver,
            generalExplanationRadToolId,
            generalExplanationRadFrameId,generalExplanationRadFooterId);

    private String TrueRadToolId = "RadWindowWrapper_RADTrueExplanation_toolbarMode";
    private String TrueRadFrameId = "RADTrueExplanation_contentIframe";
    private String TrueRadFooterId = "RADTrueExplanation_ModesWrapper";
	private VisualEditor TrueRad = new VisualEditor(uiDriver, TrueRadToolId,
			TrueRadFrameId,TrueRadFooterId);


    private String FalseRadToolId = "RadWindowWrapper_RADFalseExplanation_toolbarMode";
    private String FalseRadFrameId = "RADFalseExplanation_contentIframe";
    private String FalseRadFooterId = "RADFalseExplanation_ModesWrapper";
	private VisualEditor FalseRad = new VisualEditor(uiDriver, FalseRadToolId,
			FalseRadFrameId,FalseRadFooterId);
    /* Constructor */
    public EditTrueFalsePage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Edit True False Page ##");
    }

    public VisualEditor getQuestionRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return questionRad;
    }

    public VisualEditor getGeneralExplanationRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return generalExplanationRad;
    }

    public VisualEditor getTrueRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return TrueRad;
    }

    public VisualEditor getFalseRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return FalseRad;
    }
}
