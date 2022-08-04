// FCFS
#include <stdio.h>
void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
int main() {
    int n, t, num, b;
    printf("Enter number of processes : ");
    scanf("%d", &n);
    int arrid[n], arrat[n], arrb[n], ft[n], tat[n], wt[n];
    printf("Enter ids, arrival times and burst times : \n");
    for (int i = 0; i < n; i++) scanf("%d %d %d", &arrid[i], &arrat[i], &arrb[i]);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (arrat[i] < arrat[j]) {
                swap(arrat, i, j);
                swap(arrid, i, j);
                swap(arrb, i, j);
            }
        }
    }
    ft[0] = arrat[0] + arrb[0];
    for (int i = 1; i < n; i++) ft[i] = ft[i - 1] + arrb[i];
    for (int i = 0; i < n; i++) {
        tat[i] = ft[i] - arrat[i];
        wt[i] = tat[i] - arrb[i];
    }
    int avgwt = 0, avgtat = 0;
    printf("id\t AT\t BT\t FT\t TAT\t WT\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t %d\t %d\t %d\t %d\t %d\n", arrid[i], arrat[i], arrb[i], ft[i], tat[i], wt[i]);
        avgtat += tat[i];
        avgwt += wt[i];
    }
    printf("avg TAT : %d\n", avgtat / n);
    printf("avg WT : %d\n", avgwt / n);
}
// Enter number of processes : 5
// Enter ids, arrival times and burst times : 
// 0 0 80
// 1 0 20 
// 2 0 10
// 3 0 20
// 4 0 50
// id       AT      BT      FT      TAT     WT   
// 0        0       80      80      80      0    
// 1        0       20      100     100     80   
// 2        0       10      110     110     100  
// 3        0       20      130     130     110  
// 4        0       50      180     180     130  
// avg TAT : 120
// avg WT : 84
