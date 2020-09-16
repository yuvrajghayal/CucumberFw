@Ui @Healthcheck
Feature : E-commerce project Web site HealthCheck

Scenario: User is able to Open the browser, navigate to the URL and Search for Product
  Given User opened Browser
  And User Navigated to home application URL
  When User Search for product "Laptop"
  Then Searched Product displayed