# Imagineat-Service
___
**Technologies:**

Language:
- Java 11

Build automation system:
- Gradle wrapper

Database:
- PostgreSQL 10

**Things you need to boot server:**
- Create postgreSQL database with name imagineat
- Configure your postgreSQL server to be eligible on address `localhost` or set appropriate for your db server in imagineat\src\main\resources\application.yml
- Configure your postgreSQL server to be eligible on port `5432` or set appropriate for your db server in imagineat\src\main\resources\application.yml
- Run main method in ImangineatApplication class

**What to do in case if files in migration folder changed:**

- Drop all database tables
- Drop all database sequences
- Boot service

___
## API:

### Important:

1. For each parameter you could vary number of requested objects with **page** and **size** parameters.

    **size** = number of objects in "page"

    **page** = number of requested page

    So any request of list of objects could be done as: `($requestUrl)?page=($n)&size=($m)`

    For example: `http://localhost:8080/api/restaurants?page=0&size=2`

2. {id} field in each query means id of the main query object, for example:

    in query `http://localhost:8080/api/restaurants/{id}/tags` id field means **restaurant_id**

### 1. Get restaurants:

#### URL:

http://localhost:8080/api/restaurants

#### Result example:

    {
        "_embedded": {
            "restaurants": [
                {
                    "title": "title0",
                    "address": "address0",
                    "description": "description0",
                    "phoneNumber": "phone_num0",
                    "websiteAddress": "website_address0",
                    "externalRating": "VERY_GOOD",
                    "priceRange": "$",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurants/0"
                        },
                        "restaurant": {
                            "href": "http://localhost:8080/api/restaurants/0"
                        },
                        "tags": {
                            "href": "http://localhost:8080/api/restaurants/0/tags"
                        },
                        "menus": {
                            "href": "http://localhost:8080/api/restaurants/0/menus"
                        },
                        "photos": {
                            "href": "http://localhost:8080/api/restaurants/0/photos"
                        },
                        "schedules": {
                            "href": "http://localhost:8080/api/restaurants/0/schedules"
                        }
                    }
                },
                {
                    "title": "title1",
                    "address": "address1",
                    "description": "description1",
                    "phoneNumber": "phone_num1",
                    "websiteAddress": "website_address1",
                    "externalRating": "VERY_GOOD",
                    "priceRange": "$",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurants/1"
                        },
                        "restaurant": {
                            "href": "http://localhost:8080/api/restaurants/1"
                        },
                        "tags": {
                            "href": "http://localhost:8080/api/restaurants/1/tags"
                        },
                        "menus": {
                            "href": "http://localhost:8080/api/restaurants/1/menus"
                        },
                        "photos": {
                            "href": "http://localhost:8080/api/restaurants/1/photos"
                        },
                        "schedules": {
                            "href": "http://localhost:8080/api/restaurants/1/schedules"
                        }
                    }
                }
            ]
        },
        "_links": {
            "first": {
                "href": "http://localhost:8080/api/restaurants?page=0&size=2"
            },
            "self": {
                "href": "http://localhost:8080/api/restaurants{&sort}",
                "templated": true
            },
            "next": {
                "href": "http://localhost:8080/api/restaurants?page=1&size=2"
            },
            "last": {
                "href": "http://localhost:8080/api/restaurants?page=4&size=2"
            },
            "profile": {
                "href": "http://localhost:8080/api/profile/restaurants"
            }
        },
        "page": {
            "size": 2,
            "totalElements": 10,
            "totalPages": 5,
            "number": 0
        }
    }

### 2. Get restaurant by id:

#### URL:

http://localhost:8080/api/restaurants/0

#### Result example:

    {
        "title": "title0",
        "address": "address0",
        "description": "description0",
        "phoneNumber": "phone_num0",
        "websiteAddress": "website_address0",
        "externalRating": "VERY_GOOD",
        "priceRange": "$",
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurants/0"
            },
            "restaurant": {
                "href": "http://localhost:8080/api/restaurants/0"
            },
            "tags": {
                "href": "http://localhost:8080/api/restaurants/0/tags"
            },
            "menus": {
                "href": "http://localhost:8080/api/restaurants/0/menus"
            },
            "photos": {
                "href": "http://localhost:8080/api/restaurants/0/photos"
            },
            "schedules": {
                "href": "http://localhost:8080/api/restaurants/0/schedules"
            }
        }
    }

### 3. Get all restaurant tags:

#### URL:

http://localhost:8080/api/restaurants/{id}/tags

#### Result example:

http://localhost:8080/api/restaurants/2/tags

    {
        "_embedded": {
            "restaurantTags": [
                {
                    "title": "tag0",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurantTags/0"
                        },
                        "restaurantTag": {
                            "href": "http://localhost:8080/api/restaurantTags/0"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/restaurantTags/0/restaurants"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurants/2/tags"
            }
        }
    }

### 4. Get restaurant tag:

#### URL:

http://localhost:8080/api/restaurantTags/{id}

#### Result example:

http://localhost:8080/api/restaurantTags/0

    {
        "title": "tag0",
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurantTags/0"
            },
            "restaurantTag": {
                "href": "http://localhost:8080/api/restaurantTags/0"
            },
            "restaurants": {
                "href": "http://localhost:8080/api/restaurantTags/0/restaurants"
            }
        }
    }

### 5. Get all photos of restaurant:

http://localhost:8080/api/restaurants/{id}/photos

#### URL:

http://localhost:8080/api/restaurants/{id}/photos

#### Result example:


    {
        "_embedded": {
            "restaurantPhotos": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0"
                        },
                        "restaurantPhoto": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0"
                        },
                        "restaurant": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0/restaurant"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurants/0/photos"
            }
        }
    }

#### Comment:

We have no "file_path" title here, so you need to fetch photo name from url.\
Sorry for such messy format, it could be fixed a bit later.

### 6. Get all restaurant photos:

#### URL:

http://localhost:8080/api/restaurantPhotos?page=0&size=2

#### Result example:

    {
        "_embedded": {
            "restaurantPhotos": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0"
                        },
                        "restaurantPhoto": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0"
                        },
                        "restaurant": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo0/restaurant"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo1"
                        },
                        "restaurantPhoto": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo1"
                        },
                        "restaurant": {
                            "href": "http://localhost:8080/api/restaurantPhotos/photo1/restaurant"
                        }
                    }
                }
            ]
        },
        "_links": {
            "first": {
                "href": "http://localhost:8080/api/restaurantPhotos?page=0&size=2"
            },
            "self": {
                "href": "http://localhost:8080/api/restaurantPhotos{&sort}",
                "templated": true
            },
            "next": {
                "href": "http://localhost:8080/api/restaurantPhotos?page=1&size=2"
            },
            "last": {
                "href": "http://localhost:8080/api/restaurantPhotos?page=4&size=2"
            },
            "profile": {
                "href": "http://localhost:8080/api/profile/restaurantPhotos"
            }
        },
        "page": {
            "size": 2,
            "totalElements": 10,
            "totalPages": 5,
            "number": 0
        }
    }




### 7. Get all schedules:

#### URL:

http://localhost:8080/api/schedules

#### Result example:

    {
        "_embedded": {
            "schedules": [
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "MONDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/0"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/0"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/0/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "TUESDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/1"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/1"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/1/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "WEDNESDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/2"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/2"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/2/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "THURSDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/3"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/3"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/3/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "FRIDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/4"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/4"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/4/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "SATURDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/5"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/5"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/5/restaurants"
                        }
                    }
                },
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "SUNDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/6"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/6"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/6/restaurants"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/schedules{?page,size,sort}",
                "templated": true
            },
            "profile": {
                "href": "http://localhost:8080/api/profile/schedules"
            }
        },
        "page": {
            "size": 20,
            "totalElements": 7,
            "totalPages": 1,
            "number": 0
        }
    }

### 7. Get schedule by id:

#### URL:

http://localhost:8080/api/schedules/{id}

#### Result example:

    {
        "openTime": "1970-01-01T00:00:00.000+0000",
        "closeTime": "1970-01-01T00:33:20.000+0000",
        "dayName": "MONDAY",
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/schedules/0"
            },
            "schedule": {
                "href": "http://localhost:8080/api/schedules/0"
            },
            "restaurants": {
                "href": "http://localhost:8080/api/schedules/0/restaurants"
            }
        }
    }

### 8. Get restaurant schedule:

#### URL:

http://localhost:8080/api/restaurants/{id}/schedules

#### Result example:
http://localhost:8080/api/restaurants/5/schedules

    {
        "_embedded": {
            "schedules": [
                {
                    "openTime": "1970-01-01T00:00:00.000+0000",
                    "closeTime": "1970-01-01T00:33:20.000+0000",
                    "dayName": "MONDAY",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/schedules/0"
                        },
                        "schedule": {
                            "href": "http://localhost:8080/api/schedules/0"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/schedules/0/restaurants"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurants/5/schedules"
            }
        }
    }

### 9. Get restaurant menu:

#### URL:

Coming soon...

#### Result example:

