package UItests.UIObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class Header {
    private final SelenideElement logo = $(".logo");
    private final SelenideElement title = $(".title");
    private final SelenideElement notificationBtn = $(".notification");
    private final SelenideElement addProjectBtn = $("[class='fa fa-plus fa-fw']");
    private final SelenideElement userMenuBtn = $(".avatar-letter");

    @Step("User clicks on Add project dropdown and selects Add New Project")
    public NewProject addNewProjectHeader(){
        getAddProjectBtn().shouldBe(Condition.visible).click();
        NewProject selectOpt = new ProjectMenuDD()
                .clickAddNewProject();
        return new NewProject();
    }
}
