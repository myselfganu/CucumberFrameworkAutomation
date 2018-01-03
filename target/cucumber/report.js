$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("editAccount.feature");
formatter.feature({
  "line": 1,
  "name": "Check the Edit Account functionality",
  "description": "",
  "id": "check-the-edit-account-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 52196795391,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Check that edit account page is shown to the user",
  "description": "",
  "id": "check-the-edit-account-functionality;check-that-edit-account-page-is-shown-to-the-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@editAccount"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "user is logged using the credentials \"civihr_admin\" and \"civihr_admin\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "hover mouse over the user image on the right corner",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "click on Edit Account link",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "civihr_admin",
      "offset": 38
    },
    {
      "val": "civihr_admin",
      "offset": 57
    }
  ],
  "location": "LoginStepDefs.user_is_logged_using_the_credentials_and(String,String)"
});
formatter.result({
  "duration": 17375268000,
  "status": "passed"
});
formatter.match({
  "location": "DashboardStepDefs.hover_mouse_over_the_user_image_on_the_right_corner()"
});
formatter.result({
  "duration": 1743790824,
  "status": "passed"
});
formatter.match({
  "location": "DashboardStepDefs.click_on_Edit_Account_link()"
});
formatter.result({
  "duration": 3087043024,
  "status": "passed"
});
formatter.after({
  "duration": 21788903590,
  "status": "passed"
});
});