#include<stdio.h>
int main(){
	int i=1`,n,co=0,ce=0;
	while(i<=10)
	{
		printf("enter the number of n:");
		scanf("%d",&n);
		if(n%2==0)
		{
			ce=ce+1;
		}
		else{
			co=co+1;
		}
		printf("count of even number is %d:",ce);
		printf("count of odd number is %d:",co);
		i++;
		printf("\n");
		
	}
}
