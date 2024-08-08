#include<stdio.h>
int main(){
	char n;
	printf("enter the charcter:");
	scanf("%c",&n);
	if(n=='a'||n=='e'||n=='i'||n=='o'||n=='u'){
		printf("the given number is vowel");
	}
	else{
		printf("the given number is consonant");
	}
}
