Create TABLE short_name (
    id serial primary key ,
    title varchar(266),
    original_url varchar(266),
    short_url varchar(266) unique ,
    create_at date default now()
)