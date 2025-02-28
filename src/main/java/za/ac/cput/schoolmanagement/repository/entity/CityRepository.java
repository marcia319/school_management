/**
 * CityRepository.java
 * City Repository class for School Management Assignment
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 17 June 2022
 */

package za.ac.cput.schoolmanagement.repository.entity;

import za.ac.cput.schoolmanagement.domain.entity.City;
import za.ac.cput.schoolmanagement.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository implements ICityRepository{
    private final List<City> cityList;
    private static CityRepository CITY_REPOSITORY;

    private CityRepository() {
        this.cityList = new ArrayList<>();
    }

    public static CityRepository cityRepository() {
        if (CITY_REPOSITORY == null)
            CITY_REPOSITORY = new CityRepository();
        return CITY_REPOSITORY;
    }

    public City save(City city) {
        Optional<City> read = read(city.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.cityList.add(city);
        return city;
    }

    public Optional<City> read(String id) {
        return this.cityList.stream().filter(c -> c.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public void delete(City city) {
        this.cityList.remove(city);
    }

    public List<City> findAll() {
        return this.cityList;
    }
}