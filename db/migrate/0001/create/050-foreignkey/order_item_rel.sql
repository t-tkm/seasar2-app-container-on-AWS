alter table ORDER_ITEM_REL add constraint ORDER_ITEM_REL_FK1 foreign key (ITEM_INFO_ID) references ITEM_INFO (ID);
alter table ORDER_ITEM_REL add constraint ORDER_ITEM_REL_FK2 foreign key (ORDER_INFO_ID) references ORDER_INFO (ID);
