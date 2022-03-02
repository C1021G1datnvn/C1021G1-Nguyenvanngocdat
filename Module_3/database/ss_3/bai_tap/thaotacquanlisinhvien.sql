use quanli_sinhvien;
select * from student where  student.student_name like "h%";

select * from class where month(start_date) = 12;

select * from `subject` where credit between 3 and 5;

SET SQL_SAFE_UPDATES=0; 
update student set class_id = 2 where student_name = "Hung";
SET SQL_SAFE_UPDATES=1;
select * from student;

select student.student_name, `subject`.sub_name, mark.mark 
from student 
inner join mark 
on student.student_id = mark.student_id 
inner join `subject` 
on mark.sub_id = `subject`.sub_id
order by mark desc, student.student_name asc;



