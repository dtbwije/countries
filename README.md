#Rest Country Service


## Supported API

1. /countryservice/countries

2. /countryservice/country/name/{name}

## Design
![design image](docs/componentdiagram.png)

Ideally to improve the responsiveness along the time a cache can be added. In this implementation cache is not added in order to simplify the implementation.

## Build Project

```
mvn clean install
```

## Run project
```
mvn spring-boot:run
```

Ideally in a vertex based micro service we provide a self containing docker image which we start with a script using the docker entrypoint.

## Implementation considerations


1. requested API's are implemented.
2. Some level of testing implemented for success cases.
   1. The main branch only contains end-to-end tests.
   2. Mock is implemented to reflect rest country service 
   3. Test configuration and application configuration is isolated.
   4. More tests are available in the old-stuff branch. Experimented with the various ways of testing such as contract controller testing and some junit 5 unit tests. 
   5. Mocks are also tested. removed in commit (8784134a44489594d774c182d83b9a26c3308104) to stabilise the build.
3. Configurations added for testing and main implementation.  Annotation based configuration is also considered but abandoned to shorten the development time. But ideally would use annotation based environmental variable approach in kubernetes based environment.
4. TODO
   1. Wiremock needs to create negative responses to test error cases.
   2. Error handling is not implemented. Eg. Flux.onErrorResume()
   3. Simple webapp is not implemented.
5. CORS is not implemented.
6. Security tokens/ security headers is not considered.
7. Docker compose set up in not implemented.
8. Configuration value restrictions are not imposed.

## Concerns

* in order to map json values from response to request some stream mapping is used. This might be a bad 

