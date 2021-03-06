Feature: Component-test starter

  Background:
    Given the application is up and ready
    And the database is empty

  Scenario: Create contact
    Given service-b replies with data "hello"
    When the following "CREATE CONTACT" REST request is sent:
      | name        | joseph           |
      | email       | toto@yopmail.com |
      | phoneNumber | 083665656        |
    Then the following contact is present in the database, ignoring fields "id":
      | name        | joseph           |
      | email       | toto@yopmail.com |
      | phoneNumber | 083665656        |
      | otherValue  | hello            |
    And the following event has been published:
      | eventType              | CONTACT_CREATED  |
      | attributes.name        | joseph           |
      | attributes.email       | toto@yopmail.com |
      | attributes.phoneNumber | 083665656        |
      | attributes.otherValue  | hello            |

  Scenario: Update contact
    Given the following user in database
      | name        | joseph           |
      | email       | toto@yopmail.com |
      | phoneNumber | 083665656        |
    When the following "UPDATE CONTACT" REST request is sent:
      | name        | joseph      |
      | email       | anotherMail |
      | phoneNumber | 083665656   |
    Then the following contact is present in the database:
      | name        | joseph      |
      | email       | anotherMail |
      | phoneNumber | 083665656   |
    And the following event has been published:
      | eventType              | CONTACT_UPDATED |
      | attributes.name        | joseph          |
      | attributes.email       | anotherMail     |
      | attributes.phoneNumber | 083665656       |

  Scenario: Delete contact
    Given the following user in database
      | name        | joseph           |
      | email       | toto@yopmail.com |
      | phoneNumber | 083665656        |
    When a "DELETE CONTACT" REST request is sent
    Then there is no contact in the database
    And the following event has been published:
      | eventType | CONTACT_DELETED |