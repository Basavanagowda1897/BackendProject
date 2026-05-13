package com.umang.productcatalogservice2704.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long createdAt;
    private Long lastUpdatedAt;
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
/*
current time - 27th april, 2026, 10:21 PM (IST)
UTC

Timestamp 1  - 27th april, 2026, 10:21 PM (UTC)
Timestamp 2 - 27th august, 2029, 10:21 PM (UTC)
Are arithmetic operations on these date formats going to be super fast?
time difference between t1 and t2

epoch time - number of seconds that have elapsed since January 1, 1970 (UTC)
current time in epoch = 123455521342131

1020 BC - Before christ -
2026 AD - Anno Domini
0 - 2026 years have passed since BC is over

bunch of entities
most of the entities will have common attributes like
id, createdAt, updatedAt, createdBy, updatedBy


epoch


Soft Delete -
Delete a product.


Today's agenda items
1. Complete implementation for your models and integrate SQL DB
2. Implement our own product service (StorageProductService)
3. JPA Queries and Query methods
 */