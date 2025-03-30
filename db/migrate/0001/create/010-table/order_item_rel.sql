create table ORDER_ITEM_REL (
    ORDER_INFO_ID integer not null,
    ITEM_INFO_ID integer not null,
    constraint ORDER_ITEM_REL_PK primary key(ORDER_INFO_ID, ITEM_INFO_ID)
);
