create table tb_lru (id bigserial primary key, cache_key varchar(255) UNIQUE not null, cache_value varchar(255));