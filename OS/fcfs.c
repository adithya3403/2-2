/**
 * First come First Serve
 * FCFS
*/

#include <stdio.h>

void findWT(int processes[], int n, int bt[], int wt[]) {
    wt[0] = 0;
    for (int i = 1; i < n; i++)
        wt[i] = bt[i - 1] + wt[i - 1];
}

void findTAT(int processes[], int n, int bt[], int wt[], int tat[]) {
    for (int i = 0; i < n; i++)
        tat[i] = bt[i] + wt[i];
}

void findAT(int processes[], int n, int bt[]) {
    int wt[n], tat[n], total_wt = 0, total_tat = 0;
    findWT(processes, n, bt, wt);
    findTAT(processes, n, bt, wt, tat);
    printf("Pid\tBT\tWT\tTAT\n");
    for (int i = 0; i < n; i++) {
        total_wt = total_wt + wt[i];
        total_tat = total_tat + tat[i];
        printf("%d\t", (i + 1));
        printf("%d\t", bt[i]);
        printf("%d\t", wt[i]);
        printf("%d\t\n", tat[i]);
    }
    float s = (float)total_wt / (float)n;
    float t = (float)total_tat / (float)n;
    printf("Average waiting time = %0.2f", s);
    printf("\n");
    printf("Average turn around time = %0.2f", t);
}

int main() {
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);
    int processes[n];
    for (int i = 0; i < n; i++)
        processes[i] = i + 1;
    int burst_time[n];
    printf("Enter Burst time for each process: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &burst_time[i]);
    findAT(processes, n, burst_time);
    return 0;
}


/*

SAMPLE INPUT AND OUTPUT : 

Enter number of processes: 3
Enter Burst time for each process: 10 5 8
Pid     BT      WT      TAT
1       10      0       10
2       5       10      15
3       8       15      23
Average waiting time = 8.33
Average turn around time = 16.00

*/