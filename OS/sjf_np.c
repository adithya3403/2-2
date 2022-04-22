/**
 * Shortest job first
 * non - preemprive
 */

#include <stdio.h>
int main() {
    int bt[20], p[20], wt[20], tat[20], n, total = 0, pos, temp;
    float avg_wt, avg_tat;
    printf("Enter number of process:");
    scanf("%d", &n);
    printf("\nEnter Burst Time:\n");
    for (int i = 0; i < n; i++) {
        printf("p%d:", i + 1);
        scanf("%d", &bt[i]);
        p[i] = i + 1;
    }
    for (int i = 0; i < n; i++) {
        pos = i;
        for (j = i + 1; j < n; j++) {
            if (bt[j] < bt[pos])
                pos = j;
        }
        temp = bt[i];
        bt[i] = bt[pos];
        bt[pos] = temp;
        temp = p[i];
        p[i] = p[pos];
        p[pos] = temp;
    }
    wt[0] = 0;
    for (int i = 1; i < n; i++) {
        wt[i] = 0;
        for (int j = 0; j < i; j++)
            wt[i] += bt[j];
        total += wt[i];
    }
    avg_wt = (float)total / n;
    total = 0;
    printf("\nProcess\t    Burst Time    \tWaiting Time\tTurnaround Time");
    for (int i = 0; i < n; i++) {
        tat[i] = bt[i] + wt[i];
        total += tat[i];
        printf("\n%d\t\t  %d\t\t    %d\t\t\t%d", p[i], bt[i], wt[i], tat[i]);
    }
    avg_tat = (float)total / n;
    printf("\n\nAverage Waiting Time=%f", avg_wt);
    printf("\nAverage Turnaround Time=%f\n", avg_tat);
}

/*
Sample Output :

Enter number of process:5

Enter Burst Time:
p1:4
p2:3
p3:7
p4:1
p5:2

Process     Burst Time          Waiting Time    Turnaround Time
4                 1                 0                   1
5                 2                 1                   3
2                 3                 3                   6
1                 4                 6                   10
3                 7                 10                  17

Average Waiting Time=4.000000
Average Turnaround Time=7.400000

*/