package tests;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import youtube.NamePage;
import youtube.YoutubePage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class OpenYouTubeTest extends BaseTest {

    private String name;

    YoutubePage youtubePage;
    NamePage namePage;

    @BeforeTest
    @Parameters({"name"})
    public void param(String name){
        this.name = name;

    }

    @Test
    public void searchProgramInYoutube()  {
        youtubePage = new YoutubePage(driver);
        youtubePage.goToYoutube();
        youtubePage.searchName(name);
        namePage = youtubePage.clickSearch();
        //String title = namePage.getTitle();
        //assertThat(title, is("YouTube"));
    }
}
