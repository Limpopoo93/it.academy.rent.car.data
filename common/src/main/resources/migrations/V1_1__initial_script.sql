CREATE SEQUENCE public.m_authenticate_id_seq
    INCREMENT 1
    START 5
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_authenticate
(
    id             bigserial            not null
        constraint authenticate_pk
            primary key,
    login          varchar(50)          not null,
    password       varchar(150)         not null,
    email          varchar(50)          not null,
    profile_close  boolean default true not null,
    profile_remote boolean default true not null
);

alter table m_authenticate
    owner to postgres;

CREATE SEQUENCE public.m_roles_id_seq
    INCREMENT 1
    START 5
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_roles
(
    id        bigserial   not null
        constraint m_role_pk
            primary key,
    user_id   bigint
        constraint user_id
            references m_authenticate,
    type_role varchar(15) not null
);

alter table m_roles
    owner to postgres;

CREATE SEQUENCE public.m_country_id_seq
    INCREMENT 1
    START 19
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_country
(
    id             bigserial            not null
        constraint m_country_pk
            primary key,
    country        varchar(50)          not null,
    country_remote boolean default true not null
);

alter table m_country
    owner to postgres;

CREATE SEQUENCE public.m_town_id_seq
    INCREMENT 1
    START 44
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_town
(
    id          bigserial            not null
        constraint m_town_pk
            primary key,
    town        varchar(50)          not null,
    id_country  bigint               not null
        constraint country_id
            references m_country,
    town_remote boolean default true not null
);

alter table m_town
    owner to postgres;

CREATE SEQUENCE public.m_company_id_seq
    INCREMENT 1
    START 11
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_company
(
    id              bigserial            not null
        constraint m_company_pk
            primary key,
    name_company    varchar(50)          not null,
    reting          bigint               not null,
    telephone       varchar(50)          not null,
    email           varchar(50)          not null,
    id_town         bigint               not null
        constraint town_id
            references m_town,
    id_authenticate bigint
        constraint authenticate_id
            references m_authenticate,
    company_remote  boolean default true not null
);

alter table m_company
    owner to postgres;

CREATE SEQUENCE public.m_car_id_seq
    INCREMENT 1
    START 17
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table m_car
(
    id         bigserial            not null
        constraint m_car_pk
            primary key,
    name_car   varchar(50)          not null,
    type_fuel  varchar(50)          not null,
    col_doors  bigint               not null,
    col_people bigint               not null,
    mileage    bigint               not null,
    make_car   varchar(50)          not null,
    type_car   varchar(50)          not null,
    id_company bigint               not null
        constraint company_id
            references m_company,
    price      bigint,
    car_remote boolean default true not null
);

alter table m_car
    owner to postgres;


create table m_busy_date
(
    id               bigserial            not null
        constraint m_busy_date_pk
            primary key,
    date_check       date                 not null,
    date_return      date                 not null,
    id_car           bigint               not null
        constraint car_id
            references m_car,
    id_authenticate  bigint               not null
        constraint authenticate_id
            references m_authenticate,
    busy_date_remote boolean default true not null,
    price_car        bigint               not null
);

alter table m_busy_date
    owner to postgres;

create table m_letter
(
    id              bigserial            not null
        constraint m_letter_pk
            primary key,
    text_letter     varchar(50)          not null,
    id_authenticate bigint               not null
        constraint authenticate_id
            references m_authenticate,
    letter_remote   boolean default true not null
);

alter table m_letter
    owner to postgres;
create table m_photo_car
(
    id               bigserial            not null
        constraint m_photo_car_pk
            primary key,
    name_photo       varchar(50)          not null,
    type_photo       bytea                not null,
    id_car           bigint               not null
        constraint car_id
            references m_car,
    photo_car_remote boolean default true not null
);

alter table m_photo_car
    owner to postgres;

