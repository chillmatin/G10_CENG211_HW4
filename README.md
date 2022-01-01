# G10_CENG211_HW4
## Authors
Matin Huseynzade: **@chillmetin** <br>
Berke Udunman: **@udunmanned**


## To-do:
- [x] Determine Responsibilities
- [x] Design interfaces
- [ ] Construct UML
- [ ] Implement code
- [ ] Testing


## Responsibilities
Required responsibilities to finalize the task.
- reading all Rental Data: **_CSVReader_**
- holding all Rental Data: **_RentalDataManager_**
- holding one rental data: **_Rental_**
- checking for rental data's validity: **_RentalDataValidityChecker_**
- creating rental objects: **_RentalCollection_**
- generating statistical data out of rental objects: **_RentalStats_**
- main class: **_RentACarApp_**


## Interfaces
Set of methods to implement indicated responsibilities

##### IRentalDataManager:
```java
void printStats();
void printIndividualRentals();
void printCommercialRentals();
```


##### IRentalCollection
```java
HashMap<String, Rental> getRentals();       // HashMap maps Rental Code string to Rental object
```

##### IRentalStats
```java
int getRentedCarCount();
int getCommercialRentalCount();
int getCommercialRentalMonthCount();
int getIndividualRentalCount();
int getIndividualRentalDayCount();
int getIndividualNonMemberCustomerCount();
int getIndividualMemberCustomerCount();
int getCommercialCustomerCount(String customerType);
```
## UML diagram
Define classes for each responsibility and draw interactions between them

## Write code
Start writing classes from least coupled to most coupled 

## Testing
Test program and fix probable issues