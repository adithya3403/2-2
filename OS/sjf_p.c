#include <stdio.h>
struct Process {
    int pid;
    int bt; 
    int art;
} proc[100];
void findWaitingTime(Process proc[], int n, int wt[]) {
    int rt[n];
    for (int i = 0; i < n; i++) {
        rt[i] = proc[i].bt;
    }
    int complete = 0, t = 0, minm = INT_MAX;
    int shortest = 0, finish_time;
    bool check = false;
    while (complete != n) {
        for (int j = 0; j < n; j++) {
            if ((proc[j].art <= t) && (rt[j] < minm) && rt[j] > 0) {
                minm = rt[j];
                shortest = j;
                check = true;
            }
        }
        if (check == false) {
            t++;
            continue;
        }
        rt[shortest]--;
        minm = rt[shortest];
        if (minm == 0) {
            minm = INT_MAX;
        }
        if (rt[shortest] == 0) {
            complete++;
            check = false;
            finish_time = t + 1;
            wt[shortest] = finish_time - proc[shortest].bt - proc[shortest].art;
            if (wt[shortest] < 0) {
                wt[shortest] = 0;
            }
        }
        t++;
    }
}
void findTurnAroundTime(Process proc[], int n, int wt[], int tat[]) {
    for (int i = 0; i < n; i++) {
        tat[i] = proc[i].bt + wt[i];
    }
}
void findavgTime(Process proc[], int n) {
    int wt[n], tat[n], total_wt = 0, total_tat = 0;
    findWaitingTime(proc, n, wt);
    findTurnAroundTime(proc, n, wt, tat);
    printf("%s\t\t%s\t\t%s\t\t%s\n", "Process", "Burst time", "Waiting time", "Turn around time");
    for (int i = 0; i < n; i++) {
        total_wt = total_wt + wt[i];
        total_tat = total_tat + tat[i];
        printf("%d\t\t%d\t\t%d\t\t%d\n", proc[i].pid, proc[i].bt, wt[i], tat[i]);
    }
    printf("\nAverage waiting time = %f\n", (float)total_wt / (float)n);
    printf("\nAverage turn around time = %f\n", (float)total_tat / (float)n);
}
int main() {
    int n;
    printf("Enter number of processes:\n");
    scanf("%d", &n);
    printf("Enter details of processes:\n");
    for (int i = 0; i < n; i++) {
        printf("Enter pid, arrival time and burst time of process %d: ", i + 1);
        scanf("%d%d%d", &proc[i].pid, &proc[i].art, &proc[i].bt);
    }
    findavgTime(proc, n);
}

/*
Processes  Burst time  Waiting time  Turn around time
1               6           3               9
2               8           16              24
3               7           8               15
4               3           0               3
Average waiting time = 6.75
Average turn around time = 12.75
*/