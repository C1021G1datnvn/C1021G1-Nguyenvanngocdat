use quanli_sinhvien;
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
--
insert into student(student_name, address, phone, status, class_id) values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student(student_name, address, phone, status, class_id) values ('Hoa', 'Hai phong',null, 1, 1);
insert into student(student_name, address, phone, status, class_id) values ('Manh', 'HCM', '0123123123', 0, 2);
--
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark (Sub_Id, Student_Id, Mark, Exam_Times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);