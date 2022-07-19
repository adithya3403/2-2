// LFU Page Replacement Alogirthm in C

#include <stdio.h>
int main() {
    int f, n, hit = 0;
    int frame[10], arr[25], time[25];
    int page, flag, k, min, temp;
    printf("Enter Number of Pages:\t");
    scanf("%d", &n);
    printf("Enter Number of Frames:\t");
    scanf("%d", &f);
    int pages[n];
    for (int i = 0; i < f; i++) frame[i] = -1;
    for (int i = 0; i < 25; i++) arr[i] = 0;
    printf("Enter Reference String : ");
    for (int i = 0; i < n; i++) scanf("%d", &pages[i]);
    printf("\n");
    for (int i = 0; i < n; i++) {
        arr[pages[i]]++;
        time[pages[i]] = i;
        flag = 1;
        k = frame[0];
        for (int j = 0; j < f; j++) {
            if (frame[j] == -1 || frame[j] == pages[i]) {
                if (frame[j] != -1) hit++;
                flag = 0;
                frame[j] = pages[i];
                break;
            }
            if (arr[k] > arr[frame[j]]) k = frame[j];
        }
        if (flag) {
            min = 25;
            for (int j = 0; j < f; j++) {
                if (arr[frame[j]] == arr[k] && time[frame[j]] < min) {
                    temp = j;
                    min = time[frame[j]];
                }
            }
            arr[frame[temp]] = 0;
            frame[temp] = pages[i];
        }
        for (int j = 0; j < f; j++) printf("%d\t", frame[j]);
        printf("\n");
    }
    printf("\nPage Faults : %d\n", n - hit);
}

/*
Enter Number of Pages:  20
Enter Number of Frames: 3
Enter Reference String : 1 2 3 4 2 1 5 6 2 1 2 3 7 6 3 2 1 2 3 6

1       -1      -1
1       2       -1
1       2       3
4       2       3
4       2       3
4       2       1
5       2       1
5       2       6
5       2       6
1       2       6
1       2       6
1       2       3
7       2       3
7       2       6
3       2       6
3       2       6
3       2       1
3       2       1
3       2       1
3       2       6

Page Faults : 14
*/