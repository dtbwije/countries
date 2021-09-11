import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return country by name"

    request {
        url "/countryservice/countries"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                [
                        [
                                "id": 1,
                                "countryName": "Finland",
                                "countryCode": "FI"
                        ],[
                            "id": 2,
                            "countryName": "Sweden",
                            "countryCode": "SW"
                        ],
                        [
                            "id": 3,
                            "countryName": "Norway",
                            "countryCode": "NW"
                        ]
                ]
        )
    }
}