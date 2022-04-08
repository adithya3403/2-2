/**
 * Shortest Job First
 * Non-Preemptive
 */

#include <stdio.h>
int mat[10][6];

void arrangeArrival(int num, int mat[][6]) {
    for (int i = 0; i < num; i++) {
        for (int j = 0; j < num - i - 1; j++) {
            if (mat[j][1] > mat[j + 1][1]) {
                for (int k = 0; k < 5; k++) {
                    int temp = mat[j][k];
                    mat[j][k] = mat[j + 1][k];
                    mat[j + 1][k] = temp;
                }
            }
        }
    }
}

void completionTime(int num, int mat[][6]) {
    int temp, val;
    mat[0][3] = mat[0][1] + mat[0][2];
    mat[0][5] = mat[0][3] - mat[0][1];
    mat[0][4] = mat[0][5] - mat[0][2];
    for (int i = 1; i < num; i++) {
        temp = mat[i - 1][3];
        int low = mat[i][2];
        for (int j = i; j < num; j++) {
            if (temp >= mat[j][1] && low >= mat[j][2]) {
                low = mat[j][2];
                val = j;
            }
        }
        mat[val][3] = temp + mat[val][2];
        mat[val][5] = mat[val][3] - mat[val][1];
        mat[val][4] = mat[val][5] - mat[val][2];
        for (int k = 0; k < 6; k++) {
            int temp = mat[val][k];
            mat[val][k] = mat[i][k];
            mat[i][k] = temp;
        }
    }
}

int main() {
    int num, temp;
    printf("Enter number of processes : ");
    scanf("%d", &num);
    for (int i = 0; i < num; i++) {
        printf("Process %d : ", i + 1);
        printf("Enter Pid, AT, BT : ");
        scanf("%d %d %d", &mat[i][0], &mat[i][1], &mat[i][2]);
    }
    arrangeArrival(num, mat);
    completionTime(num, mat);
    printf("Result : \n");
    printf("Pid\tAT\tBT\tWT\tTAT\n");
    for (int i = 0; i < num; i++) {
        printf("%d\t%d\t%d\t%d\t%d\n", mat[i][0], mat[i][1], mat[i][2], mat[i][4], mat[i][5]);
    }
    return 0;
}

/*

SAMPLE INPUT AND OUTPUT : 

Enter number of processes : 4
Process 1 : Enter Pid, AT, BT : 1 2 3
Process 2 : Enter Pid, AT, BT : 2 0 4
Process 3 : Enter Pid, AT, BT : 3 4 2
Process 4 : Enter Pid, AT, BT : 4 5 4
Result : 
Pid     AT      BT      WT      TAT
2       0       4       0       4
3       4       2       0       2
1       2       3       4       7
4       5       4       4       8

*/