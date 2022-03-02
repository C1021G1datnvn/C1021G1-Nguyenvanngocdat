use quanli_sinhvien;
select Address, COUNT(Student_Id) as 'Số lượng học viên'
from student
group by Address;

select student.Student_Id,Student.Student_Name, AVG(Mark)
FROM Student join Mark  on Student.Student_Id = mark.Student_Id
GROUP BY student.Student_Id, Student.Student_Name;

SELECT Student.Student_Id,Student.Student_Name, AVG(Mark)
FROM Student join Mark on Student.Student_Id = Mark.Student_Id
GROUP BY Student.Student_Id, Student.Student_Name;

SELECT Student.Student_Id,Student.Student_Name, AVG(Mark)
FROM Student join Mark  on Student.Student_Id = Mark.Student_Id
GROUP BY Student.Student_Id, Student.Student_Name
HAVING AVG(Mark) > 15;

SELECT Student.Student_Id, Student.Student_Name, AVG(Mark)
FROM Student join Mark on Student.Student_Id = Mark.Student_Id
GROUP BY Student.Student_Id, Student.Student_Name;

SELECT Student.Student_Id, Student.Student_Name, AVG(Mark)
FROM Student join Mark on Student.Student_Id = Mark.Student_Id
GROUP BY Student.Student_Id, Student.Student_Name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);
