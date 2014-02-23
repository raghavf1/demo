package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;

public class EditEssayPage extends BasePageObject {

    /* Elements */
    private String questionRadToolId = "RadWindowWrapper_RADQuestionText_toolbarMode";
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


    /* Constructor */
    public EditEssayPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION : ### EditEssayPage ###");
    }

    public VisualEditor getQuestionRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return questionRad;
    }


    public VisualEditor getGeneralExplanationRadEditor() throws Exception {
    	 frameSwitch.switchToFrameContent();
        return generalExplanationRad;
    }

}
