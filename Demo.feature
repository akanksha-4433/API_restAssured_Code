Feature: Get book by ISBN
  
  Scenario: User calls web service to get a book by its ISBN
  Given a book exist with an ISBN of 9789208931293
  When a user retrieves the book by ISBN
  Then the status of code is 200
  And the response includes the following
    | @context 	 		| /contexts/Book					|
    | @id		        | /books		                    | 
  
  Scenario: User creates new entry
   When user send the data in json format
   Then status of code is 201
   
  Scenario: User update the existing entry
  When User send the new data
  Then the status code is 200
  
  Scenario: User delete the existing entry
  When User delete the existing entry
  Then the status code is 204
  
  
  
  
  