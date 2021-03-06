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

1. For every each request you could vary number of requested objects with **page** and **size** parameters.

(For requests with tag **no pagination** you couldn't)

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

### 9. Get restaurant menus:

#### URL:

http://localhost:8080/api/restaurants/{id}/menus

#### Result example:
http://localhost:8080/api/restaurants/0/menus

    {
        "_embedded": {
            "menus": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menus/0"
                        },
                        "menu": {
                            "href": "http://localhost:8080/api/menus/0"
                        },
                        "category": {
                            "href": "http://localhost:8080/api/menus/0/category"
                        },
                        "restaurants": {
                            "href": "http://localhost:8080/api/menus/0/restaurants"
                        },
                        "items": {
                            "href": "http://localhost:8080/api/menus/0/items"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/restaurants/0/menus"
            }
        }
    }


### 10. Get menu category:

#### URL:

http://localhost:8080/api/menus/{id}/category

#### Result example:

http://localhost:8080/api/menus/0/category

    {
        "title": "category0",
        "description": "description0",
        "hibernateLazyInitializer": {},
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuCategories/0"
            },
            "menuCategory": {
                "href": "http://localhost:8080/api/menuCategories/0"
            },
            "menus": {
                "href": "http://localhost:8080/api/menuCategories/0/menus"
            }
        }
    }


### 11. Get menu items:

#### URL:

http://localhost:8080/api/menus/{id}/items

#### Result example:

http://localhost:8080/api/menus/0/items

    {
        "_embedded": {
            "menuItems": [
                {
                    "name": "name0",
                    "secondName": "second_name0",
                    "description": "description0",
                    "price": 100,
                    "currency": "UAH",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItems/0"
                        },
                        "menuItem": {
                            "href": "http://localhost:8080/api/menuItems/0"
                        },
                        "category": {
                            "href": "http://localhost:8080/api/menuItems/0/category"
                        },
                        "photos": {
                            "href": "http://localhost:8080/api/menuItems/0/photos"
                        },
                        "tags": {
                            "href": "http://localhost:8080/api/menuItems/0/tags"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/menuItems/0/dishes"
                        },
                        "menus": {
                            "href": "http://localhost:8080/api/menuItems/0/menus"
                        },
                        "models": {
                            "href": "http://localhost:8080/api/menuItems/0/models"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menus/0/items"
            }
        }
    }

### 12. Get menu item category:

#### URL:

http://localhost:8080/api/menuItems/{id}/category

#### Result example:

http://localhost:8080/api/menuItems/0/category

    {
        "hibernateLazyInitializer": {},
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuItemCategories/item_category0"
            },
            "menuItemCategory": {
                "href": "http://localhost:8080/api/menuItemCategories/item_category0"
            },
            "items": {
                "href": "http://localhost:8080/api/menuItemCategories/item_category0/items"
            }
        }
    }

### 13. Get menu item photo:

#### URL:

http://localhost:8080/api/menuItems/{id}/photos

#### Result example:

http://localhost:8080/api/menuItems/0/photos

    {
        "_embedded": {
            "menuItemPhotos": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemPhotos/miphoto0"
                        },
                        "menuItemPhoto": {
                            "href": "http://localhost:8080/api/menuItemPhotos/miphoto0"
                        },
                        "menuItem": {
                            "href": "http://localhost:8080/api/menuItemPhotos/miphoto0/menuItem"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuItems/0/photos"
            }
        }
    }

### 14. Get menu item tags:

#### URL:

http://localhost:8080/api/menuItems/{id}/tags

#### Result example:

http://localhost:8080/api/menuItems/0/tags

    {
        "_embedded": {
            "menuItemTags": [
                {
                    "title": "title5",
                    "description": "description5",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/5"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/5"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/5/menuItems"
                        }
                    }
                },
                {
                    "title": "title6",
                    "description": "description6",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/6"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/6"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/6/menuItems"
                        }
                    }
                },
                {
                    "title": "title7",
                    "description": "description7",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/7"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/7"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/7/menuItems"
                        }
                    }
                },
                {
                    "title": "title8",
                    "description": "description8",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/8"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/8"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/8/menuItems"
                        }
                    }
                },
                {
                    "title": "title9",
                    "description": "description9",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/9"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/9"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/9/menuItems"
                        }
                    }
                },
                {
                    "title": "title0",
                    "description": "description0",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/0"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/0"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/0/menuItems"
                        }
                    }
                },
                {
                    "title": "title1",
                    "description": "description1",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/1"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/1"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/1/menuItems"
                        }
                    }
                },
                {
                    "title": "title2",
                    "description": "description2",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/2"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/2"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/2/menuItems"
                        }
                    }
                },
                {
                    "title": "title3",
                    "description": "description3",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/3"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/3"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/3/menuItems"
                        }
                    }
                },
                {
                    "title": "title4",
                    "description": "description4",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemTags/4"
                        },
                        "menuItemTag": {
                            "href": "http://localhost:8080/api/menuItemTags/4"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/menuItemTags/4/menuItems"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuItems/0/tags"
            }
        }
    }

### 15. Get menu item model:

#### URL:

http://localhost:8080/api/menuItems/{id}/models

#### Result example:

http://localhost:8080/api/menuItems/0/models

    {
        "_embedded": {
            "menuItemModels": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/menuItemModels/mimodel0"
                        },
                        "menuItemModel": {
                            "href": "http://localhost:8080/api/menuItemModels/mimodel0"
                        },
                        "menuItem": {
                            "href": "http://localhost:8080/api/menuItemModels/mimodel0/menuItem"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuItems/0/models"
            }
        }
    }

### 16. Get menu item dishes:
(**no pagination**)
#### URL:

http://localhost:8080/api/menuItems/{id}/dishes

#### Result example:
http://localhost:8080/api/menuItems/0/dishes

    {
        "_embedded": {
            "dishes": [
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/5"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/5"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/5/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/5/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/6"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/6"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/6/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/6/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/7"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/7"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/7/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/7/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/8"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/8"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/8/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/8/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/9"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/9"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/9/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/9/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/0"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/0"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/0/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/0/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/1"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/1"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/1/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/1/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/2"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/2"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/2/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/2/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/3"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/3"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/3/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/3/menuItems"
                        }
                    }
                },
                {
                    "title": "name%s",
                    "gramsDescription": "100 gr",
                    "caloriesDescription": "200 cal",
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/dishes/4"
                        },
                        "dish": {
                            "href": "http://localhost:8080/api/dishes/4"
                        },
                        "ingredients": {
                            "href": "http://localhost:8080/api/dishes/4/ingredients"
                        },
                        "menuItems": {
                            "href": "http://localhost:8080/api/dishes/4/menuItems"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/menuItems/0/dishes"
            }
        }
    }

### 17. Get dishes ingredients:
(**no pagination**)
#### URL:

http://localhost:8080/api/dishes/{id}/ingredients

#### Result example:

http://localhost:8080/api/dishes/5/ingredients

    {
        "_embedded": {
            "ingredients": [
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient1"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient1"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient1/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient0"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient0"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient0/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient5"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient5"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient5/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient4"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient4"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient4/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient3"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient3"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient3/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient2"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient2"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient2/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient9"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient9"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient9/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient8"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient8"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient8/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient7"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient7"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient7/dishes"
                        }
                    }
                },
                {
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/api/ingredients/ingredient6"
                        },
                        "ingredient": {
                            "href": "http://localhost:8080/api/ingredients/ingredient6"
                        },
                        "dishes": {
                            "href": "http://localhost:8080/api/ingredients/ingredient6/dishes"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/api/dishes/5/ingredients"
            }
        }
    }

### 18. Get photo by path:
(**no pagination**)
#### URL:

http://localhost:8080/api/image/{path}

#### Result example:
http://localhost:8080/api/image/photo4

![photo4](https://github.com/Bellkross/Imagineat-Service/blob/master/src/main/resources/upload-dir/photo4.jpg)

http://localhost:8080/api/image/miphoto4

![miphoto4](https://github.com/Bellkross/Imagineat-Service/blob/master/src/main/resources/upload-dir/miphoto4.jpg)

### 19. Download file
(**no pagination**)
#### URL:

http://localhost:8080/api/downloadFile/{fileName.fileFormat}

#### Result example:

http://localhost:8080/api/downloadFile/mimodel0.obj

    ####
    # OBJ File Generated by BOB Capture
    ###
    mtllib ./First.mtl
    v 238.285 -294.988 -1193.34
    v 240.804 -208.22 -1354.73
    ...