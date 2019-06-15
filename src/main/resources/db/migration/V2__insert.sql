truncate table restaurant_tag cascade;

do
$$
    declare
        curr_restaurant_id bigint := 0;
        title_template     text   := 'tag%s';
        tags_number        bigint := 10;
    begin
        while curr_restaurant_id < tags_number
            loop
                insert into restaurant_tag(id, title)
                values (curr_restaurant_id, (select format(title_template, curr_restaurant_id)));
                curr_restaurant_id = curr_restaurant_id + 1;
            end loop;
        create sequence if not exists restaurant_tag_id_seq start with 1;
        alter sequence restaurant_tag_id_seq restart with 9;
    end
$$;

truncate table restaurant cascade;

do
$$
    declare
        restaurant_id            bigint := 0;
        restaurants_number       bigint := 10;
        title_template           text   := 'title%s';
        address_template         text   := 'address%s';
        description_template     text   := 'description%s';
        phone_num_template       text   := 'phone_num%s';
        website_address_template text   := 'website_address%s';
        external_rating          int    := 4;
        price_range              text   := '$';
    begin
        while restaurant_id < restaurants_number
            loop
                insert into restaurant(id, title, address, description, phone_num, website_address, external_rating,
                                       price_range)
                values (restaurant_id,
                        (select format(title_template, restaurant_id)),
                        (select format(address_template, restaurant_id)),
                        (select format(description_template, restaurant_id)),
                        (select format(phone_num_template, restaurant_id)),
                        (select format(website_address_template, restaurant_id)),
                        external_rating,
                        price_range);
                restaurant_id = restaurant_id + 1;
            end loop;
        create sequence if not exists restaurant_photo_id_seq start with 1;
        alter sequence restaurant_photo_id_seq restart with 9;
    end
$$;

truncate table restaurant_has_tag cascade;

do
$$
    declare
        curr_restaurant_id     bigint := 0;
        curr_restaurant_tag_id bigint := 0;
        tags_number            bigint := 10;
        restaurants_number     bigint := 10;
    begin
        while curr_restaurant_tag_id < tags_number
            loop
                while curr_restaurant_id < restaurants_number
                    loop
                        insert into restaurant_has_tag(restaurant_id, restaurant_tag_id)
                        VALUES (curr_restaurant_id, curr_restaurant_tag_id);
                        curr_restaurant_id = curr_restaurant_id + 1;
                    end loop;
                curr_restaurant_id = 0;
                curr_restaurant_tag_id = curr_restaurant_tag_id + 1;
            end loop;
        create sequence if not exists restaurant_has_tag_id_seq start with 1;
        alter sequence restaurant_has_tag_id_seq restart with 100;
    end
$$;


truncate table restaurant_photo cascade;

do
$$
    declare
        curr_photo_id bigint := 0;
        path_template text   := 'photo%s';
        photos_number bigint := 10;
        restaurant_id bigint := 0;
    begin
        while curr_photo_id < photos_number
            loop
                insert into restaurant_photo(file_path, restaurant_id)
                values ((select format(path_template, curr_photo_id)), restaurant_id);
                curr_photo_id = curr_photo_id + 1;
                restaurant_id = restaurant_id + 1;
            end loop;
    end
$$;

truncate table schedule cascade;

do
$$
    declare
        schedule_id bigint    := 0;
        open_time   timestamp := to_timestamp(0);
        close_time  timestamp := to_timestamp(2000);
        day_names   text[]    = '{"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"}';
    begin
        while schedule_id < 7
            loop
                insert into schedule(id, open_time, close_time, day_name)
                values (schedule_id, open_time, close_time, (select day_names[schedule_id + 1]));
                schedule_id = schedule_id + 1;
            end loop;
        create sequence if not exists schedule_id_seq start with 1;
        alter sequence schedule_id_seq restart with 7;
    end
$$;

truncate table restaurant_has_schedule cascade;

do
$$
    declare
        curr_restaurant_id bigint := 0;
        curr_schedule_id   bigint := 0;
        schedules_number   bigint := 7;
        restaurants_number bigint := 10;
    begin
        while curr_schedule_id < schedules_number
            loop
                while curr_restaurant_id < restaurants_number
                    loop
                        insert into restaurant_has_schedule(restaurant_id, schedule_id)
                        VALUES (curr_restaurant_id, curr_schedule_id);
                        curr_restaurant_id = curr_restaurant_id + 1;
                    end loop;
                curr_restaurant_id = 0;
                curr_schedule_id = curr_schedule_id + 1;
            end loop;
        create sequence if not exists restaurant_has_schedule_id_seq start with 1;
        alter sequence restaurant_has_schedule_id_seq restart with 70;
    end
$$;

truncate table menu_category cascade;

do
$$
    declare
        menu_category_id       bigint := 0;
        title_template         text   := 'category%s';
        description_template   text   := 'description%s';
        menu_categories_number bigint := 10;
    begin
        while menu_category_id < menu_categories_number
            loop
                insert into menu_category (id, title, description)
                values (menu_category_id,
                        (select format(title_template, menu_category_id)),
                        (select format(description_template, menu_category_id)));
                menu_category_id = menu_category_id + 1;
            end loop;
        create sequence if not exists menu_category_id_seq start with 1;
        alter sequence menu_category_id_seq restart with 10;
    end
$$;

truncate table menu cascade;

do
$$
    declare
        menu_id          bigint := 0;
        menu_category_id bigint := 0;
        menus_number     bigint := 10;
    begin
        while menu_id < menus_number
            loop
                insert into menu (id, menu_category_id) values (menu_id, menu_category_id);
                menu_id = menu_id + 1;
                menu_category_id = menu_category_id + 1;
            end loop;
        create sequence if not exists menu_id_seq start with 1;
        alter sequence menu_id_seq restart with 10;
    end
$$;

truncate table restaurant_has_menu cascade;

do
$$
    declare
        menu_id            bigint := 0;
        restaurant_id      bigint := 0;
        menus_number       bigint := 10;
        restaurants_number bigint := 10;
    begin
        while menu_id < menus_number
            loop
                while restaurant_id < restaurants_number
                    loop
                        insert into restaurant_has_menu (menu_id, restaurant_id) values (menu_id, restaurant_id);
                        restaurant_id = restaurant_id + 1;
                    end loop;
                restaurant_id = 0;
                menu_id = menu_id + 1;
            end loop;
        create sequence if not exists restaurant_has_menu_id_seq start with 1;
        alter sequence restaurant_has_menu_id_seq restart with 100;
    end
$$;

truncate table menu_item_category cascade;

do
$$
    declare
        menu_item_category_number bigint := 0;
        title_template            text   := 'item_category%s';
        menu_categories_number    bigint := 10;
    begin
        while menu_item_category_number < menu_categories_number
            loop
                insert into menu_item_category (title)
                values ((select format(title_template, menu_item_category_number)));
                menu_item_category_number = menu_item_category_number + 1;
            end loop;
    end
$$;

truncate table menu_item cascade;

do
$$
    declare
        menu_item_id                      bigint := 0;
        name_template                     text   := 'name%s';
        second_name_template              text   := 'second_name%s';
        description_template              text   := 'description%s';
        my_price                          int    := 100;
        uah_currency                      text   := 'UAH';
        menu_item_category_title_template text   := 'item_category%s';
        menu_items_number                 bigint := 10;
    begin
        while menu_item_id < menu_items_number
            loop
                insert into menu_item (id, name, second_name, description, price, currency, menu_item_category_id)
                VALUES (menu_item_id,
                        (select format(name_template, menu_item_id)),
                        (select format(second_name_template, menu_item_id)),
                        (select format(description_template, menu_item_id)),
                        my_price,
                        uah_currency,
                        (select format(menu_item_category_title_template, menu_item_id)));
                menu_item_id = menu_item_id + 1;
            end loop;
        create sequence if not exists menu_item_id_seq start with 1;
        alter sequence menu_item_id_seq restart with 10;
    end
$$;

truncate table menu_item_tag cascade;

do
$$
    declare
        menu_item_tag_id      bigint := 0;
        title_template        text   := 'title%s';
        description_template  text   := 'description%s';
        menu_item_tags_number bigint := 10;
    begin
        while menu_item_tag_id < menu_item_tags_number
            loop
                insert into menu_item_tag (id, title, description)
                VALUES (menu_item_tag_id,
                        (select format(title_template, menu_item_tag_id)),
                        (select format(description_template, menu_item_tag_id)));
                menu_item_tag_id = menu_item_tag_id + 1;
            end loop;
        create sequence if not exists menu_item_tag_id_seq start with 1;
        alter sequence menu_item_tag_id_seq restart with 10;
    end
$$;

truncate table menu_item_has_tag cascade;

do
$$
    declare
        menu_item_id bigint := 0;
        tag_id       bigint := 0;
        menus_number bigint := 10;
        tags_number  bigint := 10;
    begin
        while menu_item_id < menus_number
            loop
                while tag_id < tags_number
                    loop
                        insert into menu_item_has_tag (menu_item_id, menu_item_tag_id) values (menu_item_id, tag_id);
                        tag_id = tag_id + 1;
                    end loop;
                tag_id = 0;
                menu_item_id = menu_item_id + 1;
            end loop;
        create sequence if not exists menu_item_has_tag_id_seq start with 1;
        alter sequence menu_item_has_tag_id_seq restart with 100;
    end
$$;

truncate table menu_has_menu_item cascade;

do
$$
    declare
        menu_id           bigint := 0;
        menu_item_id      bigint := 0;
        menus_number      bigint := 10;
        menu_items_number bigint := 10;
    begin
        while menu_item_id < menus_number
            loop
                while menu_id < menu_items_number
                    loop
                        insert into menu_has_menu_item (menu_id, menu_item_id) values (menu_id, menu_item_id);
                        menu_id = menu_id + 1;
                    end loop;
                menu_id = 0;
                menu_item_id = menu_item_id + 1;
            end loop;
        create sequence if not exists menu_has_menu_item_id_seq start with 1;
        alter sequence menu_has_menu_item_id_seq restart with 100;
    end
$$;

truncate table menu_item_model cascade;

do
$$
    declare
        menu_item_id                  bigint := 0;
        menu_item_model_id            bigint := 0;
        menu_item_model_path_template text   := 'mimodel%s';
        menu_item_models_number       bigint := 10;
    begin
        while menu_item_model_id < menu_item_models_number
            loop
                insert into menu_item_model (file_path, menu_item_id)
                values ((select format(menu_item_model_path_template, menu_item_model_id)),
                        menu_item_id);
                menu_item_model_id = menu_item_model_id + 1;
                menu_item_id = menu_item_id + 1;
            end loop;
    end
$$;

truncate table menu_item_photo cascade;

do
$$
    declare
        menu_item_id                  bigint := 0;
        menu_item_photo_id            bigint := 0;
        menu_item_photo_path_template text   := 'miphoto%s';
        menu_item_photos_number       bigint := 10;
    begin
        while menu_item_photo_id < menu_item_photos_number
            loop
                insert into menu_item_photo (file_path, menu_item_id)
                values ((select format(menu_item_photo_path_template, menu_item_photo_id)),
                        menu_item_id);
                menu_item_photo_id = menu_item_photo_id + 1;
                menu_item_id = menu_item_id + 1;
            end loop;
    end
$$;