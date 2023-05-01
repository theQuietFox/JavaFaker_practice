package ru.qa.irakulikova;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.FakerDataCreator;
import utils.StudentData;
import utils.SetUp;


public class RegistrationFormWithFakerTest extends SetUp {
    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = FakerDataCreator.getRandomStudent();

    @Test
    void successfulRegistrationForm() {

        registrationPage.openPage()
                .removeBanners()
                .setUserFirstName(studentData.getFirstName())
                .setUserLastName(studentData.getLastName())
                .setUserEmail(studentData.getUserEmail())
                .setUserGender(studentData.getGender())
                .setUserMobileNumber(studentData.getUserPhone())
                .setUserBirthDayDate(studentData.getDay(),
                        studentData.getMonth(),
                        studentData.getYear())
                .setUserSubjects(studentData.getSubject())
                .setUserHobbies(studentData.getHobby())
                .uploadUserPicture(studentData.getFilePath())
                .setUserAddress(studentData.getAddress())
                .setUserState(studentData.getState())
                .setUserCity(studentData.getCity())
                .clickSubmit();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", studentData.getFirstName() + " " +
                        studentData.getLastName())
                .verifyResult("Student Email", studentData.getUserEmail())
                .verifyResult("Gender", studentData.getGender())
                .verifyResult("Mobile", studentData.getUserPhone())
                .verifyResult("Date of Birth", studentData.getDay() + " "
                        + studentData.getMonth() + "," + studentData.getYear())
                .verifyResult("Subjects", studentData.getSubject())
                .verifyResult("Hobbies", studentData.getHobby())
                .verifyResult("Picture", studentData.getFilePath()
                        .substring(studentData.getFilePath().lastIndexOf("/") + 1))
                .verifyResult("Address", studentData.getAddress())
                .verifyResult("State and City", studentData.getState() + " "
                        + studentData.getCity());

    }
}