
    set client_min_messages = WARNING;

    alter table if exists bici 
       drop constraint if exists FKbwomtnan9xt4w1ovsf9sod7y1;

    alter table if exists macchina 
       drop constraint if exists FKfswg5ydalkd5hvl8k839qdfkf;

    alter table if exists moto 
       drop constraint if exists FKhg6x1bil1w6nnp4fxlwebfc3l;

    alter table if exists veicolo 
       drop constraint if exists FK2vsaxu42kao1fd973kjeegsud;

    alter table if exists veicolo 
       drop constraint if exists FK1ffq24yvhb1147soqdmhcrr75;

    alter table if exists veicolo 
       drop constraint if exists FKhawc18rfxiebdktlu7293kpom;

    alter table if exists veicolo 
       drop constraint if exists FKcposg08w0p0gcap88ktrxci8r;

    drop table if exists alimentazione cascade;

    drop table if exists bici cascade;

    drop table if exists categoria cascade;

    drop table if exists colore cascade;

    drop table if exists macchina cascade;

    drop table if exists marca cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists moto cascade;

    drop table if exists veicolo cascade;
