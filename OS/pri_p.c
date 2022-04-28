/**
 * Priority Scheduling
 * Preemptive
 */

#include <stdio.h>
struct process {
    char process_name;
    int at, bt, ct, wt, tat, pr;
    int status;
} p[10];
int limit;
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
void at_Sorting() {
    struct process temp;
    int i, j;
    for (int i = 0; i < limit - 1; i++) {
        for (int j = i + 1; j < limit; j++) {
            if (p[i].at > p[j].at) {
                swap(&p[i].at, &p[j].at);
            }
        }
    }
}
void main() {
    int time = 0, bt = 0, l;
    char c;
    float wt = 0, tat = 0, awt, atat;
    printf("\nEnter Total Number of Processes:\t");
    scanf("%d", &limit);
    for (int i = 0, c = 'A'; i < limit; i++, c++) {
        p[i].process_name = c;
        printf("\nEnter Details For Process[%C]:\n", p[i].process_name);
        printf("Enter Arrival Time:\t");
        scanf("%d", &p[i].at);
        printf("Enter Burst Time:\t");
        scanf("%d", &p[i].bt);
        printf("Enter priority:\t\t");
        scanf("%d", &p[i].pr);
        p[i].status = 0;
        bt = bt + p[i].bt;
    }
    at_Sorting();
    p[9].pr = -9999;
    printf("\nProcess Name\tArrival Time\tBurst Time\tPriority\tWaiting Time");
    for (int time = p[0].at; time < bt;) {
        l = 9;
        for (int i = 0; i < limit; i++) {
            if (p[i].at <= time && p[i].status != 1 && p[i].pr > p[l].pr) {
                l = i;
            }
        }
        time += p[l].bt;
        p[l].ct = time;
        p[l].wt = p[l].ct - p[l].at - p[l].bt;
        p[l].tat = p[l].ct - p[l].at;
        p[l].status = 1;
        wt = wt + p[l].wt;
        tat = tat + p[l].tat;
        printf("\n%c\t\t%d\t\t%d\t\t%d\t\t%d", p[l].process_name, p[l].at, p[l].bt, p[l].pr, p[l].wt);
    }
    awt = wt / limit;
    atat = tat / limit;
    printf("\n\nAverage waiting time:\t%f\n", awt);
    printf("Average Turnaround Time:\t%f\n", atat);
}

/*
Sample Output :
Enter Total Number of Processes:        3

Enter Details For Process[A]:
Enter Arrival Time:     1
Enter Burst Time:       23
Enter priority:         2

Enter Details For Process[B]:
Enter Arrival Time:     2
Enter Burst Time:       54
Enter priority:         1

Enter Details For Process[C]:
Enter Arrival Time:     3
Enter Burst Time:       12
Enter priority:         3

Process Name    Arrival Time    Burst Time      Priority        Waiting Time
A               1               23              2               0
C               3               12              3               21
B               2               54              1               34

Average waiting time:   18.333334
Average Turnaround Time:        48.000000
*/