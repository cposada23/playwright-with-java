# Playwright with Java

> Documentation: https://playwright.dev/java/docs/intro


## Installing All the things

####  NodeJS:
>Recomended using a tool like nvm. If you are using mac follow the steps here: https://github.com/nvm-sh/nvm

> Verify that you have the following in you bash profile or zshrc file. To know what type of profile you are using, in a terminal run ***echo $0***
> if your terminal echoed zsh the file that you need to look is  **_~/.zshrc_**, if you don't have it, create it and paste what you see down below
> If your terminal is bash then the file you should look is -   **_~/.bash_profile_**

    export NVM_DIR="$HOME/.nvm"
	[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
	[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion

> Use the LTS version of node

Useful commands for nvm

    // Install the lts version
    nvm install node
    // List all node version taht you have
    nvm list
    // Use a version of node
    nvm use <node version>

#### Install Java JDK
> You can use this page to download the latests sdks: https://adoptium.net/
> Follow this page for more details on how to setup java in mac: https://mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/

After you installed the sdk, you need to set the JAVA_HOME variable in your profile ( if mac in your .zshrc or .bash_profile (read nvm installation ) or windows in your env variables )

> On mac to check where is java installed you can run the following command **_ /usr/libexec/java_home _**. You'll need this to set JAVA_HOME variable

Mac users: on your .zshrc file add the following:

    export JAVA_HOME=$(/usr/libexec/java_home)

> Now, check the java installation by running ***java --version*** on your terminal

#### Maven
> https://maven.apache.org/what-is-maven.html

Go to the downloads page and Download the `Binary tar.gz archive`, then open a terminal, cd to the download folder and extract it like this: `tar -xvf apache-maven-3.6.3-bin.tar.gz`

Move the extracted folder where you want it,  and add it to the env variables in your terminal profile like this (replace it with the path to the folder)

    export M2_HOME=/Users/$USER/Library/apache-maven-3.9.1
    export PATH="${M2_HOME}/bin:${PATH}"
To test if maven was successfully installed, close the terminal and open a new one and test it with `mvn -version`

#### Set up a maven project

> The code for the initial par of this document you can find it here: https://github.com/cposada23/appium-java. If you are only interested in the final framework look here: <TODO>

For this course, I'm following with IntelliJ IDEA ( Community Edition ) but you can use Eclipse or the IDE that you prefer. Create a new Maven project and these are the dependencies you'll need:

> Get the Java Client for Appium here: https://mvnrepository.com/artifact/io.appium/java-client select the latest version


## Getting started

- Create a new maven project
- Add paywrigth dependency:
```xml 
<!-- https://mvnrepository.com/artifact/com.microsoft.playwright/playwright -->  
<dependency>  
 <groupId>com.microsoft.playwright</groupId>  
 <artifactId>playwright</artifactId>  
 <version>1.35.1</version>  
</dependency> 
```


### Sample test case ( Launching a browser )

```java
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
```

 