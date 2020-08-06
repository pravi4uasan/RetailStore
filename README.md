# RetailStore
Retail Store Discount calculation application ,
API is used to calculate total bill amount for each purchase by applying below given discounts
1. If	the	user	is	an	employee	of	the	store,	he	gets	a	30%	discount
2. If	the	user	is	an	affiliate	of	the	store,	he	gets	a	10%	discount
3. If	the	user	has	been	a	customer	for	over	2	years,	he	gets	a	5%	discount.
4. For	every	$100	on	the	bill,	there	would	be	a	$	5	discount	(e.g.	for	$	990,	you	get	$	45	as	a	discount).
5. The	percentage	based	discounts	do	not	apply	on	groceries.
6. A	user	can	get	only	one	of	the	percentage	based	discounts	on	a	bill

Step to set up Project:-

Clone or download project from https://github.com/pravi4uasan/RetailStore 

import as maven project ,
do maven clean ,
Start application by using RetailDiscountCalculation.java , 
Test application in postman with this URL http://localhost:8080/retailstore/billamount ,
Sample json request file is available on this path https://github.com/pravi4uasan/RetailStore/blob/master/RetailStoreBill.json ,

To Run Junit
Right click on RetailDiscountCalculationTest.java and run Junit Test ,
Junit will covered all basic test cases

To Run code covereage
Right click on project and goto Run configaration and select maven 
Goals- clean install ,
This will run all test cases and coverage with jacoco and report will be available at this path ,
/discount/target/site/jacoco/index.html
Screen shot of code coverage is avaialble at https://github.com/pravi4uasan/RetailStore/blob/master/CodeCoverage.docx

UML diagram of application is avaialable at https://github.com/pravi4uasan/RetailStore/blob/master/UMLDiagram.jpg


