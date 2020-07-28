package com.goingmerry.pet_did.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 부가서비스
 *
 * @author Jin
 *
 */
@Entity
public class Service {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;
    private String provider;
    private String providerUrl;
}
