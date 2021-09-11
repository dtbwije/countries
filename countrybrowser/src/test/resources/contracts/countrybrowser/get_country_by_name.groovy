import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return country by name"

    request {
        url "/countryservice/country/name/Finland"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                countryName: "Finland",
                countryCode: "FI"
        )
    }
}
