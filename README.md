Supported API
------------

1. countryservice/countries

2. countryservice/country/name/{name}

Build Project
-------------
mvn clean install


Run project
------------
mvn spring-boot:run


Implementation considerations
----------------------

1. requested API's are implemented.
2. Adequate testing implemented.
   1. The main branch only contains end-to-end tests.
   2. Mock is implemented to reflect rest country service 
   3. Test configuration and application configuration is isolated.


