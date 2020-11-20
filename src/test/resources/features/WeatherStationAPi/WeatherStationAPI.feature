@WeatherAPI
Feature: Open API Weather Station: Task to implement an API Testing Solution for it.

  Scenario Outline: Validate 401 Response Code by passing Invalid Api Key
    Given User added the Payload values "<external_id>","<name>","<latitude>","<longitude>" and "<altitude>"
    When User sends Post request to service with Invalid api Key
    Then API response header should have status code as "401"
    Examples:
      |external_id |name                      |latitude|longitude|altitude|
      |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |

  Scenario Outline: Validate 201 Response Code by passing Valid Api Key
    Given User added the Payload values "<external_id>","<name>","<latitude>","<longitude>" and "<altitude>"
    When User sends Post request to service with Valid api Key
    Then API response header should have status code as "201"
    Examples:
      |external_id |name                      |latitude|longitude|altitude|
      |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |
      |DEMO_TEST002|Team Demo Test Station 002|44.44   |-122.44  |111     |

  Scenario Outline: Validate 200 Response Code by passing Valid Api Key
    Given User sends valid get request to the service
    Then API response header should have status code as "200"
    Then API Response should contain values "<external_id>","<name>","<latitude>","<longitude>" and "<altitude>"
    Examples:
      |external_id |name                      |latitude|longitude|altitude|
      |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |
      |DEMO_TEST002|Team Demo Test Station 002|44.44   |-122.44  |111     |
