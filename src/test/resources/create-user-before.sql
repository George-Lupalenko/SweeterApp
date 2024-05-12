delete from user_role;
delete from usr;

insert into usr(id, username, password, active) values
   (1, '1', '$2a$08$0Q1yFEUVQaYfq/NBTJQgqu8fc4itdiR2zqqGyeS/9zdyLTs3YTCoS', true),
   (2, 'mike', '$2a$08$0Q1yFEUVQaYfq/NBTJQgqu8fc4itdiR2zqqGyeS/9zdyLTs3YTCoS', true);

insert into user_role(user_id, roles) values
     (1, 'ADMIN'), (1, 'USER'),
     (2, 'USER');