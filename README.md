# E2E Automation Test Example

We use the guru99 bank free training [page](http://demo.guru99.com/v4/). 
This Repo is part of a training exercise. I'm trying to create a repo with automatic reports, executed on a pipeline, linked to stories/issues, executed with multi browser, etc.

  - Maven
  - Java (8)
  - Selenium (page object and page factory)
  - Excel (Data provider)
  - Allure reports
  
# Pre Requisites

  - You need to have allure installed if not follow this [Link](https://docs.qameta.io/allure/#_installing_a_commandline)
  - Java 1.8
  - Maven
  
# Use

  - Clone the repo into your local
   ```sh
    $ git clone https://github.com/moisesGlb/e2eAutomationRepo.git
```
  - execute wih maven
   ```sh
    mvn clean test
```
  - After the execution go to your repo, open a terminal and enter the command:
   ```sh
   allure serve allure-results
```

Some Screenshots from allure reporting:
 Overview:
 ![Home Page Report](https://raw.githubusercontent.com/moisesGlb/e2eAutomationRepo/master/readmeImg/Allure_Report.png)
 
Execution Graphs: 
 ![Graphs Page Report]( https://raw.githubusercontent.com/moisesGlb/e2eAutomationRepo/master/readmeImg/Allure_Report3.png)
 