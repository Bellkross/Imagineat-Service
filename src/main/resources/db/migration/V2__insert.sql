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
        create sequence if not exists restaurant_photo_id_seq start with 1;
        alter sequence restaurant_photo_id_seq restart with 9;
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
                curr_schedule_id = curr_schedule_id + 1;
            end loop;
        create sequence if not exists restaurant_has_schedule_id_seq start with 1;
        alter sequence restaurant_has_schedule_id_seq restart with 70;
    end
$$;