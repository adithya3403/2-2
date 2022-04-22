/**
 * Shortest job first
 * preemprive
 */

#include <stdio.h>
int main() {
    int at[10], bt[10], temp[10];
    int smallest, count = 0, time, limit;
    double wt = 0, tat = 0, end;
    printf("\nEnter the Total Number of Processes:\t");
    scanf("%d", &limit);
    printf("\nEnter Details of %d Processes\n", limit);
    for (int i = 0; i < limit; i++) {
        printf("\nEnter Arrival Time:\t");
        scanf("%d", &at[i]);
        printf("Enter Burst Time:\t");
        scanf("%d", &bt[i]);
        temp[i] = bt[i];
    }
    bt[9] = 9999;
    for (time = 0; count != limit; time++) {
        smallest = 9;
        for (int i = 0; i < limit; i++) {
            if (at[i] <= time && bt[i] < bt[smallest] && bt[i] > 0) {
                smallest = i;
            }
        }
        bt[smallest]--;
        if (bt[smallest] == 0) {
            count++;
            end = time + 1;
            wt += end - at[smallest] - temp[smallest];
            tat += end - at[smallest];
        }
    }
    float awt = wt / limit;
    float atat = tat / limit;
    printf("\n\nAverage Waiting Time:\t%lf\n", awt);
    printf("Average Turnaround Time:\t%lf\n", atat);
}

/*
Sample Output: 

Enter the Total Number of Processes:    4

Enter Details of 4 Processes

Enter Arrival Time:     1
Enter Burst Time:       4

Enter Arrival Time:     2
Enter Burst Time:       4

Enter Arrival Time:     3
Enter Burst Time:       5

Enter Arrival Time:     4
Enter Burst Time:       8


Average Waiting Time:   4.750000
Average Turnaround Time:       10.000000
*/