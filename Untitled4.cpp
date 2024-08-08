#include<stdio.h>
int main(){
	int a, b, c, d ,e, per;
	printf("enter 5 subject mark:");
	scanf("%d""%d""%d""%d""%d",&a,&b,&c,&d,&e);
	per=(a+b+c+d+e)*100/500;
	if(per<35){
		printf("fail");
	}
	else if(per>=35 && per<45){
		printf("pass class");
	}
		else if(per>=45 && per<60){
		printf("second class");
	}
		else if(per>=60 && per<70){
		printf("first class");
	}
		else if(per>=70){
		printf("destinction class");
	}
	
}
