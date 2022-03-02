#include<stdio.h>

int main() {
	float t, l, h;
	printf("Nhap diem toan:");
	scanf("%f", &t);
	printf("Nhap dien li:");
	scanf("%f", &l);
	printf("Nhap diem hoa:");
	scanf("%f", &h);
	float avg;
	avg = (t + l + h)/ 3;
	printf("Diem trung binh 3 mon la:%f", avg);
}
