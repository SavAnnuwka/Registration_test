package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;


public class RegistrationHelper extends HelperWithWebDriverBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * PAGE 1
     */
    public void fillRegistrationForm(String name, String org, String email) {
        pages.registrationPage.setNameField(name);
        pages.registrationPage.setOrganisationField(org);
        pages.registrationPage.setEmailField(email);
    }
    public void fillRegistrationFormFromClipBoard(String name, String org, String email) {
        pages.registrationPage.setNameFieldfromClipBoard(name);
        pages.registrationPage.setOrganisationFieldfromClipBoard(org);
        pages.registrationPage.setEmailFieldgromClipBoard(email);
    }
    public void clickRegisterButton() {
        pages.registrationPage.clickSubmitButton();
    }
    public String getValue(String field) {
        if (field == Constant.NAME) {
            return pages.registrationPage.getUsername().toString();
        }
        if (field == Constant.ORGANISATION) {
            return pages.registrationPage.getOrganisation().toString();
        }
        if (field == Constant.EMAIL) {
            return pages.registrationPage.getEmail().toString();
        }
        return "Incorrect result. No  error";
    }
    public String getTextError(String field) {
        if (field == Constant.NAME) {
            return pages.errorPage.getNameError();
        }
        if (field == Constant.ORGANISATION) {
            return pages.errorPage.getOrganisationError();
        }
        if (field == Constant.EMAIL) {
            return pages.errorPage.getEmailError();
        }
        if (field == Constant.LICENCE_AGREE) {
            return pages.errorPage.getLicenceAgreeError();
        }
        return "Incorrect result. No  error";
    }
    public String getText(String field) {
        if (field == Constant.LICENCE_AGREE) {
            return pages.licencePage.getLicenceAgree();
        }
        if (field == Constant.TITLE) {
            return pages.registrationPage.getTitle();
        }
        if (field == Constant.DESCRIPTION) {
            return pages.registrationPage.getDescription();
        }
        return "Incorrect result. No  text";
    }
    public boolean checkRegistrationPage() throws InterruptedException {
        wait(pages.registrationPage.getRegistrationPage(), 60);
        return pages.registrationPage.IsLoadRegistrationPage();
    }

    /**
     * PAGE 2
     */
    public void confirmCheckbox() {
        pages.licencePage.setLicenceAgree();
    }
    public void clickRegisterLicencePageButton() {
        pages.licencePage.clickSubmitButton();
    }
    public boolean checkLicencePage() throws InterruptedException {
        wait(pages.licencePage.getLicencePage(), 60);
        return pages.licencePage.IsLoadLicencePage();
    }

    /**
     * PAGE 3
     */
    public boolean checkFinishRegistrationPage() throws InterruptedException {
        wait(pages.finishRegistrationPage.getFinishRegistrationPage(), 60);
        return pages.finishRegistrationPage.IsLoadFinishPage();
    }

    /**
     * PAGE 4 (password)
     *
     */

    public void enterPassword(String pass) {
        pages.passwordPage.setPasswordField(pages.passwordPage.getPassword(), pass);
    }
    public void enterConfirmPassword(String pass) {
        pages.passwordPage.setPasswordField(pages.passwordPage.getConfirmPassword(), pass);
    }
    public void clickSubmitPasswordButton() {
        pages.passwordPage.clickSubmitButton();
    }


}

