
Feature: Get colors patterns 
as a user i want to get the details of color patterns have received
  
  Scenario: Validate on number of views are greater than 4000 using ColorPatternsAPI
  Given specify the base URL of colourloversAPIs
  When  user defines request parameters , headers and HTTP method 
  Then  The returned response should be is ok 
  And   verify if number of views are greater than 4000
  


