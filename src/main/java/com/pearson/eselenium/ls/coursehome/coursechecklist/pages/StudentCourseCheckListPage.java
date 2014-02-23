package com.pearson.eselenium.ls.coursehome.coursechecklist.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods for the StudentCourseCheckListPage
 * 
 * @author praveen.maled
 * 
 */
/**
 * @author Praveen.Maled
 * 
 */
public class StudentCourseCheckListPage extends BasePageObject {

    /* UIElements of the page */
    private UIElement lblCourseCheckListHeader = createElement(
            UIType.Xpath,
            "//div[@class='pageTitle']/h1");
    private UIElement lnkBack = createElement(
            UIType.Xpath,
            "//form[@id='UnitCourseChecklistView']/div[3]/a[@title='back']");
    private UIElement lnkdueDate = createElement(UIType.Css, "a[title='Due Date']");
    // private UIElement unitNewPage;
    // private UIElement message;
    private UIElement lblCheckListHeading = createElement(UIType.Css, ".pageTitle");
    private UIElement tblCourseCheckListPage = createElement(UIType.Css, ".outercontenttable");
    // private UIElement txtexpandAllcourseCheckList;
    private UIElement imgExpandAllCourseCheckList = createElement(
            UIType.Xpath,
            "//a[@id='courseChecklist_expandAllLink']/img");
    private UIElement imgCollapseCourseCheckList = createElement(
            UIType.Xpath,
            "//a[@id='courseChecklist_collapseAllLink']/img");
    private UIElement lblSortByDisplayed = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']//table//tr/td[@align='{1}']");
    private UIElement imgBacklink = createElement(UIType.Css, ".back_large_double_angle");
    private UIElement chkassignmentCheckedCheckbox = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th//label[text()='{2}']]//th/input[@checked]");
    private UIElements lstunitNumber = createElements(UIType.Css, "[id*=expanded] th a");
    private UIElements lstStdunitNumber = createElements(UIType.Css, "[id*=expanded] th a");
    private UIElement spnUnitDate = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_expanded']/td[2]");
    private UIElement spnOldUnitDate = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_expanded']/td[2]/span");
    private UIElement lnkUnitContentItemGo = createElement(
            UIType.Xpath,
            "//tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th//label[text()='{2}]]/td/a");
    private UIElement imgunitContentItemGolink = createElement(
            UIType.Xpath,
            "//tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th//label[text()='{2}']]/td/a/img");
    private UIElement txtUnitContentitemafterDuedate = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th/label[text()='{2}'']]//td[2]");;
    private UIElement txtUnitContentitembeforeDuedate = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th/label[text()='{2}']]//td/span");
    private UIElements lstContentItemNumber = createElements(
            UIType.Css,
            ".courseChecklist{1}_expanded th label");
    private UIElement imgunitexpandicon = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_expanded']/td[1]/a/img");
    private UIElement imgunitcollapseicon = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_collapsed']/td[1]/a/img");
    private UIElement lnkExpandAll = createElement(UIType.ID, "courseChecklist_expandAllLink");
    private UIElement lnkCollapseAll = createElement(UIType.ID, "courseChecklist_collapseAllLink");
    private UIElement lnkCollapsedUnitGo = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_collapsed']/td[3]/a/img");
    private UIElement lnkexpandedUnitGo = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_expanded']/td[3]/a/img");
    private UIElement txtNavigatedUnitPageHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement txtNavigatedContentItemPageHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement txtNavigatedUnitPageDescription = createElement(UIType.Xpath, "//html/body");
    private UIElement txtnavigatedContetnItemPageDescription = createElement(
            UIType.Xpath,
            "//html/body");
    private UIElement chkassignmentdisabledCheckbox = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th//label[text()='{2}'']]//th/input[@disabled]");
    private UIElement lnkUnit = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']/tbody/tr/td/table[1]/tbody/tr[2]/td[1]/a");
    private UIElements lstDuedates = createElements(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr/td[2]");
    private UIElements imgexporcollapseinsidetable = createElements(
            UIType.Css,
            ".innercontenttable tbody tr td a.expandlesson img");
    // private UIElement chklist;
    private UIElement tbltableHeading = createElement(UIType.Css, ".tablehead");
    private UIElement txttableInstruction = createElement(
            UIType.Xpath,
            "//table[@class='outercontenttable']/tbody/tr/td/table/tbody/tr[1]/td[1]");
    private UIElement imgcollapseditems = createElement(
            UIType.Css,
            ".innercontenttable tbody tr[id*=collapsed] td a.expandlesson img");
    private UIElement lnkcourseorUnit = createElement(
            UIType.Xpath,
            "//tr[@id='courseChecklist{1}_expanded']/th/a");
    private UIElement txtthreadexist = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]//following-sibling::tr[th//label[text()='{2}']]//th//label");
    private UIElement chkContentItem = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']/tbody//tr[th//a[contains(text(),'{1}')]]/following-sibling::tr[th//label[text()='{2}']]//th/input");
    private UIElements lstStdcollapsedunitNumber = createElements(
            UIType.Css,
            "[id*=collapsed] th a");
    private UIElement txtbeforeDuedate = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr[{1}]/td[1]");
    private UIElement txtafterDuedate = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr[{1}]/td[1]/span");
    String strDateFormat = "MM/dd/yyyy hh:mm a";

    private static final String COURSE_CHECKLIST = "Course Checklist";
    private static final String DATE_FORMAT = "00/0/0000 00:00 AM";
    private static final String RED_TEXT = "redtext";
    private static final String CLASS = "class";
    private static final String COURSE_HOME = "Course  Home";

    private boolean flag = false;
    private boolean flag2 = false;
    private String strResult = null;
    int intUnitnumber = -1;
    int intContentItemNumber = -1;
    int intNumber = 0;
    ArrayList<Integer> arlNumbers = new ArrayList<Integer>();
    ArrayList<String> arlContentItems = new ArrayList<String>();
    ArrayList<String> arlAllUnits = new ArrayList<String>();
    ArrayList<String> arlListOfContetnItems = new ArrayList<String>();
    List<UIElement> lstUnitNames = new ArrayList<UIElement>();
    ArrayList<String> arlListUnits = new ArrayList<String>();
    List<UIElement> lstUnitNamesList = new ArrayList<UIElement>();
    List<UIElement> lstDueDates = new ArrayList<UIElement>();
    List<UIElement> lstContentItemNames = new ArrayList<UIElement>();
    List<UIElement> lstContentItemNamesList = new ArrayList<UIElement>();
    List<UIElement> lstSecondUnitNames = new ArrayList<UIElement>();
    /* Constructor */
    public StudentCourseCheckListPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "StudentCourseCheckListPage";
        logInstruction("##Student Course Check List Page##");
    }

    /**
     * This method checks whether the thread is available or not,it return the boolean value
     * 
     * @param String
     *            - strUnitname, strNameOfThread
     * @author praveen.maled
     * @return boolean
     * @throws Exception
     */
    public boolean isThreadDisplayed(String strUnitname, String strNameOfThread) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THE 'Thread' IS PRESENT OR NOT");
            frameSwitch.switchToFrameContent();
            txtthreadexist.replaceValues(strUnitname, strNameOfThread);
            flag = txtthreadexist.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK THE THREAD" + "\nMETHOD:isThreadDisplayed() \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks whether the course home is displayed or not
     * 
     * @author praveen maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseCheckListPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING THE 'Course home' HEADER");
            frameSwitch.switchToFrameContent();
            lblCourseCheckListHeader.isDisplayedAfterWaiting(waitTime);
            if (COURSE_CHECKLIST.equalsIgnoreCase(lblCourseCheckListHeader.getText()))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK THE COURSE HOME HEADER" + "\nMETHOD: isCourseCheckListPageDisplayed() \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method clicks the backLink
     * 
     * @author Praveen.Maled
     * @return:NextCourseHomePage
     * @throws Exception
     */
    public NextCourseHomePage clickBackLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Back' LINK ");
            frameSwitch.switchToFrameContent();
            lnkBack.isDisplayedAfterWaiting(waitTime);
            lnkBack.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON 'Back' LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE BACK LINK" + "\nMETHOD: clickBackLink() \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This method clicks the checkbox
     * 
     * @param String
     *            - unitname, nameofThread
     * @return:StudentCourseCheckListPage
     * @author ashish.juyal
     * @throws Exception
     */
    public StudentCourseCheckListPage clickCheckBox(String strUnitname, String strNameofThread)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'checkbox'");
            if (StringUtils.isBlank(strUnitname) || StringUtils.isBlank(strNameofThread))
                throw new Exception(
                        "EITHER UNITNAME OR NAME OF THREAD VALUE IS NULL UNIT NAME " + strUnitname + "NAME OF THREAD " + strNameofThread + "\nMETHOD: clickCheckBox()\n");
            frameSwitch.switchToFrameContent();
            chkContentItem.replaceValues(strUnitname, strNameofThread);
            chkContentItem.isDisplayedAfterWaiting(waitTime);
            chkContentItem.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABEL TO CLICK ON THE CHECKBOX" + "\nMETHOD: clickCheckBox()\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method uncheck the checkbox
     * 
     * @param String
     *            - unitname, nameofThread
     * @return:CourseCheckListPage
     * @author praveen.maled
     * @throws Exception
     */
    public StudentCourseCheckListPage uncheckCheckbox(String strUnitname, String strNameofThread)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: UNCHECKING THE 'checkbox' ");
            if (StringUtils.isBlank(strUnitname) || StringUtils.isBlank(strNameofThread))
                throw new Exception(
                        "EITHER UNITNAME OR NAME OF THREAD VALUE IS NULL UNIT NAME " + strUnitname + "NAME OF THREAD " + strNameofThread + "\nMETHOD: uncheckCheckbox()\n");
            frameSwitch.switchToFrameContent();
            chkContentItem.replaceValues(strUnitname, strNameofThread);
            chkContentItem.isDisplayedAfterWaiting(waitTime);
            if (isCheckboxChecked(strUnitname, strNameofThread)) {
                chkContentItem.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO UNCHECK THE CHECKBOX" + "\nMETHOD: uncheckCheckbox()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks on the go link based on the thread name given
     * 
     * @return StudentCourseCheckListPage
     * @param String
     *            - unitname, nameofThread
     * @throws Exception
     * @author praveen.maled
     */
    public StudentCourseCheckListPage clickContentItemGoLink(
            String strUnitname,
            String strNameofThread) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Go' link");
            if (StringUtils.isBlank(strUnitname) || StringUtils.isBlank(strNameofThread))
                throw new Exception(
                        "EITHER UNITNAME OR NAME OF THREAD VALUE IS NULL UNIT NAME " + strUnitname + "NAME OF THREAD " + strNameofThread + "\nMETHOD: clickContentItemGoLink()\n");
            frameSwitch.switchToFrameContent();
            lnkUnitContentItemGo.replaceValues(strUnitname, strNameofThread);
            lnkUnitContentItemGo.isDisplayedAfterWaiting(waitTime);
            lnkUnitContentItemGo.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON CONTENT ITEM 'Go' LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE GO LINK" + "\nMETHOD:clickContentItemGoLink()\n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks the duedate link
     * 
     * @return StudentCourseCheckListPage
     * @author ashish.juyal
     * @throws Exception
     */

    public StudentCourseCheckListPage clickDueDateLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Duedate' LINK");
            frameSwitch.switchToFrameContent();
            lnkdueDate.isDisplayedAfterWaiting(waitTime);
            lnkdueDate.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON 'DueDate' LINK");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE DUEDATE LINK" + "\nMETHOD:clickDueDateLink()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method verifies whether the course check list page heading is displayed or not ,returns
     * the boolean function
     * 
     * @return String
     * @author hemant.kumar
     * @throws Exception
     */
    public String getPageHeading() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE 'page heading' OF COURSE CHECKLIST PAGE");
            frameSwitch.switchToFrameContent();
            lblCheckListHeading.isDisplayedAfterWaiting(waitTime);
            strResult = lblCheckListHeading.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND THE COURSE CHECKLIST PAGE HEADING" + "\nMETHOD:getPageHeading()\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method verifies whether the table is available on course check list page or not,returns
     * the boolean function
     * 
     * @return boolean
     * @author hemant.kumar
     * @throws Exception
     */
    public boolean isTableDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE 'Table' ON COURSE CHECKLIST PAGE");
            frameSwitch.switchToFrameContent();
            flag = tblCourseCheckListPage.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE FIND THE TABLE" + "\nMETHOD:isTableDisplayed()\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks the String sortBy,New Unit and Due Date is displayed or not
     * 
     * @param String
     *            allignment, texttobeddisplayed
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isStringDisplayed(String strAllignement, String strTextToBeDisplayed)
            throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION: CHECKING FOR 'SortBy/unit/duedate' DISPLAYED OR NOT");
            if (StringUtils.isBlank(strAllignement) || StringUtils.isBlank(strTextToBeDisplayed))
                throw new Exception(
                        "EITHER ALLIGNMENT OR TEXT TO BE DISPLAYED VALUE IS NULL ALLIGNMENT " + strAllignement + "TEXT TO BE DISPLAYED " + strTextToBeDisplayed + "\nMETHOD: isStringDisplayed()\n");

            frameSwitch.switchToFrameContent();
            lblSortByDisplayed.replaceValues(strAllignement);
            lblSortByDisplayed.isDisplayedAfterWaiting(waitTime);

            if (strTextToBeDisplayed.contains(lblSortByDisplayed.getText())) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND THE SORTBY" + "\nMETHOD:isStringDisplayed()\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify the due dates are arranged in ascending order or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isDueDatesinAscendingOrder() throws Exception {

        flag = false;
        flag2 = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'DueDates' ORDER");
            frameSwitch.switchToFrameContent();

            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            Date dtPrevious = sdf.parse(DATE_FORMAT);
            Date dtCurrent = sdf.parse(DATE_FORMAT);

            lstDueDates = lstDuedates.getUIElementsList();
            for (int i = 2; i < lstDueDates.size() + 1; i++) {
                txtbeforeDuedate.replaceValues(String.valueOf(i));
                txtafterDuedate.replaceValues(String.valueOf(i));
                if (txtbeforeDuedate.isDisplayedAfterWaiting() && txtbeforeDuedate.getText()
                        .contains("/")) {
                    dtCurrent = sdf.parse(txtbeforeDuedate.getText());
                } else
                    if (txtafterDuedate.isDisplayedAfterWaiting() && txtbeforeDuedate.getText()
                            .contains("/")) {
                        dtCurrent = sdf.parse(txtafterDuedate.getText());
                    } else {
                        flag = true;
                        continue;
                    }
                if (!flag && dtCurrent.compareTo(dtPrevious) >= 0) {
                    dtPrevious = dtCurrent;
                } else {
                    flag2 = false;
                    break;
                }
                flag2 = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CHECK DUE DATES ORDER" + "\nMETHOD:isDueDatesinAscendingOrder()\n" + e
                            .getLocalizedMessage());
        }
        return flag2;
    }

    /**
     * Method will verify expand or collapse icon is present
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandorCollapseExistinsideTable() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Expand or Collapse img' EXIST INSIDE TABLE OR NOT");
            frameSwitch.switchToFrameContent();
            flag = imgexporcollapseinsidetable.areAllPresent();
        } catch (Exception e) {
            throw new Exception(
                    "EXPAND OR COLLAPSE NOT PRESENT INSIDE TABLE:" + "\nMETHOD:isExpandorCollapseExistinsideTable()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify whether checkbox is present or not in the CheckListPage
     * 
     * @param tring
     *            unitname,contentItem
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckBoxExist(String strUnitName, String strContentItem) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'checkbox' IS PRESENT IN THE PAGE OR NOT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentItem))
                throw new Exception(
                        "EITHER UNIT NAME OR CONTENT ITEM VALUE IS NULL ALLIGNMENT " + strUnitName + "CONTENT ITEM " + strContentItem + "\nMETHOD: isCheckBoxExist()\n");

            frameSwitch.switchToFrameContent();
            chkContentItem.replaceValues(strUnitName, strContentItem);
            chkContentItem.isDisplayedAfterWaiting(waitTime);
            flag = chkContentItem.isPresent();

        } catch (Exception e) {
            throw new Exception("CHECK BOX NOT PRESENT" + "\nMETHOD:isCheckBoxExist()\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify the table heading displayed correct or not
     * 
     * @author Praveen.Maled
     * @param strTableheader
     * @return boolean
     * @throws Exception
     */
    public boolean isTableHeaderExist(String strTableheader) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Table heading' ");
            if (StringUtils.isBlank(strTableheader))
                throw new Exception(
                        "TABLE HEADER IS NULL " + strTableheader + "\nMETHOD: isTableHeaderExist()\n");

            tbltableHeading.isDisplayedAfterWaiting(waitTime);
            if (tbltableHeading.getText().equalsIgnoreCase(strTableheader)) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "TABLE HEADER IS NOT PRESENT" + "\nMETHOD:isTableHeaderExist()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: header:" + flag);
        return flag;
    }

    /**
     * Method will verify the the instructional text inside course checklist table is displayed
     * correctly or not
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getTableInstructionalText() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING COURSE CHECKLIST TABLE 'Instructional text' IS CORRECT OR NOT");
            txttableInstruction.isDisplayedAfterWaiting(waitTime);
            strResult = txttableInstruction.getText();
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO GET COURSE CHECKLIST TABLE INSTRUCTIONAL TEXT" + "\nMETHOD:getTableInstructionalText()\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will verify the unit name link is present inside the table or not on specified row
     * number
     * 
     * @author Praveen.Maled
     * @param intRowNo
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */

    public boolean isCourseHomeorUnitLinkExist(int intRowNo, String strUnitName) throws Exception {
        flag = false;

        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Course home link' IS EXIST ARE NOT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT HEADER IS NULL " + strUnitName + "\nMETHOD: isCourseHomeorUnitLinkExist()\n");
            frameSwitch.switchToFrameContent();
            lnkcourseorUnit.replaceValues(String.valueOf((intRowNo - 1)));
            lnkcourseorUnit.isDisplayedAfterWaiting(waitTime);
            if (lnkcourseorUnit.getText().trim().equalsIgnoreCase(strUnitName.trim())) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    strUnitName + "LINK IS NOT AVAILABLE" + "\nMETHOD:isCourseHomeorUnitLinkExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify that all the sections are expanded are not in course check list page
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isAllSectionsExpanded() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: verifying all sections are expanded");
            frameSwitch.switchToFrameContent();
            if (imgCollapseCourseCheckList.isDisplayedAfterWaiting(waitTime) && !imgcollapseditems
                    .isDisplayedAfterWaiting()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception("ERROR WHILE FINDING EXPAND IMAGES" + e.getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: expanded:" + flag);
        return flag;
    }

    /**
     * Method will check Due date is exist for particular unit are not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitDuedateExist(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {

            logInstruction("LOG INSTRUCTION: VERIFYING 'Duedate' EXIST FOR CONTENT ITEM OR NOT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isUnitDuedateExist()\n");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnOldUnitDate.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            if (spnUnitDate.isDisplayedAfterWaiting(waitTime) && spnUnitDate.getText()
                    .contains("/")) {
                flag = true;
            } else
                if (spnOldUnitDate.isDisplayedAfterWaiting() && spnOldUnitDate.getText().contains(
                        "/")) {
                    flag = true;
                }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO FIND UNIT DUE DATE" + "\nMETHOD:isUnitDuedateExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will return the due date of specified unit in the form of String
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return String
     * @throws Exception
     */
    public String getUnitDueDate(String strUnitName) throws Exception {
        strResult = null;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETING 'Duedate' FOR A  UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isCourseHomeorUnitLinkExist()\n");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnOldUnitDate.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            if (spnUnitDate.isDisplayedAfterWaiting(waitTime) && spnUnitDate.getText()
                    .contains("/")) {
                strResult = spnUnitDate.getText();

            } else
                if (spnOldUnitDate.isDisplayedAfterWaiting() && spnOldUnitDate.getText().contains(
                        "/")) {
                    strResult = spnOldUnitDate.getText();
                }
        } catch (Exception e) {
            throw new Exception("FAILED TO GET UNIT DUEDATE" + "\nMETHOD:getUnitDueDate()\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check the due date color for the unit is red or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isunitDuedatecolorchanged(String strUnitName) throws Exception {
        flag = false;
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Duedate color' IS RED OR NOT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isunitDuedatecolorchanged()\n");
            intNumber = getunitNumber(strUnitName);
            spnUnitDate.replaceValues(String.valueOf(intNumber));
            spnOldUnitDate.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            spnUnitDate.isDisplayedAfterWaiting(waitTime);
            if (spnUnitDate.getAttribute("class").contains("redtext")) {
                flag = true;
            } else
                if (spnOldUnitDate.isDisplayedAfterWaiting()) {
                    if (spnOldUnitDate.getAttribute("class").contains("redtext")) {
                        flag = true;
                    }
                }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO VERIFY UNIT DUEDATE COLOR" + "\nMETHOD: isunitDuedatecolorchanged()\n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * method will return the unit row number in table based on unit name
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return int
     * @throws Exception
     */
    public int getunitNumber(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Unit row number' IN THE COURSE CHECKLIST ");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: getunitNumber()\n");
            frameSwitch.switchToFrameContent();
            lstUnitNamesList = lstStdunitNumber.getUIElementsList();
            for (UIElement number : lstUnitNamesList) {
                intUnitnumber++;
                if (number.getText().contains(strUnitName)) {
                    return intUnitnumber;
                }
            }
            intUnitnumber = -1;
            lstUnitNamesList = lstStdcollapsedunitNumber.getUIElementsList();
            for (UIElement number : lstUnitNamesList) {
                intUnitnumber++;
                if (number.getText().contains(strUnitName)) {
                    return intUnitnumber;
                }
            }
        } catch (Exception e) {
            throw new Exception("FAILED TO FIND UNIT TNUMBER" + "\nMETHOD:getunitNumber()\n" + e
                    .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: UNIT ROW NUMBER:" + intUnitnumber);
        return -1;
    }

    /**
     * method will return the content item number row inside the unit
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return ArrayList<Integer>
     * @throws Exception
     */
    public ArrayList<Integer> getContetntItemrowNumber(String strUnitName, String strContentitem)
            throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Unit row number' IN TABLE AND CONTENT ITEM NUMBER INSIDE UNIT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: getContetntItemrowNumber()\n");

            intNumber = getunitNumber(strUnitName);
            arlNumbers.add(intNumber);
            lstContentItemNumber.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            lstContentItemNames = lstContentItemNumber.getUIElementsList();
            for (UIElement objUIElementNumber : lstContentItemNames) {
                intContentItemNumber++;
                if (objUIElementNumber.getText().contains(strContentitem)) {
                    arlNumbers.add(intContentItemNumber);
                    return arlNumbers;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO GET CONTENT ITEM NUMBER" + "\nMETHOD:getContetntItemrowNumber()\n" + e
                            .getLocalizedMessage());
        }
        return arlNumbers;
    }

    /**
     * method will verify whether golink for mentioned content item is exist or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean iscontentItemGolinkExist(String strUnitName, String strContentitem)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Golink' IS PRESENT FOR CONTENT ITEM OR NOT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: iscontentItemGolinkExist()\n");
            frameSwitch.switchToFrameContent();
            lnkUnitContentItemGo.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            lnkUnitContentItemGo.isDisplayedAfterWaiting(waitTime);
            flag = lnkUnitContentItemGo.isPresent();
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO FIND GOLINK" + "\nMETHOD:iscontentItemGolinkExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify whether Golink image is exist for specific content item
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean iscontentItemGolinkImageExist(String strUnitName, String strContentitem)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Golink image' IS PRESENT FOR CONTENT ITEM OR NOT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: iscontentItemGolinkImageExist()\n");
            frameSwitch.switchToFrameContent();
            imgunitContentItemGolink.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            imgunitContentItemGolink.isDisplayedAfterWaiting(waitTime);
            flag = imgunitContentItemGolink.isPresent();
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO FIND GOLINK IMAGE. \nMETHOD: iscontentItemGolinkImageExist()." + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method to get all the content items inside the specified unitName
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return ArrayList<String>
     * @throws Exception
     */
    public ArrayList<String> getContentItemsofUnit(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Contentitems' INSIDE THE UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: getContentItemsofUnit()\n");
            lstContentItemNumber.replaceValues(String.valueOf(getunitNumber(strUnitName)));
            frameSwitch.switchToFrameContent();
            lstContentItemNamesList = lstContentItemNumber.getUIElementsList();
            for (int i = 0; i < lstContentItemNamesList.size(); i++) {
                arlContentItems.add(lstContentItemNamesList.get(i).getText());
            }

        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO GET CONTENT ITEMS \nMETHOD:getContentItemsofUnit()\n" + e
                            .getLocalizedMessage());
        }
        return arlContentItems;
    }

    /**
     * Method will click on unit link top of right side next to Sort By text
     * 
     * @author Praveen.Maled
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickonUnitLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE 'Unit link' ");
            frameSwitch.switchToFrameContent();
            if (lnkUnit.isDisplayedAfterWaiting(waitTime)) {
                lnkUnit.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION: 'Unit link' IS CLICKED");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE UNIT LINK...\nMETHOD:clickonUnitLink()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method will return the complete unit caption for specified unit shown in the
     * coursechecklistpage page
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return String
     * @throws Exception
     */
    public String geCompletUnitCaption(String strUnitName) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING COMPLETE 'unit name' SHOWN IN THE COURSECHECKLIST PAGE");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: geCompletUnitCaption()\n");

            frameSwitch.switchToFrameContent();
            lstSecondUnitNames = lstunitNumber.getUIElementsList();
            for (UIElement unit : lstSecondUnitNames) {
                if (unit.getText().contains(strUnitName)) {
                    strResult = unit.getText().trim();
                }
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET UNIT CAPTION..\nMETHOD:geCompletUnitCaption()\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will verify The page after clicking on duedate link
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isDuedateLinkDataDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'duedate link' DATA IS DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            imgExpandAllCourseCheckList.isDisplayedAfterWaiting(waitTime);
            if (!imgExpandAllCourseCheckList.isPresent()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO VERIFY DUE DATE DATA...\nMETHOD:isDuedateLinkDataDisplayed()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: DISPLAYED:" + flag);
        return flag;

    }

    /**
     * Method will on expand icon of the specified unit if its not expanded
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickonExapanduniticon(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON 'expand icon' OF UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: clickonExapanduniticon()\n");

            frameSwitch.switchToFrameContent();
            imgunitexpandicon.replaceValues(String.valueOf(getunitNumber(strUnitName)));
            if (imgunitexpandicon.isDisplayedAfterWaiting(waitTime)) {
                    imgunitexpandicon.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON THE UNIT EXPAND ICON" + e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will click on collapse icon of specified unit if its expanded
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickonCollapseuniticon(String strUnitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Expand' ICON OF UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: clickonCollapseuniticon()\n");

            frameSwitch.switchToFrameContent();
            imgunitcollapseicon.replaceValues(String.valueOf(getunitNumber(strUnitName)));
            if (imgunitcollapseicon.isDisplayedAfterWaiting(waitTime)) {
                    imgunitcollapseicon.clickAndWait(waitTime);
                }

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON THE UNIT COLLAPSE ICON...\nMETHOD:clickonExapanduniticon()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will check ExpandAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandAllLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'ExpandAll' link EXIST OR NOT");
            frameSwitch.switchToFrameContent();
            flag = lnkExpandAll.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND EXPANDALL LINK...\nMETHOD:isExpandAllLinkExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check COllapseAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCollapseAllLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'CollapseAll' link EXIST OR NOT");
            frameSwitch.switchToFrameContent();
            flag = lnkCollapseAll.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND COLLAPSEALL LINK...\nMETHOD:isCollapseAllLinkExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check ExpandAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickExpandAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'ExpandAll' linK ");
            frameSwitch.switchToFrameContent();
            lnkExpandAll.isDisplayedAfterWaiting(waitTime);
            lnkExpandAll.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON 'ExpandAll' link");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND EXPANDALL LINK...\nMETHOD:clickExpandAllLink()\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method will click on COllapseAll link is showing in page or not
     * 
     * @author Praveen.Maled
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickCollapseAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'CollapseAll' LINK");
            frameSwitch.switchToFrameContent();
            if (lnkCollapseAll.isDisplayedAfterWaiting(waitTime)) {
                lnkCollapseAll.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND COLLAPSEALL LINK...\nMETHOD:clickCollapseAllLink()\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method will click on the Go link of specified unit, return type is void as navigated page
     * varied from one to another
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @throws Exception
     */
    public void clickonUnitGoLink(String strUnitName) throws Exception {
        intNumber = 0;
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Go' LINK OF A UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: clickonCollapseuniticon()\n");

            intNumber = getunitNumber(strUnitName);
            lnkexpandedUnitGo.replaceValues(String.valueOf(intNumber));
            lnkCollapsedUnitGo.replaceValues(String.valueOf(intNumber));
            frameSwitch.switchToFrameContent();
            if (lnkexpandedUnitGo.isDisplayedAfterWaiting(waitTime)) {
                lnkexpandedUnitGo.clickAndWait(waitTime);
            } else
                if (lnkCollapsedUnitGo.isDisplayedAfterWaiting()) {
                    lnkCollapsedUnitGo.clickAndWait(waitTime);
                }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON UNIT GO LINK...\nMETHOD:clickonUnitGoLink()\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method will return the Navigated unit page title
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedUnitPageHeader() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Page title' AFTER CLICKING ON UNIT GOLINK");
            frameSwitch.switchToFrameContent();
            if (txtNavigatedUnitPageHeader.isDisplayedAfterWaiting(waitTime)) {
                strResult = txtNavigatedUnitPageHeader.getText().trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND PAGE TITLE...\nMETHOD:getNavigatedUnitPageHeader()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: HEADER OF NAVIGATED UNIT PAGE:" + strResult);
        return strResult;
    }

    /**
     * Method will get the navigated content item page title
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedContentItemPageHeader() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Page title' AFTER CLICKING ON CONTENTITEM GOLINK");
            frameSwitch.switchToFrameContent();
            if (txtNavigatedContentItemPageHeader.isDisplayedAfterWaiting(waitTime)) {
                strResult = txtNavigatedContentItemPageHeader.getText().trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND CONTENT ITEM PAGE TITLE...\nMETHOD:getNavigatedContentItemPageHeader()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: HEADER OF NAVIGATED CONTENT ITEM PAGE: " + strResult);
        return strResult;

    }

    /**
     * Method will check unit page description is exist
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitDescriptionExistinNavigatedPage() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING UNIT PAGE 'Description' ");
            frameSwitch.switchToFrameContent();
            txtNavigatedUnitPageDescription.isDisplayedAfterWaiting(waitTime);
            flag = txtNavigatedUnitPageDescription.isPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND PAGE DESCRIPTION...\nMETHOD:isUnitDescriptionExistinNavigatedPage()\n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * method will return the content item page description in text format
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedContentItemPageDescription() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CONTENT ITEM PAGE 'Description' ");
            frameSwitch.switchToFrameContent();
            txtnavigatedContetnItemPageDescription.isDisplayedAfterWaiting(waitTime);
            strResult = txtnavigatedContetnItemPageDescription.getText().substring(
                    txtnavigatedContetnItemPageDescription.getText().indexOf("\n")).trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CONTENT ITEM PAGE DESCRIPTION...\nMETHOD:getNavigatedContentItemPageDescription()\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * method will return the unit page description in text format
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     */
    public String getNavigatedUnitPageDescription() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING UNIT PAGE 'Description' ");
            frameSwitch.switchToFrameContent();
            if (txtNavigatedUnitPageDescription.isDisplayedAfterWaiting(waitTime)) {
                strResult = txtNavigatedUnitPageDescription.getText().substring(
                        txtNavigatedUnitPageDescription.getText().indexOf("\n")).trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET UNIT PAGE DESCRIPTION...\nMETHOD:getNavigatedUnitPageDescription()\n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check content item due date is exist for specified unit and content item
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemDuedateExist(String strUnitName, String strContentitem)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING CONTENTITEM 'Duedate' ");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: isContentItemDuedateExist()\n");

            frameSwitch.switchToFrameContent();
            txtUnitContentitembeforeDuedate.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            txtUnitContentitemafterDuedate.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            if (txtUnitContentitembeforeDuedate.isPresent() && txtUnitContentitembeforeDuedate
                    .getText().contains("/")) {
                flag = true;
            } else
                if (txtUnitContentitemafterDuedate.isDisplayedAfterWaiting() && txtUnitContentitemafterDuedate
                        .getText().contains("/")) {
                    flag = true;
                }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND CONTENT ITEM DUE DATE...\nMETHOD:isContentItemDuedateExist()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: CONTENT ITEM 'Due date' EXIST:" + flag);
        return flag;
    }

    /**
     * method will return the due date of the content item based on the specified unit or coursename
     * and contentItem CourseHome and unit locators are different, both are used in same method
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemDuedateColorChanged(String strUnitName, String strContentitem)
            throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CONTENTITEM 'Duedate' ");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: isContentItemDuedateExist()\n");

            frameSwitch.switchToFrameContent();
            txtUnitContentitembeforeDuedate.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            txtUnitContentitemafterDuedate.replaceValues(String.valueOf(strUnitName), String
                    .valueOf(strContentitem));
            if (txtUnitContentitembeforeDuedate.isPresent() && txtUnitContentitembeforeDuedate
                    .getAttribute(CLASS).equalsIgnoreCase(RED_TEXT)) {
                flag = true;
            } else
                if (txtUnitContentitemafterDuedate.isPresent() && txtUnitContentitemafterDuedate
                        .getAttribute(CLASS).equalsIgnoreCase(RED_TEXT)) {
                    flag = true;
                }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO VERIFY DUE DATE COLOR...\nMETHOD:isContentItemDuedateColorChanged()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: CONTENT ITEM 'Due Date color' CHANGED:" + flag);
        return flag;
    }

    /**
     * method will return the due date of the content item based on the specified unit or coursename
     * and contentItem CourseHome and unit locators are different, both are used in same method
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return String
     * @throws Exception
     */
    public String getContentItemDuedate(String strUnitName, String strContentitem) throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CONTENTITEM 'Duedate' ");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: getContentItemDuedate()\n");
            frameSwitch.switchToFrameContent();
            txtUnitContentitembeforeDuedate.replaceValues(strUnitName, strContentitem);
            txtUnitContentitemafterDuedate.replaceValues(strUnitName, strContentitem);
            if (txtUnitContentitembeforeDuedate.isPresent()) {
                strResult = txtUnitContentitembeforeDuedate.getText().trim();
            } else {
                strResult = txtUnitContentitemafterDuedate.getText().trim();
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO GET CONTENT ITEM DUE DATE...\nMETHOD:getContentItemDuedate()\n" + e
                            .getLocalizedMessage());
        }
        logInstruction("LOG INSTRUCTION: CONTENT ITEM 'DueDate':" + strResult);
        return strResult;
    }

    /**
     * Method will verify whether check box is clickable or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckboxClickable(String strUnitName, String strContentitem) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'checkbox' IS CLICKABLE OR NOT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: isCheckboxClickable()\n");
            chkassignmentdisabledCheckbox.replaceValues(strUnitName, strContentitem);
            frameSwitch.switchToFrameContent();
            flag = chkassignmentdisabledCheckbox.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "NOT ABLE TO FIND DISABLED CHECKBOX...\nMETHOD:isCheckboxClickable()\n");
        }
        return flag;
    }

    /**
     * Method will verify check box is checked or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @param strContentitem
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckboxChecked(String strUnitName, String strContentitem) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'checkbox' IS CHECKED OR NOT");
            if (StringUtils.isBlank(strUnitName) || StringUtils.isBlank(strContentitem))
                throw new Exception(
                        "UNIT NAME OR CONTENT ITEM IS NULL " + strUnitName + " CONTENT ITEM " + strContentitem + "\nMETHOD: isCheckboxChecked()\n");

            chkassignmentCheckedCheckbox.replaceValues(strUnitName, strContentitem);
            frameSwitch.switchToFrameContent();
            flag = chkassignmentCheckedCheckbox.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "NOT ABLE TO FIND CHECKED CHECKBOX...\nMETHOD:isCheckboxChecked()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify the back link is exist or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isBackLinkExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING Back link' EXIST OR NOT");
            frameSwitch.switchToFrameContent();
            flag = lnkBack.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("BACK LINK IS NOT PRESENT...\nMETHOD:isBackLinkExist()\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method to verify img for back link caption is exist or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isBacklinkimgExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Back link image' EXIST OR NOT");
            frameSwitch.switchToFrameContent();
            flag = imgBacklink.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "BACK LINK  IMAGE IS NOT PRESENT...\nMETHOD:isBacklinkimgExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check expand all icon exist or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandAllIconExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'ExpandAll icon' EXISTS OR NOT");
            frameSwitch.switchToFrameContent();
            flag = imgExpandAllCourseCheckList.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "EXPAND ALL ICON NOT PRESENT...\nMETHOD:isExpandAllIconExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify collapse all icon showing or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     */
    public boolean isCollapseAllIconExist() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'CollapseAll icon' EXISTS OR NOT");
            frameSwitch.switchToFrameContent();
            flag = imgCollapseCourseCheckList.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "COLLAPSE ALL ICON NOT PRESENT...\nMETHOD:isCollapseAllIconExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check expand all link exist or not
     * 
     * @author Praveen.Maled
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickExpandAllIcon() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'ExpandAll icon' ");
            frameSwitch.switchToFrameContent();
            if (imgExpandAllCourseCheckList.isDisplayedAfterWaiting(waitTime)) {
                    imgExpandAllCourseCheckList.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK ON EXPAND ALL ICON...\nMETHOD:clickExpandAllIcon()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will click collapse all icon
     * 
     * @author Praveen.Maled
     * @return StudentCourseCheckListPage
     * @throws Exception
     */
    public StudentCourseCheckListPage clickCollapseAllIcon() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'CollapseAll icon' ");
            frameSwitch.switchToFrameContent();
            if (imgCollapseCourseCheckList.isDisplayedAfterWaiting(waitTime)) {
                    imgCollapseCourseCheckList.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "FAILED TO CLICK ON COLLAPSED ALL ICON...\nMETHOD:clickCollapseAllIcon()\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method will check the content items order
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemsinOrder(String strUnitName) throws Exception {
        flag = false;
        try {
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isContentItemsinOrder()\n");

            arlListOfContetnItems = getContentItemsofUnit(strUnitName);
            strResult = ""; // empty string: guaranteed to be less than or equal to any other
            for (String current : arlListOfContetnItems) {
                if (current.compareTo(strResult) < 0) {
                    return flag;
                }
                strResult = current;
            }
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "FAILED WHILE CHECKING CONTENT ITEMS ORDER...\nMETHOD:isContentItemsinOrder()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify is expand icon of the specified unit is showing or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isExapanduniticonExist(String strUnitName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Expand icon' OF UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isContentItemsinOrder()\n");

            imgunitexpandicon.replaceValues(String.valueOf(getunitNumber(strUnitName)));
            flag = imgunitexpandicon.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE UNIT EXPAND ICON...\nMETHOD:isExapanduniticonExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify is collapse icon of specified unit is showing or not
     * 
     * @author Praveen.Maled
     * @param strUnitName
     * @return boolean
     * @throws Exception
     */
    public boolean isCollapseuniticonExist(String strUnitName) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING 'Collapse icon' OF UNIT");
            if (StringUtils.isBlank(strUnitName))
                throw new Exception(
                        "UNIT NAME IS NULL " + strUnitName + "\nMETHOD: isContentItemsinOrder()\n");

            imgunitcollapseicon.replaceValues(String.valueOf(getunitNumber(strUnitName)));
            flag = imgunitcollapseicon.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY THE UNIT COLLAPSE ICON...\nMETHOD:isCollapseuniticonExist()\n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method will get the title of the thread
     * 
     * @author Raghav S
     * @return String - title
     * @throws Exception
     */
    public String getTitleofthread() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING TITLE OF 'Thread' ");
            frameSwitch.switchToFrameContent();
            if (lblCourseCheckListHeader.isDisplayedAfterWaiting(waitTime))
                strResult = lblCourseCheckListHeader.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET TITLE OF THREAD...\nMETHOD:getTitleofthread()\n " + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * method will return the all units in the course check list page
     * 
     * @author Praveen.Maled
     * @param unitName
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList<String> getAllUnits() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'unit number row number' IN THE COURSE CHECKLIST ");
            frameSwitch.switchToFrameContent();
            lstUnitNames = lstStdunitNumber.getUIElementsList();
            for (UIElement objUIElementName : lstUnitNames) {
                if (COURSE_HOME.contains(objUIElementName.getText())) {
                    continue;
                }
                arlAllUnits.add(objUIElementName.getText());
            }
        } catch (Exception e) {
            throw new Exception("FAILED TO FIND UNIT NUMBER...\nMETHOD:getAllUnits()\n" + e
                    .getLocalizedMessage());
        }
        return arlAllUnits;
    }

    /**
     * method will check the Units are in order or not
     * 
     * @author Praveen.Maled
     * @param unitName
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitsAreinOrder() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING 'units are in order' IN THE COURSE CHECKLIST PAGE ");
            arlListUnits = getAllUnits();
            strResult = ""; // empty string: guaranteed to be less than or equal to any
                                     // other
            for (String strCurrent : arlListUnits) {
                if (strCurrent.isEmpty()) {
                    continue;
                }
                if (strCurrent.compareTo(strResult) < 0) {
                    return flag;
                }
                strResult = strCurrent;
            }
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "FAILED WHILE CHECKING UNITS ORDER...\nMETHOD:isUnitsAreinOrder()\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}
