package com.pearson.eselenium.ls.contentitems.exams.student.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewEssayQuestionpage extends BasePageObject{
	
	private String radframeid="radEntryText_contentIframe";
	private String radtoolid="radEntryText";
	private UIElement btnBeginNow = createElement(UIType.Css, ".buttontd");
	VisualEditor visual=new VisualEditor(uiDriver, radtoolid, radframeid,radtoolid);
	private UIElement saveanswerforgrading=createElement(UIType.ID,"btnSubmitForGrade2");
	private UIElement btnBegin = createElement(UIType.Css, ".buttontd");
	public ViewEssayQuestionpage(UIDriver uiDriver) {
		super(uiDriver);
		
	}
	
	public VisualEditor getVisualEditor(){
		return visual;
	}
	
	/**
	 * This method will click the Begin button on the first page of Exam to be
	 * taken.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ViewEssayQuestionpage clickBeginButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBegin, waitTime);
			btnBegin.click();
			logInstruction("Clicked Begin button.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Begin' BUTTON"
					+ "\n METHOD : clickBeginButton \n"
					+ e.getLocalizedMessage());
		}
	}
	
	
	/**
	 * This method will click the Begin Now button on the second page of Exam to
	 * be taken.
	 * 
	 * @author Vivek.Singh
	 * @return ExamHomePage
	 * @throws Exception
	 * **/
	public ViewEssayQuestionpage clickBeginNowButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON BEGIN NOW BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnBeginNow, waitTime);
			btnBeginNow.click();
			logInstruction("Clicked Begin Now button.");
			return this;
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Begin Now' BUTTON"
					+ "\n METHOD : clickBeginNowButton \n"
					+ e.getLocalizedMessage());
		}
	}
	
	public void clickSaveAnswereButtonforgrading() throws Exception{
		try{
			logInstruction("clicking the save answere button");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(saveanswerforgrading, waitTime);
			saveanswerforgrading.clickAndWait(waitTime);
			uiDriver.getUIAlert().acceptAlertIfPresent();
		}catch(Exception e){
			throw new Exception("LOGINSTRUCTION:Issue in clicking teh button"+e.getLocalizedMessage());
		}
	}

}
