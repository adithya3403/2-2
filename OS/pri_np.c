/**
 * Priority Scheduling
 * Non Preemptive
 */

#include <stdio.h>
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
int main() {
    int bt[20], process[20], wt[20], tat[20], pr[20];
    int limit, sum = 0, p, temp;
    float awt, atat;
    printf("Enter Total Number of Processes:\t");
    scanf("%d", &limit);
    printf("\nEnter Burst Time and pr For %d Processes\n", limit);
    for (int i = 0; i < limit; i++) {
        printf("\nProcess[%d]\n", i + 1);
        printf("Process Burst Time:\t");
        scanf("%d", &bt[i]);
        printf("Process pr:\t");
        scanf("%d", &pr[i]);
        process[i] = i + 1;
    }
    for (int i = 0; i < limit; i++) {
        p = i;
        for (int j = i + 1; j < limit; j++) {
            if (pr[j] < pr[p]) {
                p = j;
            }
        }
        swap(&pr[i], &pr[p]);
        swap(&bt[i], &bt[p]);
        swap(&process[i], &process[p]);
    }
    wt[0] = 0;
    for (int i = 1; i < limit; i++) {
        wt[i] = 0;
        for (int j = 0; j < i; j++) {
            wt[i] = wt[i] + bt[j];
        }
        sum += wt[i];
    }
    awt = sum / limit;
    sum = 0;
    printf("\nProcess ID\t\tBurst Time\t Waiting Time\t Turn around Time\n");
    for (int i = 0; i < limit; i++) {
        tat[i] = bt[i] + wt[i];
        sum = sum + tat[i];
        printf("Process[%d]\t\t%d\t\t %d\t\t %d\n", process[i], bt[i], wt[i], tat[i]);
    }
    atat = sum / limit;
    printf("\nAverage Waiting Time:\t%f", awt);
    printf("\nAverage Turn around Time:\t%f\n", atat);
}

/*
Sample Output:

Enter Total Number of Processes:        3

Enter Burst Time and pr For 3 Processes

Process[1]
Process Burst Time:     15
Process pr:     3

Process[2]
Process Burst Time:     10
Process pr:     2

Process[3]
Process Burst Time:     90
Process pr:     1

Process ID              Burst Time       Waiting Time    Turn around Time
Process[3]              90               0               90
Process[2]              10               90              100
Process[1]              15               100             115

Average Waiting Time:   63.000000
Average Turn around Time:       101.000000
*/