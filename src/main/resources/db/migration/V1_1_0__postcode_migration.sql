CREATE TABLE if not exists postcode (
                                        id serial primary key,
                                        state varchar(250),
                                        district varchar(250),
                                        city varchar(250),
                                        location varchar(250),
                                        area varchar(250),
                                        zipCode varchar(5)
);