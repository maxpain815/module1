--а) Решение выведет две записи null, null. А по заданию должна отобразиться запись только запись 2, Name3.
select t2.* from Table1 t1 FULL JOIN Table2 t2 on t1.id = t2.id WHERE NOT t1.id = t2.id OR NOT t1.name = t2.name;

--б) При таких данных решение выведет правильный результат, но в наличие записи 3, Name4 в Table1 оно уже не будет выдавать правильный результат. Заместо left join в текущем решении нужно использовать inner join, он никак не повлияет на результат, но увеличит быстродействие.
select t1.* from Table1 t1 LEft join (select id,name,count(id) from table2 group by id,name) t2 on t1.id = t2.id where t2.count>1;

--Рекомендации:
--Более подробно разобраться когда какую структуру данных нужно использовать. Рекомендуем для этого книгу Thinking in Java Forth Edition by Bruce Eckel, глава Containers in Depth.
--Разобраться со stream api. Рекомендуем для этого книгу Java 8 in Action by Alan Mycroft and Mario Fusco.
--Более подробно разобраться с SQL. Рекомендуем для этого книгу Sams Teach Yourself SQL in 10 Minutes By Ben Forta.