package testcases;

import com.microsoft.playwright.*;

public class LaunchBrowser {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(1680, 913)
        );

        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

}
