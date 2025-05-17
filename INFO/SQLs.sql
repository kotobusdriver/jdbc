create table if not exists employees (
                                         id serial primary key,
                                         name varchar (100) not null,
                                         age integer not null,
                                         position varchar (100) not null,
                                         salary numeric (10, 2) not null
);

insert into employees (name, age, position, salary) values
    ('Emma Johnson',          28, 'Software Engineer',  75000.00);


insert into employees (name, age, position, salary) values
                                                        ('Liam Miller',           35, 'Project Manager',     90000.00),
                                                        ('Olivia Brown',          30, 'Data Analyst',        65000.00),
                                                        ('Noah Davis',            42, 'HR Manager',          80000.00),
                                                        ('Ava Wilson',            26, 'UX Designer',         70000.00),
                                                        ('William Taylor',        50, 'CTO',                150000.00),
                                                        ('Sophia Anderson',       33, 'Marketing Specialist',60000.00),
                                                        ('James Thomas',          29, 'DevOps Engineer',     85000.00),
                                                        ('Isabella Jackson',      38, 'Sales Manager',       95000.00),
                                                        ('Benjamin White',        45, 'Finance Director',   120000.00);
