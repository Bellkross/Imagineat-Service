drop table if exists menu_category cascade;
drop table if exists menu cascade;
drop table if exists restaurant_has_menu cascade;
drop table if exists restaurant cascade;
drop table if exists restaurant_photo cascade;
drop table if exists restaurant_has_tag cascade;
drop table if exists restaurant_has_schedule cascade;
drop table if exists schedule cascade;
drop table if exists restaurant_rated_by_customer cascade;
drop table if exists customer cascade;
drop table if exists restaurant_tag cascade;
drop table if exists menu_has_menu_item cascade;
drop table if exists menu_item cascade;
drop table if exists menu_item_has_tag cascade;
drop table if exists menu_item_tag cascade;
drop table if exists menu_item_has_dish cascade;
drop table if exists dish cascade;
drop table if exists dish_has_ingredient cascade;
drop table if exists ingredient cascade;
drop table if exists menu_item_category cascade;
drop table if exists menu_item_photo cascade;
drop table if exists menu_item_model cascade;

create table if not exists menu_category
(
    id          bigint       not null,
    title       varchar(255) not null,
    description varchar(255) not null,
    constraint menu_category_pk primary key (id)
);
create table if not exists menu
(
    id               bigint  not null,
    menu_category_id integer not null,
    constraint menu_pk primary key (id),
    constraint menu_menu_category_fk foreign key (menu_category_id) references menu_category (id)
);
create table if not exists restaurant
(
    id              bigint       not null,
    title           varchar(255) not null,
    address         varchar(255) not null,
    description     varchar(255) not null,
    phone_num       varchar(255) not null,
    website_address varchar(255) not null,
    external_rating int,
    price_range     varchar(5),
    constraint restaurant_pk primary key (id)
);
create table if not exists restaurant_has_menu
(
    menu_id       bigint not null,
    restaurant_id bigint not null,
    constraint restaurant_has_menu_pk primary key (menu_id, restaurant_id),
    constraint restaurant_has_menu_menu_fk foreign key (menu_id) references menu (id),
    constraint restaurant_has_menu_restaurant_fk foreign key (restaurant_id) references restaurant (id)
);
create table if not exists restaurant_photo
(
    file_path     varchar(255) not null,
    restaurant_id bigint       not null,
    constraint restaurant_photo_pk primary key (file_path),
    constraint restaurant_photo_restaurant_fk foreign key (restaurant_id) references restaurant (id)
);
create table if not exists restaurant_tag
(
    id    bigint       not null,
    title varchar(255) not null,
    constraint restaurant_tag_pk primary key (id)
);
create table if not exists restaurant_has_tag
(
    restaurant_id     bigint not null,
    restaurant_tag_id bigint not null,
    constraint restaurant_has_tag_pk primary key (restaurant_id, restaurant_tag_id),
    constraint restaurant_has_tag_restaurant_fk foreign key (restaurant_id) references restaurant (id),
    constraint restaurant_has_tag_restaurant_tag_fk foreign key (restaurant_tag_id) references restaurant_tag (id)
);
create table if not exists schedule
(
    id         bigint       not null,
    open_time  timestamp    not null,
    close_time timestamp    not null,
    day_name   varchar(255) not null,
    constraint schedule_pk primary key (id),
    constraint schedule_uq unique (open_time, close_time, day_name)
);
create table if not exists restaurant_has_schedule
(
    restaurant_id bigint not null,
    schedule_id   bigint not null,
    constraint restaurant_has_schedule_pk primary key (restaurant_id, schedule_id),
    constraint restaurant_has_schedule_restaurant_fk foreign key (restaurant_id) references restaurant (id),
    constraint restaurant_has_schedule_schedule_fk foreign key (schedule_id) references schedule (id)
);
create table if not exists customer
(
    id    bigint       not null,
    email varchar(255) not null,
    name  varchar(255) not null,
    constraint customer_pk primary key (id),
    constraint customer_uq unique (email)
);
create table if not exists restaurant_rated_by_customer
(
    restaurant_id bigint       not null,
    customer_id   bigint       not null,
    point         bigint       not null,
    comment       varchar(255) not null,
    constraint restaurant_rated_by_user_pk primary key (restaurant_id, customer_id),
    constraint restaurant_rated_by_user_restaurant_fk foreign key (restaurant_id) references restaurant (id),
    constraint restaurant_rated_by_user_user_fk foreign key (customer_id) references customer (id)
);
create table if not exists menu_item_category
(
    title varchar(255) not null,
    constraint menu_item_category_pk primary key (title)
);
create table if not exists menu_item
(
    id                    bigint       not null,
    name                  varchar(255) not null,
    second_name           varchar(255),
    description           varchar(255),
    price                 integer      not null,
    currency              varchar(255),
    menu_item_category_id varchar(255) not null,
    constraint menu_item_pk primary key (id),
    constraint menu_item_menu_item_category_fk foreign key (menu_item_category_id) references menu_item_category (title)
);
create table if not exists menu_has_menu_item
(
    menu_id      bigint not null,
    menu_item_id bigint not null,
    constraint menu_has_menu_item_pk primary key (menu_id, menu_item_id),
    constraint menu_has_menu_item_menu_fk foreign key (menu_id) references menu (id),
    constraint menu_has_menu_item_menu_item_fk foreign key (menu_item_id) references menu_item (id)
);
create table if not exists menu_item_tag
(
    id          bigint       not null,
    title       varchar(255) not null,
    description varchar(255) not null,
    constraint menu_item_tag_pk primary key (id)
);
create table if not exists menu_item_has_tag
(
    menu_item_id     bigint not null,
    menu_item_tag_id bigint not null,
    constraint menu_item_has_tag_pk primary key (menu_item_id, menu_item_tag_id),
    constraint menu_item_has_tag_menu_item_fk foreign key (menu_item_id) references menu_item (id),
    constraint menu_item_has_tag_menu_item_tag_fk foreign key (menu_item_tag_id) references menu_item_tag (id)
);
create table if not exists dish
(
    id              bigint       not null,
    title           varchar(255) not null,
    gr_description  varchar(255),
    cal_description varchar(255),
    constraint dish_pk primary key (id)
);
create table if not exists menu_item_has_dish
(
    menu_item_id bigint not null,
    dish_id      bigint not null,
    constraint menu_item_has_dish_pk primary key (menu_item_id, dish_id),
    constraint menu_item_has_dish_menu_item_fk foreign key (menu_item_id) references menu_item (id),
    constraint menu_item_has_dish_dish_fk foreign key (dish_id) references dish (id)
);
create table if not exists ingredient
(
    title varchar(255) not null,
    constraint ingredient_pk primary key (title)
);
create table if not exists dish_has_ingredient
(
    dish_id       bigint       not null,
    ingredient_id varchar(255) not null,
    constraint dish_has_ingredient_pk primary key (dish_id, ingredient_id),
    constraint dish_has_ingredient_dish_fk foreign key (dish_id) references dish (id),
    constraint dish_has_ingredient_ingredient_fk foreign key (ingredient_id) references ingredient (title)
);
create table if not exists menu_item_photo
(
    file_path    varchar(255) not null,
    menu_item_id bigint       not null,
    constraint menu_item_photo_pk primary key (file_path),
    constraint menu_item_photo_menu_item_fk foreign key (menu_item_id) references menu_item (id)
);
create table if not exists menu_item_model
(
    file_path    varchar(255) not null,
    menu_item_id bigint       not null,
    constraint menu_item_model_pk primary key (file_path),
    constraint menu_item_model_menu_item_fk foreign key (menu_item_id) references menu_item (id)
);