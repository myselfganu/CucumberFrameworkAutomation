$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 2,
  "name": "Check login functionality of HR Administrator page",
  "description": "",
  "id": "check-login-functionality-of-hr-administrator-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@loginFeature"
    }
  ]
});
formatter.before({
  "duration": 15389139532,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 17,
      "value": "# test case made to test the fail scenario and the report creation"
    }
  ],
  "line": 19,
  "name": "Check that login button is diable",
  "description": "",
  "id": "check-login-functionality-of-hr-administrator-page;check-that-login-button-is-diable",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@loginFalseFail"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "check the login button has text \"LoginIn\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "duration": 634952648,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginIn",
      "offset": 33
    }
  ],
  "location": "LoginStepDefs.check_the_login_button_has_text(String)"
});
formatter.result({
  "duration": 183184796,
  "error_message": "java.lang.AssertionError: Login button doesnot contain the text\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat in.raster.cucumber.pages.LoginPage.checkLoginButtonText(LoginPage.java:46)\r\n\tat in.raster.cucumber.steps.LoginStepDefs.check_the_login_button_has_text(LoginStepDefs.java:77)\r\n\tat ✽.Then check the login button has text \"LoginIn\"(login.feature:21)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("Check that login button is diable");
formatter.after({
  "duration": 2029125571,
  "status": "passed"
});
});