set foreign_key_checks = 0;

truncate table product;
truncate table feedback;

insert into product(`id`, `name`, `price`,`details`, `currency`)
values
       (110, 'luxury chair', 4500, 'how about you buy this chair', 'SRC'),
(111, 'luxury sofa', 4600, 'how about you buy this sofa', 'USD'),
(112, 'luxury bench', 4700, 'how about you buy this bench', 'NGN'),
(113, 'luxury table', 4800, 'how about you buy this table', 'GBP');


set foreign_key_checks =  1;