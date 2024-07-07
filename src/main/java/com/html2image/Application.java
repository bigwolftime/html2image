package com.html2image;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

/**
 * @author liuxin
 * @date 2024/7/7 16:42
 */
public class Application {

    private static Playwright playwright;
    private static Browser browser;

    static {
        playwright = Playwright.create();
        browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                .setHeadless(true));
    }

    public static void main(String[] args) {
        String file = "file:////tmp/test.html";
        String outFile = "/tmp/test.png";

        Page page = browser.newPage();
        page.navigate(file);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(outFile)).setFullPage(true));

        // 关闭 Playwright 资源
        browser.close();
        playwright.close();
    }

}
