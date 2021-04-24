create table department (
    id varchar(32) not null,
    version bigint not null,
    created_by_user varchar(255) not null,
    created_date timestamp  not null,
    updated_by_user varchar(255) not null,
    updated_date timestamp not null,
    department_name varchar (32),
    primary key (id)
);

create table user (
    id varchar(32) not null,
    version bigint not null,
    created_by_user varchar(255) not null,
    created_date timestamp  not null,
    updated_by_user varchar(255) not null,
    updated_date timestamp not null,
    user_name varchar(255) not null,
    surname varchar(255) not null,
    department_id varchar(32),
    primary key (id),
    foreign key (department_id)
        references department (id)
);

create table task (
    id varchar(32) not null,
    version bigint not null,
    created_by_user varchar(255) not null,
    created_date timestamp  not null,
    updated_by_user varchar(255) not null,
    updated_date timestamp not null,
    topic varchar(255) not null,
    description varchar(255),
    author_id varchar(32),
    executor_id varchar(32),
    task_status varchar(32),
    primary key (id),
    foreign key (author_id)
        references user (id),
    foreign key (executor_id)
        references user (id)
);

create table attachment (
    id varchar(32) not null,
    version bigint not null,
    created_by_user varchar(255) not null,
    created_date timestamp  not null,
    updated_by_user varchar(255) not null,
    updated_date timestamp not null,
    file bytea,
    attachment_name varchar(255) not null,
    task_id varchar(32),
    owner_id varchar(32),
    primary key (id),
    foreign key (task_id)
        references task (id),
    foreign key (owner_id)
        references user (id)
);

create table task_comment (
    id varchar(32) not null,
    version bigint not null,
    created_by_user varchar(255) not null,
    created_date timestamp  not null,
    updated_by_user varchar(255) not null,
    updated_date timestamp not null,
    comment_text varchar(255),
    task_id varchar(32),
    owner_id varchar(32),
    primary key (id),
    foreign key (task_id)
        references task (id),
    foreign key (owner_id)
        references user (id)
);