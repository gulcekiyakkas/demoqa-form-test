# DemoQA Register Tests

## Scenario: Fill and submit complete form

* Navigate to form page
* Enter first name "Gulce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Select gender "Female"
* Enter phone number "5551234567"
* Set date of birth "05", "February", "2003"
* Enter subject "Maths"
* Select hobby "Reading"
* Upload picture "src/test/resources/photo.jpeg"
* Enter address "12 Street"
* Select state "NCR,Delhi"
* Click submit button
* The submission should be successful
* Close the browser



## Scenario: Form should not submit with invalid email

* Navigate to form page
* Enter first name "Ali"
* Enter last name "Kaya"
* Enter email "invalid-email"
* Enter phone number "5551234567"
* Select gender "Male"
* Click submit button
* Modal should not be displayed
* Close the browser



## Scenario: Submit form with invalid email and empty phone number

* Navigate to form page
* Enter first name "Gülce"
* Enter last name "Yıldız"
* Enter email "gulce.test.com"
* Enter phone number ""
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser



## Scenario: Submit form with invalid characters in first name

* Navigate to form page
* Enter first name "Gülce@!"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "5380000000"
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser



## Scenario: Submit form with invalid phone number

* Navigate to form page
* Enter first name "Gülce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "12abc456!"
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser




## Scenario: Submit form without required fields

* Navigate to form page
* Enter first name "Test"
* Enter last name "User"
* Click submit button
* Modal should not be displayed
* Close the browser



## Scenario: Submit form without first name

* Navigate to form page
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "5551234567"
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser


## Scenario: Form submission without phone number should not be successful

* Navigate to form page
* Enter first name "Gulce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser




## Scenario: Submit form with multiple hobbies selected
* Navigate to form page
* Enter first name "Gulce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "5551234567"
* Select gender "Female"
* Set date of birth "05", "February", "2003"
* Enter subject "Maths"
* Select multiple hobbies "Reading,Sports"
* Upload picture "src/test/resources/photo.jpeg"
* Enter address "12 Street"
* Select state "NCR,Delhi"
* Click submit button
* The submission should be successful
* Close the browser




## Scenario: Submit form with multiple subjects

* Navigate to form page
* Enter first name "Gülce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "5551234567"
* Select gender "Female"
* Enter multiple subjects "Maths,Chemistry"
* Click submit button
* The submission should be successful
* Close the browser




## Scenario: Positive Form Submission

* Navigate to form page
* Enter first name "Gulce"
* Enter last name "Yıldız"
* Enter email "gulce@test.com"
* Enter phone number "5551234567"
* Select gender "Female"
* Click submit button
* The submission should be successful
* Close the browser



## Scenario: Submit form without last name

* Navigate to form page
* Enter first name "Gülce"
* Enter last name ""
* Enter email "gulce@test.com"
* Enter phone number "5380000000"
* Select gender "Female"
* Click submit button
* Modal should not be displayed
* Close the browser


