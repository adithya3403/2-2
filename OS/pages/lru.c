// LRU Page Replacement Algorithm in C

#include <stdio.h>
int findLRU(int time[], int n) {
    int i, min = time[0], p = 0;
    for (i = 1; i < n; ++i) {
        if (time[i] < min) {
            min = time[i];
            p = i;
        }
    }
    return p;
}
int main() {
    int f, n, frames[10], pages[30], counter = 0, time[10], f1, f2, p, faults = 0;
    printf("Enter number of frames: ");
    scanf("%d", &f);
    printf("Enter number of pages: ");
    scanf("%d", &n);
    printf("Enter reference string: ");
    for (int i = 0; i < n; ++i) scanf("%d", &pages[i]);
    for (int i = 0; i < f; ++i) frames[i] = -1;
    for (int i = 0; i < n; ++i) {
        f1 = f2 = 0;
        for (int j = 0; j < f; ++j) {
            if (frames[j] == pages[i]) {
                counter++;
                time[j] = counter;
                f1 = f2 = 1;
                break;
            }
        }
        if (f1 == 0) {
            for (int j = 0; j < f; ++j) {
                if (frames[j] == -1) {
                    counter++;
                    faults++;
                    frames[j] = pages[i];
                    time[j] = counter;
                    f2 = 1;
                    break;
                }
            }
        }
        if (f2 == 0) {
            p = findLRU(time, f);
            counter++;
            faults++;
            frames[p] = pages[i];
            time[p] = counter;
        }
        printf("\n");
        for (int j = 0; j < f; ++j) printf("%d\t", frames[j]);
    }
    printf("\nTotal Page Faults = %d\n", faults);
}

/*
Enter number of frames: 3
Enter number of pages: 12
Enter reference string: 1 2 3 4 1 2 5 1 2 3 4 5

1       -1      -1
1       2       -1
1       2       3
4       2       3
4       1       3
4       1       2
5       1       2
5       1       2
5       1       2
3       1       2
3       4       2
3       4       5
Total Page Faults = 10
*/