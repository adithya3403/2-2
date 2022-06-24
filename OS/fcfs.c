// FCFS

#include <stdio.h>
int main() {
	int n, t, num, b;
	printf("Enter number of processes : ");
	scanf("%d", &n);
	int arrid[n];
	int arrat[n];
	int arrb[n];
	int ft[n], tat[n], wt[n];
	printf("Enter ids, arrival times and burst times : \n");
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &arrid[i], &arrat[i], &arrb[i]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arrat[i] < arrat[j]) {
				t = arrat[i];
				arrat[i] = arrat[j];
				arrat[j] = t;
				num = arrid[i];
				arrid[i] = arrid[j];
				arrid[j] = num;
				b = arrb[i];
				arrb[i] = arrb[j];
				arrb[j] = b;
			}
		}
	}
	ft[0] = arrat[0] + arrb[0];
	for (int i = 1; i < n; i++) {
		ft[i] = ft[i - 1] + arrb[i];
	}
	for (int i = 0; i < n; i++) {
		tat[i] = ft[i] - arrat[i];
		wt[i] = tat[i] - arrb[i];
	}
	int avgwt = 0;
	int avgtat = 0;
	printf("id\t AT\t BT\t FT\t TAT\t WT\n");
	for (int i = 0; i < n; i++) {
		printf("%d\t %d\t %d\t %d\t %d\t %d\n", arrid[i], arrat[i], arrb[i], ft[i],
		tat[i], wt[i]);
		avgtat = avgtat + tat[i];
		avgwt = avgwt + wt[i];
	}
	printf("avg TAT : %d\n", avgtat / n);
	printf("avg WT : %d\n", avgwt / n);
}