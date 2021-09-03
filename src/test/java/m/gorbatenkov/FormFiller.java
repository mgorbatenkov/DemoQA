package m.gorbatenkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FormFiller {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Mary");
        $("#lastName").setValue("Sue");
        $("#userEmail").setValue("Mary@sue.org");
        $("#gender-radio-2 + label").click();
        $("#userNumber").setValue("7000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/sampleFile.jpeg"));
        $("#currentAddress").setValue("Kailua, Hawaii 96734");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $("tbody").find(withText("Name")).parent().shouldHave(text("Mary Sue"));
        $("tbody").find(withText("Email")).parent().shouldHave(text("Mary@sue.org"));
        $("tbody").find(withText("Gender")).parent().shouldHave(text("Female"));
        $("tbody").find(withText("Mobile")).parent().shouldHave(text("7000000000"));
        $("tbody").find(withText("Birth")).parent().shouldHave(text("21 May,1984"));
        $("tbody").find(withText("Subjects")).parent().shouldHave(text("Maths"));
        $("tbody").find(withText("Hobbies")).parent().shouldHave(text("Reading"));
        $("tbody").find(withText("Picture")).parent().shouldHave(text("sampleFile.jpeg"));
        $("tbody").find(withText("Address")).parent().shouldHave(text("Kailua, Hawaii 96734"));
        $("tbody").find(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
    }
}
