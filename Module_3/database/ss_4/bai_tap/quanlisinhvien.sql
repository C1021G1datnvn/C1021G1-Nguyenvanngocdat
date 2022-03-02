use quanli_sinhvien;
select * from `subject` 
order by credit desc
limit 1;

select `subject`.* from `subject`
inner join mark 
on `subject`.sub_id = mark.sub_id
order by mark desc
limit 1;

select student.*, avg(mark) from student 
inner join mark 
on student.student_id = mark.student_id
group by student.student_id
order by mark desc;