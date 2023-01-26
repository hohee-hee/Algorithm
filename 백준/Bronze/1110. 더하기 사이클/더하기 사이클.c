#include <stdio.h>

int main()
{
	int num;
	scanf("%d", &num);
	int temp = num;

	int cnt = 0;

	do {
		
		if (temp < 10)
			temp = (temp%10)*10+(temp % 10);
		else if(temp>=10)
			temp = ((temp%10)*10)+(((temp / 10) + (temp % 10))%10);
		
		cnt++;
		
	} while (temp != num);

	printf("%d", cnt);

	return 0;
}