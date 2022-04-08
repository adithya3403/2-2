#include <bits/stdc++.h>
using namespace std;
int main() {
    int n, i, j, k, temp, flag = 0;
    float wt[30], tat[30], bt[30], avwt = 0.0, avtat = 0.0;
    cout << "Enter the number of processes: ";
    cin >> n;
    cout << "Enter the burst time of processes: ";
    for (i = 0; i < n; i++)
        cin >> bt[i];
    for (i = 0; i < n; i++) {
        wt[i] = 0;
        for (j = 0; j < i; j++)
            wt[i] = wt[i] + bt[j];
    }
    cout << "Process\t\tBurst Time\tWaiting Time\tTurnaround Time\n";
    for (i = 0; i < n; i++) {
        tat[i] = bt[i] + wt[i];
        avwt = avwt + wt[i];
        avtat = avtat + tat[i];
        cout << "Process " << i + 1 << "\t\t" << bt[i] << "\t\t" << wt[i] << "\t\t" << tat[i] << endl;
    }
    avwt = avwt / n;
    avtat = avtat / n;
    cout << "\nAverage Waiting Time = " << avwt;
    cout << "\nAverage Turnaround Time = " << avtat;
    return 0;
}