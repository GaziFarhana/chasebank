Feature: US100201 Checking Find a Credit Card Functionality.
Scenario Outline: As a user i am checking i should be able to find a credit card.
Given i am at Chase homepage
When i click on "<findCC>"
And i click on "<learnMore>"
Then i click on "<applyNow>"
And i enter "<firstName>" "<fname>"
And i enter "<middleIni>" "<mname>"
And i enter "<lastName>" "<lname>"
Then i enter "<address1>" "<street>"
And i enter "<apartment>" "<apt>"
Then i enter "<city>" "<cityname>"
And i select "<state>" "<statename>"
Then i enter "<zip>" "<zipcode>"
And i click on "<next>"





Examples:
|findCC|learnMore|applyNow|firstName|fname| middleIni|mname|lastName|lname|address1|street|apartment|apt|city|cityname|state|statename|zip|zipcode|next|
|findCC|learnMore|applyNow|firstName|Trisha|middleIni|T    |lastName|Hasan|address1|391 lake view|apartment|3rd Fl|city|Brooklyn|state|NY|zip|11391|next|
