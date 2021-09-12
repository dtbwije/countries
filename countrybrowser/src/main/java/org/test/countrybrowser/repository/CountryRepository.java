package org.test.countrybrowser.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.countrybrowser.entity.CountryInList;

@Repository
public interface CountryRepository extends JpaRepository<CountryInList, Long> {
    CountryInList findByCountryName(String countryName);
}
