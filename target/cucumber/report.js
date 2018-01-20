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
      "name": "@LoginFeature"
    }
  ]
});
formatter.before({
  "duration": 20828816567,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Check the HR Administrator user with valid credential is successfully logged in",
  "description": "",
  "id": "check-login-functionality-of-hr-administrator-page;check-the-hr-administrator-user-with-valid-credential-is-successfully-logged-in",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@login"
    },
    {
      "line": 3,
      "name": "@regression"
    },
    {
      "line": 3,
      "name": "@positive"
    },
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "enter the username as \"civihr_admin\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "enter the password as \"civihr_admin\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "click on the Log in button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "check following menu labels are shown: home, Search, Staff, Tasks, Leave, Recruitment, Configure, Help",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "duration": 454378008,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "civihr_admin",
      "offset": 23
    }
  ],
  "location": "LoginStepDefs.enter_the_username_as(String)"
});
formatter.result({
  "duration": 959080516,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "civihr_admin",
      "offset": 23
    }
  ],
  "location": "LoginStepDefs.enter_the_password_as(String)"
});
formatter.result({
  "duration": 720316468,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.click_on_the_Log_in_button()"
});
formatter.result({
  "duration": 10994923518,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "home, Search, Staff, Tasks, Leave, Recruitment, Configure, Help",
      "offset": 39
    }
  ],
  "location": "DashboardStepDefs.check_following_menu_labels_are_shown(String\u003e)"
});
formatter.result({
  "duration": 1260239898,
  "status": "passed"
});
formatter.after({
  "duration": 736888634,
  "status": "passed"
});
});